package dao;

import entities.plant.Plant;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class ParkListIO {
    private File parkList;

    public ParkListIO(String title){
        this.parkList = new File(title);
    }

    public ArrayList<Plant> getParkList() throws IOException{
        FileReader fr = new FileReader(this.parkList.getName());
        Scanner scan = new Scanner(fr);
        ArrayList<Plant> plantsList = new ArrayList<>();

        while(scan.hasNext()){
            int healthPoints = Integer.parseInt(scan.nextLine());
            String title = scan.nextLine();
            int beautyPercent = Integer.parseInt(scan.nextLine());

            Plant plant = new Plant(healthPoints, title, beautyPercent);
            plantsList.add(plant);
        }

        fr.close();
        return plantsList;
    }

    public void writeParkList(ArrayList<Plant> plantsList) throws IOException{
        FileWriter fw = new FileWriter(this.parkList.getName());

        for (Plant value : plantsList) {
            try {
                fw.write(Integer.toString(value.getHealthPoints()) + '\n');
                fw.write(value.getTitle() + '\n');
                fw.write(Integer.toString(value.getBeautyPercent()) + '\n');
            } catch (IOException e) {
                throw e;
            }
        }

        fw.close();
    }
}
