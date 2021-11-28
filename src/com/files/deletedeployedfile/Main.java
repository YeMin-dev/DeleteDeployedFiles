package com.files.deletedeployedfile;

public class Main {

    public static void main(String[] args) {
        try {
            // Load properties
            Loader loader = new Loader();
            Utils.setProperties(loader.loadProperties());

            ProcessFiles processFiles = new ProcessFiles();
            if (args.length > 0) { // must pass one arg
                if (args.length > 1) { // not allowed more than one arg
                    Utils.print(Messages.MORE_THAN_ONE_ARGUMENT);
                } else {
                    // Do delete process
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
