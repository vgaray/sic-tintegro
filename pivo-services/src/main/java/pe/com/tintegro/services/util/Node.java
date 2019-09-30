package pe.com.tintegro.services.util;

import java.util.ArrayList;
import java.util.List;

public class Node< T >
{
	private T data;
	private Node< T > parent;
	private List< Node< T > > children;
	private Node< T > next;
	private boolean visited;

	public Node()
	{
		this.children = new ArrayList< Node< T >>();
	}

	public Node(T data)
	{
		this();
		setData( data );
	}
	
	public boolean isVisited()
	{
		return visited;
	}

	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}

	public Node< T > getNext()
	{
		return next;
	}

	public void setNext(Node< T > nextBrother)
	{
		this.next = nextBrother;
	}

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}

	public Node< T > getParent()
	{
		return parent;
	}

	public void setParent(Node< T > parent)
	{
		this.parent = parent;
	}

	public List< Node< T > > getChildren()
	{
		return children;
	}

	public void setChildren(List< Node< T >> children)
	{
		this.children = children;
	}

	public void addChild(Node< T > child)
	{
		this.children.add( child );
	}

	public boolean isLeaf()
	{
		return this.children == null || this.children.size() == 0;
	}
}
