package service;

import entities.owner.Owner;
import entities.task.Task;
import entities.task.TaskTypes;

import java.util.Scanner;

public class OwnerConsoleIO {
    private Owner owner;
    public OwnerConsoleIO(){
        try {
            this.owner = new Owner(
                    "tasks.txt",
                    "park_list.txt",
                    "user_report.txt"
            );
        } catch (Exception e){
            System.err.println(e);
        }
    }

    public void flow(){
        Scanner scan = new Scanner(System.in);
        int choice = -1;

        while(choice != 0){
            System.out.println(
                    "Choose an option: " +
                    "\n1. Add new task" +
                    "\n2. Print all reports" +
                    "\n3. Confirm all reports" +
                    "\n0. Exit the program" +
                    "\nYour choice: ");
            try{
                choice = scan.nextInt();
                switch(choice){
                    case 1: {
                        this.addNewTask();
                        break;
                    }
                    case 2:{
                        System.out.println(this.owner.getReportListAsString());
                        break;
                    }
                    case 3:{
                        this.owner.confirmReport();
                    }
                    case 0: {
                        System.exit(0);
                    }
                    default: {
                        System.out.println("Try one more time!\n");
                    }
                }
            } catch (Exception e){
                System.err.println(e);
            }
        }
    }

    private void addNewTask(){
        System.out.println("Choose a type of a task: \n");
        TaskTypes[] types = TaskTypes.values();

        int i = 0;
        for(TaskTypes type : types){
            System.out.println(i + ". " + type.toString() + "\n");
            i++;
        }

        Scanner scan = new Scanner(System.in);
        int typeChoice = -1, indexChoice = 0;

        try{
            typeChoice = scan.nextInt();
            if(typeChoice >= types.length || typeChoice < 0){this.addNewTask();}
        } catch (Exception e){
            System.err.println(e);
        }

        System.out.println("Choose a plant index from 0 to " + this.owner.getPlantsCount());
        System.out.println("Your choice: ");

        try{
            indexChoice = scan.nextInt();
            if(indexChoice >= this.owner.getPlantsCount() && indexChoice < 0){this.addNewTask();}
        } catch (Exception e){
            System.err.println(e);
        }

        try {
            this.owner.setNewTask(new Task(types[typeChoice], indexChoice));
        } catch(Exception e){
            System.err.println(e);
        }
    }
}
