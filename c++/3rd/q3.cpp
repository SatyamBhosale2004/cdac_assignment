#include<iostream>
using namespace std;

class LogBuffer{
    char *buffer;
    int capacity;
    int size;
    static int instanceCount;
    mutable int accessCount = 0;

    public:
        LogBuffer(){

        }
        LogBuffer(int capacity){
            this->capacity = capacity;
            buffer = new char[capacity]; 
            buffer[0] = '\0';
            size = 0;
            instanceCount++;
            cout<<"[Log buffer created] capacity = " << capacity << endl;
        }

        LogBuffer (const LogBuffer& other){
            capacity = other.capacity;
            size = other.size;
            buffer = new char[capacity];
            for(int i=0;i<=size;i++){
                buffer[i] = other.buffer[i];
            }
            instanceCount++;
            cout << "[Log buffer deep copied] capacity = " << capacity << endl;
        }
        LogBuffer& operator=(const LogBuffer& other){
            if(this == &other){
                
                cout << "Self assignment detected - no op" << endl;
                return *this;
            }
                
            
            size = other.size;
            capacity = other.capacity;

            
            buffer = new char[capacity];
            for(int i=0;i<=size;i++){
                buffer[i] = other.buffer[i];
            }
            cout << "[Log buffer assigned] " << endl;
            
            return *this;
        }
        ~LogBuffer(){
            delete[] buffer;
            instanceCount--;
            cout << "Logbuffer destryoed" << endl;
        }
        void append(const char*msg) {
            for(int i=0;msg[i] != '\0';i++){
                if( size < capacity-1){
                    buffer[size] = msg[i];
                    size++;
                }
            }
            if(size < capacity)
                buffer[size] ='\0';

        }
        void print()   const {
            cout << buffer << endl;
            accessCount++;
            
        }
        void clear(){
            size=0;
            buffer[0] = '\0';
        }
        static int getInstanceCount(){
            return instanceCount;
        }
        int getAccessCount() const {
            return accessCount;
        }
};  
int LogBuffer::instanceCount = 0;
int main(){
    LogBuffer log1(256);
    log1.append("Server started on port 8080");
    log1.append(" | Request received from 192.168.1.10");
    log1.print();

    LogBuffer log2 = log1; // copy constructor
    log2.append(" | Cached response sent");
    cout << "log1 : "; log1.print(); // must NOT contain log2's append
    cout << "log2 : "; log2.print();

    LogBuffer log3(128);
    log3 = log1; // copy assignment
    log3.print();

    log1 = log1; // must not crash or corrupt data
    log1.print();

    cout << "Live LogBuffer objects : " << LogBuffer::getInstanceCount() << endl;
    cout << endl;
    const LogBuffer readOnly(log1); // copy construct into a const object
    readOnly.print();
    readOnly.print();
    readOnly.print();
    cout << "Times printed: " << readOnly.getAccessCount() << endl;
    return 0;
}
