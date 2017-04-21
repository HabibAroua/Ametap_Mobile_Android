package habib.webservice.Controller.ConjointController;

import java.util.ArrayList;
import java.util.List;

import habib.webservice.Controller.ConjointController.ConjointService;
import habib.webservice.Model.Conjoint;

/**
 * Created by lenovo on 11/04/2017.
 */
public class ConjointContent
{
    public static List<Conjoint> getConjoint(String login)
    {
        ConjointService familleService=new ConjointService();
        List<Conjoint>list=ConjointService.getData(login);
        List<Integer>Identficateur=new ArrayList<>();
        List<String>Nom=new ArrayList<>();
        List<String>Prenom=new ArrayList<>();
        List<String>Date_naissance=new ArrayList<>();
        List<String>Metier=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            Identficateur.add(list.get(i).getCin());
            Nom.add(list.get(i).getNom());
            Prenom.add(list.get(i).getPrenom());
            Date_naissance.add(list.get(i).getDate_naissance());
            Metier.add(list.get(i).getMetier());
        }
        List<Conjoint>Familles=new ArrayList<Conjoint>();
        for(int i=0;i<Identficateur.size();i++)
        {
            Familles.add(new Conjoint(Identficateur.get(i),Nom.get(i),Prenom.get(i),Date_naissance.get(i),Metier.get(i)));
        }
        return Familles;


    }
}
