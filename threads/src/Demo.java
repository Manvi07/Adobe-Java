
public class Demo {

	public static void main(String[] args) {
		int data = doTask();
		System.out.println(data);
	}

	private static int doTask() {
		try {
			int x = 10;
			int y = 2;
			return x / y;
		} catch(ArithmeticException ex) {
			return 100;
		} finally {
			return 999;
		}
		
	}

}
