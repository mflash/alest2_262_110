import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DijkstraCarga {

    private Map<String, Edge> edgeTo;
    private Map<String, Double> distTo;
    private IndexMinHeap<String, Double> pq;
    private Map<String, EdgeCarga> arestasCarga;

    public DijkstraCarga(EdgeWeightedDigraph g, Map<String,EdgeCarga> arestasCarga,
        String s, double pesoCaminhao) {
        this.arestasCarga = arestasCarga;
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        pq = new IndexMinHeap<>();

        for (String v : g.getVerts())
            distTo.put(v, Double.POSITIVE_INFINITY);
        distTo.put(s, 0.0);

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            String v = pq.delMin();
            // System.out.println("Processando: " + v);
            for (Edge e : g.getAdj(v)) {
                relax(e, pesoCaminhao);
            }
        }
    }

    public boolean hasPathTo(String v) {
        return distTo.get(v) != Double.POSITIVE_INFINITY;

    }

    public double distTo(String v) {
        if (!hasPathTo(v))
            throw new UnsupportedOperationException("Sem caminho para " + v + "!");
        return distTo.get(v);
    }

    public Iterable<Edge> pathTo(String v) {
        LinkedList<Edge> path = new LinkedList<>();
        if (!hasPathTo(v))
            return path;
        Edge e = edgeTo.get(v);
        // Enquanto não chegar na primeira aresta
        while (e != null) {
            path.addFirst(e);
            // Próxima aresta começa no V da atual!
            e = edgeTo.get(e.getV());
        }
        return path;
    }

    private void relax(Edge e, double pesoCaminhao) {
        String v = e.getV();
        String w = e.getW();
        double edgeWeight = distTo.get(v) + e.getWeight();
        EdgeCarga ec = arestasCarga.get(v+w);
        if (distTo.get(w) > edgeWeight &&
            pesoCaminhao <= ec.getMaxCarga()) {
            // Achei um caminho melhor!
            Edge oldEdge = edgeTo.get(w);
            if(oldEdge != null)
                oldEdge.setColor("");
            distTo.put(w, edgeWeight);
            edgeTo.put(w, e);
            e.setColor("color=red penwidth=3");
            if (!pq.contains(w))
                // Não existe, insere na fila
                pq.insert(w, edgeWeight);
            else
                // Já existe, reduz a prioridade (valor)
                pq.decreaseValue(w, edgeWeight);
        }
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph("exemplos/tinyEWD.txt");
        // EdgeWeightedDigraph g = new EdgeWeightedDigraph("exemplos/mediumEWG.txt");
        DijkstraSP dij = new DijkstraSP(g, "0");

        for (String v : g.getVerts().stream().sorted().toList()) {
            System.out.print(v + ": ");
            if (!dij.hasPathTo(v))
                System.out.println("Sem caminho!");
            else {
                for (Edge e : dij.pathTo(v)) {
                    System.out.print(e + " ");
                }
                System.out.println("- " + dij.distTo(v));
            }
        }
    }
}
