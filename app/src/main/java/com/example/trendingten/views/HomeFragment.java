package com.example.trendingten.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.trendingten.R;
import com.example.trendingten.controllers.HomePager;
import com.example.trendingten.databinding.FragmentHomeBinding;
import com.example.trendingten.models.Thumbnail;
import com.example.trendingten.vm.HomeViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    GoogleSignInAccount account;
    HomeViewModel viewModel;
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

        viewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        viewModel.invokeHomeApi();

        // todo going to call api to get data and passing it to pager
        HomePager pager = new HomePager(new ArrayList<>()); // sending empty at initially
        binding.homeRecyclerView.setAdapter(pager);
        binding.homeRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        // todo creating observer for it
        viewModel.getThumbnail().observe(getViewLifecycleOwner(), new Observer<List<Thumbnail>>() {
            @Override
            public void onChanged(List<Thumbnail> thumbnails) {
                pager.updateHomeRecycler(thumbnails);
                binding.swipeToRefresh.setRefreshing(false);
            }
        });


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
            viewModel.invokeHomeApi();
        });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        account = GoogleSignIn.getLastSignedInAccount(getContext());
    }

}