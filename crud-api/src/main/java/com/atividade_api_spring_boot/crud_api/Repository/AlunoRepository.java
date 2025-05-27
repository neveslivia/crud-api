package com.atividade_api_spring_boot.crud_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade_api_spring_boot.crud_api.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {

}
