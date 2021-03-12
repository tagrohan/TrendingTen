package com.example.trendingten.controllers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.trendingten.MainActivity;
import com.example.trendingten.R;
import com.example.trendingten.databinding.ActivityMainBinding;
import com.example.trendingten.databinding.ProfileDrawerBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;


public class DrawerController {
    private ActivityMainBinding binding;
    private Context context;
    private ProfileDrawerBinding header;
    GoogleSignInAccount account;
    public RestartActivity restartActivity;


    public DrawerController(Context context, ActivityMainBinding binding, ProfileDrawerBinding header) {
        this.context = context;
        this.binding = binding;
        this.header = header;

        init();
    }

    private void init() {
        navigationHeader();
        clickOnNavigation();
        openButton();
        userDetails();
    }

    public void userDetails() {
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(context);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            Uri personPhoto = acct.getPhotoUrl();


            Glide.with(context)
                    .load(personPhoto)
                    .into(binding.openProfile);

            Glide.with(context)
                    .load(personPhoto)
                    .into(header.avatar);

            header.avatarName.setText(personName);
        }
    }


    private void openButton() {
        binding.openProfile.setOnClickListener(view -> {
            binding.drawerLayout.open();
        });
    }

    private void navigationHeader() {
        header.avatarName.setText("tagrohan");

        header.avatarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavController controller = Navigation.findNavController((MainActivity) context, R.id.fragment);
                controller.navigate(R.id.profileFragment);
                binding.drawerLayout.close();
            }
        });
    }


    public void clickOnNavigation() {

        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.premium:
                        toast("Premium");
                        break;

                    case R.id.insta:
                        toast("insta");
                        break;

                    case R.id.twitter:
                        toast("twitter");
                        break;

                    case R.id.logout:
                        logout();
                        break;
                    case R.id.friend:
                        toast("friend");
                        break;
                    case R.id.you_tube:
                        toast("youtube");
                        break;
                }
                return true;
            }
        });
    }

    private void logout() {

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(context, gso);

        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle("Sign out!")
                .setMessage("Are you sure")
                .setPositiveButton("Sign out", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        mGoogleSignInClient.signOut()
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        restartActivity.restart();
                                    }
                                });
                    }
                }).setNegativeButton("cancel", null)
                .show();
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(context, R.color.themeOne));
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(context, R.color.themeOne));


    }

    private void toast(String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        binding.drawerLayout.close();
    }

    public void lastSignIn() {
        account = GoogleSignIn.getLastSignedInAccount(context);
    }

    public interface RestartActivity {
        void restart();
    }

}
