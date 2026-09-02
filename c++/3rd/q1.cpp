#include<iostream>
#include<iomanip>
#include<vector>
#include<utility>

using namespace std;

enum class HttpStatus {
 OK = 200,
 Created = 201,
 BadRequest = 400,
 Unauthorized = 401,
 NotFound = 404,
 ServerError = 500
};

void handleResponse(HttpStatus status, const string& endpoint){
    switch(static_cast<int>(status)){
        case 200 :
            cout << left << setw(20) << endpoint << " -> 200 OK" << setw(10) << " " << " : Request successful" << endl;
            break;
        case 201:
            cout << left << setw(20) << endpoint << " -> 201 OK" << setw(10) << " " << " : Created" << endl;
            break;
        case 400:
            cout << left << setw(20) << endpoint << " -> 400 OK" << setw(10) << " " << " : BadRequest" << endl;
            break;
        case 401:
            cout << left << setw(20) << endpoint << " -> 401 OK" << setw(10) << " " << " : Authentication required" << endl;
            break;
        case 404:
            cout << left << setw(20) << endpoint << " -> 404 OK" << setw(10) << " " << " : Endpoint does not exist" << endl;
            break;
        case 500:
            cout << left << setw(20) << endpoint << " -> 500 OK" << setw(10) << " " << " : Internal server error — retry later" << endl;
            break;
        default :
            cout << "Enter one of these codes 200, 201, 400, 401, 404, 500" << endl;
            break;
    }
}

using Header = pair<string, string>;
using HeaderList = vector<Header>;
using Port = unsigned int;
using IPAddress = string;   
typedef unsigned long long RequestId;

void  printHeaders(const HeaderList &headers){
    for(int i=0;i< headers.size() ; i++){
        cout << headers[i].first << " : " << headers[i].second << endl;
    }
}
int main(){
    RequestId id = 1748293847;
    Port port = 8080;
    handleResponse(HttpStatus::OK,"[GET /api/users]");
    handleResponse(HttpStatus::Unauthorized,"[GET /api/users]");
    handleResponse(HttpStatus::NotFound,"[GET /api/users]");
    handleResponse(HttpStatus::ServerError,"[GET /api/users]");
    HeaderList headers = {{"Content-Type","application/json"},{"Authorization","Bearer eyJhbGci.."},{"Accept-Language","en-US"}};
    cout << left << setw(20) << "Request ID " << " : " << id << endl;
    cout << left << setw(20) << "Server Port " << " : " << port << endl;
    cout << "Headers:" << endl;
    printHeaders(headers);
    return 0;
}
