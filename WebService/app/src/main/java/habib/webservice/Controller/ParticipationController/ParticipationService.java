package habib.webservice.Controller.ParticipationController;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import habib.webservice.Controller.IpAdresse;
import habib.webservice.Controller.MySingleton;

/**
 * Created by lenovo on 20/04/2017.
 */
public class ParticipationService
{
    public ParticipationService()
    {

    }

    public void AjouterEnfant(String login,String idActivite, final Context c)  {
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

    public void Message(Context context)
    {
        Toast.makeText(context,"Message", Toast.LENGTH_SHORT).show();
    }

}
