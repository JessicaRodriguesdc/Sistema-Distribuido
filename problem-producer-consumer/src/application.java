public class application {

	//Configuracoes
	public static final int VALOR_INICIAL_PRODUTO = 20;
	public static final int VALOR_LIMITE_PRODUTO = 30;
	public static final int DELAY = 100;
	public static final int QTD_THREAD = 3;
	
	public static void main(String[] args) {
		Product produto = new Product(VALOR_INICIAL_PRODUTO);
		Producer p = new Producer(produto);

		Consumer c0 = new Consumer(produto);
		Consumer c1 = new Consumer(produto);
		Consumer c2 = new Consumer(produto);
		
		p.start();
		
		c0.start();
		c1.start();
		c2.start();
	}
}
