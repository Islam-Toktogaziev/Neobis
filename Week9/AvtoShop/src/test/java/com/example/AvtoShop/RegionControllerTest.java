package com.example.AvtoShop;

import com.example.AvtoShop.Entity.Region;
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
public class RegionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRegionTest() throws  Exception{
        this.mockMvc.perform(get("/region"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getOneRegionTest() throws  Exception{
        this.mockMvc.perform(get("/region/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postRegionTest() throws Exception {
        Region region = new Region();
        region.setRegionID(1L);
        region.setRegion("Bishkek");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(region);
        mockMvc.perform(post("/region").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putRegionTest() throws  Exception{
        Region region = new Region();
        region.setRegion("Bishkek");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(region);
        mockMvc.perform(put("/region/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteRegionTest() throws  Exception{
        this.mockMvc.perform(delete("/region/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
