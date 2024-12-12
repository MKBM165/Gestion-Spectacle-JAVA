class Utilisateur {
    private String nom;
    private String motDePasse;

    public Utilisateur(String nom, String motDePasse) {
        this.nom = nom;
        this.motDePasse = motDePasse;
    }

    public String getnom()
    {
        return this.nom;
    }
    public String getMotDePasse()
    {
        return this.motDePasse;
    }
}
