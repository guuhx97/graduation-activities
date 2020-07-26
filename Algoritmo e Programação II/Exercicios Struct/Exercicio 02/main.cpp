#include <iostream>

using namespace std;

struct Fracao{
    int numerador;
    int denominador;
};
int menu(){
    int valor;
    cout<<"Escolha a operação\n";
    cout<<"[1]soma\n";
    cout<<"[2]Subtração\n";
    cout<<"[3]Multiplicação\n";
    cout<<"[4]Divisão\n";
    cout<<"[5]MMC\n";
    cin>>valor;

    return valor;

}


int MMC(int den1,int den2,int div = 2){
    if(den1 == 1 and den2 == 1){
        return 1;
    }else if(den1 % div == 0 and den2 % div == 0){
        return  div * MMC(den1/div, den2/div, div);
    }else if(den1 % div == 0){
        return div * MMC(den1/div,den2,div);
    }else if(den2 % div == 0){
        return div * MMC(den1,den2/div,div);
    }else{
        return MMC(den1,den2,++div);
    }
}

Fracao operator+(Fracao num, Fracao num2){
      Fracao resp;
        if(num.denominador == num2.denominador){
            resp.numerador = num.numerador + num2.numerador;
            resp.denominador = num.denominador;
            return resp;
        }else{
            resp.denominador = MMC(num.denominador, num2.denominador, 0);
            resp.numerador = ((resp.denominador/num.denominador)*num.numerador)  - ((resp.denominador/num2.denominador)*num2.numerador);
            return resp;
        }
}

Fracao operator-(Fracao num, Fracao num2){
        Fracao resp;
        if(num.denominador == num2.denominador){
            resp.numerador = num.numerador - num2.numerador;
            resp.denominador = num.denominador;
            return resp;
        }else{
            resp.denominador = MMC(num.denominador, num2.denominador);
            resp.numerador = ((resp.denominador/num.denominador)*num.numerador)  - ((resp.denominador/num2.denominador)*num2.numerador);
            return resp;
        }
}

Fracao operator/(Fracao num, Fracao num2){
    Fracao resp;
    resp.numerador = num.numerador*num2.denominador;
    resp.denominador = num.denominador * num2.numerador;
    return resp;
}

Fracao operator*(Fracao num, Fracao num2){
    Fracao resp;
    resp.numerador = num.numerador*num2.numerador;
    resp.denominador = num2.denominador * num2.denominador;
    return resp;
}

Fracao calcula(int valor, Fracao num1, Fracao num2){
     switch(valor){
        case 1:
            return num1 + num2;
        case 2:
            return num1 - num2;
        case 3:
            return num1 * num2;
        case 4:
            return num1 / num2;
     }
}

int leia(){
    Fracao numeros, numeros2,dois;
    cout<<"Informe o valor do numerador 1";
    cin>>numeros.numerador;
    cout<<"Informe o valor do denominador 1";
    cin>>numeros.denominador;
    cout<<"Informe o valor do numerador 2";
    cin>>numeros2.numerador;
    cout<<"Informe o valor do denominador 2";
    cin>>numeros2.denominador;

    int valor = menu();

     dois = calcula(valor,numeros,numeros2);

    int dominador = dois.denominador;
    int numerador = dois.numerador;
    cout<<numerador<<"/"<<dominador;

}


int main(){

    leia();

}





istream& operator+(istream &oi, Fracao num1){

}


