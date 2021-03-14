package com.alexsucata;

import java.util.Scanner;

public class Application {

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Menu owner");
            System.out.println("2. Menu pet");
            System.out.println("3. Menu consult");
            System.out.println("4. Menu veterinarian");
            System.out.println("0. Exit");

            int selectedOption = scanner.nextInt();

            switch (selectedOption) {
                case 1:
                    System.out.println("Add owner:");
                    System.out.println("Update owner:");
                    System.out.println("Delete owner:");
                    System.out.println("Get all owners:");

                    int ownerOption = scanner.nextInt();

                    switch (ownerOption) {

                    }
                case 2:
                    System.out.println("Add pet:");
                    System.out.println("Update pet:");
                    System.out.println("Delete pet:");
                    System.out.println("Get all pets:");

                    int petOption = scanner.nextInt();

                    switch (petOption) {

                    }
                case 3:
                    System.out.println("1. Add consult:");
                    System.out.println("2. Update consult:");
                    System.out.println("3. Delete consult:");
                    System.out.println("4. Get all consults:");

                    int consultOption = scanner.nextInt();

                    switch (consultOption) {


                    }

                case 4:
                    System.out.println("1. Add veterinarian:");
                    System.out.println("2. Update veterinarian:");
                    System.out.println("3. Delete veterinarian:");
                    System.out.println("4. Get all veterinarians:");

                    int veterinarianOption = scanner.nextInt();

                    switch (veterinarianOption) {


                    }

                case 0:
                    System.out.println("Application closed");
                    return;
            }

        }
    }


    //*************************************************
    // Owner menu methods: create, read, update, delete



}
