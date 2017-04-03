package habib.webservice.Model;

/**
 * Created by lenovo on 29/03/2017.
 */
public class Enfant {
    private int id;
    private String nom;
    private String prenom;
    private String date_naissance;
    private String ecole;

    public Enfant(int id, String nom, String prenom, String date_naissance, String ecole)
    {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.ecole = ecole;
    }

    //getters
    public int getId()
    {
        return this.id;
    }

    public String getNom()
    {
        return this.nom;
    }

    public String getPrenom()
    {
        return this.prenom;
    }

    public String getDate_naissance()
    {
        return this.date_naissance;
    }

    public String getEcole()
    {
        return this.ecole;
    }

    //setters
    public void setId(int id)
    {
        this.id = id;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom=prenom;
    }

    public void setDate_naissance(String date_naissance)
    {
        this.date_naissance=date_naissance;
    }

    public void setEcole(String ecole)
    {
        this.ecole=ecole;
    }

}