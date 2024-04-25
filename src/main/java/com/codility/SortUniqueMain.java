package com.codility;

public class SortUniqueMain {

    public static void printHelp() {
        System.out.println("Usage: program_name [OPTIONS]");
        System.out.println("Options:");
        System.out.println("  -h, --help          Show this help message and exit.");
        System.out.println("  -f, --file FILE     CSV file to read from.");
        System.out.println("  -o, --output FILE   CSV file to write to.");
        System.out.println("  -c, --columns COL   Columns to perform action on.");
        System.out.println("  -a, --action ACTION Action to run.");
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String arg : args) {
                if (arg.equals("--help") || arg.equals("-h")) { // Fix to check for both -h and --help in all arguments
                    printHelp();
                    return;
                }
            }
        }

        String inputFilename = null;
        String outputFilename = null;
        String column = null;
        String action = null;

        for (int i = 0; i < args.length; i += 2) {
            if (i + 1 < args.length) { // Fix to check array index bounds
                String arg = args[i];
                if (arg.equals("-f") || arg.equals("--file")) {
                    inputFilename = args[i + 1];
                } else if (arg.equals("-o") || arg.equals("--output")) {
                    outputFilename = args[i + 1];
                } else if (arg.equals("-c") || arg.equals("--columns")) {
                    column = args[i + 1];
                } else if (arg.equals("-a") || arg.equals("--action")) {
                    action = args[i + 1];
                }
            } else {
                System.err.println("Error! Missing value for option: " + args[i]);
                System.exit(1);
            }
        }

        // Basic error handling of the options provided
        if (inputFilename == null || outputFilename == null) { // Fix to check if output filename is provided
            System.err.println("Error! Missing required file name(s).");
            System.exit(1);
        }

        if (action == null) {
            System.err.println("Error! No action provided.");
            System.exit(1);
        }

        if (action.equals("sort")) {
            Sort.sortFile(inputFilename, outputFilename, column);
        } else if (action.equals("remove_duplicates")) {
            RemoveDuplicate.removeDuplicate(inputFilename, outputFilename, column);
        }

        System.exit(0);
    }
}