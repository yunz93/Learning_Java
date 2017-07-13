package Safety_Of_Thread;

import net.jcip.annotations.NotThreadSafe;

/**
 * 2-3 竞态条件之一：先检查后执行
 * 执行开始的时候，检查的结果也许已经失效了
 * 实例：延迟初始化
 * 将对象的初始化操作推迟到实际被使用时才进行，同时确保只被实例化一次
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
