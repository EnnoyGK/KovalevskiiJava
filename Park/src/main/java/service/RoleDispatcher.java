package service;


import java.util.Scanner;

public class RoleDispatcher {
    public void dispatch(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to our Park system!");
        int choice;
        while(true) {
            System.out.println("Choose your role:" +
                    "\n1. Forester" +
                    "\n2. Owner");
            System.out.println("Your choice: ");
            try {
                choice = scan.nextInt();
                if(choice == 2 || choice == 1){
                    break;
                } else{
                    continue;
                }
            } catch (Exception e){
                System.err.println(e);
            }
        }

        switch(choice){
            case 1: {
                ForesterConsoleIO foresterConsoleIO = new ForesterConsoleIO();
                foresterConsoleIO.flow();
                break;
            }
            case 2: {
                OwnerConsoleIO ownerConsoleIO = new OwnerConsoleIO();
                ownerConsoleIO.flow();
                break;
            }
        }
    }
}
