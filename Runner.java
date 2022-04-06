/**
 * Runner
 */
public class Runner {

    public static void main(String[] args) {

        GolBoard game = new GolBoard(20, 20);

        game.set(12, 10, true);
        game.set(12, 11, true);
        game.set(13, 10, true);
        game.set(13, 12, true);
        game.set(14, 10, true);

        for (int i = 0; i < 50; i++) {

            game.printBoard();
            game.play(1);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
