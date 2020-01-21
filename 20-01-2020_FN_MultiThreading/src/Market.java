public class Market {							//Market class that stores all the market info
	int apple=0;
	int orange=0;
	int grape=0;
	int watermelon=0;
	int max_size=10;
	int max_market_size=40;
	int current_market_size;
	
	void produce(String str) {
		if(str.equals("apple")) {
			this.apple++;
			this.current_market_size++;
		}
		else if(str.equals("orange")) {
			this.orange++;
			this.current_market_size++;
		}
		else if(str.equals("grape")) {
			this.grape++;
			this.current_market_size++;
		}
		else if(str.equals("watermelon")) {
			this.watermelon++;
			this.current_market_size++;
		}
	}

}
