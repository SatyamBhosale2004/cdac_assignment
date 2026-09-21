
public class easyAssignments_1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		q1();
//		q2();
//		q3();
//		q4();
//		q5();
		q6();
	}
	
	public static void q1() {
		Student john = new Student();
		john.setName("John");
		john.setRollNo(2);
		john.setPhoneNo("1234");
		john.setAddress("Kalyan");
		System.out.println("John's details: ");
		System.out.print("RollNo : " + john.getRollNo() + " Phone Number : " + john.getPhoneNo() + " Address : " + john.getAddress());
		Student sam = new Student();
		sam.setName("Sam");
		sam.setRollNo(1);
		sam.setPhoneNo("1323");
		sam.setAddress("Ulhas");
		System.out.println();
		System.out.println("Sam's details: ");
		System.out.print("RollNo : " + sam.getRollNo() + " Phone Number : " + sam.getPhoneNo() + " Address : " + sam.getAddress());
	}
	
	public static void q2() {
		Triangle obj = new Triangle(3,4,5);
		
		System.out.println("Area of triangle " + obj.area());
		System.out.println("Perimeter of triangle " + obj.perimeter());
	}
	
	public static void q3() {
		Rectangle obj = new Rectangle(3,4);
		
		System.out.println("Area of rectangle " + obj.area());
		System.out.println("Perimeter of rectangle " + obj.perimeter());
	}
	
	public static void q4() {
		Complex num1 = new Complex(3,4);
		Complex num2 = new Complex(2,6);
		Complex resultSum = Complex.add(num1, num2);
		Complex resultProd = Complex.prod(num1, num2);
		Complex resultDiff = Complex.diff(num1, num2);
		System.out.println("Sum of two complex numbers are " + resultSum.display());
		System.out.println("Difference of two complex numbers are " +resultDiff.display());
		System.out.println("Product of two complex numbers are " + resultProd.display());
	}
	
	public static void q5() {
		Employee empDetails[] = new Employee[3];
		empDetails[0] = new Employee();		
		empDetails[0].setName("Robert");
		empDetails[0].setYrOfJoining(1994);
		empDetails[0].setAddress("64C- WallsStreat");
		empDetails[1] = new Employee();	
		empDetails[1].setName("Sam");
		empDetails[1].setYrOfJoining(2000);
		empDetails[1].setAddress("64D- WallsStreat");
		empDetails[2] = new Employee();	
		empDetails[2].setName("John");
		empDetails[2].setYrOfJoining(1999);
		empDetails[2].setAddress("28B- WallsStreat");
		System.out.println("Name \t Year of Joining \t Address");
		for(int iTemp = 0; iTemp < empDetails.length; iTemp++) {
			empDetails[iTemp].display();
		}
	}
	
	public static void q6() {
		Employee obj = new Employee();
		System.out.println("Enter salary and hours of work per day");
		obj.getInfo(ConsoleInput.getDouble(), ConsoleInput.getInt());
		System.out.println("Final Salary " + obj.getSalary());
	}
}


class Student{
	private String name = "";
	private String phoneNo = "";
	private String address = "";
	private int rollNo = 0;
	
	
	public void setName(String n) {
		name = n;
	}
	public void setPhoneNo(String pNo) {
		phoneNo = pNo;
	}
	public void setAddress(String add) {
		address = add;
	}
	public void setRollNo(int r) {
		rollNo = r;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public int getRollNo() {
		return rollNo;
	}
}

class Triangle{
	private double length;
	private double breadth;
	private double height;
	
	Triangle(double l, double b, double h){
		length = l;
		breadth = b;
		height = h;
	}
	
	public double area() {		
		return 0.5 * breadth * height;
	}
	 public double perimeter() {
		 return length + breadth + height;
	 }
	
}

class Rectangle{
	private double length;
	private double breadth;
	
	Rectangle(double l, double b){
		length = l;
		breadth = b;
	}
	
	public double area() {		
		return breadth * length;
	}
	 public double perimeter() {
		 return 2* (length + breadth);
	 }
	
}


class Complex{
	private double real;
	private double imag;
	
	
	Complex(double r,double i){
		real = r;
		imag = i;
	}
	
	static Complex add(Complex n1, Complex n2) {
		double newReal = n1.real + n2.real;
		double newImag = n1.imag + n2.imag;
		
		return new Complex(newReal,newImag);
	}
	static Complex diff(Complex n1, Complex n2) {
		double newReal = n1.real - n2.real;
		double newImag = n1.imag - n2.imag;
		
		return new Complex(newReal,newImag);
	}
	static Complex prod(Complex n1, Complex n2) {
		double newReal = n1.real * n2.real;
		double newImag = n1.imag * n2.imag;
		
		return new Complex(newReal,newImag);
	}
	public String display() {
		if(imag >= 0)
			return real + "+" + imag + "i";
		else
			return real + "" + imag + "i";
	}	
}

class Employee{
	private String name;
	private int yrOfJoining;
	private String address;
	private double salary;
	private int hours;
	
	public void setName(String n) {
		name = n;
	}
	
	public void setYrOfJoining(int yr) {
		yrOfJoining = yr;
	}
	
	public void setAddress(String add) {
		address = add;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getYrOfJoining() {
		return yrOfJoining;
	}
	
	public void display() {
		
		System.out.println(name +" \t " + yrOfJoining + " \t\t\t " +address);
	}
	
	public void getInfo(double sal, int h) {
		salary  = sal;
		hours = h;
		addSal();
		addWork();
	}
	public double addSal() {
		if(salary < 500)
			return salary += 10;
		else
			return salary;
	}
	
	public double addWork() {
		if(hours > 6)
			return salary +=5;
		else
			return salary;
	}
	
	public double getSalary() {
		return salary;
	}
	
	
}
