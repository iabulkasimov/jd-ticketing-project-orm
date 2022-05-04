package com.cybertek.controller;

import com.cybertek.dto.TaskDTO;
import com.cybertek.enums.Status;
import com.cybertek.service.ProjectService;
import com.cybertek.service.TaskService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/task")
public class TaskController {

    TaskService taskService;
    ProjectService projectService;
    UserService userService;

    public TaskController(TaskService taskService, ProjectService projectService, UserService userService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createTask(Model model){

        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.listAllProjects());
        model.addAttribute("employees",userService.listAllByRole("employee"));
        model.addAttribute("tasks",taskService.listAllTasks());

        return ("/task/create");
    }

    @PostMapping("/create")
    public String insertTask(Model model, TaskDTO taskDTO){

        taskService.save(taskDTO);
//        taskDTO.setTaskStatus(Status.OPEN);
//        taskDTO.setAssignedDate(LocalDate.now());
//        taskDTO.setId(UUID.randomUUID().getMostSignificantBits());
//
//        System.out.println("Auto generated : " + taskDTO.getId());
//
//        taskService.save(taskDTO);

        return ("redirect:/task/create");
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){

        taskService.delete(id);

        return "redirect:/task/create";
    }

    @GetMapping("/update/{id}")
    public String editTask(@PathVariable("id") Long id, Model model){

        model.addAttribute("task", taskService.findById(id));
        model.addAttribute("projects", projectService.listAllProjects());
        model.addAttribute("employees",userService.listAllByRole("employee"));
        model.addAttribute("tasks",taskService.listAllTasks());

        return "/task/update";
    }

    @PostMapping("/update/{id}")
    public String updateTask(TaskDTO id){

        taskService.update(id);

        return "redirect:/task/create";
    }

}
