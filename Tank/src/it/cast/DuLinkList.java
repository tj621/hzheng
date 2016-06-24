package it.cast;

public class DuLinkList<T>{
	private class Node{
		private T data;
		private Node prev;
		private Node next;
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node(T data, Node prev, Node next) {
			super();
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		public Node() {
			super();
		}
		
	}
	
	private Node header;
	private Node tail;
	private int size;
	public DuLinkList() {
		header=null;
		tail=null;
		size=0;
	}
	public DuLinkList(T ele) {
		header=new Node(ele, null, null);
		tail=header;
		size++;
	}
	public int getSize() {
		return size;
	}
	
	public Node getByIndex(int index){
		if(index<0 || index>size){
			throw new IndexOutOfBoundsException();
		}
		else
		{
			Node curr=header;
			if(index<=size/2){
				for (int i = 0; i <=size/2 && curr!=null; i++,curr=curr.next) {
					if(i==index){
						return curr;
					}
				}
			if(index>size/2){
				for (int i = 0; i <=size/2 && curr!=null; i++,curr=curr.next) {
					if(i==index){
						return curr;
					}
				}	
			}	
			
			}
	}
		return null;
	}
	
	public void addEle(T ele){
		if(header==null){
			header=new Node(ele, null, null);
			tail=header;
		}
		else{
			Node newNode=new Node(ele, null, null);
			tail.next=newNode;
			tail=newNode;
		}
		size++;
	}
}
