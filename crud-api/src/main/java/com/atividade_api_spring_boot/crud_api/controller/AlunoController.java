package com.atividade_api_spring_boot.crud_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade_api_spring_boot.crud_api.model.Aluno;
import com.atividade_api_spring_boot.crud_api.service.AlunoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/alunos")
public class AlunoController {
    @Autowired
    AlunoService alunoService;

     public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/{id}")
    public Aluno listarAlunos(@PathVariable Long id) {
        return alunoService.burcarAlunoPorId(id);

    }

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoService.listarAlunos();
    }
    

    @PostMapping
    public Aluno cadastarAluno(@RequestBody Aluno aluno) {
        return alunoService.cadastrarAluno(aluno);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long  id){
        alunoService.deletarAluno(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoService.altualizarAluno(id, aluno);
    }
    
    

}
