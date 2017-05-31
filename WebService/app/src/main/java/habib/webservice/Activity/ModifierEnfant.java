package habib.webservice.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import habib.webservice.R;

public class ModifierEnfant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportFragmentManager().beginTransaction().add(R.id.activityModifierConjoint, new habib.webservice.Fragemnts.ModifierConjoint()).commit();
        setContentView(R.layout.activity_modifier_enfant);
        getSupportFragmentManager().beginTransaction().add(R.id.activityModifierEnfant, new habib.webservice.Fragemnts.ModifierEnfant()).commit();

    }
}
