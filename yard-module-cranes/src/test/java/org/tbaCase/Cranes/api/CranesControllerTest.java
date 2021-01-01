package org.tbaCase.Cranes.api;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.tbaCase.Cranes.service.CranesService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(CranesController.class)
class CranesControllerTest {

    private static final long craneId = 1L;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CranesService cranesService;

    @Test
    public void getCranesTest() throws Exception {
        mvc.perform(get("/api/v1/1")
                .contentType(MediaType.APPLICATION_JSON));
        verify(cranesService, times(1)).findById(craneId);
    }

    @Test
    private void moveLeft() throws Exception {
        mvc.perform(get("/api/v1/{id}/moveLeft", craneId)//
                .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    private void moveRight() throws Exception{
        mvc.perform(get("/api/v1/{id}/moveRight", craneId)//
                .contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    public void testMoveCraneToRight() throws Exception {
        moveCranes(2);
    }

    @Test
    public void testMoveCraneToLeft() throws Exception {
        moveCranes(-5);
    }

    private void moveCranes(int x) throws Exception {

        for (int i = 0; i > x; i--) { moveLeft(); }
        for (int i = 0; i < x; i++) { moveRight(); }

        verify(cranesService, times(x < 0 ? -x : 0)).moveLeft(1L);
        verify(cranesService, times(x > 0 ? x : 0)).moveRight(1L);

        verifyNoMoreInteractions(cranesService);
    }


}