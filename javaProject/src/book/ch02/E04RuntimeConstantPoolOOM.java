package book.ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args��-XX:PermSize=3M -XX:MaxPermSize=3M
 * @author zzm
 */
public class E04RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        // ʹ��List�����ų��������ã�����Full GC���ճ�������Ϊ
        List<String> list = new ArrayList<String>();
        // 3MB��PermSize��integer��Χ���㹻����OOM��
        int i = 0; 
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}

