package org.fooshtech.t_mobilechallenge.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.fooshtech.t_mobilechallenge.R;
import org.fooshtech.t_mobilechallenge.adapter.RecyclerdAdapter;
import org.fooshtech.t_mobilechallenge.model.Cards;
import org.fooshtech.t_mobilechallenge.viewmodel.CardsViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    CardsViewModel viewModel;
    RecyclerView mRecyclerView;
    private RecyclerdAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter= new RecyclerdAdapter(this);
        mRecyclerView = findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
        getObserves();

    }

    private void getObserves() {
        viewModel = new ViewModelProvider(this).get(CardsViewModel.class);
        viewModel.getCards().observe(this, new Observer<List<Cards>>() {
            @Override
            public void onChanged(List<Cards> cards) {
                adapter.setItemList(cards);
            }
        });

        viewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.getError().removeObservers(this);
        viewModel.getCards().removeObservers(this);
    }
}