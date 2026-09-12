public class  ComplexNo{	
	private int number1;
	private int number2;
	
	public void setRealNum(int num) {
		number1 = num;
	}
	
	public void setImagNum(int num) {
		number2 = num;
	}
	
	public int getNumber1() {
		return number1;
	}
	
	public int getNumber2() {
		return number2;
	}
	
	public void display() {
		System.out.println("The complex Number is : " + getNumber1() * getNumber2());
	}
	
	public static void computeComplex() {
		ComplexNo complexNum[] = new ComplexNo[5];
		for(int iTemp=0;iTemp<complexNum.length;iTemp++) {
			complexNum[iTemp] = new ComplexNo();
			System.out.println("Enter first number");
			complexNum[iTemp].setRealNum(ConsoleInput.getInt());
			System.out.println("Enter second number");
			complexNum[iTemp].setImagNum(ConsoleInput.getInt());
			complexNum[iTemp].display();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		computeComplex();
	}

}