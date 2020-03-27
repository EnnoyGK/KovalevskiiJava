package entities.forester;

import entities.plant.art.CutPlantBehaviour;
import entities.plant.art.PaintPlantBehaviour;
import entities.plant.destruction.CutDownBehaviour;
import entities.plant.destruction.DigUpBehaviour;
import entities.plant.treatment.AddFertilizerBehaviour;
import entities.plant.treatment.PruneTwigsBehaviour;
import entities.plantsList.PlantsList;
import entities.reportList.ReportList;
import entities.task.Task;
import entities.taskList.TaskList;

import java.io.IOException;


public class Forester {
    private TaskList taskList;
    private PlantsList plantsList;
    private ReportList reportList;

    public Forester(
        String taskListFileName,
        String plantsListFileName,
        String reportListFilename
    ) throws IOException{
        this.taskList = new TaskList(taskListFileName);
        this.plantsList = new PlantsList(plantsListFileName);
        this.reportList = new ReportList(reportListFilename);
    }

    public void performTask(int taskIndex) throws IOException{
        Task task = this.taskList.getTaskList().get(taskIndex);
        this.executeTask(task);
        this.plantsList.writeParkList();
        makeReport(taskIndex);
    }

    public void makeReport(int taskIndex) throws IOException{
        this.reportList.addNewReport(this.taskList.getTaskList().get(taskIndex));
        this.taskList.deleteTask(taskIndex);

        this.reportList.writeReportList();
        this.taskList.writeTaskList();
    }

    public String getPlantsListAsString() throws IOException{
        return this.plantsList.getPlantsListAsString();
    }

    public String getTaskListAsString() throws IOException{
        return this.taskList.getTaskListAsString();
    }

    private void executeTask(Task task){
        switch (task.getType()){
            case CUT_PLANT: {
                this.plantsList.getPlantsList()
                               .get(task.getPlantIndexInList())
                               .decorate(new CutPlantBehaviour());
                break;
            }

            case PAINT_PLANT: {
                this.plantsList.getPlantsList()
                        .get(task.getPlantIndexInList())
                        .decorate(new PaintPlantBehaviour());
                break;
            }

            case DIG_UP: {
                this.plantsList.getPlantsList()
                        .get(task.getPlantIndexInList())
                        .destruct(new DigUpBehaviour());
                break;
            }

            case CUT_DOWN: {
                this.plantsList.getPlantsList()
                        .get(task.getPlantIndexInList())
                        .destruct(new CutDownBehaviour());
                break;
            }

            case ADD_FERTILIZER: {
                this.plantsList.getPlantsList()
                        .get(task.getPlantIndexInList())
                        .heal(new AddFertilizerBehaviour());
                break;
            }

            case PRUNE_TWIGS: {
                this.plantsList.getPlantsList()
                        .get(task.getPlantIndexInList())
                        .heal(new PruneTwigsBehaviour());
                break;
            }
        }
    }
}
