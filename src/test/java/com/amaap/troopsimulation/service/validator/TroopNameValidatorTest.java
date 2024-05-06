package com.amaap.troopsimulation.service.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TroopNameValidatorTest {

    @Test
    public void ShouldBeAbleToTestValidTroopType() {
        assertTrue(TroopNameValidator.isTroopTypeValid("Barbarian"));
    }

    @Test
    public void shouldBeAbleToTestValidTroopTypeIgnoreCase() {
        assertTrue(TroopNameValidator.isTroopTypeValid("aRcHer"));
    }

    @Test
    public void shouldBeAbleToTestInvalidTroopType() {
        assertFalse(TroopNameValidator.isTroopTypeValid("Knight"));
    }



    @Test
    public void shouldBeAbleToTestValidTroopTypeWithSpaces() {
        assertFalse(TroopNameValidator.isTroopTypeValid("Elite Barbarian"));
    }

    @Test
    public void shouldBeAbleTotestValidTroopTypeWithSpecialCharacters() {
        assertFalse(TroopNameValidator.isTroopTypeValid("Goblin+"));
    }

}