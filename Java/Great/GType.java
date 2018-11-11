package great;

public enum GType {
	NoGT(0, "��Ÿ"),
	King(1, "��"),
	Soldier(2, "����"),
	Politician(3, "��ġ��"),
	Artist(4, "������"),
	Doctor(5, "�ǻ�"),
	Religeous(6, "������");
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
