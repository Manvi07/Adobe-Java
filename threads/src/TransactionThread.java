
public class TransactionThread extends Thread {
	private Account acc;
	private String name;
	private TransactionType type;
	private double amt;
	 
	public TransactionThread(Account acc, String name, TransactionType type, double amt) {
		this.acc = acc;
		this.name = name;
		this.type = type;
		this.amt = amt;
	}

	@Override
	public void run() {
		if(type == TransactionType.CREDIT) {
			acc.deposit(name, amt);
		} else {
			acc.withdraw(name, amt);
		}
	}
}
