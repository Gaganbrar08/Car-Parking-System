package com.example.macstudent.carparkingsystem;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macstudent.carparkingsystem.database.AddTicket;
import com.example.macstudent.carparkingsystem.database.AddTicketDao;
import com.example.macstudent.carparkingsystem.database.AppDatabase;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        counter = findViewById(R.id.counter);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "AddTicket-database").build();
        AddTicketDao addTicketDao = AppDatabase.getInstance(HomeActivity.this).addTicket();
        int count = addTicketDao.getAllAddTicket().size();
        counter.setText(String.valueOf(count));


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
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent = null;
        int id = item.getItemId();

        if (id == R.id.nav_Home) {
            intent = new Intent(HomeActivity.this, HomeActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_addticket) {
            intent = new Intent(HomeActivity.this, AddTicketActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_location) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:0,0?q=43.6497688362,-79.38952512778(" + getString(R.string.app_name) + ")"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "Maps application is not available.", Toast.LENGTH_LONG).show();
            }
        } else if (id == R.id.nav_report) {

        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_instruction) {
            intent = new Intent(HomeActivity.this, InstructionActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_contact) {
            intent = new Intent(HomeActivity.this, ContactActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {
            intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {

        counter = findViewById(R.id.counter);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "AddTicket-database").build();
        AddTicketDao addTicketDao = AppDatabase.getInstance(HomeActivity.this).addTicket();
        int count = addTicketDao.getAllAddTicket().size();
        counter.setText(String.valueOf(count));

        super.onStart();
    }
}

