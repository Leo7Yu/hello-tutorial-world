package cn.leo.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	private Object srcTarget;

	private CglibProxy(Object o) {
		srcTarget = o;
	}

	public static <T> T proxyTarget(T t) {
		Enhancer en = new Enhancer();
		en.setSuperclass(t.getClass());
		en.setCallback(new CglibProxy(t));
		@SuppressWarnings("unchecked")
		T tt = (T) en.create();
		return tt;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println(method+" in intercept...");
		Object o = method.invoke(srcTarget, args);
		return o;
	}

	public static void main(String[] args) {
		// 未实现接口的类的代理
		Person person = CglibProxy.proxyTarget(new Person());
		String result = person.active("sing a song");
		System.out.println("person active result:" + result);
		// 实现接口的类的代理
		IAnimal dog = CglibProxy.proxyTarget(new Dog());
		result = dog.active("shout");
		System.out.println("dog active result:" + result);
	}

}
