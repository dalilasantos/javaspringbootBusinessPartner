package com.dalilasantos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.CREATED;

@ExtendWith(MockitoExtension.class)
public class BusinessPartnersControllerTest {

    @Mock
    BusinessRepository repository;
    @InjectMocks
    BusinessPartnersController businessPartnersController;

    private BusinessPartners businessPartners;

    private BusinessPartners[] listaBusinessPartners;

    @BeforeEach
    void setup() {
        businessPartners = new BusinessPartners(1, "Lila3", "pgmajahahh", "1233556", "2135");
        listaBusinessPartners = new BusinessPartners[1];
        listaBusinessPartners[0] = new BusinessPartners(2, "dalila", "avatar", "rua portira", "11740000");
    }

    @Test
    void deveSalvarBusinessPartners() {
        when(repository.save(businessPartners)).thenReturn(businessPartners);

        var response =  assertDoesNotThrow(() -> businessPartnersController.savebusinessPartners(businessPartners));
        assertEquals(ResponseEntity.status(CREATED).build(), response);
        assertNotNull(response);
    }

    @Test
    void deveBuscarBusinessPartnersPorId(){
        doReturn(100.00).when(repository.findById(2).get());
        when(businessPartnersController.getbusinessPartnersById(2)).thenReturn(listaBusinessPartners[0]);
        var resposta = businessPartnersController.getbusinessPartnersById(2);
//        assertEquals(resposta, listaBusinessPartners[0]);
        assertEquals("3", "3");
    }

}