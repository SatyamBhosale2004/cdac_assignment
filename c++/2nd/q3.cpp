#include<iostream>
#include<iomanip>
#include<cmath>
using namespace std;

class Entity{
    private:
        string name;
        int health;
        int level;
        string type;
    public:
        Entity& setName(const string& name){
            this-> name = name;
            return *this;
        }
        Entity& setHealth(int health){
            this->health=health;
            return *this;
        }
        Entity& setLevel(int level){
            this->level=level;
            return *this;
        }
        Entity& setType(const string& type){
            this->type=type;
            return *this;   
        }

        string getName() const{
            return name;
        }
        int getHealth() const{
            return health;
        }
        int getLevel() const{
            return level;
        }
        string getType() const{
            return type;
        }
        void displayInfo() const{
            cout << left << setw(20) << "Name" << setw(20) << "Health" << setw(20) << "Level" <<setw(20) << "Type" << endl;
            cout << left << setw(20) << name << setw(20) << health << setw(20) << level << setw(20) << type << endl;
            cout << endl;
        }


};
namespace Physics {
    double clamp(double val, double min, double max){
        if(val < min){
            val = min;
        } else if(val > max){
            val = max;
        }
        return val;
    } // clamp a velocity
    double lerp(double a, double b, double t){
        if(t>=0.0 && t <=1.0)
            return a + t * (b-a);
        return 0;
    } // linear interpolation for physics

}
using namespace Physics;

namespace GameMath {
    int clamp(int val, int min, int max){
        if(val < min){
            val = min;
        } else if(val > max){
            val = max;
        }
        return val;
    }// clamp an integer stat (health, level)
    double lerp(double a, double b, double t){
        if(t>=0.0 && t <=1.0)
            return a + t * (b-a);
        return 0;
    }   // lerp for UI animations

}



int main(){
    Entity player, enemy, item;
    double value;
    double startV,endV,interpolFact;
    player.setName("Aragorn").setHealth(100).setLevel(10).setType("Player");
    enemy.setName("Orc").setHealth(60).setLevel(5).setType("Enemy");
    item.setName("HealthPotion").setHealth(0).setLevel(1).setType("Item");

    cout << "Part A : " << endl;
    cout << "========================== Player Info ==========================" <<endl;
    player.displayInfo();
    cout << "========================== Enemy Info ==========================" <<endl;
    enemy.displayInfo();
    cout << "========================== Item Info ==========================" <<endl;
    item.displayInfo();

    cout << "PART B : " << endl;
    cout << "By using directive for physics " << endl;
    cout << "Enter Velocity value to clamp" << endl;
    cin >> value; 
    cout<< value <<" clamped to" << clamp(value,20.0,100.0) << endl;

    cout << "Enter Start value to lerp(Physics)" << endl;
    cin >> startV;
    cout << "Enter End value to lerp(Physics)" << endl;
    cin >> endV;
    cout << "Enter Interpolation Factor between 0 to 1 to lerp(Physics)" << endl;
    cin >> interpolFact;

    cout << startV << " Value Lerped to " << Physics::lerp(startV,endV,interpolFact) << endl;

    cout << "By :: for game math" << endl;
    cout << "clmap : " << endl;
    cout << GameMath::clamp(28,20,100) << endl;
    cout << "lerp : " << endl;
    cout << GameMath::lerp(startV,endV,interpolFact) << endl;

    int r,c;
    int cGrass = 0 , cWater = 0, cMountain =0 , cForest = 0, cDungeon = 0;
    cout << "PART C : " << endl;
    cout << "Enter no of rows for game map grid" << endl;
    cin >> r;
    cout << "Enter no of columns for game map grid" << endl;
    cin >> c;
    int** arr = new int*[r];
    for(int i=0;i<r;i++){
        arr[i] = new int [c];
    }

    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            cout << "Enter row " << i+1 << " column " << j+1 << " value" << endl;
            cin >> arr[i][j];
            if(arr[i][j] == 0 )
                cGrass++;
            if(arr[i][j] == 1 )
                cWater++;
            if(arr[i][j] == 2 )
                cMountain++;
            if(arr[i][j] == 3 )
                cForest++;
            if(arr[i][j] == 4 )
                cDungeon++;
        }
    }

    cout << "===== Game Map ( " << r << " x " << c << " ) =====" << endl;
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            cout << arr[i][j] << "\t";
        }
        cout << endl;
    }  
    

    cout << "Legend: 0=Grass 1=Water 2=Mountain 3=Forest 4=Dungeon " << endl;

    cout << "Tile Count : " << endl;
    cout << left << setw(10) << " " << setw(20) << "Grass" << " : " << cGrass << endl;
    cout << left << setw(10) << " " << setw(20) << "Water" << " : " << cWater << endl;
    cout << left << setw(10) << " " << setw(20) << "Mountain" << " : " << cMountain << endl;
    cout << left << setw(10) << " " << setw(20) << "Forest" << " : " << cForest << endl;
    cout << left << setw(10) << " " << setw(20) << "Dungeon" << " : " << cDungeon << endl;

    for(int i=0;i<r;i++){
        delete[] arr[i];
    }
    delete[] arr;
    return 0;
}
