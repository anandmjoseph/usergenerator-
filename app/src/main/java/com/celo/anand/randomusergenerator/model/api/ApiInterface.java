package com.celo.anand.randomusergenerator.model.api;


import com.celo.anand.randomusergenerator.model.data.ApiResponseDTO;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("?nat=US")
    Observable<ApiResponseDTO> getRandomUsers(@Query("results") int count);
}
