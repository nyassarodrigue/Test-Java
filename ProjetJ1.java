import java.util.Scanner;

public class ProjetJ1 {
    public static void main (String [] args) {
        System.out.print ("Entrer votre nom :");
        Scanner scanner = new Scanner (System.in);
        String nom = scanner.nextLine();
        System.out.println ();
        System.out.println ("\nBonjour, " + nom + "!" + "\nBienvenue dans le monde de Java.");

        scanner.close();
    }


    
}
