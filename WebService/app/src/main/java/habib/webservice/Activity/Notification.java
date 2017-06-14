package habib.webservice.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import habib.webservice.R;

public class Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        getSupportFragmentManager().beginTransaction().add(R.id.Act_notif, new habib.webservice.Fragemnts.AfficheNotif()).commit();

    }
}
