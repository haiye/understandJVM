package book.ch02;

/**
 * VM Args：-Xss2M （这时候不妨设大些）
 * @author zzm
 */
public class E03JavaVMStackOOM {
 
       private void dontStop() {
              while (true) {
              }
       }
 
       public void stackLeakByThread() {
              while (true) {
                     Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                   dontStop();
                            }
                     });
                     thread.start();
              }
       }
 
       public static void main(String[] args) throws Throwable {
              E03JavaVMStackOOM oom = new E03JavaVMStackOOM();
              oom.stackLeakByThread();
       }
}

