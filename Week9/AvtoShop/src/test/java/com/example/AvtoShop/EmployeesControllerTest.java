package com.example.AvtoShop;

import com.example.AvtoShop.Entity.Employee;
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
public class EmployeesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getEmployeesTest() throws  Exception{
        this.mockMvc.perform(get("/employees"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getOneEmployeeTest() throws  Exception{
        this.mockMvc.perform(get("/employees/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postEmployeeTest() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeID(1L);
        employee.setEmployeeName("Bryan");
        employee.setAddress("Bishkek");
        employee.setEmail("123@gmail.com");
        employee.setNumber("0123456789");
        employee.setPositionID(new Position(1L,"Manager"));
        employee.setSalary(25550);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(employee);
        mockMvc.perform(post("/employees").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putEmployeeTest() throws  Exception{
        Employee employee = new Employee();
        employee.setEmployeeID(1L);
        employee.setEmployeeName("Bryan");
        employee.setAddress("Bishkek");
        employee.setEmail("123@gmail.com");
        employee.setNumber("0123456789");
        employee.setPositionID(new Position(1L,"Manager"));
        employee.setSalary(25550);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(employee);
        mockMvc.perform(put("/employees/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteEmployeeTest() throws  Exception{
        this.mockMvc.perform(delete("/employees/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
