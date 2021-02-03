package classes;

import enums.ReportLevel;
import interfaces.Layout;

public class XmlLayout implements Layout {

    @Override
    public String formatter(String date, ReportLevel reportLevel, String message) {
        return String.format("<log>%n" +
                "   <date>%s</date>%n" +
                "   <level>%s</level>%n" +
                "   <message>%s</message>%n" +
                "</log>", date, reportLevel, message);
    }

    @Override
    public String getType() {
        return "XmlLayout";
    }
}
