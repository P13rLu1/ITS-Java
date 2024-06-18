package Thread;

public class EnumeratorePariDispari extends Thread{
    private int limiteSuperiore;
    private boolean pari;

    public EnumeratorePariDispari(int n, boolean pari){
        this.limiteSuperiore = n;
        this.pari = pari;
    }

    public void run(){
        for(int i=0; i<limiteSuperiore; i++){
            if (pari){
                if(1%2 == 0){
                    System.out.println("Pari: " + i);
                } else {
                    if (i%2 != 0){
                        System.out.println("Dispari: " + i);
                    }
                }
            }
        }
    }
}
