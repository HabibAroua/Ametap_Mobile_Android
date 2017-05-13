package habib.webservice.Controller.AdherentController;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import habib.webservice.Controller.IpAdresse;
import habib.webservice.Controller.MySingleton;
import habib.webservice.Activity.Login;
import habib.webservice.Activity.MainActivity;
import habib.webservice.Activity.Navigation;

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
        return "http://192.168.43.212:88/";
    }

    public void inscription(String matricule,String login , String password  ,final MainActivity c)
    {
        IpAdresse ipAdresse = new IpAdresse();
        final String myMatricule, myLogin, myPassword;
        myMatricule = matricule;
        myLogin = login;
        myPassword = password;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, ipAdresse.getIpAdresse() + "Ametap/DataOperation/AjouterAdherent.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        builder.setTitle("Server response");
                        builder.setMessage("Response :" + response);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                //situation.setText("");
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        error.printStackTrace();
                        Toast.makeText(c,"Erreur",Toast.LENGTH_SHORT).show();
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
        MySingleton.getInstance(c).addTorequestique(stringRequest);
    }



    public void Connexion(final String login,final String mot_de_passe , final Login l)
    {
        IpAdresse ipAdress=new IpAdresse();
        JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.POST ,ipAdress.getIpAdresse()+"Ametap/DataOperation/AdherentISExist.php?login="+login+"&password="+mot_de_passe+"",(String)null
                ,new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    String Mylogin = response.getString("login");
                    String Mymot_de_passe=response.getString("password");
                    Toast.makeText(l,login,Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(l,Navigation.class);
                    i.putExtra("value",login);
                    l.startActivity(i);
                }
                catch(JSONException ex)
                {
                    ex.printStackTrace();
                }
            }
        },new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(l, "Error ....", Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getInstance(l).addTorequestique(jsonObjectRequest);

    }
}
