package habib.webservice.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import habib.webservice.R;

public class ModifierConjoint extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_conjoint);
        getSupportFragmentManager().beginTransaction().add(R.id.activityModifierEnfant, new habib.webservice.Fragemnts.ModifierEnfant()).commit();

    }
}
