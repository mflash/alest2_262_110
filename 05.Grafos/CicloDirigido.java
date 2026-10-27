import java.util.HashMap;
import java.util.Map;

public class CicloDirigido
{
    private enum Cor {
        PRETO, BRANCO, CINZA
    }

    private Digraph g;
    private Map<String, String> edgeTo;
    private Map<String, Cor> cores;
    private boolean temCiclo;

    public CicloDirigido(Digraph g) {
        this.g = g;
        temCiclo = false;
        edgeTo = new HashMap<>();
        cores = new HashMap<>();
        for(String s: g.getVerts())
            cores.put(s, Cor.BRANCO);

        for(String s: g.getVerts()) {
            if(cores.get(s) == Cor.BRANCO) {
                if(dfs(s)) {
                    temCiclo = true;
                    return;
                }
            }
        }
    }

    public boolean hasCycle() {
        return temCiclo;
    }

    private boolean dfs(String v)
    {
        System.out.println("Entrando em "+v);
        // Marca como visitado
        cores.put(v, Cor.CINZA);
        for(String w: g.getAdj(v)) {
            // Visita se não tiver sido processado (BRANCO)
            if(cores.get(w) == Cor.BRANCO) {
                // Armazena que para chegar em w viemos de v
                edgeTo.put(w, v);
                if(dfs(w))
                    return true;
            }
            // Se chegar em um vértice CINZA, é um ciclo!
            else if(cores.get(w) == Cor.CINZA) {
                System.out.println("  >>> Ciclo encontrado em "+w);
                return true;
            }
        }
        System.out.println("Saindo de "+v);
        // Não encontrou ciclo
        cores.put(v, Cor.PRETO);
        return false;
    }
}