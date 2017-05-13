package com.ps.antlr.arexpr;

import com.ps.antlr.arexpr.parser.ArExpressionBaseVisitor;
import com.ps.antlr.arexpr.parser.ArExpressionLexer;
import com.ps.antlr.arexpr.parser.ArExpressionParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ArExpressionExample {

    public static void main(String[] args) throws IOException {
        CharStream charStream = new ANTLRInputStream(new ByteArrayInputStream("a = 1 + (2 * 3) \n".getBytes()));
        ArExpressionLexer lexer = new ArExpressionLexer(charStream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        ArExpressionParser parser = new ArExpressionParser(tokenStream);
        ParseTree tree = parser.prog();
        // System.out.println(tree.toStringTree(parser));
        EvalVisitor eval = new EvalVisitor();
        System.out.println(eval.visit(tree));
    }

    public static class EvalVisitor extends ArExpressionBaseVisitor<Integer> {

        Map<String, Integer> memory = new HashMap<>();

        @Override
        public Integer visitAssign(ArExpressionParser.AssignContext ctx) {
            String id = ctx.ID().getText(); // id is left-hand side of '='
            int value = visit(ctx.expr()); // compute value of expression on right
            memory.put(id, value); // store it in our memory
            return value;
        }

        @Override
        public Integer visitPrintExpr(ArExpressionParser.PrintExprContext ctx) {
            Integer value = visit(ctx.expr()); // evaluate the expr child
            System.out.println(value); // print the result
            return 0; // return dummy value
        }

        @Override
        public Integer visitParens(ArExpressionParser.ParensContext ctx) {
            return visit(ctx.expr()); // return child expr's value
        }

        @Override
        public Integer visitMulDiv(ArExpressionParser.MulDivContext ctx) {
            int left = visit(ctx.expr(0)); // get value of left subexpression
            int right = visit(ctx.expr(1)); // get value of right subexpression
            String op = ctx.getChild(1).getText();
            if (op.equals("*"))
                return left * right;
            return left / right; // must be DIV
        }

        @Override
        public Integer visitAddSub(ArExpressionParser.AddSubContext ctx) {
            int left = visit(ctx.expr(0)); // get value of left subexpression
            int right = visit(ctx.expr(1)); // get value of right subexpression
            String op = ctx.getChild(1).getText();
            if (op.equals("+"))
                return left + right;
            return left - right; // must be SUB
        }

        @Override
        public Integer visitId(ArExpressionParser.IdContext ctx) {
            String id = ctx.ID().getText();
            if (memory.containsKey(id)) return memory.get(id);
            return 0;
        }

        @Override
        public Integer visitInt(ArExpressionParser.IntContext ctx) {
            return Integer.valueOf(ctx.INT().getText());
        }
    }

}
