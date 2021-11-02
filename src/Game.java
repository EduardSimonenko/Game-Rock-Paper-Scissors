import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {

        String key = GenKey.generator();
        String[] str = getStrings();
        int computerMove = (int) (Math.random() * str.length);

        String hmac = GenKey.calculateHMAC(str[computerMove], key);
        System.out.println("HMAC: " + hmac);
        menuOutput(str);

        int yourMove = getPlayerMove(str) - 1;
        System.out.println("computer move: " + str[computerMove]);
        System.out.println("HMAC key:" + key);

        VictoryRules.getWinner(yourMove, computerMove, str);

    }

    static String[] getStrings() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the names of the moves  >= 3 ");

        while (true) {
            String str = in.nextLine();
            String[] substr;
            String delimeter = " ";
            substr = str.split(delimeter);
            if (substr.length >= 3 && substr.length % 2 != 0) {
                return substr;
            } else {
                System.out.print("Enter correct values ");
            }
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


