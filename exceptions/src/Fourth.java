import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Fourth {

	public static void main(String[] args) {
		System.out.println("Main Starts!!");
			doTask();
		System.out.println("Main ends!!!");
	}

	private static void doTask() {
		try {
			FileInputStream fis = new FileInputStream("a.txt");
			System.out.println("read file");
			// code to read from file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
