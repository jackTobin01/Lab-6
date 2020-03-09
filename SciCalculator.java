import java.util.Scanner;

public class SciCalculator {
    public static Scanner scanner = new Scanner(System.in);
    public static int oper = 0, counter = 0;
    public static double endRes = 0.0, avg = 0.0, totalValue = 0.0;

    // Making this change for Lab 6, adding comment
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        // prints out menu display
        System.out.println("Current Result: " + endRes);
        System.out.println("Calculator Menu");
        System.out.println("---------------");
        System.out.println("0. Exit Program");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exponentiation");
        System.out.println("6. Logarithm");
        System.out.println("7. Display Average");
        System.out.println("Enter Menu Selection: ");
        oper = scanner.nextInt();
        numCalc();
    }

    public static void numCalc() {
        //determines which operation will be used, prevents inputs not with range of 0 to 7
        if (oper == 0){
            System.out.println("Thanks for using this calculator. Goodbye!");
        }
        else if (oper < 0 || oper > 7){
            System.out.println("Error: Invalid selection!");
            System.out.println("Enter Menu Selection: ");
            oper = scanner.nextInt();
            numCalc();
        }
        else {
            operations();
        }
    }

    public static void operations() {
        double num1 = 0.0, num2 = 0.0;
        if (oper >= 1 && oper <=6) {
            System.out.println("Enter first operand: ");
            num1 = scanner.nextDouble();
            System.out.println("Enter second operand: ");
            num2 = scanner.nextDouble();
        }
        if (oper == 1) {
            endRes = num1 + num2;
            mainMenu();
        }
        else if (oper == 2){
            endRes = num1 - num2;
            mainMenu();
        }
        else if (oper == 3){
            endRes = num1 * num2;
            mainMenu();
        }
        else if (oper == 4){
            endRes = num1 / num2;
            mainMenu();
        }
        else if (oper == 5){
            double placeHld = 1.0;
            while (num2 > 0){
                placeHld = placeHld * num1;
                num2 --;
            }
            endRes = placeHld;
            mainMenu();
        }
        else if (oper == 6){
            endRes = Math.log(num2) / Math.log(num1);
            mainMenu();
        }

        totalValue = totalValue + endRes;
        counter ++;

        if (oper == 7){
            if (totalValue == 0){
                System.out.println("Error: No calculations yet to average!");
                System.out.println("Enter Menu Selection: ");
                oper = scanner.nextInt();
                numCalc();
            }
            else {
                System.out.println("Sum of calculations: " + totalValue);
                System.out.println("Number of calculations: " + counter);
                System.out.println("Average of calculations: " + totalValue/counter);
                mainMenu();
            }
        }
    }
}
