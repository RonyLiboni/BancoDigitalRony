
public abstract class Conta {
	private int agencia=3545;
	private int numero;
	private double saldo=0;
	private Cliente cliente;
	
	public Conta(int numero) {
		this.numero=numero;
	}
	
	public Conta(int numero, String nome, String cpf) {
		this.numero=numero;
		this.cliente = new Cliente(nome,cpf);
	}
	
	public void sacar(double valor) {
		if (this.saldo>valor) {
			this.saldo-=valor;	
		} else {
			System.out.println("Saldo insuficiente! Voc� tem "+this.saldo+" dispon�vel.");
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
			System.out.println("N�o h� saldo suficiente para esta transfer�ncia!!");
		}					
	}
	
	public void extratoConta() {
		System.out.println("Ol�, "+this.getCliente().getNome() +" o numero da sua conta � "+this.numero+" e sua agencia � "+this.agencia);
		System.out.println("Seu saldo atual � "+this.saldo);
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
