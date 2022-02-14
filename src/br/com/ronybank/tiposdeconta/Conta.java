package br.com.ronybank.tiposdeconta;

import java.math.BigDecimal;

import br.com.ronybank.cliente.Cliente;


public abstract class Conta {
	private int agencia=0001;
	private int numero;
	private BigDecimal saldo= new BigDecimal("0.00");
	private Cliente cliente;
	private boolean contaEstaAtiva;
	
	public Conta(int numero) {
		this.numero=numero;
	}
	
	public Conta(int numero, String nome, String cpf) {
		this.numero=numero;
		this.cliente = new Cliente(nome,cpf);
	}
	
	public void sacar(BigDecimal valor) {
		if (this.saldo.compareTo(valor)==-1 )  
			return;
		this.saldo=this.saldo.subtract(valor);
	}
		
	public void depositar(BigDecimal valor) {
		this.saldo = this.saldo.add(valor);
	}
	
	public String transferir(BigDecimal valor, Conta destino) {
		
		if (this.saldo.compareTo(valor)==-1) return "Saldo insuficiente!";	
				
		this.sacar(valor);
		destino.depositar(valor);	// validar destino jogar exceção?
		return "Transferência feita com sucesso!";
	}
	
	public void extratoConta() {
		System.out.println(this.getCliente().getNome()+", seu saldo atual é "+this.saldo);
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public String toString() {
		return "Agência: "+this.agencia+". Número da Conta: "+this.numero;
	}
	
}
