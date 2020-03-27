package service;

import entities.forester.Forester;

import java.util.Scanner;

public class ForesterConsoleIO {
    private Forester forester;

    public ForesterConsoleIO(){
        try {
            this.forester = new Forester(
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
                            "\n1. Perform a task" +
                            "\n2. Print all tasks" +
                            "\n3. Print all plants" +
                            "\n0. Exit the program" +
                            "\nYour choice: ");
            try{
                choice = scan.nextInt();
                switch(choice){
                    case 1: {
                        this.forester.performTask(this.getTaskNumber());
                        break;
                    }
                    case 2:{
                        System.out.println(this.forester.getTaskListAsString());
                        break;
                    }
                    case 3:{
                        System.out.println(this.forester.getPlantsListAsString());
                        break;
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

    public int getTaskNumber() throws Exception{
        System.out.println("Input task number: ");
        Scanner scan = new Scanner(System.in);

        return scan.nextInt();
    }
}
