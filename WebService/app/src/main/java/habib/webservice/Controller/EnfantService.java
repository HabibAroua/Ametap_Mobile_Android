package habib.webservice.Controller;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 29/03/2017.
 */


public class EnfantService extends AppCompatActivity
{
    public  EnfantService()
    {

    }
    public void AjouterEnfant(String id, String nom , String prenom, String date_naissance, String ecole, String login , final Context c)
    {
        IpAdresse ipAdresse =new IpAdresse();
        final String myId, myNom, myPrenom, myDate_naissance,myEcole,myLogin;
        myId = id;
        myNom = nom;
        myPrenom = prenom;
        myDate_naissance=date_naissance;
        myEcole=ecole;
        myLogin=login;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, ipAdresse.getIpAdresse()+"Ametap/AjouterEnfant.php",
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        AlertDialog.Builder a_builder=new AlertDialog.Builder(c);
                        a_builder.setMessage(response).setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog alert=a_builder.create();
                        alert.setTitle("Alert");
                        alert.show();
                    }
                }
                ,
                new Response.ErrorListener()
                {

                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        AlertDialog.Builder a_builder=new AlertDialog.Builder(c);
                        a_builder.setMessage("Erreur").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                        AlertDialog alert=a_builder.create();
                        alert.setTitle("Alert");
                        alert.show();
                        //Toast.makeText(c, "Error ...", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", myId);
                params.put("nom", myNom);
                params.put("prenom", myPrenom);
                params.put("date_naissance",myDate_naissance);
                params.put("ecole",myEcole);
                params.put("login",myLogin);
                return  params;
            }
        };
        MySingleton.getInstance(c).addTorequestique(stringRequest);
    }
}
