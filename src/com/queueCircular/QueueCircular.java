package com.queueCircular;

import com.LRU.LinkedList;

/**
 * 循环队列算法--链表数据结构实现
 * @author Administrator
 *-v0.1
 *
 */
public class QueueCircular<T> {
	Node list;//头部
	
	int max_size;//队列大小
	
	int enqueue = 0;//入队
	
	final int  DEFAULT_max_size = 10;//默认队列大小
	
	public QueueCircular(){
		max_size = DEFAULT_max_size;
	}
	public QueueCircular(int max_max_size){
		this.max_size = max_max_size;
	}
	
	//入队
	public void enQueue(T data) {
		//判断队列是否已满
		if((enqueue+1)%max_size !=0) {
			Node cur = new Node(data, list);
			list = cur;
			enqueue++;
			System.out.println("*****************入队数据为:"+data);
		}else {
			try {
				throw new Exception("队列已满无法插入");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	/*
	public void putIndex(T data,int index) {//在链表index位置插入一个新的数据data
		checkPositionIndex(index);
		Node cur = list;//后一个节点
		Node head = list;//前一个节点
		for(int i = 0 ; i < index ; i++) {
			head = cur;
			cur = cur.next;
		}
		Node node = new Node(data, cur);
		head.next = node;
		max_size++;
	}
	*/
	//修改
	
	/*public void set(int index, T data) {
		checkPositionIndex(index);
		Node cur = list;//后一个节点
		for(int i = 0 ; i < index ; i++) {
			cur = cur.next;
		}
		cur.data = data;
	}*/
	//删除
	/*public T remove() {//删除头部节点
		if(list != null) {
			Node node = list;
			list = list.next;//将头部的下一节点当做新头部节点
			node.next = null;//GC回收
			max_size--;
		}
		return null;
	}
	
	public T removeIndex(int index) {//根据指定下标删除
		checkPositionIndex(index);
		Node cur = list; 
		Node head = list;
		for(int i = 0 ; i < index ; i++) {
			head = cur;
			cur = cur.next;
		}
		head.next = cur.next;
		cur.next = null;
		max_size--;
		return cur.data;
	}*/
	//出队
	public T deQueue() {//删除尾部节点
		//判断队列是否有数据
		if(enqueue != 0) {
			Node cur = list;
			Node head = list; 
			while(cur.next != null) {
				head = cur;
				cur = cur.next;
			}
			head.next = null;
			enqueue--;
			System.out.println("--------------出队数据为:"+cur.data);
			return cur.data;
		}else {
			try {
				throw new Exception("队列为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
/*	//查询
	public T get() {//查询头部节点
		if(list != null) {
			return list.data;
		}
		
		return null;
	}
	public T get(int index) {//查询指定节点
		if(list != null) {
			checkPositionIndex(index);
			Node cur = list;//后一个节点
			for(int i = 0 ; i < index ; i++) {
				cur = cur.next;
			}
			return cur.data;
		}
		return null;
	}
	@Override
	public String toString() {
		Node node = list ;
		for(int i = 0 ; i< max_size ; i++) {
			System.out.print(node.data+"  ");
			node = node.next;
		}
		System.out.println();
		return super.toString();
	}
	private void checkPositionIndex(int index) {
		// TODO 判断下表是否合法
		if(!(index >-0 && index <=max_size)) {
			throw new IndexOutOfBoundsException("index:" + index + ",max_size:"+max_size);
		}
	}*/

	class Node{
		T data;//节点数据
		Node next;//下一节点
		
		public Node(T data, Node node) {
			// TODO Auto-generated constructor stub
			this.data = data;
			this.next = node;
		}
	}
	public static void main(String[] args) {
		QueueCircular<Integer> defQueue = new QueueCircular<>();
		for(int i = 0 ; i < defQueue.max_size-1;i++) {
			defQueue.enQueue(i);
			System.out.println("当前入队下标为："+defQueue.enqueue);
		}
		for(int i = 0 ; i < defQueue.max_size-1;i++) {
			defQueue.deQueue();
			System.out.println("当前入队下标为："+defQueue.enqueue);
		}
	}
}
