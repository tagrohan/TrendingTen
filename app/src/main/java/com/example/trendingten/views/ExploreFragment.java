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
import com.example.trendingten.databinding.FragmentExploreBinding;
import com.example.trendingten.models.Thumbnail;
import com.example.trendingten.vm.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment {

    FragmentExploreBinding binding;
    HomeViewModel homeViewModel;

    public ExploreFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentExploreBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        // todo testing in invoking again
//        homeViewModel.invokeHomeApi();

        HomePager pager = new HomePager(new ArrayList<>());
        binding.exploreRecyclerView.setAdapter(pager);
        binding.exploreRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        // todo creating observer for it
        homeViewModel.getThumbnail().observe(getViewLifecycleOwner(), new Observer<List<Thumbnail>>() {
            @Override
            public void onChanged(List<Thumbnail> thumbnails) {
                pager.updateHomeRecycler(thumbnails);
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
    }
}