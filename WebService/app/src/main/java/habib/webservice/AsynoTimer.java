package habib.webservice;

import android.os.AsyncTask;

/**
 * Created by lenovo on 17/02/2017.
 */
public class AsynoTimer extends AsyncTask<Void,Integer,Boolean>
{

    private boolean isRunnig;
    private boolean stop;
    private long time;
    private int seconde;
    @Override
    protected Boolean doInBackground(Void... params)
    {
        stop=false;
        isRunnig=true;
        time=System.currentTimeMillis();
        seconde=0;
        this.publishProgress(0);
        return null;
    }

    protected void onCancelled()
    {
        stop=true;
    }

    protected  void onPostExecute(Boolean result)
    {
        isRunnig=true;
    }

    protected void onProgressUpdtae(Integer ...values)
    {

    }
}
