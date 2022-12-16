package Singleton;

// Singleton Design pattern 1 nesneden sadece bir kere oluşmasını istediğimizde kullandığımız yapıdır.
public class Singleton {
	private static Singleton singleton;

	private Singleton() {
		System.out.println("Ben oluştum");
	}

	public static Singleton getSingleton() {
		//Sadece singletonun null olduğu durumda synchronized çalışacak. 
		if (singleton == null) {
			// Thread safe yapabilmek için synchronized metodunu kullanıyoruz.
			synchronized (Singleton.class) {
				if (singleton == null) {
					// Nesnemizin ihtiyaç duyulduğunda oluşturulması için metod çağrıldığında
					// oluşturuyorum.(Lazy Loading)
					singleton = new Singleton();
				}
			}

		}
		return singleton;
	}

}
