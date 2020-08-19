package com.example.AvtoShop;

import com.example.AvtoShop.Entity.Customer;
import com.example.AvtoShop.Entity.Reputation;
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
public class CustomersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCustomersTest() throws  Exception{
        this.mockMvc.perform(get("/customers"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getOneCustomerTest() throws  Exception{
        this.mockMvc.perform(get("/customers/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postCustomerTest() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerID(1L);
        customer.setCustomerName("Bryan");
        customer.setAddress("Bishkek");
        customer.setEmail("123@gmail.com");
        customer.setNumber("0123456789");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(customer);
        mockMvc.perform(post("/customers").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putCustomerTest() throws  Exception{
        Customer customer = new Customer();
        customer.setCustomerID(1L);
        customer.setReputationID(new Reputation(1L,"CoolMan"));
        customer.setCustomerName("Bryan");
        customer.setAddress("Bishkek");
        customer.setEmail("123@gmail.com");
        customer.setNumber("0123456789");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(customer);
        mockMvc.perform(put("/customers/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCustomerTest() throws  Exception{
        this.mockMvc.perform(delete("/customers/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
