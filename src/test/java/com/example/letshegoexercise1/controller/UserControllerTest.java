package com.example.letshegoexercise1.controller;

import com.example.letshegoexercise1.model.Account;
import com.example.letshegoexercise1.model.Basket;
import com.example.letshegoexercise1.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
@WithMockUser
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    Boolean include = false;
    String exampleBasketJson = "{"+"\""+"includeGrocery"+"\"" +" : "+ include +", " +"\""+"bill"+"\"" + " : " +120.4+", " +"\""+"account"+"\" : "+"{"+"\""+"accountId"+"\""+ " : " +1+"}}";

    @Test
    void bill() throws Exception {
        Account account = new Account(1, LocalDate.now(), "Employee");
        Basket basket = new Basket(2,130.5, false, account);
        Basket mockBasket = new Basket(2, 130.4, Boolean.FALSE,account);



        // Send basket as body to /bill
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/bill")
                .accept(MediaType.APPLICATION_JSON).content(exampleBasketJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

    }
}