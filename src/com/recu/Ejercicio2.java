package com.recu;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el numero de ventanas ejecutar: ");
        int ventanasNum = input.nextInt();
        ArrayList<Process> listOfProcess = new ArrayList<Process>();
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("C:/Program Files/Google/Chrome/Application/chrome");

        try {

            String horaEjecucion= LocalDateTime.now().getHour()+":"+ LocalDateTime.now().getMinute()+":"+LocalDateTime.now().getSecond();
            System.out.println("La hora de arranque del proceso es: " + horaEjecucion );

            for (int i = 0; i < ventanasNum; i++) {
                Process process = processBuilder.start();
                listOfProcess.add(process);
            }

            for (Process process : listOfProcess) {
                process.waitFor(500, TimeUnit.MILLISECONDS);
                process.destroy();
            }
            System.out.println("La hora de finalización del proceso es: " + horaEjecucion);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
