public abstract class Personatge extends Element implements Moviment {
    int energia = 0;
    int velocitat;

    public Personatge(char nom, Coordenades c, int velocitat) {
        super(nom, c);
        this.velocitat = velocitat;
    }


    @Override
    public void mouD() {

    }

    @Override
    public void mouL() {

    }

    @Override
    public void mouR() {

    }

    @Override
    public void mouU() {

    }

    @Override
    public void setVelocitat(int velocitat) {
     //int velocitatConPocio = velocitat + 1;

    }
}
