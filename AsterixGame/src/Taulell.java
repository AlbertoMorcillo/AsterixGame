import java.util.ArrayList;

public class Taulell {
    private int columnes;
    private int files;
    private static char[][] taulell;

    public Taulell(int files, int columnes) {
        this.files = files;
        this.columnes = columnes;
    }

    public void dibu() {
        taulell = new char[files][columnes];
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                System.out.print(" " + taulell[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void init(Pocio p, Jugador jug, ArrayList<Enemic> enemics) {
        for (int i = 0; i < files; ++i) {
            for (int j = 0; j < columnes; ++j) {
                if (i == 0 || j == 0 || i == files - 1 || j == columnes - 1) taulell[i][j] = '#';
                else taulell[i][j] = ' ';
            }
        }
        taulell[jug.coords.fila] [jug.coords.columna] = jug.nom;
        taulell[p.coords.fila] [p.coords.columna] = p.nom;

        for (int i = 0; i < enemics.size(); i++) {
            Enemic e = enemics.get(i);
            taulell[e.coords.fila] [e.coords.columna] = e.nom;
        }
    }
}
