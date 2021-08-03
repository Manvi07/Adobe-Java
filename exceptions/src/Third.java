
public class Third {
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler((thread, ex) -> {
			System.out.println(thread.getName() + " --> Boom :-(" + ex.getMessage());
		});
		System.out.println("Hello!!");
			doTask();
		System.out.println("Bye!!!");
	}

	private static void doTask() {
		 int x = 10;
		 int y = 0;
		 int result = x / y;
		 System.out.println(result);
	}
}
