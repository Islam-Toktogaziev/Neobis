package com.example.AvtoShop;

import com.example.AvtoShop.Entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("admin")
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getOrdersTest() throws  Exception{
        this.mockMvc.perform(get("/orders"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getOrdersByCustomerTest() throws  Exception{
        this.mockMvc.perform(get("/customers/1/orders"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getOneOrderByCustomerTest() throws  Exception{
        this.mockMvc.perform(get("/customers/1/orders/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postOrderByCustomerTest() throws Exception {
        Orders orders = new Orders();
        orders.setOrderID(1L);
        orders.setCustomerID(new Customer(1L,"Bryan",new Reputation(),"qwe","qwe","qwe"));
        orders.setShippingID(new Shipping(1L,"Dostavka",2500,new Region()));
        orders.setStatus("Ready");
        orders.setCarID(new Car(1L,"Camry",new Brand(), new CarType(), new PriceList(), "Green",2500));
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(orders);
        mockMvc.perform(post("/customers/1/orders").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putOrderTest() throws  Exception{
        Orders orders = new Orders();
        orders.setCustomerID(new Customer(1L,"Bryan",new Reputation(),"qwe","qwe","qwe"));
        orders.setShippingID(new Shipping(1L,"Dostavka",2500,new Region()));
        orders.setStatus("Ready");
        orders.setCarID(new Car(1L,"Camry",new Brand(), new CarType(), new PriceList(), "Green",2500));
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(orders);
        mockMvc.perform(put("/customers/1/orders/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteOrderTest() throws  Exception{
        this.mockMvc.perform(delete("/customers/1/orders/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
