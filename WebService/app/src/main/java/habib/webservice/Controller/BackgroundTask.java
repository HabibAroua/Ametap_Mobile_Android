package habib.webservice.Controller;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import habib.webservice.Model.Activite;

/**
 * Created by lenovo on 06/04/2017.
 */
public class BackgroundTask
{
    IpAdresse ipAdresse=new IpAdresse();
    Context context;
    ArrayList<Activite> arrayList=new ArrayList<>();
    String  json_url=ipAdresse.getIpAdresse()+"Ametap/Activite.php";
    public BackgroundTask(Context context)
    {
        this.context=context;
    }
    public ArrayList<Activite> getList()
    {
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, json_url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        int count=0;
                        while(count<response.length())
                        {
                            try
                            {
                                JSONObject jsonObject=response.getJSONObject(count);
                                Activite activite=new Activite(jsonObject.getInt("ID"),jsonObject.getString("Nom_activite")
                                        ,jsonObject.getString("date_debut"),jsonObject.getString("date_fin")
                                        ,jsonObject.getDouble("prix_unitaire"),jsonObject.getString("Nom_organisateur"));
                                arrayList.add(activite);
                                count++;

                            }
                            catch(JSONException e)
                            {
                                Toast.makeText(context,"hello",Toast.LENGTH_LONG).show();

                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                //Toast.makeText(context,"Erreur..",Toast.LENGTH_LONG).show();
                error.printStackTrace();

            }
        });
        //Toast.makeText(context,"hello",Toast.LENGTH_LONG).show();
        MySingleton.getInstance(context).addTorequestique(jsonArrayRequest);
        return arrayList;
    }


}
