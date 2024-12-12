public class Diffusion {
    private int idDiffusion;
    private String dateDiff;
    private String heureDebut;
    private String heureFin;
    private Spectacle idSpectacle;
    private Salle idSalle;
    private final int nbrMaxBillets ;
    private int nbrBillets=0;
    private Billet[] billetsReserver = new Billet[200];

    public Diffusion(int idDiffusion, String dateDiff, String heureDebut, Spectacle idSpectacle, Salle idSalle,Planning p) {
        this.idDiffusion = idDiffusion;
        this.dateDiff = dateDiff;
        this.heureDebut = heureDebut;
        this.idSpectacle = idSpectacle;
        this.idSalle = idSalle;
        //heureFin = heureDebut+idSpectacle.getduree() à verifier et modifier
        nbrMaxBillets=idSalle.getCapacite();
        idSpectacle.setDiffusions(this);
        p.ajoutdiff(this);
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public void setDateDiff(String dateDiff) {
        this.dateDiff = dateDiff;
    }

    public void vendreBiller() {
        Billet billet = new Billet(1000,this,idSalle,idSpectacle);
        billet.affichebillet();
        billetsReserver[nbrBillets]=billet;
        nbrBillets++;
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

    public String getDateDiff() {
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
        return billetsReserver.length;
    }
    public void afficher(){
        //idSpectacle.afficher()
        //idSalle.afficher()
        System.out.println("******************************************");
        System.out.println("-------- le :"+dateDiff+"--------");
        System.out.println("Du : "+heureDebut+" jusqu'à : "+heureFin);
        System.out.println("Nbr de place : "+nbrMaxBillets);
        System.out.println("******************************************");
    }
}
