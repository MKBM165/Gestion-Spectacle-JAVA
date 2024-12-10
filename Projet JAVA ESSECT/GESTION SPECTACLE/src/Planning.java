public class Planning {
    private Diffusion[]diffusions=new Diffusion[100];
    private int nbdiff=0;
    private Spectacle[]spectacles=new Spectacle[100];
    private int nbspec=0;

    public void ajoutdiff(Diffusion d){
        if(nbdiff<100){
            diffusions[nbdiff]=d;
            nbdiff++;
        }
        else {
            System.out.println("Planning saturée");
        }
    }
    public void ajoutspectacle(Spectacle s){
        if(nbspec<100){
            spectacles[nbspec]=s;
            nbspec++;
        }
        else {
            System.out.println("Planning saturée");
        }
    }
    public void affichediffusion(){
        for(int i=0;i<nbdiff;i++){
            diffusions[i].afficher();
        }
    }
    public void affichespectacle(){
        for(int i=0;i<nbspec;i++){
            System.out.println(i+1);
            spectacles[i].afficher();
        }
    }
}
