package com.files.deletedeployedfile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Objects;

public class ProcessFiles {

    public void prepareFiles(String path) {
        try {
            if (StringUtils.isBlank(path)) {
                Utils.print(Messages.ZERO_ARGUMENT);
            } else {
                path = path.trim();
                path = Utils.getRelevantPath(path);

                if (Utils.isCorrectPath(path)) {
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

    private void deleteWars(String path) {
        File dir = new File(path);
        try {
            if (dir.exists()) {
                if (Objects.requireNonNull(dir.listFiles()).length == 0) {
                    Utils.print(Messages.EMPTY_FILES, dir.toString());
                } else {
                    FileUtils.cleanDirectory(dir);
                    Utils.print(Messages.JUST_DELETED, dir.toString());
                }
            } else {
                Utils.print(Messages.NOT_EXIST, dir.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteTempFiles(String path) {
        File dir;
        String[] nameList = {"\\data", "\\log", "\\tmp"};
        try {
            for (String fileName : nameList) {
                dir = new File(path + fileName);
                if (dir.exists()) {
                    FileUtils.deleteDirectory(dir);
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
