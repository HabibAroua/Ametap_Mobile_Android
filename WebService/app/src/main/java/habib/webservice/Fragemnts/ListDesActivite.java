package habib.webservice.Fragemnts;


import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import habib.webservice.Activity.Navigation;
import habib.webservice.Controller.ActiviteController.ActiviteContent;
import habib.webservice.Controller.ActiviteController.ActiviteService;
import habib.webservice.Controller.ParticipationController.ParticipationService;
import habib.webservice.Model.Activite;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListDesActivite extends Fragment
{
    ListView listView;
    ArrayAdapter<String>adapter;
    public String adresse="http://192.168.1.133:88/Ametap/Activite.php";
    InputStream is=null;
    String line=null;
    String result=null;
    String []data;
    List<Activite> listActivite=new ArrayList<>();
    Button btDemander;
    View view;


    ActiviteService activiteService=new ActiviteService(getContext());

    public ListDesActivite()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_list_des_activite, container, false);


        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().build()));
        ActiviteService activiteService=new ActiviteService(getContext());

        //try
        //{
            listView = (ListView) view.findViewById(R.id.listActivite);
            ActiviteAdapter adapter = new ActiviteAdapter(getContext(), R.layout.row_item, ActiviteContent.getActivites());
            listView.setAdapter(adapter);
        //}
        //catch(Exception e)
        //{

//        }
        return view;
    }

    public class ActiviteAdapter extends ArrayAdapter<Activite>
    {
        Context context;
        int resource;
        public ActiviteAdapter(Context context, int resource, List<Activite> prisoners)
        {
            super(context,resource,prisoners);
            this.context=context;
            this.resource=resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View view=inflater.inflate(resource,parent,false);
            final TextView id=(TextView)view.findViewById(R.id.viewID);
            TextView nomActivite=(TextView)view.findViewById(R.id.viewNom_Activite);
            TextView date_debut=(TextView)view.findViewById(R.id.viewDateDebut);
            TextView date_fin=(TextView)view.findViewById(R.id.viewDateFin);
            TextView prix_unitaire=(TextView)view.findViewById(R.id.viewPrixUnitaire);
            TextView nom_organisateur=(TextView)view.findViewById(R.id.viewNomOrganisateur);
            Button btDemander=(Button)view.findViewById(R.id.btDemander);

            id.setText(getItem(position).getId()+" ");
            nomActivite.setText(getItem(position).getNom_activite());
            date_debut.setText(getItem(position).getDate_debut());
            date_fin.setText(getItem(position).getDate_fin());
            prix_unitaire.setText((int)getItem(position).getPrix_unitaire()+" ");
            nom_organisateur.setText(getItem(position).getOrganisateur());
            btDemander.setOnClickListener(
                    new View.OnClickListener()
                    {
                        public void onClick(View v)
                        {
                            ParticipationService participationService=new ParticipationService();
                            Navigation n=new Navigation();
                            String login=n.LoginValue;
                            participationService.ParticipationAdherent(login,id.getText().toString(),getContext());
                            //participationService.Message(getContext());
                            //Toast.makeText(getContext(),"Votre demande a été envoyé avec succés !", Toast.LENGTH_SHORT).show();
                        }
                    });
            Button btDemandeActivitPourConjoint=(Button)view.findViewById(R.id.btDemanderActivitePourConjoint);
            btDemandeActivitPourConjoint.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    ParticipationService participationService=new ParticipationService();
                    Navigation n=new Navigation();
                    String login=n.LoginValue;
                    participationService.ParticipationConjoint(login,id.getText().toString(),getContext());
                }
            });

            return view;
        }
    }
}
