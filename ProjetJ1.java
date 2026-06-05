import java.util.Scanner; // importation de la classe Scanner pour lire les entrées de l'utilisateur

public class ProjetJ1 {
    // l'utilisateur entre son nom, puis affiche un message de bienvenue
    // personnalisé.
    public static void main(String[] args) { // point d'entrée du programme
        System.out.print("Entrer votre nom : "); // invite l'utilisateur à entrer son nom
        Scanner scanner = new Scanner(System.in); // création d'un objet Scanner pour lire les entrées au clavier
        String nom = scanner.nextLine(); // recupération du nom de l'utilisateur en tant que chaîne de caractères
        System.out.println(); // saut de ligne pour améliorer la lisibilité
        System.out.println("\nBonjour, " + nom + " !" + "\nBienvenue dans le monde de Java.");

        // convertisseur de distance
        System.out.print("Entrer une distance en kilomètres : ");
        double km = scanner.nextDouble(); // recuperation de la distance en km en nombre à virgule flottante
        double miles = km * 0.621371;
        System.out.print("La distance en miles est de : " + miles);
        System.out.println();

        // convertisseur de température
        System.out.println("Entrer une température en celsius : ");
        double celsius = scanner.nextDouble();
        double fahreinheit = (celsius * 9 / 5) + 32;
        System.out.println("La température en fahreinheit est de : " + fahreinheit);
        System.out.println();

        // convertisseur de Lb vers kg
        System.out.println("Entrer une masse en livres (lb) : ");
        double lb = scanner.nextDouble();
        double kg = lb * 0.453592;
        System.out.println("La masse en kg est de : " + kg);

        scanner.close();
    }

}
