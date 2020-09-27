import java.util.Scanner;

class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            String numberString;
            try {
                numberString = scanner.nextLine();
            } catch (Exception e) {
                return;
            }

            if (numberString.equals("0")) {
                return;
            }

            int number;
            try {
                number = Integer.parseInt(numberString);
                System.out.println(number * 10);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + numberString);
            }
        }
    }
}