package classes;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.File;
import interfaces.Layout;

public class FileAppender extends AppenderImpl {
    private File file;

    public FileAppender(Layout simpleLayout, LogFile file) {
        super(simpleLayout);
        this.file = file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String getType() {
        return "FileAppender";
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append(", File size: ");
        result.append(this.getFile().getSize());
        return result.toString();
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        if(reportLevel.ordinal() >= super.getReportLevel().ordinal()) {
            super.incrementAppendCounter();
            this.file.write(super.getLayout().formatter(date, reportLevel, message));
        }
    }
}
