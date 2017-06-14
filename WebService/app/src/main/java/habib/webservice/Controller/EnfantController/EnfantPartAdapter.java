package habib.webservice.Controller.EnfantController;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import habib.webservice.Activity.Navigation;
import habib.webservice.Activity.Participer_Enfant;
import habib.webservice.Model.Enfant;
import habib.webservice.R;

/**
 * Created by lenovo on 03/06/2017.
 */
public class EnfantPartAdapter extends ArrayAdapter<Enfant>
{
    Context context;
    int resource;
    public EnfantPartAdapter(Context context, int resource, List<Enfant> membre)
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
        final TextView id=(TextView)view.findViewById(R.id.partId);
        final TextView nom=(TextView) view.findViewById(R.id.partNom);
        final TextView prenom= (TextView) view.findViewById(R.id.partPrenom);
        id.setText(getItem(position).getId()+" ");
        nom.setText(getItem(position).getNom() + " ");
        prenom.setText(getItem(position).getPrenom());
        Button btParticiper=(Button)view.findViewById(R.id.btPerticiperEnfant);
        btParticiper.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Participer_Enfant participer_enfant=new Participer_Enfant();
                String idActivite=participer_enfant.idActivite;
                EnfantService enfantService=new EnfantService();
                Toast.makeText(context,""+idActivite,Toast.LENGTH_SHORT).show();
                Navigation n=new Navigation();
                enfantService.participer(id.getText().toString(),idActivite,n.LoginValue,context);
            }
        });
        return view;
    }
}
