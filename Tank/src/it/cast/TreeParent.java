package it.cast;

public class TreeParent<E> {
	public static class Node<T>{
		T data;
		int parent;
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public int getParent() {
			return parent;
		}
		public void setParent(int parent) {
			this.parent = parent;
		}
		public Node(T data, int parent) {
			super();
			this.data = data;
			this.parent = parent;
		}
		public Node() {
			super();
		}
		@Override
		public String toString() {
			return "Node [data=" + data + ", parent=" + parent + "]";
		}
		
	}
	
	private final int DEFAULY_TREE_SIZE=100;
	private int treeSize=0;
	
	//使用node[]数组来记录该数里面的所有节点
	private Node<E>[] nodes;
	
	//记录节点数
	private int nodeNums;
	
	//以指定根节点创建树
	public TreeParent(E data) {
		treeSize=DEFAULY_TREE_SIZE;
		nodes=new Node[treeSize];
		nodes[0]=new Node<E>(data, -1);
		nodeNums++;
		
		// TODO Auto-generated constructor stub
	}
	
	
	public TreeParent(E data,int treeSize){
		this.treeSize=treeSize;
		nodes=new Node[treeSize];
		nodes[0]=new Node<E>(data,-1);
		nodeNums++;
	}
	
	//以指定的节点添加节点
	public void addNode(E data,Node parent){
		for (int i = 0; i < treeSize; i++) {
			
		}
	}
}
