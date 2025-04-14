package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {


    @Autowired
    private MockMvc mockMvc;

    @Test
    //@WithMockUser(username = "user", roles = {"USER"})
    void testPublicEndpoint() throws Exception {
        mockMvc.perform(get("/api/public"))
                .andExpect(status().isOk())
              .andExpect(content().string("This is a public API. No authentication required here."));
    }

    @Test
    void testSecureEndpointUnauthorized() throws Exception {
        mockMvc.perform(get("/api/secure"))
                .andExpect(status().isUnauthorized());
                //.andExpect(content().string("This is a secure API. Authentication required here."));
    }
    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    void testSecureEndpointnauthorized() throws Exception {
        mockMvc.perform(get("/api/secure"))
                .andExpect(status().isOk())
                .andExpect(content().string("This is a secure API. Authentication required here."));
    }

}
