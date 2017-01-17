package book.ch03;
/**
 * testGC()方法执行后，objA和objB会不会被GC呢？ 
 * @author zzm
 */
public class E01ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员属性的唯一意义就是占点内存，以便在能在GC日志中看清楚是否有回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        E01ReferenceCountingGC objA = new E01ReferenceCountingGC();
        E01ReferenceCountingGC objB = new E01ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 假设在这行发生GC，objA和objB是否能被回收？
        System.gc();
    }

}

