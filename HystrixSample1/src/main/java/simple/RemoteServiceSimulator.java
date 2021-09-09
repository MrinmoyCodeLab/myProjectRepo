package simple;

public class RemoteServiceSimulator {

  private long wait;

    public RemoteServiceSimulator(long wait) throws InterruptedException {
        this.wait = wait;
    }

    public String execute() throws InterruptedException {
        Thread.sleep(wait);
        return "Success";
    }
}
