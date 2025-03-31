package io.github.luckyQing.rule.engine.example.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

import java.util.Map;
import java.util.stream.Collectors;

public class QLExpressEnhancer {

    private final ExpressRunner runner;

    /**
     * 默认构造（开启安全模式）
     */
    public QLExpressEnhancer() {
        this.runner = new ExpressRunner(true, true);
    }

    /**
     * 自定义配置构造
     *
     * @param isSafe
     * @param isTrace
     */
    public QLExpressEnhancer(boolean isSafe, boolean isTrace) {
        this.runner = new ExpressRunner(isSafe, isTrace);
    }

    /**
     * 执行脚本并返回所有变量（Map）
     *
     * @param script    QLExpress脚本
     * @param inputVars 初始参数（可为空）
     * @return 包含所有计算后变量的Map
     */
    public Map<String, Object> execute(String script, Map<String, Object> inputVars) throws Exception {
        DefaultContext<String, Object> context = new DefaultContext<>();
        // 1、注入输入参数
        if (inputVars != null) {
            context.putAll(inputVars);
        }


        // 2、执行脚本（忽略返回值，专注于上下文变量）
        runner.execute(script, context, null, true, false);

        // 3、收集输出参数（仅收集#开头的变量）
        return context.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith("#"))
                .collect(Collectors.toMap(
                        entry -> entry.getKey().substring(1),
                        Map.Entry::getValue
                ));
    }

}