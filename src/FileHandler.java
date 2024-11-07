import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public List<String> readFile(String filePath, String keyword) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (keyword.isEmpty() || line.contains(keyword)) lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erreur fichier non trouvé : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        return lines;
    }

    private int writeFile(String filePath, List<String> lines) {
        int i = 0;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(i + ". " + line + "\n");
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erreur fichier non inexistant : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        return i;
    }

    public void displayFile(String filePath) {
        List<String> lines = readFile(filePath, "");
        for (String line : lines) System.out.println(line);
    }

    public void displayFileFromKeyword(String filePath, String keyword) {
        List<String> lines = readFile(filePath, keyword);
        for (String line : lines) System.out.println(line);
    }

    public void copyFile(String fileInput, String fileOutput) {
        List<String> lines = readFile(fileInput, "");
        int i = writeFile(fileOutput, lines);
        System.out.print("File copied. ");
    }

    public void copyFileFromKeyword(String filePath, String fileOutput, String keyword) {
        List<String> lines = readFile(filePath, keyword);
        int i = writeFile(fileOutput, lines);
        if (i == 0) System.out.println("No line copied.");
        else System.out.printf("%d lines copied.\n", i);
    }
}
