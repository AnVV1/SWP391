package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.payload.request.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityControllerTest_AuthenticateUser {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Test username + passwword null
    @Test
    private void authenticateUser_1() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(null);
        loginRequest.setPassword(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    // Test username + passwword rỗng
    @Test
    private void authenticateUser_2() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("");
        loginRequest.setPassword("");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    // Test username + passwword nhập đúng
    @Test
    private void authenticateUser_3() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
    // Test passwword nhập sai (khong tồn tại trong db)
    @Test
    private void authenticateUser_4() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("456");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    // Test username nhập sai (khong tồn tại trong db)
    @Test
    private void authenticateUser_5() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("abcdefgh");
        loginRequest.setPassword("456");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    // Test username + passwword nhập sai (khong tồn tại trong db)
    @Test
    private void authenticateUser_6() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("abcdefgh");
        loginRequest.setPassword("1584699");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
}

