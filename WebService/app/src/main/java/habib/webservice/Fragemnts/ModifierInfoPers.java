package habib.webservice.Fragemnts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import habib.webservice.Activity.Navigation;
import habib.webservice.Controller.AdherentController.AdherentService;
import habib.webservice.R;

/**
 * A simple {@link Fragment} subclass.
 */

public class ModifierInfoPers extends Fragment
{
    Button btModifier;
    EditText login, newPassword, confirNewPassword;
    AdherentService adherentService;

    public ModifierInfoPers()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        adherentService = new AdherentService();
        Navigation n = new Navigation();
        View view = inflater.inflate(R.layout.fragment_modifier_info_pers, container, false);
        login = (EditText) view.findViewById(R.id.txtNewLogin);
        newPassword = (EditText) view.findViewById(R.id.txtNewPassword);
        confirNewPassword = (EditText) view.findViewById(R.id.txtConfNewPassword);
        login.setText(n.LoginValue);
        btModifier = (Button) view.findViewById(R.id.btModifierInfoPers);
        btModifier.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try
                {
                    if (!newPassword.getText().toString().equals(confirNewPassword.getText().toString()))
                    {
                        confirNewPassword.setError("mot de passe incorecct");
                    }
                    else
                    {
                        if (login.getText().toString().equals(""))
                        {
                            login.setError("SVP saisir votre nouveau login");
                        }
                        else
                        {
                            if (newPassword.getText().toString().equals(""))
                            {
                                newPassword.setError("SVP saisir un mot de passe");
                            }
                            else
                            {
                                if ((confirNewPassword.getText().toString().equals("")) && (!newPassword.getText().toString().equals(""))) {
                                    confirNewPassword.setError("SVP confirmer votre mot de passe");
                                }
                                else
                                {
                                    Navigation n = new Navigation();
                                    adherentService.modifierInfoPersonnel(n.LoginValue, login.getText().toString(), newPassword.getText().toString(), getContext());
                                    n.LoginValue = login.getText().toString();
                                }
                            }
                        }
                    }
                }
                catch (Exception e)
                {

                }
            }
        });
        return view;
    }
}