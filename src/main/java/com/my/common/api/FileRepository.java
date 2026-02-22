package com.my.common.api;

import java.nio.file.Path;

/**
 * FileRepository interface for performing file operations such as saving, reading,
 * and deleting files. It provides an abstraction for handling file-related operations.
 */
public interface FileRepository {

    /**
     * Saves the file data to the specified path.
     *
     * @param data the byte array representing the file content to be saved
     * @param path the file path where the data should be saved
     *
     * Example:
     *  fileRepository.saveFile(fileData, "/uploads/image.png");
     */
    Path saveFile(byte[] data, Path path);

    /**
     * Reads the file from the specified path and returns its content as a byte array.
     *
     * @param path the file path from which to read the data
     * @return the byte array representing the file content, or null if the file doesn't exist
     *
     * Example:
     *  byte[] fileData = fileRepository.readFile("/uploads/image.png");
     */
    byte[] readFile(String path);

    /**
     * Deletes the file from the specified path.
     *
     * @param path the file path of the file to be deleted
     *
     * Example:
     *  fileRepository.deleteFile("/uploads/image.png");
     */
    void deleteFile(String path);
}

