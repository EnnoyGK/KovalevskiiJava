package entities.plant.destruction;

import entities.plant.Plant;

public class DigUpBehaviour implements PlantDestructionBehaviour {
    public void destruct(Plant plant){
        plant.setHealthPoints(0);
    }
}
