package com.example.SpringEsercizio4;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1")
public class NameController {
    @Operation(
            summary = "Retrieve the name by Request paramter",
            description = "Get a name by specifying its parameter. The response is a String with the name itself.",
            tags = { "nameController", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returns the name in the parameter",content = { @Content(schema = @Schema(implementation = NameController.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Malformed name parameter", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "Name not found or wrong mapping", content = { @Content(schema = @Schema()) }) })
    @GetMapping(path = "/getname")
    public String getName(String name) {
        return name;
    }
    @Operation(
            summary = "Retrieve the name by Request paramter",
            description = "Deliver a name backwards. The response is a String with the name backwards itself.",
            tags = { "nameController", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returns the name in the parameter",content = { @Content(schema = @Schema(implementation = NameController.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Malformed name parameter", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "Name not found or wrong mapping", content = { @Content(schema = @Schema()) }) })
    @PostMapping(path = "/reversedname")
    public StringBuilder reverseName(@RequestParam String name) {
        StringBuilder prova = new StringBuilder(name);
        return prova.reverse();
    }
}

