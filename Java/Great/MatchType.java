package great;

public enum MatchType {
	None(0, "없음"),
	Name(1, "이름"),
	Gender(2, "성별"),
	Year(3, "년도"),
	Achieved(4, "업적");
	int num;
	String value;
	MatchType(int n, String s) {
		num = n;
		value = s;
	}
	static int getNum(String s) {
		for (MatchType type : MatchType.values()) {
			if (type.name().equals(s))
				return type.num;
		}
		return 0;
	}
	static String getValue(int n) {
		for (MatchType type : MatchType.values()) {
			if (type.num == n) 
				return type.value;
		}
		return null;
	}
}
