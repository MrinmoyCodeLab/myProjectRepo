package simple;



public class RemoteServiceClient {

  private RemoteServiceSimulator remoteSr;

    public RemoteServiceClient(Setter config, RemoteServiceSimulator remoteSr) {
        super(config);
        this.remoteSr = remoteSr;
    }

    @Override
    protected String run() throws Exception {
        return remoteSr.execute();
    }

	


}
