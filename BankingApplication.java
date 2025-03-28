import java.util.HashSet;
import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        HashSet<Integer> accountNumbers = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBanking Application");
            System.out.println("1. Add Account Number");
            System.out.println("2. Remove Account Number");
            System.out.println("3. Check Account Number");
            System.out.println("4. View All Account Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Add Account Number
                    System.out.print("Enter account number to add: ");
                    int accountToAdd = scanner.nextInt();
                    if (accountNumbers.add(accountToAdd)) {
                        System.out.println("Account number added successfully!");
                    } else {
                        System.out.println("Account number already exists!");
                    }
                    break;

                case 2: // Remove Account Number
                    System.out.print("Enter account number to remove: ");
                    int accountToRemove = scanner.nextInt();
                    if (accountNumbers.remove(accountToRemove)) {
                        System.out.println("Account number removed successfully!");
                    } else {
                        System.out.println("Account number not found!");
                    }
                    break;

                case 3: // Check Account Number
                    System.out.print("Enter account number to check: ");
                    int accountToCheck = scanner.nextInt();
                    if (accountNumbers.contains(accountToCheck)) {
                        System.out.println("Account number exists in the system!");
                    } else {
                        System.out.println("Account number does not exist!");
                    }
                    break;

                case 4: // View All Account Numbers
                    System.out.println("Account numbers: " + accountNumbers);
                    break;

                case 5: // Exit
                    System.out.println("Exiting the system. Have a great day!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
