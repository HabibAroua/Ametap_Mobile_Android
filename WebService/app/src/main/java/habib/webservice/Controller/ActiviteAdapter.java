package habib.webservice.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

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
        View view=inflater.inflate(resource,parent,false);
        TextView id=(TextView)view.findViewById(R.id.viewID);
        TextView nomActivite=(TextView)view.findViewById(R.id.viewNom_Activite);
        TextView date_debut=(TextView)view.findViewById(R.id.viewDateDebut);
        TextView date_fin=(TextView)view.findViewById(R.id.viewDateFin);
        TextView prix_unitaire=(TextView)view.findViewById(R.id.viewPrixUnitaire);
        TextView nom_organisateur=(TextView)view.findViewById(R.id.viewNomOrganisateur);
        id.setText(getItem(position).getId()+" ");
        nomActivite.setText(getItem(position).getNom_activite());
        date_debut.setText(getItem(position).getDate_debut());
        date_fin.setText(getItem(position).getDate_fin());
        prix_unitaire.setText((int)getItem(position).getPrix_unitaire()+" ");
        nom_organisateur.setText(getItem(position).getOrganisateur());
        return view;
    }
}
