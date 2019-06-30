using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dijkstra
{
    class Aresta
    {

        public Aresta(Vertice A, Vertice B, int Distancia)
        {
            origem = A;
            destino = B;
            peso = Distancia;
            A.ListaDeAdjacentes.Add(B);
            B.ListaDeAdjacentes.Add(A);

        }
        public Vertice origem { get; set; }

        public Vertice destino { get; set; }

        public int peso { get; set; }

        public bool Visitado = false;
    }
}
