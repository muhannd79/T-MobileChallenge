package org.fooshtech.t_mobilechallenge.request;


import org.fooshtech.t_mobilechallenge.model.ResultList;


import io.reactivex.Observable;
import retrofit2.http.GET;


public interface CardsApi {


    @GET("test/home")
    Observable<ResultList> getCards();

}
