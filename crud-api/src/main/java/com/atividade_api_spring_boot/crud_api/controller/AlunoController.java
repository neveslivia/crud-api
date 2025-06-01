package com.atividade_api_spring_boot.crud_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade_api_spring_boot.crud_api.model.Aluno;
import com.atividade_api_spring_boot.crud_api.service.AlunoService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;




@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("api/alunos")
public class AlunoController {
    @Autowired
    AlunoService alunoService;

     public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
    
    @Operation(
        summary = "Buscar aluno por ID",
        description = "Retorna os dados de um aluno específico com base no ID fornecido."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Aluno encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })

    @GetMapping("/{id}")
    public Aluno listarAlunos(@PathVariable Long id) {
        return alunoService.buscarAlunoPorId(id);

    }
    @Operation(
        summary = "Busca todos os alunos cadastrados",
        description = "Retorna os dados de todos os alunos."
    )

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoService.listarAlunos();
    }
    

    @PostMapping
    public Aluno cadastarAluno(@RequestBody Aluno aluno) {
        return alunoService.cadastrarAluno(aluno);
        
    }
    @Operation(
        summary = "Deletar aluno por ID",
        description = "Deleta os dados do aluno de acordo com o ID fornecido"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Aluno deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long  id){
        alunoService.deletarAluno(id);
    }

    @Operation(
        summary = "Atualiza  ID",
        description = "Atualiza os dados de um aluno específico com base no ID fornecido."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Aluno atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoService.altualizarAluno(id, aluno);
    }
    
    

}
