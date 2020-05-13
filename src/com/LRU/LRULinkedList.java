package com.LRU;
/**
 * LRU算法222
 * @author Administrator
 * @param <T>
 *
 */
public class LRULinkedList<T> extends LinkedList<T>{
	//限定内存空间大小，模拟LRU内存不足时的操作
	int memory_size;
	//默认大小
	static final int DEFAULT_CAP = 5;
	
	
	public LRULinkedList() {
		// TODO Auto-generated constructor stub
		this(DEFAULT_CAP);
	}
	
	public LRULinkedList(int default_mempry_size) {
		memory_size = DEFAULT_CAP;
	}
	
	//LRU添加节点
	public void lruPut(T data){
		if(size >= memory_size) {//若内存已满，将尾部节点删除
			removeLast();
			put(data);
		}else {
			put(data);
		}
		
	}
	
	//LRU删除（删除最后面一个节点为最不常用的节点）
	public T lruRemove() {
		return removeLast();
	}
	
	//LRU访问
	public T lruGet(int index) {
		checkPositionIndex(index);
		Node node = list;//当前访问的节点数据
		Node pre = list;//前一节点数据
		for(int i = 0 ; i < index ; i++) {//得到访问节点的数据和前一节点的数据
			pre = node;
			node = node.next;
		}
		T resultData = node.data;//返回当前节点数据
		//将访问的节点移到表头
		pre.next = node.next;//将当前节点的下一节点连接赋值给前一节点
		Node head = list;//获取头部节点
		node.next = head;//将当前访问的节点修改为头部节点
		list = node;//将默认头部节点改为当前访问节点
		
		return resultData;
	}
	
	public static void main(String[] args) {
		LRULinkedList<Integer> lru = new LRULinkedList<>(5);
		
		for(int i = 0 ; i < 4 ; i++) {
			lru.put(i);
		}
		lru.toString();
		System.out.println(lru.lruGet(3));
		lru.toString();
		lru.lruPut(20);
		lru.toString();
		lru.lruPut(13);
		lru.toString();
	}
}
