package cn.leo;

public class Main {

	public static void main(String[] args) {
		String s="123";
		int si=Integer.parseInt(s);
		int i=123;
		Integer I=123;
		if(s.equals(i)){
			System.out.println("s=i");
		}else{
			System.out.println("s!=i");
		}
		
		if(s.equals(I)){
			System.out.println("s=I");
		}else{
			System.out.println("s!=I");
		}
		
		if(si==i){
			System.out.println("si=i");
		}
	}

}
