#include <iostream>
#include <iomanip>
using namespace std;

double** reading(int &n){
    double** arr = new double*[n]; // pointer to row pointer basically *arr was pointer to heap here **arr means pointer to  pointer 
    for(int i =0; i < n ; i++){
        arr[i] = new double[n];// here arr[i] which is row but is still a pointer should have value not *double or it will be adress in address
    }
    for(int i =0;i<n;i++){
        for(int j=0;j<n;j++){
            cout << "Enter Floor " << i+1 << " Room " << j+1 << endl;
            cin >> arr[i][j];
        }
    }
    cout << left << setw(20) << " " ;
    for(int i =0 ;i<n;i++){
        cout <<left << setw(15)<< ("Room"+ to_string(i + 1)) << " " ;
    }
    cout << endl;
    for(int i =0 ;i<n;i++){
        cout << left  <<setw(15) << ("Floor"+ to_string(i+1)) << " : ";
        for(int j = 0 ;j< n ;j++){
            cout <<  setw(20) <<arr[i][j]   ;
        }
        cout << endl;
    }
    return arr;
}


void hotr(double** arr, int n){
    double max1;
    int fi1,fi2,ri;//floor and room index;
    double max2 = arr[0][0];
    double avg1 = 0;
    double avg2 = 0;
    double sum = 0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(max2 < arr[i][j]){
                max2 = arr[i][j];
                fi1 = j;
                ri = i;
            }    
            sum += arr[i][j] ;
        }
        avg1 = sum/n;
        sum=0;
        if (avg2 < avg1){
            avg2 = avg1;
            fi2 = i;
        }
        
    }
    cout<<endl;
    cout << left << "Hottest Room" << " : " << "Floor " << fi1+1 << " Room " << ri+1 << " -> " << max2 << endl;
    cout<<endl;
    cout << left << "Hottest Floor" << " : " << "Floor " << fi2+1 << " (avg " << avg2 << (char)248 << "C" << " )" << endl;
}

void warn(double** arr, int n){
    int c=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(arr[i][j] < 0){
                continue;
            }else if(arr[i][j] >= 0 && arr[i][j] <=29){
                continue;
            }else if(arr[i][j] >= 30 && arr[i][j] <= 44){
                c++;
            }else if(arr[i][j] >= 45 && arr[i][j] <= 59){
                c++;
            }else{
                c++;
            }
        }
    }
    cout<<endl;
    cout << left << "Rooms at Warning or above : " << c << endl;
}

int main(){
    int n;
    cout << "Enter Number Of Floors" << endl;
    cin >> n;
    double** arr = reading(n);
    hotr(arr,n);
    warn(arr,n);
}
