package com.example.springplayground.services;

import com.example.springplayground.service.MathUtil;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilShould {
    @Test
    void squareReturnsTheSquareOfAPositiveNumber(){
        MathUtil util = new MathUtil(); //arrange
        int sq=util.square(8); //act
       assertEquals(640,sq); //Assert

    }
}
