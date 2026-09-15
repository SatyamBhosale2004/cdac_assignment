
public class MenuOptimized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee empObj[] = new Employee[50];
		int currentIndex = -1;
		int count =0;
		boolean flag = true;
        final int ADD_EMPLOYEE = 1;
        final int DISPLAY_EMPLOYEE = 2;
        final int SORT_EMPLOYEE = 3;
        final int EXIT_MAIN = 4;

        
		while(flag) {
	
			System.out.println("=============Menu=============");
			System.out.println("1 -> Add Employee");
			System.out.println("2 -> Display Employee Details");
			System.out.println("3 -> Sort");
			System.out.println("4 -> Exit");
			System.out.println("Enter your choice");
			int choice = ConsoleInput.getInt();
			switch(choice) {
				case ADD_EMPLOYEE:
                    final int ADD_MANAGER = 1;
                    final int ADD_ENGINEER = 2;
                    final int ADD_SALES_PERSON = 3;
                    final int EXIT_ADD = 4; 

					System.out.println("1 -> Add Manager");
					System.out.println("2 -> Add Engineer");
					System.out.println("3 -> Add Sales Person");
					System.out.println("4 -> Exit to main menu");
                
					System.out.println("Enter choice");
					int addChoice = ConsoleInput.getInt();
                    //common details
                    if(addChoice == ADD_MANAGER || addChoice == ADD_ENGINEER || addChoice == ADD_SALES_PERSON)
                    {
                        System.out.println("Enter Employee name");
                        String name = ConsoleInput.getString();

                        System.out.println("Enter Employee address");
                        String address = ConsoleInput.getString();

                        System.out.println("Enter Employee age");
                        int age = ConsoleInput.getInt();

                        System.out.println("Enter Employee gender (Enter Male or Female)");
                        String gender = ConsoleInput.getString();

                        System.out.println("Enter Employee salary");
                        double salary = ConsoleInput.getDouble();

                        if(addChoice == ADD_MANAGER)
                        {
                            System.out.println("Enter Manager HRA");
                            double hra = ConsoleInput.getDouble();

                            empObj[count] = new Manager(name, address, age, gender, salary, hra);
                            count++;
                        }
                        else if(addChoice == ADD_ENGINEER)
                        {
                            System.out.println("Enter Engineer overtime");
                            int overTime = ConsoleInput.getInt();

                            empObj[count] = new Engineer(name, address, age, gender, salary, overTime);
                            count++;
                        }
                        else if(addChoice == ADD_SALES_PERSON)
                        {
                            System.out.println("Enter Sales Person commission");
                            double commission = ConsoleInput.getDouble();

                            empObj[count] = new SalesPerson(name, address, age, gender, salary, commission);
                            count++;
                        }
                    }
					if(addChoice == EXIT_ADD)
						break;
					break;
					
				case DISPLAY_EMPLOYEE:
                    final int ALL_EMPLOYEES = 1;
                    final int FIRST_EMPLOYEES = 2;
                    final int NEXT_EMPLOYEES = 3;
                    final int PREV_EMPLOYEES = 4;
                    final int LAST_EMPLOYEES = 5;
                    final int EXIT_DISP = 6;

					System.out.println("1 -> All Employees");
					System.out.println("2 -> First Employee");
					System.out.println("3 -> Next Employee");
					System.out.println("4 -> Prev Employee");
					System.out.println("5 -> Last Employee");
					System.out.println("6 -> Exit to main menu");
					System.out.println("Enter choice");
					int dispChoice = ConsoleInput.getInt();
					// if(dispChoice == ALL_EMPLOYEES || dispChoice == FIRST_EMPLOYEES || dispChoice == NEXT_EMPLOYEES || dispChoice == PREV_EMPLOYEES || dispChoice == LAST_EMPLOYEES) {
					// 	if(count > 0)
                    //         for(int iTemp =0 ; iTemp < count ; iTemp++) {
                    //             System.out.println(empObj[iTemp].getName());
                    //             System.out.println(empObj[iTemp].getAddress());
                    //             System.out.println(empObj[iTemp].getAge());
                    //             System.out.println(empObj[iTemp].getGender());
                    //             System.out.println(empObj[iTemp].getSalary());
                    //             if(empObj[iTemp] instanceof Manager){
                    //                 Manager objManager = (Manager) empObj[iTemp];
                    //                 System.out.println(objManager.getHra());
                    //                 System.out.println("It's a Manager");
                    //             }  
                    //             if(empObj[iTemp] instanceof Engineer){
                    //                 Engineer objEngineer = (Engineer) empObj[iTemp];
                    //                 System.out.println(objEngineer.getOverTime());
                    //                 System.out.println("It's an Engineer");
                    //             } 
                    //             if(empObj[iTemp] instanceof SalesPerson){
                    //                 SalesPerson objSalesPerson = (SalesPerson) empObj[iTemp];
                    //                 System.out.println(objSalesPerson.getCommission());
                    //                 System.out.println("It's a Sales Person");
                    //             }   
                    //             System.out.println();
                    //         }
					// }
                    if(dispChoice == ALL_EMPLOYEES) {
						for(int iTemp =0 ; iTemp < count ; iTemp++) {
							displayEmployee(empObj[iTemp]);
							System.out.println();
						}
					}
					if(dispChoice == FIRST_EMPLOYEES) {
						if (count > 0){
                            currentIndex = 0;
							displayEmployee(empObj[currentIndex]);
                        }
                        else
							System.out.println("No Employees yet");
						
					}
					if(dispChoice == NEXT_EMPLOYEES) {
						if(currentIndex < count -1) {
							currentIndex++;
							displayEmployee(empObj[currentIndex]);
						}
						else
							System.out.println("No next employee");
					}
					if(dispChoice == PREV_EMPLOYEES) {
						if(currentIndex > 0) {
							currentIndex--;
							displayEmployee(empObj[currentIndex]);
						}
						else
							System.out.println("No pervious empliuee");
						
					}
					if(dispChoice == LAST_EMPLOYEES) {
						if(count > 0) {
							currentIndex = count -1;
							displayEmployee(empObj[currentIndex]);
						}
						else
							System.out.println("No last employee");
					}
					if(dispChoice == EXIT_DISP)
						break;
					break;
					
				case SORT_EMPLOYEE:
                    final int ALL_MANAGERS = 1;
                    final int ALL_ENGINEERS = 2;
                    final int ALL_SALES_PERSON = 3;
                    final int ALL_EMP_IN_ASCENDING = 4;
                    final int ALL_EMP_IN_DESCENDING = 5;
                    final int EXIT_SORT = 6;

					System.out.println("1 -> All Managers");
					System.out.println("2 -> All Engineers");
					System.out.println("3 -> All Sales Person");
					System.out.println("4 -> All Employees Alphabetic order ascending");
					System.out.println("5 -> All Employees Alphabetic order descending");
					System.out.println("6 -> Exit to main menu");

					System.out.println("Enter choice");
					int sortChoice = ConsoleInput.getInt();
                    
					if(sortChoice == ALL_MANAGERS) {
						Employee tempObj[] = new Employee[count];
						int tempCount = 0;
						for(int iTemp = 0 ; iTemp < count ; iTemp ++) {
							if(empObj[iTemp] instanceof Manager) {
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
					if(sortChoice == ALL_ENGINEERS) {
						Employee tempObj[] = new Employee[count];
						int tempCount = 0;
						for(int iTemp = 0 ; iTemp < count ; iTemp ++) {
							if(empObj[iTemp] instanceof Engineer) {
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
					if(sortChoice == ALL_SALES_PERSON) {
						Employee tempObj[] = new Employee[count];
						int tempCount = 0;
						for(int iTemp = 0 ; iTemp < count ; iTemp ++) {
							if(empObj[iTemp] instanceof SalesPerson) {
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
					if(sortChoice== ALL_EMP_IN_ASCENDING) {
						for(int iTemp = 0; iTemp < count-1 ; iTemp++) {
							for(int jTemp = iTemp + 1; jTemp < count ; jTemp++) {
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
					if(sortChoice == ALL_EMP_IN_DESCENDING) {
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
					if(sortChoice == EXIT_SORT)
						break;
					break;
				case EXIT_MAIN:
					flag = false;
                    break;
				default:
					System.out.println("Invalid choice");
			}
		}
	}
    //display common logic
        static void displayEmployee(Employee emp)
        {
            System.out.println("Name : " +emp.getName());
            System.out.println("Address : " +emp.getAddress());
            System.out.println("Age : " +emp.getAge());
            System.out.println("Gender : " +emp.getGender());
            System.out.println("Salary : " +emp.getSalary());

            if(emp instanceof Manager)
            {
                Manager obj = (Manager)emp;
                System.out.println(obj.getHra());
                System.out.println("It's a Manager");
            }
            else if(emp instanceof Engineer)
            {
                Engineer obj = (Engineer)emp;
                System.out.println(obj.getOverTime());
                System.out.println("It's an Engineer");
            }
            else if(emp instanceof SalesPerson)
            {
                SalesPerson obj = (SalesPerson)emp;
                System.out.println(obj.getCommission());
                System.out.println("It's a Sales Person");
            }
            System.out.println();
        }

}



class Employee{
	protected String name;
	protected String address;
	protected int age;
	protected String gender;
	protected double salary;
	
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

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        return gender;
    }

    public double getSalary(){
        return salary;
    }
	
}

class Manager extends Employee{
	private double hra;
		
	Manager(String name, String address, int age, String gender , double salary, double hra){
		super(name,address,age,gender,salary);
		this.hra=hra;
	}
	
    public double getHra(){
        return hra;
    }
}

class Engineer extends Employee{
	private int overTime;
		
	Engineer(String name, String address, int age, String gender , double salary, int overTime){
		super(name,address,age,gender,salary);
		this.overTime=overTime;
	}
	
    public int getOverTime(){
        return overTime;
    }
}

class SalesPerson extends Employee{
	private double commission;
		
	SalesPerson(String name, String address, int age, String gender , double salary, double commission){
		super(name,address,age,gender,salary);
		this.commission=commission;
	}
	
    public double getCommission(){
        return commission;
    }
}