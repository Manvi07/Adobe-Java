package com.adobe.prj.client;

import com.adobe.prj.entity.Employee;
import com.adobe.prj.entity.Product;
import com.adobe.prj.util.SQLUtil;

public class SQLClient {

	public static void main(String[] args) {
		String SQL = SQLUtil.createStatement(Product.class);
		System.out.println(SQL);
		
		SQL = SQLUtil.createStatement(Employee.class);
		System.out.println(SQL);
	}

}
