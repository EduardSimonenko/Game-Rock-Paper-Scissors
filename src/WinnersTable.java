import com.jakewharton.fliptables.FlipTableConverters;

public class WinnersTable {

    public static void getWinnersTable(String[] head) {
        if (head.length == 7) {
            String[] headears = {"PC \n User", head[0], head[1], head[2], head[3], head[4], head[5], head[6]};
            Object[][] data = {
                    {head[0], "DRAW", "WIN", "WIN", "WIN", "LOSE", "LOSE", "LOSE"},
                    {head[1], "LOSE", "DRAW", "WIN", "WIN", "WIN", "LOSE", "LOSE"},
                    {head[2], "LOSE", "LOSE", "DRAW", "WIN", "WIN", "WIN", "LOSE"},
                    {head[3], "LOSE", "LOSE", "LOSE", "DRAW", "WIN", "WIN", "WIN"},
                    {head[4], "WIN", "LOSE", "LOSE", "LOSE", "DRAW", "WIN", "WIN"},
                    {head[5], "WIN", "WIN", "LOSE", "LOSE", "LOSE", "DRAW", "WIN"},
                    {head[6], "WIN", "WIN", "WIN", "LOSE", "LOSE", "LOSE", "DRAW"}

            };
            System.out.println(FlipTableConverters.fromObjects(headears, data));
        } else if (head.length == 3) {
            String[] headears = {"PC \n User", head[0], head[1], head[2]};
            Object[][] data = {
                    {head[0], "DRAW", "WIN", "LOSE"},
                    {head[1], "LOSE", "DRAW", "WIN"},
                    {head[2], "WIN", "LOSE", "DRAW"},
            };
            System.out.println(FlipTableConverters.fromObjects(headears, data));
        } else if (head.length == 5) {
            String[] headears = {"PC \n User", head[0], head[1], head[2], head[3], head[4]};
            Object[][] data = {
                    {head[0], "DRAW", "WIN", "WIN", "LOSE", "LOSE"},
                    {head[1], "LOSE", "DRAW", "WIN", "WIN", "LOSE"},
                    {head[2], "LOSE", "LOSE", "DRAW", "WIN", "WIN"},
                    {head[3], "WIN", "LOSE", "LOSE", "DRAW", "WIN"},
                    {head[4], "WIN", "WIN", "LOSE", "LOSE", "DRAW"},
            };
            System.out.println(FlipTableConverters.fromObjects(headears, data));
        }
}}