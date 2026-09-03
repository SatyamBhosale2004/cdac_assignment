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
    string name, type;
    public:
        Shader(){

        }
        Shader(const string&n, const string&t) : name(n) , type(t){
            cout << "[Shader Compiled]" << endl;
        }
        int getReferenceCount(const shared_ptr<Shader> &shader){
            return shader.use_count();
        }
        ~Shader(){
            cout<<"[Shader Destroyed]" << endl;
        }
        
};

class AudioClip{
    string name;
    double value;

    public:
        AudioClip(){

        }
        AudioClip(const string&n , double v) : name(n),value(v) {
            cout << "[Audio clip made]" << endl;
        }
        ~AudioClip(){
            cout << "[Audio CLip destroyed]" << endl;
        }
        string getName(){
            return name;
        }
};

int main(){
    auto text1 = make_unique<Texture>("player_sprite",512,512);
    text1->display();
    // unique_ptr<Texture> text2 = text1;
    //cant do this because its a unique pointer and two unique pointers cant exits but in move func it deletes the og one by making it into nullptr
    unique_ptr<Texture> text2 = move(text1);
    //part b
    cout << "text1 is null" << (text1 == nullptr ? "Yes" : "No") << endl;
    
    auto shader = make_shared<Shader>("main_vert","vertex");
    cout << "Ref count : " << shader->getReferenceCount(shader) << endl;
    {
        auto renderRef = shader;
        cout << "Ref count : " << shader->getReferenceCount(shader) << endl;
        auto editorRef = shader;
        cout << "Ref count : " << shader->getReferenceCount(shader) << endl;
    }
    cout << "Ref count : " << shader->getReferenceCount(shader) << endl;

    //partc
    auto audio = make_shared<AudioClip>("explosion" , 3.5);
    weak_ptr<AudioClip> observer = audio;

    if(auto clip = observer.lock())
        cout << "Clip alive : " << clip->getName() << endl;

    audio.reset();

    if(observer.expired())
        cout << "Clip already unloaded " << endl;
    return 0;
}
