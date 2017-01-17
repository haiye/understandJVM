package book.ch03;

public class E06SameAgeObj {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM������-XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
     * -XX:+PrintTenuringDistribution
     * 
 Ϊ�˸��õ���Ӧ��ͬ�̶ȵ��ڴ�״�����������������ԶҪ�������������ﵽMaxTenuringThreshold���ܽ��������
����Survivor�ռ�����ͬ�������ж����С���ܺʹ���Survivor�ռ��һ�룬������ڻ���ڸ�����Ķ���Ϳ���ֱ�ӽ��������

������ allocation1��allocation2���󶼽��������������û�еȵ�15����ٽ����䣬��Ϊ����������������ﵽ��512KB��������ͬ��ģ�����ͬ�����ﵽSurvivor�ռ��һ��Ĺ���
��Ȼ������ֻ��ע�͵�����һ�������new�������ͻᷢ������һ���Ͳ�����������������
     */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];   // allocation1+allocation2����survivo�ռ�һ��
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
