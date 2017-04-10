package habib.webservice;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import habib.webservice.Controller.MySingleton;

public class MainActivity extends AppCompatActivity
{
    EditText matricule,login,password,confirmPassword;
    Button btAjouter ,btEffacer;
    String URL = "http://192.168.1.8:88/Ametap/AjouterAdherent.php";
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matricule=(EditText)findViewById(R.id.txtMatricule);
        login=(EditText)findViewById(R.id.txtLogin);
        password=(EditText)findViewById(R.id.txtPassword);
        confirmPassword=(EditText)findViewById(R.id.txtConfirmPassword);
        builder =new AlertDialog.Builder(MainActivity.this);
        btEffacer=(Button)findViewById(R.id.btEffacer);
        btEffacer.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                matricule.setText("");
                login.setText("");
                password.setText("");
                confirmPassword.setText("");
            }
        });

        btAjouter=(Button)findViewById(R.id.btInscrire);
        btAjouter.setOnClickListener(
                new View.OnClickListener() {
                                         public void onClick(View v)
                                         {
                                             if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
                                                 confirmPassword.setError("Vérifier le code");
                                             }
                                             else
                                             {
                                                 final String myMatricule, myLogin, myPassword;
                                                 myMatricule = matricule.getText().toString();
                                                 myLogin = login.getText().toString();
                                                 myPassword = password.getText().toString();
                                                 StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                                                         new Response.Listener<String>() {
                                                             @Override
                                                             public void onResponse(String response) {
                                                                 builder.setTitle("Server response");
                                                                 builder.setMessage("Response :" + response);
                                                                 builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                     @Override
                                                                     public void onClick(DialogInterface dialog, int which) {
                                                                         matricule.setText("");
                                                                         login.setText("");
                                                                         password.setText("");
                                                                         //situation.setText("");
                                                                     }
                                                                 });
                                                                 AlertDialog alertDialog = builder.create();
                                                                 alertDialog.show();

                                                             }
                                                         }


                                                         ,
                                                         new Response.ErrorListener() {

                                                             @Override
                                                             public void onErrorResponse(VolleyError error) {
                                                                 Toast.makeText(MainActivity.this, "Error ...", Toast.LENGTH_SHORT).show();
                                                                 error.printStackTrace();
                                                             }
                                                         }) {
                                                     @Override
                                                     protected Map<String, String> getParams() throws AuthFailureError {
                                                         Map<String, String> params = new HashMap<String, String>();
                                                         params.put("matricule", myMatricule);
                                                         params.put("login", myLogin);
                                                         params.put("password", myPassword);
                                                         return params;
                                                     }
                                                 };
                                                 MySingleton.getInstance(MainActivity.this).addTorequestique(stringRequest);
                                             }
                                         }
                                     }
        );

    }


}
