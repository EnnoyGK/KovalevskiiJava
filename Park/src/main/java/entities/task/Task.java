package entities.task;

public class Task{
    private TaskTypes type;
    private int plantIndexInList;

    public Task(TaskTypes type, int plantIndexInList){
        this.plantIndexInList = plantIndexInList;
        this.type = type;
    }

    public TaskTypes getType() {
        return type;
    }

    public void setType(TaskTypes type) {
        this.type = type;
    }

    public int getPlantIndexInList() {
        return plantIndexInList;
    }

    public void setPlantIndexInList(int plantIndexInList) {
        this.plantIndexInList = plantIndexInList;
    }
}