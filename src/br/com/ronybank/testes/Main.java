package br.com.ronybank.testes;

import br.com.ronybank.tiposdeconta.ContaCorrente;
import br.com.ronybank.tiposdeconta.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
			
		ContaCorrente cc =new ContaCorrente(6565,"Rony","156.587.655-85");
		ContaPoupanca cp =new ContaPoupanca(1313,"Ka","000.565.655-36");
		

		cc.depositar(255);
		cc.sacar(200);
		cc.transferir(522, cp);
		
		System.out.println();
		cc.extratoConta();
		System.out.println();
		cp.extratoConta();
		
			
		
	}

}
