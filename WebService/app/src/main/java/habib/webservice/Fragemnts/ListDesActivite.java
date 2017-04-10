package habib.webservice.Fragemnts;


import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import habib.webservice.Controller.ActiviteAdapter;
import habib.webservice.Controller.ActiviteService;
import habib.webservice.Model.Activite;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListDesActivite extends Fragment
{
    ListView listView;
    ArrayAdapter<String>adapter;
    public String adresse="http://192.168.1.8:88/Ametap/Activite.php";
    InputStream is=null;
    String line=null;
    String result=null;
    String []data;
    List<Activite> listActivite=new ArrayList<>();
    Button btDemander;


    ActiviteService activiteService=new ActiviteService(getContext());

    public ListDesActivite()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_list_des_activite, container, false);


        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().build()));
        ActiviteService activiteService=new ActiviteService(getContext());

        try
        {
            listView = (ListView) v.findViewById(R.id.listActivite);
            ActiviteAdapter adapter = new ActiviteAdapter(getContext(), R.layout.row_item, ActiviteContent.getActivites());
            listView.setAdapter(adapter);
        }
        catch(Exception e)
        {

        }
        btDemander=(Button)v.findViewById(R.id.btDemander);
        btDemander.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

            }
        });

        return v;
    }
}
