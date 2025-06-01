package com.atividade_api_spring_boot.crud_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade_api_spring_boot.crud_api.Repository.AlunoRepository;
import com.atividade_api_spring_boot.crud_api.model.Aluno;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno cadastrarAluno(Aluno aluno){
         return alunoRepository.save(aluno);
    }

    public Aluno buscarAlunoPorId(Long id){
        return alunoRepository.findById(id).orElse(null);
    }
    public List<Aluno> listarAlunos(){
        return alunoRepository.findAll();
    }
    public void deletarAluno(Long id){
        alunoRepository.deleteById(id);
    }
    public Aluno altualizarAluno(Long id,Aluno alunoAtualizado){
      Aluno alunoExistente = buscarAlunoPorId(id);
    if (alunoExistente != null) {
        alunoExistente.setNome(alunoAtualizado.getNome());
        alunoExistente.setEmail(alunoAtualizado.getEmail());
        return alunoRepository.save(alunoExistente);
    }
    return null;
    }



}
