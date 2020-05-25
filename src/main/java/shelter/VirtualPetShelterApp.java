package shelter;

import java.util.Scanner;

public class VirtualPetShelterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VirtualPet pet1 = new VirtualPet("Poncho",
                "A dog with course brown fur.",
                58, 43, 62);
        VirtualPet pet2 = new VirtualPet("Bella",
                "A baby kitten.",
                53, 47, 58);
        VirtualPet pet3 = new VirtualPet("Bandit",
                "An antisocial mean kitten.",
                47, 56, 54);
        VirtualPetShelter shelter = new VirtualPetShelter(50);
        shelter.addPetToShelter(pet1);
        shelter.addPetToShelter(pet2);
        shelter.addPetToShelter(pet3);

        System.out.println("Welcome to your Virtual Pet Shelter!\n");

        while (true) {
            System.out.println("The pet pens are this dirty: " + shelter.getPenCleanliness());
            System.out.println("This is the status of your pets:\n");
            getPetsStatus(shelter);
            System.out.println("What would you like to do next?\n");
            int input = shelterInteraction(scanner, shelter);
            if (input == 0) {
                break;
            }
            scanner.nextLine();
            shelter.tick();
        }
    }

    public static void getPetsStatus(VirtualPetShelter shelter) {
        System.out.println("Name    |Hunger  |Thirst  |Boredom");
        for (VirtualPet virtualPet : shelter.getAllPets()) {
            StringBuilder petName = new StringBuilder(virtualPet.getPetName());
            while (petName.length() < 8) {
                petName.append(" ");
            }
            StringBuilder petHunger = new StringBuilder();
            petHunger.append(virtualPet.getPetHunger());
            while (petHunger.length() < 8) {
                petHunger.append(" ");
            }
            StringBuilder petThirst = new StringBuilder();
            petThirst.append(virtualPet.getPetThirst());
            while (petThirst.length() < 8) {
                petThirst.append(" ");
            }
            StringBuilder petBoredom = new StringBuilder();
            petBoredom.append(virtualPet.getPetBoredom());
            while (petBoredom.length() < 8) {
                petBoredom.append(" ");
            }
            System.out.println(petName + "|"
                    + petHunger + "|"
                    + petThirst + "|"
                    + petBoredom + "");
        }
        System.out.println();
    }

    public static int shelterInteraction(Scanner scanner, VirtualPetShelter shelter) {
        System.out.println("1. Feed the pets\n" +
                "2. Water the pets\n" +
                "3. Play with a pet\n" +
                "4. Adopt a pet\n" +
                "5. Admit a pet\n" +
                "6. Clean Pens\n" +
                "0. Quit");
        int input = scanner.nextInt();
        input = shelterHelp(scanner, input);
        if (input == 1) {
            shelter.feedAllPets(43);
            System.out.println("You feed the pets!");
        } else if (input == 2) {
            shelter.waterAllPets(47);
            System.out.println("You water the pets!");
        } else if (input == 3) {
            playWithPet(scanner, shelter);
        } else if (input == 4) {
            adoptPet(scanner, shelter);
        } else if (input == 5) {
            admitPet(scanner, shelter);
        } else if (input == 6) {
            shelter.cleanPens(50);
            System.out.println("You cleaned the pens!");
        }
        return input;

    }

    public static int shelterHelp(Scanner scanner, int input) {
        while ((input > 6) || (input < 0)) {
            System.out.println("Please enter a number between 0 and 6:");
            input = scanner.nextInt();
        }
        return input;
    }

    public static void playWithPet(Scanner scanner, VirtualPetShelter shelter) {
        System.out.println("OK, so you'd like to play with a pet. Please choose one:\n");
        for (VirtualPet pet : shelter.getAllPets()) {
            System.out.println(pet.getPetName() + ": " + pet.getPetDescription());
        }
        System.out.println("\nWhich pet would you like to play with?");
        String pet = scanner.next();
        pet = petHelp(scanner, shelter, pet);
        shelter.playWithPet(pet, 53);
    }

    public static void adoptPet(Scanner scanner, VirtualPetShelter shelter) {
        System.out.println("OK, so you'd like to adopt a pet. Please choose one:\n");
        for (VirtualPet pet : shelter.getAllPets()) {
            System.out.println(pet.getPetName() + ": " + pet.getPetDescription());
        }
        System.out.println("\nWhich pet would you like to adopt?");
        String pet = scanner.next();
        pet = petHelp(scanner, shelter, pet);
        shelter.removePetFromShelter(pet);
    }

    public static void admitPet(Scanner scanner, VirtualPetShelter shelter) {
        System.out.println("OK, so you'd like to admit a pet.\n");
        System.out.println("What is its name?");
        String name = scanner.next();
        System.out.println("Please give a description of the pet.");
        String description = scanner.next();
        System.out.println("On a scale of 1 - 100, how hungry is the pet?");
        int hunger = scanner.nextInt();
        System.out.println("On a scale of 1 - 100, how thirsty is the pet?");
        int thirst = scanner.nextInt();
        System.out.println("On a scale of 1 - 100, how bored is the pet?");
        int boredom = scanner.nextInt();
        VirtualPet virtualPet = new VirtualPet(name, description, hunger, thirst, boredom);
        shelter.addPetToShelter(virtualPet);
        System.out.println(name + " has been added to the shelter.");
    }


    public static String petHelp(Scanner scanner, VirtualPetShelter shelter, String pet) {
        boolean petInShelter = shelter.isPetInShelter(pet);
        while (!petInShelter) {
            System.out.println("Please select a pet from the list.");
            pet = scanner.next();
            petInShelter = shelter.isPetInShelter(pet);
        }
        return pet;
    }
}