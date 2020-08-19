package com.example.AvtoShop;

import com.example.AvtoShop.Entity.PriceList;
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
public class PriceListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPriceListTest() throws  Exception{
        this.mockMvc.perform(get("/price"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getOnePriceTest() throws  Exception{
        this.mockMvc.perform(get("/price/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postPriceTest() throws Exception {
        PriceList price = new PriceList();
        price.setPriceID(1L);
        price.setPrice(2500);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(price);
        mockMvc.perform(post("/price").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putPriceTest() throws  Exception{
        PriceList price = new PriceList();
        price.setPrice(2500);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(price);
        mockMvc.perform(put("/price/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deletePriceTest() throws  Exception{
        this.mockMvc.perform(delete("/price/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
