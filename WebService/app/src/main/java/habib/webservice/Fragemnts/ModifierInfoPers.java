package habib.webservice.Fragemnts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import habib.webservice.Activity.Navigation;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModifierInfoPers extends Fragment
{
    Button btModifier,btAnnuler;
    EditText login,oldPassword,newPassword,confirNewPassword;
    public ModifierInfoPers()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        Navigation n=new Navigation();
        View v=inflater.inflate(R.layout.fragment_modifier_info_pers, container, false);
        login=(EditText)v.findViewById(R.id.txtNewLogin);
        oldPassword=(EditText)v.findViewById(R.id.txtOldPassword);
        newPassword=(EditText)v.findViewById(R.id.txtNewPassword);
        confirNewPassword=(EditText)v.findViewById(R.id.txtConfNewPassword);
        login.setText(n.LoginValue);
        oldPassword.setText(n.PasswordValue);
        return v;
    }

}
