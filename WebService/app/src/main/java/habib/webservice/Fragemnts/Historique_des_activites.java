package habib.webservice.Fragemnts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import habib.webservice.Controller.ActiviteController.ActiviteHistAdapter;
import habib.webservice.Controller.ActiviteController.ActiviteHistoriqueContent;
import habib.webservice.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Historique_des_activites extends Fragment
{
    ListView listView;


    public Historique_des_activites() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_historique_des_activites, container, false);
        try {
            listView = (ListView) view.findViewById(R.id.listActiviteHis);
            ActiviteHistAdapter adapter = new ActiviteHistAdapter(getContext(), R.layout.item_row6, ActiviteHistoriqueContent.getActivites());
            listView.setAdapter(adapter);
        }
        catch(Exception ex)
        {

        }
        return view;
    }

}
