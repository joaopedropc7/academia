package com.academia.academia.controllers;

import com.academia.academia.models.DTOS.PlanDTO;
import com.academia.academia.models.PlanModel;
import com.academia.academia.service.PlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanController {

    @Autowired
    private PlanService service;

    @PostMapping
    @Operation(summary = "Adds a new Plan",
            description = "Adds a new Plan by passing in a JSON, XML or YML representation of the person!",
            tags = {"Plan"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PlanModel.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public PlanModel CriarPlano(@RequestBody PlanDTO planDTO){
        System.out.println(planDTO);
        PlanModel plano = service.cadastrarPlano(planDTO);
        System.out.println(plano);
        return plano;
    }

    @GetMapping
    @Operation(summary = "Finds all plans", description = "Finds all plans",
            tags = {"Plan"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation =PlanModel.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public List<PlanModel> buscarPlanos(){
        List<PlanModel> planos = service.buscarPlanos();
        return planos;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Finds a Plan", description = "Finds a Plan",
            tags = {"Plan"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PlanModel.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public PlanModel buscarPlanoPorId(@PathVariable(value = "id") Integer planoID){
        PlanModel plano = service.buscarPorId(planoID);
        return plano;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updates a Plan",
            description = "Updates a Plan by passing in a JSON, XML or YML representation of the person!",
            tags = {"Plan"},
            responses = {
                    @ApiResponse(description = "Updated", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PlanModel.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public PlanModel AtualizarPlano(@PathVariable(value = "id") Integer planoID, PlanDTO planDTO){
        PlanModel planModel = service.atualizarPlano(planDTO, planoID);
        return  planModel;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a Plan",
            description = "Deletes a Person by passing in a JSON, XML or YML representation of the Plan!",
            tags = {"Plan"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public void deletarPlano(@PathVariable(value = "id") Integer planoID){
        service.deletarPlano(planoID);
    }
}
