// Generated from C:/Projects/tutorials/antlr-parser/src/main/antlr\SQLExpression.g4 by ANTLR 4.6
package com.ps.antlr.sqlexpr.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLExpressionParser}.
 */
public interface SQLExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SQLExpressionParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SQLExpressionParser.ExprContext ctx);
}