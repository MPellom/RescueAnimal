import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<>();
    // Instance variables (if needed)


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String userInput;


        initializeDogList();
        initializeMonkeyList();

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
        // For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
        // Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.

        //do while loop until "q" is entered


        do {
            displayMenu();
            userInput = scnr.nextLine();

            if (isValidInput(userInput)) {
                switch (userInput) {
                    case "1":
                        intakeNewDog(scnr);
                        break;

                    case "2":
                        intakeNewMonkey(scnr);
                        break;

                    case "3":
                        reserveAnimal(scnr);
                        break;

                    case "4":
                        printAnimals("dog", false);
                        break;

                    case "5":
                        printAnimals("monkey", false);
                        break;

                    case "6":
                        printAnimals("dog", true);
                        printAnimals("monkey", true);
                        break;
                    case "q":

                        break;
                }
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        } while (!userInput.equals("q"));
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Spencer", "Male", "4", "8.4", "7-15-2024","Congo" ,"in service",  true, "Canada", "14", "22", "10", "Squirrel monkey");

        monkeyList.add(monkey1);
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return;
            }
        }
        //prompts for dog characteristic inputs
        System.out.println("What is the dog's breed?: ");
        String breed = scanner.nextLine();

        System.out.println("What is the dog's gender?: ");
        String gender = scanner.nextLine();

        System.out.println("What is the dog's age?: ");
        String age = scanner.nextLine();

        System.out.println("What is the dog's weight?: ");
        String weight = scanner.nextLine();

        System.out.println("What is the dog's acquisition date?: ");
        String acquisitionDate = scanner.nextLine();

        System.out.println("What is the dog's acquisition country?: ");
        String acquisitionCountry = scanner.nextLine();

        System.out.println("What is the dog's training status?: ");
        String trainingStatus = scanner.nextLine();

        System.out.println("What is the dogs country of origin?");
        String inServiceCountry = scanner.nextLine();

        //creates newDog object
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, trainingStatus, acquisitionCountry, false, inServiceCountry);
        //adds newDog to dogList
        dogList.add(newDog);
        System.out.println("\n\n Dog added to system successfully!\n\n");


        // Add the code to instantiate a new dog and add it to the appropriate list
    }


    // Complete intakeNewMonkey
    //Instantiate and add the new monkey to the appropriate list
    // For the project submission you must also  validate the input
    // to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the Monkey's name?");
        String name = scanner.nextLine();
        if (!isValidName(name, monkeyList)) {
            System.out.println("\n\nInvalid name. Please enter a valid name.\n\n");
            return;
        }
        for (Monkey monkey : monkeyList) {
            //validates to monkey does not already exist
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return;
            }

        }
        //Prompts for characteristics input for new monkey
        System.out.println("What is the monkey's gender?: ");
        String gender = scanner.nextLine();

        System.out.println("What is the monkey's age?: ");
        String age = scanner.nextLine();

        System.out.println("What is the monkey's weight?: ");
        String weight = scanner.nextLine();

        System.out.println("What is the monkey's acquisition date?: ");
        String acquisitionDate = scanner.nextLine();

        System.out.println("What is the monkey's training status?: ");
        String trainingStatus = scanner.nextLine();

        System.out.println("What is the monkey's acquisition country?: ");
        String acquisitionCountry = scanner.nextLine();


        System.out.println("What is the monkey's country of service?");
        String inServiceCountry = scanner.nextLine();

        System.out.println("What is the monkey's tail length?");
        String tailLength = scanner.nextLine();

        System.out.println("What is the monkey's height?");
        String height = scanner.nextLine();

        System.out.println("What is the monkey's body length?");
        String bodyLength = scanner.nextLine();

        System.out.println("What is the monkey's species?");
        String species = scanner.nextLine();

        //creates list of valid species
        String[] validSpecies = {
                "Capuchin",
                "Guenon",
                "Macaque",
                "Marmoset",
                "Squirrel monkey",
                "Tamarin"
        };
        //allow creation of monkey to continue
        //if species is valid
        boolean isValidSpecies = false;
        for (String valid : validSpecies) {
            if (species.equalsIgnoreCase(valid)) {
                isValidSpecies = true;
                break;
            }
        }
        //prompts user of invalid species
        //cancels creation of new object
        if (!isValidSpecies) {
            System.out.println("\n\nInvalid species. Please choose from the following: Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin.\n\n");
            return;
        }

        //creates newMonkey object
        Monkey newMonkey = new Monkey(name, gender, age, weight, acquisitionDate, trainingStatus, acquisitionCountry, false, inServiceCountry, tailLength, height, bodyLength, species);
        //adds newMonkey to the monkeyList
        monkeyList.add(newMonkey);
        System.out.println("\n\n monkey added to system successfully!\n\n");
    }

    public static boolean isValidName(String name, ArrayList<Monkey> monkeyList) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        if (!name.matches("[a-zA-Z]+")) {
            return false;
        }

        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }

        return true;
    }

    // Complete reserveAnimal
    // You will need to find the animal by animal type and in service country
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Enter the type of animal (dog/monkey): ");
        String animalType = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter the country of service: ");
        String country = scanner.nextLine().trim().toLowerCase();

        boolean animalFound = false;

        if (animalType.equals("dog")) {
            for (Dog dog : dogList) {
                if (dog.getInServiceLocation().equalsIgnoreCase(country) && !dog.getReserved()) {
                    dog.setReserved(true);
                    System.out.println("Dog " + dog.getName() + " has been reserved.");
                    animalFound = true;
                    break;
                }
            }
        } else if (animalType.equals("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getInServiceLocation().equalsIgnoreCase(country) && !monkey.getReserved()) {
                    monkey.setReserved(true);
                    System.out.println("Monkey " + monkey.getName() + " has been reserved.");
                    animalFound = true;
                    break;
                }
            }
        } else {
            System.out.println("Invalid animal type. Please enter 'dog' or 'monkey'.");
            return;
        }


        if (!animalFound) {
            System.out.println("No available " + animalType + " found in " + country + ".");
        }
    }


    public static void printAnimals(String animalType, boolean inServiceAndAvailable) {
        if (animalType.equals("dog")) {
            System.out.println("Dogs:");
            if (animalType.equalsIgnoreCase("dog")) {
                for (Dog dog : dogList) {
                    if (inServiceAndAvailable) {
                        if (dog.getTrainingStatus().equalsIgnoreCase("in service") && dog.getReserved()) {
                            System.out.print(dog.getName() + ", ");
                            System.out.print(dog.getBreed() + ", ");
                            System.out.print(dog.getGender() + ", ");
                            System.out.print(dog.getAge() + ", ");
                            System.out.print(dog.getWeight() + ", ");
                            System.out.print(dog.getAcquisitionDate() + ", ");
                            System.out.print(dog.getTrainingStatus() + ", ");
                            System.out.print(dog.getAcquisitionLocation() + ", ");
                            System.out.print(dog.getReserved() + ", ");
                            System.out.println(dog.getInServiceLocation());

                        }
                    }else {
                        System.out.print(dog.getName() + ", ");
                        System.out.print(dog.getBreed() + ", ");
                        System.out.print(dog.getGender() + ", ");
                        System.out.print(dog.getAge() + ", ");
                        System.out.print(dog.getWeight() + ", ");
                        System.out.print(dog.getAcquisitionDate() + ", ");
                        System.out.print(dog.getTrainingStatus() + ", ");
                        System.out.print(dog.getAcquisitionLocation() + ", ");
                        System.out.print(dog.getReserved() + ", ");
                        System.out.println(dog.getInServiceLocation());
                    }
                }
            }
        } else if (animalType.equals("monkey")) {
            System.out.println("Monkeys:");
            for (Monkey monkey : monkeyList) {
                if (inServiceAndAvailable) {
                    if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && monkey.getReserved()) {
                        System.out.print(monkey.getName() + ", ");
                        System.out.print(monkey.getGender() + ", ");
                        System.out.print(monkey.getAge() + ", ");
                        System.out.print(monkey.getWeight() + ", ");
                        System.out.print(monkey.getAcquisitionDate() + ", ");
                        System.out.print(monkey.getTrainingStatus() + ", ");
                        System.out.print(monkey.getAcquisitionLocation() + ", ");
                        System.out.print(monkey.getReserved() + ", ");
                        System.out.print(monkey.getInServiceLocation() + ", ");
                        System.out.print(monkey.getTailLength() + ", ");
                        System.out.print(monkey.getHeight() + ", ");
                        System.out.print(monkey.getBodyLength() + ", ");
                        System.out.println(monkey.getSpecies());
                    }
                } else {
                    System.out.print(monkey.getName() + ", ");
                    System.out.print(monkey.getGender() + ", ");
                    System.out.print(monkey.getAge() + ", ");
                    System.out.print(monkey.getWeight() + ", ");
                    System.out.print(monkey.getAcquisitionDate() + ", ");
                    System.out.print(monkey.getTrainingStatus() + ", ");
                    System.out.print(monkey.getAcquisitionLocation() + ", ");
                    System.out.print(monkey.getReserved() + ", ");
                    System.out.print(monkey.getInServiceLocation() + ", ");
                    System.out.print(monkey.getTailLength() + ", ");
                    System.out.print(monkey.getHeight() + ", ");
                    System.out.print(monkey.getBodyLength() + ", ");
                    System.out.println(monkey.getSpecies());
                }

            }


        }
    }


        //input validation for menu input
        public static boolean isValidInput (String input){
            // Check if the input is a valid menu option
            String[] validOptions = {"1", "2", "3", "4", "5", "6", "q"};
            for (String option : validOptions) {
                if (input.equals(option)) {
                    return true;
                }
            }
            return false;
        }

    }



