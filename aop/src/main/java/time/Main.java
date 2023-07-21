package time;

public class Main {

	public static void main(String[] args) {
		long beforetime = System.currentTimeMillis();
		for(int i=0;i<100000000;i++) {
			int y = 0;
			y++;
		}
		long aftertime = System.currentTimeMillis();
		
		System.out.println(aftertime-beforetime);
	}

}
