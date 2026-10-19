import java.util.NoSuchElementException;

public class AStack {
    public String[] arr;
    public int liveValues;

    //A constructor for the IntDoublingArr class
    public AStack(String[] arr, int liveValues){
        this.arr = arr;
        this.liveValues = liveValues;
    }

    // returns true if the stack is empty and returns false otherwise
    public boolean isEmpty(){
        if(liveValues == 0){
            return true;
        }else{
            return false;
        }
    }

    //add to end that adds to the end of the list
    public void push(String ent){
        if(arr == null){
            String[] temp = {ent};
            arr = temp;
            liveValues++;
        } else if(liveValues == arr.length){
            arr = doubleArr();
            arr[liveValues] = ent;
            liveValues++;
        }else{
            arr[liveValues] = ent;
            liveValues++;
        }
    }

    //removes the last element in a stack and then returns it throws error if stack is empty
    public String pop(){
        if(liveValues == 0){
            throw new NoSuchElementException();
        }else{
            String str = arr[liveValues -1];
            arr[liveValues - 1] = null;
            liveValues--;
            return str;
        }
    }

    //returns the top element of the stack and throws an error if the stack is empty
    public String peek(){
        if(liveValues == 0) {
            throw new NoSuchElementException();
        }else{
            return arr[liveValues -1];
        }
    }

    //returns the size of the array
    public int size(){
        return liveValues;
    }

    //Returns a string of all the numbers in the array
    public String toString(){
        String str = new String("");
        for(int i = 0; i < arr.length; i++){
            str = str + " "  + arr[i];
        }
        return str;
    }

    //doubles the length of the array
    public String[] doubleArr(){
        String[] temp = new String[arr.length * 2];
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        return temp;
    }

    //returns true if both stacks are equal and false otherwise
    public boolean equal(AStack enter){
        if(arr.length != enter.arr.length ){
            System.out.println("different Sizes");
            return false;
        }
        for(int i = 0; i < liveValues; i++ ){
            if(arr[i] != enter.arr[i]){
                System.out.println("different nums");
                return false;
            }
        }
        return true;
    }

    //reuturns true if all the live values are the same
    public boolean equalElts(AStack enter){
        if(liveValues != enter.liveValues ){
            System.out.println("different Sizes");
            return false;
        }
        for(int i = 0; i < liveValues; i++ ){
            if(arr[i] != enter.arr[i]){
                System.out.println("different nums");
                return false;
            }
        }
        return true;
    }

}
