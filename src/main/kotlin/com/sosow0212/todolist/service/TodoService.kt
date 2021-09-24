package com.sosow0212.todolist.service

import com.sosow0212.todolist.repository.Todo
import com.sosow0212.todolist.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TodoService(
    private val todoRepository: TodoRepository
) {
    fun getTodos() = todoRepository.findAll() // fun은 함수이다.

    fun insertTodo(todoName: String) : Todo = todoRepository.save(Todo(todoName = todoName))

    fun updateTodo(todoId: Long): Todo { // Todo는 반환값
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw Exception() // 있으면 반환, 없으면 null
        todo.completed = !todo.completed
        return todoRepository.save(todo)
    }

    fun deleteTodo(todoId: Long) = todoRepository.deleteById(todoId)
}