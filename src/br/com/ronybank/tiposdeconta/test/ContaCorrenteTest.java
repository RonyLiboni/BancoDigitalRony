package br.com.ronybank.tiposdeconta.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.ronybank.exceptions.contaInativaException;
import br.com.ronybank.tiposdeconta.ContaCorrente;

public class ContaCorrenteTest {
	private List<ContaCorrente> conta = new ArrayList<>();
	BigDecimal saldo0;
	BigDecimal saldo1;
	
		@BeforeEach
		private void inicializar() {
			this.conta.add(new ContaCorrente("Rony","156.587.655-85"));
			this.conta.add(new ContaCorrente("Ka","156.587.645-85"));
			this.conta.get(0).depositar(new BigDecimal("1555"));
		}
		
		private void getSaldos() {
			saldo0= this.conta.get(0).getSaldo();
			saldo1= this.conta.get(1).getSaldo();
		} 
				
		@Test
		public void SacarComSaldoMaiorQueOSuficiente() {
			this.conta.get(0).sacar(new BigDecimal ("555"));
			getSaldos();
			assertEquals(new BigDecimal("1000.00"), saldo0);
		}
		
		@Test
		public void SacarComSaldoIgualAoValorDoSaque(){
			this.conta.get(0).sacar(new BigDecimal ("1555"));
			getSaldos();
			assertEquals(new BigDecimal("00.00"), saldo0);
		}
		
		@Test
		public void SacarComSaldoInsuficiente() {
			this.conta.get(0).sacar(new BigDecimal ("15550"));
			getSaldos();
			assertEquals(new BigDecimal("1555.00"), saldo0); 
		}
			
		
		@Test
		public void transferirComSaldoMaiorQueOSuficiente() {
			this.conta.get(0).transferir(new BigDecimal ("555"), this.conta.get(1));
			getSaldos();
			assertEquals(new BigDecimal("1000.00"), saldo0);
			assertEquals(new BigDecimal("555.00"), saldo1);
		}
		
		@Test
		public void transferirComSaldoIgualAoValorDaTransferencia(){
			this.conta.get(0).transferir(new BigDecimal ("1555"), this.conta.get(1));
			getSaldos();
			assertEquals(new BigDecimal("00.00"), saldo0);
			assertEquals(new BigDecimal("1555.00"), saldo1);
		}
		
		@Test
		public void transferirComSaldoInsuficiente() {
			this.conta.get(0).transferir(new BigDecimal ("1666"), this.conta.get(1));
			getSaldos();
			assertEquals(new BigDecimal("1555.00"), saldo0);
			assertEquals(new BigDecimal("00.00"), saldo1);
		}
		
		@Test
		public void fecharContaSemSaldo() {
			assertEquals("Conta fechada com sucesso!", this.conta.get(1).fecharConta());
		}
		
		@Test
		public void fecharContaComSaldo() {
			assertEquals("Para fechar sua conta, ela deve estar com saldo de zero reais!", this.conta.get(0).fecharConta());
		}
		
		@Test
		public void fecharContaFechada() {
			this.conta.get(1).fecharConta();
			assertEquals("Sua conta já está fechada!", this.conta.get(1).fecharConta());
		}
		
		@Test
		public void sacarComContaFechadaLancaContaInativaException() {
			this.conta.get(1).fecharConta();
			assertThrows(contaInativaException.class,
					() -> this.conta.get(1).sacar(saldo0));
		}
		
		@Test
		public void depositarComContaFechadaLancaContaInativaException() {
			this.conta.get(1).fecharConta();
			assertThrows(contaInativaException.class,
					() -> this.conta.get(1).depositar(saldo0));
		}
		
		@Test
		public void transferirComContaFechadaLancaContaInativaException() {
			this.conta.get(1).fecharConta();
			assertThrows(contaInativaException.class,
					() -> this.conta.get(1).transferir(saldo0,this.conta.get(0)));
		}
		
		
		
}
