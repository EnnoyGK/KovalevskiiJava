package dao;

import entities.plant.Plant;
import entities.task.Task;
import entities.task.TaskTypes;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskListIO {
    private File taskList;

    public TaskListIO(String fileName){
        this.taskList = new File(fileName);
    }

    public ArrayList<Task> getTaskList() throws IOException{
        FileReader fr = new FileReader(this.taskList.getName());
        Scanner scan = new Scanner(fr);
        ArrayList<Task> taskList = new ArrayList<>();

        while(scan.hasNext()){
            int plantIndex = Integer.parseInt(scan.nextLine());
            TaskTypes type = TaskTypes.valueOf(scan.nextLine());

            Task task = new Task(type, plantIndex);
            taskList.add(task);
        }

        fr.close();
        return taskList;
    }

    public void writeTaskList(ArrayList<Task> taskList) throws IOException{
        FileWriter fw = new FileWriter(this.taskList.getName());

        for (Task value : taskList) {
            try {
                fw.write(Integer.toString(value.getPlantIndexInList()) + '\n');
                fw.write(value.getType().toString() + '\n');
            } catch (IOException e) {
                throw e;
            }
        }

        fw.close();
    }
}
