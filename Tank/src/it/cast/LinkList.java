package it.cast;

public class LinkList<T> {
	private class Node{
		private T data;
		private Node Next;
		public Node(T data, Node next) {
			super();
			this.data = data;
			Next = next;
		}
		public Node() {
			super();
		}
		
	}
	
	private Node header;
	private Node tail;
	private int size;
	public LinkList() {
		// TODO Auto-generated constructor stub
		header=null;
		tail=null;
		size=0;
	}
	public LinkList(T element){
		header=new Node(element,null);
		tail=header;
		size++;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public T getElement(int index){
		return null;
	}
	
	public void addElement(T element){
		if(header==null){
			header=new Node(element,null);
			tail=header;
		}
		else{
			Node newNode=new Node(element,null);
			tail.Next=newNode;
			tail=newNode;
		}
		size++;
	}
	
	public void addHeader(T element){
		Node newNode=new Node(element,null);
		header=newNode;
		if(tail==null){
			tail=header;
		}
		size++;
	}
	
	public Node getByIndex(int index){
		if(index<0||index>size){
			throw new IndexOutOfBoundsException();
		}
		else{
			Node current=header;
			for(int i=0;i<size & current!=null;i++,current=current.Next){
				if(i==index){
					return current;
				}
			}
			return null;
		}
	}
	
	public void insertEle(T element,int index){
		if(index<0||index>size){
			throw new IndexOutOfBoundsException();
		}
		else{
			if(header==null){
				this.addElement(element);
			}
			else{
				if(index==0){
					this.addHeader(element);
				}
				else{
					//获取前面一个节点的后节点
					Node prev=getByIndex(index);
					prev.Next=new Node(element,prev.Next);
					size++;
				}
			}
		}
	}
	
	public int locate(T element){
		Node current=header;
		for(int i=0;i<size && current!=null;i++,current=current.Next){
			if(current.data.equals(element)){
				return i;
			}
		}
		return -1;
	}
	
	public T delete(int x){
		if(x<0||x>size){
			throw new IndexOutOfBoundsException();
		}
		
		Node del=null;
			if(x==0){
				del=header;
				header=header.Next;
			}
			else{
				Node prev=getByIndex(x-1);
				del=prev.Next;
				prev.Next=del.Next;
				del.Next=null;
			}
		size--;
		return del.data;
	}
	
	public T remove(){
		return delete(size-1);
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public String toString(){
		if(isEmpty()){
			return "[]";
		}
		else{
			StringBuilder sb=new StringBuilder();
			for(Node current=header;current!=null;current=current.Next){
				sb.append(current.data.toString()+",");
			}
			int len=sb.length();
			return sb.delete(len-2, len).append("]").toString();
		}
	}
}
