public class Salle {
    private int idSalle;
    private int numSalle;
    private int capacite;

    public Salle(int idSalle, int numSalle, int capacite) {
        this.idSalle = idSalle;
        this.numSalle = numSalle;
        this.capacite = capacite;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public int getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    public void afficher(){
        System.out.println("--------- Salle N°: "+numSalle+" ---------");
    }
}
