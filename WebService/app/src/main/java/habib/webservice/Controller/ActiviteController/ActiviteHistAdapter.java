package habib.webservice.Controller.ActiviteController;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import habib.webservice.Model.Activite;
import habib.webservice.R;

/**
 * Created by lenovo on 01/06/2017.
 */
public class ActiviteHistAdapter extends ArrayAdapter<Activite>
{
    Context context;
    int resource;
    EditText date_naissance;
    public ActiviteHistAdapter(Context context, int resource,List<Activite> membre) {
        super(context, resource, membre);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view=inflater.inflate(resource,parent,false);
        TextView nomActivite=(TextView)view.findViewById(R.id.viewHisNom_Activite);
        TextView id=(TextView)view.findViewById(R.id.idHisActivite);
        TextView participant=(TextView)view.findViewById(R.id.participantHis);
        TextView dateDebut=(TextView)view.findViewById(R.id.date_debutHis);
        TextView dateFin=(TextView)view.findViewById(R.id.date_finHis);
        nomActivite.setText(getItem(position).getNom_activite());
        id.setText(getItem(position).getId()+"");
        participant.setText(getItem(position).getPrenom()+" "+getItem(position).getNom());
        dateDebut.setText(getItem(position).getDate_debut());
        dateFin.setText(getItem(position).getDate_fin());
        return view;
    }
}
