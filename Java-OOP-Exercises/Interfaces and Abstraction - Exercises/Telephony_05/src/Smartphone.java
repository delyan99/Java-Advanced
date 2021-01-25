import java.util.List;

public class Smartphone implements  Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();
        int counter = 0;
        for (String url : urls) {
            boolean isUrl = true;
            for (Character character : url.toCharArray()) {
                if(Character.isDigit(character)){
                    isUrl = false;
                    break;
                }
            }
            if(isUrl){
                result.append("Browsing: ").append(urls.get(counter++)).append("!").append(System.lineSeparator());
            }else{
                result.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return result.toString();
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();
        int counter = 0;
        for (String number : numbers) {
            boolean isNumber = true;
            for (Character character : number.toCharArray()) {
                if(!Character.isDigit(character)){
                    isNumber = false;
                    break;
                }
            }
            if(isNumber){
                result.append("Calling... ").append(numbers.get(counter++)).append(System.lineSeparator());
            }else{
                result.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return result.toString();
    }
}
