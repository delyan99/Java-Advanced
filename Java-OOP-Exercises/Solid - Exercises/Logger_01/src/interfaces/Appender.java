package interfaces;

import enums.ReportLevel;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message);

    void setReportLevel(ReportLevel error);

    String getType();
}
