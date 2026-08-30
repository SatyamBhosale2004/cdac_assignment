#include<iostream>
#include<iomanip>
using namespace std;

class Employee{
    private:
        int empId;
        string name;
        string department;
        char grade;
        double basicSalary;
        bool isActive = true;
        static int employeeCount;

    public:
        // setters
        void setBasicSalary(double salary){
            if(salary >= 10000 && salary <= 500000){
                basicSalary = salary;
            } else {
                cout << "ERROR: Salary must be between Rs.10,000 and Rs.5,00,000. Value rejected" << endl;
                return;
            }
        }

        void setName(const string &n){
            if(n != ""){
                name = n;
            }
        }

        void setDepartment(const string &dept){
            if(dept == "Engineering" || dept == "HR" || dept == "Finance" || dept== "Operations"){
                department = dept;
            } else {
                cout << "ERROR: ' " << dept << " ' is not a registered department." << endl;
                return;
            }
        } 

        void setGrade(char g){
            if(g == 'A' || g == 'B' || g == 'C' || g == 'D'){
                grade = g;
            } else {
                cout << "ERROR: Invalid grade ' " << g << " '. Accepted values: A, B, C, D." << endl;
                return;
            }
        }

        void deactivate(){
            isActive = false;
        }
        //getters
        int getEmpId() const {
                return empId;
        }
        string getName() const{
            return name;
        }
        string getDepartment() const{
            return department;
        }
        char getGrade() const{
            return grade;
        }
        double getBasicSalary() const{
            return basicSalary;
        }
        bool getIsActive() const{
            return isActive;
        }
        //business logic

        double computeAllowances() const{
            if(grade == 'A'){
                return basicSalary * 0.4;
            } else if (grade == 'B'){
                return basicSalary * 0.3;
            }else if (grade =='C'){
                return basicSalary * 0.2;
            }else if (grade == 'D'){
                return basicSalary * 0.1;
            }
            return 0;
        }
        double computeGrossSalary() const{
            return basicSalary + computeAllowances();
        }

        double computeTax() const{
            double gross = computeGrossSalary();
            if(gross <= 50000){
                return 0;
            } else if(gross >= 50001 && gross <= 100000){
                return 0.1* (gross - 50000);
            } else if(gross > 100000){
                return 5000 + 0.2* (gross - 100000);
            }
            return 0;
        }

        double computeNetSalary() const{
            return computeGrossSalary() - computeTax();
        }

        void printPayslip() const{
            int allowancePercent = 0;

            if (grade == 'A') allowancePercent = 40;
            else if (grade == 'B') allowancePercent = 30;
            else if (grade == 'C') allowancePercent = 20;
            else if (grade == 'D') allowancePercent = 10;

            cout << "============================================================================" << endl;
            cout << left << setw(20)<< " " <<"Employee Payslip - AUG 2026 " << endl;
            cout << "============================================================================" << endl;
            cout << left << setw(15) << "Emp Id" << " : " << empId << endl;
            cout << left << setw(15) << "Name" << " : " << name << endl;
            cout << left << setw(15) << "Department" << " : " << department << endl;
            cout << left << setw(15) << "Grade" << " : " << grade << endl;
            cout << left << setw(15) << "Status" << " : " << (isActive  ? "Active" : "Inactive")  << endl;
            cout << "----------------------------------------------------------------------------" << endl;
            cout << left << setw(15) << fixed << setprecision(2) << "Basic Salary" << " : " << "Rs. " << basicSalary << endl;
            cout << left << setw(15) << fixed << setprecision(2) << ("Allowances(" + std::to_string(allowancePercent) + "%) : ") << "Rs. " << computeAllowances() << endl;
            cout << left << setw(15) << fixed << setprecision(2) << "Gross Salary" << " : " << "Rs. " << computeGrossSalary() << endl;
            cout << "----------------------------------------------------------------------------" << endl;
            cout << left << setw(15) << fixed << setprecision(2) << "Tax Deduction" << " : " << "Rs. " << computeTax() << endl;
            cout << left << setw(15) << fixed << setprecision(2) << "Net Salary" << " : " << "Rs. " << computeNetSalary() << endl;
            cout << "============================================================================" << endl;

        }
        static int getEmployeeCount(){
            return employeeCount;
            
        }   
        Employee(){
            employeeCount++;
            empId = 1000 + employeeCount;
        }
        void acceptDetails(){
            string n , dept;
            char g;
            double salary;
            cout << "Enter Name" << endl;
            getline(cin >> ws, n);
            setName(n);
            cout << "Enter Department" << endl;
            cin >> dept;
            setDepartment(dept);
            cout << "Enter Grade" << endl;
            cin >> g;
            setGrade(g);
            cout << "Enter Salary" << endl;
            cin >> salary;
            setBasicSalary(salary);
        }
};
int Employee::employeeCount = 0;

int main(){

    // Create objects — one on stack, two on heap
    Employee e1;
    Employee* e2 = new Employee();
    Employee* e3 = new Employee();
    e1.acceptDetails();
    e2->acceptDetails();
    e3->acceptDetails();
 // Try uncommenting — observe the compiler error, then explain in a comment
// why
//  e1.empId = 999;
//  e1.basicSalary = -1000;
// error says they are inaccessible its cause we trying to change private members so cant be accessed only via encapsulations getters and setters
    e1.printPayslip();
    e2->printPayslip();
    e3->printPayslip();
 // Simulate a resignation
    e3->deactivate();
    if (!e3->getIsActive())
        cout << e3->getName() << " is no longer active. Payroll skipped." << endl;
    cout << "Total Employees : " << Employee::getEmployeeCount() << endl;
    delete e2;
    delete e3;

    return 0;
}
