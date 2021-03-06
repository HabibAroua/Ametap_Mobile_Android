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

import habib.webservice.Activity.AjouterEnfant;
import habib.webservice.Activity.MenuEnfant;
import habib.webservice.Activity.Navigation;
import habib.webservice.Controller.EnfantController.EnfantContent;
import habib.webservice.Controller.EnfantController.EnfantInfoAdapter;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoEnfant extends Fragment
{
ListView listView;
TextView exceptionEnfant;
    public InfoEnfant()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_info_enfant, container, false);
        try {
            Navigation n = new Navigation();
            exceptionEnfant=(TextView)v.findViewById(R.id.exceptionEnfant);
            listView = (ListView) v.findViewById(R.id.listInfoEnfant);
            EnfantInfoAdapter adapterInfo = new EnfantInfoAdapter(getContext(), R.layout.item_row5, EnfantContent.getEnfant(n.LoginValue));
            listView.setAdapter(adapterInfo);
        }
        catch (Exception ex)
        {
            exceptionEnfant.setText("Vous n'a pas des enfant .. clicquer ici pour les ajouter");

        }
        listView.setOnItemClickListener
                (
                        new AdapterView.OnItemClickListener()
                        {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                            {
                                Intent i=new Intent(getActivity(), MenuEnfant.class);
                                startActivity(i);
                            }
                        }
                );

        exceptionEnfant.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i=new Intent(getActivity(), AjouterEnfant.class);
                startActivity(i);
            }
        });

        return v;
    }
}
