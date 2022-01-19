
public class Teste {

	public static void main(String[] args) {
		ContaCorrente c =new ContaCorrente(6565);
		c.setSaldo(500);
		c.depositar(255);
		c.sacar(200);
		System.out.println(c.getSaldo());
		
		ContaPoupanca cp =new ContaPoupanca(1313);
		System.out.println(cp.getSaldo());
		
		c.transferir(5202, cp);
		System.out.println("CP="+cp.getSaldo());
		System.out.println(c.getSaldo());
		
		
		c.extratoConta();
		cp.extratoConta();
	}

}
