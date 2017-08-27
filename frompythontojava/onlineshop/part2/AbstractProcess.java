public abstract class AbstractProcess{

    public void process(){
        stepBefore(); // implement directly in abstract superclass (here)
        action(); // implement in subclasses
        stepAfter(); // implement directly in abstract superclass (here)
    }

    public void stepBefore(){
        //implementation
    }

    public abstract void action();

    public void stepAfter(){
        //implementation
    }
}
