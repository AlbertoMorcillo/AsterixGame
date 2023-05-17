import java.util.ArrayList;
import java.util.Scanner;

public class Joc {
    private static Jugador asterix;
    private static Taulell bosc;
    private static Pocio pocio;
    static int COLUMNES = 20;
    static int FILES = 20;
    private static boolean fi;
    private static ArrayList<Enemic> legionaris = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
            bosc = new Taulell(FILES, COLUMNES);
            pocio = new Pocio('P', posicioAleatoria());
            asterix = new Jugador('A', posicioAleatoria());
        legionaris.add(new Enemic('L', new Coordenades(1,1)));
        legionaris.add(new Enemic('L', new Coordenades(FILES-2,COLUMNES-2)));
        legionaris.add(new Enemic('L', new Coordenades(1,COLUMNES-2)));
        legionaris.add(new Enemic('L', new Coordenades(FILES-2,1)));
            do {
                bosc.init(pocio, asterix, legionaris);
                bosc.dibu();
                fi = mouJugador();
                if (!fi) fi = mouEnemics();
            } while (!fi);
    }
    public static boolean mouEnemics(){
        //ToDo: Son 4 líneas de código.
        for (int i = 0; i < legionaris.size(); i++) {
            if(legionaris.get(i).coords.fila > asterix.coords.fila){
                legionaris.get(i).mouU();
            }else if(legionaris.get(i).coords.fila < asterix.coords.fila){
                legionaris.get(i).mouD();
            } else{
               if (legionaris.get(i).coords.columna > asterix.coords.columna){
                   legionaris.get(i).mouL();
               }
               else if (legionaris.get(i).coords.columna < asterix.coords.columna){
                   legionaris.get(i).mouR();
               }
            } {
                legionaris.get(i).mouL();
            }
        }

        /*
* IF F(L) > F(A) = para arriba
* else if F(L) <  F(A) = para abajo
* else{
* IF C(L) > C(A) = para izquierda
 * else if C(L) <  C(A) = para derecha
* }
*
* */


        return true;
    }
    public static boolean mouJugador(){
        char opcion;
        do {
            System.out.println("¿Qué movimiento quieres hacer?");
            System.out.println("A - Left");
            System.out.println("D - Right");
            System.out.println("W - Up");
            System.out.println("S - Down");
            System.out.println("X - Exit");
            opcion = scan.nextLine().toUpperCase().charAt(0);
        } while(!(opcion == 'A' || opcion == 'D' || opcion == 'W' || opcion == 'S' || opcion == 'X'));

        switch (opcion){
            case 'A':
                asterix.mouL();
                return false;
            case 'D':
                asterix.mouR();
              return false;
            case 'W':
                asterix.mouU();
                return false;
            case 'S':
                asterix.mouD();
                return false;
            default:
                return true;
        }
    }
    public static Coordenades posicioAleatoria(){
        int files = (int) (Math.random() * (FILES - 2 + 1) + 2);
        int columnes = (int) (Math.random() * (COLUMNES - 2 + 1) + 2);
        return new Coordenades(files, columnes);
    }
}