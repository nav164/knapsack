package com.assignment.testData;

import io.swagger.model.Item;
import io.swagger.model.WeightAndValue;
import io.swagger.model.WeightAndValueResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {

    public static WeightAndValue getWeightValueRequestData(){
        WeightAndValue weightAndValue = new WeightAndValue();
        List<Item> itemList = new ArrayList<>();
        Item item = new Item();
        item.setName("Elt1");
        item.setValue(30);
        item.setWeight(10);
        itemList.add(item);

        item = new Item();
        item.setName("Elt2");
        item.setValue(6);
        item.setWeight(3);
        itemList.add(item);
        
        item = new Item();
        item.setName("Elt3");
        item.setValue(15);
        item.setWeight(10);
        itemList.add(item);
        
        item = new Item();
        item.setName("Elt4");
        item.setValue(10);
        item.setWeight(2);
        itemList.add(item);
        
        item = new Item();
        item.setName("Elt5");
        item.setValue(24);
        item.setWeight(8);
        itemList.add(item);
        
        item = new Item();
        item.setName("Elt6");
        item.setValue(10);
        item.setWeight(50);
        itemList.add(item);
        
        item = new Item();
        item.setName("Elt7");
        item.setValue(50);
        item.setWeight(25);
        itemList.add(item);
        
        item = new Item();
        item.setName("Elt8");
        item.setValue(6);
        item.setWeight(2);
        itemList.add(item);
        
        item = new Item();
        item.setName("Elt9");
        item.setValue(20);
        item.setWeight(8);
        itemList.add(item);
        
        item = new Item();
        item.setName("Elt10");
        item.setValue(24);
        item.setWeight(6);
        itemList.add(item);

        weightAndValue.setItems(itemList);
        weightAndValue.setAllowedWeight(40);
        return weightAndValue;
    }

    public static WeightAndValueResponse getWeightAndValueResponse() {
        WeightAndValueResponse weightAndValueResponse = new WeightAndValueResponse();
        weightAndValueResponse.setItemsToPack(Arrays.asList(6,8,2,8,2,3,10));
        weightAndValueResponse.setValue(Arrays.asList(24,20,6,24,10,6,30));
        weightAndValueResponse.setTotalWeight("39 kg");
        weightAndValueResponse.setTotalValue(120);
        return weightAndValueResponse;
    }
}
