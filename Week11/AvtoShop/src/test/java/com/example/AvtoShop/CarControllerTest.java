package com.example.AvtoShop;

import com.example.AvtoShop.Entity.Brand;
import com.example.AvtoShop.Entity.Car;
import com.example.AvtoShop.Entity.CarType;
import com.example.AvtoShop.Entity.PriceList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCarsTest() throws  Exception{
        this.mockMvc.perform(get("/cars"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getOneCarTest() throws  Exception{
        this.mockMvc.perform(get("/cars/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postCarsTest() throws Exception {
        Car car = new Car();
        car.setCarID(1L);
        car.setPriceID(new PriceList(1L,2500));
        car.setBrand(new Brand(1L,"Toyata"));
        car.setCarName("Camry");
        car.setCarType(new CarType(1L,"Sedan"));
        car.setColor("White");
        car.setEngineDisplacement(2.5);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(car);
        mockMvc.perform(post("/cars").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putCarsTest() throws  Exception{
        Car car = new Car();
        car.setCarID(2L);
        car.setPriceID(new PriceList(1L,2500));
        car.setBrand(new Brand(1L,"Toyata"));
        car.setCarName("Camry");
        car.setCarType(new CarType(1L,"Sedan"));
        car.setColor("White");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(car);
        mockMvc.perform(put("/cars/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCarsTest() throws  Exception{

        this.mockMvc.perform(delete("/cars/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
