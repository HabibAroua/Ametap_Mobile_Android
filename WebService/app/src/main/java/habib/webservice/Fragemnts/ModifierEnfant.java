package habib.webservice.Fragemnts;


import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import habib.webservice.Controller.ActiviteController.ActiviteService;
import habib.webservice.Controller.EnfantController.EnfantAdapter;
import habib.webservice.Controller.EnfantController.EnfantContent;
import habib.webservice.Navigation;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModifierEnfant extends Fragment
{
    ListView listView;


    public ModifierEnfant() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().build()));
        ActiviteService activiteService=new ActiviteService(getContext());
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_modifier_enfant, container, false);
        Navigation n=new Navigation();
        listView = (ListView) v.findViewById(R.id.listEnfant);
        EnfantAdapter adapter = new EnfantAdapter(getContext(), R.layout.row_item2, EnfantContent.getEnfant(n.LoginValue));
        listView.setAdapter(adapter);

        return v;
    }

}
