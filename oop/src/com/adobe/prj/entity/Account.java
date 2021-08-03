package com.adobe.prj.entity;
/**
 *  This entity  class represents banking account.
 *   
 * @author banup
 *
 */
public class Account {
	private double balance; // state of object ; instance variables 
	private static int count = 0;
	
	// default constructor
	public Account() {
		count++;
		this.balance += 0.0;
	}
	
	// parameterized constructor
	public Account(double amt) {
		count++;
		this.balance += amt;
	}
	
	// instance methods ==> object will be the context
	/**
	 * method to credit amount into banking account.
	 * 
	 * @param amt the amount to be credited
	 */
	public void deposit(double amt) { 
		this.balance += amt;
	}	

	public double getBalance() {
		return this.balance;
	}
	
	//class method
	public static int getCount() {
			return count;
	}

	// a1.equals(a2);
	// equals() ==> "a1" is "this" and "obj" is "a2"
	
 	@Override
	public boolean equals(Object obj) {
		Account acc = (Account) obj;
		return this.balance == acc.balance;
	}
	
}
