
public class easyAssignments_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		q1();
//		q2();
//		q3();
		q4();
	}

	
	public static void q1() {
		Parent objP = new Parent();
		Child objC = new Child();
		objP.printP();
		objC.printC();
		objC.printP();
	}
	
	public static void q2() {
		PrimeMembers mem1 = new PrimeMembers();
		System.out.println("Enter member name");
		mem1.setName(ConsoleInput.getString());
		System.out.println("Enter member age");
		mem1.setAge(ConsoleInput.getInt());
		System.out.println("Enter member phone number");
		mem1.setPhoneNo(ConsoleInput.getString());
		System.out.println("Enter member address");
		mem1.setAddress(ConsoleInput.getString());
		System.out.println("Enter member salary");
		mem1.setSalary(ConsoleInput.getDouble());
		System.out.println("Enter member joining year");
		mem1.setJoiningYr(ConsoleInput.getInt());
		System.out.println("Enter member joining fees");
		mem1.setJoiningFees(ConsoleInput.getDouble());
		System.out.println("Enter member is active or not");
		mem1.setIsActive(ConsoleInput.getBoolean());
		System.out.println("Member Details");
		mem1.display();
	}
	
	public static void q3() {

		Rectangle objRectangle = new Rectangle(4, 5);

		Square objSquare = new Square(5);

		System.out.println("Rectangle Area = " + objRectangle.area());
		System.out.println("Rectangle Perimeter = " + objRectangle.perimeter());

		System.out.println("Square Area = " + objSquare.area());
		System.out.println("Square Perimeter = " + objSquare.perimeter());
	}
	
	public static void q4() {

		SquareShape objSquare = new SquareShape();

		objSquare.shapeMethod();
		objSquare.rectangleMethod();
	}
}


class Parent{
	public void printP() {
		System.out.println("This is parent class");
	}
}

class Child extends Parent{
	public void printC() {
		System.out.println("This is child class");
	}
}

class Members{
	private String name;
	private String address;
	private String phoneNo;
	private double salary;
	private int age;

	public void setName(String n) {
		name = n;
	}
	public void setAddress(String add) {
		address = add;
	}
	public void setPhoneNo(String pNo) {
		phoneNo = pNo;
	}
	
	public void setAge(int a) {
		age = a;
	}
	
	public void setSalary(double s) {
		salary = s;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public double getSalary() {
		return salary;
	}
	public int getAge() {
		return age;
	}
	
	public void printSalary() {
		System.out.println("Salary of member is " +salary);
	}
	
	public void display() {
		System.out.println("Name \t\t Age \t\t Phone Number \t\t Address \t Salary");
		System.out.println(name + " \t\t " + age + " \t\t " + phoneNo  + " \t\t " + address + " \t\t " + salary);
	}
}

class PrimeMembers extends Members{
	private int joiningYr;
	private double joiningFees;
	private boolean isActive;
	
	public void setJoiningYr(int yr) {
		joiningYr = yr;
	}
	public void setJoiningFees(double fee) {
		joiningFees = fee;
	}
	public void setIsActive(boolean active) {
		isActive = active;
	}
	public int getJoiningYr() {
		return joiningYr;
	}
	public double getJoiningFees() {
		return joiningFees;
	}
	public boolean getIsActive() {
		return isActive;
	}
	
	public void display() {
		System.out.println("Name \t\t Age \t\t Phone Number \t\t Address \t Salary \t Joining Year \t Joining Fees \t Is active");
		System.out.println(getName() + " \t\t " + getAge() + " \t\t " + getPhoneNo()  + " \t\t " + getAddress() + " \t\t " + getSalary() + " \t\t " + joiningYr + " \t\t " + joiningFees + " \t\t " + isActive);
	}
}

class Rectangle{
	private double length;
	private double breadth;
	
	public Rectangle(double l, double b) {
		length = l;
		breadth = b;
	}
	public double area() {

		return length * breadth;
	}

	public double perimeter() {

		return 2 * (length + breadth);
	}
}

class Square extends Rectangle {
	public Square(double side) {
		super(side,side);
	}
}

class Shape {

	public void shapeMethod() {
		System.out.println("This is shape");
	}
}

class RectangleShape extends Shape {

	public void rectangleMethod() {
		System.out.println("This is rectangular shape");
	}
}

class Circle extends Shape {

	public void circleMethod() {
		System.out.println("This is circular shape");
	}
}

class SquareShape extends RectangleShape {

	public void squareMethod() {
		System.out.println("Square is a rectangle");
	}
}