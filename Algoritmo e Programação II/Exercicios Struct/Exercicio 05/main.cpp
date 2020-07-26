#include <iostream>
#include <windows.h>
#define TAM 5
using namespace std;

struct Despesas{
    string nomeDoResponsavel;
    int numeroDoApt;
    double areaQuadrada;
    int numeroDeMoradores;
    double valorDoAluguel;
};


void preencherVetor(Despesas vetor[TAM]){
    int valor = 0;
    while (valor < 5){
            system("CLS");
     cout<<"Informe o nome do responsavel: \n";
     cin>>vetor[valor].nomeDoResponsavel;
     cout<<"Informe o numero do Apartamento: \n";
     cin>>vetor[valor].numeroDoApt;
     cout<<"Informe o Tamanho do Apartamento: \n";
     cin>>vetor[valor].areaQuadrada;
     cout<<"Informe a Quantidade de pessoas que moram no APT: \n";
     cin>>vetor[valor].numeroDeMoradores;
    valor++;
    }
}
int areaCondominio(Despesas vetor[TAM],int valor=0,int cont =0){
    if(cont == 5){
        return valor;
    }else{
        valor + vetor[cont].areaQuadrada;
        return areaCondominio(vetor,cont+1,valor);
    }
}
void mostrarVetor (Despesas vetor[TAM]){
    cout<<"Area Total do Condominio:    "<<areaCondominio(vetor,0)<<"\n\n";
    int vetorGuardaPosicao[TAM]= {0},maiorValor=0,cont=0;

    for(int i =0;i<TAM;i++){
        if(vetor[i].numeroDeMoradores > maiorValor){
            maiorValor = vetor[i].numeroDeMoradores;
        }
     }

     for(int i=0;i<TAM;i++){
        if(vetor[i].numeroDeMoradores == maiorValor){
            cout<<"Responsavel:\t"<<vetor[i].nomeDoResponsavel<<"\n";
            cout<<"Nº APT:\t"<<vetor[i].numeroDoApt<<"\n";
            cout<<"QTD Moradores:\t"<<vetor[i].numeroDeMoradores<<"\n";
            cout<<"\n\n";
        }
     }

    Sleep(10000);
    }

int menu(){
    int valor;
    do{
        cout<<"\t\t================================\n";
        cout<<"\t\t===     [1]Preencher Dados =====\n";
        cout<<"\t\t===     [2]Mostrar  Moradores===\n";
        cout<<"\t\t===     [3]Sair              ===\n";
        cout<<"\t\t================================\n";
        cin>>valor;
    }while(valor < 1 and valor > 3 );
    return valor;
}


int main(){
    int valor = 0,cont =0;
    Despesas vetor[TAM];

        do{
            system("cls");
            valor = menu();
            cout<<valor;
            if(valor == 1){
                preencherVetor(vetor);
                cont++;
            }else if(valor == 2){
                if(cont > 0){
                    mostrarVetor(vetor);
                }else{
                    cout<<"Nenhum dado cadastrado";
                }
            }
        }while(valor != 3);

}
