package linkedin;

public class BlockingQueueThread extends Thread{
	BlockingQueue<Integer> q;
	public BlockingQueueThread(BlockingQueue<Integer> q){
		this.q = q;
	}
	
	public void put(Integer i){
		try {
			this.q.put(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Integer get(){
		try {
			return this.q.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<Integer> q = new BlockingQueue<Integer>(10);
	}

}
