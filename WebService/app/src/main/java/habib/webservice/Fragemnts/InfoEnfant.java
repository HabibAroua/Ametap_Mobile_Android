package habib.webservice.Fragemnts;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import habib.webservice.Activity.*;
import habib.webservice.Controller.EnfantController.EnfantContent;
import habib.webservice.Controller.EnfantController.EnfantInfoAdapter;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoEnfant extends Fragment
{
ListView listView;

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
        Navigation n=new Navigation();
        listView = (ListView) v.findViewById(R.id.listInfoEnfant);
        EnfantInfoAdapter adapterInfo=new EnfantInfoAdapter(getContext(), R.layout.item_row5, EnfantContent.getEnfant(n.LoginValue));
        listView.setAdapter(adapterInfo);
        listView.setOnItemClickListener
                (
                        new AdapterView.OnItemClickListener()
                        {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                            {
                                if(id==1)
                                {
                                    Intent i=new Intent(getContext(), habib.webservice.Activity.ModifierConjoint.class);
                                    startActivity(i);
                                }
                            }
                        }
                );

        return v;
    }
}
