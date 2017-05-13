package habib.webservice.Controller.ParticipationController;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import habib.webservice.Model.Participation;
import habib.webservice.R;

/**
 * Created by lenovo on 24/04/2017.
 */
public class ParticipationAdapter extends ArrayAdapter<Participation>
{
    Context context;
    int resource;

    public ParticipationAdapter(Context context, int resource, List<Participation> membre)
    {
        super(context, resource, membre);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view=inflater.inflate(resource,parent,false);
        final TextView notif=(TextView) view.findViewById(R.id.viewNotif);
        final TextView nom =(TextView)view.findViewById(R.id.viewActivite);
        notif.setText(getItem(position).getNotif());
        nom.setText(getItem(position).getNom_Activite());
        return view;
    }
}

