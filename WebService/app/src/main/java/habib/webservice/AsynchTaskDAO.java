package habib.webservice;
import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 16/02/2017.
 */
public class AsynchTaskDAO extends AsyncTask<String, Void, String>
{
    protected String doInBackground(String... params)
    {
        try
        {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(params[0]); // url
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(7);
            nameValuePairs.add(new BasicNameValuePair("var1", params[1].toString()));
            nameValuePairs.add(new BasicNameValuePair("var2", params[2].toString()));
            nameValuePairs.add(new BasicNameValuePair("var3", params[3].toString()));
            nameValuePairs.add(new BasicNameValuePair("var3", params[4].toString()));
            nameValuePairs.add(new BasicNameValuePair("var3", params[5].toString()));
            nameValuePairs.add(new BasicNameValuePair("var3", params[6].toString()));
            nameValuePairs.add(new BasicNameValuePair("var3", params[7].toString()));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
        }
        catch (ClientProtocolException e)
        {
            Log.v("err protocol exception",e.getMessage().toString());
        }
        catch (IOException e)
        {
            Log.v("____error io",e.getMessage().toString());
        }
        return "success";
    }

    protected void onPostExecute(String result)
    {
        super.onPostExecute(result);
        Log.v("________result", result);
    }

}
