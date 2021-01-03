import java.util.List;

public class ListyIterator{
    private List<String> data;
    private int index;

    public ListyIterator(List<String> data){
        this.data = data;
        this.index = 0;
    }

    public boolean move(){
        if(this.index + 1 < this.data.size()){
            this.index++;
            return true;
        }
        return false;
    }

    public String print(){
        String result = "";
        if(isEmpty()){
            return "Invalid Operation!";
        }
        if(this.index < this.data.size()){
            result = this.data.get(this.index);
        }
        return result;
    }

    public boolean hasNext(){
        if(this.index + 1 < this.data.size()){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(this.data.size() == 0){
            return true;
        }
        return false;
    }
}
