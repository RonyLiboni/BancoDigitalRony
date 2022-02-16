package br.com.ronybank.main;

import java.math.BigDecimal;

import br.com.ronybank.tiposdeconta.ContaCorrente;

public class Main {
	public static void main(String[] args) {
		ContaCorrente cc0 = new ContaCorrente("Rony","1.2.3.4");
		ContaCorrente cc1 = new ContaCorrente("Ka","1.28-48.4");
		
		cc0.depositar(new BigDecimal("1562"));
		cc0.depositar(new BigDecimal("88"));
		cc0.depositar(new BigDecimal("40.85"));
		cc0.sacar(new BigDecimal("600"));
		cc0.transferir(new BigDecimal("100"),cc1);
		cc0.transferir(new BigDecimal("100"),cc1);
		cc0.extratoBancario.forEach(ex->System.out.println(ex));
	
		
		
	}
}
