package io.github.luckyQing.rule.engine.example.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.EvalMode;
import com.googlecode.aviator.Expression;
import org.junit.jupiter.api.Test;


class AppTest {

    @Test
    void test() {
        // 创建解释器
        AviatorEvaluatorInstance engine = AviatorEvaluator.newInstance(EvalMode.INTERPRETER);

        Expression exp = engine.compile("score > 80 ? 'good' : 'bad'");
        System.out.println(exp.execute(exp.newEnv("score", 100)));
        System.out.println(exp.execute(exp.newEnv("score", 50)));
    }

    @Test
    void test2() {
        // 创建解释器
        AviatorEvaluatorInstance engine = AviatorEvaluator.newInstance(EvalMode.INTERPRETER);

        Expression exp = engine.compile("score > 80");
        System.out.println(exp.execute(exp.newEnv("score", 100)));
        System.out.println(exp.execute(exp.newEnv("score", 50)));
    }

}