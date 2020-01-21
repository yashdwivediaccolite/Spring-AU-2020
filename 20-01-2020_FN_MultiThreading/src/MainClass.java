public class MainClass {
	public static void main(String []args) {
		Market obj=new Market();
		Thread c1=new Thread(new Consumer(obj));
		Thread c2=new Thread(new Consumer(obj));
		Thread c3=new Thread(new Consumer(obj));
		Thread c4=new Thread(new Consumer(obj));
		Thread f1=new Thread(new Farmer(obj));
		Thread f2=new Thread(new Farmer(obj));
		Thread f3=new Thread(new Farmer(obj));
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		f1.start();
		f2.start();
		f3.start();
	}
}
