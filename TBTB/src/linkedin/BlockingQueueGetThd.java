package linkedin;

public class BlockingQueueGetThd extends BlockingQueueThread{
	public BlockingQueueGetThd(BlockingQueue<Integer> q) {
		super(q);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run(){
		this.get();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
