import java_cup.runtime.Symbol;
import except.ListError;

%%

%cup
%unicode
%line
%column

%{
  int yyline = 0;
  int yycolumn = 0;
%}


%{ 

    private ListError listError; 
 
    public Yylex(java.io.FileReader in, ListError listError) { 
        this(in); 
        this.listError = listError; 
    } 
 
    public ListError getListError() { 
        return listError; 
    } 
 
    public void defineError(int line, int column, String text) { 
        this.listError.defineError(line, column, text); 
    } 
 
    public void defineError(int linha, int coluna) { 
        this.listError.defineError(linha, coluna); 
    }

    public void defineError(String texto) { 
        this.listError.defineError(texto); 
    } 
 
    public Symbol createSymbol(int token, Object value) {
        System.out.println("Token: " + token + " | Lexema: " + value + " | Linha: " + (yyline + 1) + " | Coluna: " + (yycolumn + 1));
        return new Symbol(token, yyline, yycolumn, value); 
    } 
 
    public Symbol createSymbol(int token) {
        return this.createSymbol(token, null); 
    } 

%}

espaco = [ \n\r\t]+
letra = [a-zA-Z_]
digito = [0-9]
id = {letra}({letra}|{digito})*
idErrado = {digito}({letra}|{digito})*

%%

"GRAPH"         { return createSymbol(Sym.GRAPH); }
"vertex"        { return createSymbol(Sym.vertex); }
"edge"          { return createSymbol(Sym.edge); }
"directed"      { return createSymbol(Sym.directed); }
"undirected"    { return createSymbol(Sym.undirected); }
"print"         { return createSymbol(Sym.print); }
"adjacency"     { return createSymbol(Sym.adjacency); }
":"             { return createSymbol(Sym.colon); }
"->"            { return createSymbol(Sym.arrow); }
"--"            { return createSymbol(Sym.line); }
{id}            { return createSymbol(Sym.ID, yytext()); }
{espaco}        { /* ignora espaços */ }
{idErrado}      { return createSymbol(Sym.IDerrado, yytext()); }
.               { 
                    defineError(yyline , yycolumn , "Sintaxe inválida, comando desconhecido: " + yytext()); 
                    return createSymbol(Sym.EOF);       
                }
\n              { yyline++; yycolumn = 0; }
\r\n?           { yyline++; yycolumn = 0; } // caso Windows
.               { yycolumn++; }

<<EOF>>         { return createSymbol(Sym.EOF); }

// Regras para rastrear linha e coluna
\n              { yyline++; yycolumn = 0; return (Symbol) null; }
\r\n?           { yyline++; yycolumn = 0; return (Symbol) null; }
.               { yycolumn++; return (Symbol) null; }
