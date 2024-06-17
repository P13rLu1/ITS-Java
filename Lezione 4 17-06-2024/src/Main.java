import Animalo.Animale;
import Animalo.Cane;
import Animalo.Gatto;

public class Main {
    public static void main(String[] args) {
        Cane cane = new Cane("Fido", "Pastore Tedesco", 5, "croccantini");
        Gatto gatto = new Gatto("Fuffi", "Persiano", 3, "scatolette");
        Animale[] listaAnimali = new Animale[2];
        listaAnimali[0] = cane;
        listaAnimali[1] = gatto;

        for (Animale a:listaAnimali){
            System.out.printf("Il %s mangia %s\n", a, a.cosaMangia());
        }
    }
}