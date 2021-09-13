package com.test.exchangerates.controller;

import com.test.exchangerates.service.GifDownloadService;
import com.test.exchangerates.service.GifOnRateService;
import com.test.exchangerates.service.GifService;
import com.test.exchangerates.service.RateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RateService rateService;

    @MockBean
    private GifService gifService;

    @MockBean
    private GifDownloadService gifDownloadService;

    @MockBean
    private GifOnRateService gifOnRateService;

    @Test
    @DisplayName("checking response")
    public void getResponse() throws Exception {

        mockMvc.perform(get("/api/"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("getting GIF")
    public void getGif() throws Exception {

        mockMvc.perform(get("/api/gif?symbols=RUB")
                .contentType(MediaType.IMAGE_GIF))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().contentType(MediaType.IMAGE_GIF));
    }

}
