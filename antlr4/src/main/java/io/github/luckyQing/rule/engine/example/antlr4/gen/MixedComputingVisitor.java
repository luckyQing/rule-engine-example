package io.github.luckyQing.rule.engine.example.antlr4.gen;// Generated from MixedComputing.g4 by ANTLR 4.9.3

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MixedComputingParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface MixedComputingVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link MixedComputingParser#prog}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProg(MixedComputingParser.ProgContext ctx);

    /**
     * Visit a parse tree produced by the {@code AddOrSub}
     * labeled alternative in {@link MixedComputingParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAddOrSub(MixedComputingParser.AddOrSubContext ctx);

    /**
     * Visit a parse tree produced by the {@code Single}
     * labeled alternative in {@link MixedComputingParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSingle(MixedComputingParser.SingleContext ctx);

    /**
     * Visit a parse tree produced by the {@code Lieteral}
     * labeled alternative in {@link MixedComputingParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLieteral(MixedComputingParser.LieteralContext ctx);

    /**
     * Visit a parse tree produced by the {@code MultiOrDiv}
     * labeled alternative in {@link MixedComputingParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMultiOrDiv(MixedComputingParser.MultiOrDivContext ctx);
}