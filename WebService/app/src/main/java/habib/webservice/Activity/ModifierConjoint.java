package habib.webservice.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import habib.webservice.R;

public class ModifierConjoint extends AppCompatActivity
{
    public static String login;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_conjoint);
        getSupportFragmentManager().beginTransaction().add(R.id.activityModifierConjoint, new habib.webservice.Fragemnts.ModifierConjoint()).commit();
    }
}
