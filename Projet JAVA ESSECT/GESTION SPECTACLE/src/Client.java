public class Client extends Utilisateur{

    public Client(int id,String nom,String mdp) {
        super.setnom(nom);
        super.setMotDePasse(mdp);
        super.setId(id);
    }
}
