package com.database.dataBaseProject.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("current")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // /list-todos

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
      List<Todo> todos = todoService.findByUserName("bhajahmad");

      model.addAttribute("todos",todos);
        model.addAttribute("current","Home");
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(Model model , Todo todo){
        model.addAttribute("todo",todo);
        return "todo";
    }
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodoPage(Model model, Todo todo ,@RequestParam String description, BindingResult result){
        if(!result.hasErrors()){
            System.out.println(result.toString());
        todoService.addTodo("bhajahmad",description, LocalDate.now().plusYears(1),false);
        return "redirect:list-todos";
        }else {
            return "listTodos";
        }
    }
}
