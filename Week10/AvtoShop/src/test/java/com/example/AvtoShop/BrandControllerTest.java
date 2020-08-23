package com.example.AvtoShop;

import com.example.AvtoShop.Entity.Brand;
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
public class BrandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getBrandTest() throws  Exception{
        this.mockMvc.perform(get("/brand"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getOneBrandTest() throws  Exception{
        this.mockMvc.perform(get("/brand/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postBrandTest() throws Exception {
        Brand anBrand = new Brand();
        anBrand.setBrandID(1L);
        anBrand.setBrand("Toyota");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(anBrand);
        mockMvc.perform(post("/brand").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putBrandTest() throws  Exception{
        Brand anBrand = new Brand();
        anBrand.setBrand("Toyota");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(anBrand);
        mockMvc.perform(put("/brand/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteBrandTest() throws  Exception{
        this.mockMvc.perform(delete("/brand/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
