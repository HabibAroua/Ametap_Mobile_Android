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
import habib.webservice.Controller.ConjointController.ConjointContent;
import habib.webservice.Controller.ConjointController.ConjointInfoAdapter;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoConjoint extends Fragment {
    ListView listView;

    public InfoConjoint() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info_conjoint, container, false);
        Navigation n = new Navigation();
        listView = (ListView) v.findViewById(R.id.listInfoConjoint);
        ConjointInfoAdapter adapterInfo = new ConjointInfoAdapter(getContext(), R.layout.row_item4, ConjointContent.getConjoint(n.LoginValue));
        listView.setAdapter(adapterInfo);
        listView.setOnItemClickListener
                (
                        new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                if (id == 0)
                                {
                                    Navigation n=new Navigation();
                                    Intent intent=new Intent(getActivity(), MenuConjoint.class);
                                    startActivity(intent);
                                }
                            }
                        } );

        return v;
    }
}