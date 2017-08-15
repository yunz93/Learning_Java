package ConcurrentTools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Exchanger;


/**
 * �����̼߳�����ݽ���
 */
public class ExchangerTest2 {
    private static final Exchanger<List<String>> ex = new Exchanger<List<String>>();
    private static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * �ڲ��࣬����������
     */
    class DataProducer implements Runnable {
        private List<String> list = new ArrayList<String>();

        public void run() {
            System.out.println("�����߿�ʼ��������");
            for (int i = 1; i <= 5; i++) {
                System.out.println("�����˵�" + i + "�����ݣ���ʱ1��");
                list.add("������" + i);
                sleep(1000);
            }
            System.out.println("�������ݽ���");
            System.out.println("��ʼ�������߽�������");

            try {
                //������׼�����ڽ����������������ߵ�����
                list = (List<String>) ex.exchange(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("�����������߽�������");
            System.out.println("�������������߽������ݺ�����������");
            for (int i = 6; i < 10; i++) {
                System.out.println("�����������˵�" + i + "�����ݣ���ʱ1��");
                list.add("������������" + i);
                sleep(1000);
            }

            System.out.println("���������߽����������");
            for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
                System.out.println(iterator.next());
            }
        }

    }


    /**
     * �ڲ��࣬����������
     */
    class DataConsumer implements Runnable {
        private List<String> list = new ArrayList<String>();

        public void run() {
            System.out.println("�����߿�ʼ��������");
            for (int i = 1; i <= 5; i++) {
                System.out.println("�����˵�" + i + "������");
                // �����߲������ݣ����潻����ʱ���������
                list.add("������" + i);
            }

            System.out.println("�������ݽ���");
            System.out.println("��ʼ�������߽�������");
            try {
                // �������ݽ��������������ߵ�����
                list = (List<String>) ex.exchange(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("�������������߽������ݺ�����������");
            for (int i = 6; i < 10; i++) {
                System.out.println("�����������˵�" + i + "������");
                list.add("������������" + i);
                sleep(1000);
            }
            sleep(1000);
            System.out.println("��ʼ���������߽����������");

            for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
                System.out.println(iterator.next());
            }
        }
    }

    // ������
    public static void main(String args[]) {
        ExchangerTest2 et = new ExchangerTest2();
        new Thread(et.new DataProducer()).start();
        new Thread(et.new DataConsumer()).start();
    }
}
