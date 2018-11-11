package great;

public enum GType {
	NoGT(0, "기타"),
	King(1, "왕"),
	Soldier(2, "무인"),
	Politician(3, "정치가"),
	Artist(4, "예술가"),
	Doctor(5, "의사"),
	Religeous(6, "종교인");
	int num;
	String type;
	GType(int n, String s) {
		num = n;
		type = s;
	}
	static String getValue(int n) {
		for (GType type : GType.values()) {
			if (type.num == n)
				return type.type;
		}
		return null;
	}
}
