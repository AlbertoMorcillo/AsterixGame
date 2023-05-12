public class Taulell {
    private int columnes;
    private int files;
    private static char[][] taulell;

    public Taulell(int files, int columnes){
        this.files = files;
        this.columnes = columnes;
    }
    public void dibu(){
        taulell = new char[files][columnes];
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                System.out.print(" " + taulell[i][j] + " ");
            }
        }
    }
    public void init (Pocio p, Jugador jug, Enemic[] enemics){

    }
}
