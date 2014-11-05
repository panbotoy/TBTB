package linkedin;

public class BlockingQueuePutThd extends BlockingQueueThread{
	@Override
	public void run(){
		
		try {
			this.put(1);
			Thread.sleep(5000);
			this.put(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public BlockingQueuePutThd(BlockingQueue<Integer> q) {
		super(q);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
