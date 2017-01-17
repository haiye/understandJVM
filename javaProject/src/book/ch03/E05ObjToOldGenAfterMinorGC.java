package book.ch03;

public class E05ObjToOldGenAfterMinorGC {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     * -XX:+PrintTenuringDistribution
     * 
     * -XX:MaxTenuringThreshold=1：对象在第二次发生GC时就进入老年代
     * -XX:MaxTenuringThreshold=15：对象在第二次发生GC时还停留在新生代的Survivor空间
     * 
     */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];  // 什么时候进入老年代决定于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testTenuringThreshold();
    }
}
