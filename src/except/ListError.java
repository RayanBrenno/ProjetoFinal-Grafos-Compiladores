package except;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List; 

public class ListError {
    private List<Error> errors; 
 
    public ListError() { 
        this.errors = new java.util.ArrayList<Error>(); 
    } 
    
    public void defineError(int line, int column, String text) { 
        this.errors.add(new Error(line, column, text)); 
    } 
 
    public void defineError(int line, int column) { 
        this.errors.add(new Error(line, column, null)); 
    } 
 
    public void defineError(String text) { 
        for(Error e : this.errors) { 
            if(e.getText() == null) { 
                e.setText(text); 
                return; 
            } 
        } 
    } 
 
    public void logErrors() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/erros.log"))) {
            for (Error e : this.errors) {
                writer.write(e.print()); // usa a formatação personalizada do erro
                writer.newLine();
            }
        } catch (IOException ex) {
            System.err.println("Erro ao escrever no arquivo de log: " + ex.getMessage());
        }
    }
 
    public boolean hasErrors() { 
        return this.errors.size() > 0; 
    } 
     
}
