package com.amaap.troopsimulation.controller;

import com.amaap.troopsimulation.controller.dto.HttpStatus;
import com.amaap.troopsimulation.controller.dto.Response;

public class BarrackController {
    public Response train() {

        return new Response(HttpStatus.OK);
    }
}
