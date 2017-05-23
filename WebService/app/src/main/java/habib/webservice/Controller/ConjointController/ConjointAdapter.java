package habib.webservice.Controller.ConjointController;

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

import habib.webservice.Activity.Navigation;
import habib.webservice.Model.Conjoint;
import habib.webservice.R;

/**
 * Created by lenovo on 11/04/2017.
 */
public class ConjointAdapter extends ArrayAdapter<Conjoint>
{
    Context context;
    int resource;
      EditText date_naissance;
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
        date_naissance=(EditText) view.findViewById(R.id.conjointDateNaissance);
       // date_naissance.setOnClickListener(new View.OnClickListener()
        //{
          //  public void onClick(View v)
            //{
              //  new DatePickerDialog(getContext(), date, myCalendar
                //        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                  //      myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            //}
        //});
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
                conjointService.modifierConjoint(cin.getText().toString(),nom.getText().toString(),prenom.getText().toString(),date_naissance.getText().toString(),metier.getText().toString(),n.LoginValue, getContext());
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

}

