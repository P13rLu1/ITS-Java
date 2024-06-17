package Banca;

public class ContoFiduciario extends ContoCorrente {
    int fido;

    public ContoFiduciario(String iban, int fido) {
        super(iban);
        this.fido = fido;
    }

    // Metodo per depositare denaro nel conto corrente
    public void deposita(double importo) {
        setSaldo(getSaldo() + importo);
    }

    // Metodo per prelevare denaro dal conto corrente
    public void preleva(double importo) {
        if (getSaldo() - importo < -fido) {
            System.out.println("Fido insufficiente");
        } else {
            setSaldo(getSaldo() - importo);
        }
    }
}
