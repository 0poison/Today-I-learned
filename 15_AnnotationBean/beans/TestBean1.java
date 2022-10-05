package kr.co.ezenac.beans;

public class TestBean1 {
	private int data1;
	private String data2;
	private DataBean1 data3;

	public TestBean1() {

	}

	public TestBean1(int data1, String date2, DataBean1 data3) {
		this.data1 = data1;
		this.data2 = date2;
		this.data3 = data3;
	}

	public int getData1() {
		return data1;
	}

	public void setData1(int data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String date2) {
		this.data2 = date2;
	}

	public DataBean1 getData3() {
		return data3;
	}

	public void setData3(DataBean1 data3) {
		this.data3 = data3;
	}

}
