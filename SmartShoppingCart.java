import java.util.Scanner;

public class SmartShoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Product data
        String[] productNames = {"Laptop", "Headphones", "Keyboard", "Mouse", "USB Cable"};
        int[] productPrices = {50000, 2000, 1500, 800, 300};

        // This array stores how many of each product are in the cart.
        int[] cart = {0, 0, 0, 0, 0};

        int choice = 0;

        System.out.println("Welcome to Smart Shopping Cart!");

        while (choice != 6) {
            System.out.println("\n========== SMART SHOPPING CART ==========");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n========== PRODUCTS ==========");
                    for (int i = 0; i < productNames.length; i++) {
                        System.out.println((i + 1) + ". " + productNames[i]
                                + " - Rs." + productPrices[i]);
                    }
                    break;

                case 2:
                    System.out.println("\n========== PRODUCTS ==========");
                    for (int i = 0; i < productNames.length; i++) {
                        System.out.println((i + 1) + ". " + productNames[i]
                                + " - Rs." + productPrices[i]);
                    }

                    System.out.print("Enter product number: ");
                    int addProduct = scanner.nextInt();

                    if (addProduct >= 1 && addProduct <= 5) {
                        System.out.print("Enter quantity: ");
                        int addQuantity = scanner.nextInt();

                        if (addQuantity > 0) {
                            cart[addProduct - 1] = cart[addProduct - 1] + addQuantity;
                            System.out.println(productNames[addProduct - 1] + " added to cart.");
                        } else {
                            System.out.println("Quantity must be greater than 0.");
                        }
                    } else {
                        System.out.println("Invalid product number.");
                    }
                    break;

                case 3:
                    System.out.println("\n========== YOUR CART ==========");
                    boolean cartIsEmpty = true;

                    for (int i = 0; i < cart.length; i++) {
                        if (cart[i] > 0) {
                            System.out.println((i + 1) + ". " + productNames[i]
                                    + " x" + cart[i]);
                            cartIsEmpty = false;
                        }
                    }

                    if (cartIsEmpty) {
                        System.out.println("Your cart is empty.");
                    } else {
                        System.out.print("Enter product number to remove: ");
                        int removeProduct = scanner.nextInt();

                        if (removeProduct >= 1 && removeProduct <= 5
                                && cart[removeProduct - 1] > 0) {
                            System.out.print("Enter quantity to remove: ");
                            int removeQuantity = scanner.nextInt();

                            if (removeQuantity > 0) {
                                cart[removeProduct - 1] = cart[removeProduct - 1] - removeQuantity;

                                // Do not allow a negative cart quantity.
                                if (cart[removeProduct - 1] < 0) {
                                    cart[removeProduct - 1] = 0;
                                }
                                System.out.println(productNames[removeProduct - 1] + " updated in cart.");
                            } else {
                                System.out.println("Quantity must be greater than 0.");
                            }
                        } else {
                            System.out.println("This product is not in your cart.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n========== YOUR CART ==========");
                    int subtotal = 0;
                    boolean emptyCart = true;

                    for (int i = 0; i < cart.length; i++) {
                        if (cart[i] > 0) {
                            int itemTotal = productPrices[i] * cart[i];
                            System.out.println(productNames[i] + " x" + cart[i]
                                    + " = Rs." + itemTotal);
                            subtotal = subtotal + itemTotal;
                            emptyCart = false;
                        }
                    }

                    if (emptyCart) {
                        System.out.println("Your cart is empty.");
                    } else {
                        System.out.println("Subtotal: Rs." + subtotal);
                    }
                    break;

                case 5:
                    int total = 0;

                    for (int i = 0; i < cart.length; i++) {
                        total = total + (productPrices[i] * cart[i]);
                    }

                    if (total == 0) {
                        System.out.println("Your cart is empty.");
                    } else {
                        double discount = 0;

                        if (total >= 10000) {
                            discount = total * 0.10;
                        } else if (total >= 5000) {
                            discount = total * 0.05;
                        }

                        double finalAmount = total - discount;

                        System.out.println("\n========== BILL ==========");
                        System.out.println("Subtotal     : Rs." + total);
                        System.out.println("Discount     : Rs." + discount);
                        System.out.println("Final amount : Rs." + finalAmount);
                        System.out.println("Thank you for shopping!");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for shopping! Goodbye!");
                    break;

                default:
                    System.out.println("Please enter a number from 1 to 6.");
            }
        }

        scanner.close();
    }
}
