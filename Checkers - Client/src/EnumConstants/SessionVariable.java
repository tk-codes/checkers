package EnumConstants;

public enum SessionVariable{
	
	myID(3);
	//public static MyMouseListener mouseListener = new MyMouseListener();
	
	private int value;
	
	SessionVariable(int value){
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
