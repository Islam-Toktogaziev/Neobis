package com.example.AvtoShop;

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
public class ReputationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getReputationTest() throws  Exception{
        this.mockMvc.perform(get("/reputation"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getOneReputationTest() throws  Exception{
        this.mockMvc.perform(get("/reputation/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postReputationTest() throws Exception {
        Reputation reputation = new Reputation();
        reputation.setReputationID(1L);
        reputation.setReputation("GoodShopper");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(reputation);
        mockMvc.perform(post("/reputation").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putReputationTest() throws  Exception{
        Reputation reputation = new Reputation();
        reputation.setReputation("GoodShopper");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(reputation);
        mockMvc.perform(put("/reputation/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteReputationTest() throws  Exception{
        this.mockMvc.perform(delete("/reputation/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
