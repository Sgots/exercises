package com.example.letshegoexercise1;

import com.example.letshegoexercise1.controller.UserController;
import com.example.letshegoexercise1.model.Account;
import com.example.letshegoexercise1.model.Basket;
import com.example.letshegoexercise1.repository.UserRepository;
import com.example.letshegoexercise1.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
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

@SpringBootTest
class LetshegoExercise1ApplicationTests {

    @Mock
    private Basket basket2;
    @Mock
    private Account account1;
    @Autowired
    UserService userService;
@Autowired
        UserRepository userRepository;
    Boolean include = false;
    Double bill = 120.4;

    String exampleBasketJson = "{"+"\""+"includeGrocery"+"\"" +" : "+ include +", " +"\""+"bill"+"\"" + " : " +bill+", " +"\""+"account"+"\" : "+"{"+"\""+"accountId"+"\""+ " : " +1+"}}";
    @Test
    void contextLoads() {
    }
    @Test
    void employeeBill() throws Exception {
        account1 = new Account();
        account1.setAccountId(1);

        Basket basket1 = new Basket();
        basket1.setBill(bill);
        basket1.setAccount(account1);
        basket1.setIncludeGrocery(include);

        basket2 = userService.basket(basket1);

        Double reduction = bill * 0.3;
        Double net = bill - reduction;

        assertEquals(net, basket2.getNet_payable());
        System.out.println("Expected Bil  "+net);

        System.out.println("Received Bill "+basket2.getNet_payable());



    }
    @Test
    void affiliateBill() throws Exception {
        account1 = new Account();
        account1.setAccountId(3);

        Basket basket1 = new Basket();
        basket1.setBill(bill);
        basket1.setAccount(account1);
        basket1.setIncludeGrocery(include);

        basket2 = userService.basket(basket1);

        Double reduction = bill * 0.1;
        Double net = bill - reduction;

        assertEquals(net, basket2.getNet_payable());
        System.out.println("Expected Bil  "+net);

        System.out.println("Received Bill "+basket2.getNet_payable());



    }
    @Test
    void customerBill() throws Exception {
        account1 = new Account();
        account1.setAccountId(2);

        Basket basket1 = new Basket();
        basket1.setBill(bill);
        basket1.setAccount(account1);
        basket1.setIncludeGrocery(include);

        basket2 = userService.basket(basket1);

        Double reduction = bill * 0.3;
        Double net = bill - reduction;

        assertEquals(net, basket2.getNet_payable());
        System.out.println("Expected Bil  "+net);

        System.out.println("Received Bill "+basket2.getNet_payable());



    }

}
