package Test;

public class CD {
	private int maCD;
	private String tenCD;
	private String caSy;
	private int soBaiHat;
	private float giaThanh;
	
	public CD () {}

	public CD(int maCD, String tenCD, String caSy, int soBaiHat, float giaThanh) {
		this.maCD = maCD;
		this.tenCD = tenCD;
		this.caSy = caSy;
		this.soBaiHat = soBaiHat;
		this.giaThanh = giaThanh;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello");
		CD cd = new CD();
	}
}
