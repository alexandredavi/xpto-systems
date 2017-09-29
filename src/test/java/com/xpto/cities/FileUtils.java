package com.xpto.cities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {

	private FileUtils() {

	}

	public static File readFile(final String filename) {
		ClassLoader classLoader = new FileUtils().getClass().getClassLoader();
		return new File(classLoader.getResource(filename).getFile());
	}

    public static String readTextFile(final String filename) {
        try {
            ClassLoader classLoader = new FileUtils().getClass().getClassLoader();
            File file = new File(classLoader.getResource(filename).getFile());
            return new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}