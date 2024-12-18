import java.util.Scanner;
import java.time.*;
public class Main {
    public static void main(String[] args)
    {
        //modifier l acces de client
        //problem dans affichage apreès l ajout dun spectacle
        Scanner input=new Scanner(System.in);
        //après sc.nextInt() -> sc.nextline(); pour vider le champs
        int scenario = 0;
        //quand le scenario = 0 : afficher le menu principal(Log In)
        //quand le scenario = 1 : quitter le programme
        //quand le scenario = 2 : quitter le prograame a cause de l'authentification
        //quand le scenario = 3 : retour au menu
        //base de donnes locale
        //declaration pour l authentification

        Client c1=new Client("c1","mdpc1");
        Client c2=new Client("c2","mdpc2");
        Gestionnaire g1=new Gestionnaire("g1","mdpg1");
        Gestionnaire g2=new Gestionnaire("g2","mdpg2");
        Utilisateur[] tutilisateurs = {c1,c2,g1,g2};
        String inputnom;
        String inputmdp;

        //declaration planning
        Planning plan = new Planning();
        //declaration des Salle
        Salle salle1 = new Salle(1,100,plan);
        Salle salle2 = new Salle(2,70,plan);
        //declaration des Spectacles
        Spectacle s1 =new Spectacle(1,"Venum","12/12/2024","Action",120,plan);
        Spectacle s2 =new Spectacle(2,"The Conjuring","15/11/2024","Horror",90,plan);
        Spectacle s3 =new Spectacle(3,"The Notebook","21/11/2024","Romance",160,plan);
        //declaration des diffusions
        Diffusion d1= new Diffusion(1,"22/12/2024","20:00",s1,salle1,plan);
        Diffusion d2= new Diffusion(2,"22/12/2024","20:00",s3,salle2,plan);
        Diffusion d3= new Diffusion(3,"20/12/2024","21:00",s2,salle1,plan);
        Diffusion d4= new Diffusion(4,"30/12/2024","08:00",s3,salle2,plan);
        Diffusion d5= new Diffusion(5,"20/12/2024","12:00",s1,salle1,plan);
        Diffusion d6= new Diffusion(6,"20/12/2024","21:00",s3,salle1,plan);
        Diffusion d7= new Diffusion(7,"20/12/2024","19:00",s2,salle2,plan);
        Diffusion d8= new Diffusion(8,"20/12/2024","22:00",s2,salle1,plan);

        //authentification
        do {
            int authentifCount=1;
            do {
                System.out.println("Trial "+authentifCount+" / 3" );
                System.out.println("*********************************");
                System.out.println("--- entrer le nom d'utilisateur : ");
                inputnom=input.nextLine();
                System.out.println("--- entrer le mdp : ");
                inputmdp=input.nextLine();
                System.out.println("*********************************");
                authentifCount++;
            }while (authentification(tutilisateurs,inputnom,inputmdp)==null && authentifCount<=3);
            if (authentifCount>3){
                scenario=2;
                System.out.println("Fin d'épreuve ...");

            }
            else {
                System.out.println("Connexion réussie");
                Utilisateur user = authentification(tutilisateurs, inputnom, inputmdp);
                if (user instanceof Client) {
                    Client c = (Client) user;
                    do {

                    switch (c.ChoixSpectacles()) {
                        case 0 -> scenario = 1;
                        case 1 -> {
                            plan.affichespectacle();
                            scenario = 3;
                        }
                        case 2 -> scenario = 0;
                    }
                    }while (scenario == 3);
                }
                //gestionnaire
                else if (user instanceof Gestionnaire) {
                    Gestionnaire g = (Gestionnaire) user;
                    do {
                        scenario=3;
                        switch (g.menugestionnarie()) {
                            case 0 -> scenario = 1;
                            case 1 -> g.ajoutspectacle(plan);
                            case 2 -> g.modifierSpectacle(plan);
                            case 3 -> plan.afficherSpectacle();
                            case 4 -> g.supprimerSpectacle(plan);
                            case 5 -> plan.afficherDiffusionGestion();
                            case 6 -> g.ajouterDiffusion(plan);
                            case 7 -> g.supprimerDiffusion(plan);
                            case 8 -> scenario = 0;
                        }
                    }while (scenario == 3);
                }
            }
        }while (scenario==0);
        System.out.println("Exit...");
    }

    public static Utilisateur authentification(Utilisateur[] tutils,String inputnom , String inputmdp){
        int i=0;
        while(i<tutils.length){
            if (tutils[i].getnom().equals(inputnom) && tutils[i].getMotDePasse().equals(inputmdp)){
                return tutils[i];
            }
            i++;
        }
        return null;
    }

}