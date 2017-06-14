package habib.webservice.Activity;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import habib.webservice.Controller.AdherentController.AdherentService;
import habib.webservice.Fragemnts.ListDesActivite;
import habib.webservice.R;

public class Navigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    public static String LoginValue ,PasswordValue;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Intent i=getIntent();
        LoginValue= i.getStringExtra("value1");
        PasswordValue=i.getStringExtra("value2");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        Intent intent=new Intent();
        PendingIntent pIntent=PendingIntent.getActivity(Navigation.this,0,intent,0);
        Notification  notification;

            notification = new Notification.Builder(Navigation.this)
                    .setTicker("")
                    .setContentTitle("Activité accepter")
                    .setContentText("Bienvenue")
                    .setSmallIcon(R.drawable.ic_ame_inscr)
                    .setContentIntent(pIntent)
                    .getNotification();
            notification.flags=Notification.FLAG_AUTO_CANCEL;
            NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(0,notification);


    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ListDesActivite(), "");
        //adapter.addFragment(new AfficheNotif(),"");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager =getSupportFragmentManager();
        if (id == R.id.nav_camera)
        {
            Intent i=new Intent(Navigation.this,Information_Personnel.class);
            startActivity(i);
        }
        else
        if (id == R.id.nav_gallery)
        {
            Intent i=new Intent(Navigation.this,HistoriqueActivite.class);
            startActivity(i);
        }
        else
        if (id == R.id.nav_share)
        {
            Intent i=new Intent(Navigation.this,Presentation.class);
            startActivity(i);
            //getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout,new Participer_activite()
            //).commit();
        }
        else
        if (id == R.id.nav_manage)
        {
            Intent i=new Intent(Navigation.this, habib.webservice.Activity.Notification.class);
            startActivity(i);
        }
        else if (id == R.id.nav_point)
        {
            AdherentService adherentService=new AdherentService();
            adherentService.getNombrePoint(LoginValue,Navigation.this);
        }
        else if (id == R.id.nav_send)
        {
            finish();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void toLogin()
    {
        Intent i=new Intent(Navigation.this,Login.class);

        startActivity(i);
    }


}

class ViewPagerAdapter extends FragmentPagerAdapter
{

    private final List<Fragment> mFragmentList = new ArrayList<>();

    private final List<String> mFragmentTitleList = new ArrayList<>();
    public ViewPagerAdapter(FragmentManager manager)
    {
        super(manager);
    }

    @Override

    public Fragment getItem(int position)
    {
        return mFragmentList.get(position);
    }

    @Override

    public int getCount()
    {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title)
    {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
    @Override

    public CharSequence getPageTitle(int position)
    {
        return mFragmentTitleList.get(position);
    }


}