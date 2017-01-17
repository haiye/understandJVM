package book.ch03;

public class E05ObjToOldGenAfterMinorGC {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM������-XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     * -XX:+PrintTenuringDistribution
     * 
     * -XX:MaxTenuringThreshold=1�������ڵڶ��η���GCʱ�ͽ��������
     * -XX:MaxTenuringThreshold=15�������ڵڶ��η���GCʱ��ͣ������������Survivor�ռ�
     * 
     */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];  // ʲôʱ����������������XX:MaxTenuringThreshold����
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testTenuringThreshold();
    }
}
