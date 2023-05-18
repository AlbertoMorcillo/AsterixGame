public class Jugador extends Personatge{

    public Jugador(char nom, Coordenades c) {
        super(nom, c, 1);
    }

    void prenPocio(){
        energia = 10;
        velocitat = 2;
    }
    void restarEnergia(){
        --energia;
    }
    public int getEnergia(){
        return energia;
    }
}
