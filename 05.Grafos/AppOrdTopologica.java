public class AppOrdTopologica {
   
    public static void main(String[] args) {
        // Digraph g = new Digraph("exemplos/tinyG.txt");
        Digraph g = new Digraph("exemplos/disciplinas.txt");
        OrdTopologica ord = new OrdTopologica(g);

        if(ord.hasCycle())
            System.out.println("IMPOSSÍVEL FAZER! O grafo TEM ciclo!");
        else {
            System.out.print("Ordem topológica: ");
            for(String v: ord.getOrdemTopologica())
                System.out.print(v+" ");
            System.out.println();
        }
    }
}
