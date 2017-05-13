package habib.webservice.Controller.ParticipationController;

import java.util.ArrayList;
import java.util.List;

import habib.webservice.Model.Participation;

/**
 * Created by lenovo on 24/04/2017.
 */
public class ParticipationContent
{
    public static List<Participation> getNotification(String login)
    {
        //ParticipationService participationService=new ParticipationService();
        List<Participation>list=ParticipationService.getData(login);
        List<String>Notifs=new ArrayList<>();
        List<String>Nom_Activite=new ArrayList<>();

        for(int i=0;i<list.size();i++)
        {
            Notifs.add(list.get(i).getNotif());
            Nom_Activite.add(list.get(i).getNom_Activite());
        }
        List<Participation>participation=new ArrayList<Participation>();
        for(int i=0;i<Notifs.size();i++)
        {
            participation.add(new Participation(Notifs.get(i),Nom_Activite.get(i)));
        }
        return participation;
    }
}
