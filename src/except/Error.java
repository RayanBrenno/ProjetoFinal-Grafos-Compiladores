package except;

public class Error {

    private int line, column;
    private String text;

    public Error(int line, int column, String text) {
        this.line = line;
        this.column = column;
        this.text = text;
    }

    public String print() {
        String aux = "Erro na linha " + (line+1) + " e coluna " + (column+1) + ": ";
        if (this.text == null)
            aux += "Erro desconhecido";
        else
            aux += this.text;
        return aux;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
