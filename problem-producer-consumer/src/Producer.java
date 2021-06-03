
public class Producer extends Thread {

	Product product;
	
	Producer (Product product) {
		this.product = product;
	}
	
	@Override
	public void run() {
		for (int i = application.VALOR_INICIAL_PRODUTO; i <= application.VALOR_LIMITE_PRODUTO; i++) {
			product.createProduct(this.getName(), i);
			
			try {
				sleep(application.DELAY);
			} catch (InterruptedException e) {}
		}
	}
}
