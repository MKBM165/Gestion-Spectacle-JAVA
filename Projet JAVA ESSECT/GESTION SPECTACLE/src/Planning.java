public class Planning {
    private Diffusion[]diffusions=new Diffusion[100];
    private int nbdiff=0;


    public void ajoutdiff(Diffusion d){
        if(nbdiff<100){
            diffusions[nbdiff]=d;
            nbdiff++;
        }
        else {
            System.out.println("Planning saturée");
        }
    }
    public void afficheplan(){
        for(int i=0;i<nbdiff;i++){
            diffusions[i].afficher();
        }
    }
}
