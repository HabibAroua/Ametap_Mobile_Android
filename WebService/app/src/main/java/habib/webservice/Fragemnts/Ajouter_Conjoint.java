package habib.webservice.Fragemnts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import habib.webservice.Controller.ConjointService;
import habib.webservice.Navigation;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ajouter_Conjoint extends Fragment
{
    private Button btAjouter,btEffacer;
    private EditText txtCin,txtNom,txtPrenom,txtDate_naissance,txtMetier;

    public Ajouter_Conjoint() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_ajouter__conjoint, container, false);
        txtCin=(EditText)v.findViewById(R.id.txtCinConjoint);
        txtNom=(EditText)v.findViewById(R.id.txtNomConjoint);
        txtPrenom=(EditText)v.findViewById(R.id.txtPrenomConjoint);
        txtDate_naissance=(EditText)v.findViewById(R.id.txtDate_naissanceConjoint);
        txtMetier=(EditText)v.findViewById(R.id.txtMetierConjoint);
        btEffacer=(Button)v.findViewById(R.id.btEffacerConjoint);
        btEffacer.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                txtCin.setText("");
                txtNom.setText("");
                txtPrenom.setText("");
                txtDate_naissance.setText("");
                txtMetier.setText("");
            }
        });
        btAjouter=(Button)v.findViewById(R.id.btAjouterConjoint);
        btAjouter.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Navigation n=new Navigation();
                String s=n.LoginValue;
                ConjointService cs=new ConjointService();
                cs.ajouterConjoint(txtCin.getText().toString(),txtNom.getText().toString(),txtPrenom.getText().toString(),txtDate_naissance.getText().toString(),txtMetier.getText().toString(),s,getContext());
            }
        });

        return v;
    }

}
