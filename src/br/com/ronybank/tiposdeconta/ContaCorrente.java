package br.com.ronybank.tiposdeconta;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(int numero,String nome, String cpf) {
		super(numero,nome,cpf);
	}

	@Override
	public String toString() {
		return "Conta Corrente. "+super.toString();
	}

}
