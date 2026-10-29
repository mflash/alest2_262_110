import java.util.HashMap;
import java.util.Map;

public class ExemploCurriculo {

    public static void main(String[] args) {
        Digraph g = new Digraph();
        In arq = new In("exemplos/98AJ_requisitos.csv");
        arq.readLine();
        while(arq.hasNextLine()) {
            String linha = arq.readLine();
            String[] dados = linha.split(",");
            String disc = dados[2];
            String requisito = dados[5];
            // System.out.println(requisito + " -> "+disc);
            g.addEdge(requisito, disc);
        }
        System.out.println(g.toDot());

        Map<String, String> nomes = new HashMap<>();
        In arq2 = new In("exemplos/discipl_cc.csv");
        arq2.readLine();
        while(arq2.hasNextLine()) {
            String linha = arq2.readLine();
            String[] dados = linha.split(";");
            String cod = dados[0];
            String nome = dados[2];
            nomes.put(cod, nome);
        }

        OrdTopologica ot = new OrdTopologica(g);
        for(String v: ot.getOrdemTopologica())
            System.out.println(">>> "+v+" - "+nomes.get(v));
    }
}
