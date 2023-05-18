public abstract class Personatge extends Element implements Moviment {
    int energia = 0;
    int velocitat;

    public Personatge(char nom, Coordenades c, int velocitat) {
        super(nom, c);
        this.velocitat = velocitat;
    }

    public void mouU() {
        if (coords.fila > 1) {
            --coords.fila;
        }
    }

    @Override
    public void mouD() {
        if (coords.fila < Joc.FILES - 2) {
          ++coords.fila;
        }
    }

    @Override
    public void mouL() {
        if (coords.columna > 1) {
            --coords.columna;
        }
    }

    @Override
    public void mouR() {
        if (coords.columna < Joc.COLUMNES - 2) {
            ++coords.columna;
        }
    }

    @Override
    public void setVelocitat(int velocitat) {
     //int velocitatConPocio = velocitat + 1;

    }
}
