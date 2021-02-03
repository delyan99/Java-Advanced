import classes.*;
import enums.ReportLevel;
import interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//        Layout simpleLayout = new SimpleLayout();
//        Appender consoleAppender = new ConsoleAppender(simpleLayout);
//        Logger logger = new MessageLogger(consoleAppender);
//
//        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
//        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

//        Layout simpleLayout = new SimpleLayout();
//        Appender consoleAppender = new ConsoleAppender(simpleLayout);
//
//        File file = new LogFile();
//        Appender fileAppender = new FileAppender(simpleLayout);
//        ((FileAppender) fileAppender).setFile(file);
//        Logger logger = new MessageLogger(consoleAppender, fileAppender);
//
//        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
//        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

//        Layout xmlLayout = new XmlLayout();
//        Appender consoleAppender = new ConsoleAppender(xmlLayout);
//        Logger logger = new MessageLogger(consoleAppender);
//
//        logger.logFatal("3/31/2015 5:23:54 PM", "mscorlib.dll does not respond");
//        logger.logCritical("3/31/2015 5:23:54 PM", "No connection string found in App.config");

//        Layout simpleLayout = new SimpleLayout();
//        Appender consoleAppender = new ConsoleAppender(simpleLayout);
//        consoleAppender.setReportLevel(ReportLevel.ERROR);
//
//        Logger logger = new MessageLogger(consoleAppender);
//
//        logger.logInfo("3/31/2015 5:33:07 PM", "Everything seems fine");
//        logger.logWarning("3/31/2015 5:33:07 PM", "Warning: ping is too high - disconnect imminent");
//        logger.logError("3/31/2015 5:33:07 PM", "Error parsing request");
//        logger.logCritical("3/31/2015 5:33:07 PM", "No connection string found in App.config");
//        logger.logFatal("3/31/2015 5:33:07 PM", "mscorlib.dll does not respond");

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Logger logger = new MessageLogger();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Layout layout = input[1].equals("SimpleLayout") ? new SimpleLayout() : new XmlLayout();
            Appender appender = input[0].equals("ConsoleAppender") ? new ConsoleAppender(layout) : new FileAppender(layout, new LogFile());
            if(input.length == 3) {
                appender.setReportLevel(ReportLevel.valueOf(input[2]));
            }
            logger.addAppender(appender);
        }

        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] tokens = input.split("\\|");
            switch (tokens[0]){
                case "INFO":
                    logger.logInfo(tokens[1], tokens[2]);
                    break;
                case "WARNING":
                    logger.logWarning(tokens[1], tokens[2]);
                    break;
                case "ERROR":
                    logger.logError(tokens[1], tokens[2]);
                    break;
                case "CRITICAL":
                    logger.logCritical(tokens[1], tokens[2]);
                    break;
                case "FATAL":
                    logger.logFatal(tokens[1], tokens[2]);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(logger);
    }
}
