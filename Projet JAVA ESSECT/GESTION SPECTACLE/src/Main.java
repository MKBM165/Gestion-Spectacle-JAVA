import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
     //base de donnes locale
        //declaration pour l authentification
        Admin admin=new Admin(1,"Admin","Admin123");
        Utilisateur[] tutilisateurs = new Utilisateur[4];
        Client c1=new Client(2,"Client1","mdpclient1");
        Client c2=new Client(3,"Client2","mdpclient2");
        Gestionnaire g1=new Gestionnaire(4,"Gest1","Gestionnaire1");
        Gestionnaire g2=new Gestionnaire(5,"Gest2","Gestionnaire2");
        tutilisateurs[0]=c1;
        tutilisateurs[1]=c2;
        tutilisateurs[2]=g1;
        tutilisateurs[3]=g2;
        String inputnom;
        String inputmdp;
        //****************
        //declaration des Spectacles
        Spectacle s1 =new Spectacle(1,"Venum","12/12/2024","Action",120);
        Spectacle s2 =new Spectacle(2,"The Conjuring","15/11/2024","Horror",90);
        Spectacle s3 =new Spectacle(3,"The Notebook","21/11/2024","Romance",160);


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
            //affichage fi wost l main walla najmou nhotouh fi wost lclass client

            switch (((Client) user).ChoixSpectacles()){
                case 1 :
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