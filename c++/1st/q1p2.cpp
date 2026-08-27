#include<iostream>
#include<iomanip>
using namespace std;

double* reading(int &n){
    
    int count=0;
    int invalid = 0;
    cout << left << setw(20) << "Enter array size : ";
    cin >> n;
    double* arr = new double[n];//readings array
    
    for(int i = 0; i < n ; i++){
        cout << "Enter " << i << " index element" << endl;
        cin >> arr[i];
        count++;
        
    } 
    cout << left << setw(20) << "Reading" << ": " << count << endl; 

    cout << left << setw(20) << "Valid Readings" << ": ";
    for(int i =0; i<n;i++){
        if(arr[i] < 0 ){
            invalid++ ;
            continue;
        }
        if(arr[i] >=0)
        cout << arr[i] << " ";
    }
    cout << endl;
    cout << left << setw(20) << "Skipped (errors)" << ": " << invalid << endl;
    return arr;
}

void critical(double* arr, int n){
    int count=0;
    int index;
    for(int i=0;i<n;i++){
        if(arr[i]>=45){
            count++;
        }
        if(arr[i] >= 45 && count ==1){
            cout<<endl;
            cout << left << setw(20) << "First Critical" << ": " << "Index " << i+1 << " -> " << arr[i] << (char)248 << "C" <<endl;
        } 
    }
}   

void sl(double* arr, int n){
    int cn=0 , cw=0 , cc=0 , cs = 0;
    for(int i=0;i<n;i++){
        if(arr[i] < 0){
            continue;
        }else if(arr[i] >= 0 && arr[i] <=29){
            cn++;
        }else if(arr[i] >= 30 && arr[i] <= 44){
            cw++;
        }else if(arr[i] >= 45 && arr[i] <= 59){
            cc++;
        }else{
            cs++;
        }
    }
    cout<<endl;
    cout << left << "Normal" << " : " << cn << "\tWarning" << " : " << cn << "\tCritical" << " : " << cc << "\tShutdown" << " : " << cs << endl;
}

void avg(double* arr, int n){
    double max =arr[0];
    double min =arr[0];
    double avg=0,sum=0;
    for(int i=0;i<n;i++){
        if(max < arr[i]){
            max = arr[i];
        }
        if(min > arr[i] && arr[i] >= 0){
            min = arr[i];
        }
        sum += arr[i];
    }
    avg = sum / n;
    cout<<endl;
    cout << left << "Min" << " : " << min << (char)248 << "C" << "\t Max" << " : " << max << (char)248 << "C" << "\tAvg" << " : " << avg << (char)248 << "C" << endl;
}

int main(){
    int n;
    double* arr =reading(n);
    critical(arr, n);
    avg(arr,n);
    sl(arr, n);
    delete[] arr;   
    return 0;
}

