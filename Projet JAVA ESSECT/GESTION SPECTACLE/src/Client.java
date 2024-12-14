import java.util.Scanner;

public class Client extends Utilisateur{


    public Client(String nom, String motDePasse) {
        super(nom, motDePasse);
    }

    public int ChoixSpectacles(){
        Scanner input = new Scanner(System.in);
        System.out.println("*********************************");
        System.out.println("0 : Exit");
        System.out.println("1 : Voir les Spectacles Disponible");
        System.out.println("2 : Retour au menu principal (Log In)");
        System.out.println("*********************************");
        System.out.println("----Entrer votre Choix : ");
        return input.nextInt();
    }
}
