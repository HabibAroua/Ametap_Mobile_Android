package habib.webservice.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import habib.webservice.R;

public class MenuEnfant extends AppCompatActivity
{
    Button btAjouter,btModifier;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_enfant);
        btAjouter=(Button)findViewById(R.id.buttonAjouterEnfant);
        btModifier=(Button)findViewById(R.id.buttonModifierEnfant);
        btAjouter.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i=new Intent(MenuEnfant.this,AjouterEnfant.class);
                startActivity(i);
            }
        });

        btModifier.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i=new Intent(MenuEnfant.this,ModifierEnfant.class);
                startActivity(i);

            }
        });
    }
}
