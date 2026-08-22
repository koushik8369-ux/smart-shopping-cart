import java.util.Scanner;

public class InvoiceGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Customer details
        System.out.println("========== INVOICE GENERATOR ==========");

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        while (customerName.trim().isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            System.out.print("Enter customer name: ");
            customerName = sc.nextLine();
        }

        System.out.print("Enter invoice number: ");
        String invoiceNumber = sc.nextLine();

        while (invoiceNumber.trim().isEmpty()) {
            System.out.println("Invoice number cannot be empty.");
            System.out.print("Enter invoice number: ");
            invoiceNumber = sc.nextLine();
        }

        // Number of products
        int n;

        do {
            System.out.print("Enter number of products: ");
            n = sc.nextInt();

            if (n <= 0) {
                System.out.println("Invalid! Number of products must be greater than 0.");
            }

        } while (n <= 0);

        sc.nextLine();

        String[] productNames = new String[n];
        double[] prices = new double[n];
        int[] quantities = new int[n];
        double[] productTotals = new double[n];

        // Product input
        for (int i = 0; i < n; i++) {

            System.out.println("\nProduct " + (i + 1));

            // Product name
            do {
                System.out.print("Enter product name: ");
                productNames[i] = sc.nextLine();

                if (productNames[i].trim().isEmpty()) {
                    System.out.println("Product name cannot be empty.");
                }

            } while (productNames[i].trim().isEmpty());

            // Price
            do {
                System.out.print("Enter price: ");
                prices[i] = sc.nextDouble();

                if (prices[i] <= 0) {
                    System.out.println("Invalid! Price must be greater than 0.");
                }

            } while (prices[i] <= 0);

            // Quantity
            do {
                System.out.print("Enter quantity: ");
                quantities[i] = sc.nextInt();

                if (quantities[i] <= 0) {
                    System.out.println("Invalid! Quantity must be greater than 0.");
                }

            } while (quantities[i] <= 0);

            sc.nextLine();
        }

        // Calculate product totals and subtotal
        double subtotal = 0;

        for (int i = 0; i < n; i++) {

            productTotals[i] = prices[i] * quantities[i];

            subtotal = subtotal + productTotals[i];
        }

        // Discount calculation
        double discountRate;

        if (subtotal >= 5000) {
            discountRate = 0.15;
        } else if (subtotal >= 3000) {
            discountRate = 0.10;
        } else if (subtotal >= 1000) {
            discountRate = 0.05;
        } else {
            discountRate = 0;
        }

        double discount = subtotal * discountRate;

        double afterDiscount = subtotal - discount;

        // Tax calculation
        double taxRate = 0.05;

        double tax = afterDiscount * taxRate;

        // Final amount
        double finalAmount = afterDiscount + tax;

        // Display invoice
        System.out.println("\n\n==============================================");
        System.out.println("              SMART INVOICE");
        System.out.println("==============================================");

        System.out.println("Customer      : " + customerName);
        System.out.println("Invoice No.   : " + invoiceNumber);

        System.out.println("----------------------------------------------");

        System.out.printf("%-20s %-10s %-8s %-12s%n",
                "Product", "Price", "Qty", "Total");

        System.out.println("----------------------------------------------");

        for (int i = 0; i < n; i++) {

            System.out.printf(
                    "%-20s ₹%-9.2f %-8d ₹%-11.2f%n",
                    productNames[i],
                    prices[i],
                    quantities[i],
                    productTotals[i]
            );
        }

        System.out.println("----------------------------------------------");

        System.out.printf("Subtotal       : ₹%.2f%n", subtotal);
        System.out.printf("Discount       : ₹%.2f%n", discount);
        System.out.printf("After Discount : ₹%.2f%n", afterDiscount);
        System.out.printf("Tax (5%%)       : ₹%.2f%n", tax);

        System.out.println("----------------------------------------------");

        System.out.printf("FINAL AMOUNT   : ₹%.2f%n", finalAmount);

        System.out.println("==============================================");
        System.out.println("        Thank you for your purchase!");
        System.out.println("==============================================");

        sc.close();
    }
}