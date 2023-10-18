package com.academia.academia.controllers;

import com.academia.academia.models.ClientModel;
import com.academia.academia.models.DTOS.ClieneAlterarPlano;
import com.academia.academia.models.DTOS.ClientDTO;
import com.academia.academia.models.DTOS.PlanDTO;
import com.academia.academia.models.PlanModel;
import com.academia.academia.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClientService service;

    @PostMapping
    @Operation(summary = "Adds a new client",
            description = "Adds a new Client by passing in a JSON, XML or YML representation of the client!",
            tags = {"Client"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ClientModel.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public ClientModel cadastrarCliente(@RequestBody ClientDTO clientDTO) throws ParseException {
        System.out.println("TESTEADAWDJWAIDAWJDJWAI");
        ClientModel clientModel = service.cadastrarCliente(clientDTO);
        return clientModel;
    }


    @GetMapping
    @Operation(summary = "Finds all clients", description = "Finds all clients",
            tags = {"Clients"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation =ClientModel.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public List<ClientModel> buscarClientes(){
        List<ClientModel> clientes = service.listarClientes();
        return clientes;
    }


    @GetMapping("/{id}")
    @Operation(summary = "Finds a client", description = "Finds a client",
            tags = {"Client"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ClientModel.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public ClientModel buscarClientePorId(@PathVariable(value = "id") Integer clienteID){
        ClientModel cliente = service.buscarClientePorID(clienteID);
        return cliente;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updates a Client",
            description = "Updates a Client by passing in a JSON, XML or YML representation of the client!",
            tags = {"Client"},
            responses = {
                    @ApiResponse(description = "Updated", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ClientModel.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public ClientModel atualizarCliente(@PathVariable(value = "id") Integer clienteID, ClientDTO clientDTO) throws ParseException {
        ClientModel clientModel = service.atualizarCliente(clienteID, clientDTO);
        return  clientModel;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a Client",
            description = "Deletes a Client by passing in a JSON, XML or YML representation of the Client!",
            tags = {"Client"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public void deletarPlano(@PathVariable(value = "id") Integer clienteID){
        service.deletarCliente(clienteID);
    }

    @PutMapping("/alterarPlano")
    public void alterarPlano(ClieneAlterarPlano clieneAlterarPlano){
        service.alterarPlano(clieneAlterarPlano);
    }

}
