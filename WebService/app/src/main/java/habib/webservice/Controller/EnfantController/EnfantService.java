package habib.webservice.Controller.EnfantController;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import habib.webservice.Controller.IpAdresse;
import habib.webservice.Controller.MySingleton;
import habib.webservice.Model.Enfant;


/**
 * Created by lenovo on 14/04/2017.
 */
public  class EnfantService
{
    public EnfantService()
    {

    }

    public void AjouterEnfant(String id, String nom, String prenom, String date_naissance, String ecole, String login, final Context c) throws UnknownHostException {
        IpAdresse ipAdresse = new IpAdresse();
        final String myId, myNom, myPrenom, myDate_naissance, myEcole, myLogin;
        myId = id;
        myNom = nom;
        myPrenom = prenom;
        myDate_naissance = date_naissance;
        myEcole = ecole;
        myLogin = login;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, ipAdresse.getIpAdresse() + "Ametap/DataOperation/AjouterEnfant.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(c);
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
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Alert");
                        alert.show();
                    }
                }
                ,
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(c);
                        a_builder.setMessage("Erreur").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Alert");
                        alert.show();
                        //Toast.makeText(c, "Error ...", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", myId);
                params.put("nom", myNom);
                params.put("prenom", myPrenom);
                params.put("date_naissance", myDate_naissance);
                params.put("ecole", myEcole);
                params.put("login", myLogin);
                return params;
            }
        };
        MySingleton.getInstance(c).addTorequestique(stringRequest);
    }

    public static List<Enfant> getData(String login)
    {
        IpAdresse ipAdresse=new IpAdresse();
        String adresse =ipAdresse.getIpAdresse()+"Ametap/DataOperation/AfficherEnfants.php?login=" + login;
        InputStream is = null;
        String line = null;
        String result = null;
        String[] data;
        List<Enfant> listEnfant = new ArrayList<Enfant>();
        try
        {
            URL url = new URL(adresse);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            is = new BufferedInputStream(con.getInputStream());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null)
            {
                //Toast.makeText(v.getContext(),line,Toast.LENGTH_SHORT).show();
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            JSONArray ja = new JSONArray(result);
            JSONObject jo = null;
            data = new String[ja.length()];
            for (int i = 0; i < ja.length(); i++)
            {
                jo = ja.getJSONObject(i);
                data[i] = jo.getString("nom");
                int identificateur = jo.getInt("id");
                String nom = jo.getString("nom");
                String prenom = jo.getString("prenom");
                String date_naissance = jo.getString("date_naissance");
                String ecole = jo.getString("ecole");
                listEnfant.add(new Enfant(identificateur, nom, prenom, date_naissance, ecole));
            }
            return listEnfant;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void modifierEnfant(String id, String nom, String prenom, String date_naissance, String ecole, String login, final Context c)
    {
        IpAdresse ipAdresse = new IpAdresse();
        final String myId, myNom, myPrenom, myDate_naissance, myEcole, myLogin;
        myId = id;
        myNom = nom;
        myPrenom = prenom;
        myDate_naissance = date_naissance;
        myEcole = ecole;
        myLogin = login;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, ipAdresse.getIpAdresse() + "Ametap/DataOperation/modifierEnfant.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(c);
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
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Alert");
                        alert.show();
                    }
                }
                ,
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(c);
                        a_builder.setMessage("Erreur").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Alert");
                        alert.show();
                        //Toast.makeText(c, "Error ...", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", myId);
                params.put("nom", myNom);
                params.put("prenom", myPrenom);
                params.put("date_naissance", myDate_naissance);
                params.put("ecole", myEcole);
                params.put("login", myLogin);
                return params;
            }
        };
        MySingleton.getInstance(c).addTorequestique(stringRequest);
    }
}

