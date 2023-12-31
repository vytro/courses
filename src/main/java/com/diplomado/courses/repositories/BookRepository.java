package com.diplomado.courses.repositories;

import com.diplomado.courses.domain.entities.Book;
import com.diplomado.courses.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
