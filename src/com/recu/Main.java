package com.recu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el numero de ventanas ejecutar: ");
        int ventanasNum = input.nextInt();
        ArrayList<Process> listOfProcess = new ArrayList<Process>();
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("C:/Program Files/Google/Chrome/Application/chrome");
        try {
            for (int i = 0; i < ventanasNum; i++) {
                Process process = processBuilder.start();
                listOfProcess.add(process);
            }

            for (Process process : listOfProcess) {
                while (process.isAlive()) {
                    process.waitFor();
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }



}



