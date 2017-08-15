package ConcurrentTools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Total {

    public static void main(String[] args) {
        TotalService totalService = new TotalServiceImpl();
        CyclicBarrier barrier = new CyclicBarrier(5, new TotalTask(totalService));

        // ʵ��ϵͳ�ǲ������ʡ����code���б�Ȼ��ѭ����ÿ��code����һ���̡߳�
        new BillTask(new BillServiceImpl(), barrier, "����").start();
        new BillTask(new BillServiceImpl(), barrier, "�Ϻ�").start();
        new BillTask(new BillServiceImpl(), barrier, "����").start();
        new BillTask(new BillServiceImpl(), barrier, "�Ĵ�").start();
        new BillTask(new BillServiceImpl(), barrier, "������").start();
    }

}


/**
 * �����񣺻�������
 */
class TotalTask implements Runnable {
    private TotalService totalService;

    TotalTask(TotalService totalService) {
        this.totalService = totalService;
    }

    public void run() {
        // ��ȡ�ڴ��и�ʡ�����ݻ��ܣ������ԡ�
        totalService.count();
        System.out.println("��ʼȫ������");
    }

}


/**
 * �����񣺼Ʒ�����
 */
class BillTask extends Thread {
    private BillService billService;     // �Ʒѷ���
    private CyclicBarrier barrier;
    private String code;    // ���룬��ʡ������࣬��ʡ���ݿ������

    BillTask(BillService billService, CyclicBarrier barrier, String code) {
        this.billService = billService;
        this.barrier = barrier;
        this.code = code;
    }

    public void run() {
        System.out.println("��ʼ����--" + code + "ʡ--���ݣ�");
        billService.bill(code);

        // ��bill������������ڴ棬��ConcurrentHashMap,vector��,������
        System.out.println(code + "ʡ�Ѿ��������,��֪ͨ����Service��");
        try {
            // ֪ͨbarrier�Ѿ����
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}


interface BillService {
    public void bill(String code);
}

interface TotalService {
    public void count();
}


class BillServiceImpl implements BillService{

    @Override
    public void bill(String code) {}
}

class TotalServiceImpl implements TotalService{

    @Override
    public void count(){}
}
