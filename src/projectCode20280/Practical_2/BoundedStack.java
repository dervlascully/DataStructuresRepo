package projectCode20280.Practical_2;

public class BoundedStack<E> extends ArrayStack<E> {

    public BoundedStack(int maxsize){
        super(maxsize);
    }


    public void push(E e){
        if(this.size() >= this.getCapacity()) {
            throw new RuntimeException("Cannot push: stack is at max capacity");
        }

        else{
            super.push(e);
        }

    }
}
