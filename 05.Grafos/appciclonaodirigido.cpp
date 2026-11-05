#include <iostream>
#include "graph.h"
#include "ciclonaodirigido.h"

using namespace std;

int main()
{
  // Graph g("exemplos/tinyG.txt");
  Graph g;
  g.addEdge("1","2");
  g.addEdge("2","4");
  g.addEdge("4","3");
  // g.addEdge("1","3");
  g.addEdge("4","5");
  g.addEdge("6","7");
  g.addEdge("7","8");
  g.addEdge("6","8");
  UndirectedCycle ucycle(g);

  cout << "Tem ciclo? " << ucycle.containsCycle() << endl;
}
