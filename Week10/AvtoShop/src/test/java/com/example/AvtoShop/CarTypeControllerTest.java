package com.example.AvtoShop;

import com.example.AvtoShop.Entity.CarType;
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
public class CarTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCarTypeTest() throws  Exception{
        this.mockMvc.perform(get("/car-type"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getOneCarTypeTest() throws  Exception{
        this.mockMvc.perform(get("/car-type/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postCarTypeTest() throws Exception {
        CarType carType = new CarType();
        carType.setTypeID(1L);
        carType.setCarType("Coupe");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(carType);
        mockMvc.perform(post("/car-type").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putCarTypeTest() throws  Exception{
        CarType carType = new CarType();
        carType.setCarType("Coupe");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(carType);
        mockMvc.perform(put("/car-type/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCarTypeTest() throws  Exception{
        this.mockMvc.perform(delete("/car-type/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
