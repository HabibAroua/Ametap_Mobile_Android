package habib.webservice.Controller;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by lenovo on 21/02/2017.
 */
public class MySingleton
{
    private static MySingleton mInstance ;
    private RequestQueue requestQueue ;
    private static Context myContext;

    private MySingleton(Context context)
    {
        myContext=context;
        requestQueue = getRequestQueue();
    }

    public static synchronized MySingleton getInstance(Context context)
    {
        if(mInstance==null)
        {
            mInstance=new MySingleton(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(myContext.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addTorequestique(Request<T> request )
    {
        requestQueue.add(request);
    }
}
