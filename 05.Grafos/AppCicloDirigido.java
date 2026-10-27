public class AppCicloDirigido {
   
    public static void main(String[] args) {
        Digraph g = new Digraph("exemplos/tinyG.txt");
        CicloDirigido c = new CicloDirigido(g);

        if(c.hasCycle())
            System.out.println("O grafo TEM ciclo!");
        else
            System.out.println("O grafo não tem ciclo...");
    }
}
