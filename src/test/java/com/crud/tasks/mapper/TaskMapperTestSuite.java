package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test Title Dto", "Test Content Dto");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals("Test Title Dto", task.getTitle());
    }

    @Test
    public void mapToTaskDto() {
        //Given
        Task task = new Task(1L, "Test Title", "Test Content");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals("Test Title", taskDto.getTitle());
    }

    @Test
    public void mapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "Test Title", "Test Content"));
        taskList.add(new Task(2L, "Test Title 2", "Test Content 2"));
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals(2, taskDtoList.size());
    }
}