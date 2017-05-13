// Generated from C:/Projects/tutorials/antlr-parser/src/main/antlr\ArExpression.g4 by ANTLR 4.6
package com.ps.antlr.arexpr.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArExpressionParser}.
 */
public interface ArExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArExpressionParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ArExpressionParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArExpressionParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ArExpressionParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link ArExpressionParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(ArExpressionParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link ArExpressionParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(ArExpressionParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ArExpressionParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ArExpressionParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ArExpressionParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ArExpressionParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link ArExpressionParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(ArExpressionParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link ArExpressionParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(ArExpressionParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ArExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(ArExpressionParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ArExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(ArExpressionParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ArExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(ArExpressionParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ArExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(ArExpressionParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ArExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(ArExpressionParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ArExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(ArExpressionParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link ArExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(ArExpressionParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link ArExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(ArExpressionParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link ArExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(ArExpressionParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link ArExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(ArExpressionParser.IntContext ctx);
}