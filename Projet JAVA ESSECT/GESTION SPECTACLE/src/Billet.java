public class Billet {
    private static int id_billet = 16845;
    private float prix;
    private Diffusion  id_dif;
    private Salle salle;
    private Spectacle spectacle;

    public Billet (float prix,Diffusion id_diffusion, Salle salle,Spectacle spectacle)
    {
        this.prix=prix;
        this.id_dif=id_diffusion;
        this.salle=salle;
        this.spectacle=spectacle;
        id_billet++;
    }

    public void affichebillet()
    {
        System.out.println("********************************\n"+
                            "Billet num : "+id_billet+
                            "\nprix : "+prix+" DT"+
                            "\n--------- "+spectacle.getTitre()+" ---------"+
                            "\n-------- le : "+id_dif.getDateDiff()+"--------"+
                            "\nDu : "+id_dif.getHeureDebut()+" jusqu'à : "+id_dif.getHeureFin()+
                            "\nNum Salle : "+salle.getNumSalle()+
                            "\n*********************************");
    }
}
