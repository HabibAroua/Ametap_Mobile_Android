package habib.webservice.Fragemnts;


import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import habib.webservice.Activity.Navigation;
import habib.webservice.Controller.ActiviteController.ActiviteService;
import habib.webservice.Controller.ParticipationController.ParticipationAdapter;
import habib.webservice.Controller.ParticipationController.ParticipationContent;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AfficheNotif extends Fragment
{
    private ListView listView;
    public AfficheNotif()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.fragment_affiche_notif, container, false);
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().build()));
        ActiviteService activiteService=new ActiviteService(getContext());

        //try
        //{
            listView = (ListView) v.findViewById(R.id.listNotif);
            Navigation n=new Navigation();
            String login=n.LoginValue;
            ParticipationAdapter adapter = new ParticipationAdapter(getContext(), R.layout.row_tem3, ParticipationContent.getNotification(login));
            listView.setAdapter(adapter);
        //}
        //catch(Exception e)
        //{

//        }
        // Inflate the layout for this fragment
        return v;
    }

}
