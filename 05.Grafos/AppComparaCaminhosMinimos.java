public class AppComparaCaminhosMinimos {

    public static void main(String[] args) {

        EdgeWeightedDigraph g = new EdgeWeightedDigraph("exemplos/mediumEWG.txt");
        System.out.println(g.totalEdges);
        System.out.println(g.totalVertices);

        long totalDijsktra = 0;
        for (String inicial : g.getVerts()) {
            long inicio = System.currentTimeMillis();
            // System.out.println(inicial);
            DijkstraSP dij = new DijkstraSP(g, inicial);
            long fim = System.currentTimeMillis();
            totalDijsktra += (fim - inicio);
        }
        System.out.println("Tempo Dijkstra: "+totalDijsktra);

        // FW é O(n3)!
        FloydWarshallSP fw = new FloydWarshallSP(g);
        System.out.println("Tempo FW: "+fw.getTempoTotal());
    }
}
