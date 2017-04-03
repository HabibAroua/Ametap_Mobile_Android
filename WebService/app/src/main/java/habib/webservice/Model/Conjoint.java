package habib.webservice.Model;

/**
 * Created by lenovo on 29/03/2017.
 */
public class Conjoint
{
    private int cin;
    private String nom;
    private String prenom;
    private String date_naissance;
    private String metier;

    public Conjoint(int cin,String nom,String prenom,String date_naissance,String metier)
    {
        this.cin=cin;
        this.nom=nom;
        this.prenom=prenom;
        this.date_naissance=date_naissance;
        this.metier=metier;
    }

    //getters
    public int getCin()
    {
        return this.cin;
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

    public String getMetier()
    {
        return this.metier;
    }

    //Setters

    public void setCin(int cin)
    {
        this.cin=cin;
    }

    public void setNom(String nom)
    {
        this.nom=nom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom=prenom;
    }

    public void setDate_naissance(String date_naissance)
    {
        this.date_naissance=date_naissance;
    }

    public void setMetier(String metier)
    {
        this.metier=metier;
    }
}
