public class Billet {
    private static int id_billet = 16845;
    private float prix;
    private Diffusion  id_diffusion;

    public Billet (float prix,Diffusion id_diffusion)
    {
        this.prix=prix;
        this.id_diffusion=id_diffusion;
        id_billet++;
    }

    public void affichebillet()
    {

    }
}
