import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Map<String, String> dizionario = new HashMap<>();
        dizionario.put("cane", "animale domestico");
        dizionario.put("gatto", "animale domestico");
        dizionario.put("cavallo", "animale da corsa");
        dizionario.put("elefante", "animale selvatico");
        dizionario.put("tigre", "animale selvatico");
        dizionario.put("pappagallo", "animale da compagnia");
        dizionario.put("scoiattolo", "animale selvatico");
        dizionario.put("formica", "insetto");
        dizionario.put("ragno", "insetto");
        dizionario.put("mosca", "insetto");

        //stampa il dizionario
        System.out.println("Dizionario:");
        for (Map.Entry<String, String> entry : dizionario.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //cerca la definizione di un animale
        System.out.print("Di quale animale vuoi sapere la definizione?: ");
        String animale = scanner.nextLine();
        System.out.println("La definizione di " + animale + " è: " + dizionario.get(animale));
    }
}