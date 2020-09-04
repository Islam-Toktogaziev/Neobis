package com.example.AvtoShop;

import com.example.AvtoShop.Entity.Region;
import com.example.AvtoShop.Entity.Shipping;
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
public class ShippingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getShippingTest() throws  Exception{
        this.mockMvc.perform(get("/shipping"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getOneShippingTest() throws  Exception{
        this.mockMvc.perform(get("/shipping/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postShippingTest() throws Exception {
        Shipping shipping = new Shipping();
        shipping.setShippingID(1L);
        shipping.setShippingType("Dostavka");
        shipping.setRegion(new Region(1L,"Bishkek"));
        shipping.setShippingCost(2550);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(shipping);
        mockMvc.perform(post("/shipping").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putShippingTest() throws  Exception{
        Shipping shipping = new Shipping();
        shipping.setShippingType("Dostavka");
        shipping.setRegion(new Region(1L,"Bishkek"));
        shipping.setShippingCost(2550);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(shipping);
        mockMvc.perform(put("/shipping/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteShippingTest() throws  Exception{
        this.mockMvc.perform(delete("/shipping/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
