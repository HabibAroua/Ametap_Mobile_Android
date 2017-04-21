package habib.webservice;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import habib.webservice.Fragemnts.Ajouter_Conjoint;
import habib.webservice.Fragemnts.ModifierConjoint;


public class Information_personnelle extends Fragment
{
    private Button btAjouterEnfant,btAjouterConjoint;
    public Information_personnelle()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_information_personnelle, container, false);
        btAjouterEnfant=(Button)v.findViewById(R.id.btEnfant);
        btAjouterConjoint=(Button)v.findViewById(R.id.btConjoint);
        btAjouterEnfant.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //FragmentManager fragmentManager =getFragmentManager();

                //fragmentManager.beginTransaction().replace(R.id.content,new ModifierConjoint()).commit();

                getFragmentManager().beginTransaction().replace(R.id.drawer_layout,new ModifierConjoint()).commit();
            }
        });

        btAjouterConjoint.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                getFragmentManager().beginTransaction().replace(R.id.drawer_layout,new Ajouter_Conjoint()).commit();
            }
        });
        return v;
    }
}
