package dao;

import entities.task.Task;
import entities.task.TaskTypes;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportListIO {
    private File reportList;

    public ReportListIO(String fileName){
        this.reportList = new File(fileName);
    }

    public ArrayList<Task> getTaskList() throws IOException {
        FileReader fr = new FileReader(this.reportList.getName());
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
        FileWriter fw = new FileWriter(this.reportList.getName());

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
