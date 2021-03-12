package com.example.trendingten;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.trendingten.controllers.DrawerController;
import com.example.trendingten.databinding.ActivityMainBinding;
import com.example.trendingten.databinding.ProfileDrawerBinding;
import com.example.trendingten.interfaces.DrawerLocker;

public class MainActivity extends AppCompatActivity implements DrawerLocker {

    ActivityMainBinding binding;
    ProfileDrawerBinding header;
    NavController navController;
    DrawerController drawerController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // inflating views
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        header = ProfileDrawerBinding.bind(binding.navigationView.getHeaderView(0));

//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.themeOne));
        setContentView(binding.getRoot());

        navController = Navigation.findNavController(this, R.id.fragment);
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);

        NavigationUI.setupWithNavController(binding.navigationView,navController);

        // DrawerController is handling all of the navigation
        drawerController = new DrawerController(this, binding, header);

        //restart activity after logout
        drawerController.restartActivity = () -> {
            finish();
            startActivity(getIntent());
        };
    }

    // handling back button with navigation drawer
    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isOpen()) {
            binding.drawerLayout.close();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void setDrawerLocked(boolean enabled) {
        if (enabled) {
            binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            binding.bottomNavigation.setVisibility(View.GONE);
            binding.openProfile.setVisibility(View.GONE);
        } else {
            binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            binding.bottomNavigation.setVisibility(View.VISIBLE);
            binding.openProfile.setVisibility(View.VISIBLE);
            drawerController.userDetails();
        }
    }
}