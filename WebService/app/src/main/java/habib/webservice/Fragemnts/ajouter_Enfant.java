package habib.webservice.Fragemnts;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.net.UnknownHostException;

import habib.webservice.Controller.EnfantController.EnfantService;
import habib.webservice.Navigation;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ajouter_Enfant extends Fragment
{
    Button btAjouterEnfant , btEffacerEnfant;
    EditText id,nom,prenom,date_naissance,ecole;


    public ajouter_Enfant()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_ajouter__enfant, container, false);
        id=(EditText)view.findViewById(R.id.txtIdEnfant);
        nom=(EditText)view.findViewById(R.id.txtNomEnfant);
        prenom=(EditText)view.findViewById(R.id.txtPrenomEnfant);
        date_naissance=(EditText)view.findViewById(R.id.txtDate_naissanceEnfant);
        ecole=(EditText)view.findViewById(R.id.txtEcoleEnfant);
        btAjouterEnfant=(Button)view.findViewById(R.id.btAjouterEnfant);
        btAjouterEnfant.setOnClickListener
                (
                        new View.OnClickListener()
                        {
                            public void onClick(View v)
                            {
                                Navigation n=new Navigation();
                                String s=n.LoginValue;
                                EnfantService es=new EnfantService();
                                try
                                {
                                    es.AjouterEnfant(id.getText().toString(),nom.getText().toString(),prenom.getText().toString(),date_naissance.getText().toString(),ecole.getText().toString(),s,getContext());
                                }
                                catch (UnknownHostException e)
                                {
                                    e.printStackTrace();
                                }
                                //Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                            }
                        }
                );
        btEffacerEnfant=(Button)view.findViewById(R.id.btEffacerEnfant);
        btEffacerEnfant.setOnClickListener
                (
                        new View.OnClickListener()
                        {
                            public void onClick(View v)
                            {
                                id.setText("");
                                nom.setText("");
                                prenom.setText("");
                                date_naissance.setText("");
                                ecole.setText("");
                                AlertDialog.Builder a_builder=new AlertDialog.Builder(getContext());
                                a_builder.setMessage("Hello world").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();

                                    }
                                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                                AlertDialog alert=a_builder.create();
                                alert.setTitle("Alert");
                                alert.show();




                                //MyDialog myDialog=new MyDialog("Hello");

                            }
                        }
                );
        return view;
    }
}
