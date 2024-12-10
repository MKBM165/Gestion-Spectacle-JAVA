public class Billet {
    private static int id_billet = 16845;
    private float prix;
    private Diffusion  id_dif;

    public Billet (float prix,Diffusion id_diffusion)
    {
        this.prix=prix;
        this.id_dif=id_diffusion;
        id_billet++;
    }

    public void affichebillet()
    {
        System.out.println("********************************\n"+
                           "Billet num : "+id_billet+
                           "\nprix : "+prix+
                           "\n*********************************");
        id_dif.afficher();
    }
}
