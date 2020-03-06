package com.example.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Question;

@Repository
public interface QuestionDAO  extends JpaRepository<Question, Integer> {


}
