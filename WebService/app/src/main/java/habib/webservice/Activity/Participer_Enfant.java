package habib.webservice.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import habib.webservice.Controller.EnfantController.EnfantContent;
import habib.webservice.Controller.EnfantController.EnfantPartAdapter;
import habib.webservice.R;

public class Participer_Enfant extends AppCompatActivity
{
    ListView listView;
    TextView exceptionPartEnfant;
    public static String idActivite;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participer__enfant);
        try
        {
            listView = (ListView) findViewById(R.id.listpartEnfant);
            exceptionPartEnfant=(TextView)findViewById(R.id.exceptionPartEnfant);
            Navigation n = new Navigation();
            EnfantPartAdapter enfantPartAdapter = new EnfantPartAdapter(Participer_Enfant.this, R.layout.itel_row7, EnfantContent.getEnfant(n.LoginValue));
            listView.setAdapter(enfantPartAdapter);
            Intent intent = getIntent();
            idActivite = intent.getStringExtra("value1");
        }
        catch(Exception e)
        {
            exceptionPartEnfant.setText("Aucun enfant");
        }
    }
}
