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
        p.ajoutspectacle(c);
        System.out.println("Spectacle ajouté!");
    }

    public int menugestionnarie(){
        int choix;
        do {
            System.out.println("*********************************");
            System.out.println("1 : Ajouter un spectacle");
            System.out.println("2 : Modifier un spectacle");
            System.out.println("3 : Afficher spectacles");
            System.out.println("4 : Supprimer un spectacle");
            System.out.println("5 : Afficher diffusion");
            System.out.println("6 : Ajouter / supprimer diffusion");
            System.out.print("Entrez votre choix : ");
            choix= sc.nextInt();
        }while(choix>5||choix<0);
        return choix;
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

        System.out.print("Entrez le numéro du spectacle : ");
        int indice = sc.nextInt();
        sc.nextLine(); // Clear the buffer

        if (indice> p.getNombreSpectacles()) {
            System.out.println("Numéro de spectacle invalide.");
            return;
        }

        Spectacle spectacle = p.getSpectacle(indice - 1);

        System.out.println("Quoi modifier dans le spectacle ?");
        System.out.println("1 : Titre");
        System.out.println("2 : Type");
        System.out.println("3 : Durée");
        System.out.println("4 : Date");
        System.out.print("Entrez votre choix : ");
        int choix = sc.nextInt();
        sc.nextLine(); // Clear the buffer

        switch (choix) {
            case 1 -> {
                System.out.print("Donner le nouveau titre : ");
                String newTitre = sc.nextLine();
                modifiertitre(spectacle, newTitre);
                System.out.println("Titre modifié avec succès !");
            }
            case 2 -> {
                System.out.print("Donner le nouveau type : ");
                String newType = sc.nextLine();
                modifiertype(spectacle, newType);
                System.out.println("Type modifié avec succès !");
            }
            case 3 -> {
                System.out.print("Donner la nouvelle durée : ");
                int newDuree = sc.nextInt();
                spectacle.setDuree(newDuree);
                System.out.println("Durée modifiée avec succès !");
            }
            case 4 ->{
                System.out.println("Donner la nouvelle Date");
                String newDate=sc.nextLine();
                spectacle.setDate(newDate);
            }
            default -> System.out.println("Choix invalide.");
        }
        p.afficherSpectacle(indice-1);
    }

    public void supprimerSpectacle(Planning p)
    {
        System.out.println("Donner l'indice du spectacle a supprimer");
        int indice= sc.nextInt();
        indice--;
        p.supprimerSpectacle(indice);
    }

    public void ajouterDiffusion(Planning p){
        System.out.println("Donner l'id de la diffusion :");
        int id_diff= sc.nextInt();
        System.out.println("Donner la date de la diffusion :");
        String date= sc.nextLine();
        System.out.println("Donner l'heure de debut :");
        String heureDebut=sc.nextLine();
        System.out.println("Pour quelle spectacle ? : ");
        p.afficherSpectacle();
        System.out.println("Entrez le numero du spectacle :");
        int numspec= sc.nextInt();
        Spectacle s=p.getSpectacle(numspec-1);
        System.out.println("Choisir une salle : ");
        System.out.print("Entrez le numéro de la salle : ");
        int numSalle = sc.nextInt();
        Salle salle = new Salle(numSalle, 100);
        Diffusion nouvelleDiffusion = new Diffusion(id_diff, date, heureDebut, s, salle, p);
        p.ajoutdiff(nouvelleDiffusion);
        System.out.println("Diffusion ajoutée avec succès !");



    }

    public void supprimerDiffusion(Planning p) {
        System.out.println("Choisissez la diffusion à supprimer :");
        p.affichediffusion();
        System.out.print("Entrez le numéro de la diffusion : ");
        int indice = sc.nextInt();
        p.supprimerDiffusion(indice - 1);
    }

}

