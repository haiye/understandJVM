package book.ch03;

public class E04BigObjToOldGen {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM������-XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     * 3145728/1024/1024=3MB
     * ����3MB�Ķ���ֱ�ӽ��������
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];  //ֱ�ӷ������������
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
