/**
 * Eden Yemini
 * Gilad Yehuda
 */

/**
 * Runner
 */
public class Runner {

    public static void main(String[] args) {

        // Use a string to load a file, or two numbers for a custom board
        GolBoard game = new GolBoard("GliderGunSmall.txt");

        // Iterate over 50 turns
        for (int i = 0; i < 50; i++) {

            game.printBoard();
            game.play(1); // Note: You can play more than one turn at a time! :)

            // Little delay so you can see the board on each iteration
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
