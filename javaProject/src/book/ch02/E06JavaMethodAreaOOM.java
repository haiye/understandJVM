package book.ch02;

/**
 * VM Args�� -XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * need to CGLibֱ�Ӳ����ֽ�������ʱ���ɴ����Ķ�̬��
 * http://cglib.sourceforge.net/
 * @author zzm
 */
public class E06JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(OOMObject.class);
//            enhancer.setUseCache(false);
//            enhancer.setCallback(new MethodInterceptor() {
//                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//                    return proxy.invokeSuper(obj, args);
//                }
//            });
//            enhancer.create();
        }
    }

    static class OOMObject {

    }
}

