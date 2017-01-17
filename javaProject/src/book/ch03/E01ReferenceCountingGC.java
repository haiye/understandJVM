package book.ch03;
/**
 * testGC()����ִ�к�objA��objB�᲻�ᱻGC�أ� 
 * @author zzm
 */
public class E01ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     * �����Ա���Ե�Ψһ�������ռ���ڴ棬�Ա�������GC��־�п�����Ƿ��л��չ�
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        E01ReferenceCountingGC objA = new E01ReferenceCountingGC();
        E01ReferenceCountingGC objB = new E01ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // ���������з���GC��objA��objB�Ƿ��ܱ����գ�
        System.gc();
    }

}

