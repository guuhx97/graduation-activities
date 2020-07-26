#include <iostream>

using namespace std;

double calc(int a,int b){
    if(a < 1){
        return b;
    }else{
        return calc(a-b,a=b);
    }
}

int main() {
    cout<<calc(12,20);
}
