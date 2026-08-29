#include<iostream>
#include<cmath>
using namespace std;

inline double distanceBetween(double x1, double y1, double x2 , double y2){
    return sqrt( pow(x2-x1,2) + pow(y2-y1,2) );
}

inline double toRadians(double degree){
    return degree * (M_PI / 180.0);
}

inline double clamp(double value, double minVal, double maxVal){
    if(value < minVal){
        return minVal;
    } else if(value > maxVal){
        return maxVal;
    } else {
        return value;
    }
}


inline bool isInSafeZone(double x,double y, double cx, double cy, double radius){
    double distance = distanceBetween(cx,cy,x,y);
    if(distance <= radius){
        return true;
    }else {
        return false;
    }
}
int main(){
    double homeX = 0.0 , homeY = 0.0;
    double radius = 50;

    double x[3]= {2, 120 ,0};
    double y[3]= {8, 130,0};


    for(int i=0;i < 3;i++){
        double distance = distanceBetween(homeX,homeY,x[i],y[i]);

        cout << "Waypoint " << i+1 << endl;
        cout << "Distance : " << distance << endl;

        if(isInSafeZone(x[i],y[i],homeX,homeY,radius)){
            cout << "In safe zone" << endl;
        } else {
            cout << "Outside safe zone" << endl;
        }

    }  
    cout << "90 degrees = " << toRadians(90) << " radians " << endl;
    cout << "CLAMPED VALUE = " << clamp(120,0,100) << endl;
    return 0;
}
