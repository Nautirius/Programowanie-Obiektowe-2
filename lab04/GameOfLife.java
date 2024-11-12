import java.util.Random;

public class GameOfLife {
    private int sizeX, sizeY, steps;
    private int[][] board;

    public GameOfLife(int sizeX, int sizeY, int steps, int preset) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.steps = steps;
        // Tworzymy planszę o rozmiarze (sizeX + 2) x (sizeY + 2), aby dodać martwą warstwę
        board = new int[sizeX + 2][sizeY + 2];
        initializeBoard(preset);
    }

    private void initializeBoard(int preset) {
        switch (preset) {
            case 0:
                Random random = new Random();
                for (int i = 1; i <= sizeX; i++) {
                    for (int j = 1; j <= sizeY; j++) {
                        board[i][j] = random.nextBoolean() ? 1 : 0;
                    }
                }
                break;
            case 1: // Łódź
                if (sizeX >= 5 && sizeY >= 5) {
                    board[sizeX / 2][sizeY / 2] = 1;
                    board[sizeX / 2][sizeY / 2 + 1] = 1;
                    board[sizeX / 2 + 1][sizeY / 2] = 1;
                    board[sizeX / 2 + 1][sizeY / 2 + 2] = 1;
                    board[sizeX / 2 + 2][sizeY / 2 + 1] = 1;
                }
                break;
            case 2: // Blinker
                if (sizeX >= 5 && sizeY >= 5) {
                    board[sizeX / 2][sizeY / 2] = 1;
                    board[sizeX / 2 + 1][sizeY / 2] = 1;
                    board[sizeX / 2 - 1][sizeY / 2] = 1;
                }
                break;
            case 3: // Szybowiec
                if (sizeX >= 5 && sizeY >= 5) {
                    board[sizeX / 2][sizeY / 2 + 1] = 1;
                    board[sizeX / 2][sizeY / 2 - 1] = 1;
                    board[sizeX / 2 + 1][sizeY / 2] = 1;
                    board[sizeX / 2 + 1][sizeY / 2 + 1] = 1;
                    board[sizeX / 2 - 1][sizeY / 2] = 1;
                }
                break;
            default:
                System.out.println("Nieprawidłowy preset.");
                System.exit(1);
        }
    }

    private void simulate() {
        for (int step = 1; step <= steps; step++) {
            System.out.println("------ " + step + " --------");
            printBoard();
            board = nextGeneration();
        }
    }

    private int[][] nextGeneration() {
        int[][] newBoard = new int[sizeX + 2][sizeY + 2];

        for (int i = 1; i <= sizeX; i++) {
            for (int j = 1; j <= sizeY; j++) {
                int aliveNeighbors = countAliveNeighbors(i, j);

                // Reguły gry
                if (board[i][j] == 1) { // żywa komórka
                    if (aliveNeighbors == 2 || aliveNeighbors == 3) {
                        newBoard[i][j] = 1; // pozostaje żywa
                    } else {
                        newBoard[i][j] = 0; // umiera
                    }
                } else { // martwa komórka
                    if (aliveNeighbors == 3) {
                        newBoard[i][j] = 1; // staje się żywa
                    } else {
                        newBoard[i][j] = 0; // pozostaje martwa
                    }
                }
            }
        }

        return newBoard;
    }

    private int countAliveNeighbors(int x, int y) {
        int aliveCount = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // pomijamy samą komórkę
                aliveCount += board[x + i][y + j];
            }
        }

        return aliveCount;
    }

    private void printBoard() {
        for (int i = 1; i <= sizeX; i++) {
            for (int j = 1; j <= sizeY; j++) {
                System.out.print(board[i][j] == 1 ? "X" : ".");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java GraWZycie size_x size_y steps preset");
            return;
        }

        int sizeX = Integer.parseInt(args[0]);
        int sizeY = Integer.parseInt(args[1]);
        int steps = Integer.parseInt(args[2]);
        int preset = Integer.parseInt(args[3]);

        GraWZycie game = new GraWZycie(sizeX, sizeY, steps, preset);
        game.simulate();
    }
}
