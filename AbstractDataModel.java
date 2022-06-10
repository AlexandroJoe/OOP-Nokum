
public abstract class AbstractDataModel implements DataModel{
	protected int data;
	
	public AbstractDataModel(int value) {
		this.data = value;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int value) {
		this.data = value;
		
	}
	
	public void increment() {
		data++;
	}
	
}
