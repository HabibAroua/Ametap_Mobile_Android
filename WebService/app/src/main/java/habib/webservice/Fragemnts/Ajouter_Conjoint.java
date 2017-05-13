package habib.webservice.Fragemnts;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import habib.webservice.Controller.ConjointController.ConjointService;
import habib.webservice.Activity.Navigation;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ajouter_Conjoint extends Fragment
{
    private Button btAjouter,btEffacer;
    private EditText txtCin,txtNom,txtPrenom,txtDate_naissance,txtMetier;

    public Ajouter_Conjoint()
    {
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
        txtDate_naissance.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
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
    Calendar myCalendar = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
        private void updateLabel() {

            String myFormat = "MM/dd/yy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            txtDate_naissance.setText(sdf.format(myCalendar.getTime()));
        }

    };

}
