package habib.webservice.Fragemnts;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import habib.webservice.Activity.*;
import habib.webservice.Controller.ConjointController.ConjointContent;
import habib.webservice.Controller.ConjointController.ConjointInfoAdapter;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoConjoint extends Fragment
{
    ListView listView;
    TextView exceptionConjoint,exceptionTitreConjoint;

    public InfoConjoint() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {



            View v = inflater.inflate(R.layout.fragment_info_conjoint, container, false);
        try {
            Navigation n = new Navigation();
            listView = (ListView) v.findViewById(R.id.listInfoConjoint);
            exceptionTitreConjoint=(TextView)v.findViewById(R.id.exceptionTitreConjoint);
            exceptionConjoint=(TextView)v.findViewById(R.id.exceptionConjoint);
            ConjointInfoAdapter adapterInfo = new ConjointInfoAdapter(getContext(), R.layout.row_item4, ConjointContent.getConjoint(n.LoginValue));
            listView.setAdapter(adapterInfo);
        }
        catch (Exception ex)
        {
            exceptionConjoint.setText("Vous n'a pas conjoint .. clicquer ici pour le ajouter");
            exceptionTitreConjoint.setText("Mon Conjoint");
        }
            listView.setOnItemClickListener
                    (
                            new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    if (id == 0) {
                                        Navigation n = new Navigation();
                                        Intent intent = new Intent(getActivity(), MenuConjoint.class);
                                        startActivity(intent);
                                    }
                                }
                            });
        exceptionConjoint.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i=new Intent(getActivity(), AjouterConjoint.class);
                startActivity(i);
            }
        });



        return v;
    }
}