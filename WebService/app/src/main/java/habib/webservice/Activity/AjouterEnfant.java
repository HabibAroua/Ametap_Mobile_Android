package habib.webservice.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import habib.webservice.R;

public class AjouterEnfant extends AppCompatActivity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_enfant);
        getSupportFragmentManager().beginTransaction().add(R.id.ajouterEnfant, new habib.webservice.Fragemnts.ajouter_Enfant()).commit();

    }
}
