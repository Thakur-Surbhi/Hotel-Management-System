package Stream8;

public class Singleton1 {
	
	private static final Singleton1 instance = null;
	
	private Singleton1() {
	}
	
	public static Singleton1 getSingletonObj() {
		synchronized(Singleton1.class) {
			if(instance==null) {
				  new Singleton1();
			}
		}
		
		return instance;
		
	}
	public static void main(String[] args) {
		Singleton1 s1= new Singleton1();
		Singleton1 s2= new Singleton1();
		Singleton1 s3= new Singleton1();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}
