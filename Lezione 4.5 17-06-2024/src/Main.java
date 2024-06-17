import Poligoni.Poligono;
import Poligoni.Quadrato;
import Poligoni.Rettangolo;
import Poligoni.Triangolo;

public class Main {
    public static void main(String[] args) {
        Rettangolo rettangolo = new Rettangolo(3, 7);
        Quadrato quadrato = new Quadrato(5);
        Triangolo triangolo = new Triangolo(3, 7);
        Poligono[] listaPoligoni = new Poligono[3];
        listaPoligoni[0] = rettangolo;
        listaPoligoni[1] = quadrato;
        listaPoligoni[2] = triangolo;

        for (Poligono p:listaPoligoni){
            System.out.println(p);
        }
    }
}