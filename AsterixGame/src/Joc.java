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
        legionaris.add(new Enemic('L', new Coordenades(1, 1)));
        legionaris.add(new Enemic('L', new Coordenades(FILES - 2, COLUMNES - 2)));
        legionaris.add(new Enemic('L', new Coordenades(1, COLUMNES - 2)));
        legionaris.add(new Enemic('L', new Coordenades(FILES - 2, 1)));
        do {
            bosc.init(pocio, asterix, legionaris);
            bosc.dibu();
            fi = mouJugador();
            if (!fi) mouEnemics();
        } while (!fi);
    }

    public static void mouEnemics() {
        for (int i = 0; i < legionaris.size(); i++) {
            if (legionaris.get(i).coords.fila > asterix.coords.fila) {
                legionaris.get(i).mouU();
            } else if (legionaris.get(i).coords.fila < asterix.coords.fila) {
                legionaris.get(i).mouD();
            } else {
                if (legionaris.get(i).coords.columna > asterix.coords.columna) {
                    legionaris.get(i).mouL();
                } else if (legionaris.get(i).coords.columna < asterix.coords.columna) {
                    legionaris.get(i).mouR();
                }
            }
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
    public static boolean mouJugador() {
        char opcion;
        boolean finalizar;
        do {
            System.out.println("¿Qué movimiento quieres hacer?");
            System.out.println("A - Left");
            System.out.println("D - Right");
            System.out.println("W - Up");
            System.out.println("S - Down");
            System.out.println("X - Exit");
            opcion = scan.nextLine().toUpperCase().charAt(0);
        } while (!(opcion == 'A' || opcion == 'D' || opcion == 'W' || opcion == 'S' || opcion == 'X'));

        switch (opcion) {
            case 'A':
                asterix.mouL();
                finalizar = false;
                break;
            case 'D':
                asterix.mouR();
                finalizar = false;
                break;
            case 'W':
                asterix.mouU();
                finalizar = false;
                break;
            case 'S':
                asterix.mouD();
                finalizar = false;
                break;
            default:
                finalizar = true;
        }
        if (asterix.getEnergia() > 0) {
            asterix.restarEnergia();
        }
        if (asterix.coords.fila == pocio.coords.fila && asterix.coords.columna == pocio.coords.columna) {
            asterix.prenPocio();
        }
        for (int i = 0; i < legionaris.size(); i++) {
            if (asterix.coords.fila == legionaris.get(i).coords.fila && asterix.coords.columna == legionaris.get(i).coords.columna)
            {
                if (asterix.energia > 0) {
                    legionaris.remove(i);
                    --i;
                } else {
                    return true;
                }
            }
        }
        return finalizar;
    }
    //ToDo: Comprobar que el jugador si tiene la pocion si la vuelve a tocar que no se le vuelva a rellenar.
    //ToDo: Hacer que si el jugador tome la pocion la letra "p" desaparezca (no borrarla).
    //ToDo: mirar el orden que tienen de comprobar si el legionario ha matado a asterix o no.
    //ToDo: Hacer que la poción vuelva a salir de forma aleatoria.
    public static Coordenades posicioAleatoria() {
        int fila = (int) (Math.random() * (FILES - 4) + 2);
        int columna = (int) (Math.random() * (COLUMNES - 4) + 2);
        return new Coordenades(fila, columna);
    }
}