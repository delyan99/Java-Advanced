public class Validator {
    public static void validateName(String name){
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public static void validateStats(String statsName, int statsValue){
        if(statsValue < 0 || statsValue > 100){
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", statsName));
        }
    }
}
