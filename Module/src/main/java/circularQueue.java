import java.util.NoSuchElementException;

public class circularQueue {
    int start;
    int end;
    int size;
    int length;
    String[] arr;

    //constructor for circularQueue
    public circularQueue(String[] arr, int size){
        this.arr = new String[size];
        for(int i = 0; i < arr.length; i++){
            this.arr[i] = arr[i];
        }
        this.length = arr.length;
        this.start = 0;
        this.end = arr.length - 1;
        this.size = size;
    }

    //returns a string interpretation of a circular queue
    public String toString(){
        String str = "";
        for(int i = 0; i < size; i++){
            str = str + " | " + arr[i];
        }
        return str;
    }

    //returns true if both queues are equal
    public boolean equals(circularQueue other){
        if(this.length == other.length){
            for(int i = 0; i < this.arr.length; i++){
                if(this.arr[i] != other.arr[i]){
                    return true;
                    //return false;
                }
            }
            return true;
            //return true;
        }else{
            return false;
            //return false;
        }
    }

    //returns an integer representation of the size of the queue
    public int size(){
        return length;
    }

    //returns true if the elements in the array are equal
    public boolean equalElts(circularQueue other){
        if(this == null && other == null){
            return true;
        }else if((this == null && other != null)||(this != null && other == null)){
            return false;
        }else if(length != other.length){
            return false;
        }else {
            for (int i = 0; i < length; i++) {
                if (other.arr[other.start + i] != arr[start + i]) {
                    return false;
                }
            }
            return true;
        }
    }

    //adds a String to the start of the queue
    public void enqueue(String ent){
        if(end == size -1){
            end = 0;
            arr[end] = ent;
        }else{
            end++;
            length++;
            arr[end] = ent;
        }
    }

    //removes a String from the end of the queue
    public String dequeue(){
        if(this == null || arr == null || arr[start] == null ){
            throw new NoSuchElementException();
        }
        String var = arr[start];
        arr[start] = null;
        length--;
        start++;
        return var;
    }

    //returns the String at the end of the queue
    public String peek(){
        String var = arr[start];
        return var;
    }

    //returns true if the queue is empty and false otherwise
    public boolean is_empty(circularQueue circ){
        if(circ == null){
            return true;
        }else if(circ.arr[start] == null){
            return true;
        }else{
            return false;
        }
    }
}
