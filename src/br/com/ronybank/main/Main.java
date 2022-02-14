package br.com.ronybank.main;

import java.math.BigDecimal;

import br.com.ronybank.cliente.Cliente;
import br.com.ronybank.tiposdeconta.ContaCorrente;

public class Main {

	public static void main(String[] args) {
			
		ContaCorrente cc =new ContaCorrente(6565,"Rony","156.587.655-85");
		ContaCorrente cp =new ContaCorrente(1313,"Ka","000.565.655-36");

		
		cc.depositar(new BigDecimal("5535"));
		cc.sacar(new BigDecimal("300"));
		cc.transferir(new BigDecimal("522"), cp);

		System.out.println();
		cc.extratoConta();
		System.out.println();
		cp.extratoConta();
		System.out.println(cc);
		
	
		
	}

}
