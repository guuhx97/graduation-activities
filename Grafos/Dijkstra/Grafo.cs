using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dijkstra
{
    class Grafo
    {

        public Grafo()
        {
            ListaDeVertice = new List<Vertice>();
            ListaDeAresta = new List<Aresta>();

            ListaDeVertice.Add(new Vertice("0"));
            ListaDeVertice.Add(new Vertice("1"));
            ListaDeVertice.Add(new Vertice("2"));
            ListaDeVertice.Add(new Vertice("3"));
            ListaDeVertice.Add(new Vertice("4"));
            ListaDeVertice.Add(new Vertice("5"));


            ListaDeAresta.Add(new Aresta(ListaDeVertice.ElementAt(0), ListaDeVertice.ElementAt(1), 1));
            ListaDeAresta.Add(new Aresta(ListaDeVertice.ElementAt(0), ListaDeVertice.ElementAt(2), 5));
            ListaDeAresta.Add(new Aresta(ListaDeVertice.ElementAt(1), ListaDeVertice.ElementAt(4), 6));
            ListaDeAresta.Add(new Aresta(ListaDeVertice.ElementAt(1), ListaDeVertice.ElementAt(3), 4));
            ListaDeAresta.Add(new Aresta(ListaDeVertice.ElementAt(2), ListaDeVertice.ElementAt(5), 2));
            ListaDeAresta.Add(new Aresta(ListaDeVertice.ElementAt(2), ListaDeVertice.ElementAt(4), 1));
            ListaDeAresta.Add(new Aresta(ListaDeVertice.ElementAt(3), ListaDeVertice.ElementAt(5), 15));
            ListaDeAresta.Add(new Aresta(ListaDeVertice.ElementAt(4), ListaDeVertice.ElementAt(5), 7));

        }
        public List<Vertice> ListaDeVertice { get; set; }

        public List<Aresta> ListaDeAresta { get; set; }

        public bool AdicionaVertice(Vertice vertice)
        {
            if (ListaDeVertice.Any(c => c.Nome == vertice.Nome))
            {
                Console.Write("Esse vertive já existe");
                Console.ReadKey();
                return true;
            }
            else
            {
                ListaDeVertice.Add(vertice);
                Console.Write("Vertice Adicionado Com Sucesso!");
                Console.ReadKey();
                return false;
            }

        }

        public string AdicionarAresta(Aresta aresta)
        {
            if (!(ListaDeVertice.Any(c => c.Nome == aresta.origem.Nome)) && !(ListaDeVertice.Any(c => c.Nome == aresta.destino.Nome)))
            {
                return "O vertice de Origem ou Destino, não é";
            }
            else
            {
                ListaDeAresta.Add(aresta);
                AdicionaListaAdjacencia(aresta.origem, aresta.destino);
                return "Adicionado Com Sucesso";
            }
        }

        public void MostraGrafo(Grafo grafo)
        {
            foreach (Vertice v in grafo.ListaDeVertice)
            {
                Console.Write(v.Nome + " => ");
                foreach (Vertice v2 in v.ListaDeAdjacentes)
                {
                    Console.Write(v2.Nome + " | ");

                }
                Console.WriteLine();
            }
        }

        public void AdicionaListaAdjacencia(Vertice A, Vertice B)
        {
            A.ListaDeAdjacentes.Add(B);
            B.ListaDeAdjacentes.Add(A);
        }

        public Vertice RetornaVertice(string nome)
        {
            foreach (Vertice ver in ListaDeVertice)
            {

                if (ver.Nome.Equals(nome))
                {
                    return ver;
                }
            }

            return null;
        }

        public List<Aresta> ProcurarVerticeComAresta(Vertice V2)
        {
            List<Aresta> ListaDeArestaLigadas = new List<Aresta>();

            foreach(Aresta A in this.ListaDeAresta)
            {
                if(A.origem.Nome == V2.Nome || A.destino.Nome == V2.Nome)
                {
                    ListaDeArestaLigadas.Add(A);
                }
            }
            return ListaDeArestaLigadas;

        }

        public void EscolhendoMelhorCaminho(Vertice VerticeInicial)
        {
            //ListaDeVertice.Remove(VerticeInicial);
            // ListaDeVertice.Insert(0,VerticeInicial);

            

            List<Vertice> MenorCaminho = new List<Vertice>();
            List<Vertice> NaoVisitados = new List<Vertice>();
            List<Aresta> ArestaVertice = new List<Aresta>();
            Vertice Vizinho;
            MenorCaminho.Clear();
            NaoVisitados.Clear();
            
            foreach(Vertice v2 in this.ListaDeVertice)
            {
                if(v2.Nome.Equals(VerticeInicial.Nome))
                {

                    v2.Distancia = 0;
                    v2.Fechado = false;
                    v2.VerticeAnterior.Nome = "-";
                }
                else
                {
                    v2.Distancia = int.MaxValue ;
                }
                
                NaoVisitados.Add(v2);
            }
            NaoVisitados.OrderByDescending(c => c.Distancia);
            while (NaoVisitados.Any())
            {
                VerticeInicial = NaoVisitados.First();

                ArestaVertice = ProcurarVerticeComAresta(VerticeInicial);

                foreach(Aresta Arest in ArestaVertice)
                {


                    if (Arest.origem.Equals(VerticeInicial))
                    {
                        Vizinho = Arest.destino;
                    }
                    else
                    {
                        Vizinho = Arest.origem;
                    }
                    

                    if (!Vizinho.Fechado)
                    {
                        if(Vizinho.Distancia > (VerticeInicial.Distancia + Arest.peso))
                        {
                                                       
                            Vizinho.Distancia = (VerticeInicial.Distancia + Arest.peso);
                            Vizinho.VerticeAnterior = VerticeInicial;

                        }
                    }
                }

                VerticeInicial.Fechado = true;
                MenorCaminho.Add(VerticeInicial);
                NaoVisitados.Remove(VerticeInicial);

               // NaoVisitados.OrderByDescending(c => c.Distancia);
            }

            Console.Write("Vertice: ");
            foreach(Vertice v in MenorCaminho)
            {
                Console.Write("\t\t " + v.Nome);
            }
            Console.WriteLine();
            Console.Write("Estimativa:  ");
                           
            foreach (Vertice v in MenorCaminho)
            {
                Console.Write("\t\t " + v.Distancia);
            }
            Console.WriteLine();
            Console.Write("Anterior:    ");
            foreach (Vertice v in MenorCaminho)
            {
                Console.Write("\t\t" + v.VerticeAnterior.Nome);
            }
            Console.WriteLine();
            Console.Write("Fechado: ");
            foreach (Vertice v in MenorCaminho)
            {
                if (v.Fechado)
                {
                    Console.Write("\t S");
                }
                else
                {
                    Console.Write("\t N");
                }
                
            }

            Console.ReadKey();


            /*foreach (var vertice in VerticeInicial.ListaDeAdjacentes)
            { 
                vertice.VerticeAnterior = VerticeInicial;
                vertice.Distancia = grafo.ListaDeAresta.FirstOrDefault(c => c.origem == VerticeInicial && c.destino == vertice).peso;

            }*/
        }
    
    }
}
