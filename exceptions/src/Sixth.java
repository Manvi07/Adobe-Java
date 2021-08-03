import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Sixth {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Main Starts!!");
				doTask();
		System.out.println("Main ends!!!");
	}

	private static void doTask() throws FileNotFoundException {
			FileInputStream fis = new FileInputStream("a.txt");
			// code to read from file
	}

}
