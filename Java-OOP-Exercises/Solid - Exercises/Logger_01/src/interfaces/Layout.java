package interfaces;

import enums.ReportLevel;

public interface Layout {
    String formatter(String date, ReportLevel reportLevel, String message);

    String getType();
}
