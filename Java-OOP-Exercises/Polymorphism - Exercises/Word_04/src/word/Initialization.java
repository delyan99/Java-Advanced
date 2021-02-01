package word;

import word.CommandImpl.ToUpperTransform;

import java.util.List;

public class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text) {
        String[] tokens = text.toString().split("\\s+");
        CommandImpl command = new CommandImpl(text);
        command.init();
        return command;
    }
}
