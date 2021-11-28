package com.files.deletedeployedfile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Objects;

public class ProcessFiles {

    /**
     * Prepare relevant file path and do delete process */
    public void prepareFiles(String path) {
        try {
            if (StringUtils.isBlank(path)) {
                Utils.print(Messages.ZERO_ARGUMENT);
            } else {
                path = path.trim();
                path = Utils.getRelevantPath(path); // getting relevant path

                if (Utils.isCorrectPath(path)) { // show error message if path is wrong
                    deleteTempFiles(path);
                    deleteWars(path + "\\deployments");
                } else {
                    Utils.print(Messages.WRONG_DIRECTORY);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete deployed WAR files from Jboss deployments folder*/
    private void deleteWars(String path) {
        File dir = new File(path);
        try {
            if (dir.exists()) {
                if (Objects.requireNonNull(dir.listFiles()).length == 0) {
                    Utils.print(Messages.EMPTY_FILES, dir.toString());
                } else {
                    FileUtils.cleanDirectory(dir); // deleting content from folder
                    Utils.print(Messages.JUST_DELETED, dir.toString());
                }
            } else {
                Utils.print(Messages.NOT_EXIST, dir.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete temp files from Jboss standalone folder*/
    private void deleteTempFiles(String path) {
        File dir;
        String[] nameList = {"\\data", "\\log", "\\tmp"};
        try {
            for (String fileName : nameList) {
                dir = new File(path + fileName);
                if (dir.exists()) {
                    FileUtils.deleteDirectory(dir); // deleting folder as well as content
                    Utils.print(Messages.JUST_DELETED, dir.toString());
                } else {
                    Utils.print(Messages.EMPTY_FILES, dir.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
