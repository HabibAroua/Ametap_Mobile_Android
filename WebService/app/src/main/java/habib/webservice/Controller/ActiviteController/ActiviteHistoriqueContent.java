package habib.webservice.Controller.ActiviteController;

import java.util.ArrayList;
import java.util.List;

import habib.webservice.Model.Activite;

/**
 * Created by lenovo on 01/06/2017.
 */
public class ActiviteHistoriqueContent
{
    public static List<Activite> getActivites()
    {
        ActiviteService activiteService=new ActiviteService();
        List<Activite>list=activiteService.getListHistiryActivity();
        List<Integer>Identficateur=new ArrayList<>();
        List<String>Prenom=new ArrayList<>();
        List<String>Nom=new ArrayList<>();
        List<String>Nom_Activite=new ArrayList<>();
        List<String>Date_debut=new ArrayList<>();
        List<String>Date_fin=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            Identficateur.add(list.get(i).getId());
            Nom.add(list.get(i).getNom());
            Prenom.add(list.get(i).getPrenom());
            Nom_Activite.add(list.get(i).getNom_activite());
            Date_debut.add(list.get(i).getDate_debut());
            Date_fin.add(list.get(i).getDate_fin());
        }
        List<Activite>Activites=new ArrayList<Activite>();
        for(int i=0;i<Identficateur.size();i++)
        {
            Activites.add(new Activite(Identficateur.get(i),Prenom.get(i),Nom.get(i),Nom_Activite.get(i),Date_debut.get(i),Date_fin.get(i)));
        }
        return Activites ;


    }
}
