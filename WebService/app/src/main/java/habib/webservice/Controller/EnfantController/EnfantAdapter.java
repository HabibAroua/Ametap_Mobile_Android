package habib.webservice.Controller.EnfantController;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import habib.webservice.Model.Enfant;
import habib.webservice.Activity.Navigation;
import habib.webservice.R;

/**
 * Created by lenovo on 12/04/2017.
 */
public class EnfantAdapter extends ArrayAdapter<Enfant> {
    Context context;
    int resource;
    EditText date_naissance;
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
        date_naissance = (EditText) view.findViewById(R.id.date_naissanceEnfant);
        date_naissance.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

            }
        });
        final EditText ecole = (EditText) view.findViewById(R.id.ecoleEnfant);
        Button btModifier = (Button) view.findViewById(R.id.btModifierEnfant);
        Button btAnuller = (Button) view.findViewById(R.id.btAnullerMotifEnfant);
        id.setText(getItem(position).getId() + " ");
        nom.setText(getItem(position).getNom());
        prenom.setText(getItem(position).getPrenom());
        date_naissance.setText(getItem(position).getDate_naissance());
        date_naissance.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
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
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

            date_naissance.setText(sdf.format(myCalendar.getTime()));
        }

    };

    /**
     * Created by lenovo on 29/03/2017.
     */


}