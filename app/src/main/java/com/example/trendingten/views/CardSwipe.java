package com.example.trendingten.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.trendingten.R;
import com.example.trendingten.controllers.CardRecycler;
import com.example.trendingten.databinding.FragmentCardSwipeBinding;
import com.example.trendingten.models.Card;
import com.example.trendingten.models.Thumbnail;
import com.example.trendingten.vm.CardSwipeViewModel;
import com.example.trendingten.vm.HomeViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardSwipe extends Fragment implements View.OnClickListener {

    private static final String TAG = "CardSwipe";
    FragmentCardSwipeBinding binding;
    private int position;
    public List<Card> sendingData = new ArrayList<>();
    CardStackLayoutManager manager;
    CardSwipeViewModel viewModel;
    HomeViewModel homeViewModel;
    NavController controller;
    CardRecycler recycler;
    List<Thumbnail> thumbnails;

    public CardSwipe() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCardSwipeBinding.inflate(inflater);

        position = getArguments().getInt("KEY");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        viewModel = new ViewModelProvider(getActivity()).get(CardSwipeViewModel.class);
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        // todo testing in invoking again
//        homeViewModel.invokeHomeApi();
        observers();


        binding.forward.setOnClickListener(this);
        binding.rewind.setOnClickListener(this);
        binding.like.setOnClickListener(this);

        controller = Navigation.findNavController(requireView());

//        viewModel.updateData(position);
        recyclerManager();
        recycler = new CardRecycler(requireContext(), sendingData);
    }


    // LiveData observers
    private void observers() {
        homeViewModel.getThumbnail().observe(getViewLifecycleOwner(), thumbnails -> {
            CardSwipe.this.thumbnails = thumbnails;
            List<Card> cards = thumbnails.get(position).getCards();
            Collections.reverse(cards);
            invokingRecycler(cards);
        });
    }

    private void invokingRecycler(List<Card> data) {
        recycler.updatingRecycler(data);

        binding.stackView.setLayoutManager(manager);
        binding.stackView.setAdapter(recycler);
    }

    private void recyclerManager() {
        manager = new CardStackLayoutManager(getContext(), new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {

            }

            @Override
            public void onCardSwiped(Direction direction) {

            }

            @Override
            public void onCardRewound() {

            }

            @Override
            public void onCardCanceled() {

            }

            @Override
            public void onCardAppeared(View view, int position) {
            }

            @Override
            public void onCardDisappeared(View view, int position) {
                if (position == 9) {
                    controller.navigateUp();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forward:
                animateFAB(binding.forward);
                binding.stackView.swipe();
                break;
            case R.id.like:
                animateFAB(binding.like);
                break;
            case R.id.rewind:
                animateFAB(binding.rewind);
                binding.stackView.rewind();
                break;
        }
    }

    private void animateFAB(final FloatingActionButton fab) {
        fab.animate().scaleX(0.7f).scaleY(0.7f).setDuration(80).withEndAction(new Runnable() {
            @Override
            public void run() {
                fab.animate().scaleX(1f).scaleY(1f);
            }
        });

    }
}