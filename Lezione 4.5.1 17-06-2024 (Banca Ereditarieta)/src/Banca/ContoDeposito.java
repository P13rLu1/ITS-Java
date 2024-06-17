package Banca;

public class ContoDeposito extends ContoCorrente {
    private double tassoInteresse;

    public ContoDeposito(String iban, double tassoInteresse) {
        super(iban);
        this.tassoInteresse = tassoInteresse;
    }

    // Metodo per depositare denaro nel conto corrente
    public void deposita(double importo) {
        setSaldo(getSaldo() + importo);
    }

    // Metodo per prelevare denaro dal conto corrente
    public void preleva(double importo) {
        System.out.println("Operazione non consentita");
    }

    // Metodo per calcolare gli interessi maturati
    public void calcolaInteressi() {
        double interessi = getSaldo() * tassoInteresse / 100;
        setSaldo(getSaldo() + interessi);
    }
}
