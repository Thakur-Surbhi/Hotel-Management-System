package Client_Question;

public class Singleton {
	
	private static Singleton singleton ;
	
	private Singleton(){
		
	}
	
	public static synchronized Singleton getSingletonObj() {
		if(singleton==null) {
			return singleton = new Singleton();
		}
		
		return singleton;
	}

	public static void main(String[] args) {
		Singleton s1 = getSingletonObj();
		Singleton s2 = getSingletonObj();
		Singleton s3 = getSingletonObj();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}
