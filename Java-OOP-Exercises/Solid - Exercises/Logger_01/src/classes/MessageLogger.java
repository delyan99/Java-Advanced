package classes;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Layout;
import interfaces.Logger;

import java.util.ArrayList;
import java.util.List;

public class MessageLogger implements Logger {
    private List<Appender> consoleAppender;

    public MessageLogger(Appender... consoleAppender) {
        this.consoleAppender = new ArrayList<>(List.of(consoleAppender));
    }

    @Override
    public void logError(String date, String message) {
        appendAll(date, message, ReportLevel.ERROR);
    }

    @Override
    public void logInfo(String date, String message) {
        appendAll(date, message, ReportLevel.INFO);
    }

    @Override
    public void logWarning(String date, String message) {
        appendAll(date, message, ReportLevel.WARNING);
    }

    @Override
    public void logCritical(String date, String message) {
        appendAll(date, message, ReportLevel.CRITICAL);
    }

    @Override
    public void logFatal(String date, String message) {
        appendAll(date, message, ReportLevel.FATAL);
    }

    @Override
    public void addAppender(Appender appender) {
        this.consoleAppender.add(appender);
    }

    private void appendAll(String date, String message, ReportLevel fatal) {
        for (Appender appender : this.consoleAppender) {
            appender.append(date, fatal, message);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Logger info").append(System.lineSeparator());
        for (Appender appender : consoleAppender) {
            result.append(appender.toString());
            result.append(System.lineSeparator());
        }

        return result.toString().trim();
    }
}
