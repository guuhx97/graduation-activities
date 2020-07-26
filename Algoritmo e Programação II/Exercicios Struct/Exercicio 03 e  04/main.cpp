#include <iostream>
#include <windows.h>
#include <time.h>
using namespace std;

struct data{
    int dia;
    int mes;
    int ano;
};

struct pessoa{
    string nome;
    data dataNascimento;
};

data lerData(){
    data h;
    cout<<"informe o dia: ";
    cin>>h.dia;
    cout<<"informe o mes: ";
    cin>>h.mes;
    cout<<"informe o ano: ";
    cin>>h.ano;

    return h;
}
bool verificaAnoeBissesto(int ano){
    bool var;

    if(ano % 4 == 0){
        var = true;
    }
    if(ano%100==0){
        var = false;
    }
    if(ano%400==0){
        var = true;
    }
    return var;
}
bool verificaMes(int mes){
    if(mes >= 1 and mes <= 12){
        return true;
    }else{
    return false;
    }
}
bool verificaDia(int dia, int mes,int ano){
    if(mes%2==0 and mes < 8 and mes != 2){
        if(dia <=30){
            return true;
        }else{
            return false;
        }
    }else if(mes%2==1 and mes < 8 and mes != 2){
        if(dia <= 31){
            return true;
        }else{
            return false;
        }
    }else if (mes >= 8 and mes%2==0){
        if(dia <= 31){
            return true;
        }else{
            return false;
        }
    }else if(mes > 8 and mes %2==1){
        if(dia <=30){
            return true;
        }else{
            return false;
        }

    }else if(mes == 2){
        if(ano == true and dia <= 29){
            return true;
        }else if(ano == false and dia <=28){
            return true;
        }else{
            return false;
        }
    }
}
bool verificaDataDeNascimento(data dias){
    bool ano = verificaAnoeBissesto(dias.ano);
    bool mes = verificaMes(dias.mes);
    bool dia = verificaDia(dias.dia,dias.mes,ano);
}
void lerUsuario(pessoa vetor[]){
    data h;
    bool ver;
    for(int i=0;i<5;i++){
        cout<<"Informe o seu nome: ";
        cin>>vetor[i].nome;
        do{
            vetor[i].dataNascimento.dia = rand() % 31 + 1;
            vetor[i].dataNascimento.mes = rand() % 12 + 1;
            vetor[i].dataNascimento.ano = rand() % 116 + 1900;

            ver = verificaDataDeNascimento(vetor[i].dataNascimento);
        }while(ver == false);
        system("cls");
    }
}
int calculaIdade(data hoje,data dataNasci){
        if((hoje.mes < dataNasci.mes) or (hoje.mes == dataNasci.mes and hoje.dia < dataNasci.dia)) {
            return (hoje.ano - dataNasci.ano)-1;
        }if(hoje.mes >= dataNasci.mes and hoje.dia >= dataNasci.dia){
            return (hoje.ano - dataNasci.ano);
        }
}

int main(){

    time_t tempo = time(NULL);
    tm *amanha =  localtime(&tempo);
    data hoje = {amanha -> tm_mday, amanha -> tm_mon+1, amanha ->tm_year + 1900};


    srand(time(NULL));
    rand() % 116 + 1;


    pessoa vetor[5];
    lerUsuario(vetor);


    int apartir;
    system("cls");
    cout<<"A partir de qual idade Voce gostaria de ver";
    cin>>apartir;

    for(int i =0;i<5;i++){
        if(calculaIdade(hoje,vetor[i].dataNascimento) >= apartir){
            cout<<vetor[i].nome<<"\t\t\t"<<calculaIdade(hoje,vetor[i].dataNascimento)<<"\n";
        }
    }




}
