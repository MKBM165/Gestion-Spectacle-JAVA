import java.util.Date;

public class Diffusion {
    private int idDiffusion;
    private Date dateDiff;
    private String heureDebut;
    private String heureFin;
    private Spectacle idSpectacle;
    private Salle idSalle;
    private int nbrMaxBillets;
    private int billetsReserver;

    public Diffusion(int idDiffusion, Date dateDiff, String heureDebut, Spectacle idSpectacle, Salle idSalle ) {
        this.idDiffusion = idDiffusion;
        this.dateDiff = dateDiff;
        this.heureDebut = heureDebut;
        this.idSpectacle = idSpectacle;
        this.idSalle = idSalle;
        //heureFin = heureDebut+idSpectacle.getduree() à verifier et modifier
        //nbrMaxBillets=idSalle.getcacite()
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public void setDateDiff(Date dateDiff) {
        this.dateDiff = dateDiff;
    }

    public void vendreBiller() {
        billetsReserver++;
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

    public Date getDateDiff() {
        return dateDiff;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public int getNbrMaxBillets() {
        return nbrMaxBillets;
    }

    public int getBilletsReserver() {
        return billetsReserver;
    }
    public void afficher(){
        //idSpectacle.afficher()
        //idSalle.afficher()
        System.out.println("-------- le :"+dateDiff+"--------");
        System.out.println("Du : "+heureDebut+" jusqu'à : "+heureFin);
        System.out.println("Nbr de place : "+nbrMaxBillets);
    }
}
