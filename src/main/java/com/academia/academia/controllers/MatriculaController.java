package com.academia.academia.controllers;

import com.academia.academia.models.ClientModel;
import com.academia.academia.models.DTOS.RealizarMatriculaDTO;
import com.academia.academia.models.MatriculaModel;
import com.academia.academia.models.PlanModel;
import com.academia.academia.service.MatriculaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    @Operation(summary = "Matricular cliente",
            description = "Adds a new matricula by passing in a JSON, XML or YML representation of the client!",
            tags = {"Matricula"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = MatriculaModel.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public MatriculaModel matricularCliente(@RequestBody RealizarMatriculaDTO dto){
        System.out.println("DJWAODWAOJDOJDAJDJOWA");
        MatriculaModel matriculaModel = matriculaService.matricularCliente(dto);
        return matriculaModel;
    }

    @PostMapping("/desmatricular")
    @Operation(summary = "Desmatricular cliente",
            description = "Desmatricula by passing in a JSON, XML or YML representation of the client!",
            tags = {"Matricula"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = MatriculaModel.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public void desmatricularCliente(Integer idCliente){
        matriculaService.desmtricularCliente(idCliente);
    }

    @GetMapping
    @Operation(summary = "Finds all matriculas", description = "Finds all matriculas",
            tags = {"Matricula"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = MatriculaModel.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public List<MatriculaModel> listarMatriculas(){
        return matriculaService.listarMatriculas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Finds a matricula", description = "Finds a matricula",
            tags = {"Matricula"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = MatriculaModel.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public MatriculaModel buscarMatriculaPorId(Integer id){
        return matriculaService.buscarMatriculaPorId(id);
    }

}
