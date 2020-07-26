#include <iostream>
#include <windows.h>

#define TAM 2
using namespace std;
bool verdade = true;
struct carro{
    string cor;
    int ano;
    string marca;
    double valor;
};

void preencheInformacoes(carro vetCarro[TAM]){
    int cont=0;
    while(cont < TAM){
        system("cls");
        cout<<"Informe a cor do Carro: \n";
        cin>>vetCarro[cont].cor;
        cout<<"Informe o ano do carro: \n";
        cin>>vetCarro[cont].ano;
        cout<<"Informe a marca do carro: \n";
        cin>>vetCarro[cont].marca;
        cout<<"Informe o valor do carro: \n";
        cin>>vetCarro[cont].valor;
        cont++;
    }

}

void procura(string marca, carro vetCarro[TAM]){
    int cont=0,numero;
    for(int i =0;i<TAM;i++){
        if(vetCarro[i].marca == marca){
            cout<<"Marca: \t\t\t"<<vetCarro[i].marca<<"\n";
            cout<<"Ano: \t\t\t"<<vetCarro[i].ano<<"\n";
            cout<<"Cor: \t\t\t"<<vetCarro[i].cor<<"\n";
            cout<<"Valor: \t\t\t"<<vetCarro[i].valor<<"\n";
            cont++;
        }
    }
     if(cont == 0){
            cout<<"NENHUM RESULTADO ENCONTRADO\n";
        }
    cout<<"Deseja voltar ao Menu? \n";
    cout<<"[1]SIM\n";
    cout<<"[2]NAO\n";
    cin>>numero;
    if(numero == 1){
    }else{
        verdade = false;
    }
}

void procura(double valor,carro vetCarro[TAM]){
    int cont,numero;
    cout<<"ola";
    for(int i =0;i<TAM;i++){
        if(vetCarro[i].valor <= valor){
            cout<<"Marca: \t\t\t"<<vetCarro[i].marca<<"\n";
            cout<<"Ano: \t\t\t"<<vetCarro[i].ano<<"\n";
            cout<<"Cor: \t\t\t"<<vetCarro[i].cor<<"\n";
            cout<<"Valor: \t\t\t"<<vetCarro[i].valor<<"\n";
            cont++;
        }
    }
         if(cont == 0){
            cout<<"NENHUM RESULTADO ENCONTRADO\n";
        }
    cout<<"Deseja voltar ao Menu? \n";
    cout<<"[1]SIM\n";
    cout<<"[2]NAO\n";
    cin>>numero;
    if(numero == 1){

    }else{
        verdade = false;
    }
}

void procura(string marca,int ano,string cor,carro vetCarro[TAM]){
       int cont=0,numero;
       for(int i =0;i<TAM;i++){
            if(vetCarro[i].marca <= marca and vetCarro[i].ano == ano and vetCarro[i].cor == cor){
                cout<<"Marca: \t\t\t"<<vetCarro[i].marca<<"\n";
                cout<<"Ano: \t\t\t"<<vetCarro[i].ano<<"\n";
                cout<<"Cor: \t\t\t"<<vetCarro[i].cor<<"\n";
                cout<<"Valor: \t\t\t"<<vetCarro[i].valor<<"\n\n\n";
                cont++;
            }
        }
        if(cont == 0){
            cout<<"NENHUM RESULTADO ENCONTRADO\n";
        }
    cout<<"Deseja voltar ao Menu? \n";
    cout<<"[1]SIM\n";
    cout<<"[2]NAO\n";
      cin>>numero;
    if(numero == 1){

    }else{
        verdade = false;
    }
}

void escolheabusca(int valor,carro vetCarros[TAM]){
     if(valor == 1){
        system("cls");
        int valorCarro;
        cout<<"===============PESQUISA POR VALOR===============\n";
        cout<<"Informe o valor que voce deseja: ";
        cin>>valorCarro;
        procura(valorCarro,vetCarros);

    }else if(valor == 2){
        system("cls");
        string marca;
        cout<<"===============PESQUISA POR MARCA===============\n";
        cout<<"Informe a marca que voce deseja: ";
        cin>>marca;
        procura(marca,vetCarros);
    }else if(valor == 3){
        string marca,cor;
        int ano;
        system("cls");
        cout<<"===============PESQUISA POR VALOR===============\n";
        cout<<"\nInforme o Marca que voce deseja: ";
        cin>>marca;
        cout<<"\nInforme o Ano que voce deseja: ";
        cin>>ano;
        cout<<"\nInforme o Cor que voce deseja: ";
        cin>>cor;
        procura(marca,ano,cor,vetCarros);
    }
}

int menu(){
    int valor;
    do{
        system("cls");
        cout<<"====================================\n";
        cout<<"======[1]Pesquisa por Valor\n";
        cout<<"======[2]Pesquisa por marca\n";
        cout<<"======[3]Pesquisa por marca,ano,cor=\n";
        cout<<"====================================\n";
        cin>>valor;
    }while(valor != 1 and valor!=2 and valor !=3);
    return valor;
}

int main(){
    int valor;
    carro vetCarros[TAM];
    preencheInformacoes(vetCarros);

    while(verdade){
        system("cls");
        valor = menu();
        escolheabusca(valor, vetCarros);
    }


}

