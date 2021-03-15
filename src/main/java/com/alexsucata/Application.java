package com.alexsucata;

import com.alexsucata.owners.OwnerEntity;
import com.alexsucata.owners.OwnerRepository;
import com.alexsucata.owners.OwnerRepositoryImpl;

import java.util.List;
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
                        case 1:
                            readAndInsertOwnerDetails();
                            break;
                        case 2:
                            updateOwner();
                            break;
                        case 3:
                            deleteOwner();
                            break;
                        case 4:
                            getAllOwners();
                            break;
                        default:
                            System.out.println("Option not available");
                    }
                    break;
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

    public void readAndInsertOwnerDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        scanner.close();

        OwnerEntity owner = new OwnerEntity();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        owner.setAddress(address);
        owner.setPhoneNumber(phoneNumber);

        OwnerRepositoryImpl repository = new OwnerRepositoryImpl();
        repository.create(owner);
    }

    public void getAllOwners() {
        OwnerRepository ownerRepository = new OwnerRepositoryImpl();
        List<OwnerEntity> ownerEntityList = ownerRepository.findAll();
        for (int i = 0; i < ownerEntityList.size(); i++) {
            System.out.println(ownerEntityList.get(i).toString());
        }
    }

    public void updateOwner() {
        OwnerRepository ownerRepository = new OwnerRepositoryImpl();
        List<OwnerEntity> ownerEntityList = ownerRepository.findAll();
        for (int i = 0; i < ownerEntityList.size(); i++) {
            System.out.println(ownerEntityList.get(i).getFirstName());
        }
        Scanner scanner = new Scanner(System.in);
        int selectedOwnerPosition = scanner.nextInt() - 1;
        OwnerEntity selectedOwner = ownerEntityList.get(selectedOwnerPosition);
        scanner.nextLine();
        System.out.println("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        scanner.close();

        selectedOwner.setFirstName(firstName);
        selectedOwner.setLastName(lastName);
        selectedOwner.setAddress(address);
        selectedOwner.setPhoneNumber(phoneNumber);

        ownerRepository.update(selectedOwner.getOwnerId(), selectedOwner);
    }

    public void deleteOwner() {
        OwnerRepository ownerRepository = new OwnerRepositoryImpl();
        List<OwnerEntity> ownerEntityList = ownerRepository.findAll();
        for (int i = 0; i < ownerEntityList.size(); i++) {
            System.out.println(ownerEntityList.get(i).getFirstName());
        }
        Scanner scanner = new Scanner(System.in);
        int selectedOwnerPosition = scanner.nextInt() - 1;

        ownerRepository.delete(ownerEntityList.get(selectedOwnerPosition));
    }


}
