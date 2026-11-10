import java.util.HashMap;
import java.util.Map;

public class AppCarga {
    public static void main(String[] args) {

        Map<String,EdgeCarga> arestasCarga = new HashMap<>();

        EdgeWeightedDigraph rotas = new EdgeWeightedDigraph();
        In arq = new In("exemplos/carga.txt");
        while (arq.hasNextLine()) {
            String linha = arq.readLine();
            String dados[] = linha.split(" ");
            String v = dados[0];
            String w = dados[1];
            double tempo = Double.parseDouble(dados[2]);
            double cargaMaxima = Double.parseDouble(dados[3]);
            rotas.addEdge(v, w, tempo);
            arestasCarga.put(v+w, new EdgeCarga(v, w, tempo, cargaMaxima));
        }

        // Rodando Dijkstra adaptado
        String start = "0";
        String end = "14";
        double pesoCaminhao = 25;

        DijkstraCarga dij = new DijkstraCarga(rotas, arestasCarga,
            start, pesoCaminhao);

        // Tem caminho do start ao end?
        if (dij.hasPathTo(end)) {
            System.out.println("Tem caminho!");
            for (Edge e : dij.pathTo(end)) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
        else {
            System.out.println("SEM CAMINHO!");
        }
        System.out.println(rotas.toDot());
    }
}
