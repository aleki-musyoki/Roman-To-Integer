package com.projects.roman.Tests;

import com.projects.roman.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void checkSingleDigit() {
        int result = Main.romanToInteger("V");
        Assertions.assertEquals(5, result);
    }

    @Test
    public void subtractiveNotation(){
        Assertions.assertEquals(4, Main.romanToInteger("IV"));
        Assertions.assertEquals(19, Main.romanToInteger("ixx"));
    }

    @Test
    public void manyLetters(){
        Assertions.assertEquals(28, Main.romanToInteger("XXVIII"));
    }

    @Test
    public void repetition() {
        int result = Main.romanToInteger("II");
        Assertions.	assertEquals(2, result);
    }

    @Test
    public void invalid(){
        Assertions.assertEquals(-1, Main.romanToInteger("ZP"));
        Assertions.assertEquals(-1, Main.romanToInteger("YO"));
        Assertions.assertEquals(-1, Main.romanToInteger("NN"));
    }

    @Test
    public void invalidThenValidLetter(){
        Assertions.assertEquals(-1, Main.romanToInteger("XVIP"));
        Assertions.assertEquals(-1, Main.romanToInteger("IXK"));
        Assertions.assertEquals(-1, Main.romanToInteger("LO"));
    }

    @Test
    public void notValidRoman(){
        Assertions.assertEquals(-1, Main.romanToInteger("VV"));
        Assertions.assertEquals(-1, Main.romanToInteger("LL"));
        Assertions.assertEquals(-1, Main.romanToInteger("DD"));
    }
}
