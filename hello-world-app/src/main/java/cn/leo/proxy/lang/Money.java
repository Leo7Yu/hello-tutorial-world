package cn.leo.proxy.lang;

public class Money implements MoneyInterface{
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String doSomething() {
		System.out.println("do something...");
		return "hello world!";
	}
}
