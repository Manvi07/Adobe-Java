import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Fifth {
	public static void main(String[] args) {
		System.out.println("Main Starts!!");
			try {
				doTask();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Main ends!!!");
	}

	private static void doTask() throws FileNotFoundException {
			FileInputStream fis = new FileInputStream("a.txt");
			// code to read from file
	}

}
