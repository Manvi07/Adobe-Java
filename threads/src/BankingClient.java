
public class BankingClient {

	public static void main(String[] args) {
		Account acc = new Account(5000);
		TransactionThread t1 = new TransactionThread(acc, "Roger", TransactionType.CREDIT, 3000);
		TransactionThread t2 = new TransactionThread(acc, "\tAnitha", TransactionType.CREDIT, 2500);
		TransactionThread t3 = new TransactionThread(acc, "\t\tSmitha", TransactionType.DEBIT, 6000);
		
		t3.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		t1.start();
		t2.start();
		 // main, t1, t2 and t3 are ready state
		
		try {
			t1.join(5000);
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Final Balance: " + acc.getBalance());
	}

}
