import java.util.Scanner;

public class Joc {
    private static Jugador asterix;
    private static Taulell bosc;
    private static Pocio pocio;
    static int COLUMNES;
    static int FILES;
    private static boolean fi;
    private static Enemic[] legionaris = new Enemic[4];
    static Scanner scan = new Scanner(System.in);

    public Joc() {
        bosc = new Taulell(FILES, COLUMNES);
        pocio = new Pocio('P',posicioAleatoria());
        asterix = new Jugador('J',posicioAleatoria());
        fi = false;
        for (int i = 0; i < legionaris.length ; i++) {
            legionaris[i] = new Enemic((char)('1' + i), posicioAleatoria());
        }
    }

    public static void main(String[] args) {


    }
    public static boolean mouEnemics(){
        return true;
    }
    public static boolean mouJugador(){
        return true;
    }
    public static Coordenades posicioAleatoria(){


        return new Coordenades();
    }
}