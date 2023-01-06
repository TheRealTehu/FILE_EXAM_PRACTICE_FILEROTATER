package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRowRotater {
    private String path;

    public FileRowRotater(String path) {
        this.path = path;
    }

    public void rotateRows(){
        File file = new File(path);
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(rotateLine(scanner.nextLine()));
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        String newFilePath = getNewFilePath(path);
        String text = createText(lines);
        saveToFile(newFilePath, text);
    }

    private String createText(List<String> lines) {
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line).append("\n");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    private void saveToFile(String path, String text){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
            writer.write(text);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private String getNewFilePath(String path) {
        String stringToInsert = ".rotated";
        int startOfFileExtension = path.lastIndexOf('.');
        String start = path.substring(0, startOfFileExtension);
        String end = path.substring(startOfFileExtension);
        return start + stringToInsert + end;
    }

    private String rotateLine(String line) {
        int indexOfStartingLetter = findUpperCaseLetterPosition(line);
        String start = line.substring(indexOfStartingLetter);
        String end = line.substring(0, indexOfStartingLetter);
        return start + end;
    }

    private int findUpperCaseLetterPosition(String line) {
        char[] lineAsCharArray = line.toCharArray();
        for (int i = 0; i < line.length(); i++) {
            if (Character.isUpperCase(lineAsCharArray[i])) {
                return i;
            }
        }
        return -1;
    }
}
