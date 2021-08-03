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

import com.example.trendingten.R;
import com.example.trendingten.controllers.HomePager;
import com.example.trendingten.controllers.ShortRecycler;
import com.example.trendingten.databinding.FragmentShortBinding;
import com.example.trendingten.models.Card;
import com.example.trendingten.vm.ShortViewModel;

import java.util.ArrayList;
import java.util.List;

public class ShortFragment extends Fragment {
    FragmentShortBinding binding;
    ShortViewModel viewModel;
    ShortRecycler shortRecycler;

    public ShortFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentShortBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ShortViewModel.class);
        viewModel.invokeShortApi();
        observers();
        shortRecycler = new ShortRecycler(new ArrayList<>());
    }

    private void observers() {
        viewModel.getCards().observe(getViewLifecycleOwner(), new Observer<List<Card>>() {
            @Override
            public void onChanged(List<Card> cards) {
                if (cards.size() > 0) {
                    invokingRecycler(cards);
                }
            }
        });
    }

    private void invokingRecycler(List<Card> cards) {
        shortRecycler.updatingRecycler(cards);
        binding.pager.setAdapter(shortRecycler);
    }
}