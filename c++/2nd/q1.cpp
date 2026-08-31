#include<iostream>
using namespace std;

class Product{
    private:
        int productId;
        string name;
        double price;
        int quantity;
        
    
    public : 
        void acceptDetails(){
            cout << "Enter product id " << endl;
            cin >> productId;
            cout << "Enter product name " << endl;
            cin >> name;
            cout << "Enter product price "<< endl;
            cin >> price;
            cout << "Enter product quantity "<< endl;
            cin >> quantity;
        }
        void displayDetails(int threshold) const{
            cout << productId << "\t\t" << name << "\t\t" << price << "\t\t" << quantity << "\t\t" << totalValue(); 
            if(isLowStock(threshold)){
                cout << "\t <- Low Stock";
                
            }
            cout << endl;
        }
        double totalValue() const{
            double value = price * quantity;
            return value;
        }
        bool isLowStock(int threshold) const{
            return quantity < threshold;
        } 
        string getName() const {
            return name;
        }

};



int main(){
    int threshold;
    cout << "Enter threshold limit of quantity"<< endl;
    cin >> threshold;
    Product prod[5];
    

    for(int i =0; i< 5 ; i++) {
        cout << "Enter Product " << i+1  << " Details" <<endl;
        prod[i].acceptDetails();
    }
    for(int i =0; i< 5 ; i++) {
        prod[i].totalValue();
    }
    cout << "==========================" << "Inventory Report" << "==========================" << endl;
    cout << "ID" << "\t\t" << "Name" << "\t\t" << "Price" << "\t\t" << "QTY" << "\t\t" << "Total value" << endl;
    for(int i =0 ;i<5 ; i++){
        prod[i].displayDetails(threshold); 
    }

    int max = 0;
    for(int i=0;i<5;i++){
        if(prod[max].totalValue() < prod[i].totalValue()){
            max = i;
        }
    }
    cout << "Highest Value Product : " << prod[max].getName() << " ( " << prod[max].totalValue()  << " )"<< endl;
    cout << "Low Stock (threshold " << threshold << " ) : ";
    bool first = true;
    for(int i=0;i<5;i++){
        if(prod[i].isLowStock(threshold)){
            if(!first){
                cout << " ,";
            }
            cout << prod[i].getName();
            first = false; 
        }
    } 
    return 0;
}
