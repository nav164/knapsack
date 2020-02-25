package com.assingment.service;

import com.assingment.TestData;
import io.swagger.model.Item;
import io.swagger.model.WeightAndValue;
import io.swagger.model.WeightAndValueResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OptimizeWeightAndValueServiceImplTest {

    private OptimizeWeightAndValueService optimizeWeightAndValueService = new OptimizeWeightAndValueServiceImpl();

    @Test
    public void getMaxValueAndWeightListTest() throws Exception{
        WeightAndValueResponse weightAndValueResponse = optimizeWeightAndValueService.getMaxValueAndWeightList(TestData.getWeightValueRequestData());
        assertNotNull("Optimum weight and value response list is not null", weightAndValueResponse);
        assertEquals("Item to pack list size", 7, weightAndValueResponse.getItemsToPack().size());
        assertEquals("Value of items list size", 7, weightAndValueResponse.getValue().size());
        assertEquals("Total value", 120,  weightAndValueResponse.getTotalValue().intValue());
        assertEquals("Total weight", "39 kg",  weightAndValueResponse.getTotalWeight());
    }
    
    @Test
    public void getMaxValueAndWeightListTest2() throws Exception{
    	WeightAndValue weightAndValue = new WeightAndValue();
        List<Item> itemList = new ArrayList<>();
        Item item = new Item();
        item.setName("Elt1");
        item.setValue(60);
        item.setWeight(10);
        itemList.add(item);

        item = new Item();
        item.setName("Elt2");
        item.setValue(100);
        item.setWeight(20);
        itemList.add(item);
        
        item = new Item();
        item.setName("Elt3");
        item.setValue(120);
        item.setWeight(30);
        itemList.add(item);
        weightAndValue.setItems(itemList);
        weightAndValue.setAllowedWeight(50);
        
        WeightAndValueResponse weightAndValueResponse = optimizeWeightAndValueService.getMaxValueAndWeightList(weightAndValue);
        assertNotNull("Optimum weight and value response list is not null", weightAndValueResponse);
        assertEquals("Item to pack list size", 2, weightAndValueResponse.getItemsToPack().size());
        assertEquals("Value of items list size", 2, weightAndValueResponse.getValue().size());
        assertEquals("Total value", 220,  weightAndValueResponse.getTotalValue().intValue());
        assertEquals("Total weight", "50 kg",  weightAndValueResponse.getTotalWeight());
    }
}
