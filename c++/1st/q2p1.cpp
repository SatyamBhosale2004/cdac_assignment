// input: a and b
// output: three cond one not change in cbv one change in cbr and change in cbp
// ds: a and b v1,2,3 func
// algo:   v1(){
//     take param call by value
//     swap logic using a + b
//     print output val not changes
// }
// v2 (){
//     param ref
//     same logiv print output val changed
// }
// v3 (){
//     param pointer
//     same logiv print output val changed
// }
// edge cases: same values



#include <iostream>
using namespace std;

void resetSensorPointerV1(int read1, int read2){
    
    read1 = read1 + read2;
    read2 = read1 - read2;
    read1 = read1 - read2;
    
}
void resetSensorPointerV2(int& read1, int&read2){
    
    read1 = read1 + read2;
    read2 = read1 - read2;
    read1 = read1 - read2;
    
}
void resetSensorPointerV3(int* read1, int* read2){
    
    *read1 = *read1 + *read2;
    *read2 = *read1 - *read2;
    *read1 = *read1 - *read2;
    
}

int main(){
    int read1, read2;
    cout << "Enter two readings "<< endl;
    cin >> read1 >> read2;
    cout << "---" << "V1:" << "Call by value" << "---" << endl;
    cout << "Before : " << "A = " << read1 << " B = " << read2 << endl;
    resetSensorPointerV1(read1,read2);
    cout << "After : " << "A = " << read1 << " B = " << read2 << endl;
    cout << "---" << "V2:" << "Call by ref" << "---" << endl;
    cout << "Before : " << "A = " << read1 << " B = " << read2 << endl;
    resetSensorPointerV2(read1,read2);
    cout << "After : " << "A = " << read1 << " B = " << read2 << endl;
    cout << "---" << "V3:" << "Call by pointer" << "---" << endl;
    cout << "Before : " << "A = " << read1 << " B = " << read2 << endl;
    resetSensorPointerV3(&read1,&read2);
    cout << "After : " << "A = " << read1 << " B = " << read2 << endl;
    return 0;
}
