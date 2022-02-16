package br.com.ronybank.tiposdeconta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.ronybank.cliente.Cliente;
import br.com.ronybank.exceptions.contaInativaException;


public abstract class Conta {
	private int agencia=0001;
	private String numeroDaConta;
	private BigDecimal saldo= new BigDecimal("0.00");
	private Cliente cliente;
	private boolean contaEstaAtiva;
	public List<String> extratoBancario = new ArrayList <>();
	
	public Conta(String nome, String cpf) {
		definirNumeroDaConta(cpf);
		this.cliente = new Cliente(nome,cpf);
		this.contaEstaAtiva=true;
	}
	
	public void sacar(BigDecimal valor) {
		verificaStatusDaConta();
		if (this.saldo.compareTo(valor)==-1 ) return;
		this.saldo=this.saldo.subtract(valor);
		this.extratoBancario.add(LocalDate.now()+(" R$ -"+valor.toString()));
	}
		
	public void depositar(BigDecimal valor) {
		verificaStatusDaConta();
		this.saldo = this.saldo.add(valor);
		this.extratoBancario.add(LocalDate.now()+(" R$ +"+valor.toString()));
	}
	
	public String transferir(BigDecimal valor, Conta destino) {
		verificaStatusDaConta();
		if (this.saldo.compareTo(valor)==-1) return "Saldo insuficiente!";		
		this.sacar(valor);
		destino.depositar(valor);
		return "Transferência feita com sucesso!";
	}
	
	public BigDecimal getSaldo() {
		verificaStatusDaConta();
		return saldo;
	}

	@Override
	public String toString() {
		return "Cliente: "+this.cliente.getNome()+". Agência: "+this.agencia+". Número da Conta: "+this.numeroDaConta;
	}
	
	private void definirNumeroDaConta(String cpf) {
		String retiraPontos=cpf.replace(".", "");
		this.numeroDaConta=retiraPontos.replace("-", "");
	}
	
	private void verificaStatusDaConta() {
		if (this.contaEstaAtiva) return;
		throw new contaInativaException("Você precisa reativar sua conta para fazer essa operação!");			
	}
	
	public void reabrirConta() {
		this.contaEstaAtiva=true;
	}

	public String fecharConta() {
		if (contaEstaAtiva==false) return "Sua conta já está fechada!";
		if (this.saldo.equals(new BigDecimal("0.00"))) { 
			this.contaEstaAtiva=false;
			return "Conta fechada com sucesso!";
		}
		return "Para fechar sua conta, ela deve estar com saldo de zero reais!";
	}	
	

}



