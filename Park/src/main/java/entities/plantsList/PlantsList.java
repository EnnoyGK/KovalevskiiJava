package entities.plantsList;

import dao.ParkListIO;
import entities.plant.Plant;
import entities.task.Task;

import java.io.IOException;
import java.util.ArrayList;

public class PlantsList {
    private ArrayList<Plant> plantsList;
    private String fileName;

    public PlantsList(String fileName) throws IOException {
        this.fileName = fileName;

        ParkListIO parkListIO = new ParkListIO(this.fileName);
        this.plantsList = parkListIO.getParkList();
    }

    public ArrayList<Plant> getPlantsList(){
        return this.plantsList;
    }

    public void addNewPlant(Plant plant){
        this.plantsList.add(plant);
    }

    public void writeParkList() throws IOException{
        ParkListIO parkListIO = new ParkListIO(this.fileName);
        parkListIO.writeParkList(this.plantsList);
    }

    public String getPlantsListAsString() throws IOException{
        String plantsStr = "";
        ArrayList<Plant> plants = this.getPlantsList();
        for(Plant plant : plants){
            plantsStr +=
                    "Tree title: " + plant.getTitle() +
                    "\nHealth points: " + plant.getHealthPoints() +
                    "\nBeauty percents: " + plant.getBeautyPercent() +
                    "\n\n";
        }
        return plantsStr;
    }
}
