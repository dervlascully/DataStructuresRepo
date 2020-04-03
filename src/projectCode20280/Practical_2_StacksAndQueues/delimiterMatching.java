package projectCode20280.Practical_2_StacksAndQueues;

public class delimiterMatching {

    private LinkedStack<Character> myStack = new LinkedStack<>();
    private char[] array = {'{', '}', '[', ']','(', ')'}; // default
    private String input;

    public delimiterMatching(String input){
        this.input = input;
    }

    public void setInput(String str){
        this.input = str;
    }

    public void setArray(char[] array){
        this.array = array;
    }

    public void checkDelimiter(){

        for(int i=0; i<input.length(); i++){

            char x = input.charAt(i);
            int y = 0;

            if (contains(array, x)) { // if the character in the input string is { } [ ] ( or )

                if(! myStack.isEmpty()) { // if there is at least one element in the stack already

                    if (x == '}' && myStack.top() == '{') {
                        myStack.pop();
                        y = 1;
                    }
                    else if (x == ')' && myStack.top() == '(') {
                        myStack.pop();
                        y = 1;
                    }
                    else if (x == ']' && myStack.top() == '[') {
                        myStack.pop();
                        y = 1;
                    }
                }
                if(y == 0) myStack.push(x);
            }


        }

        if(myStack.top()==null) {
            System.out.println(":) No Missing Delimiters! ");
        }
        else{
            System.out.println(":( Your delimiters are not matching");
        }


    }


    public static boolean contains(char[] myArray, char value){
        for(int i=0; i<myArray.length; i++){
            if(myArray[i] == value)
                return true;
        }
        return false;
    }
}



