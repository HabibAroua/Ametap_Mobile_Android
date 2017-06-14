package habib.webservice.Controller.ActiviteController;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import habib.webservice.Activity.Navigation;
import habib.webservice.Controller.ParticipationController.ParticipationService;
import habib.webservice.Fragemnts.Participer_activite;
import habib.webservice.Model.Activite;
import habib.webservice.R;

/**
 * Created by lenovo on 08/04/2017.
 */
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
        TextView date_fin_inscription=(TextView)view.findViewById(R.id.viewDate_fin_inscription);
        Button btDemander=(Button)view.findViewById(R.id.btDemander);

        id.setText(getItem(position).getId()+" ");
        nomActivite.setText(getItem(position).getNom_activite());
        date_debut.setText(getItem(position).getDate_debut());
        date_fin.setText(getItem(position).getDate_fin());
        prix_unitaire.setText((int)getItem(position).getPrix_unitaire()+" ");
        nom_organisateur.setText(getItem(position).getOrganisateur());
        date_fin_inscription.setText("15/11/1994");

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
        Button btDemandeActivitePourConjoint=(Button)view.findViewById(R.id.btDemanderActivitePourConjoint);
        btDemandeActivitePourConjoint.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Navigation n=new Navigation();
                String login=n.LoginValue;
                Toast.makeText(view.getContext(),"Hello",Toast.LENGTH_SHORT).show();
            }
        });
        Button btDemandeEnfant=(Button)view.findViewById(R.id.toPartEnfant);
        btDemandeEnfant.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i=new Intent(getContext(), Participer_activite.class);
                getContext().startActivity(i);
            }
        });

        return view;
    }
}



