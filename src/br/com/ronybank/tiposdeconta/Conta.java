package br.com.ronybank.tiposdeconta;

import br.com.ronybank.tiposdeusuarios.Cliente;

/**
 * Classe representa a moldura do minimo que uma conta deve ter
 * @author Ronald Liboni
 * @version 0.1
 *
 */

public abstract class Conta {
	private int agencia=0001;
	private int numero;
	private double saldo=0;
	private Cliente cliente;
	
	public Conta(int numero) {
		this.numero=numero;
	}
	
	/**
	 * Construtor faz conta e ja cria vincula ela a um cliente
	 * @param numero
	 * @param nome
	 * @param cpf
	 */
	public Conta(int numero, String nome, String cpf) {
		this.numero=numero;
		this.cliente = new Cliente(nome,cpf);
	}
	
	public void sacar(double valor) {
		if (this.saldo>valor) {
			this.saldo-=valor;	
		} else {
			System.out.println("Saldo insuficiente! Você tem "+this.saldo+" disponível.");
		}
	}
		
	public void depositar(double valor) {
		this.saldo+=valor;
	}
	
	public void transferir(double valor, Conta destino) {
		if (this.saldo>valor) {
			this.sacar(valor);
			destino.depositar(valor);
		} else {
			System.out.println("Não há saldo suficiente para esta transferência!!");
		}					
	}
	
	public void extratoConta() {
		System.out.println("Olá, "+this.getCliente().getNome() +" o numero da sua conta é "+this.numero+" e sua agencia é "+this.agencia);
		System.out.println("Seu saldo atual é "+this.saldo);
	}

	public double getSaldo() {
		return saldo;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
