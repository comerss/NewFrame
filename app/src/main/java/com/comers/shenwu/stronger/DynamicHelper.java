package com.comers.shenwu.stronger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicHelper {
    public static void main(String[] args) {
        ProductMachine productMachine = new ProductMachine();
//        DynamicHandler handler=new DynamicHandler(productMachine);
//        Machine proxy= (Machine) Proxy.newProxyInstance(ProductMachine.class.getClassLoader(),ProductMachine.class.getInterfaces(),handler);
//        proxy.doSomeThing();


        DynamicHandler handler = new DynamicHandler();
        Machine machine = (Machine) handler.bind(productMachine, new Class[]{Machine.class});
        machine.doSomeThing();

    }


    static class DynamicHandler implements InvocationHandler {
        Object obj;

        //        public DynamicHandler(Object obj){
//            this.obj=obj;
//        }
        //对创建进行简单的封装
        public Object bind(Object target, Class[] interfaces) {
            this.obj = target;
            return Proxy.newProxyInstance(target.getClass().getClassLoader(), interfaces, this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("执行代理了");
            return method.invoke(obj, args);
        }
    }
}
