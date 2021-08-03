// StackOverflowError
public class First {
	
	public static void main(String[] args) {
		System.out.println("Hello!!");
			doTask();
		System.out.println("Bye!!!");
	}

	private static void doTask() {
		System.out.println("Task done!!!");
		doTask(); // recursive without exit condition
	}

}
