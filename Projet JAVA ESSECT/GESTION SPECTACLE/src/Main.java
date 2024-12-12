import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
     //base de donnes locale
        //declaration pour l authentification

        Client c1=new Client("Client1","mdpclient1");
        Client c2=new Client("Client2","mdpclient2");
        Gestionnaire g1=new Gestionnaire("Gest1","Gestionnaire1");
        Gestionnaire g2=new Gestionnaire("Gest2","Gestionnaire2");
        Utilisateur[] tutilisateurs = {c1,c2,g1,g2};
        String inputnom;
        String inputmdp;

        //declaration planning
        Planning plan = new Planning();
        //declaration des Salle
        Salle salle1 = new Salle(1,100);
        Salle salle2 = new Salle(2,70);
        //declaration des Spectacles
        Spectacle s1 =new Spectacle(1,"Venum","12/12/2024","Action",120,plan);
        Spectacle s2 =new Spectacle(2,"The Conjuring","15/11/2024","Horror",90,plan);
        Spectacle s3 =new Spectacle(3,"The Notebook","21/11/2024","Romance",160,plan);
        //declaration des diffusions
        Diffusion d1= new Diffusion(1,"22/12/2024","20:00",s1,salle1,plan);
        Diffusion d2= new Diffusion(2,"22/12/2024","20:00",s3,salle2,plan);
        Diffusion d3= new Diffusion(1,"20/12/2024","21:00",s2,salle1,plan);

        //authentification
        do {
        System.out.println("entrer le nom : ");
        inputnom=input.nextLine();
        System.out.println("entrer le mdp : ");
        inputmdp=input.nextLine();
        System.out.println(authentification(tutilisateurs,inputnom,inputmdp));//return
        }while (authentification(tutilisateurs,inputnom,inputmdp)==null);


        Utilisateur user =authentification(tutilisateurs,inputnom,inputmdp);
        if (user instanceof Client){
            Client c = (Client) user;
            switch (c.ChoixSpectacles()){
                case 1 ->{
                    plan.affichespectacle();
                }//A continuer scenario
                case 2->
                    System.out.println("exit");//A faire
        }
        }

        //gestionnaire
        if(user instanceof Gestionnaire){
            Gestionnaire g=(Gestionnaire)user;
            switch (g.menugestionnarie()){
                case 1-> g.ajoutspectacle(plan);
                case 2-> g.modifierSpectacle(plan);
                case 3-> plan.afficherSpectacle();
                case 4->g.supprimerSpectacle(plan);
                case 5->plan.affichediffusion();
                case 6->{
                    System.out.println("1 : Ajouter une diffusion");
                    System.out.println("2 : Supprimer une diffusion");
                    System.out.println("Entrez votre choix :");
                    int choix= input.nextInt();
                    {
                        if (choix==1)
                        {g.ajouterDiffusion(plan);}
                        else if(choix==2)
                        {g.supprimerDiffusion(plan);}
                    }
                }
            }
        }
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