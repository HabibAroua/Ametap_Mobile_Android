package habib.webservice.Controller.EnfantController;

import java.util.ArrayList;
import java.util.List;

import habib.webservice.Model.Enfant;

/**
 * Created by lenovo on 12/04/2017.
 */
public class EnfantContent
{
    public static List<Enfant> getEnfant(String login)
    {
        EnfantService EnfantService=new EnfantService();
        List<Enfant>list=EnfantService.getData(login);
        List<Integer>Ids=new ArrayList<>();
        List<String>nom=new ArrayList<>();
        List<String>prenom=new ArrayList<>();
        List<String>date_naissance=new ArrayList<>();
        List<String>ecole=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            Ids.add(list.get(i).getId());
            nom.add(list.get(i).getNom());
            prenom.add(list.get(i).getPrenom());
            date_naissance.add(list.get(i).getDate_naissance());
            ecole.add(list.get(i).getEcole());
        }
        List<Enfant>Enfants=new ArrayList<Enfant>();
        for(int i=0;i<Ids.size();i++)
        {
            Enfants.add(new Enfant(Ids.get(i),nom.get(i),prenom.get(i),date_naissance.get(i),ecole.get(i)));
        }
        return Enfants;
    }
}

