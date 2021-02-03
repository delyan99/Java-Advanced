package classes;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int appendCounter;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        reportLevel = ReportLevel.INFO;
    }

    protected ReportLevel getReportLevel() {
        return reportLevel;
    }

    protected Layout getLayout() {
        return layout;
    }

    public void incrementAppendCounter(){
        appendCounter++;
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        if(reportLevel.ordinal() >= this.reportLevel.ordinal()) {
            incrementAppendCounter();
            System.out.println(this.getLayout().formatter(date, reportLevel, message));
        }
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Appender type: ");
        result
                .append(getType())
                .append(", Layout type: ")
                .append(this.layout.getType())
                .append(", Report level: ")
                .append(this.reportLevel.name())
                .append(", Messages appended: ")
                .append(this.appendCounter);

        return result.toString();
    }
}
