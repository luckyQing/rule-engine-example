package io.github.luckyQing.rule.engine.example.antlr4.service;

import io.github.luckyQing.rule.engine.example.antlr4.gen.MixedComputingBaseVisitor;
import io.github.luckyQing.rule.engine.example.antlr4.gen.MixedComputingParser;

import java.util.Objects;

public class EvalExprMixedComputingVisitor extends MixedComputingBaseVisitor<Integer> {

    /**
     * 入口处调用
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Integer visitProg(MixedComputingParser.ProgContext ctx) {
        MixedComputingParser.ExprContext expr = ctx.expr();
        return visit(expr);
    }

    /**
     * expr ('*'|'/') expr
     */
    @Override
    public Integer visitMultiOrDiv(MixedComputingParser.MultiOrDivContext ctx) {
        Integer op1 = visit(ctx.expr(0));
        Integer op2 = visit(ctx.expr(1));

        String operator = ctx.getChild(1).getText();
        if (Objects.equals(operator, "*")) {
            return op1 * op2;
        }

        if (Objects.equals(operator, "/")) {
            return op1 / op2;
        }

        return 0;
    }

    /**
     * expr ('+'|'-') expr
     */
    @Override
    public Integer visitAddOrSub(MixedComputingParser.AddOrSubContext ctx) {
        Integer op1 = visit(ctx.expr(0));
        Integer op2 = visit(ctx.expr(1));

        String operator = ctx.getChild(1).getText();
        if (Objects.equals(operator, "+")) {
            return op1 + op2;
        }

        if (Objects.equals(operator, "-")) {
            return op1 - op2;
        }

        return 0;
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Integer visitSingle(MixedComputingParser.SingleContext ctx) {
        return visit(ctx);
    }

    /**
     * INT
     *
     * @return
     */
    @Override
    public Integer visitLieteral(MixedComputingParser.LieteralContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

}