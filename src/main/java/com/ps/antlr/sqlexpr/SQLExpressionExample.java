package com.ps.antlr.sqlexpr;

import com.ps.antlr.sqlexpr.parser.SQLExpressionLexer;
import com.ps.antlr.sqlexpr.parser.SQLExpressionParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SQLExpressionExample {

    public static void main(String[] args) throws IOException {
        CharStream charStream = new ANTLRInputStream(new ByteArrayInputStream("(name = \"dfdf\") AND (name = \"fdf\")".getBytes()));
        SQLExpressionLexer lexer = new SQLExpressionLexer(charStream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        SQLExpressionParser parser = new SQLExpressionParser(tokenStream);
        ParseTree tree = parser.expr();
        System.out.println(tree.toStringTree(parser));
    }


}
