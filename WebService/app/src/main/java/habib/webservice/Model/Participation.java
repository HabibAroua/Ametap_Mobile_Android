package habib.webservice.Model;

/**
 * Created by lenovo on 20/04/2017.
 */
public class Participation
{
    private int id;
    private String date_part;
    private int etat;
    private String notif;
    private int matriculePart;
    private int idActivite;
    private String Nom_Activite;

    public Participation(String notif,String Nom_Activite)
    {
        this.notif=notif;
        this.Nom_Activite=Nom_Activite;
    }

    public String getNom_Activite()
    {
        return  this.Nom_Activite;
    }

    public void setNom_Activite(String Nom_Activite)
    {
        this.Nom_Activite=Nom_Activite;
    }

    public Participation(int id,String date_part,int etat,String notif,int matriculePart,int idActivite)
    {
        this.id=id;
        this.date_part=date_part;
        this.etat=etat;
        this.notif=notif;
        this.matriculePart=matriculePart;
        this.idActivite=idActivite;
    }

    //Getters

    public int getId()
    {
        return this.id;
    }

    public String getDate_part()
    {
        return this.date_part;
    }

    public String getNotif()
    {
        return this.notif;
    }

    public int getEtat()
    {
        return this.etat;
    }

    public int getMatriculePart()
    {
        return this.matriculePart;
    }

    public int getIdActivite()
    {
        return this.idActivite;
    }

    //Setters

    public void setId(int id)
    {
        this.id=id;
    }

    public void setDate_part(String date_part)
    {
        this.date_part=date_part;
    }

    public void setEtat(int etat)
    {
        this.etat=etat;
    }

    public void setNotif(String notif)
    {
        this.notif=notif;
    }

    public void setMatriculePart(int matriculePart)
    {
        this.matriculePart=matriculePart;
    }

    public void setIdActivite(int idActivite)
    {
        this.idActivite=idActivite;
    }
}
