package habib.webservice.Controller;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import habib.webservice.MainActivity;

/**
 * Created by lenovo on 29/03/2017.
 */
public class AdherentService
{

    android.support.v7.app.AlertDialog.Builder builder;
    public AdherentService()
    {

    }

    public String getAdresseIp()
    {
        return "http://192.168.1.219:88/";
    }

    public void inscription(String matricule,String login , String password , String confirmPassword)
    {

        if (!password.equals(confirmPassword)) {

        } else {
            final String myMatricule, myLogin, myPassword;
            myMatricule = matricule;
            myLogin = login;
            myPassword = password;
            StringRequest stringRequest = new StringRequest(Request.Method.POST, getAdresseIp()+"AjouterAdherent.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            builder.setTitle("Server response");
                            builder.setMessage("Response :" + response);
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //situation.setText("");
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();

                        }
                    }


                    ,
                    new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("matricule", myMatricule);
                    params.put("login", myLogin);
                    params.put("password", myPassword);
                    return params;
                }
            };
            MainActivity m=new MainActivity();
            MySingleton.getInstance(m).addTorequestique(stringRequest);
        }

    }
}
