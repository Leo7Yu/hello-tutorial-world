package cn.leo;

public class Main {

	public static void main(String[] args) {
		Integer i1 = 120;
		Integer i2 = 120;

		System.out.println(i1==i2);
		
		int ii1=200;
		int ii2=200;
		System.out.println(ii1==ii2);


		Integer i3 = new Integer(200);
		Integer i4 = new Integer(200);

		System.out.println(i3==i4);
		System.out.println(ii2==i4);
	}


}
