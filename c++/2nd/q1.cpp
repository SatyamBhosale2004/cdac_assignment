#include<iostream>
#include<iomanip>
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
            cout << left << setw(8) << productId << setw(18) << name << setw(12) << price << setw(8) << quantity << setw(15) << totalValue(); 
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

double reorderCost(int qty, double unitPrice){
        return qty*unitPrice;
    }
double reorderCost(double qty, double unitPrice){
    return qty*unitPrice;
}
double reorderCost(int qty, double unitPrice , double taxRate){
    return (qty*unitPrice)+(qty*unitPrice*taxRate / 100);
}
double applyDiscount(double price, double discount = 10.0){
        return price - (price*(discount/100));
}

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
    cout << "====================================================" << "Inventory Report" << "====================================================" << endl;
    cout << left << setw(8) <<"ID" << setw(18)<< "Name" << setw(12)<< "Price" << setw(8)<< "QTY" << setw(15)<< "Total value" << endl;
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
    cout << endl;
    cout << "Int qty : " << reorderCost(2,20.2) << endl; 
    
    cout << "Double qty : " <<reorderCost(8.1,15.5)<< endl;
    
    cout << "With tax : " <<reorderCost(120,250,18.5)<< endl;
    
    cout << "Discounted price : " << applyDiscount(5000,25)<< endl;
    
    
    
    return 0;
}
