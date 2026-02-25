package sn.isi.l3gl.core.task_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.l3gl.core.task_core.entity.Task;
import sn.isi.l3gl.core.task_core.enumeration.StatusEnum;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    // query methods Spring Data
    //    findByStatus(StatusEnum status) → SELECT * FROM tasks WHERE status = ?
    //countByStatus(StatusEnum status) → SELECT COUNT(*) FROM tasks WHERE status = ?

    List<Task> findByStatus(StatusEnum status);

    long countByStatus(StatusEnum status);
}