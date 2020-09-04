package com.example.AvtoShop;

import com.example.AvtoShop.Entity.Position;
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
public class PositionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPositionTest() throws  Exception{
        this.mockMvc.perform(get("/position"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getOnePositionTest() throws  Exception{
        this.mockMvc.perform(get("/position/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postPositionTest() throws Exception {
        Position position = new Position();
        position.setPositionID(1L);
        position.setPosition("TeamLead");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(position);
        mockMvc.perform(post("/position").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putPositionTest() throws  Exception{
        Position position = new Position();
        position.setPosition("TeamLead");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(position);
        mockMvc.perform(put("/position/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deletePositionTest() throws  Exception{
        this.mockMvc.perform(delete("/position/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
