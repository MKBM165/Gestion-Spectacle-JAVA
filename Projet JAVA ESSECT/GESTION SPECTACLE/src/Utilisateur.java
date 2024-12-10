public class Utilisateur {
    private int id;
    private String nom;
    private String motDePasse;

    public void setId(int id)
    {
        this.id=id;
    }

    public void setnom(String nom)
    {
        this.nom=nom;
    }
    public String getnom()
    {
        return this.nom;
    }
    public String getMotDePasse()
    {
        return this.motDePasse;
    }
    public void setMotDePasse(String mdp)
    {
        this.motDePasse=mdp;
    }
}
