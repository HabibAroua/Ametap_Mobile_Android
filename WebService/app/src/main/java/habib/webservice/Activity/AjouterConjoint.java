package habib.webservice.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import habib.webservice.R;

public class AjouterConjoint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_conjoint);
        getSupportFragmentManager().beginTransaction().add(R.id.ajouterConjoint, new habib.webservice.Fragemnts.Ajouter_Conjoint()).commit();

    }
}
