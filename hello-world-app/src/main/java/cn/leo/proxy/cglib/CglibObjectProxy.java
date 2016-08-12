package cn.leo.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibObjectProxy {

	public static <K> Object createProxyObject(final Object object, Class<K> clazz) {
		// 声明增加类实例
		Enhancer en = new Enhancer();
		// 设置被代理字节码，CGLIB根据字节码生成被代理类的子类
		en.setSuperclass(clazz);
		// 设置回调函数，即一个方法拦截
		en.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				//注意参数object，仍然为外部声明的源对象，且Method为JDK的Method反射
				System.out.println(method+" in intercept...");
				Object o=method.invoke(object, args);
				return o;
			}
		});
		return en.create();
	}

	public static void main(String[] args) {
		//未实现接口的类的代理
		Person proxyPerson=(Person) CglibObjectProxy.createProxyObject(new Person(), Person.class);
		String result=proxyPerson.active("sing a song");
		System.out.println("person active result:"+result);
		//实现接口的类的代理
		IAnimal proxyDog=(IAnimal) CglibObjectProxy.createProxyObject(new Dog(), Dog.class);
		result=proxyDog.active("shout");
		System.out.println("dog active result:"+ result);
	}

}
