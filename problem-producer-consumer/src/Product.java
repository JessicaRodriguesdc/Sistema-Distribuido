public class Product {
	private int product;
	private boolean usable;
	
	Product(int product) {
		this.product = product;
		usable = false;
	}
	
	public synchronized int useProduct(String idThread) {
		while(!this.usable) {
			try {
				this.wait();
			} catch (InterruptedException e) {}
		}
		
		System.out.println("Consumidor: \t" + idThread + "\tconsumiu: \t" + this.product);
		notifyAll();
		this.usable = false;
		return this.product;
	}
	
	public synchronized void createProduct(String idThread, int product) {
		while(this.usable) {
			try {
				this.wait();
			} catch (InterruptedException e) {}
		}
		
		this.usable = true;
		this.product = product;
		System.out.println("Produtor: \t" + idThread + " \tproduziu: \t" + product);
		notifyAll();
		
	}
}
