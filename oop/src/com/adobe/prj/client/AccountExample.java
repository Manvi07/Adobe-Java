package com.adobe.prj.client;

import com.adobe.prj.entity.Account;

public class AccountExample {

	public static void main(String[] args) {
		
		Account first = new Account(); // create object ==> constructor is called
		Account second = new Account(5000);
		
		first.deposit(5000); // send message ==> inside deposit( ) ==> "this" refers to "first"
 		second.deposit(2500); // send message ==> inside deposit( ) ==> "this" refers to "second"
 		
		System.out.println("First Account : ");
		System.out.println(first.getBalance()); // inside getBalance( ) ==> "this" refers to "first"
		
		System.out.println("Second Account : ");
		System.out.println(second.getBalance());
	
		
		System.out.println("Count :" + Account.getCount()); // 2
		
		
		Account a1 = new Account(5000);
		Account a2 = new Account(5000);
		
		
		if(a1 == a2) { // compare address of a1 with a2
			System.out.println("same objects");
		}
		
		if(a1.equals(a2)) {
			System.out.println("a1 and a2 are similar");
		}
	}

}
