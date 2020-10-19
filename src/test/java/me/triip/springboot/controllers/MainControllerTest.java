package me.triip.springboot.controllers;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

class MainControllerTest {

    private MainController mainController = new MainController();

    @Test
    void testMainControllerIndex() {
        // setup
        Model model = new BindingAwareModelMap();

        // when
        String index = mainController.index(model);

        // then
        assertEquals("index", index, "Index function should return `index` String");
        assertEquals("Highest prime lower than input number", model.getAttribute("eventName"), "Event name should be `Highest prime lower than input number`");
    }
}