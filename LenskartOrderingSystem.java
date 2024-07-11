import java.util.*;

public class LenskartOrderingSystem {

    static Scanner scanner = new Scanner(System.in);
    static Map<String, String> users = new HashMap<>();
    static Map<String, OrderDetails> orders = new HashMap<>();
    static String currentUser = null;

    static List<String> lensShapes = Arrays.asList("Round", "Square", "Oval", "Rectangle", "Cat Eye");
    static List<String> frameShapes = Arrays.asList("Full Rim", "Half Rim", "Rimless", "Clip-on", "Sports");
    static List<String> colors = Arrays.asList("Black", "Blue", "Red", "Green", "Yellow", "Brown", "Purple", "Pink", "Orange", "White");
    static List<String> lensTypes = Arrays.asList("BlueReace", "UVRace", "AntiGlare", "PhotoChromatic", "Polarized");
    static List<String> priceRanges = Arrays.asList("1000-2000", "2000-3000", "3000-4000");

    public static void main(String[] args) {
        users.put("admin", "admin"); // default user
        orders.put("admin", new OrderDetails("No orders placed yet", 0));

        while (true) {
            showLoginMenu();
        }
    }

    public static void showLoginMenu() {
        System.out.println("\n********************************************");
        System.out.println("*          Welcome to Lenskart             *");
        System.out.println("********************************************");
        System.out.println("1. Login");
        System.out.println("2. Create Account");
        System.out.println("3. Forgot Password");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                createAccount();
                break;
            case 3:
                forgotPassword();
                break;
            case 4:
                System.out.println("Exiting the system. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            currentUser = username;
            System.out.println("Login successful! Welcome, " + username);
            showHomePage();
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    public static void createAccount() {
        System.out.print("Enter a new username: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please try again.");
            return;
        }
        System.out.print("Enter a new password: ");
        String password = scanner.nextLine();
        users.put(username, password);
        orders.put(username, new OrderDetails("No orders placed yet", 0));
        System.out.println("Account created successfully!");
    }

    public static void forgotPassword() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.print("Enter your new password: ");
            String newPassword = scanner.nextLine();
            users.put(username, newPassword);
            System.out.println("Password reset successful!");
        } else {
            System.out.println("Username not found. Please try again.");
        }
    }

    public static void showHomePage() {
        while (true) {
            System.out.println("\n********************************************");
            System.out.println("*                  Home Page               *");
            System.out.println("********************************************");
            System.out.println("1. View Products");
            System.out.println("2. Place Order");
            System.out.println("3. View Orders");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    placeOrder();
                    break;
                case 3:
                    viewOrders();
                    break;
                case 4:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void viewProducts() {
        System.out.println("\n********************************************");
        System.out.println("*              Available Products          *");
        System.out.println("********************************************");

        System.out.println("Lens Shapes:");
        int lensShapeNum = 1;
        for (String shape : lensShapes) {
            System.out.println(lensShapeNum + ". " + shape);
            lensShapeNum++;
        }

        System.out.println("\nFrame Shapes:");
        int frameShapeNum = 1;
        for (String shape : frameShapes) {
            System.out.println(frameShapeNum + ". " + shape);
            frameShapeNum++;
        }

        System.out.println("\nColors:");
        int colorNum = 1;
        for (String color : colors) {
            System.out.println(colorNum + ". " + color);
            colorNum++;
        }

        System.out.println("\nLens Types:");
        int lensTypeNum = 1;
        for (String type : lensTypes) {
            System.out.println(lensTypeNum + ". " + type);
            lensTypeNum++;
        }

        System.out.println("\nPrice Ranges:");
        int priceRangeNum = 1;
        for (String range : priceRanges) {
            System.out.println(priceRangeNum + ". " + range);
            priceRangeNum++;
        }
    }

    public static void placeOrder() {
        System.out.println("\n********************************************");
        System.out.println("*               Place Your Order           *");
        System.out.println("********************************************");

        System.out.println("Available Products:");
        viewProducts();

        System.out.println("\nEnter your choices for the following:");

        System.out.print("Lens Shape (choose a number): ");
        int lensShapeChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (lensShapeChoice < 1 || lensShapeChoice > lensShapes.size()) {
            System.out.println("Invalid Lens Shape choice.");
            return;
        }
        String lensShape = lensShapes.get(lensShapeChoice - 1);

        System.out.print("Frame Shape (choose a number): ");
        int frameShapeChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (frameShapeChoice < 1 || frameShapeChoice > frameShapes.size()) {
            System.out.println("Invalid Frame Shape choice.");
            return;
        }
        String frameShape = frameShapes.get(frameShapeChoice - 1);

        System.out.print("Color (choose a number): ");
        int colorChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (colorChoice < 1 || colorChoice > colors.size()) {
            System.out.println("Invalid Color choice.");
            return;
        }
        String color = colors.get(colorChoice - 1);

        System.out.print("Lens Type (choose a number): ");
        int lensTypeChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (lensTypeChoice < 1 || lensTypeChoice > lensTypes.size()) {
            System.out.println("Invalid Lens Type choice.");
            return;
        }
        String lensType = lensTypes.get(lensTypeChoice - 1);

        System.out.print("Price Range (choose a number): ");
        int priceRangeChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (priceRangeChoice < 1 || priceRangeChoice > priceRanges.size()) {
            System.out.println("Invalid Price Range choice.");
            return;
        }
        String priceRange = priceRanges.get(priceRangeChoice - 1);

        System.out.print("Enter the power for the left eye (+ or -): ");
        String leftEyePower = scanner.nextLine();

        System.out.print("Enter the power for the right eye (+ or -): ");
        String rightEyePower = scanner.nextLine();

        // Check if all fields are filled
        if (leftEyePower.isEmpty() || rightEyePower.isEmpty()) {
            System.out.println("You have not completed all fields. Please fill all required fields.");
            return;
        }

        // Generate a random total amount for the order
        Random random = new Random();
        int totalAmount = random.nextInt(3000 - 1000 + 1) + 1000; // Random amount between 1000 and 3000

        String orderDetails = String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s",
                lensShape, frameShape, color, lensType, priceRange, leftEyePower, rightEyePower);
        orders.put(currentUser, new OrderDetails(orderDetails, totalAmount));

        System.out.println("\nOrder placed successfully!");
        System.out.println("Total Amount: $" + totalAmount);
    }

    public static void viewOrders() {
        System.out.println("\n********************************************");
        System.out.println("*               Your Orders                *");
        System.out.println("********************************************");
        System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s",
                "Lens Shape", "Frame Shape", "Color", "Lens Type", "Price Range", "Left Power", "Right Power"));
        System.out.println("--------------------------------------------------------------------------------------------------");

        OrderDetails orderDetails = orders.get(currentUser);
        if (orderDetails != null) {
            System.out.println(orderDetails.getDetails());
            System.out.println("Total Amount: $" + orderDetails.getTotalAmount());
        } else {
            System.out.println("No orders placed yet.");
        }
    }

    static class OrderDetails {
        String details;
        int totalAmount;

        public OrderDetails(String details, int totalAmount) {
            this.details = details;
            this.totalAmount = totalAmount;
        }

        public String getDetails() {
            return details;
        }

        public int getTotalAmount() {
            return totalAmount;
        }
    }
}
