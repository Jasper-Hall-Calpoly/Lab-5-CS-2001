import java.util.NoSuchElementException;

public class LLQueue {
    public record ll(String first, ll rest){};

    ll front;
    ll tail;

    //constructor for a linked list queue
    public LLQueue(ll front, ll tail){
        this.front = front;
        this.tail = tail;
    }

    //returns true if the linked list queue is empty and false otherwise
    public boolean isEmpty(){
        if(this == null){
            return true;
        }else if(front == null && tail == null){
            return true;
        }else{
            return false;
        }
    }

    //adds a value to the start of the queue
    public void enqueue(String ent){
        ll hold = new ll(ent, tail);
        tail = hold;
    }

    //checks to see if the tail needs oo be moved to the front and then does so if necessary
    public void reverse_if_needed(){
        if(front == null || front.first == null){
            ll reverse = null;
            while (tail != null){
                reverse = new ll(tail.first, reverse);
                tail = tail.rest();
            }
            front = reverse;
        }
    }

    //returns true if both elements have the same elements
    public boolean equals(LLQueue other){
        return equalElts(other, this);
    }

    //returns a string representation of a queue
    public String toString(ll l){
        switch(l){
            case null: return "";
            case ll(String first, ll rest):{
                return first + " " + toString(rest);
            }
        }
    }

    //returns true if both arguments have the same elements
    public boolean equalElts(LLQueue other, LLQueue first){
        if(first == null && other == null){
            return true;
        }else if(first == null || other == null){
            System.out.println("only one is null");
            return false;
        }else if(first.front == null && other.front == null && first.tail == null && other.tail == null){
            return true;
        }
        if(other.front == null){
            other.reverse_if_needed();
        }
        if(first.front == null){
            first.reverse_if_needed();
        }

        switch(other.front){
            case null: {
                if(first.front == null){
                    return true;
                }else{
                    return false;
                }
            }
            case ll(String str, ll tail): {
                if(str == first.front.first()){
                    other.front = other.front.rest();
                    first.front = first.front.rest();
                    return equalElts(other, first);
                }else{
                    return false;
                }
            }
        }
    }

    //removes a element from the end of the list and returns the element that was removed
    public String dequeue(){
        if(tail == null && front == null){
            throw new NoSuchElementException();
        }
        reverse_if_needed();
        String temp = front.first();
        front = front.rest();
        return temp;
    }

    //returns the end element of the queue
    public String peek(){
        if(tail == null && front == null){
            throw new NoSuchElementException();
        }
        reverse_if_needed();
        return front.first();
    }

}
