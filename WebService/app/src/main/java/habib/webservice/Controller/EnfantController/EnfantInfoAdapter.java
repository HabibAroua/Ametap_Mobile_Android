package habib.webservice.Controller.EnfantController;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import habib.webservice.Model.Enfant;
import habib.webservice.R;

/**
 * Created by lenovo on 02/05/2017.
 */
public class EnfantInfoAdapter extends ArrayAdapter<Enfant>
{
    Context context;
    int resource;
    public EnfantInfoAdapter(Context context, int resource, List<Enfant> membre)
    {
        super(context, resource, membre);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(resource, parent, false);
        final TextView nom=(TextView) view.findViewById(R.id.viewNomEnfant);
        final TextView prenom= (TextView) view.findViewById(R.id.viewPrenomEnfant);
        final TextView date_naissance=(TextView)view.findViewById(R.id.viewDateNaissanceEnfant);
        nom.setText(getItem(position).getNom() + " ");
        prenom.setText(getItem(position).getPrenom());
        date_naissance.setText(getItem(position).getPrenom());
        date_naissance.setText(getItem(position).getDate_naissance());


        return view;
    }


}
