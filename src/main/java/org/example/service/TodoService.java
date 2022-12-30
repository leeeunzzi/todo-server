package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    // 추가
    public TodoEntity add(TodoRequest request) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());
        //TodoEntity entity = this.todoRepository.save(todoEntity);
        return this.todoRepository.save(todoEntity);
    }

    // 특정 아이템 조회
    public TodoEntity searchById(Long id) {
        return this.todoRepository.findById(id)
                // 값이 없을 경우 not found
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // 전체 목록 조회
    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }

    // 특정 아이템 수정
    public TodoEntity updateById(Long id, TodoRequest request) {
        TodoEntity todoEntity = this.searchById(id);
        if (request.getTitle() != null) todoEntity.setTitle(request.getTitle());
        if (request.getOrder() != null) todoEntity.setOrder(request.getOrder());
        if (request.getCompleted() != null) todoEntity.setCompleted(request.getCompleted());

        // update시 save
        return this.todoRepository.save(todoEntity);
    }

    // 특정 아이템 삭제
    public void deleteById(Long id) {
        this.todoRepository.deleteById(id);
    }

    // 전체 목록 삭제
    public void deleteAll() {
        this.todoRepository.deleteAll();
    }
}
