import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nFil Manipulation Menu");
            System.out.println("1. Opret en fil");
            System.out.println("2. Læs en fil");
            System.out.println("3. Skriv til en fil");
            System.out.println("4. Slet en fil");
            System.out.println("5. Afslut");
            System.out.print("Vælg en mulighed: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Forbrug newline

            switch (choice) {
                case 1:
                    System.out.print("Indtast navnet på filen, der skal oprettes: ");
                    String createFileName = scanner.nextLine();
                    createFile(createFileName);
                    break;

                case 2:
                    System.out.print("Indtast navnet på filen, der skal læses: ");
                    String readFileName = scanner.nextLine();
                    readFile(readFileName);
                    break;

                case 3:
                    System.out.print("Indtast navnet på filen, der skal skrives til: ");
                    String writeFileName = scanner.nextLine();
                    System.out.print("Indtast teksten, der skal skrives til filen: ");
                    String content = scanner.nextLine();
                    writeFile(writeFileName, content);
                    break;

                case 4:
                    System.out.print("Indtast navnet på filen, der skal slettes: ");
                    String deleteFileName = scanner.nextLine();
                    deleteFile(deleteFileName);
                    break;

                case 5:
                    exit = true;
                    System.out.println("Afslutter programmet...");
                    break;

                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
                    break;
            }
        }
        scanner.close();
    }

    private static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("Filen " + fileName + " blev oprettet.");
            } else {
                System.out.println("Filen eksisterer allerede.");
            }
        } catch (IOException e) {
            System.out.println("En fejl opstod under oprettelse af filen: " + e.getMessage());
        }
    }

    private static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nIndhold af filen " + fileName + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("En fejl opstod under læsning af filen: " + e.getMessage());
        }
    }

    private static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            writer.newLine();
            System.out.println("Tekst blev skrevet til filen " + fileName + ".");
        } catch (IOException e) {
            System.out.println("En fejl opstod under skrivning til filen: " + e.getMessage());
        }
    }

    private static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("Filen " + fileName + " blev slettet.");
        } else {
            System.out.println("Filen kunne ikke slettes. Kontroller, om den eksisterer.");
        }
    }
}
