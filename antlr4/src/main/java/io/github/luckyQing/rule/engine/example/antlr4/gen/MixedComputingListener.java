package io.github.luckyQing.rule.engine.example.antlr4.gen;// Generated from MixedComputing.g4 by ANTLR 4.9.3

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MixedComputingParser}.
 */
public interface MixedComputingListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link MixedComputingParser#prog}.
     *
     * @param ctx the parse tree
     */
    void enterProg(MixedComputingParser.ProgContext ctx);

    /**
     * Exit a parse tree produced by {@link MixedComputingParser#prog}.
     *
     * @param ctx the parse tree
     */
    void exitProg(MixedComputingParser.ProgContext ctx);

    /**
     * Enter a parse tree produced by the {@code AddOrSub}
     * labeled alternative in {@link MixedComputingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterAddOrSub(MixedComputingParser.AddOrSubContext ctx);

    /**
     * Exit a parse tree produced by the {@code AddOrSub}
     * labeled alternative in {@link MixedComputingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitAddOrSub(MixedComputingParser.AddOrSubContext ctx);

    /**
     * Enter a parse tree produced by the {@code Single}
     * labeled alternative in {@link MixedComputingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterSingle(MixedComputingParser.SingleContext ctx);

    /**
     * Exit a parse tree produced by the {@code Single}
     * labeled alternative in {@link MixedComputingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitSingle(MixedComputingParser.SingleContext ctx);

    /**
     * Enter a parse tree produced by the {@code Lieteral}
     * labeled alternative in {@link MixedComputingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterLieteral(MixedComputingParser.LieteralContext ctx);

    /**
     * Exit a parse tree produced by the {@code Lieteral}
     * labeled alternative in {@link MixedComputingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitLieteral(MixedComputingParser.LieteralContext ctx);

    /**
     * Enter a parse tree produced by the {@code MultiOrDiv}
     * labeled alternative in {@link MixedComputingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterMultiOrDiv(MixedComputingParser.MultiOrDivContext ctx);

    /**
     * Exit a parse tree produced by the {@code MultiOrDiv}
     * labeled alternative in {@link MixedComputingParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitMultiOrDiv(MixedComputingParser.MultiOrDivContext ctx);
}