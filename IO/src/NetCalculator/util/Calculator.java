package NetCalculator.util;

/**
 * Created by Administrator on 2017/8/11 0011.
 */
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public enum Calculator {
    Instance;

    private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");

    public Object cal(String expression) throws ScriptException{
        return jse.eval(expression);
    }
}
