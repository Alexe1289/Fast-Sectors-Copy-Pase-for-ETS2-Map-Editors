package model;

import data.PathIO;
import exceptions.FileNotFoundException;
import exceptions.InvalidInputPathException;
import exceptions.InvalidPatternException;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppModel {
    private final PathIO inputPath;
    private final PathIO outputPath;

    private String presetName = null;

    private DefaultListModel<String> sectors;

    public AppModel() {
        this.sectors = new DefaultListModel<>();
        this.inputPath = new PathIO();
        this.outputPath = new PathIO();
    }

    public AppModel(PathIO inputPath, PathIO outputPath, String presetName,
                    DefaultListModel<String> sectors) {
        this.sectors = sectors;
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.presetName = presetName;
    }

    public void copyPaste(boolean replaceIfExists) throws IOException {
        Path source = Paths.get(inputPath.getPathName());
        Path dest = Paths.get(outputPath.getPathName());
        Files.walk(source)
                .filter(Files::isRegularFile)
                .filter(path -> {
                    String fileName = path.getFileName().toString();
                    return sectors.contains(fileName);
                })
                .forEach(file -> {
                    try {
                        Path relativePath = source.relativize(file);
                        Path destinationPath = dest.resolve(relativePath);
                        if (replaceIfExists) {
                            Files.copy(file, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                        } else {
                            Files.copy(file, destinationPath);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Unexpected error at copying files.");
                    }
                });

    }

    public DefaultListModel<String> processSector(String sectorName, JTextField inputField) throws Exception {
        if (inputField.getText() == null) {
            throw new InvalidInputPathException();
        }
        validatePattern(sectorName);
        return findSectors(sectorName);
    }



    private void validatePattern(String text) throws Exception {
        String pattern = "[+\\-]\\d{4}[+\\-]\\d{4}";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        if (!m.matches()) {
            throw new InvalidPatternException();
        }
    }

    private DefaultListModel<String> findSectors(String sectorName) throws Exception {
        File directory = new File(inputPath.getPathName());
        if (!(directory.exists() && directory.isDirectory())) {
            throw new InvalidInputPathException();
        }

        String prefix = "sec" + sectorName;
        DefaultListModel<String> sectors = new DefaultListModel<String>();

        for (File file : directory.listFiles()) {
            if (file.getName().startsWith(prefix)) {
                sectors.addElement(file.getName());
            }
        }
        if (sectors.isEmpty()) {
            throw new FileNotFoundException();
        }
        return sectors;
    }

    public DefaultListModel<String> getSectors() {
        return sectors;
    }

    public void setSectors(DefaultListModel<String> sectors) {
        this.sectors = sectors;
    }

    public PathIO getInputPath() {
        return inputPath;
    }

    public PathIO getOutputPath() {
        return outputPath;
    }

    public String getPresetName() {
        return presetName;
    }

    public void setPresetName(String presetName) {
        this.presetName = presetName;
    }
}
