#include "ordtopologica.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <set>

using namespace std;

OrdTopologica::OrdTopologica(Digraph&g)
{
	for (auto const &v : g.getVerts()) {
    if (marked.find(v) == marked.end())
      dfs(g, v);
  }
}

void OrdTopologica::dfs(Digraph &g, string v)
{
	// cout << "em " << v << endl;
	marked.insert(v); // marca v como visitado
	for (auto const &w : g.getAdj(v))
	{
		if (marked.find(w) == marked.end())
			dfs(g, w);
	}
  ordemTopo.insert(ordemTopo.begin(), v);
}

vector<string> OrdTopologica::getOrdemTopo()
{
  // Copia original
	vector<string> path(ordemTopo);
	return path;
}

