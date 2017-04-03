package habib.webservice.Controller;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import habib.webservice.Navigation;

/**
 * Created by lenovo on 29/03/2017.
 */
public class ConjointService
{
    android.support.v7.app.AlertDialog.Builder builder;
    public ConjointService()
    {

    }
    public void ajouterConjoint(String cin,String nom,String prenom,String date_naissance,String metier,String login,final Context c)
    {
        IpAdresse ipAdresse =new IpAdresse();
        final String myCin, myNom, myPrenom, myDate_naissance,myMetier,myLogin;
        myCin = cin;
        myNom = nom;
        myPrenom = prenom;
        myDate_naissance=date_naissance;
        myMetier=metier;
        myLogin=login;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, ipAdresse.getIpAdresse()+"Ametap/AjouterConjoint.php",
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
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


                    }
                }
                ,
                new Response.ErrorListener()
                {

                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        error.printStackTrace();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("cin", myCin);
                params.put("nom", myNom);
                params.put("prenom", myPrenom);
                params.put("date_naissance",myDate_naissance);
                params.put("metier",myMetier);
                params.put("login",myLogin);
                return params;
            }
        };
        Navigation n=new Navigation();
        MySingleton.getInstance(n).addTorequestique(stringRequest);
    }
}
