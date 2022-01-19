
public class Main {

	public static void main(String[] args) {
	
// utilizando o construtor da conta para instanciar o objeto cliente junto
		
		ContaCorrente cc2 =new ContaCorrente(6565,"Rony","156.587.655-85");
		ContaPoupanca cp2 =new ContaPoupanca(1313,"Ka","000.565.655-36");
		
//		cc2.setSaldo(500); retirei, pois não fazia sentido setar um saldo direto, e sim deposita-lo
		cc2.depositar(255);
		cc2.sacar(200);
		cc2.transferir(52, cp2);
		
		System.out.println();
		cc2.extratoConta();
		System.out.println();
		cp2.extratoConta();
		
			
		
	}

}
