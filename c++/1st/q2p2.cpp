// input : dynamic 1d array test signals n size gainfact
// ouput : print each function output 
// ds: pointer var func arr
// algo:
// comp(){
//     sqrt ( sum += pow(arr[i],2) / n )
// }
// norm(){
//     max =0 
//     if (max < arr[i]) max = arr[i] in for
//     for print arr but arr[i] /= n
// }
// count()[
//     1st = 0
//     if(signbit(1st) != signbit(arr[i])) count++
// ]
// apply(){
//     for print after for arr[i] *= gainf
// }
// edge cases:
// none


#include <iostream>
#include <cmath>
using namespace std;


double computeRMS(double* signal, int n){
    double sum = 0;
    double result;
    for(int i =0 ; i<n;i++){
        sum += pow(*(signal+i),2);
    }
    double mean = sum/n;
    result = sqrt(mean); 
    return result;
}

void normalise(double* signal, int n){
    double max = *(signal);
    for(int i=0;i<n;i++){
        if(max < (*signal+i)){
            max = (*signal+i);
        }
    }
    for(int i =0 ;i<n;i++){ 
        cout << *(signal+i) << " ";
    }
}

int countZeroCrossing(double* signal, int n){
    int count = 0;
    for(int i =0 ;i<n-1;i++){
        if(std::signbit(*(signal+i)) != std::signbit(*(signal + (i+1)))){
            count++;
        }
    }
    return count;
}


void applyGain(double* signal, int n , double gain){
    for(int i=0;i<n;i++){
        *(signal + i) *= gain;
    }
    for(int i =0 ;i<n;i++){ 
        cout << *(signal+i) << " ";
    }
}

int main(){
    int n;
    double gain;
    cout<< "Enter gain factor " << endl;
    cin >> gain;
    cout << "Enter num of signals " << endl;
    cin >> n;
    double* signal =  new double[n];
    for(int i=0;i<n;i++){
        cout << "Enter " << i+1 << " element " <<endl; 
        cin >> signal[i];
    }

    cout << "RMS: " << computeRMS(signal,n) << endl;
    cout << "Normalised readings : " << endl;
    normalise(signal,n);
    cout << endl;
    cout << "No of zero crossings : " << countZeroCrossing(signal,n) << endl;
    cout << "Gain factor readings : " << endl;
    applyGain(signal,n,gain);
    return 0;
}
