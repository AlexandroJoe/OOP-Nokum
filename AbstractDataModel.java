
public abstract class AbstractDataModel implements DataModel{
	protected int data; //declaring variable
	
	
	public AbstractDataModel(int value) {
		this.data = value;
	}
	
	//set the function of getData, return data
	public int getData() {
		return data;
	}
	
	//set the function of setData
	public void setData(int value) {
		this.data = value;
		
	}
	
	//set the function to increment the data
	public void increment() {
		data++;
	}
	
}
