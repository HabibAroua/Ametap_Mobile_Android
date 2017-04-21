package habib.webservice.Fragemnts;


import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import habib.webservice.Controller.ActiviteController.ActiviteService;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Choisir_Participant extends Fragment
{
    ListView listView;
    ArrayAdapter<String> adapter;
    public Choisir_Participant()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_choisir__participant, container, false);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().build()));
        ActiviteService activiteService=new ActiviteService(getContext());

        try
        {
            //listView=(ListView)v.findViewById(R.id.listParticipant);
            //ConjointAdapter adapter = new ConjointAdapter(getContext(), R.layout.row_item1, ConjointContent.getConjoint());
            //listView.setAdapter(adapter);
        }
        catch(Exception e)
        {

        }

        return v;
    }

}
