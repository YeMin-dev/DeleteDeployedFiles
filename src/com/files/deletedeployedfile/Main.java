package com.files.deletedeployedfile;

public class Main {

    public static void main(String[] args) {
        try {
            Loader loader = new Loader();
            Utils.setProperties(loader.loadProperties());

            ProcessFiles processFiles = new ProcessFiles();
            if (args.length > 0) {
                if (args.length > 1) {
                    Utils.print(Messages.MORE_THAN_ONE_ARGUMENT);
                } else {
                    processFiles.prepareFiles(args[0]);
                }
            } else {
                Utils.print(Messages.ZERO_ARGUMENT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
