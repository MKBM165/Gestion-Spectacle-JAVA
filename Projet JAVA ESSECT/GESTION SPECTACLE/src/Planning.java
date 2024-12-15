import java.util.Scanner;

public class Planning {
    private Diffusion[] diffusions = new Diffusion[100];
    private int nbdiff = 0;
    private Spectacle[] spectacles = new Spectacle[100];
    private int nbspec = 0;
    private Salle[] salles = new Salle[100];
    private int nbsalle =0;

    public void ajoutdiff(Diffusion d) {
        if (nbdiff < 100) {
            diffusions[nbdiff] = d;
            nbdiff++;
        } else {
            System.out.println("Planning saturée");
        }
    }
    public void ajoutSalle(Salle salle) {
        if (nbsalle < 100) {
            salles[nbsalle] = salle;
            nbsalle++;
        } else {
            System.out.println("Planning saturée");
        }
    }
    public void afficherSalle(){
        for (int i = 0; i <nbsalle ; i++) {
            System.out.println((i+1)+" : ");
            salles[i].afficher();
        }
    }
    public Salle getSalle(int i){
        return salles[i-1];
    }

    public void supprimerDiffusion(int indice) {
        if (indice >= 0 && indice < nbdiff) {
            for (int i=indice;i<nbdiff-1;i++) {
                diffusions[i]=diffusions[i+1];
            }
            diffusions[nbdiff - 1] = null;
            nbdiff--;
            System.out.println("Diffusion supprimée !");
        } else {
            System.out.println("Indice invalide");
        }
    }


    public void ajoutspectacle(Spectacle s){
        if(nbspec<100){
            spectacles[nbspec]=s;
            nbspec++;
        }
        else {
            System.out.println("Planning saturée");
        }
    }
    public void affichediffusion(){
        for(int i=0;i<nbdiff;i++){
            diffusions[i].afficher();
        }
    }
    public int affichespectacle(){
        Scanner input = new Scanner(System.in);
        int choix;
        System.out.println("0 : retour au menu principal");
        for(int i=0;i<nbspec;i++){
            System.out.println(i+1+" : ");
            spectacles[i].afficher();
        }
        System.out.println("Entrer votre Choix : ");
        choix = input.nextInt();
        //case choix du spectacle :
         if (choix < nbspec+1 && choix >0 ){
             spectacles[choix-1].afficherDiffusions();
        }
         return 0 ;
    }
    public void afficherSpectacle(){
        for (int i = 0; i < nbspec; i++) {

            System.out.println((i+1)+" : "+spectacles[i]);
        }
    }
    public void afficherSpectacle(int i) {
        if (i >= 0 && i < nbspec) {
            System.out.println(spectacles[i]);
        } else {
            System.out.println("Index invalide pour l'affichage du spectacle.");
        }
    }

    public Spectacle getSpectacle(int indice){
        return spectacles[indice-1];
    }
    public int getNombreSpectacles()
    {
        return nbspec;
    }
    public void supprimerSpectacle(int indice){
        if(indice>=0 && indice<nbspec)
        {
            for(int i=indice;i<nbspec;i++)
            {
                spectacles[i]=spectacles[i+1];
            }
            spectacles[indice-1]=null;
            nbspec--;
            System.out.println("Spectacle supprimé!");
        }
        else System.out.println("Indice invalide");
    }

}
