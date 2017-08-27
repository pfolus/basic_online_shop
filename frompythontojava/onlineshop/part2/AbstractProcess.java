public abstract class AbstractProcess{

    public void process(){
        stepBefore();
        action();
        stepAfter();
    }

    public void stepBefore(){
        System.out.println("Step Before test");
    }

    public abstract void action();

    public void stepAfter(){
        System.out.println("Step After test");
    }
}
