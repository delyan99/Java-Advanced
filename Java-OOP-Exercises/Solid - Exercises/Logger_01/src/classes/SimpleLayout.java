package classes;

import enums.ReportLevel;
import interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String formatter(String date, ReportLevel reportLevel, String message) {
        return date + " - " + reportLevel.name() + " - " + message;
    }

    @Override
    public String getType() {
        return "SimpleLayout";
    }
}
