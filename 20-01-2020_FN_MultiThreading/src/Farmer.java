
public class Farmer implements Runnable{
	
	Market market;
	Farmer(Market mr) {
		this.market=mr;
	}
	
	public void run() {
		synchronized(this.market) {
		int runs=2; 
		while(true) {
			if(this.market.current_market_size==this.market.max_market_size) {					// Wait if market is full
				try {
					this.market.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				if(this.market.apple<this.market.max_size) {									//Produce fruits
					this.market.produce("apple");
					System.out.println("Farmer "+Thread.currentThread().getName()+" has produced an apple");
				}
				if(this.market.orange<this.market.max_size) {
					this.market.produce("orange");
					System.out.println("Farmer "+Thread.currentThread().getName()+" has produced an orange");
				}
				if(this.market.watermelon<this.market.max_size) {
					this.market.produce("watermelon");
					System.out.println("Farmer "+Thread.currentThread().getName()+" has produced a watermelon");
				}
				if(this.market.grape<this.market.max_size) {
					this.market.produce("grape");
					System.out.println("Farmer "+Thread.currentThread().getName()+" has produced a grape");
				}
				if(runs==1) {											// TO make sure all farmers get fair market share
					try {
						this.market.wait();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					runs=3;
				}
				runs--;
				this.market.notifyAll();
			}
		}
	}

}
