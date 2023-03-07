import java.util.Scanner;

public class CandyStore {
    
    public static void main(String[] args) {
        // Create new Scanner object to take user input 
        Scanner input = new Scanner(System.in);


        //Initialize variables for candy choice and total cost
        String choice = ""; 
        double totalCost = 0.0;
        //Greet user and start loop for candy selection
        System.out.println("Welcome to the Candy Store!");
        while (!choice.equals("quit")) {
            //Prompt user to select a candy and get input
            String candy = candyChoices();
            // If user did not choose to quit, ask for quantity and calculate the cost 
            if (!candy.equals("quit")) {
                int qty = getQuantity();
                double cost = calculateCost(candy, qty);
                // Add cost to total and print cost of candy
                totalCost += cost;
                System.out.printf("The cost of %d kg of %s is: $%.2f%n", qty, candy, cost);
            }
            //Update choice variable with candy choice
            choice = candy;
        }
        
        // Calculate and print total cost after tax
        double tax = 0.13 * totalCost;
        double costAfterTax = totalCost + tax;
        System.out.printf("Total cost before tax: $%.2f%n", totalCost);
        System.out.printf("Tax: $%.2f%n", tax);
        System.out.printf("Total cost after tax: $%.2f%n", costAfterTax);
        System.out.println("Thank you for shopping at the Candy Store!");
    }
    // Metod to Print candy options and get user input
    public static String candyChoices() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please select a type of candy (or enter 'quit' to exit): ");
        System.out.println("a) Reese's Pieces: $2.50/0.5 kg");
        System.out.println("b) Skittles: $1.75/1 kg");
        System.out.println("c) Jubjubes: $0.50/1 kg");
        System.out.println("d) Lollipops: 1 for $0.50 or 5 for $2.00");
        System.out.println("e) Smarties: $1.50/1 kg");
        // Get user input and return it
        String choice = input.nextLine();
        return choice;
    }
    // Method to get quantity of candy from user
    public static int getQuantity() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the quantity (in kg): ");
        // Get user input 
        int qty = input.nextInt();
        input.nextLine(); // consume the extra newline character
        return qty;
    }
    // Method to calculate cost based on candy choice and quantity 
    public static double calculateCost(String choice, int qty) {
        double cost = 0.0;
        switch (choice) {
            case "a":
                cost = 2.5 * qty;
                break;
            case "b":
                cost = 1.75 * qty;
                break;
            case "c":
                cost = 0.5 * qty;
                break;
            case "d":
                int remainder = qty % 5;
                int setsOfFive = qty / 5;
                cost = setsOfFive * 2.0 + remainder * 0.5;
                break;
            case "e":
                cost = 1.5 * qty;
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
        return cost;
       
    }
}



    