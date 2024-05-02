package com.mugi;

import java.io.File;

/**
 * created on 02/05/2024
 *
 * @author Mugi
 */
public class RenameFolderFiles {
    public static void main(String[] args) {
        // Specify the path to the folder containing the files
        String folderPath = "/Volumes/saqlever/Grauchi";

        // Create a File object representing the folder
        File folder = new File(folderPath);

        // Check if the specified path is a directory
        if (folder.isDirectory()) {
            // Get all files in the directory
            File[] files = folder.listFiles();

            // Iterate through each file and rename it
            if (files != null) {
                for (File file : files) {
                    // Specify the new file name (you can modify this as needed)
//                    DJ CIBIN 2023 HOMEBOIZ RADIO MIX 1(HIPHOP, DRILL, EDM, POP, NAIJA, GENGETONE, AFRICAN).m4a
                    String toReplace1 = "Episode";
                    String toReplace2 = "(720p_25fps_H264-128kbit_AAC)";
                    String newFileName =  file.getName()
                            .replaceAll(toReplace1, "")
                            .replaceAll(toReplace2, "")
                            .replaceAll("720p_25fps_H264-192kbit_AAC","")
                            .replace("(","")
                            .replace(")","")
                            .replace("with-Episode","")
                            .replace("with","")
                            .replace("2018","")
                            .replaceAll("newName_","").trim();
                    System.out.println("\n\n\nFile Name:"+file.getName()+" \nnewFileName:" + newFileName);
                    // Create a File object representing the new file name and path
                    File newFile = new File(file.getParent(), newFileName);

                    // Rename the file using the renameTo() method
                    boolean renamed = file.renameTo(newFile);

                    // Check if the renaming was successful
                    if (renamed) {
                        System.out.println("File " + file.getName() + " renamed to " + newFileName);
                    } else {
                        System.out.println("Failed to rename file " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found in the folder.");
            }
        } else {
            System.out.println("Specified path is not a directory.");
        }
    }
}
