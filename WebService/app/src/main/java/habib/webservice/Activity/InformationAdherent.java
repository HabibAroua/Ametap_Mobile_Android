package habib.webservice.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import habib.webservice.R;

public class InformationAdherent extends AppCompatActivity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_adherent);
        getSupportFragmentManager().beginTransaction().add(R.id.infoAdherent, new habib.webservice.Fragemnts.ModifierInfoPers()).commit();
    }
}
