import java.io.*;


public class lab08 {
    public static void main(String[] args) {
        String inputFile = "";
        String outputFile = "";
        try {
            if (args.length != 2) {
                throw new IllegalArgumentException("Nieprawidłowe parametry. Parametry programu: [nazwa pliku z danymi] [nazwa pliku wynikowego]");
            }

            inputFile = args[0];
            outputFile = args[1];
        } catch (IllegalArgumentException e) {
            System.err.println("Błąd: " + e.getMessage());
            System.exit(1);
        }


        try (BufferedReader in = new BufferedReader(new FileReader(inputFile));
             BufferedWriter out = new BufferedWriter(new FileWriter(outputFile))) {

            int sum = 0;
            int count = 0;
            String line;
            int lineNumber = 0;

            while ((line = in.readLine()) != null) {
                lineNumber++;
                try {
                    int number = Integer.parseInt(line.trim());
                    sum += number;
                    count++;
                } catch (NumberFormatException e) {
                    System.err.println("Błąd: Niepoprawny format liczby w linii " + lineNumber + ": \"" + line + "\"");
                    System.exit(1);
                }
            }

            if (count == 0) {
                System.err.println("Błąd: Plik wejściowy nie zawiera żadnych liczb.");
                System.exit(1);
            }

            double average = (double) sum / count;
            out.write("Średnia: " + average);
            System.out.println("Średnia została zapisana do pliku: " + outputFile);

        } catch (FileNotFoundException e) {
            System.err.println("Błąd: Nie udało się otworzyć pliku z danymi. Upewnij się, że plik istnieje: " + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Błąd: Problem z operacjami wejścia/wyjścia: " + e.getMessage());
            System.exit(1);
        }
    }
}
