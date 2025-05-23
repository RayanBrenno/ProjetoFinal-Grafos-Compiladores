package Classes;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Digrafo {

    public static void adicionarVertice(String v, Map<String, Set<String>> digrafo) {
        digrafo.put(v, new HashSet<>());
    }

    public static boolean existeVertice(String v, Map<String, Set<String>> digrafo) {
        return digrafo.containsKey(v);
    }
    
    public static void adicionarAresta(String v1, String v2, Map<String, Set<String>> digrafo) {
        digrafo.get(v1).add(v2);
    }

    public static boolean existeAresta(String v1, String v2, Map<String, Set<String>> digrafo) {
        return digrafo.get(v1).contains(v2);
    }

    public static void printAdjacency(Map<String, Set<String>> digrafo) {

        String caminho = Paths.get("src/Matriz de Adjacencia", "matrizDigrafo.txt").toString();

        try (FileWriter writer = new FileWriter(caminho)) {
            List<String> vertices = new ArrayList<>(digrafo.keySet());
            Collections.sort(vertices); // ordena para manter consistência

            int colWidth = vertices.stream().mapToInt(String::length).max().orElse(1) + 2;

            writer.write("Matriz de Adjacência (Digrafo)\n\n");

            // Cabeçalho
            writer.write(String.format("%" + colWidth + "s", ""));
            for (String v : vertices) {
                writer.write(String.format("%" + colWidth + "s", v));
            }
            writer.write("\n");

            // Corpo
            for (String origem : vertices) {
                writer.write(String.format("%" + colWidth + "s", origem));
                for (String destino : vertices) {
                    int valor = digrafo.get(origem).contains(destino) ? 1 : 0;
                    writer.write(String.format("%" + colWidth + "d", valor));
                }
                writer.write("\n");
            }

            System.out.println("Arquivo matrizDigrafo.txt gerado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao gerar matriz de adjacência: " + e.getMessage());
        }
    }
    
}