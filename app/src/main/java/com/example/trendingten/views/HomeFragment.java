package com.example.trendingten.views;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.trendingten.R;
import com.example.trendingten.controllers.HomePager;
import com.example.trendingten.databinding.FragmentHomeBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    GoogleSignInAccount account;
    private static final String TAG = "HomeFragment";

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (account == null) {
//            NavOptions.Builder options = new NavOptions.Builder().setPopUpTo(R.id.signInFragment, true);
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_signInFragment);
        }


        // todo going to call api to get data and passing it to pager
        HomePager pager = new HomePager();
        binding.homeRecyclerView.setAdapter(pager);

        pager.itemPosition = new HomePager.ItemPosition() {
            @Override
            public void itemPosition(int position) {

                Bundle bundle = new Bundle();

                bundle.putInt("KEY", position);
                Navigation.findNavController(view).navigate(R.id.HomeToCardSwipe
                        , bundle);
            }
        };


        binding.swipeToRefresh.setOnRefreshListener(() -> {
            new Handler().postDelayed(() -> {
                binding.swipeToRefresh.setRefreshing(false);
                Toast.makeText(requireContext(), "refreshing", Toast.LENGTH_SHORT).show();
                binding.swipeToRefresh.setRefreshing(false);
            }, 500);
        });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        account = GoogleSignIn.getLastSignedInAccount(getContext());
    }

}