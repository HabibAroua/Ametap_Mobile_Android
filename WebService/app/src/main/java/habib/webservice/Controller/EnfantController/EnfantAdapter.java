package habib.webservice.Controller.EnfantController;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import habib.webservice.Model.Enfant;
import habib.webservice.Navigation;
import habib.webservice.R;

/**
 * Created by lenovo on 12/04/2017.
 */
public class EnfantAdapter extends ArrayAdapter<Enfant> {
    Context context;
    int resource;

    public EnfantAdapter(Context context, int resource, List<Enfant> membre) {
        super(context, resource, membre);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(resource, parent, false);
        final EditText id = (EditText) view.findViewById(R.id.idEnfant);
        final EditText nom = (EditText) view.findViewById(R.id.nomEnfant);
        final EditText prenom = (EditText) view.findViewById(R.id.prenomEnfant);
        final EditText date_naissance = (EditText) view.findViewById(R.id.date_naissanceEnfant);
        final EditText ecole = (EditText) view.findViewById(R.id.ecoleEnfant);
        Button btModifier = (Button) view.findViewById(R.id.btModifierEnfant);
        Button btAnuller = (Button) view.findViewById(R.id.btAnullerMotifEnfant);
        id.setText(getItem(position).getId() + " ");
        nom.setText(getItem(position).getNom());
        prenom.setText(getItem(position).getPrenom());
        date_naissance.setText(getItem(position).getDate_naissance());
        ecole.setText(getItem(position).getEcole());

        btModifier.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Toast.makeText(getContext(),"vous modifier "+id.getText().toString(),Toast.LENGTH_SHORT).show();
                Navigation n=new Navigation();
                EnfantService enfantService=new EnfantService();
                enfantService.modifierEnfant(id.getText().toString(),nom.getText().toString(),prenom.getText().toString(),date_naissance.getText().toString(),ecole.getText().toString(),n.LoginValue,getContext());
            }
        });

        btAnuller.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                id.setText("");
                nom.setText("");
                prenom.setText("");
                date_naissance.setText("");
                ecole.setText("");
            }
        });
        return view;
    }

    /**
     * Created by lenovo on 29/03/2017.
     */


}