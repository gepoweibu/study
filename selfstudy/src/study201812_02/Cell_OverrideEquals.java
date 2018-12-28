package study201812_02;

public class Cell_OverrideEquals {
	private int x;
	private int y;

	public Cell_OverrideEquals(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (obj instanceof Cell_OverrideEquals && this.x == ((Cell_OverrideEquals) obj).getX()
				&& this.y == ((Cell_OverrideEquals) obj).getY()) {
			return true;
		} else {
			return false;
		}
	}

	// 1.一般情况下重写equals方法就要重写hashCode()方法，否则在hashSet或hashMap等类似的hash集合中会出现问题。
	// 2.为不相等的对象生成不同整数结果可以提高哈希表的性能.
	// HashSet集合判断两个元素相等的标准是：两个对象通过equals()方法比较相等，
	// 并且两个对象的HashCode()方法返回值也相等。如果两个元素通过equals()方法比较返回true，
	// 但是它们的hashCode()方法返回值不同，HashSet会把它们存储在不同的位置，依然可以添加成功。
	// 同样:HashMap，存储的数据是<key,value>对，key，value都是对象，
	// 被封装在Map.Entry，即：每个集合元素都是Map.Entry对象。在Map集合中，
	// 判断key相等标准也是：两个key通过equals()方法比较返回true，两个key的hashCode的值也必须相等。
	@Override
	public int hashCode() {
		int result = 17;
		return result * 31 + this.x + this.y;
	}
	// 下面是对于equals中每一个元素的hashCode值得计算方法(必须包含equals中每一个元素的hash值，才能保证对象与hashCode的一一对应)
	// public int hashCode() {
	// //设置初始值
	// int result = 17;
	//
	// //假设有效域为: name,age,idCardNo,incomeAnnual,sex,brithDay
	// int c = 0;
	// //计算name (String为对象类型,他的计算直接调用本身的hashCode)
	// c = name.hashCode();
	// result = result * 37 + c;
	//
	// //计算age (int/byte/char/short类型,他的计算直接调用本身的值)
	// c = this.getAge();
	// result = result * 37 + c;
	//
	// //计算idCardNo (long类型,他的计算 (int)(field^(field >>> 32)) 无符号右移32位)
	// c = (int) (this.idCardNo ^ (this.idCardNo >>> 32));
	// result = result * 37 + c;
	//
	// //计算 incomeAnnual (double类型,他的计算
	// Double.doubleToLongBits(field)后,再按Long类型计算 )
	// //(float类型,他的计算 Float.floatToIntBits(field) )
	// long tmp = Double.doubleToLongBits(this.incomeAnnual);
	// c = (int) (tmp ^ (tmp >>> 32));
	// result = result * 37 + c;
	//
	// //计算 sex (sex为boolean类型,他的计算直接调用 c=sex?1:0)
	// c = this.isSex() ? 1 : 0;
	// result = result * 37 + c;
	//
	// //计算 brithDay (brithDay为Date对象类型,他的计算直接调用 本身的hashCode)
	// c = this.getBirthDay().hashCode();
	// result = result * 37 + c;
	//
	// return result;
	// }
}
