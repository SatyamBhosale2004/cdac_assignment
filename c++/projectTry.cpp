#include<iostream>
#include<iomanip>
#include<vector>

using namespace std;

class Student{
    int rollNumber;
    string name;
    double percentage;
    static int totalStudents;

    public:
        Student(int roll, const string& studentName){
            percentage = 0;
            totalStudents++;
            rollNumber = roll;
            name = studentName;
            cout << "[Student Created] Roll: "<< rollNumber << " , Name: " << name << endl;
        }
        Student(const Student& other){
            rollNumber = other.rollNumber;
            name = other.name;
            percentage = other.percentage;
            totalStudents++;
            cout << "[Copy Constructor Called]" << endl;
        }
        ~Student(){
            cout << "[Student Deleted] Roll: " << rollNumber << " , Name : " << name << endl; 
            totalStudents--;
        }
        void setPercentage(double percent){
            if(percent >=0 && percent <= 100){
                
                percentage = percent;
            }else{
                cout << "Invalid" << endl;
            }
            
        }
        double getPercentage() const{
            return percentage;
        }
        string getName() const{
            return name;
        }
        char calculateGrade() const {
            if(percentage >= 80 && percentage <=100){
                return 'A';
            }else if(percentage >=70){
                return 'B';
            }else if(percentage >=60 ){
                return 'C';
            }else if(percentage >= 50){
                return 'D';
            }else {
                return 'F';
            }
        }
        friend ostream& operator<< (ostream& out, const Student &other){
            out << left << "Roll: " << setw(10) <<  other.rollNumber << "Name: " << setw(10) <<  other.name << "Percentage: " << setw(10) << other.percentage << "Grade: " << setw(10) << other.calculateGrade() << endl; 
            return out; 
        }
        bool operator==(const Student &other)const{
            return rollNumber == other.rollNumber;
        }
        static int getTotalStudents(){
            return totalStudents;
        }
};
int Student::totalStudents=0;

int main(){
    vector<Student> v;
    v.emplace_back(101,"Raj Kumar");
    v.emplace_back(102,"Priya Singh");
    v.emplace_back(103,"Arun Patel");
    v.emplace_back(104,"Deepa Sharma");
    v.emplace_back(105,"Vikram Singh");
    v[0].setPercentage(86.6);
    v[1].setPercentage(90.8);
    v[2].setPercentage(70.0);
    v[3].setPercentage(80.0);
    v[4].setPercentage(55.0);
    for(int i=0;i<v.size();i++){
        cout << v[i] << endl;
    }
    cout << "Total Students : " << Student::getTotalStudents() << endl;

    int highest = 0, lowest = 0;
    for(int i=1;i<v.size();i++){
        if(v[highest].getPercentage() < v[i].getPercentage()){
            highest = i;
        }
        if(v[lowest].getPercentage() > v[i].getPercentage()){
            lowest = i;
        }
    }
    cout << "Highest Percentage: " << v[highest].getName() << " ( " << v[highest].getPercentage() << " )" << endl;
    cout << "Lowest Percentage: " << v[lowest].getName() << " ( " << v[lowest].getPercentage() << " )" << endl;
    int A=0,B=0,C=0,D=0,F=0;
    for(const Student &s : v){
        switch(s.calculateGrade()){
            case 'A' :
                A++;
                break;
            case 'B' :
                B++;
                break;
            case 'C' :
                C++;
                break;
            case 'D' :
                D++;
                break;
            case 'F' :
                F++;
                break;
            default :
                cout << "Invalid Grade" << endl;
        }
    }
    cout << "Grade Distribution : " << endl;
    if(A > 0)
        cout << "Grade A : " << A << "Student" <<(A>1 ? "s" : "") << endl;
    if(B > 0)
        cout << "Grade B : " << B << "Student" <<(B>1 ? "s" : "") << endl;
    if(C > 0)
        cout << "Grade C : " <<C << "Student" <<(C>1 ? "s" : "") << endl;
    if(D > 0)
        cout << "Grade D : " << D << "Student" <<(D>1 ? "s" : "") << endl;
    if(F > 0)
        cout << "Grade F : " << F << "Student" <<(F>1 ? "s" : "") << endl;
    Student v1 = v[0];
    if(v1 == v[0]){
        cout << "Copied student has same rollNo" << endl;
    }
    cout << "Total students after copy : " << Student::getTotalStudents() << endl;

    return 0;
}


