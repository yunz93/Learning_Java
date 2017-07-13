package Safety_Of_Thread;

import net.jcip.annotations.NotThreadSafe;

/**
 * 2-3 ��̬����֮һ���ȼ���ִ��
 * ִ�п�ʼ��ʱ�򣬼��Ľ��Ҳ���Ѿ�ʧЧ��
 * ʵ�����ӳٳ�ʼ��
 * ������ĳ�ʼ�������Ƴٵ�ʵ�ʱ�ʹ��ʱ�Ž��У�ͬʱȷ��ֻ��ʵ����һ��
 * Created by Administrator on 2017/6/11 0011.
 */
@NotThreadSafe
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null)
            instance = new ExpensiveObject();
        return instance;
    }
}

class ExpensiveObject { }
