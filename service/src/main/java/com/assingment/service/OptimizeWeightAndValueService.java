package com.assingment.service;

import io.swagger.model.WeightAndValue;
import io.swagger.model.WeightAndValueResponse;

public interface OptimizeWeightAndValueService {
    WeightAndValueResponse getMaxValueAndWeightList(WeightAndValue weightAndValue);
}
