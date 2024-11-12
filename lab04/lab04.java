public class lab04
{
    public static void main(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Nieprawidłowe parametry. Parametry programu: size_x size_y steps preset");
        }

        int sizeX = Integer.parseInt(args[0]);
        int sizeY = Integer.parseInt(args[1]);
        int steps = Integer.parseInt(args[2]);
        int preset = Integer.parseInt(args[3]);

        GameOfLife game = new GameOfLife(sizeX, sizeY, steps, preset);
        game.simulate();
    }
}