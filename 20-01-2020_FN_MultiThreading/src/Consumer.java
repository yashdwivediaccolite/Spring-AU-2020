import java.util.Scanner;
import java.util.stream.Stream;
public class Consumer implements Runnable{
	Market market;
	Consumer(Market mer){
		this.market=mer;
	}

	public void run() {
		Scanner sc=new Scanner(System.in);
		int runs=2;
		synchronized(this.market) {
			while(true) {
				if(this.market.current_market_size==0) {						// Wait if market is empty
					try {
						this.market.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Stream<String> stream=Stream.of("Choose a fruit","1.Apple","2.Orange","3.Grape","4.Watermelon");   //Using Streams to print data
				stream.forEach(s->System.out.println(s));
				int choice=sc.nextInt();
				switch(choice) {												//Updating market parameters after consumer buys something
				case 1:
					if(this.market.apple<=0) {									//Wait if required fruits not there in market
						try {
							System.out.println("Consumer:"+Thread.currentThread().getName() +" please wait");
							this.market.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					this.market.apple-=1;
					this.market.current_market_size-=1;
					System.out.println(this.market.apple);
					System.out.println("Consumer:"+Thread.currentThread().getName() +" got Apple");
					break;
				case 2:
					if(this.market.orange<=0) {
						try {
							System.out.println("Consumer:"+Thread.currentThread().getName() +" please wait");
							this.market.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					this.market.orange-=1;
					this.market.current_market_size-=1;
					System.out.println("Consumer:"+Thread.currentThread().getName() +" got Orange");
					break;
				case 3:
					if(this.market.grape<=0) {
						try {
							System.out.println("Consumer:"+Thread.currentThread().getName() +" please wait");
							this.market.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					this.market.grape-=1;
					this.market.current_market_size-=1;
					System.out.println("Consumer:"+Thread.currentThread().getName() +" got grape");
					break;	
				case 4:
					if(this.market.watermelon<=0) {
						try {
							System.out.println("Consumer:"+Thread.currentThread().getName() +" please wait");
							this.market.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					this.market.watermelon -=1;
					this.market.current_market_size-=1;
					System.out.println("Consumer:"+Thread.currentThread().getName() +" got watermelon");
					break;	
				default: System.out.println("Choose a valid option");
				break;	
				}
				if(runs==1) {													// To make sure all Consumes get fair chance to buy
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
