#include<iostream>
#include<memory>
using namespace std;

class Texture{
    int width,height;
    string name;
    public:
        Texture(){
            
        }

        ~Texture(){
            cout << "[Texture Released]" << endl;
        }
        Texture(const string&n ,int width,int height) : name(n){
            
            this->width=width;
            this->height=height;
            cout << "[Texture Loaded]" << endl;
        }
        void display(){
            cout << "Texture Name : " << name << endl;
            cout << "Texture width : " << width << endl;
            cout << "Texture height : " << height << endl;
        }

};
class Shader{
g

};

int main(){
    auto text1 = make_unique<Texture>("player_sprite",512,512);
    text1->display();
    // unique_ptr<Texture> text2 = text1;
    //cant do this because its a unique pointer and two unique pointers cant exits but in move func it deletes the og one by making it into nullptr
    unique_ptr<Texture> text2 = move(text1);
    cout << "text1 is null" << (text1 == nullptr ? "Yes" : "No") << endl;
    
    return 0;
}