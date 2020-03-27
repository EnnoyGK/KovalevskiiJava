package entities.taskList;

import dao.TaskListIO;
import entities.task.Task;
import java.io.IOException;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;
    private String fileName;

    public TaskList(String fileName) throws IOException{
        this.fileName = fileName;

        TaskListIO taskListIO = new TaskListIO(this.fileName);
        this.taskList = taskListIO.getTaskList();
    }

    public ArrayList<Task> getTaskList(){
        return this.taskList;
    }

    public void addNewTask(Task task){
        this.taskList.add(task);
    }

    public void deleteTask(int taskIndex){ this.taskList.remove(taskIndex); }

    public void writeTaskList() throws IOException{
        TaskListIO taskListIO = new TaskListIO(this.fileName);
        taskListIO.writeTaskList(this.taskList);
    }

    public String getTaskListAsString() throws IOException{
        String taskStr = "";
        ArrayList<Task> tasks = this.getTaskList();
        for(Task task : tasks){
            taskStr +=
                    "Tree index: " + task.getPlantIndexInList() +
                    "\nTo do: " + task.getType().toString() +
                    "\n\n";
        }
        return taskStr;
    }
}
