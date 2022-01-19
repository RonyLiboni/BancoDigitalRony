
public class ContaPoupanca extends Conta {

	
	public ContaPoupanca(int numero,String nome, String cpf) {
		super(numero,nome,cpf);
		this.depositar(50);
		System.out.println(this.getCliente().getNome()+", obrigado por abrir uma conta poupança conosco!");
		System.out.println("Você recebeu 50 reais como premiação!");
	}
	

	
}
