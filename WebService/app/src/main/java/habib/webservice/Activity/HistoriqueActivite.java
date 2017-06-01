package habib.webservice.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import habib.webservice.R;

public class HistoriqueActivite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique_activite);
        getSupportFragmentManager().beginTransaction().add(R.id.histAct, new habib.webservice.Fragemnts.Historique_des_activites()).commit();

    }
}
