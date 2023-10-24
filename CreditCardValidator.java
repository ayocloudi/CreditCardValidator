// Importing the scanner for user input
// The Luhn's Algorithm is a simple checksum formula used to validate identification numbers, most famously credit card numbers.
import java.util.Scanner;

public class CreditCardValidator {

    public static void main(String[] args) {
        // Scanner object for user input
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your card number please: ");
        
        // Allows user to enter a string for card number
        String cardNumber = sc.nextLine();
        


        // Prints out if the card is valid or invalid
        if (isValid(cardNumber)) {
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
        }
    }

    // This is our method where the main work is done
    // Using Luhn's Algorithm to check if the card number inputted by the user is valid
    public static boolean isValid(String cardNumber) {
        int sum = 0;
        
        // A flag to help us pick every second digit
        boolean doubleDigit = false; 
        
         // 1. Reverse Order: Start from the rightmost digit.
        
        // For loop to check string from the back to front
        // We'll start from the last digit and move towards the first
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            char currentChar = cardNumber.charAt(i);
            
            // Check if the current character is a digit
            if (!Character.isDigit(currentChar)) {
                return false; // Not a valid card number if it contains non-digit characters
            }
            
            //Here I am converting the Character into an Integer
            int digit = Integer.parseInt(String.valueOf(currentChar));

            //2. Double Every 2nd Digit: Double the value of every second digit.
            
            // Double the value of every second digit
            if (doubleDigit) {
                digit *= 2;
            
            //3. Adjust Digits Over 9: If doubling results in a number over 9, subtract 9

                // If doubling results in a number over 9, subtract 9
                if (digit > 9) {
                    digit -= 9;
                }
            }

            // 4. Sum All Digits: Add all the numbers together.

            // Add all the numbers together
            sum += digit;

            // Flip the flag for the next loop iteration
            doubleDigit = !doubleDigit;
        }
        
        //5. Check Divisibility: If the sum is divisible by 10, it's a valid number; if not, it's invalid.
        
        // Check if the total is a multiple of 10. If it is, the card number is valid!
        return sum % 10 == 0;
    }
}