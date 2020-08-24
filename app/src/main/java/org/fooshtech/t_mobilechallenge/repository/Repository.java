package org.fooshtech.t_mobilechallenge.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.fooshtech.t_mobilechallenge.model.Cards;
import org.fooshtech.t_mobilechallenge.model.ResultList;
import org.fooshtech.t_mobilechallenge.request.CardsApi;
import org.fooshtech.t_mobilechallenge.request.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class Repository {

    private MutableLiveData<List<Cards>> listMutableLiveData;
    private List<Cards> cardList = new ArrayList<>();

    private MutableLiveData<String> errorMutableLiveData;
    private String error;

    private Observable<ResultList> observable;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public Repository() {
        listMutableLiveData = new MutableLiveData<>();
        errorMutableLiveData = new MutableLiveData<>();
        getCards();
    }

    public void getCards(){

        CardsApi cardsApi = RetrofitInstance.getRetrofitInstance();
        observable = cardsApi.getCards();
        compositeDisposable.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<ResultList>(){

                    @Override
                    public void onNext(ResultList resultList) {

                        cardList =  resultList.getPage().getCards();

                        for (Cards item:cardList) {
                            Log.d("tmz","item="+item.getCardType());
                        }


                    }


                    @Override
                    public void onError(Throwable e) {
                        errorMutableLiveData.postValue(e.getMessage().toString());

                    }


                    @Override
                    public void onComplete() {
                        listMutableLiveData.postValue(cardList);
                    }
                })
        );

    }

    public LiveData<List<Cards>> getCardList() {
        return listMutableLiveData;
    }

    public LiveData<String> getError() {
        return errorMutableLiveData;
    }
}
