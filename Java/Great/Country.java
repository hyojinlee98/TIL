package great;

public enum Country {
	NoCountry(0, "없음"),
	GoChoSun(1, "고조선"),
	SamGuk(2, "삼국"),
	Silla(3, "신라"),
	Goryo(4, "고려"),
	Chosun(5, "조선"),
	Colonial(6, "식민지"),
	ROK(7, "대한민국"),
	PastSameGuk(8, "후삼국");
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
