package com.example.HiberTest.FileHandler;

import java.nio.file.Path;

public interface directoryCreater {
    Path createFileDirectory(String fileName);

    Path getFileDerictory(String fileName);

    Path moveFile(Path sourcePath,String fileName);
}
