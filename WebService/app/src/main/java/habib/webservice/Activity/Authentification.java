package habib.webservice.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import habib.webservice.Controller.IpAdresse;
import habib.webservice.Controller.MySingleton;
import habib.webservice.R;

public class Authentification extends AppCompatActivity
{
    TextView lin;
    EditText log ,password;
    private String login,mot_de_passe;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
        //setContentView(R.layout.activity_login);
        log=(EditText)findViewById(R.id.usrusr);
        password=(EditText)findViewById(R.id.pswrdd);
        lin=(TextView)findViewById(R.id.lin);
        lin.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                IpAdresse ipAdresse=new IpAdresse();
                JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.POST ,ipAdresse.getIpAdresse()+"Ametap/DataOperation/AdherentISExist.php?login="+log.getText().toString()+"&password="+password.getText().toString()+"",(String)null
                        ,new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try
                        {
                            login = response.getString("login");
                            mot_de_passe=response.getString("password");
                            //Toast.makeText(Authentification.this, login+" "+mot_de_passe, Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(Authentification.this,Navigation.class);
                            i.putExtra("value1",log.getText().toString());
                            i.putExtra("value2",password.getText().toString());
                            startActivity(i);
                            finish();
                        }
                        catch(JSONException ex)
                        {
                            ex.printStackTrace();
                        }

                    }
                },new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(Authentification.this, "Error ....", Toast.LENGTH_SHORT).show();
                    }
                });
                MySingleton.getInstance(Authentification.this).addTorequestique(jsonObjectRequest);


            }
        });
    }
}
