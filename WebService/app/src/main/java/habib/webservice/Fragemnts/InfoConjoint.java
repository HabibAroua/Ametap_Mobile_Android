package habib.webservice.Fragemnts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import habib.webservice.Activity.Navigation;
import habib.webservice.Controller.ConjointController.ConjointContent;
import habib.webservice.Controller.ConjointController.ConjointInfoAdapter;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoConjoint extends Fragment
{
    private ListView listView;
    private Button btModifier;
    public InfoConjoint()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.fragment_info_conjoint, container, false);
        // Inflate the layout for this fragment
        Navigation n=new Navigation();
        listView = (ListView) v.findViewById(R.id.listInfoConjoint);
        ConjointInfoAdapter adapterInfo=new ConjointInfoAdapter(getContext(), R.layout.row_item4, ConjointContent.getConjoint(n.LoginValue));
        listView.setAdapter(adapterInfo);
        listView.setOnItemClickListener
                (
                        new AdapterView.OnItemClickListener()
                        {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                            {
                                if(id==0)
                                {
                             //       ModifierConjoint modifierConjoint=new ModifierConjoint();
                               //     android.support.v4.app.FragmentTransaction fragmentTransation=getFragmentManager().beginTransaction();
                                 //   fragmentTransation.replace(R.id.actInfoPersonnel,modifierConjoint);
                                   // fragmentTransation.commit();
                                }
                            }
                        }
                );
        //btModifier.setOnClickListener(new View.OnClickListener()
        //{
          //  public void onClick(View v)
            //{
              //  FragmentManager fragmentManager =getFragmentManager();

                //fragmentManager.beginTransaction().replace(R.id.actInfoPersonnel,new ModifierConjoint()).commit();
            //}
        //});
        return v;
    }

}
