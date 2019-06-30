using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dijkstra
{
    class Vertice
    {

        public Vertice(string nomeV)
        {
            Nome = nomeV;
            ListaDeAdjacentes = new List<Vertice>();
            //Distancia = int.MaxValue;
            Fechado = false;
            VerticeAnterior = new Vertice() ;
        }

        public Vertice()
        {

        }

        public string Nome { get; set; }

        public List<Vertice> ListaDeAdjacentes { get; set; }

        public int Distancia = -1;

        public int peso = 0;
        public Vertice VerticeAnterior { get; set; }

        public bool Fechado { get; set; }

        

        

        /*public int Estimativa
        {
            get
            {
                var dist = Distancia;
                var anterior = VerticeAnterior;

                while(anterior != null)
                {
                    dist += anterior.Distancia;
                    anterior = anterior.VerticeAnterior;
                }

                return dist;
            }
        }*/

    }
}
