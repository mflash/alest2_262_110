public class AppCicloNaoDirigido {
   
    public static void main(String[] args) {
        Graph g = new Graph("exemplos/tinyG.txt");
        CicloNaoDirigido c = new CicloNaoDirigido(g);

        if(c.hasCycle())
            System.out.println("O grafo TEM ciclo!");
        else
            System.out.println("O grafo não tem ciclo...");
    }
}
