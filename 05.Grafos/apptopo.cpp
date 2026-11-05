#include <iostream>
#include "digraph.h"
#include "ordtopologica.h"

using namespace std;

int main()
{
  Digraph g("exemplos/tinyG.txt");
  OrdTopologica ot(g);

  for (auto const &v : ot.getOrdemTopo())
    cout << v << " ";
  cout << endl;
}
