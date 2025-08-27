package my.e88gt.schlong.utils;

public class Nullable<T>
{
	private T t;
	
	/**
	 * If it requires to be null, set {@link value} to null
	 * 
	 * @param value
	 */
	public Nullable(T value)
	{
		set(value);
	}
	
	public boolean hasValue()
	{
		return t != null;
	}
	
	public T value() throws NullPointerException
	{
		if (!hasValue())
			throw new NullPointerException("Value is null");
		
		return t;
	}
	
	public void set(T value)
	{
		t = value;
	}
	
	@Override public String toString()
	{
		return "" + t;
	}
}
