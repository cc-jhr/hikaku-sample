package de.codecentric.hikaku.sample

import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMethod.*

data class Todo(val text: String = "")

@RestController
@RequestMapping("/todos")
class TodosController {

    @RequestMapping(method = [GET])
    fun fetchAllTodos() = listOf(Todo())

    @RequestMapping(method = [POST])
    fun createTodo(@RequestBody todo: Todo) { }

    @RequestMapping("/{id}", method = [DELETE])
    fun deleteTodo(@PathVariable("id") todoIdentifier: String) { }

    @RequestMapping("/{id}", method = [GET])
    fun fetchTodo(@PathVariable("id") todoIdentifier: String) = Todo()
}