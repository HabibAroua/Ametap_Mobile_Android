package habib.webservice.Controller.ConjointController;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import habib.webservice.Model.Conjoint;
import habib.webservice.R;

/**
 * Created by lenovo on 02/05/2017.
 */
public class ConjointInfoAdapter  extends ArrayAdapter<Conjoint>

    {
        AppCompatActivity a;
        Button btModif;
        Context context;
        int resource;
        EditText date_naissance;
        Button btModifier;
        public ConjointInfoAdapter(Context context, int resource, List<Conjoint > membre)
        {
            super(context, resource, membre);
            this.context = context;
            this.resource = resource;
        }

        @Override
        public View getView ( int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View view = inflater.inflate(resource, parent, false);
           final TextView nom=(TextView) view.findViewById(R.id.viewNomConjoint);
            final TextView prenom= (TextView) view.findViewById(R.id.viewPrenomConjoint);
            final TextView date_naissance=(TextView)view.findViewById(R.id.viewDateNaissanceConjoint);
             nom.setText(getItem(position).getNom() + " ");
            prenom.setText(getItem(position).getPrenom());
            date_naissance.setText(getItem(position).getPrenom());
            date_naissance.setText(getItem(position).getDate_naissance());
            nom.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {

                }
            });



             return view;
        }


    }
