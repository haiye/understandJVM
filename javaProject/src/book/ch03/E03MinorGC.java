package book.ch03;

public class E03MinorGC {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM������-XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * 
     * 
-Xms20M -Xmx20M -Xmn10M������Java�Ѵ�СΪ20MB������10MB�������������ʣ��10MB����������
-XX:SurvivorRatio=8����������Eden:Survivor:Survivor=8:1:1����eden:from:to=8192K(8MB):1024K(1MB):1024K(1MB)�����������ܿ��ÿռ�Ϊ9216KB��eden+1��survivor��
��������allocation1, allocation2, allocation3��������󣬵�����allocation4��ʱ�򣬷���ʣ���eden�ռ��Ѿ�����4MB���ʴ���һ��minorGC
��ʱ���ַ���allocation1, allocation2, allocation3���������Ǵ��ģ����޷�����Survivor�ռ��У�ֻ�ý�allocation1, allocation2, allocation3��������ת�Ƶ��������
GC֮��Eden�ռ䱻��գ����տ��Է���allocation4��4MB������
�����allocation4������Eden�� allocation1, allocation2, allocation3���������������

      */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];  // ����һ��Minor GC
     }

    public static void main(String[] args) {
        testAllocation();
    }
}
