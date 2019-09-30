package pe.com.tintegro.services.util;

public class Queue< T >
{
	private Node< T > front;
	private Node< T > end;

	public Queue()
	{
		this.front = null;
		this.end = null;
	}

	public void enqueue(T data)
	{
		Node< T > node = new Node< T >();
		node.setData( data );

		if ( isEmpty() )
		{
			front = node;
			end = node;
		}
		else
		{
			node.setNext( end );
			end = node;
		}
	};

	public T dequeue()
	{
		T data = null;

		if( !isEmpty() )
		{
			Node< T > node = null;
			
			if( end.getNext() == null )
			{
				node = end;
				end = front = null;
			}
			else
			{
				Node< T > aux = end;

				while ( aux.getNext() != front && aux.getNext() != null )
					aux = aux.getNext();

				node = front;

				front = aux;
				front.setNext( null );
			}
			
			data = node.getData();
		}
		
		return data;
	}

	public T peek()
	{
		return front.getData();
	}

	public boolean isEmpty()
	{
		return front == null && end == null;
	}	

	public Node< T > getFront()
	{
		return front;
	}

	public void setFront(Node< T > front)
	{
		this.front = front;
	}

	public Node< T > getEnd()
	{
		return end;
	}

	public void setEnd(Node< T > end)
	{
		this.end = end;
	}
	
	public void print( CallbackQueue< T > callback )
	{		
		for ( Node< T > node = end; node != null ; node = node.getNext() )
		{			
			callback.printItem( node.getData() );
		}
	}
	
	public interface CallbackQueue< T >
	{
		public void printItem( T item );
	}
}
