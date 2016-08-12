package cn.leo.proxy.lang;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyHandler implements InvocationHandler {
	private Object business;

	public Object bind(Object business) {
		this.business = business;
		return Proxy.newProxyInstance(business.getClass().getClassLoader(), business.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result=null;
		doBefore();
		result=method.invoke(business, args);
		doAfter();
		return result;
	}

	private void doAfter() {
		System.out.println("do something after");
		
	}

	private void doBefore() {
		System.out.println("do something before");
	}

	public static void main(String[] args) {
		DynamicProxyHandler handler=new DynamicProxyHandler();
		MoneyInterface money=new Money();
		MoneyInterface moneyProxy=(MoneyInterface) handler.bind(money);
		String result=moneyProxy.doSomething();
		System.out.println(result);
	}
}
