import java.time.*;
import java.util.Scanner;

public class Spectacle {
    private int idSpectacle;
    private String titre;
    private String date;
    private String type;
    private int duree;//par minute
    private final int MAX=10;
    private int nbdiff=0;
    private Diffusion[]diffusions=new Diffusion[MAX];

    public Spectacle(int idSpectacle, String titre, String date, String type, int duree,Planning p) {
        this.idSpectacle = idSpectacle;
        this.titre = titre;
        this.date = date;
        this.type = type;
        this.duree = duree;
        p.ajoutspectacle(this);
    }

    public int getIdSpectacle() {
        return idSpectacle;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void afficher(){
        System.out.println("--------- "+titre+" ---------");
        System.out.println("Date à partir de : "+date+"--------- Duree : "+duree);
    }

    public void setDiffusions(Diffusion diff) {
        diffusions[nbdiff]=diff;
        nbdiff++;
    }
    public int afficherDiffusions(){
        Scanner input =new Scanner(System.in);
        int choix;
        System.out.println("0 : retour au menu principal");
        System.out.println("-----------Voi ci les Horaires de "+titre+"------------");
        for (int j = 0; j <nbdiff ; j++) {
            System.out.println((j+1)+ " : ");
            diffusions[j].afficher();
        }
        System.out.println("Entrer votre Choix : ");
        choix = input.nextInt();
        if (choix>0 && choix<nbdiff+1){
            diffusions[choix-1].vendreBiller();
        }
        return 0;
    }
    @Override
    public String toString() {
        return "ID: " + idSpectacle+ ", Titre: " + titre + ", Date: " + date + ", Type: " + type + ", Durée: " + duree + " minutes";
    }
}
