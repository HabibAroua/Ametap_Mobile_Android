package habib.webservice.Controller.ActiviteController;

import java.util.ArrayList;
import java.util.List;

import habib.webservice.Model.Activite;

/**
 * Created by lenovo on 08/04/2017.
 */
public class ActiviteContent
{


    public static List<Activite> getActivites()
    {
        ActiviteService activiteService=new ActiviteService();
        List<Activite>list=activiteService.getData();
        List<Integer>Ids=new ArrayList<>();
        List<String>nomActivite=new ArrayList<>();
        List<String>date_debut=new ArrayList<>();
        List<String>date_fin=new ArrayList<>();
        List<Double>prix_unitaire=new ArrayList<>();
        List<String>nom_organisateur=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            Ids.add(list.get(i).getId());
            nomActivite.add(list.get(i).getNom_activite());
            date_debut.add(list.get(i).getDate_debut());
            date_fin.add(list.get(i).getDate_fin());
            prix_unitaire.add(list.get(i).getPrix_unitaire());
            nom_organisateur.add(list.get(i).getOrganisateur());
        }
        List<Activite>Activites=new ArrayList<Activite>();
        for(int i=0;i<Ids.size();i++)
        {
            Activites.add(new Activite(Ids.get(i),nomActivite.get(i),date_debut.get(i),date_fin.get(i),prix_unitaire.get(i),nom_organisateur.get(i)));
        }
        return Activites;
    }
}
