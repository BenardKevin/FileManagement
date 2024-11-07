import javax.print.DocFlavor;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String fileInput = "C:\\Users\\IB\\Desktop\\fichier_entree.txt";
        String fileOutput = "C:\\Users\\IB\\Desktop\\fichier_sortie.txt";

        FileHandler handler = new FileHandler();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to file Management:\n 1 - Display file\n 2 - Copy file\n 3 - Copy file from keyword\n 4 - Update path\n 0 - Leave");

        menu(scanner, handler, fileInput, fileOutput);
    }

    private static void menu(Scanner scanner, FileHandler handler, String fileInput, String fileOutput) {
        System.out.print("\nSelect your option: ");

        String keyword;

        switch (scanner.nextLine()) {
            case "1" -> {
                System.out.print("\n1 - Display input\n2 - Display output\n3 - Display input from keyword\nSelect your display option: ");
                switch (scanner.nextLine()) {
                    case "1" -> handler.displayFile(fileInput);
                    case "2" -> handler.displayFile(fileOutput);
                    case "3" -> {
                        System.out.print("\nSelect your keyword: ");
                        keyword = scanner.nextLine();
                        handler.displayFileFromKeyword(fileInput, keyword);
                    }
                }
            }
            case "2" -> handler.copyFile(fileInput, fileOutput);
            case "3" -> {
                System.out.print("\nSelect your keyword: ");
                keyword = scanner.nextLine();
                handler.copyFileFromKeyword(fileInput, fileOutput, keyword);
            }
            case "4" -> {
                System.out.print("\n1 - Update input path\n2 - Update output path\n\nSelect which path to update: ");
                URL url;
                switch (scanner.nextLine()) {
                    case "1" -> {
                        System.out.print("\nEnter your new input path: ");
                        try {
                            url = Paths.get(scanner.nextLine()).toUri().toURL();
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }
                        fileInput = url.toString();
                    }
                    case "2" -> {
                        System.out.print("\nEnter your new output path: ");
                        try {
                            url = Paths.get(scanner.nextLine()).toUri().toURL();
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }
                        fileOutput = url.toString();
                    }
                }
            }
            case "0" -> {
                return;
            }
        }
        menu(scanner, handler, fileInput, fileOutput);
    }
}