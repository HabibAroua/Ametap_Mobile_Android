package habib.webservice;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import habib.webservice.Controller.AdherentController.AdherentService;

public class MainActivity extends AppCompatActivity
{
    EditText matricule, login, password, confirmPassword;
    Button btAjouter, btEffacer;
    String URL = "http://192.168.1.41:88/Ametap/DataOperation/AjouterAdherent.php";
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        matricule = (EditText) findViewById(R.id.txtMatricule);
        login = (EditText) findViewById(R.id.txtLogin);
        password = (EditText) findViewById(R.id.txtPassword);
        confirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);
        builder = new AlertDialog.Builder(MainActivity.this);
        btEffacer = (Button) findViewById(R.id.btEffacer);
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

        btAjouter = (Button) findViewById(R.id.btInscrire);
        btAjouter.setOnClickListener
                (new View.OnClickListener()
                {
                     public void onClick(View v)
                     {
                         if (!password.getText().toString().equals(confirmPassword.getText().toString()))
                         {
                             confirmPassword.setError("Vérifier le code");
                         }
                         else
                         {
                             AdherentService adherentService = new AdherentService();
                             adherentService.inscription(matricule.getText().toString(), login.getText().toString(), password.getText().toString(), MainActivity.this);
                         }
                     }
                 }
                );
    }

}
