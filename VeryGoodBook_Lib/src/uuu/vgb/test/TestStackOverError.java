package uuu.vgb.test;

public class TestStackOverError {
	public static void main(String[] args) {
		//main(null); //直接遞迴
		main2(); //間接遞迴
	}
	private static void main2() {
		main(null);
	}
}
