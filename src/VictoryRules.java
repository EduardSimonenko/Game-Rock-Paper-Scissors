public class VictoryRules {

    public static void getWinner(int yourMove, int computerMove, String[] str) {
        int m = str.length / 2;
        if (yourMove == computerMove) {
            System.out.println("Tie");
        } else if ((yourMove < computerMove && Math.abs(yourMove - computerMove) <= m) || (yourMove > computerMove && yourMove - computerMove > m)) {
            System.out.println("you loss");
        } else System.out.println(("you won!!!"));

    }
}
