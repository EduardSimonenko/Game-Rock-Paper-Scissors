import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {

        getStrings(args);
        String key = GenKey.generator();
        String[] str = args;
        int computerMove = (int) (Math.random() * str.length);

        String hmac = GenKey.calculateHMAC(str[computerMove], key);
        System.out.println("HMAC: " + hmac);
        menuOutput(str);

        int yourMove = getPlayerMove(str) - 1;
        System.out.println("computer move: " + str[computerMove]);
        System.out.println("HMAC key:" + key);

        VictoryRules.getWinner(yourMove, computerMove, str);

    }

    static void getStrings(String [] args) {

        if (args.length < 3 || args.length % 2 == 0) {
            System.out.println("Error, count of elements must be >=3 and be odd number");
            System.out.println("Example: rock paper scissors lizard Spock");

            System.exit(0);
        }
    }


    static int getPlayerMove(String[] str) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your move: ");
        int a = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                a = scanner.nextInt();
                if (a == 0) {
                    System.exit(0);
                } else if (a > 0 && a <= str.length) {
                    System.out.println("Your move: " + str[a - 1]);
                    break;
                }
            } else if (scanner.next().equals("?")) {
                WinnersTable.getWinnersTable(str);
                System.exit(0);
            }
            menuOutput(str);
            System.out.print("Enter your move: ");

        }
        return a;
    }


    static void menuOutput(String[] str) {
        System.out.println("Available moves:");
        for (int i = 0, a = 1; i < str.length; i++, a++) {
            System.out.println(a + " - " + str[i]);
        }
        System.out.println(0 + " - exit");
        System.out.println("? - help");
    }
}


