package cn.leo.proxy.lang;

public final class RMBMoney extends Money{
	
	public void addToAmount(int amountToAdd){
		setAmount(getAmount()+amountToAdd);
	}
	
}
