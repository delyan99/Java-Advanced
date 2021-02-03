package classes;

import enums.ReportLevel;
import interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {

    public ConsoleAppender(Layout simpleLayout) {
        super(simpleLayout);
    }

    @Override
    public String getType() {
        return "ConsoleAppender";
    }
}
