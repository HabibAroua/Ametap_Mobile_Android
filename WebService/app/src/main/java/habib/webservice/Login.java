package habib.webservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import habib.webservice.Controller.MySingleton;

public class Login extends AppCompatActivity
{
    private TextView inscrire;
    private EditText email,password;
    private Button btAnnuler,connexion;
    private String login,mot_de_passe;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        connexion=(Button) findViewById(R.id.btConnexion);
        email=(EditText)findViewById(R.id.email_au);
        password=(EditText)findViewById(R.id.password_Au);
        btAnnuler=(Button)findViewById(R.id.btAnnuler);
        inscrire=(TextView)findViewById(R.id.inscrire);
        inscrire.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent i=new Intent(Login.this,MainActivity.class);
                startActivity(i);
            }
        });

        connexion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.POST ,"http://192.168.1.8:88/Ametap/AdherentISExist.php?login="+email.getText().toString()+"&password="+password.getText().toString()+"",(String)null
                        ,new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response)
                    {
                      try
                        {
                           login = response.getString("login");
                            mot_de_passe=response.getString("password");
                            Toast.makeText(Login.this, login+" "+mot_de_passe, Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(Login.this,Navigation.class);
                            i.putExtra("value",email.getText().toString());
                            startActivity(i);
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
                        Toast.makeText(Login.this, "Error ....", Toast.LENGTH_SHORT).show();
                    }
                });
                MySingleton.getInstance(Login.this).addTorequestique(jsonObjectRequest);


            }
        });


        btAnnuler.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                email.setText("");
                password.setText("");

            }
        });
    }
}
