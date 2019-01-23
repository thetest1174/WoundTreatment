package com.example.woundtreatment;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(MainActivity.this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.recent_activity: {
                //do something
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentRecent()).commit();
                break;
            }

                case R.id.report:{
                //do something
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentReport()).commit();
                break;
            }
            case R.id.patient_list:{
                //do something
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentPatients()).commit();
                break;
            }
            case R.id.upload:{
                //do something
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentUpload()).commit();
                break;
            }
            case R.id.download:{
                //do something
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentDownload()).commit();
                break;
            }
            case R.id.settings:{
                //do something
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentSettings()).commit();
                break;
            }
            case R.id.tip_n_feedback:{
                //do something
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentTalk()).commit();
                break;
            }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }
            return super.onOptionsItemSelected(item);

    }

}
