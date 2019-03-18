package study201903_16;

public class RenMingBi {
	private static final char[] data = new char[] { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
	private static final char[] units = new char[] { '元', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿','拾', '佰', '仟', '万'};

	public static void main(String[] args) {
		System.out.println(convert(300134023244L));
	}

	public static String convert(long money) {
		StringBuffer sbf = new StringBuffer();
		int unit = 0;
		while (money != 0) {
			sbf.insert(0, units[unit++]);
			long number = money % 10L;
			sbf.insert(0, data[(int)number]);
			money /= 10;
		}
		System.out.println(sbf.toString());
		return sbf.toString().replaceAll("零[拾佰仟]", "零").replaceAll("零+万", "万").replaceAll("零+元", "元")
				.replaceAll("零+亿", "亿").replaceAll("零+", "零");
	}

}
