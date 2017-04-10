package habib.webservice.Model;

/**
 * Created by lenovo on 05/04/2017.
 */
public class Activite
{
    private int id;
    private String nom_activite;
    private int capacite;
    private int nombre_participant;
    private String date_debut;
    private String date_fin;
    private double prix_unitaire;
    private double montant_prevu;
    private double montant_actuel;
    private int id_TypeActivite;
    private int idBudget;
    private String organisateur;

    public Activite(int id,String nom_activite,int capacite,int nombre_participant,String date_debut,String date_fin,double prix_unitaire,double montant_prevu,double montant_actuel,int id_TypeActivite,int idBudget,String organisateur)
    {
        this.id=id;
        this.nom_activite=nom_activite;
        this.capacite=capacite;
        this.nombre_participant=nombre_participant;
        this.date_debut=date_debut;
        this.date_fin=date_fin;
        this.prix_unitaire=prix_unitaire;
        this.montant_prevu=montant_prevu;
        this.montant_actuel=montant_actuel;
        this.id_TypeActivite=id_TypeActivite;
        this.idBudget=idBudget;
        this.organisateur=organisateur;
    }

    //getters

    public int  getId()
    {
        return this.id;
    }

    public String getNom_activite()
    {
        return this.nom_activite;
    }

    public String getDate_debut()
    {
        return this.date_debut;
    }

    public String getDate_fin()
    {
        return this.date_fin;
    }

    public double getPrix_unitaire()
    {
        return this.prix_unitaire;
    }

    public double getMontant_prevu()
    {
        return this.montant_prevu;
    }

    public double getMontant_actuel()
    {
        return this.montant_actuel;
    }

    public int getCapacite()
    {
        return this.capacite;
    }

    public int getNombre_participant()
    {
        return this.nombre_participant;
    }

    public int getId_TypeActivite()
    {
        return this.id_TypeActivite;
    }

    public int getIdBudget()
    {
        return this.idBudget;
    }

    public String getOrganisateur()
    {
        return this.organisateur;
    }

    //Setters

    public void setId(int id)
    {
        this.id=id;
    }

    public void setNom_activite(String nom_activite)
    {
        this.nom_activite=nom_activite;
    }

    public void setCapacite(int capacite)
    {
        this.capacite=capacite;
    }

    public void setNombre_participant(int nombre_participant)
    {
        this.nombre_participant=nombre_participant;
    }

    public void setDate_debut(String date_debut)
    {
        this.date_debut=date_debut;
    }

    public void setDate_fin(String date_fin)
    {
        this.date_fin=date_fin;
    }

    public void setPrix_unitaire(double prix_unitaire)
    {
        this.prix_unitaire=prix_unitaire;
    }

    public void setMontant_prevu(double montant_prevu)
    {
        this.montant_prevu=montant_prevu;
    }

    public void setMontant_actuel(double montant_actuel)
    {
        this.montant_actuel=montant_actuel;
    }

    public void setId_TypeActivite(int id_TypeActivite)
    {
        this.id_TypeActivite=id_TypeActivite;
    }

    public void setIdBudget(int idBudget)
    {
        this.idBudget=idBudget;
    }

    public void setIdOrganisateur(String  organisateur)
    {
        this.organisateur=organisateur;
    }

    public Activite(int id,String nom_activite,String date_debut,String date_fin,double prix_unitaire,String organisateur)
    {
        this.id=id;
        this.nom_activite=nom_activite;
        this.date_debut=date_debut;
        this.date_fin=date_fin;
        this.prix_unitaire=prix_unitaire;
        this.organisateur=organisateur;
    }

    public String toString()
    {
        return "id :"+this.id+" nom activite :"+this.nom_activite+" date debut :"+this.date_debut+" date fin :"+this.date_fin+" Prix unitaire :"+prix_unitaire+" nom Organisateur : "+this.organisateur ;
    }
}
