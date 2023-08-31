package io.github.luckyQing.rule.engine.example.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class AppTest {

    @Test
    void test() throws Exception {
        ExpressRunner runner = new ExpressRunner(true, false);
        runner.setShortCircuit(true);
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("$a", 1);
        context.put("$b", 2);
        context.put("$c", 3);
        String express = "max($a,$c,$b)";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);

        String[] varNames = runner.getOutVarNames(express);
        for (String varName : varNames) {
            System.out.println(varName);
        }
    }

    @Test
    void testMap() throws Exception {
        ExpressRunner runner = new ExpressRunner(true, false);
        runner.setShortCircuit(true);
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("uid", 7);
        String express = "Map creditResult = new HashMap();\n" +
                "if(uid<10){\n" +
                "creditResult.put(\"amount\", 500);\n" +
                "creditResult.put(\"level\", \"5\");\n" +
                "creditResult.put(\"approval_result\", \"pass\");\n" +
                "} else {\n" +
                "creditResult.put(\"approval_result\", \"reject\");\n" +
                "}\n" +
                "return creditResult;";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }

    @Test
    void testMap2() throws Exception {
        ExpressRunner runner = new ExpressRunner(true, false);
        runner.setShortCircuit(true);
        runner.addFunctionOfClassMethod("#", HashMap.class.getName(), "put", new String[]{"Object", "Object"}, null);
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("uid", 7);
        String express = "if(uid<10){\n" +
                "NewMap(\"amount\":500, \"level\":\"5\", \"approval_result\":\"pass\")\n" +
                "}else {\n" +
                "NewMap(\"approval_result\":\"reject\")\n" +
                "}";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }

    @Test
    void testMap3() throws Exception {
        ExpressRunner runner = new ExpressRunner(true, false);
        runner.setShortCircuit(true);
        runner.replaceOperator("=",  new EnhanceOperatorEvaluate("="));
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("uid", 7);
//        String express = "if(uid<10){\n" +
//                "#amount=500\n" +
//                "#level=\"5\"\n" +
//                "#approval_result=\"pass\"\n" +
//                "}else {\n" +
//                "#approval_result=\"reject\"\n" +
//                "}";
        String express = "if(uid<10){\n" +
                "1#amount\n" +
                "2#level\n" +
                "}else {\n" +
                "3#approval_result\n" +
                "}";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }

}