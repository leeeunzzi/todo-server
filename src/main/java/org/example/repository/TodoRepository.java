package org.example.repository;

import org.example.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TodoEntity를 위한 repository
// 테이블 객체를 가지고 있는 TodoEntity
// 테이블 객체의 id의 type
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}
