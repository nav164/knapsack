package com.assingment.service;

import io.swagger.model.Item;
import io.swagger.model.WeightAndValue;
import io.swagger.model.WeightAndValueResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OptimizeWeightAndValueServiceImpl implements OptimizeWeightAndValueService {

    /**
     * This method will create grid of type [values][weights]
     * e.g. [value1,value2....,value.y][weight1,weight2.....,weight.z] i.e.(.y is the size of list & .z is the allowed weight)
     * @param weightAndValue
     * @return
     */
    public WeightAndValueResponse getMaxValueAndWeightList(WeightAndValue weightAndValue) {

        int NB_ITEMS = weightAndValue.getItems().size();
        // use a matrix to store the max value at each n-th item
        int[][] matrix = new int[NB_ITEMS + 1][weightAndValue.getAllowedWeight() + 1];

        // first line is initialized to 0
        for (int i = 0; i <= weightAndValue.getAllowedWeight(); i++)
            matrix[0][i] = 0;

        // iterate on items
        for (int i = 1; i <= NB_ITEMS; i++) {
            // we iterate on each capacity
            for (int j = 0; j <= weightAndValue.getAllowedWeight(); j++) {
                if (weightAndValue.getItems().get(i - 1).getWeight() > j)
                    matrix[i][j] = matrix[i-1][j];
                else
                    //maximize value at this rank in the matrix
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j - weightAndValue.getItems().get(i - 1).getWeight()]
                            + weightAndValue.getItems().get(i - 1).getValue());
            }
        }
        List<Item> itemsSolution = this.getOptimizeItems(matrix,weightAndValue);
        return this.mapper(itemsSolution, matrix[NB_ITEMS][weightAndValue.getAllowedWeight()]);
    }

    /**
     * This method will return all the items which are allowed to get max value in given capacity
     * @param matrix
     * @param weightAndValue
     * @return
     */
    public List<Item> getOptimizeItems(int[][] matrix, WeightAndValue weightAndValue) {
        int totalItem = weightAndValue.getItems().size();
        int res = matrix[totalItem][weightAndValue.getAllowedWeight()];
        int w = weightAndValue.getAllowedWeight();
        List<Item> itemsSolution = new ArrayList<>();
        for (int i = totalItem; i > 0  &&  res > 0; i--) {
            if (res != matrix[i-1][w]) {
                itemsSolution.add(weightAndValue.getItems().get(i - 1));
                //remove items value and weight
                res -= weightAndValue.getItems().get(i - 1).getValue();
                w -= weightAndValue.getItems().get(i - 1).getWeight();
            }
        }
        return itemsSolution;
    }

    /**
     * This method will map the values to the response object
     * @param items
     * @param maxValue
     * @return
     */
    public WeightAndValueResponse mapper(List<Item> items, int maxValue) {
        WeightAndValueResponse weightAndValueResponse = new WeightAndValueResponse();
        List<Integer> weights = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        AtomicInteger totalWeight = new AtomicInteger();
        items.forEach(item -> {
            totalWeight.set(totalWeight.get() + item.getWeight());
            weights.add(item.getWeight());
            values.add(item.getValue());
        });
        weightAndValueResponse.setItemsToPack(weights);
        weightAndValueResponse.setValue(values);
        weightAndValueResponse.setTotalWeight(totalWeight+" kg");
        weightAndValueResponse.setTotalValue(maxValue);
        return weightAndValueResponse;
    }
}
