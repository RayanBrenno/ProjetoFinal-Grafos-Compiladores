import java.io.FileReader; 
import java.nio.file.Paths;

import Classes.Digrafo;
import Classes.Grafo;
import except.ListError;
import java_cup.runtime.Symbol; 
 
public class App { 

    public static void main(String[] args) throws Exception { 
        // texte do rayanzin game plays
        String rootPath = Paths.get("").toAbsolutePath().toString(); 
        String inputFilePath = rootPath + "\\src\\input.txt"; 
        ListError listError = new ListError(); 
        FileReader in = new FileReader(inputFilePath); 
        Yylex scanner = new Yylex(in, listError); 
        Parser parser = new Parser(scanner); 
        try { 
            parser.parse(); 
        } catch (Exception e) { 
            System.out.print(""); 
        } 
        if (listError.hasErrors()) { 
            listError.logErrors(); 
        } else { 
            System.out.println("Sintaxe correta!"); 
            if (parser.deveImprimir) {
                if ("digrafo".equals(parser.type)) {
                    Digrafo.printAdjacency(parser.digrafo);
                } else {
                    Grafo.printAdjacency(parser.grafo);
                }
            }
        }
    } 
}