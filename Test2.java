import java.util.Scanner;

public class Test2 {
    public static void main (String [] args ) { // point d'entrée de l'application 
        System.out.println ("Entrer votre âge :"); // affichage 
        Scanner scanner = new Scanner (System.in); // lecture de l'instruction tapée au clavier

        int age = scanner.nextInt(); // recuperation d'un entier
        System.out.print ("Vous avez : " + age + " ANS");
    }
    
}
