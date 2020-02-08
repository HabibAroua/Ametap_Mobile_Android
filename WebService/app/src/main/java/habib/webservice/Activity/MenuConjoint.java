package habib.webservice.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import habib.webservice.R;

public class MenuConjoint extends AppCompatActivity
{
    Button btAjouter,btModifier;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_conjoint);
        btAjouter=(Button)findViewById(R.id.buttonAjouterConjoint);
        btAjouter.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i=new Intent(MenuConjoint.this,AjouterConjoint.class);
                startActivity(i);
            }
        });

        btModifier=(Button)findViewById(R.id.buttonModifierConjoint);
        btModifier.setOnClickListener(new View.OnClickListener()
        {
            public  void onClick(View v)
            {
                Intent i= new Intent(MenuConjoint.this,ModifierConjoint.class);
                startActivity(i);
            }
        });
    }
}
