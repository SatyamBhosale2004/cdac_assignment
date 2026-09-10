
public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date obj = new Date();
		
		boolean flag = true;
		while(flag) {
	
			System.out.println("=============Menu=============");
			System.out.println("1 -> Set Date");
			System.out.println("2 -> Add Days");
			System.out.println("3 -> Add Months");
			System.out.println("4 -> Add Years");
			System.out.println("5 -> Display");
			System.out.println("6 -> Compare Dates");
			System.out.println("7 -> Exit");
			System.out.println("Enter your choice");
			int choice = ConsoleInput.getInt();
			switch(choice) {
				case 1 :
					System.out.println("Enter year");
					int year = ConsoleInput.getInt();
					System.out.println("Enter month");
					int month = ConsoleInput.getInt();
					System.out.println("Enter day");
					int day = ConsoleInput.getInt();
					obj.setDate(day, month, year);
					break;
				case 2 :
					System.out.println("Enter amount of days you want to add");
					int addD = ConsoleInput.getInt();
					obj.addDays(addD);
					break;
				case 3 :
					System.out.println("Enter amount of months you want to add");
					int addM = ConsoleInput.getInt();
					obj.addMonths(addM);
					break;
				case 4 :
					System.out.println("Enter amount of years you want to add");
					int addY = ConsoleInput.getInt();
					obj.addYears(addY);
					break;
				case 5 :
					obj.display();
					break;
				case 6 :
					obj.compareDates();
					break;
				case 7 :
					System.out.println("You have exited the menu");
					flag = false;
					break;
				default :
					flag = false;
					System.out.println("Invalid Choice");
					break;
			}
		}
	}
}
