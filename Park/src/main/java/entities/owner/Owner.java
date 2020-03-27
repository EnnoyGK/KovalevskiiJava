package entities.owner;

import entities.plantsList.PlantsList;
import entities.reportList.ReportList;
import entities.task.Task;
import entities.taskList.TaskList;

import java.io.IOException;
import java.util.ArrayList;

public class Owner {
    private TaskList taskList;
    private PlantsList plantsList;
    private ReportList reportList;

    public Owner(
        String taskListFileName,
        String plantsListFileName,
        String reportListFilename
    ) throws IOException{
        this.taskList = new TaskList(taskListFileName);
        this.plantsList = new PlantsList(plantsListFileName);
        this.reportList = new ReportList(reportListFilename);
    }

    public void setNewTask(Task task) throws IOException{
        this.taskList.addNewTask(task);
        this.taskList.writeTaskList();
    }

    public String getReportListAsString() throws IOException{
        return this.reportList.getReportListAsString();
    }


    public void confirmReport() throws IOException{
        this.reportList.clearReportList();
        this.reportList.writeReportList();
    }

    public int getPlantsCount(){
        return this.plantsList.getPlantsList().size();
    }
}
