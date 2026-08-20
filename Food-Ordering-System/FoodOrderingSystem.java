import java.util.Scanner;

public class FoodOrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Food names and prices
        String[] foodNames = {"Burger", "Pizza", "Pasta", "French Fries", "Cold Drink"};
        int[] foodPrices = {120, 250, 180, 100, 50};

        // This array stores the quantity ordered for each food item.
        int[] order = {0, 0, 0, 0, 0};

        int choice = 0;

        System.out.println("Welcome to Food Ordering System!");

        while (choice != 5) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. View Food Menu");
            System.out.println("2. Add Food to Order");
            System.out.println("3. View Order");
            System.out.println("4. Generate Bill");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n========== FOOD MENU ==========");
                    for (int i = 0; i < foodNames.length; i++) {
                        System.out.println((i + 1) + ". " + foodNames[i]
                                + " - Rs." + foodPrices[i]);
                    }
                    break;

                case 2:
                    System.out.println("\n========== FOOD MENU ==========");
                    for (int i = 0; i < foodNames.length; i++) {
                        System.out.println((i + 1) + ". " + foodNames[i]
                                + " - Rs." + foodPrices[i]);
                    }

                    System.out.print("Enter food number: ");
                    int foodNumber = scanner.nextInt();

                    if (foodNumber >= 1 && foodNumber <= 5) {
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();

                        if (quantity > 0) {
                            order[foodNumber - 1] = order[foodNumber - 1] + quantity;
                            System.out.println(foodNames[foodNumber - 1] + " added to your order.");
                        } else {
                            System.out.println("Quantity must be greater than 0.");
                        }
                    } else {
                        System.out.println("Invalid food number.");
                    }
                    break;

                case 3:
                    System.out.println("\n========== YOUR ORDER ==========");
                    int subtotal = 0;
                    boolean orderIsEmpty = true;

                    for (int i = 0; i < order.length; i++) {
                        if (order[i] > 0) {
                            int itemTotal = foodPrices[i] * order[i];
                            System.out.println(foodNames[i] + " x" + order[i]
                                    + " = Rs." + itemTotal);
                            subtotal = subtotal + itemTotal;
                            orderIsEmpty = false;
                        }
                    }

                    if (orderIsEmpty) {
                        System.out.println("Your order is empty.");
                    } else {
                        System.out.println("Subtotal: Rs." + subtotal);
                    }
                    break;

                case 4:
                    int total = 0;

                    for (int i = 0; i < order.length; i++) {
                        total = total + (foodPrices[i] * order[i]);
                    }

                    if (total == 0) {
                        System.out.println("Your order is empty.");
                    } else {
                        System.out.println("\n========== FINAL BILL ==========");
                        System.out.println("Total amount: Rs." + total);
                        System.out.println("Thank you for your order!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you! Visit again.");
                    break;

                default:
                    System.out.println("Please enter a number from 1 to 5.");
            }
        }

        scanner.close();
    }
}
