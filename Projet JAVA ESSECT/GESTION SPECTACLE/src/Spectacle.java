import java.time.Duration;
import java.util.Date;

public class Spectacle {
    private int idSpectacle;
    private String titre;
    private Date date;
    private String type;
    private Duration duree;

    public Spectacle(int idSpectacle, String titre, Date date, String type, Duration duree) {
        this.idSpectacle = idSpectacle;
        this.titre = titre;
        this.date = date;
        this.type = type;
        this.duree = duree;
    }

    public int getIdSpectacle() {
        return idSpectacle;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Duration getDuree() {
        return duree;
    }

    public void setDuree(Duration duree) {
        this.duree = duree;
    }

    public void afficher(){
        System.out.println("--------- "+titre+" ---------");
        System.out.println("Date à partir de : "+date+"--------- Duree : "+duree);
    }
}
