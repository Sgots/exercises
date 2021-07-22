package com.example.letshegoexercise1.controller;

import com.example.letshegoexercise1.model.Account;
import com.example.letshegoexercise1.model.Basket;
import com.example.letshegoexercise1.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
@WithMockUser
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private Basket basket2;
    @Mock
    private Account account1;
    @Autowired
UserService userService;

    Boolean include = false;
    Double bill = 120.4;
    Double reduction = null;

    String exampleBasketJson = "{"+"\""+"includeGrocery"+"\"" +" : "+ include +", " +"\""+"bill"+"\"" + " : " +bill+", " +"\""+"account"+"\" : "+"{"+"\""+"accountId"+"\""+ " : " +1+"}}";

    @Test
    void bill() throws Exception {
        Account account = new Account(1, LocalDate.now(), "Employee");
         account1 = new Account();
         account1.setAccountId(1);
        Basket basket = new Basket(2,bill, false, account);
        Basket mockBasket = new Basket(2, 130.4, Boolean.FALSE,account);


Basket basket1 = new Basket();
basket1.setBill(bill);
basket1.setAccount(account1);
basket1.setIncludeGrocery(include);
        // Send basket as body to /bill
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:8080/bill")
                .accept(MediaType.APPLICATION_JSON).content(exampleBasketJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

         basket2 = userService.basket(basket1);

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        System.out.println("basket"+basket);

        System.out.println("basket"+basket2);
      //  assertEquals(new Double(bill - new Double((reduction * 30) / 100)), basket2);




    }
}