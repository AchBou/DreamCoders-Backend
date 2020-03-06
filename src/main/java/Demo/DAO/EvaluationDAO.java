package com.example.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Evaluation;

@Repository
public interface EvaluationDAO extends JpaRepository<Evaluation, Integer>{

}
