package com.diplomado.courses.repositories;

import com.diplomado.courses.domain.entities.StudentIdCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentIdCardRepository extends JpaRepository<StudentIdCard, Long>{
}
