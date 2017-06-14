package habib.webservice.Fragemnts;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import habib.webservice.Activity.InformationAdherent;
import habib.webservice.Activity.Navigation;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AfficheInfoAdherent extends Fragment
{
    TextView login;
    Button btModifier;

    public AfficheInfoAdherent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_affiche_info_adherent, container, false);
        login=(TextView)view.findViewById(R.id.viewInfoLogin);
        Navigation n=new Navigation();
        login.setText(n.LoginValue);
        btModifier=(Button)view.findViewById(R.id.btGoModifierInfo);
        btModifier.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent=new Intent(getActivity(), InformationAdherent.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
