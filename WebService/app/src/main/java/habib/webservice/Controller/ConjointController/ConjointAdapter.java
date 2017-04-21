package habib.webservice.Controller.ConjointController;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import habib.webservice.Model.Conjoint;
import habib.webservice.Navigation;
import habib.webservice.R;

/**
 * Created by lenovo on 11/04/2017.
 */
public class ConjointAdapter extends ArrayAdapter<Conjoint>
{
    Context context;
    int resource;

    public ConjointAdapter(Context context, int resource, List<Conjoint> membre)
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
        final EditText cin=(EditText)view.findViewById(R.id.ConjointCin);
        final EditText nom =(EditText)view.findViewById(R.id.ConjointNom);
        final EditText prenom=(EditText)view.findViewById(R.id.conjointPrenom);
        final EditText date_naissance=(EditText) view.findViewById(R.id.conjointDateNaissance);
        final EditText metier=(EditText)view.findViewById(R.id.conjointMetier);
        Button btModifier=(Button)view.findViewById(R.id.btModifierConjoint);
        Button btAnuller=(Button)view.findViewById(R.id.btAnnulerModifConjoint);
        cin.setText(getItem(position).getCin()+" ");
        nom.setText(getItem(position).getNom());
        prenom.setText(getItem(position).getPrenom());
        date_naissance.setText(getItem(position).getDate_naissance());
        metier.setText(getItem(position).getMetier());

        btModifier.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Navigation n=new Navigation();
                Toast.makeText(getContext(),"Login :"+n.LoginValue,Toast.LENGTH_SHORT).show();
                ConjointService conjointService=new ConjointService();
                conjointService.modifierConjoint(cin.getText().toString(),nom.getText().toString(),prenom.getText().toString(),date_naissance.getText().toString(),metier.getText().toString(),n.LoginValue,getContext());
            }
        });

        btAnuller.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                cin.setText("");
                nom.setText("");
                prenom.setText("");
                date_naissance.setText("");
                metier.setText("");
            }
        });
        return view;
    }
}

