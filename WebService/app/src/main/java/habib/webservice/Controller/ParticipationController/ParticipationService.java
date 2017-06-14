package habib.webservice.Controller.ParticipationController;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import habib.webservice.Controller.IpAdresse;
import habib.webservice.Controller.MySingleton;
import habib.webservice.Model.Participation;


public class ParticipationService
{
    public ParticipationService()
    {

    }

    public void ParticipationAdherent(String login,String idActivite, final Context c)  {
        IpAdresse ipAdresse = new IpAdresse();
        final String myLogin;
        final String myIdActivite;
        myLogin=login;
        myIdActivite=idActivite;


        StringRequest stringRequest = new StringRequest(Request.Method.POST, ipAdresse.getIpAdresse() + "Ametap/DataOperation/ParticipationAdherent.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(c);
                        a_builder.setMessage(response).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

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
                params.put("login", myLogin);
                params.put("idActivite", myIdActivite);
                return params;
            }
        };
        MySingleton.getInstance(c).addTorequestique(stringRequest);
    }

    public void ParticipationConjoint(String login,String idActivite, final Context c)  {
        IpAdresse ipAdresse = new IpAdresse();
        final String myLogin;
        final String myIdActivite;
        myLogin=login;
        myIdActivite=idActivite;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, ipAdresse.getIpAdresse() + "Ametap/DataOperation/ParticipationConjoint.php",
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(c);
                        a_builder.setMessage(response).setCancelable(false).setPositiveButton
                                ("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                dialog.dismiss();
                            }
                        }
                        );
                        AlertDialog alert = a_builder.create();
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
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(c);
                        a_builder.setMessage("Erreur").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Alert");
                        alert.show();
                        //Toast.makeText(c, "Error ...", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("login", myLogin);
                params.put("idActivite", myIdActivite);
                return params;
            }
        };
        MySingleton.getInstance(c).addTorequestique(stringRequest);
    }

    public static List<Participation> getData(String login)
    {
        IpAdresse ipAdresse=new IpAdresse();
        String adresse = ipAdresse.getIpAdresse()+"Ametap/DataOperation/AfficheNotif.php?login="+login;
        InputStream is = null;
        String line = null;
        String result = null;
        String[] data;
        List<Participation> listNotif = new ArrayList<Participation>();
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
                data[i] = jo.getString("Nom_Activite");
                String Notif = jo.getString("Notif");
                String nom = jo.getString("Nom_Activite");
                listNotif.add(new Participation(Notif,nom));
            }



            return listNotif;

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Participation> getNotif(String login)
    {
        return getData(login);
    }

}
