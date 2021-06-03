
public class Consumer extends Thread {
	Product product;
	
	Consumer(Product product) {
		this.product = product;
	}
	
	@Override
	public void run() {
		int valor = application.VALOR_INICIAL_PRODUTO;
		
		for (int i = application.VALOR_INICIAL_PRODUTO; i <= application.VALOR_LIMITE_PRODUTO; i++) {
			valor = this.product.useProduct(this.getName());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
