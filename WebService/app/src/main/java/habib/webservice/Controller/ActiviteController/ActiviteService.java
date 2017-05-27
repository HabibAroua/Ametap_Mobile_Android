package habib.webservice.Controller.ActiviteController;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import habib.webservice.Controller.IpAdresse;
import habib.webservice.Model.Activite;

/**
 * Created by lenovo on 08/04/2017.
 */
public class ActiviteService
{
    ListView listView;
    ArrayAdapter<String> adapter;
    IpAdresse ipAdresse=new IpAdresse();
    public String adresse=ipAdresse.getIpAdresse()+"Ametap/DataOperation/AfficherActiviteActuel.php";
    InputStream is=null;
    String line=null;
    String result=null;
    String []data;
    List<Activite> listActivite=new ArrayList<Activite>();
    public ActiviteService(Context v)
    {
        //adapter=new ArrayAdapter<String>(getContext(), R.layout.row_item);
    }
    public ActiviteService()
    {}
    public  List<Activite> getData(Context v)
    {
        try
        {
            URL url=new URL(adresse);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            is=new BufferedInputStream(con.getInputStream());


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            while((line=br.readLine())!=null)
            {
                //Toast.makeText(v.getContext(),line,Toast.LENGTH_SHORT).show();
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;
            data=new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data[i]=jo.getString("Nom_activite");
                int id=jo.getInt("ID");
                String nom_activite=jo.getString("Nom_activite");
                String date_debut=jo.getString("date_debut");
                String date_fin=jo.getString("date_fin");
                double prix_unitaire=jo.getDouble("prix_unitaire");
                String nom_organisateur=jo.getString("nom_organisateur");
                listActivite.add(new Activite(id,nom_activite,date_debut,date_fin,prix_unitaire,nom_organisateur));
                //Toast.makeText(getContext(),"ID :"+id+" nom activité :"+ nom_activite+" date debut :"+date_debut+" date fin :"+date_fin+" prix unitaire :"+prix_unitaire+" nom organisateur :"+nom_organisateur,Toast.LENGTH_SHORT).show();
            }
            return listActivite;
            //for(int i=0;i<listActivite.size();i++)
            //{
                //Toast.makeText(getContext(),  listActivite.get(i).toString(),Toast.LENGTH_SHORT).show();
            //}
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public  List<Activite> getData()
    {
        try
        {
            URL url=new URL(adresse);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            is=new BufferedInputStream(con.getInputStream());


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            while((line=br.readLine())!=null)
            {
                //Toast.makeText(v.getContext(),line,Toast.LENGTH_SHORT).show();
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;
            data=new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data[i]=jo.getString("Nom_activite");
                int id=jo.getInt("ID");
                String nom_activite=jo.getString("Nom_activite");
                String date_debut=jo.getString("date_debut");
                String date_fin=jo.getString("date_fin");
                double prix_unitaire=jo.getDouble("prix_unitaire");
                String nom_organisateur=jo.getString("nom_organisateur");
                listActivite.add(new Activite(id,nom_activite,date_debut,date_fin,prix_unitaire,nom_organisateur));
                //Toast.makeText(getContext(),"ID :"+id+" nom activité :"+ nom_activite+" date debut :"+date_debut+" date fin :"+date_fin+" prix unitaire :"+prix_unitaire+" nom organisateur :"+nom_organisateur,Toast.LENGTH_SHORT).show();
            }
            return listActivite;
            //for(int i=0;i<listActivite.size();i++)
            //{
            //Toast.makeText(getContext(),  listActivite.get(i).toString(),Toast.LENGTH_SHORT).show();
            //}
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
