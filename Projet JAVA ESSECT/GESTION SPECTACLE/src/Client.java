import java.util.Scanner;

public class Client extends Utilisateur{

    public Client(int id,String nom,String mdp) {
        super.setnom(nom);
        super.setMotDePasse(mdp);
        super.setId(id);
    }
    public int ChoixSpectacles(){
        Scanner input = new Scanner(System.in);
        System.out.println("*********************************");
        System.out.println("1 : Voir les Spectacles Disponible");
        System.out.println("2 : exit");
        System.out.println("*********************************");
        System.out.println("----Entrer votre Choix : ");
        return input.nextInt();
    }

}
