import java.util.Random;

/**
 * Klasa GameOfLife
 *
 * Symuluje grę Game of Life
 *
 * @author Marcin Knapczyk
 * @version 1.0
 */
public class GameOfLife {
    private int sizeX, sizeY, steps;
    private int[][] gameBoard;

    public GameOfLife(int sizeX, int sizeY, int steps, int preset) {
        if(sizeX < 5 || sizeY < 5) throw new IllegalArgumentException("size_x i size_y powinny mieć wartość co najmniej 5");
        if (preset < 0 || preset > 3) throw new IllegalArgumentException("preset powinien być z zakresu (0,3)");
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.steps = steps;
        gameBoard = new int[sizeX + 2][sizeY + 2]; // +2 na martwą warstwę
        initializeGameBoard(preset);
    }

    private void initializeGameBoard(int preset) {
        switch (preset) {
            case 0: // Losowe ułożenie
                Random random = new Random();
                for (int i = 1; i <= sizeX; i++) {
                    for (int j = 1; j <= sizeY; j++) {
                        gameBoard[i][j] = random.nextBoolean() ? 1 : 0;
                    }
                }
                break;
            case 1: // Łódź
                gameBoard[sizeX / 2][sizeY / 2] = 1;
                gameBoard[sizeX / 2][sizeY / 2 + 1] = 1;
                gameBoard[sizeX / 2 + 1][sizeY / 2] = 1;
                gameBoard[sizeX / 2 + 1][sizeY / 2 + 2] = 1;
                gameBoard[sizeX / 2 + 2][sizeY / 2 + 1] = 1;
                break;
            case 2: // Blinker
                gameBoard[sizeX / 2 + 1][sizeY / 2 + 1] = 1;
                gameBoard[sizeX / 2 + 2][sizeY / 2 + 1] = 1;
                gameBoard[sizeX / 2][sizeY / 2 + 1] = 1;
                break;
            case 3: // Szybowiec
                gameBoard[sizeX / 2 - 1 + 1][sizeY / 2 - 1 + 1] = 1;
                gameBoard[sizeX / 2 - 1 + 1][sizeY / 2 + 1] = 1;
                gameBoard[sizeX / 2 - 1 + 1][sizeY / 2 + 1 + 1] = 1;
                gameBoard[sizeX / 2 + 1][sizeY / 2 - 1 + 1] = 1;
                gameBoard[sizeX / 2 + 1 + 1][sizeY / 2 + 1] = 1;
                break;
            default:
                System.out.println("Nieprawidłowy preset (podaj wartość 0-3)");
                break;
        }
    }

    public void simulate() {
        for (int step = 1; step <= steps; step++) {
            System.out.println("------- " + step + " ---------");
            printGameBoard();
            gameBoard = getNextGenBoard();
        }
    }

    private int[][] getNextGenBoard() {
        int[][] newGameBoard = new int[sizeX + 2][sizeY + 2];

        for (int i = 1; i <= sizeX; i++) {
            for (int j = 1; j <= sizeY; j++) {
                int aliveNeighborsCount = countAliveNeighbors(i, j);

                if (gameBoard[i][j] == 1) {
                    if (aliveNeighborsCount == 2 || aliveNeighborsCount == 3) {
                        newGameBoard[i][j] = 1;
                    } else {
                        newGameBoard[i][j] = 0;
                    }
                } else {
                    if (aliveNeighborsCount == 3) {
                        newGameBoard[i][j] = 1;
                    } else {
                        newGameBoard[i][j] = 0;
                    }
                }
            }
        }

        return newGameBoard;
    }

    private int countAliveNeighbors(int x, int y) {
        int aliveCount = 0;

        // idziemy dookoła komórki (+-1)
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // ta sama komórka
                aliveCount += gameBoard[x + i][y + j];
            }
        }

        return aliveCount;
    }

    private void printGameBoard() {
        for (int i = 1; i <= sizeX; i++) {
            for (int j = 1; j <= sizeY; j++) {
                System.out.print(gameBoard[i][j] == 1 ? "X" : ".");
            }
            System.out.println();
        }
    }
}
