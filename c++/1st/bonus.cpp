#include<iostream>
using namespace std;

    struct Layout1 { char c1; int i; char c2; };
    struct Layout2 { int i; char c1; char c2; };

int main(){



    cout << "Layout 1 : " << sizeof(Layout1) << endl;
    // got 12 
    // because char is 1 int is 4 so
    // 0(usedbit)(char) 1 2 3(padding of 3) 4 5 6 7(int) 8(char) 0 0 0(padding of 3)   (cuz 32 bit system 4 bits padding is done to make it into 4 bits format) 4 + 4 + 1 + 3 = 12 
    cout << "Layout 1 : " << sizeof(Layout2) << endl;
    // because char is 1 int is 4 so
    // 0 1 2 3(int) 4 (char) 5(char) 0 0(padding of 2)  4 + 1 + 1 + 2 = 8
    return 0;
}

