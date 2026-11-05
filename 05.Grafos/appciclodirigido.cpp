#include <iostream>
#include "digraph.h"
#include "ciclodirigido.h"

using namespace std;

int main()
{
  // Digraph g("tinyDAG.txt");
  Digraph g;
  g.addEdge("1","2");
  g.addEdge("2","4");
  g.addEdge("4","3");
  // g.addEdge("3","1"); // retirando para não ter ciclo nesta parte
  g.addEdge("4","5");
  g.addEdge("6","7");
  g.addEdge("7","8");
  g.addEdge("8","6");
  DirectedCycle dcycle(g);

  cout << g.toDot() << endl;

  cout << "Tem ciclo? " << dcycle.containsCycle() << endl;
}
