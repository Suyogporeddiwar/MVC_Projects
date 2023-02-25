package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductBean implements Serializable{
	
	private String pcode;
	private String pname;
	private int pqty;
	private float pprice;
	
	ProductBean()
	{
		
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
	}

	public float getPprice() {
		return pprice;
	}

	public void setPprice(float pprice) {
		this.pprice = pprice;
	}

}
