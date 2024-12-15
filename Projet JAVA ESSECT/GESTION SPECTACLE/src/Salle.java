public class Salle {
    private int numSalle;
    private int capacite;

    public Salle( int numSalle, int capacite,Planning p) {
        this.numSalle = numSalle;
        this.capacite = capacite;
        p.ajoutSalle(this);
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
