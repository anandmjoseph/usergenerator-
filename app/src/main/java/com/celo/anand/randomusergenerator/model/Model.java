package com.celo.anand.randomusergenerator.model;


import com.celo.anand.randomusergenerator.model.data.ApiResponseDTO;

import io.reactivex.Observable;

public interface Model {
    Observable<ApiResponseDTO> getUsersList(int count);
}
