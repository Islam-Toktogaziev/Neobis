package com.example.AvtoShop;

import com.example.AvtoShop.Entity.*;
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
public class ContractControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getContractsTest() throws  Exception{
        this.mockMvc.perform(get("/contracts"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getOneContractTest() throws  Exception{
        this.mockMvc.perform(get("/contracts/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getContractsByCustomerTest() throws  Exception{
        this.mockMvc.perform(get("/customers/1/contracts"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getOneContractByCustomerTest() throws  Exception{
        this.mockMvc.perform(get("/customers/1/contracts/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getContractsByEmployeeTest() throws  Exception{
        this.mockMvc.perform(get("/employees/1/contracts"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getOneContractByEmployeeTest() throws  Exception{
        this.mockMvc.perform(get("/employees/1/contracts/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postContractTest() throws Exception {
        Contracts contracts = new Contracts();
        contracts.setContractID(2L);
        contracts.setEmployeeID(employee());
        contracts.setPriceID(new PriceList(1L, 2555));
        contracts.setCarID(car());
        contracts.setOrderID(orders());
        contracts.setCustomerID(customer());
        contracts.setShippingID(shipping());
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(contracts);
        mockMvc.perform(post("/customers/1/contracts").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    private Car car(){
        Car car = new Car();
        car.setCarID(1L);
        car.setPriceID(new PriceList(1L,2500));
        car.setBrand(new Brand(1L,"Toyata"));
        car.setCarName("Camry");
        car.setCarType(new CarType(1L,"Sedan"));
        car.setColor("White");
        car.setEngineDisplacement(2.5);
        return car;
    }

    private Employee employee(){
        Employee employee = new Employee();
        employee.setEmployeeID(1L);
        employee.setEmployeeName("Bryan");
        employee.setAddress("Bishkek");
        employee.setEmail("123@gmail.com");
        employee.setNumber("0123456789");
        employee.setPositionID(new Position(1L,"Manager"));
        employee.setSalary(25550);
        return employee;
    }

    private Customer customer(){
        Customer customer = new Customer();
        customer.setCustomerID(1L);
        customer.setCustomerName("Bryan");
        customer.setAddress("Bishkek");
        customer.setEmail("123@gmail.com");
        customer.setNumber("0123456789");
        return customer;
    }

    private Orders orders(){
        Orders orders = new Orders();
        orders.setOrderID(1L);
        orders.setCustomerID(new Customer(1L,"Bryan",new Reputation(),"qwe","qwe","qwe"));
        orders.setShippingID(new Shipping(1L,"Dostavka",2500,new Region()));
        orders.setStatus("Ready");
        orders.setCarID(new Car(1L,"Camry",new Brand(), new CarType(), new PriceList(), "Green",2500));
        return orders;
    }

    private Shipping shipping(){
        Shipping shipping = new Shipping();
        shipping.setShippingID(1L);
        shipping.setShippingType("Dostavka");
        shipping.setRegion(new Region(1L,"Bishkek"));
        shipping.setShippingCost(2550);
        return shipping;
    }
}
