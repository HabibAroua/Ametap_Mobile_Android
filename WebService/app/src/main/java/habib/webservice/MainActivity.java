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

public class MainActivity extends AppCompatActivity
{
    EditText cin,nom,prenom,situation,email,nbr_enfant,telephone;
    Button btAjouter ,btEffacer;
    String URL = "http://192.168.1.5:88/Ametap/AjouterAdherent.php";
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cin=(EditText)findViewById(R.id.txtCin);
        nom=(EditText)findViewById(R.id.txtNom);
        prenom=(EditText)findViewById(R.id.txtPrenom);
        situation=(EditText)findViewById(R.id.txtSituation);
        email=(EditText)findViewById(R.id.txtEmail);
        nbr_enfant=(EditText)findViewById(R.id.txtNbEnfant);
        telephone=(EditText)findViewById(R.id.txtTelephone);
        builder =new AlertDialog.Builder(MainActivity.this);
        btEffacer=(Button)findViewById(R.id.btEffacer);
        btEffacer.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                cin.setText("");
                nom.setText("");
                prenom.setText("");
                situation.setText("");
                email.setText("");
                nbr_enfant.setText("");
                telephone.setText("");
            }
        }
        );

        btAjouter=(Button)findViewById(R.id.btInscrire);
        btAjouter.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                final String myCin, myNom, myPrenom, mySituation, myEmail, myNombreEnfant , myTelephone;
                myCin = cin.getText().toString();
                myNom = nom.getText().toString();
                myPrenom = prenom.getText().toString();
                mySituation = situation.getText().toString();
                myEmail = email.getText().toString();
                myNombreEnfant = nbr_enfant.getText().toString();
                myTelephone=telephone.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                        new Response.Listener<String>() {

                            @Override
                            public void onResponse(String response)
                            {
                                builder.setTitle("Server response");
                                builder.setMessage("Response :"+response);
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        cin.setText("");
                                        nom.setText("");
                                        prenom.setText("");
                                        situation.setText("");
                                        email.setText("");
                                        nbr_enfant.setText("");
                                        telephone.setText("");
                                    }
                                });
                                AlertDialog alertDialog =builder.create();
                                alertDialog.show();

                            }
                        }


                         ,
                 new Response.ErrorListener() {

                     @Override
                     public void onErrorResponse(VolleyError error)
                     {
                         Toast.makeText(MainActivity.this,"Error ...",Toast.LENGTH_SHORT).show();
                         error.printStackTrace();
                     }
                 }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String , String > params=new HashMap<String, String>();
                        params.put("id",myCin);
                        params.put("nom",myNom);
                        params.put("prenom",myPrenom);
                        params.put("situation",mySituation);
                        params.put("email",myEmail);
                        params.put("nombreEnfant",myNombreEnfant);
                        params.put("telephone",myTelephone);
                        return params;
                    }
                };
            MySingleton.getInstance(MainActivity.this).addTorequestique(stringRequest);





             /*   Boolean test=true;
                AsynchTaskDAO a=new AsynchTaskDAO();
                if(cin.getText().toString().equals(""))
                {
                    cin.setError("SVP donner votre cin");
                    test=false;
                    return;
                }
                if(nom.getText().toString().equals(""))
                {
                    nom.setError("SVP donner votre nom");
                    test=false;
                    return;
                }
                if(prenom.getText().toString().equals(""))
                {
                    prenom.setError("SVP donner votre prenom");
                    test=false;
                    return;
                }
                if(situation.getText().toString().equals(""))
                {
                    situation.setError("SVP donner votre situation");
                    test=false;
                    return ;
                }
                if(email.getText().toString().equals(""))
                {
                    email.setError("SVP donner votre email");
                    test=false;
                    return;
                }
                if(nbr_enfant.getText().toString().equals(""))
                {
                    nbr_enfant.setError("SVP donner le nombre des enfants");
                    test=false;
                    return ;
                }
                if(telephone.getText().toString().equals(""))
                {
                    telephone.setError("SVP donner votre numéro");
                    test=false;
                    return;
                } */

            }
        }
        );

    }


}
