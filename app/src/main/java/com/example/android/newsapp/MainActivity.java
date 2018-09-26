package com.example.android.newsapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.newsapp.Fragment.BusinessFragment;
import com.example.android.newsapp.Fragment.HealthFragment;
import com.example.android.newsapp.Fragment.PoliticsFragment;
import com.example.android.newsapp.Fragment.TopStoriesFragment;
import com.example.android.newsapp.Fragment.WorldFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup the navigation drawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Start the first Menu item in Navigation Drawer and highlight it
        onNavigationItemSelected(navigationView.getMenu().getItem(0).setChecked(true));

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {

            case R.id.nav_top_stories:
                /** When user selects home from navigation drawer, start {@link HomeFragment} */
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_body, new TopStoriesFragment())
                        .commit();
                break;

            case R.id.nav_world:
                /** When user selects home from navigation drawer, start {@link HomeFragment} */
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_body, new WorldFragment())
                        .commit();
                break;

            case R.id.nav_politics:
                /** When user selects home from navigation drawer, start {@link HomeFragment} */
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_body, new PoliticsFragment())
                        .commit();
                break;

            case R.id.nav_business:
                /** When user selects home from navigation drawer, start {@link HomeFragment} */
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_body, new BusinessFragment())
                        .commit();
                break;

            case R.id.nav_health:
                /** When user selects home from navigation drawer, start {@link HomeFragment} */
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_body, new HealthFragment())
                        .commit();
                break;

        }

        // When user selects an item from navigation drawer, close it
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
//        return super.onOptionsItemSelected(item);
        return false;
    }

}
