package com.amaap.troopsimulation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TroopControllerTest {

     TroopController troopController=new TroopController();

    @Test
    void shouldBeAbleToCreateTroopAndGetOKResponse()  {
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";

        Response expected = new Response(HttpStatus.OK);

        // act
        Response actual = troopController.createTroop(troopCount, troopType);

        // assert
        assertEquals(expected, actual);
    }



}
