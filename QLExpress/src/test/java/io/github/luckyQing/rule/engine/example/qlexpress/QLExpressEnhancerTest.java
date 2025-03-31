package io.github.luckyQing.rule.engine.example.qlexpress;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class QLExpressEnhancerTest {

    @Test
    void testMap2() throws Exception {
        QLExpressEnhancer engine = new QLExpressEnhancer(true, false);

        // 定义初始参数
        Map<String, Object> params = new HashMap<>();
        params.put("$age", 6);

        // 定义计算逻辑脚本
        String script =
                "if ($age <= 18) {\n" +
                        "    #price_code = \"AAA\";\n" +
                        "    #credit_level = 1;\n" +
                        "    #credit_amount = 100000;\n" +
                        "} else if ($age > 18 && $age < 60) {\n" +
                        "    #price_code = \"BBB\";\n" +
                        "    #credit_level = 2;\n" +
                        "    #credit_amount = 200000;\n" +
                        "} else {\n" +
                        "    #price_code = \"CCC\";\n" +
                        "    #credit_level = 3;\n" +
                        "    #credit_amount = 1;\n" +
                        "}";
        // 执行脚本并获取所有变量
        Map<String, Object> result = engine.execute(script, params);

        // 输出结果
        System.out.println("全部变量: " + result);
    }

}