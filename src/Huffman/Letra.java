//@author Barillas
package Huffman;
public class Letra {   
    private char Caracter;
    private int Frecuencia;
    
    public Letra(char Caracter){
        this.Caracter = Caracter;
        Frecuencia = 1;
    }

    public char getCaracter() {
        return Caracter;
    }

    public void setCaracter(char Caracter) {
        this.Caracter = Caracter;
    }

    public int getFrecuencia() {
        return Frecuencia;
    }

    public void setFrecuencia(int Frecuencia) {
        this.Frecuencia = Frecuencia;
    }
}