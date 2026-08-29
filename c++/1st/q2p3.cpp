#include<iostream>
using namespace std;

int main(){
    int statusReg = 0b10110001;
    int controlReg = 0b10110001;
    int dataReg = 0b10110001;
    int temp = 0;

    const int* regPtr1 = &statusReg;
    cout << "Before changing ptr1 : " << *regPtr1 << endl;
    // *regPtr1 = 1; error : expression must be modifiable lvalue
    cout <<  "Before changing add ptr1 : " << regPtr1 << endl;
    regPtr1 = &temp;
    cout <<  "After changing add ptr1 : " << regPtr1 << endl; 
    // no error can repoint
    
    int *const regPtr2 = &controlReg;
    cout << "Before changing ptr2 : " << *regPtr2 << endl;
    *regPtr2 = 1;
    cout << "After changing ptr2 : " << *regPtr2 << endl; 
    // no error as we can change value
    // regPtr2 = &temp;
    // error : exp must be modifiable lvalue
    const int *const regPtr3 = &dataReg;
    //same error for both 
    // *regPtr3 = 2; 
    // regPtr3 = &temp;
    cout << "Before changing ptr3 : " << *regPtr3 << endl; 
    return 0;
}
