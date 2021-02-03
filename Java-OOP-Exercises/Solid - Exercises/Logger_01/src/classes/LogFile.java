package classes;

import interfaces.File;

public class LogFile implements File {
    private StringBuilder builder;

    public LogFile(){
        this.builder = new StringBuilder();
    }

    @Override
    public void write(String text) {
        builder.append(text);
    }

    @Override
    public int getSize() {
        int sum = 0;
        for (int i = 0; i < builder.length(); i++) {
            if(Character.isAlphabetic(builder.charAt(i))){
                sum += builder.charAt(i);
            }
        }
        return sum;
    }
}
