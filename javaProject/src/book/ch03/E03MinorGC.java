package book.ch03;

public class E03MinorGC {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * 
     * 
-Xms20M -Xmx20M -Xmn10M：限制Java堆大小为20MB，其中10MB分配给新生代，剩余10MB分配给老年代
-XX:SurvivorRatio=8：新生代中Eden:Survivor:Survivor=8:1:1，故eden:from:to=8192K(8MB):1024K(1MB):1024K(1MB)，故新生代总可用空间为9216KB（eden+1个survivor）
当分配了allocation1, allocation2, allocation3三个对象后，当分配allocation4的时候，发现剩余的eden空间已经不到4MB，故触发一次minorGC
这时，又发现allocation1, allocation2, allocation3三个对象都是存活的，又无法放入Survivor空间中，只好将allocation1, allocation2, allocation3三个对象转移到老年代中
GC之后，Eden空间被清空，最终可以分配allocation4（4MB）对象
故最后：allocation4分配在Eden， allocation1, allocation2, allocation3被分配在老年代中

      */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];  // 出现一次Minor GC
     }

    public static void main(String[] args) {
        testAllocation();
    }
}
