package com.example.nuhavarier.shopping_app.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.nuhavarier.shopping_app.R;
import com.example.nuhavarier.shopping_app.fragments.ClothingFragment;
import com.example.nuhavarier.shopping_app.fragments.EquipmentsFragment;
import com.example.nuhavarier.shopping_app.fragments.HelpFragment;
import com.example.nuhavarier.shopping_app.fragments.HistoryFragment;
import com.example.nuhavarier.shopping_app.fragments.HomeFragment;
import com.example.nuhavarier.shopping_app.fragments.MyAccountFragment;
import com.example.nuhavarier.shopping_app.fragments.ShoesFragment;
import com.example.nuhavarier.shopping_app.fragments.WishlistFragment;
import com.example.nuhavarier.shopping_app.listeners.OnFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,OnFragmentInteractionListener{

    ClothingFragment clothingFragment;
    ShoesFragment shoesFragment;
    EquipmentsFragment equipmentsFragment;
    MyAccountFragment myAccountFragment;
    WishlistFragment wishlistFragment;
    HistoryFragment historyFragment;
    HelpFragment helpFragment;
    HomeFragment homeFragment;
    TextView welcome;
    Boolean flag = false;
    String name="";
    SharedPreferences sharedPreferences;

    public static List<Cart> cartlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=getSharedPreferences("my_preference", Context.MODE_PRIVATE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initSp();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        View headerView = navigationView.getHeaderView(0);
        welcome=headerView.findViewById(R.id.welcome);
        if (sharedPreferences.getBoolean("is_user_logged_in",false)) {
            welcome.setText(name);
        }

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        if (clothingFragment == null) clothingFragment = ClothingFragment.newInstance(null,null);
        if (shoesFragment == null) shoesFragment = ShoesFragment.newInstance(null,null);
        if (equipmentsFragment == null) equipmentsFragment = EquipmentsFragment.newInstance(null,null);
        if (myAccountFragment == null) myAccountFragment = MyAccountFragment.newInstance(null,null);
        if (wishlistFragment == null) wishlistFragment = WishlistFragment.newInstance(null,null);
        if (historyFragment == null) historyFragment = HistoryFragment.newInstance(null,null);
        if (helpFragment == null) helpFragment = HelpFragment.newInstance(null,null);
        if (homeFragment == null) homeFragment = HomeFragment.newInstance(null,null);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main,new HomeFragment())
                .commit();

        Log.d("main_activity","onCreate Working");
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.clothing) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main,clothingFragment)
                    .commit();
        } else if (id == R.id.shoes) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main,shoesFragment)
                    .commit();

        } else if (id == R.id.equipments) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main,equipmentsFragment)
                    .commit();

        } else if (id == R.id.my_account) {
            flag=true;

            Log.d("TTTT"," >>> "+sharedPreferences.getBoolean("is_user_logged_in",false));
            if (!sharedPreferences.getBoolean("is_user_logged_in",false)) {
                Intent intent=new Intent(this,LoginPage.class);
                intent.putExtra("is_from","MainActivity");
                startActivityForResult(intent,100);
            } else {
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main,myAccountFragment)
                    .commit();
            }

        } else if (id == R.id.wishlist) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main,wishlistFragment)
                    .commit();

        } else if (id == R.id.history) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main,historyFragment)
                    .commit();

        } else if (id == R.id.help) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main,helpFragment)
                    .commit();

        } else if (id == R.id.home) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main,homeFragment)
                    .commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.title_bar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == Activity.RESULT_OK) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main,myAccountFragment)
                        .commit();
            }else{
                //ToDo: Show user to message
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=new Intent(this, Cart.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void initSp(){
        name=sharedPreferences.getString("name","Welcome");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
