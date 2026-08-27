#include<iostream>
#include<iomanip>
using namespace std;

int main(){
    double temp;//input
    cout << "Enter temp" << endl;
    cin >> temp;
    double tempf = (temp*(9.0/5.0) + 32);//temp in fahreneit
    int sc;//statuscode
    cout << left  << setw(15) << "Temperature" << ": " << temp << " / " << tempf << endl;
    if(temp < 0){
        sc = -1;
    }else if(temp >= 0 && temp <=29){
        sc = 0;
    }else if(temp >= 30 && temp <= 44){
        sc = 1;
    }else if(temp >= 45 && temp <= 59){
        sc = 2;
    }else{
        sc = 3;
    } 
    switch(sc){
        case -1 : 
            cout << left  << setw(15) << "Status" << ":" << " SENSOR_ERROR" << endl;
            cout << left  << setw(15) << "Action" << ":" << " Sensor fault-check writing" << endl;
            break;
        case 0 : 
            cout << left  << setw(15) << "Status" << ":" << " NORMAL" << endl;
            cout << left  << setw(15) << "Action" << ":" << " No action required" << endl;
            break;
        case 1 : 
            cout << left  << setw(15) << "Status" << ":" << " WARNING" << endl;
            cout << left  << setw(15) << "Action" << ":" << " Alert sent to supervisor" << endl;
            break;
        case 2 : 
            cout << left  << setw(15) << "Status" << ":" << " CRITICAL" << endl;
            cout << left  << setw(15) << "Action" << ":" << " Cooling system triggered" << endl;
            break;
        case 3 : 
            cout << left  << setw(15) << "Status" << ":" << " SHUTDOWN" << endl;
            cout << left  << setw(15) << "Action" << ":" << " Emergency shutdown initiated" << endl;
            break;
        default : 
            cout << "Invalid code";
            break;

    (temp >= 25) ? cout << left << setw(15) << "Reading" << ":" << "Above Average" << endl : cout << setw(15) << "Reading" << ":" << "Below Average" << endl;

    }
    return 0;
}
