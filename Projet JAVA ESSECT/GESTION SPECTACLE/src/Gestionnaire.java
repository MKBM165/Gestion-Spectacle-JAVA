import java.util.Scanner;
public class Gestionnaire extends Utilisateur {
    Scanner sc=new Scanner(System.in);

    public Gestionnaire(String nom, String motDePasse) {
        super(nom, motDePasse);
    }

    public void ajoutspectacle(Planning p)
    {  System.out.println("Donner l'id du spectacle");
        int id= sc.nextInt();
        System.out.println("Donner le titre du spectacle :");
        String titre=sc.nextLine();
        System.out.println("Donner le type de spectale :");
        String type=sc.nextLine();
        System.out.println("Donner la date du spectacle :");
        String date=sc.nextLine();
        System.out.println("Donner la duree du spectacle");
        int duration=sc.nextInt();
        Spectacle c=new Spectacle(id,titre,date,type,duration,p);
    }
    public void modifiertitre(Spectacle c,String titre)
    {
        c.setTitre(titre);
    }
    public void modifiertype(Spectacle c,String type)
    {
        c.setType(type);
    }

}
