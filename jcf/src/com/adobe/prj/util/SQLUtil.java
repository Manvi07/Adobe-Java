package com.adobe.prj.util;

import java.lang.reflect.Method;

import com.adobe.prj.annotations.Column;
import com.adobe.prj.annotations.Table;

public class SQLUtil {
	// create table products (PRD_ID NUMERIC(12), 
	// PRD_NAME VARCHAR(100), AMOUNT NUMERIC(12,2), CATEGORY VARCHAR(100));
	// input Product.class
	public static String createStatement(Class<?> clazz) {
		StringBuilder builder = new StringBuilder();
		Table table = clazz.getAnnotation(Table.class);
		if(table != null) {
			builder.append("create table ");
			builder.append(table.name());
			builder.append(" (");
			Method[] methods = clazz.getDeclaredMethods();
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					Column col = m.getAnnotation(Column.class);
					if(col != null) {
						builder.append(col.name());
						builder.append(" ");
						builder.append(col.type());
						builder.append(", ");
					}
				}
			}
			builder.setCharAt(builder.lastIndexOf(","), ')');
		}
		return builder.toString();
	}
}
