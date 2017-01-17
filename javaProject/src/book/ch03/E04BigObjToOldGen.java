package book.ch03;

public class E04BigObjToOldGen {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     * 3145728/1024/1024=3MB
     * 超过3MB的对象直接进入老年代
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];  //直接分配在老年代中
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
