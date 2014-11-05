package linkedin;

import java.util.LinkedList;

public class BlockingQueue <T> {
	
	/**
	 * @param args
	 */
	LinkedList<T> queue = new LinkedList<T>();
	int limit;
	
	public BlockingQueue(int limit){
		this.limit = limit;
	}
	
	synchronized public void put(T item) throws InterruptedException{   // if it is not synchronized, check queue size may end up with a problem. also for put.
		System.out.println("Thead:" + Thread.currentThread().getName() + " has entered put()" );
		while (this.queue.size() == this.limit){  //never use if, but use while for spurious wake up. When a thread wakes up, it will continue after wait(); if it is IF, 
												  // it will skip the check and proceed. However, if two threads are waiting before get, and one new item is put into queue, there will be a problem. 
			wait();
		}
		if (this.queue.size() == 0) notifyAll();
		this.queue.add(item);
		notifyAll(); // use notifyAll instead of notify. I think we can use notify if it puts 1 item every time. But if it puts two items within one put() call, notifyAll is needed.
	}
	
	synchronized public T get() throws InterruptedException{
		System.out.println("Thead:" + Thread.currentThread().getName() + " has entered get()" );
		while (this.queue.size() == 0){
			System.out.println("Thead:" + Thread.currentThread().getName() + " prepare to wait()" );
			wait();
			System.out.println("Thead:" + Thread.currentThread().getName() + " wakes" );
		}
		if (this.queue.size() == 1) notifyAll();
		T item = this.queue.remove();
		System.out.println("Thead:" + Thread.currentThread().getName() + " get item " + item );
		return item;
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BlockingQueue<Integer> q = new BlockingQueue<Integer>(10);
		BlockingQueuePutThd put = new BlockingQueuePutThd(q);
		BlockingQueuePutThd put1 = new BlockingQueuePutThd(q);
		BlockingQueueGetThd get = new BlockingQueueGetThd(q);
		BlockingQueueGetThd get1 = new BlockingQueueGetThd(q);
		get.start();
		get1.start();
		put.start();
//		try {
//			get.join();
//			get1.join();
//			put.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
	}

}
