package habib.webservice.Controller;

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

import habib.webservice.Model.Conjoint;

/**
 * Created by lenovo on 11/04/2017.
 */
public class FamilleService
{

    ListView listView;
    ArrayAdapter<String> adapter;
    public String adresse = "http://192.168.43.212:88/Ametap/AfficherMembreFamille.php";
    InputStream is = null;
    String line = null;
    String result = null;
    String[] data;
    List<Conjoint> listActivite = new ArrayList<Conjoint>();

    public List<Conjoint> getData() {
        try
        {
            URL url = new URL(adresse);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            is = new BufferedInputStream(con.getInputStream());
        } catch (Exception e) {
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
                int identificateur = jo.getInt("identificateur");
                String nom = jo.getString("nom");
                String prenom= jo.getString("prenom");
                String date_naissance = jo.getString("date_naissance");
                listActivite.add(new Conjoint(identificateur,nom,prenom,date_naissance));
            }
            return listActivite;
            //for(int i=0;i<listActivite.size();i++)
            //{
            //Toast.makeText(getContext(),  listActivite.get(i).toString(),Toast.LENGTH_SHORT).show();
            //}
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

