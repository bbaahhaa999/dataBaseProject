package com.database.dataBaseProject.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount =0;
    static {
        todos.add(new Todo(++todosCount,"bhajahmad","spring boot course", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"aboodHA","spring MVC", LocalDate.now().plusYears(2),false));
        todos.add(new Todo(++todosCount,"alaaHA","Microservices", LocalDate.now().plusYears(3),false));
    }

    public List<Todo> findByUserName(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos;
    }
    public void addTodo(String username, String description, LocalDate targetDate,boolean done){
        Todo todo = new Todo(++todosCount,username,description,targetDate,done);
        todos.add(todo);

    }
}
