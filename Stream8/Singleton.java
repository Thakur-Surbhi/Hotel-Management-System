package Stream8;

public class Singleton {
	
	private static  Singleton instance = null;
	
	private Singleton () {
		
	}
	public static synchronized Singleton getSingletonObj() {
		// synchronized(Singleton.class) {
		if(instance==null) 
			instance = new Singleton();
			return instance;
		}
		
	public static void main(String[] args) {
		Singleton a= Singleton.getSingletonObj();
		Singleton b =Singleton.getSingletonObj();
		Singleton c = Singleton.getSingletonObj();
		
		System.out.println("Singleton Object 1 :  "+getSingletonObj());
		System.out.println("Singleton Object 2 :  "+getSingletonObj());
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
