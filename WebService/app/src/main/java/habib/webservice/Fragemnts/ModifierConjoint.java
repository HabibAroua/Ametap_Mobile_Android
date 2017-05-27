package habib.webservice.Fragemnts;


import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import habib.webservice.Controller.ActiviteController.ActiviteService;
import habib.webservice.Controller.ConjointController.ConjointAdapter;
import habib.webservice.Controller.ConjointController.ConjointContent;
import habib.webservice.Activity.Navigation;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModifierConjoint extends Fragment implements AdapterView.OnItemClickListener {
ListView listView;

    public ModifierConjoint() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().build()));
        ActiviteService activiteService=new ActiviteService(getContext());
        View v=inflater.inflate(R.layout.fragment_modifier_conjoint, container, false);

     //   try
       // {

            Navigation n=new Navigation();
        ///Toast.makeText(getContext(),n.LoginValue,Toast.LENGTH_SHORT).show();
        //ConjointService cs=new ConjointService();
        //List<Conjoint> list =cs.getData(n.LoginValue);
        //for (int i=0;i<list.size();i++)
        //{
          //  Toast.makeText(getContext(),list.get(i).getPrenom(),Toast.LENGTH_SHORT).show();
        //}
            listView = (ListView) v.findViewById(R.id.listConjoint);
            ConjointAdapter adapter = new ConjointAdapter(getContext(), R.layout.row_item1, ConjointContent.getConjoint(n.LoginValue));
            listView.setAdapter(adapter);

        //}
        //catch(Exception e)
       //{

       //}
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
