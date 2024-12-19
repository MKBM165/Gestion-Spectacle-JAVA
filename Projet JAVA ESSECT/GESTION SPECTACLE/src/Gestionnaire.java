import java.util.Scanner;
import java.time.*;
public class Gestionnaire extends Utilisateur {
    Scanner sc=new Scanner(System.in);

    public Gestionnaire(String nom, String motDePasse) {
        super(nom, motDePasse);
    }

    public void ajoutspectacle(Planning p)
    {  System.out.println("Donner l'id du spectacle");
        int id= sc.nextInt();
        sc.nextLine();
        System.out.println("Donner le titre du spectacle :");
        String titre=sc.nextLine();
        System.out.println("Donner le type de spectale :");
        String type=sc.nextLine();
        System.out.println("Donner la date du spectacle :");
        String date=sc.nextLine();
        System.out.println("Donner la duree du spectacle");
        int duration=sc.nextInt();
        sc.nextLine();
        Spectacle c=new Spectacle(id,titre,date,type,duration,p);
        System.out.println("Spectacle ajouté!");
    }

    public int menugestionnarie(){
        int choix;
        do {
            System.out.println("*********************************");
            System.out.println("0 : exit");
            System.out.println("1 : Ajouter un spectacle");
            System.out.println("2 : Modifier un spectacle");
            System.out.println("3 : Afficher spectacles");
            System.out.println("4 : Supprimer un spectacle");
            System.out.println("5 : Afficher diffusion");
            System.out.println("6 : Ajouter  diffusion");
            System.out.println("7 : Supprimer diffusion");
            System.out.println("8 : Afficher le Total des Billets vendus");
            System.out.println("9 : Retour au menu principal (Log In)");
            System.out.print("--- Entrez votre choix : ");
            choix= sc.nextInt();
        }while(choix>9 || choix<0);
        return choix;
    }
    public void totBilletsVendus(Planning p){
        int totbillets =p.totbillets();
        double totvente= totbillets*1000;
        System.out.println("*********************************");
        System.out.println("le Total des Billets Vendus est : "+totbillets);
        System.out.printf("le  Total des Ventes est : %.2f DT\n",totvente);
    }
    public void modifiertitre(Spectacle c,String titre)
    {
        c.setTitre(titre);
    }
    public void modifiertype(Spectacle c,String type)
    {
        c.setType(type);
    }

    public void modifierSpectacle(Planning p) {

        System.out.println("Choisissez le spectacle à modifier :");
        p.afficherSpectacle();

        System.out.print("--- Entrez le numéro du spectacle : ");
        int indice = sc.nextInt();
        sc.nextLine();

        if (indice> p.getNombreSpectacles()) {
            System.out.println("Numéro de spectacle invalide.");
            return;
        }

        Spectacle spectacle = p.getSpectacle(indice - 1);
        int choix=5;
        do {

        System.out.println("Choisir le type de modification ? ");
        System.out.println("0 : Annuler");
        System.out.println("1 : Titre");
        System.out.println("2 : Type");
        System.out.println("3 : Durée");
        System.out.println("4 : Date");
        System.out.print("--- Entrez votre choix : ");
        choix = sc.nextInt();
        sc.nextLine();

        switch (choix) {
            case 1 -> {
                System.out.print("--- Donner le nouveau titre : ");
                String newTitre = sc.nextLine();
                modifiertitre(spectacle, newTitre);
                System.out.println("Titre modifié avec succès !");
            }
            case 2 -> {
                System.out.print("--- Donner le nouveau type : ");
                String newType = sc.nextLine();
                modifiertype(spectacle, newType);
                System.out.println("Type modifié avec succès !");
            }
            case 3 -> {
                System.out.print("--- Donner la nouvelle durée : ");
                int newDuree = sc.nextInt();
                sc.nextLine();
                spectacle.setDuree(newDuree);
                System.out.println("Durée modifiée avec succès !");
            }
            case 4 ->{
                System.out.println("--- Donner la nouvelle Date");
                String newDate=sc.nextLine();
                spectacle.setDate(newDate);
            }
            default -> System.out.println("Choix invalide.");
        }
        }while (choix <0 || choix > 4);
        if (choix!=0)
            p.afficherSpectacle(indice-1);
    }

    public void supprimerSpectacle(Planning p)
    {
        int indice=-1;
        do {

        System.out.println("0 : Annuler");
        p.afficherSpectacle();
        System.out.println("--- Entrer l'indice du spectacle a supprimer");
        indice= sc.nextInt();
        sc.nextLine();
        }while (indice < 0 || indice>p.getNombreSpectacles());
        if (indice!=0)
            p.supprimerSpectacle(indice-1);
    }

    public void ajouterDiffusion(Planning p){
        System.out.println("Donner l'id de la diffusion :");
        int id_diff= sc.nextInt();
        sc.nextLine();
        System.out.println("Donner la date de la diffusion :");
        String date=sc.nextLine();
        System.out.println("Donner l'heure de debut :");
        String heureDebut=sc.nextLine();
        System.out.println("Pour quelle spectacle ? : ");
        p.afficherSpectacle();
        System.out.println("Entrez le numero du spectacle :");
        int numspec= sc.nextInt();
        Spectacle s=p.getSpectacle(numspec);
        System.out.println("Choisir une salle : ");
        p.afficherSalle();
        System.out.print("Entrez le numéro de la salle : ");
        int numSalle = sc.nextInt();
        Salle salle = p.getSalle(numSalle);
        Diffusion nouvelleDiffusion = new Diffusion(id_diff, date, heureDebut, s, salle, p);
        System.out.println("Diffusion ajoutée avec succès !");



    }

    public void supprimerDiffusion(Planning p) {
        System.out.println("Choisissez la diffusion à supprimer :");
        p.afficherDiffusionGestion();
        System.out.print("Entrez le numéro de la diffusion : ");
        int indice = sc.nextInt();
        p.supprimerDiffusion(indice - 1);
    }

}

