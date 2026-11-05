#include <vector>
#include <map>
#include <set>
#include <string>
#include "digraph.h"

#ifndef ORDEM_TOPO_H
#define ORDEM_TOPO_H

class OrdTopologica
{

public:
	OrdTopologica(Digraph &g);

	std::vector<std::string> getOrdemTopo();

private:
	std::set<std::string> marked;
	std::vector<std::string> ordemTopo;
	void dfs(Digraph &g, std::string v);
};

#endif
