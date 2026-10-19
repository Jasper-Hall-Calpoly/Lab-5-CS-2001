import java.util.NoSuchElementException;

public class LLStack {
    record pair(String str, pair pr){}

    pair stack;
    int liveNums;

    //constructor for LLStack
    public LLStack(pair stack, int liveNums){
        this.stack = stack;
        this.liveNums = liveNums;
    }

    //pushes a string to the top of the stack
    public void push(String str){
        stack = new pair(str, stack);
        liveNums++;
    }

    //removes and returns the top element of the stack and throws an error if the stack is empty
    public String pop(){
        if(liveNums == 0){
            throw new NoSuchElementException();
        }else {
            String str = stack.str();
            stack = stack.pr();
            liveNums--;
            return str;
        }
    }

    public String toString(){
        return new String(stringify(stack));
    }

    public String stringify(pair cur){
        return switch(cur){
            case null -> "";
            case pair(String first, pair rest) ->{
                yield first + " " + stringify(rest);
            }
        };
    }


    //returns the tio element of the stac and throws an error if the stack is empty
    public String peek(){
        if(liveNums == 0){
            throw new NoSuchElementException();
        }else {
            return stack.str();
        }
    }

    public int size(pair cur){
        return switch(cur){
            case null -> 0;
            case pair(String first, pair rest) ->{
                yield 1 + size(rest);
            }
        };
    }

    public boolean is_Empty(){
        if(stack == null){
            return true;
        }else{
            return false;
        }
    }

}
