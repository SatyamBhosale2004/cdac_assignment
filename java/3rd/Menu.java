
public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee empObj[] = new Employee[50];
		int currentIndex = -1;
		int count =0;
		boolean flag = true;
		while(flag) {
	
			System.out.println("=============Menu=============");
			System.out.println("1 -> Add Employee");
			System.out.println("2 -> Display Employee Details");
			System.out.println("3 -> Sort");
			System.out.println("4 -> Exit");
			System.out.println("Enter your choice");
			int choice = ConsoleInput.getInt();
			switch(choice) {
				case 1:
					System.out.println("1 -> Add Manager");
					System.out.println("2 -> Add Engineer");
					System.out.println("3 -> Add Sales Person");
					System.out.println("4 -> Exit to main menu");
					System.out.println("Enter choice");
					int addChoice = ConsoleInput.getInt();
					if(addChoice == 1) {
						System.out.println("Enter Manager Details");
						System.out.println("Enter Manager name");
						String name = ConsoleInput.getString();
						System.out.println("Enter Manager address");
						String address = ConsoleInput.getString();
						System.out.println("Enter Manager age");
						int age = ConsoleInput.getInt();
						System.out.println("Enter Manager gender");
						String gender = ConsoleInput.getString();
						System.out.println("Enter Manager salary");
						double salary = ConsoleInput.getDouble();
						System.out.println("Enter Manager hra");
						double hra = ConsoleInput.getDouble();
						empObj[count] = new Manager(name,address,age,gender,salary,hra);
						count++;
						
					}
					if(addChoice == 2) {
						System.out.println("Enter Engineer Details");
						System.out.println("Enter Engineer name");
						String name = ConsoleInput.getString();
						System.out.println("Enter Engineer address");
						String address = ConsoleInput.getString();
						System.out.println("Enter Engineer age");
						int age = ConsoleInput.getInt();
						System.out.println("Enter Engineer gender");
						String gender = ConsoleInput.getString();
						System.out.println("Enter Engineer salary");
						double salary = ConsoleInput.getDouble();
						System.out.println("Enter Engineer over time");
						int overTime = ConsoleInput.getInt();
						empObj[count] = new Engineer(name,address,age,gender,salary,overTime);
						count++;
					}
					if(addChoice == 3) {
						System.out.println("Enter Sales Person Details");
						System.out.println("Enter Sales Person name");
						String name = ConsoleInput.getString();
						System.out.println("Enter Sales Person address");
						String address = ConsoleInput.getString();
						System.out.println("Enter Sales Person age");
						int age = ConsoleInput.getInt();
						System.out.println("Enter Sales Person gender");
						String gender = ConsoleInput.getString();
						System.out.println("Enter Sales Person salary");
						double salary = ConsoleInput.getDouble();
						System.out.println("Enter Sales Person comission");
						double commission = ConsoleInput.getDouble();
						empObj[count] = new SalesPerson(name,address,age,gender,salary,commission);
						count++;
					}
					if(addChoice == 4)
						break;
					break;
					
				case 2:
					System.out.println("1 -> All Employees");
					System.out.println("2 -> First Employee");
					System.out.println("3 -> Nexf Employee");
					System.out.println("4 -> Prev Employee");
					System.out.println("5 -> Last Employee");
					System.out.println("6 -> Exit to main menu");
					System.out.println("Enter choice");
					int dispChoice = ConsoleInput.getInt();
					if(dispChoice == 1) {
						for(int iTemp =0 ; iTemp < count ; iTemp++) {
							empObj[iTemp].display();
							System.out.println();
						}
					}
					if(dispChoice == 2) {
						if (count > 0)
							empObj[currentIndex].display();
						else
							System.out.println("No Employees yet");
						
					}
					if(dispChoice == 3) {
						if(currentIndex < count -1) {
							currentIndex++;
							empObj[currentIndex].display();
						}
						else
							System.out.println("No next employee");
					}
					if(dispChoice == 4) {
						if(currentIndex > 0) {
							currentIndex--;
							empObj[currentIndex].display();
						}
						else
							System.out.println("No pervious empliuee");
						
					}
					if(dispChoice == 5) {
						if(count > 0) {
							currentIndex = count -1;
							empObj[currentIndex].display();
						}
						else
							System.out.println("No last employee");
					}
					if(dispChoice == 6)
						break;
					break;
					
				case 3:
					System.out.println("1 -> All Managers");
					System.out.println("2 -> All Engineers");
					System.out.println("3 -> All Sales Person");
					System.out.println("4 -> All Employees Alphabetic order ascending");
					System.out.println("5 -> All Employees Alphabetic order descending");
					System.out.println("6 -> Exit to main menu");
					System.out.println("Enter choice");
					int sortChoice = ConsoleInput.getInt();
					if(sortChoice == 1) {
						Employee tempObj[] = new Employee[count];
						int tempCount = 0;
						for(int iTemp = 0 ; iTemp < count ; iTemp ++) {
							if(empObj[iTemp].type == 1) {
								tempObj[tempCount] = empObj[iTemp];
								tempCount++;
							}
						}
						//swap if alphabetically larger
						for(int iTemp = 0 ; iTemp < tempCount - 1 ; iTemp++) {
							for(int jTemp = iTemp + 1 ; jTemp < tempCount  ; jTemp ++ ) {
								if(tempObj[iTemp].name.compareTo(tempObj[jTemp].name) > 0) {
									Employee temp = tempObj[iTemp];
									tempObj[iTemp] = tempObj[jTemp];
									tempObj[jTemp] = temp;
								}
							}
						}
						
						for(int iTemp = 0; iTemp < tempCount; iTemp++)
					    {
					        //only name
					        System.out.println(tempObj[iTemp].name);
					    }
					}
					if(sortChoice == 2) {
						Employee tempObj[] = new Employee[count];
						int tempCount = 0;
						for(int iTemp = 0 ; iTemp < count ; iTemp ++) {
							if(empObj[iTemp].type == 2) {
								tempObj[tempCount] = empObj[iTemp];
								tempCount++;
							}
						}
						//swap if alphabetically larger
						for(int iTemp = 0 ; iTemp < tempCount - 1 ; iTemp++) {
							for(int jTemp = iTemp + 1 ; jTemp < tempCount  ; jTemp ++ ) {
								if(tempObj[iTemp].name.compareTo(tempObj[jTemp].name) > 0) {
									Employee temp = tempObj[iTemp];
									tempObj[iTemp] = tempObj[jTemp];
									tempObj[jTemp] = temp;
								}
							}
						}
						
						for(int iTemp = 0; iTemp < tempCount; iTemp++)
					    {
					        //only name
					        System.out.println(tempObj[iTemp].name);
					    }
					}
					if(sortChoice == 3) {
						Employee tempObj[] = new Employee[count];
						int tempCount = 0;
						for(int iTemp = 0 ; iTemp < count ; iTemp ++) {
							if(empObj[iTemp].type == 3) {
								tempObj[tempCount] = empObj[iTemp];
								tempCount++;
							}
						}
						//swap if alphabetically larger
						for(int iTemp = 0 ; iTemp < tempCount - 1 ; iTemp++) {
							for(int jTemp = iTemp + 1 ; jTemp < tempCount  ; jTemp ++ ) {
								if(tempObj[iTemp].name.compareTo(tempObj[jTemp].name) > 0) {
									Employee temp = tempObj[iTemp];
									tempObj[iTemp] = tempObj[jTemp];
									tempObj[jTemp] = temp;
								}
							}
						}
						
						for(int iTemp = 0; iTemp < tempCount; iTemp++)
					    {
					        //only name
					        System.out.println(tempObj[iTemp].name);
					    }
					}
					if(sortChoice==4) {
						for(int iTemp = 0; iTemp < count-1 ; iTemp++) {
							for(int jTemp = iTemp + 1; jTemp < count-1 ; jTemp++) {
								if(empObj[iTemp].name.compareTo(empObj[jTemp].name) > 0)
					            {
					                Employee temp = empObj[iTemp];
					                empObj[iTemp] = empObj[jTemp];
					                empObj[jTemp] = temp;
					            }
							}
						}
						
						for(int iTemp = 0; iTemp < count; iTemp++)
					    {
					        //only name
					        System.out.println(empObj[iTemp].name);
					    }
					}
					if(sortChoice==5) {
						for(int iTemp = 0; iTemp < count-1 ; iTemp++) {
							for(int jTemp = iTemp + 1; jTemp < count ; jTemp++) {
								if(empObj[iTemp].name.compareTo(empObj[jTemp].name) < 0)
					            {
					                Employee temp = empObj[iTemp];
					                empObj[iTemp] = empObj[jTemp];
					                empObj[jTemp] = temp;
					            }
							}
						}
						
						for(int iTemp = 0; iTemp < count; iTemp++)
					    {
					        //only name
					        System.out.println(empObj[iTemp].name);
					    }
					}
					if(sortChoice == 6)
						break;
					break;
				case 4:
					return;
				default:
					System.out.println("Invalid choice");
			}
		}
	}

}



class Employee{
	protected String name;
	protected String address;
	protected int age;
	protected String gender;
	protected double salary;
	protected int type;
	
	Employee(String name, String address, int age, String gender , double salary){
		this.name = name;
		this.address = address;
		setAge(age);
		setGender(gender);
		this.salary = salary;
	}
	
	public void setAge(int age)
    {
        if(age >= 18 && age <= 60)
            this.age = age; 
        else
            System.out.println("Invalid age");
    }

    public void setGender(String gender)
    {
        if(gender.equals("Male") || gender.equals("Female"))
            this.gender = gender;
        else
            System.out.println("Invalid gender");
    }
	
	
	public void display() {
		System.out.println("Name : " + name);
		System.out.println("Address : " + address);
		System.out.println("Age : " + age);
		System.out.println("Gender : " + gender);
		System.out.println("Salary : " + salary);
	}
	
}

class Manager extends Employee{
	private double hra;
		
	Manager(String name, String address, int age, String gender , double salary, double hra){
		super(name,address,age,gender,salary);
		this.hra=hra;
		this.type = 1;
	}
	
	public void display() {
		super.display();
		System.out.println("Hra : " +hra);
		
	}	
}

class Engineer extends Employee{
	private int overTime;
		
	Engineer(String name, String address, int age, String gender , double salary, int overTime){
		super(name,address,age,gender,salary);
		this.overTime=overTime;
		this.type = 2;
	}
	
	public void display() {
		super.display();
		System.out.println("OverTime : " +overTime);
	}	
}

class SalesPerson extends Employee{
	private double commission;
		
	SalesPerson(String name, String address, int age, String gender , double salary, double commission){
		super(name,address,age,gender,salary);
		this.commission=commission;
		this.type = 3;
	}
	
	public void display() {
		super.display();
		System.out.println("Commission : " +commission);
	}	
}