package entities.plant.art;

import entities.plant.Plant;

public class PaintPlantBehaviour implements ArtProcessingBehaviour {
    public void decorate(Plant plant){
        plant.setBeautyPercent(plant.getBeautyPercent() + 15);
    }
}
