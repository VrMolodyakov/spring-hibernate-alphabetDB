package com.example.HiberTest.FileHandler;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class dirCreatorImpl implements directoryCreater{
    @Override
    public Path createFileDirectory(String fileName) {
        Path deskPath = Paths.get(System.getProperty("user.home") + "\\desktop");
        Path dirPath = getFileDerictory(fileName);
        dirPath = deskPath.resolve(dirPath);
        try {
            return Files.createDirectories(dirPath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public Path getFileDerictory(String fileName) {
        String firstThousand = fileName.substring(0,3);
        String secondThousand = fileName.substring(3,6);
        String thirdThousand = fileName.substring(6,9);

        return Paths.get(firstThousand,secondThousand,thirdThousand);

    }

    @Override
    public Path moveFile(Path sourcePath, String fileName) {


        try {
            String clearFileName;
            return Files.move(sourcePath,createFileDirectory(fileName).resolve(Paths.get(fileName)));

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }


    }
}
