package com.assignment.controller;

import com.assignment.testData.TestData;
import com.assignment.service.OptimizeWeightAndValueService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.WeightAndValue;
import io.swagger.model.WeightAndValueResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = OptimizeWeightAndValue.class)
@ContextConfiguration(classes = { OptimizeWeightAndValue.class })
public class OptimizeWeightAndValueTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OptimizeWeightAndValueService optimizeWeightAndValueService;

    private ObjectMapper objectmapper = new ObjectMapper();

    @Test
    public void getOptimumWeightAndValueTest() throws Exception {
        WeightAndValue weightAndValue = TestData.getWeightValueRequestData();
        String weightAndValueJson = objectmapper.writeValueAsString(weightAndValue);

        when(optimizeWeightAndValueService.getMaxValueAndWeightList(weightAndValue)).thenReturn(TestData.getWeightAndValueResponse());

        MvcResult result = mockMvc.perform(post("/solve").contentType(MediaType.APPLICATION_JSON).content(weightAndValueJson)).andReturn();
        assertEquals("OK", 200, result.getResponse().getStatus());
        String response = result.getResponse().getContentAsString();
        WeightAndValueResponse responseObjectFromJson = objectmapper.readValue(response, WeightAndValueResponse.class);
        assertEquals("Json Response values match", responseObjectFromJson, TestData.getWeightAndValueResponse());
        verify(optimizeWeightAndValueService, times(1)).getMaxValueAndWeightList(weightAndValue);
        verifyNoMoreInteractions(optimizeWeightAndValueService);
    }
}
