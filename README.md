# Java

Trainer: Banuprakash C

Full Stack Architect,

Co-founder Lucida Technologies Pvt Ltd.,

Corporate Trainer,

Email: banuprakashc@yahoo.co.in

https://www.linkedin.com/in/banu-prakash-50416019/


https://github.com/BanuPrakash/ADOBE_JAVA

===================================



Softwares Required:
1) Java 8+
	https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html

2) Eclipse for JEE  
	https://www.eclipse.org/downloads/packages/release/2020-03/m1/eclipse-ide-enterprise-java-developers

3) MySQL  [ Prefer on Docker]

Install Docker Desktop

Docker steps:

a) docker pull mysql

b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -t -i <container_name> /bin/bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit

========================================================

Day 1

OOP ==> Object Oriented Paradigm ==> real world

Tv, AC, Microwave, ...

Every object has a state and behaviour
TV: State can be ==> Volume, Channel, OTT

AC: State can be ==> Temperature, Fan Speed

BankingAccount: State is balance, accNo


Actions / Behaviour / Message are used to change the state of object

ON, OFF, INCREASE, DECREASE, CREDIT, DEBIT

===================================================

BluePrint / Template is required to create a Object

JavaScript uses function as blueprint

function Account(accNo, initalAmt) {
	...
}


C++ or Java: class as blueprint

class Account {

}

Oracle: Type

Type Account

End Type


=============================================
Create Object using blueprint:
new Account(); // Dynamic Memory Allocation

========================================================

SOLID Design Principle:

S ==> Single Responsiblity

O ==> Open Close Principle; Closed for Change, but open for extension
	
	void sort(elems) { // String
	}

	Employee, Order, Supplier, Customer, Product

L ==> Liskov Substitution Principle [ Generalization and Specialization]

I ==> Interface Segregation

D ==> Dependency Injection

=================================

Java: ==> Technology ==> Platform + APIs [ run time ==> rt.jar ] to execute Bytecode

source code ==> Compile ==> Bytecode

JDK [ Java Development Kit]
Source code will be in Java Programing language
javac ==> javac


Kotlin as programming language
Groovy as programming language

ByteCode is not self contained like ==> "exe" generated from C programming language

File.java ==> javac ==> File.class [ Bytecode]

=============================================

Logically group objects/ classes

1) Entity class / Model class / Domain class / Document class

	They represent business data ==> data which is long lived

	Uber ==> Customer, Vehicle, Trip, Payment, Driver ==> store [ RDBMS / MongoDB ]

	Java class to map to this data in store is entity / domain / model class

	https://www.tutorialspoint.com/sql/sql-rdbms-concepts.htm

2) DAO ==> Data Access Object ==> CRUD operations [ CREATE READ UPDATE DELETE]

	CustomerDao ==> INSERT, DELETE, UPDATE and SELET Customer from "customers" table
	VehicleDao 
	==> fine grained operations

3) Service ==> facade over DAO + Business logic
	==> Coarse grained

4) DTO ==> value objects ==> Data Transfer Object

5) Utility classes ==> Helpers ==> filter/ sort / Date coversion / Currency Coversion / i18N

6) UI classes ==> Web / Mobile / Standalone

7) Exception class ==> to represet any abnormal condition that arises during program exection

==============================

In Java we use packages to logically group these classes [ folders]

"com.adobe.prj"."classtype"

com.adobe.prj.entity
com.adobe.prj.dao
com.adobe.prj.service

========================================

Account.java

public class Account {
	private double balance; // state of object

	public void deposit(double amt) {
		this.balance += amt;
	}	

	public double getBalance() {
		return this.balance;
	}
}

javac Account.java ===> Account.class

Example.java

public class Example {
	public static void main(String[] args) {
		Account first = new Account();
		Account second = new Account();
		first.deposit(5000);
		second.deposit(2500);
		System.out.println(first.getBalance());
	}
}


javac Example.java ==> Example.class

java Example 


====

context.action(arguments)

tv.on();

ac.off();

tv.changeChannel(1234);

===

first.deposit(5000); ==> deposit(first, 5000); ==> implict first argument is "context/target object"


public void deposit(double amt) {
		this.balance += amt;
} 
gets compiled to:

public void deposit(Account this, double amt) {
		this.balance += amt;
}

second.deposit(2500);

deposit(second, 2500);

first.getBalance(); ==> getBalance(first);


public double getBalance() {
		return this.balance;
} 
gets compiled to

public double getBalance(Account this) {
		return this.balance;
}


https://github.com/BanuPrakash/ADOBE_JAVA

==================================================

"new" to create object
Stack and Heap area

"this" keyword ==> referes to the object which invoked the action / behaviour / message

====================

* constructors
==> they are special methods which has the same name as that class; no explict return type
==> they are invoked when object is created; generally initialization is done here
==> Compiler creates default constructor if we don't write any constructors
==> we an overload constructors

Carpenter ==> need a computer table
		==> computer table with 3' x 4' x 3.5'

============================

I need to track how many Account instance / object are created?

Every class in Java inherits from java.lang.Object class

===============================================
primitive values:
int x = 10;
int y = 10;
x == y; // ==> true

Object equality: == vs equals()

== compare address of objects
equals() should compare contents


Account a1 = new Account(5000);
Account a2 = new Account(5000);

a1 == a2; ==> false




Account acc = new Account(2323);

Account ref = acc;

================================================================

* Relationship between Objects:
1) Generalization and Specilization [ IS A ]
2) Realization
3) Association
4) Uses A

Java development tools:
1) Maven
2) static code analysis
	==> checkstyle [ Naming Conventions / code comments/ white spaces / line size / function size]
	==> PMD / FindBugs / SpotBugs [ Coding practices ]
		====> Empty block statements
			if(condition) {

			} else {
					code
			}
		==> unreachable code
		==> Copy and Paste code
	==> Sonar
3) Jenkins 
	==> CI /CD

4) Repository	[ GitHub / BitBucket]


Keys,  Tv

14" or 32" pocket

Mobile which HAS A Tata Sky App

Mobile IS A Tv

========================

In Java we use "extends" keyword for Speacilzation


public class Product { // implicit extends Object

}

public class Mobile extends Product {

}

public class Tv extends Product {

}

Note: Java doesn;t support multiple inheritance [ class A extends B, C {} // not allowed]

========================

Inheritance and constructors:

public class Object {
	public Object() {

	}
}


public class Product {  
	public Product() {
		"P1"
	}

	public Product(int id, String name) {
		"P2"
	}
}

public class Tv extends Product {
	public Tv() {
		"T1"
	}

	public Tv(int id, String name, String type) {
		"T2"
	}
}

look into shared "png" files for explanation

===========



public class Product {  
	public Product() {
		"P1"
	}

	public Product(int id, String name) {
		"P2"
	}
}

public class Tv extends Product {
	public Tv() {
		"T1"
	}

	public Tv(int id, String name, String type) {
		super(id, name);
		"T2"
	}
}


=====================


Methods and Inheritance




public class Product {  
	 public double getPrice() {
	 	return 100;
	 }
}

public class Tv extends Product {
	 public double getPrice() {
	 	return 999;
	 }

	 public String getType() {
	 	return "LED"
	 }
}

Tv t = new Tv();
t.getPrice(); // 999
t.getType(); // LED

Override rules:
1) Private is not visible ==> No overriding concept
2) while overriding; overriding method should have same access modifier or enhance the visiblity;
can't weaken the visiblity

public class Product {
	public double getPrice() {
	 	return 100;
	 }
}

class Tv extends Product {
	private double getPrice() { // ERROR
	 	return 100;
	 }
}


===


public class Product {
	 double getPrice() { // default is package-private
	 	return 100;
	 }
}

class Tv extends Product {
	public double getPrice() { // VALID
	 	return 100;
	 }
}

======


public class Product {
	protected double getPrice() { // package-private + inherited classes
	 	return 100;
	 }
}

class Tv extends Product {
	public double getPrice() { // VALID
	 	return 100;
	 }
}

=======
* Enhance the visiblity:
private ==> default ==> protected ==> public

* method name and arguments should be same; return type has to be same or sub-class

public class Product {
	public Product getObject() {
		return new Product(...);
	}
}

public class Tv extends Product {
	@Override
	public Tv getObject() {
		retunr Tv(...)
	}
}

=========

variables and static methods are not override; but shadowed

public class Product {
	public int id = 10;

	public static void doTask() {}
}

public class Tv extends Product {
	public int id = 100; // shadowing
	public static void doTask() {} // shadowing

}


============

Dynamic Binding:

public class Product {  
	 public double getPrice() {
	 	return 100;
	 }
}

public class Tv extends Product {
	 public double getPrice() {
	 	return 999;
	 }

	 public String getType() {
	 	return "LED"
	 }
}

Product p = new Tv(); // upcasting
p.getPrice(); // 999

p.getType(); // ERROR


p = new Product();
p.getPrice(); // 100

======================================

Product[] products = new Product[5]; // Array of 5 Pointers
		products[0] = new Tv(133, "Sony Bravia", 135000.00, "LED"); // upcasting
		products[1] = new Mobile(453, "MotoG", 12999.00, "4G");
		products[2] = new Tv(634, "Onida Thunder", 3500.00, "CRT");
		products[3] = new Mobile(621, "iPhone XR", 99999.00, "4G");
		products[4] = new Mobile(844, "Oppo", 9999.00, "4G");

instead if we do:

Tv[] tvs = new Tv[123];

for(Tv t : tvs) {

}
Mobile[] mobiles = new Mobiles[500];

for(Mobile m : mobiles) {

}

DishWasher[] dws = ...

for(DishWasher d : dws) {

}

====================

Self Study:

1) Different types of Comments in Java
2) Arrays : primitive and object arrays
3) Naming Conventions in Java
	3.1) CamelCase
	3.2) Spine Case
	3.3) Snake Case

====================================


Different types of Comments in Java:
A) Developers: ==> who has access to source code

1) Single line
int age = 10; // age of person

2) Multiline
/*
	this is multiline
*/

B) API user: Developer but maynot be  a part of team
3) Documentation Comments

/**


*/


Documentation comment:

ICICI Banking application
	==> Verisign, Citrus, ...

	ICICI buys API from Verisign and integrate with the application

	/**
		This class is used to authenitcate ...

		@author Verisgn
		@Version 1.0

	*/
	public class Authenticate {

		/**
			this method valdiates the pin

			@arg pin
			@return true if pin is valid else return false
		*/
		public boolean validatePin(String pin) {

		}
	}
	
============

Naming Conventions in Java:

1) class ==> CamelCase

	class OracleConnection {

	}

2) methods: ==> CamelCase
	// getmetea() { }

	public Tea getMeTea() {

	}

3) variables ==> CamelCase

	int priceOfProduct = 12444.22;


4) Constants ==>  Snake Case

	final int MAX_AGE = 100;

5) Spine Case ==> only in html / xml 
	<customer-id>123</customer-id>

================================================
Product by itselef doesn't exist
I need to buy a Product

I need to open an Account

There can't be any instance of Product, Account in real world. They are just meant of Generalization purpose

Such classes should be marked as "abstract"

Rule:
1) If one of the method is abstract then class also should be declared abstract
2) abstract class need not have abstract methods

============================

Realization Relationship
=> Object / Component will realize the behaviour specified by other in order to communicate

==> implementated using interfaces

interface interfaceName {
	abstract methods
}

interface EmployeeDao {
	void addEmployee(Employee e);
	Employee getEmployee(int id);
}


Why Program to interface?
1) DESIGN
2) IMPLMENTATION
3) TESTING
4) INTEGRATION
5) loose coupling

====================================

Interfaces for OCP.

===========================

class Rectangle {
	int width;
	int breadth;
}


Generics

class Rectangle <T> {
	T width;
	T breadth;

	//
}

Rectangle<Integer> r1 = new Rectangle<Integer>(4,5);

Rectangle<Double> r2 = new Rectangle<Double>(4.3,1.6);


Rectangle<String> r3 = new Rectangle<String>("A", "B");

Integer, Double, Float  are typewrapper classes for int, double and float

Limitation of Generices ==> only objects can be of generic type


class Store<T1,T2> {
	T1 key;
	T2 value;
	///
}

Store<String,Integer> mystore = new Store<String, Integer>("Java", 1234);

=====================================

interfaces for OCP

------------------

public interface Comparable<T> {
	 public int compareTo(T o);
}


class Rectangle implements Comparable <Rectangle> {
	//
	public int compareTo(Rectangle o) {
		// logic
	}
}

class Employee implements Comparable<Employee> {
	public int compareTo(Employee o) {
		// logic
	}
}

//OCP
public void sort(Comparable[] elems) {
	logic
}

=============================================================================

interface Swim {
	void swim();
}

interface Dance {
	void dance();
}

interface Fight {
	void fight();
}

class Actor implements Dance {
	public void dance() {///}
}

class Hero extends Actor implements Swim, Fight {
	public void fight() {//}
	public void swim() {//}
}

=======================================

Anonymous class

interface Flyable {
	public void fly();
}

public class Bird implements Flyable {
	// state
	// behaviour

	public void fly() {
		// logic
	}
}

public class AeroPlane implements Flyable {
	//state and behaviour
	public void fly() {
		// logic
	}
}

Flyable f = new Bird();
f = new AeroPlane();

Flyable f = new Flyable(); // error

// Anonymous class
Flyable f = new Flyable() {
	public void fly() {
		jump from 10th floor!!!
	}
};	

f.fly();

===========================

interface Priority {
	int LOW = 0; // public static final
	int MED = 5;
	int HIGH = 10;
}

Priority.HIGH;

==========================

abstract class , abstract methods, interface for realization relationship

=========================================================================

Java Collection Framework -> provides Data Containers 

Arrays are data containers

int[] data  = new int[500];

Limitation 
	==>  1) Size is fixed; it can't grow or shrink
		 2) adding and removing from arbitrary position is difficult On

==========

Comparable Vs Comparator

Comparable
	==> logic is within the class
	==> use this for Natural comparision [ Strings by lexical ordering, 
		Product, Employee, etc by Primary Key [ id ]]

Comparator
	==> logic is in client code
	==> use various fields [ Product ==> name, price, category ]

===========================

List:
	is a data container which supports duplicates, index based operation, ordered, re-order

Set: is a data container with unique elements and doesn't support => index based operation, ordered, re-order

ArrayList list = new ArrayList(); // tightly coupled ==> Avoid


List list = new ArrayList(); //loose coupled

list = new LinkedList();

==

Prefer using Generics:

Avoid without generics: ==> Not TypeSafe
List list = new ArrayList();
list.add("A");
list.add(new Product());
list.add(new Date());

if(list.get(0) instanceof String) {
	String s = (String) list.get(0);
} else if (list.get(0) instanceOf Date) {
	Date d = (Date) list.get(0);
}

With Generics:
List<String> list = new ArrayList<String>();
list.add("A"); // works
list.add("B");
list.add(new Date()) ; // Compilation error

String s = list.get(1); // Type Safe

===========================================
Functional Style of Programming Vs OOP

OOP ==> methods ==> tightly coupled to state of object deposit() getBalance() ==> balance

Functional Style of Programming ==> functionalities which are not tightly coupled to any type of data
	filter, map, reduce, forEach, skip, limit, sorted

====

High Order Functions:
* functions which accept other functions as arguments
* function returns a function

============

Java 8 streams supports
	1) filter
		is to get subset based on the predicate
	2) map
		is to transform data
	3) reduce
		is to get aggregate => sum(), count(), avg(), max(), min() ==> single value
	4) forEach
		is to traverse
	5) limit
	6) skip
	7) collect
		==> to collect into another container
	8) flatMap
	..

	Terminal opertions: reduce, forEach, collect
	Intermediate Operations : all others

===========================================

 HashCode: A hash code is an integer value that is associated with each object

* similar objects should have same hashcode

* possiblity is disimiar objects can also have same hashcode


HashSet, HashMap uses hashcode for ==> finding duplicates and position of object in container




class Rectangle {

	public int hashCode() {
		return w * b;
	}
}

4,5 ==> 20
20,1 ==> 20
1,20 ==> 20
10, 2 ==> 20
5,4  ==> 20

======================================================

Queue, TreeSet ==> self-study

=======================================

Map ==> store with Key / value pair

Dictionary [ key is unique, values can be duplicate]

Registry


Map<String, Double> map = new HashMap<>();

map.put("Java", 2345.11);
map.put("JS", 1235.32);

double price = map.get("Java"); // 2345.11

map.put("Java", 3444.22); // overwrite

price = map.get("Java"); //  3444.22

==================================================

Exception Handling

------------------

In Java "exception" is an abnormal condition that arises during program execution.

"exceptions" can be broadly classfied as error type and exception type

Error type of exceptions ==> can't be resolved during program exectuon; program crashes; redo the code 
and re-run

exception type of exceptions ==> can be handled ==> can have alternate flow

In Java exception is represented in the form of object which gives following info:
* what went wrong
* Why?
* where?

=================================================

Exceptions; Annotations; Multi-threaded application

Docker and Mysql setup done

=============================================


Backend ==> pull the data ==> store in TreeSet ==> views uses them [ sorted ]
	==> fetch in ArrayList and allow clients to sort

Frontend ==> add/remove ==> hashSet ==> send it to backend

=========================================================

Day 3:

------
"exceptions" can be broadly classfied as error type and exception type

exception type of exceptions can be classified as "checked type" and "unchecked type"


unchecked type:
* Compiler doesn't force you to handle
* ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException, ClassCastException

	1) ArithmeticException:
	 	int x = 10;
		int y = 0;
		int result = x / y;

		Resolve: if( y != 0)

	2) public void addEmployee(Employee e) {
			e.setSalary(222222); // NullPointerException
		}

		Employee e = null;
		addEmployee(e);

		Resolve: if( e!= null)

 	3) ArrayIndexOutOfBoundsException
 			int[] data = new int[4];

 			data[0] = 222;
 			data[8] = 99; //  ArrayIndexOutOfBoundsException
 			System.out.println(data[5]);   //  ArrayIndexOutOfBoundsException

 	4) 	ClassCastException

 		Product[] products = new Product[5]; // Array of 5 Pointers
		products[0] = new Tv(133, "Sony Bravia", 135000.00, "LED"); // upcasting
		
		Mobile m = (Mobile) products[0]; // ClassCastException

		Resolve:
		if(products[0] instanceof Mobile) {
			Mobile m = (Mobile) products[0];
		}

* all these type of exceptions happen due to reasons within JRE


Checked type of exceptions:
* compiler forces you to handle by using try - catch - finally block
* these exceptions are a result of abnormal condition outside of JRE

Examples:
	SQLException
		==> Database connection 
		==> insert record which is already existing in DB [ Unique key constraint]
	IOException
		==> open file which doesn't exist ==> OS throws exception
		==> open socket which is used by other app
	ClassNotFoundException
		==> load a class which doesn't exist in secondary storage

* User Defined exceptions and its uses + usage of finally block ==> JDBC ==> connecting to database

====================================================================================================


* Annotations

==> metadata ==> data about data

==> xml as metadata before annotation

@annotationname

* Who uses it?
 ===> COMPILER
 ===> CLASSLOADER
 ===> RUNTIME [ JRE ]

* Where can i apply it?
==> METHOD
==> TYPE [ class, interface, ..]
==> Constructor
==> FIELD
==> PARAMETERS

Example:

@Override is used by COMPILER and applied on method

Mobile.java
@Override
public boolean isExpensive() {
	
}

=========================================

We can write @Mobile to be used by CLASSLOADER

@Mobile(brand="Samsung")
public class PubG extends Game {

}

====

* RUNTIME

public class SampleApp {

	public static void first() {

	}

	@Test()
	public static void firstTest() {

	}

	@Test()
	public static void secondTest() {

	}

	public static void second() {

	}
}

JUnit / TestNG

==================

Example: @Table and @Column annotations



@Table(name="products")
public class Product implements Comparable<Product> {
	
	@Column(name="PRD_ID", type="NUMERIC(12)")
	public int getId() {
		return id;
	}

	@Column(name="PRD_NAME")
	public String getName() {
		return name;
	}

	@Column(name="amount", type="NUMERIC(12,2)")
	public double getPrice() {
		return price;
	}

	@Column(name="CATEGORY")
	public String getCategory() {
		return category;
	}
}

SQLs for:

DDL ==> CREATE , ALTER, drop

DML ==> INSERT, DELETE, UPDATE ,SELECT


String vs StringBuilder

String s = "Hello";

s += "World";

s += "123";


List<Integer>

List<Double>

List<?> ==> know as unknown type ==> allows accessors on any type but prevents mutation

======================================================================

Java Concurrent Programming ==> Building multi-threaded applications

Process ==> Program in execution has to have atleast one of unit of work

Thread ==> Unit of Work

Web Browser is multi-threaded
	* getting data from network
	* rendering images
	* rendering text
	* event handling
	* user threads

Word
	* editing
	* spell check
	* grammer check
	* auto-saving

Eclipse
	* code 
	* syntax errors
	* intelisense


Why do we need multi-threaded applications?
--> Better user experience
--> optimzation of usage of available resources
	==> multi-core
--> seperate tasks so that if one of the tasks doesn't work the application need not be terminated


JVM and Threads

Every thread has to be runnable
interface Runnable {
	void run();
}

class SpellCheck implements Runnable {
	///

	// entry point for a thread
	public void run() {

	}
}

Entry point of main thread ==> main()

=============

Thread class ==> has Thread control methods
* start()
* yield()
* sleep(ms)
* interrupt()
* join()

* stop(), suspend() and resume() are deprectated


======================

Every object has a Mutex / Monitor / Lock ==> use the lock to protect critical section

By Locking only one critical section can be executed by any thread at a given point of point

synchronized ==> marker to specific it as critical section

==========================================================

Docker is a container 

images

container

============

mysql> create database ADOBE_JAVA_2;
mysql> use ADOBE_JAVA_2;
mysql> create table products (id int primary key auto_increment, name VARCHAR(100), price double, category VARCHAR(100));
mysql> insert into products values (0, 'iPhone 11', 89000.00,'mobile');
mysql>  select * from products;

========================================================


JDBC ==> Java Database Connectivity ==> Integration API

JDBC provides set of interfaces; implementation classes are provided by database vendors

ORACLE ==>  implementation classes are provided by Oracle

MySQL ==> implementation classes are provided by MySQL

"mysql-connector-8.jar"

"ojdbc.jar"

=============

Steps:

1) load driver classes provided by database vendors

	Class.forName(driverClassName);

	Class.forName("oracle.jdbc.Driver");

	Class.forName("com.mysql.jdbc.cj.Driver");

2) Establish a database connection:

	Connection con = DriverManager.getConnection(URL, USER, PWD);

	URL: 
		jdbc:oracle:thin:@198.22.134.13:1521/adobe_java_2

		jdbc:mysql://120.221.44.12:3306/adobe_java_2

3) Send SQL
	3.1) Statement
		uses this if SQL is fixed
			"select * from products"
	3.2) use preparedstatement if SQL depends on IN parameters
			"select * from accounts where acc_no = ?"

			? ==> SB_103
			? ==> SB_633

			"select * from users where user = ? and password =?"

			"insert into products values (?, ?, ? , ?)"

	int executeUpdate(SQL) for INSERT, DELETE and UPDATE


	ResultSet executeQuery(SQL) ==> SELECT Statement


4) Always release connection in "finally" block
	finally block is a compulsory execute code [ exception occurs or not]

	try {


	} catch(SQLException ex) {

	} finally {
		con.close();
	}
=======================================

Maven: Maven is a software project management and comprehension tool. Dependency management is a core feature of Maven.

All dependecnices are in the form of "jar" files across different repositories/CDN

pom.xml
	<dependency>
      <groupId>commons-logging</groupId>
      <artifactId>commons-logging</artifactId>
      <version>1.2.4</version>
    </dependency>

Maven takes care of downloading the dependencies and attaching it to your project

============


Threads, synchronized, wait and notify, JDBC, User defined exception, Maven as a build tool

================================================

Web application development ==> JEE ==> Java Enterprise Edition

Engines / Container ==> Servlet engine / Servlet Container ==> Java as platform
ASP engine, ASP.NET , PHP




Servlet engine / Servlet Container ==> Tomcat, Jetty

Eclipse Jetty is a Java web server and Java Servlet container.

Tomcat is a Servelt Container ==> Apache, JBOSS, WebLogic, Webpshere


public class Sample {
	private static Sample ref = null;
	private Sample() {

	}

	public synchronized static Sample getSample() {
		if(ref == null) {
			ref = new Sample();
		}
		return ref;
	}

	method() {

	}
}




Sample s = new Sample(); // error


Sample s1 = Sample.getSample();

Sample s2 = Sample.getSample();

======================================


Servlet API ==> jar files ==> Maven

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response) {

 }

  public void doPost(HttpServletRequest request, HttpServletResponse response) {

 }

  public void doPut(HttpServletRequest request, HttpServletResponse response) {

 }
  public void doDelete(HttpServletRequest request, HttpServletResponse response) {

 }

}

===============

Prior to Annotations ==> Before Servlet 2.5 version we used xml

public class RegisterServlet extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response) {

 }

  public void doPost(HttpServletRequest request, HttpServletResponse response) {

 }

  public void doPut(HttpServletRequest request, HttpServletResponse response) {

 }
  public void doDelete(HttpServletRequest request, HttpServletResponse response) {

 }

}

web.xml ==> deployment descriptor
<servlet>
	<servlet-name>First</servlet-name>
	<servlet-class>pkg.RegisterServlet</servlet-class>
</servlet>

<servlet-mapping>
		<servlet-name>First</servlet-name>
		<url-pattern> /register </url-pattern>
</servlet-mapping>

SAXParser / DOMParser

Default package -- > jar

Web archive:
<packaging>war</packaging>


Scope of dependecies:
<scope>provided</scope>
	==> use this dependency for Compilation;
	===> don't add these dependecnies into my "war" / "jar" file
	==> target engine has these dependencies

<scope>test</scope>

=======================================================

src/main/webapp ==> folder where static resources [ html / css / js/ images ] reside. 


jetty:run

===================
HTML ==> static content

JSP ==> Java Server Pages ==> server side templates for rendering data
	==> static + dynamic content

	<%

	scriptlet

	%>

	Expression:
	<%= variable %>

Prefer JSP for views instead of Servlet

Servlet should be used for application logic ==> flow of application

============================

${p.id} ==> p.getId()

${p.name} ==> p.getName()

=====================================

HTTP protocol is a stateless protocol; Doesn't keep track of conversational state of client

request and response objects are created and destroyed for every "request"


================


JSP ==> View ==> Server side Rendering
Servlet ==> Controller ==> Application logic
Filter ==> Interceptor pattern [ Security, logging, encrypt, ..]

Listeners ==> execute based on events within the Servlet container / engine ==> No URL pattern

==> ServletContext is created [ each application within an engine has its own ServletContext]

============



Day 5:

------
Spring Boot and JPA with Hibernate

-----------------------

Spring ==> Framework with lightweight container for developing Enterprise Application


XML as metdata

public interface ProductDao {
	addProduct(Product p);
}

public class ProductDaoJdbcImpl implements ProductDao {
	addProduct ...
}

public class ProductDaoMongoDbImpl implements ProductDao {
	addProduct ...
}


public class ApplicationService {

	ProductDao productDao;

	public void setProductDao(ProductDao pd) {
		this.productDao = pd;
	}

	insertProduct(p) {
		productDao.addProduct(p);
	}
}

beans.xml

<bean id="jdbcdao" class="ProductDaoJdbcImpl"/>
<bean id="mongodao" class="ProductDaoMongoDbImpl"  />

<bean id="service" class="ApplicationService">
	<property name="productDao" ref="jdbcdao" />
</bean>


===========

Annotations:



public interface ProductDao {
	addProduct(Product p);
}

@Repository
public class ProductDaoJdbcImpl implements ProductDao {
	addProduct ...
}

@Repository
public class ProductDaoMongoDbImpl implements ProductDao {
	addProduct ...
}


@Service
public class ApplicationService {

	@Autowired
	ProductDao productDao;

	insertProduct(p) {
		productDao.addProduct(p);
	}
}

Bytecode instrumentation is a technique for changing the code of compiled Java applications, either before running them – on the disk, or “on the fly” as they are loaded into memory


To Resolve multiple beans implmenting the same interface: which to inject?

@Autowired
@Qualifier("productDaoMongoDbImpl")
ProductDao productDao;

====================



public interface ProductDao {
	addProduct(Product p);
}

@Repository
public class ProductDaoJdbcImpl implements ProductDao {
	addProduct ...
}

@Repository
@Primary
public class ProductDaoMongoDbImpl implements ProductDao {
	addProduct ...
}


@Service
public class ApplicationService {

	@Autowired
	ProductDao productDao;
 
=========================================================

Using Profile to solve multiple implmentations of interface
public interface ProductDao {
	addProduct(Product p);
}

@Repository
@Profile("dev")
public class ProductDaoJdbcImpl implements ProductDao {
	addProduct ...
}

@Repository
@Profile("prod")
public class ProductDaoMongoDbImpl implements ProductDao {
	addProduct ...
}

@Repository
@Profile("test")
public class ProductDaoMockImpl implements ProductDao {
	addProduct ...
}

@Service
public class ApplicationService {

	@Autowired
	ProductDao productDao;

VM arguments:
java -Dspring.profiles.active=test ApplicationClassHavingMain
OR
Program argument:
--spring.profiles.active=test

or

application.properties
spring.profiles.active=test

java ApplicationClassHavingMain



@Repository("mockimpl")
public class ProductDaoMockImpl implements ProductDao {
	addProduct ...
}

@SpringBootApplication
	==> @ComponentScan
			this annotation scans for classes with @Component, @Repository, @Service, @Controller, @RestController or @Configuration from "com.adobe.prj" and subpackages and creates instances of the class [ singleton]
	==> @EnableAutoConfiguration
		==> creates objects of classes bundled with "jar"

============================
 package com.adobe.prj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.AppService;

@SpringBootApplication
public class SpringdemoApplication /* implements CommandLineRunner */ {
	
//	@Autowired
//	private AppService service;
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringdemoApplication.class, args);
		
		AppService service = ctx.getBean("appService", AppService.class);
		Product p = new Product(45,"some",343,"ct"); 
		service.insertProduct(p);
	}

	/*
	 * @Override public void run(String... args) throws Exception { // this code
	 * gets executed as soon as Spring Container is created Product p = new
	 * Product(45,"some",343,"ct"); service.insertProduct(p); }
	 */

}


==============================

ORM ==> Object Realtional Mapping
	ORM Frameworks ==> 
	Hibernate, 	KODO, TopLink, OpenJPA

	JPA ==> Java Persitence API ==> interfaces for ORM


spring.jpa.hibernate.ddl-auto=update
	DDL ==> data definiation language
		CREATE, ALTER, DROP
	--> create ==> drop existing tables and re-create
	-->  update ==> if table exists use it, if not create it, if any alter needs to be done do it
	--> verify ==> use tables provided by database as is; dont alter; if doesn't match throw exception


spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
	Since JPA[ Hibernate ] is generating SQL; good to see what is genenerated ==> console

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

ORM ==> generate SQL compatable to MySQL8Dialect/ Oracle9Dialect

=============

In enterprise appication avoid
DriverManager.getConnection(url,...)
Why?
	latency involed in establishing connection; we need to release the connection

Prefer ==> database connection pool ==> DataSource [ pool of database connections]
	HikariCP, c3p0, DriverManagerDataSource

==========

Post Lunch ==> try adding Customer and getCustomer by "email"

=========================

for(int i = 0 to 100)
	product[] elems = getById(i); // none of the products are loaded from db


Product p = elems[8];
p.setPrice(...); // hits the db

====================================

findById(22) this returns Optional<Product>

	Optional<Product> opt = productDao.findById(34);
	if(!opt.isPresent()) {

	} else {
			opt.get();
	}
===================================

Declarative Transactions ==> @Transactional


@Entity
@Table("accounts")
class Account {

}

@Entity
@Table("txs")
class BankingTransaction {

}

BankingService.java

@Transactional
public void transferFunds(String a1, String a2, double amt) {
	Account acc1 = accountDao.findById(a1);
	Account acc2 = accountDao.findById(a2);
	acc1.withdraw(amt);
	acc2.deposit(amt);

	BankingTransaction tx = new BankingTransction(;;;);
	bankingTransactionDao.save(tx);
}
	

=======
	Update SQL on 2 accounts; insert SQL on txs table	
	@Transactional ==> code atomic
=============================================

Association Mapping

Customer and Orders	

Customer oneToMany Order

Order manyToOne Customer

==========

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="order_fk") // FK
	private List<Item> items = new ArrayList<>();



Order o = new Order(,,,,);
place 4 items in order

Save without cascade:
orderDao.save(o);
itemDao.save(i1);
itemDao.save(i2);
itemDao.save(i3);
itemDao.save(i4);

Delete without cascade:
orderDao.delete(o);
itemDao.delete(i1);
itemDao.delete(i2);
itemDao.delete(i3);
itemDao.delete(i4);


--
Save with Cascade: @OneToMany(cascade = CascadeType.ALL)
orderDao.save(o); // will take care or saving all its children ==> items

Delete with Cascade:
orderDao.delete(o); // takes care of deleteing its children


==========

default fetch is LAZY

orderDao.findAll(); // select * from orders;

itemDao.getItemByOrder(itemid);
itemDao.getItemByOrder(iod);
itemDao.getItemByOrder(iod);



fetch = FetchType.EAGER

orderDao.findAll();  // gets all orders and items also


=================================

DAO ==> Table most of the time 95%+ [ 1: 1 ]

Service classes ==> one per actor [ customer/ Manager ] or one per application

=========================

 
ManyToOne ==> Fetch is EAGER by default
OneToMany ==> Fetch is LAZY by default

===============

To update data:
Approach 1:

Client passes "id" and "price" 

Service:

@Transactional
public void updatePrice(int id, double price) {
	Product p = productDao.findById(id).get();
	p.setPrice(price); // dirty checking ==> update
}

=====

Approach 2:
Write modifiying query
call this method of ProductDao from service
	@Modifying
	@Query("update Product set price = :pr where id = :id")
	public void updateProduct( @Param("id") int id, @Param("pr") double price);


==
Deleting


@Transactional
public void deleteProduct(int id) {
	Product p = productDao.findById(id).get();
	productDao.delete(p);
}

=================================================

JPA.pdf ==> Association Mapping

Task 1: VehicleRental
	entities:
		1) Rental [ id, rentaldate, Vehicle, Customer, amount]
		2) Vehicle
		3) Customer


	Rental to Customer is manyToOne
	Rental to Vehicle is manyToOne

	==> no need for EAGER and cascade

Task 2: ProjectManagment

		1) Project
		2) Client
		3) Employee


Task 3: oneToMany
		Test
		Question
		MCQ Options

======================================

Install POSTMAN

=====================================

RESTful Web services

Representional State Transfer


uses HTTP protocol
uses URLs to identify resources [ plural nouns]
uses HTTP methods for verbs/actions

---
1)
GET
http://localhost:8080/api/products 

get all products

2) GET
http://localhost:8080/api/products/5

get a product whose id is "5"

use extra path parameter for "id" or sub-resource

http://localhost:8080/api/customers/banu@adobe.com/orders

3) GET
http://localhost:8080/api/products?page=3&size=10
use query parameter for subset
http://localhost:8080/api/products?category=mobile
http://localhost:8080/api/products?low=5000&high=10000


4) POST
http://localhost:8080/api/products
payload from client contains new product which has to be added to "products" resource

5) DELETE
http://localhost:8080/api/products/5

delete a product whose id is "5"

6) PUT
http://localhost:8080/api/products/4

payload has new productinfo to update product whose id is "4"

POST and PUT has payload

GET and DELETE has no payload

---
IDEMPOTENT ==> GET and DELETE

=======================================================================

public interface ProductDao extends JpaRepository<Product, Integer> {
	List<Product> findByCategory(String category);

	List<Product findByPriceAndCategory(double price , String category);
}

select * from products where category = 

select * from products where price = and category =

==========================================================



Day 6

-----

http://localhost:8080/api/products

http://localhost:8080/api/v1/products



@RestController
@RequestMapping("api/products")
public class ProductController {

	@GetMapping()
	method


	@PostMapping()
	method

	@PutMapping()
	method

	@DeleteMapping()
	method
}

========================

Status Code:
200 ==> OK [ Default]
201 ==> CREATED
400 ==> BAD REQUEST
401 ==> Unauthorized
404 ==> Resource Not Found
500 ==> Internal Server Error



1) ==> Method of REQUEST is GET @GetMapping)()
	
	@GetMapping()
	public @ResponseBody List<Product> getProducts() {
		return service.getProducts();
	}
	

	@ResponseBody List<Product> ==> returned products has to be converted into representation [ JSON / XML]
	based on "accept" header from client [ POSTMAN, REACT, Angular , .NET applciation , C++ application]

	 @ResponseBody ==> uses content negotiation handler 
	 		JSON ==> Jackson, Jettison, GSON , Moxy

	 		Java <==> JSON
	 JAXB ==> XML
2)

http://localhost:8080/api/products/2

extra path ==> /{pid}


@GetMapping("/{pid}")
	public @ResponseBody Product getProduct(@PathVariable("pid") int id) {
		return service.getProductById(id);
	}


3)

@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody Product addProduct(@RequestBody Product p) {
		return service.addProduct(p);
	}
	
CLient sets header ==> content-type : "application/json"
client sends payload
@RequestBody converts payload to object


=================

Task: 
1) Write CustomerController ==> api/customers

	1.1) get all customers
	1.2) get customer by email

==============


OrderController

	Placing and ORder should insret into "orders" + "items" table ==> Cascade
	Once products are added into items ==> "products" table should be updated ==> Dirty Checking

	Order JSON:
	{
		"customer" : {
			"email": "george@adobe.com"
		},
		"items" : [
			{"product": {"id" : 6 }, "qty" : 2},
			{"product" : { "id": 1}, "qty": 1}
		]
	}
 
org.springframework.web.bind.MethodArgumentNotValidException: Validation failed for argument [0] in public com.adobe.prj.entity.Product com.adobe.prj.api.ProductController.addProduct(com.adobe.prj.entity.Product) with 3 errors: [Field error in object 'product' on field 'price': rejected value [-34.0]; codes [Min.product.price,Min.price,Min.double,Min]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [product.price,price]; arguments []; default message [price],10]; default message [Price -34.0 should be more than 10]] [Field error in object 'product' on field 'quantity': rejected value [-100]; codes [Min.product.quantity,Min.quantity,Min.int,Min]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [product.quantity,quantity]; arguments []; default message [quantity],0]; default message [Quantity -100 should be more than 0]] [Field error in object 'product' on field 'name': rejected value []; codes [NotBlank.product.name,NotBlank.name,NotBlank.java.lang.String,NotBlank]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [product.name,name]; arguments []; default message [name]]; default message [Name is required]] 


===================================================================================

Recap:

1) Rest Controllers need to be marked with @RestController

2) @RequestMapping can be given at class level or method level
	
3) @GetMapping() @PostMapping() @PutMapping() and @DeleteMapping()

4) @ResponseBody is to convert java to JSON for sending to client

5) @RequestBody is to convert payload coming from client in XML/json format to Java object

6) @PathVariable to read  path parameter {variableName}

	@GetMapping("/{id}")
	public @ResponseBody Product getProduct(@PathVariable("id") int id)

7) To read Query paramters ?key=value&key=value
	@RequestParam
	// http://localhost:8080/api/products?low=1000&high=50000
	@GetMapping()
	public @ResponseBody List<Product> getProducts(@RequestParam(name = "low", defaultValue = "0.0") double low,
			@RequestParam(name="high", defaultValue =  "0.0") double high) {

8) Input Validation;
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

	8.1) place validation annotations on fields of entity: @Min, @Max, @NotNull, ...
	8.2) Place @Valid for method argument
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody Product addProduct(@RequestBody @Valid Product p) {
		return service.addProduct(p);
	}

	If validation fails it throws "MethodArgumentValdiationException"
	to handle exceptions from Controller/RestController we write @ControllerAdvice GlobalExceptionHanlder


@ControllerAdvice
public class GlobalExceptionHandler extends  ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest req) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", ex.getLocalizedMessage());
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDate.now());
		body.put("status", status.value());
		
		List<String> errors  = ex.getBindingResult()
					.getFieldErrors()
					.stream()
					.map(x -> x.getDefaultMessage())
					.collect(Collectors.toList());
		
		body.put("errors", errors);
		
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
}

=======

Updating a Product:

ProductDao:
	@Modifying
	@Query("update Product set price = :pr where id = :id")
	public void updateProduct( @Param("id") int id, @Param("pr") double price);

-----

OrderService:

	@Transactional
	public Product updateProduct(int id, double price) {
		productDao.updateProduct(id, price);
		return productDao.findById(id).get();
	}

----

ProductController:

	
	@PutMapping("/{id}")
	public @ResponseBody Product modifyProduct(@PathVariable("id") int id, @RequestBody Product p) {
		return service.updateProduct(id, p.getPrice());
	}

-----

POSTMAN:
PUT:  http://localhost:8080/api/products/4

body:
{
    "price": 999.99
}

---------------------------------------

Task:
	Rental application to RESTful web service:
	VehicleController 
	RentalController

	add the following dependencies:
	1) spring-boot-starter-web
	2) sprinb-boot-starter-validation

---------------------------------
 Rental:

 {
 	"vehicle": {
 		"vehicleNumber" : "AP 09 SE 1490"

 	},
 	"customer" : {
 		"email" : "hema@gmail.com"
 	},
 	"amount": 3434

 }

 -------------------------------------------------

 Unit testing RestController
 JUnit is a unit testing framework

 We need to test:
 package com.adobe.prj.util;

public class ArrayUtil {
	public static int getSum(int[] elems) {
		int sum = 0;
		for(int elem : elems) {
			sum += elem;
		}
		return sum;
	}
	
	public static int getOccurence(int[] elems, int no) {
		int count = 0;
		for (int i = 0; i < elems.length; i++) {
			if(no == elems[i]) {
				count++;
			}
		}
		return count;
	}
	
}



=======
package com.adobe.prj;
 

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.adobe.prj.util.ArrayUtil;

public class ArrayUtilTest {

	@Test
	public void testGetSum() {
		int[] data = {5,4,2};
		int expectedSum = 11;
		assertEquals(expectedSum, ArrayUtil.getSum(data));
	}

	@Test
	public void testGetOccurence() {
		 int[] elems = {5,7,2,5,9,5};
		 int expected = 3;
		 assertEquals(expected, ArrayUtil.getOccurence(elems, 5));
	}

}

===============
Dependency

RestController ===> Service ===> JPARepository ===> database

Spring boot uses IOC using @Autowired

RestController <=== Service <=== JPARepository <=== database

For Unit Testing we need to mock the dependencies

To test RestController -> inject Mock Service

to test Service inject mock JPARepository

---------------------

for Java we have EasyMock, jMock and Mockito for Mocking class

Hamcrest => library with Good Assertion methods on top of Unit test framework provided [ JUnit ]
json-path ==> makes testing JSON easy

https://jsonpath.com/

=================

Swagger:
The OpenAPI Specification (OAS) defines a standard, language-agnostic interface to RESTful APIs which allows both humans and computers to discover and understand the capabilities of the service without access to source code, documentation


@Configuration
class SomeClass {

	@Bean
	public MyClass getMyClass() {
		return new MyClass();
	}
}

Spring executes methods marked as "@Bean" in "@Configuration" classes and returned object is managed
by Spring Container

------

Spring creates objects of class which have: @Repository, @Component, @Service, @Controller, @RestController, @Configuration



public class MyClass {
	public MyClass(String name, int config) {

	}
}

Where and When can i use @Bean:
1) 3rd party classes doesn't have Spring annotations
2) Spring always uses default constructor for creating objects; requirement is to invoke parameterized constructor
    

 
public class EmailSetUp {
	public EmailSetUp(String host, int port) {
		this.host = host;
		this.port =port
	}
}

@Bean
	public EmailSetUp getEmailSetup() {
		return new EmailSetUp("smtp.gmail.com", 465);
	}

	

@Api
@ApiOperation
@ApiModel
@ApiParameter

=========================================================

Docket is for Documentation using Swagger ==> OpenAPI

GitHub: jdbcauth.zip and jwt.zip ==> extract them ==> 


spring security dependency adds "username" "user" and generated password with
"login" and logout

===================

JDBCAuthentication:

===================================================

https://bcrypt-generator.com/

-----

JWT:
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
	 
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt</artifactId>
			<version>0.9.1</version>
		</dependency>
		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.0</version>
		</dependency>
==============================================

JWT ==> JSON Web Token
	==> authentication and authorization in Stateless application
	RESTful web services is Stateless

https://medium.com/@.jlabs/testing-spring-boot-application-secured-with-json-web-tokens-using-rest-assured-library-d6fdb19d2e70

===================================================================






9845801302




