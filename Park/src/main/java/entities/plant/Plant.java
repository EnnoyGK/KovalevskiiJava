package entities.plant;

import entities.plant.art.ArtProcessingBehaviour;
import entities.plant.destruction.PlantDestructionBehaviour;
import entities.plant.treatment.PlantTreatmentBehaviour;

public class Plant {
    private int healthPoints;
    private String title;
    private int beautyPercent;

    public Plant(){
        this.healthPoints = 40;
        this.beautyPercent = 40;
        this.title = "Noname tree";
    }

    public Plant(int healthPoints, String title, int beautyPercent){
        this.setHealthPoints(healthPoints);
        this.setTitle(title);
        this.setBeautyPercent(beautyPercent);
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if(healthPoints > 100)
            this.healthPoints = 100;
        else
            this.healthPoints = healthPoints;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBeautyPercent() {
        return beautyPercent;
    }

    public void setBeautyPercent(int beautyPercent) {
        if(beautyPercent > 100)
            this.beautyPercent = 100;
        else
            this.beautyPercent = beautyPercent;
    }

    public void heal(PlantTreatmentBehaviour plantTreatmentBehaviour){
        plantTreatmentBehaviour.heal(this);
    }

    public void decorate(ArtProcessingBehaviour artProcessingBehaviour){
        artProcessingBehaviour.decorate(this);
    }

    public void destruct(PlantDestructionBehaviour plantDestructionBehaviour){
        plantDestructionBehaviour.destruct(this);
    }
}
