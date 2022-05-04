package com.cybertek.repository;

import com.cybertek.entity.Project;
import com.cybertek.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query("SELECT count(t) FROM Task t WHERE t.project.projectCode = ?1 AND t.taskStatus <> 'COMPLETED'")
    int totalNonCompletedTaks(String projectCode);

    @Query(value = "SELECT count(*) " +
            "FROM tasks t JOIN projects p on t.project_id=p.id " +
            "WHERE p.project_code = ?1 AND t.task_status = 'COMPLETED'", nativeQuery = true)
    int totalCompletedTaks(String projectCode);
}