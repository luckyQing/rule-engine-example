package io.github.luckyQing.rule.engine.example.antlr4.gen.test;

import io.github.luckyQing.rule.engine.example.antlr4.gen.MixedComputingLexer;
import io.github.luckyQing.rule.engine.example.antlr4.gen.MixedComputingParser;
import io.github.luckyQing.rule.engine.example.antlr4.service.EvalExprMixedComputingVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MixedComputingTest {

    @Test
    public void test() {
        List<String> testSet = Arrays.asList(
                "1+2",
                "1+2+3*4",
                "3/3",
                "10/2",
                "5*5+10+5*5"
        );

        List<Integer> res = Arrays.asList(
                3, 15, 1, 5, 60
        );

        for (int i = 0; i < testSet.size(); i++) {
            // 构建字符流
            CodePointCharStream charStream = CharStreams.fromString(testSet.get(i));

            // 从字符流分析词法， 解析为token
            MixedComputingLexer lexer = new MixedComputingLexer(charStream);

            // 从token进行分析
            MixedComputingParser parser = new MixedComputingParser(new CommonTokenStream(lexer));

            // 使用监听器，遍历语法树，根据语法定义，prog为语法树的根节点
            MixedComputingParser.ProgContext prog = parser.prog();


            // 使用visitor，生成自定义的对象
            Integer result = prog.accept(new EvalExprMixedComputingVisitor());
            System.out.println(result);
            Assertions.assertThat(result).isEqualTo(res.get(i));
        }
    }
}