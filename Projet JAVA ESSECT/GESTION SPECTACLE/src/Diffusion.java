import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.*;
public class Diffusion {
    private int idDiffusion;
    private LocalDate dateDiff;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private Spectacle idSpectacle;
    private Salle idSalle;
    private int nbrMaxBillets ;
    private int nbrBillets=0;
    private Billet[] billetsReserver = new Billet[200];

    public Diffusion(int idDiffusion, String dateDiff, String heureDebut, Spectacle idSpectacle, Salle idSalle,Planning p) {
        DateTimeFormatter dateFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //convertion et affectatton d'un string au format date
        this.dateDiff = LocalDate.parse(dateDiff,dateFormatter);
        this.idDiffusion = idDiffusion;
        DateTimeFormatter timeFormatter=DateTimeFormatter.ofPattern("HH:mm");
        //converstion et affectation d'un string au localtime
        this.heureDebut = LocalTime.parse(heureDebut,timeFormatter);
        this.idSpectacle = idSpectacle;
        this.idSalle = idSalle;
        int duréespectacle=idSpectacle.getDuree();
        this.heureFin=this.heureDebut.plusMinutes(duréespectacle);
        nbrMaxBillets=idSalle.getCapacite();
        idSpectacle.setDiffusions(this);
        p.ajoutdiff(this);
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public void setDateDiff(LocalDate dateDiff) {
        this.dateDiff = dateDiff;
    }

    public void vendreBiller() {
        Scanner input = new Scanner(System.in);
        if (nbrBillets<nbrMaxBillets){
            do {
            Billet billet = new Billet(1000,this,idSalle,idSpectacle);
            billet.affichebillet();
            System.out.println(" 0 : Annuler \n 1 : Confirmer ");
            if (input.nextInt()==1){
            billetsReserver[nbrBillets]=billet;
            nbrBillets++;
                System.out.println("Merci pour votre Achat Au revoir !");
                System.out.println("Retour au menu Principal (Log In)..... ");
            return;
            }
            else {
                return;
            }
            }while (input.nextInt() !=0 && input.nextInt() !=1);
        }
        else
        {
            System.out.println("Nous sommes désolé le Film est complé ");
        }
    }

    public int getIdDiffusion() {
        return idDiffusion;
    }

    public Spectacle getIdSpectacle() {
        return idSpectacle;
    }

    public Salle getIdSalle() {
        return idSalle;
    }

    public LocalDate getDateDiff() {
        return dateDiff;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public int getNbrMaxBillets() {
        return nbrMaxBillets;
    }

    public int getBilletsReserver() {
        return billetsReserver.length;
    }
    public void afficher(){
        System.out.println("******************************************");
        System.out.println("-------- le : "+dateDiff+" --------");
        System.out.println("Du : "+heureDebut+" jusqu'à : "+heureFin);
        System.out.println("Nbr de place : "+nbrBillets+" / "+nbrMaxBillets);
        System.out.println("******************************************");
    }
    public void afficherGestion(){
        System.out.println("******************************************");
        System.out.println("-------- "+idSpectacle.getTitre()+" -------");
        System.out.println("-------- le :"+dateDiff+" --------");
        System.out.println("Du : "+heureDebut+" jusqu'à : "+heureFin);
        System.out.println("Nbr de place : "+nbrBillets+" / "+nbrMaxBillets);
        idSalle.afficher();
        System.out.println("******************************************");
    }
}
