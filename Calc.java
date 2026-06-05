import java.util.Scanner;

public class Calc {
    public static void main ( String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Bienvenue sur cette calculatrice java");
        System.out.print ("Entrer le premier nomnbre ");

        int Nbre = scanner.nextInt();

        System.out.print ("Entrer un second nombre ");
        int Nbre2 = scanner.nextInt();

        int nbre3 = Nbre + Nbre2 ;

        System.out.println ("la somme est : " + nbre3);

        scanner.close();       

    }
    
}
