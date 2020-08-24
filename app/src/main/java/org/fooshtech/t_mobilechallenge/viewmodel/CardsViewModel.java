package org.fooshtech.t_mobilechallenge.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import org.fooshtech.t_mobilechallenge.model.Cards;
import org.fooshtech.t_mobilechallenge.repository.Repository;

import java.util.List;

public class CardsViewModel extends ViewModel {

    private Repository repository;

    public CardsViewModel() {

        repository = new Repository();
    }

    public  LiveData<List<Cards>> getCards() {
        return repository.getCardList();
    }

    public LiveData<String> getError(){
        return repository.getError();
    }
}
