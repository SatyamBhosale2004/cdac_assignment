#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

int main(int argc , char *argv[]){
    int cn=0,cw=0,cc=0,cs=0;
    // int warn_threshold, critical_threshold, num_readings;
    srand(time(0));
    if(argc !=4 ){
        cout << "Usage : " << "./sensor_monitor" << " <warn_threshold> " << " <critical_threshold> " << " <num_readings> " << endl;
        cout << "Error : " << "Missing arguments." << endl;
        return 1;
    }else if((stoi(argv[1])) >= stoi(argv[2])){
        cout << "Error : " << "Warn thres higher than crit." << endl;
        return 1;
    }else if(stoi(argv[3])<1 || stoi(argv[3]) > 500){
        cout << "Error : " << "Invalid num of readings." << endl;
        return 1;
    }else {
        for(int i =0 ; i < stoi(argv[3]) ; i++){
            int random = rand() % 70;
            if(random < stoi(argv[1]))
                cn++;
            if(random >= stoi(argv[1]) && random < stoi(argv[2]))
                cw++;
            if(random >= stoi(argv[2]) && random < 60)
                cc++;
            if(random >= 60)
                cs++;
        }
        cout << "Config " << " : " << " Warn = " << argv[1] << (char)248 << "C" << " Critical = " << argv[2] << (char)248 << "C" << " Readings = " << argv[argc-1] << endl;
        cout << "Results " << " : " << " Normal : " << cn  << " Warning : " << cw << " Critical : " << cc <<  " Shutdown : " << cs  << endl;
    }   

    return 0;
}
