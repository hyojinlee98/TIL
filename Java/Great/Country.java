package great;

public enum Country {
	NoCountry(0, "����"),
	GoChoSun(1, "������"),
	SamGuk(2, "�ﱹ"),
	Silla(3, "�Ŷ�"),
	Goryo(4, "���"),
	Chosun(5, "����"),
	Colonial(6, "�Ĺ���"),
	ROK(7, "���ѹα�"),
	PastSameGuk(8, "�Ļﱹ");
	int num;
	String country;
	Country(int n, String s) {
		num = n;
		country = s;
	}
	static String getValue(int n) {
		for (Country type : Country.values()) {
			if (type.num == n)
				return type.country;
		}
		return null;
	}
}
