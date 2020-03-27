package entities.plant.art;

import entities.plant.Plant;

public class CutPlantBehaviour implements ArtProcessingBehaviour {
    public void decorate(Plant plant){
        plant.setBeautyPercent(plant.getBeautyPercent() + 30);
    }
}
