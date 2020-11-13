package demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private String barcode;
	private String pname;
	private String color;
	private String pDescription;
	
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	@Override
	public String toString() {
		return "Product [barcode=" + barcode + ", pname=" + pname + ", color=" + color + ", pDescription="
				+ pDescription + "]";
	}
	
	
	
}
