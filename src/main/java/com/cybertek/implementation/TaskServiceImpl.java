package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.TaskDTO;
import com.cybertek.entity.Task;
import com.cybertek.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public TaskDTO findById(Long id) {
        return null;
    }

    @Override
    public List<TaskDTO> listAllTasks() {
        return null;
    }

    @Override
    public Task save(TaskDTO dto) {
        return null;
    }

    @Override
    public void update(TaskDTO dto) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public int totalNonCompletedTasks(String projectCode) {
        return 0;
    }

    @Override
    public int totalCompletedTasks(String projectCode) {
        return 0;
    }

    @Override
    public void deleteByProject(ProjectDTO project) {

    }
}
