package Classes;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Grafo {

    public static void adicionarVertice(String v, Map<String, Set<String>> grafo) {
        grafo.put(v, new HashSet<>());
    }

    public static boolean existeVertice(String v, Map<String, Set<String>> grafo) {
        return grafo.containsKey(v);
    }

    public static void adicionarAresta(String v1, String v2, Map<String, Set<String>> grafo) {
        grafo.get(v1).add(v2);
        grafo.get(v2).add(v1);
    }

    public static boolean existeAresta(String v1, String v2, Map<String, Set<String>> grafo) {
        return grafo.get(v1).contains(v2);
    }

    public static void printAdjacency(Map<String, Set<String>> grafo) {

        String caminho = Paths.get("src/Matriz de Adjacencia", "matrizGrafo.txt").toString();

        try (FileWriter writer = new FileWriter(caminho)) {
            List<String> vertices = new ArrayList<>(grafo.keySet());
            Collections.sort(vertices);

            int colWidth = vertices.stream().mapToInt(String::length).max().orElse(1) + 2;

            writer.write("Matriz de Adjacência (Grafo)\n\n");

            writer.write(String.format("%" + colWidth + "s", ""));
            for (String v : vertices) {
                writer.write(String.format("%" + colWidth + "s", v));
            }
            writer.write("\n");

            for (String origem : vertices) {
                writer.write(String.format("%" + colWidth + "s", origem));
                for (String destino : vertices) {
                    int valor = grafo.get(origem).contains(destino) ? 1 : 0;
                    writer.write(String.format("%" + colWidth + "d", valor));
                }
                writer.write("\n");
            }

            System.out.println("Arquivo matrizGrafo.txt gerado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao gerar matriz de adjacência: " + e.getMessage());
        }
    }
    
}