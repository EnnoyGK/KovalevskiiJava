package entities.plant.treatment;

import entities.plant.Plant;

public class AddFertilizerBehaviour implements PlantTreatmentBehaviour{
    public void heal(Plant plant){
        plant.setHealthPoints(plant.getHealthPoints() + 20);
    }
}
