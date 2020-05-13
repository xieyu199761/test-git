package com.LRU;
/**
 * 单链表
 * @author Administrator
 *
 * @param <T>
 */
public class LinkedList<T> {

	Node list;//头部
	
	int size;//链表有多少个节点
	
	public LinkedList(){
		size = 0;
	}
	
	//添加节点 
	 public void put(T data) {
		 //Node head = list;
		 Node curNode = new Node(data, list);
		 list = curNode;
		 size++;
	 }
	 public void put (int index,T data) {//在链表index位置插入一个新的数据data
		 checkPositionIndex(index);
		 Node cur = list;//添加坐标的后方节点数据
		 Node head = list;//添加坐标的前方节点数据
		 for(int i = 0 ; i < index ; i++) {
			 head = cur;
			 cur = cur.next;
		 }
		 Node node = new Node(data, cur);//插入指定节点的数据，cur为当前数据的下一节点数据
		 head.next = node;//将当前数据设置为前一个节点数据的下一节点
		 size++; 
	 }
	//删除节点 
	public T remove() {//删除头部节点
		if(list != null) {
			Node node = list;
			list = list.next;
			node.next = null;//GC回收
			size--;
			return node.data;
		}
		return null;
	}
	
	public T remove(int index) {//删除指定节点
		checkPositionIndex(index);
		Node cur = list;//添加坐标的后方节点数据
		Node head = list;//添加坐标的前方节点数据
		for(int i = 0 ; i < index ; i++) {
			 head = cur;
			 cur = cur.next;
		 }
		head.next = cur.next;
		cur.next = null;//GC回收
		return cur.data;
	}
	
	public T removeLast() {//删除尾部节点
		if(list != null) {
			Node node = list ; 
			Node cur = list;
			while(cur.next != null) {
				node = cur;
				cur = cur.next;
			}
			node.next = null;
			size --;
			return cur.data;
		}
		return null;
	}
	
	//修改节点
	public void set(int index,T newData) {
		checkPositionIndex(index);
		Node head = list;//添加坐标的后方节点数据
		for(int i = 0 ; i < index ; i++) {
			head = head.next;
		}
		head.data = newData;
	}
	//查询节点
	public T get() {//get头部节点
		Node node = list;
		if(node != null) {
			return node.data;
		}
		return null;
	}
	public T get(int index) {//get指定节点
		checkPositionIndex(index);
		Node node = list; 
		for(int i = 0; i < index ; i++) {
			node = node.next;
		}
		return node.data;
	}
	//检查index是否在链表中
	public void checkPositionIndex(int index) {
		// TODO Auto-generated method stub
		if(!(index >-0 && index <=size)) {
			throw new IndexOutOfBoundsException("index:" + index + ",size:"+size);
		}
	}
	
	@Override
	public String toString() {
		Node node = list ;
		for(int i = 0 ; i< size ; i++) {
			System.out.print(node.data+"  ");
			node = node.next;
		}
		System.out.println();
		return super.toString();
	}
	
	class Node{
		T data;//节点的数据
		Node next;//下一个节点
		
		public Node(T data,Node node) {
			this.data = data;
			this.next = node;
		}
	}
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0 ; i < 5 ; i++) {
			list.put(i);
		}
		list.toString();
		list.put(3,33);
		list.toString();
		list.put(8);
		list.toString();
		System.out.println(list.get(2));
	}
}
