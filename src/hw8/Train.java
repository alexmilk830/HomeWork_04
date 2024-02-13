package hw8;

import java.util.Objects;

public class Train {
	private int number;
	private String type;
	private String start;
	private String dest;
	private double price;

	public Train() {

	}

	public Train(int number, String type, String start, String dest, double price) {

		this.number = number;
		this.type = type;
		this.start = start;
		this.dest = dest;
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	@Override
	public int hashCode() {
//接受多個物件作為引數，並計算它們的哈希碼的組合值。這裡的 dest、number、price、start 和 type 是 Train 類別的屬性，它們都參與計算哈希碼。這樣的實作有助於確保不同的 Train 物件有不同的哈希碼，但由於哈希碼是整數，不同的物件可能仍有相同的哈希碼（哈希碰撞）
		return Objects.hash(dest, number, price, start, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) //處理與避免 null == null 為 true 的問題
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		return Objects.equals(dest, other.dest)
//比較這兩個字串是否相等。如果兩者都是 null 或者兩者的內容相等，Objects.equals 會返回 true
				&& number == other.number
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
//比較 price 屬性，因為 price 是 double 型別，使用 == 可能會因為浮點數的精度問題而造成誤差。因此，這裡使用 Double.doubleToLongBits 將 double 值轉換為 long，再比較
				&& Objects.equals(start, other.start)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Train [number=" + number + ", type=" + type + ", start=" + start + ", dest=" + dest + ", price=" + price
				+ "]";
	}

	



}
