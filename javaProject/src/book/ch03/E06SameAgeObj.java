package book.ch03;

public class E06SameAgeObj {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
     * -XX:+PrintTenuringDistribution
     * 
 为了更好地适应不同程度的内存状况，虚拟机并不是永远要求对象的年龄必须达到MaxTenuringThreshold才能晋升老年代
若在Survivor空间中相同年龄所有对象大小的总和大于Survivor空间的一半，年龄大于或等于该年龄的对象就可以直接进入老年代

下列中 allocation1和allocation2对象都进入了老年代，而没有等到15岁的临界年龄，因为这两个对象加起来达到了512KB，并且是同年的，满足同年对象达到Survivor空间的一半的规则
当然，我们只有注释掉其中一个对象的new操作，就会发现另外一个就不会晋升到老年代中了
     */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];   // allocation1+allocation2大于survivo空间一半
        allocation2 = new byte[_1MB / 4];  
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testTenuringThreshold2();
    }
}
