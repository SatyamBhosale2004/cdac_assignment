#include<iostream>
#include<iomanip>
using namespace std;
class Patient{
    private :
        int patientId;
        string name;
        int age;
        string ward;
        const string bloodGroup;

    public :
        Patient() : bloodGroup("O+") { // def
            patientId = 0;
            name = "Unknown";
            age =0;
            ward = "General";
            cout << "[Constructor] " << "Default Patient registered." << endl;
        }
        Patient(int id, const string& name, int age, const string&ward, const string& bg) : bloodGroup(bg){ //full admission
            patientId= id;
            this -> name = name;
            this -> age = age;
            this -> ward = ward;
            cout << "[Constructor] " << "Full Admission: " << name << " registered." << endl;
        }
        Patient(int id, const string&name) : bloodGroup("O+"){ //emergenices
            patientId= id;
            this -> name = name;
            age =0;
            ward = "General";
            cout << "[Constructor] " << "Emergency: " << name << " registered." << endl;
        }
        ~Patient(){
            cout << "[Deconstructor] Patient " << name << " discharged" << endl; 
        }

        void displayRecord(){
            cout << "Patient Record" << endl;
            cout << left << setw(15) << "ID" << ":" << patientId << endl;
            cout << left << setw(15) << "Name" << ":" << name << endl;
            cout << left << setw(15) << "Age" << ":" << age << endl;
            cout << left << setw(15) << "Ward" << ":" << ward << endl;
            cout << left << setw(15) << "Blood Group" << ":" << bloodGroup << endl;
            cout<<endl;
        }
        void transferWard(const string &newWard){
            cout << "Ward Transfer : " << name << " -> " << newWard << endl;
        }

};

int main(){
    
    
    Patient p1(1001,"Meera Joshi",34,"Cardiology","B+");
    Patient p2(1002,"Raj Patel");
    Patient p3;
    
    
    

    Patient *patient = new Patient[4];
    
    p1.displayRecord();
    
    for(int i =0;i<4;i++){
        patient[i].displayRecord();
    }
    p2.transferWard("ICU");
    cout<<endl;
    delete[] patient;

    return 0;
}
