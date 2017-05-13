grammar ArExpression;

/** The start rule; begin parsing here. */
prog: stat+;

stat: expr NEWLINE           # printExpr
    | ID '=' expr NEWLINE    # assign
    | NEWLINE                # blank
    ;

expr: expr ('*'|'/') expr    # MulDiv
    | expr ('+'|'-') expr    # AddSub
    | INT                    # int
    | ID                     # id
    | '(' expr ')'           # parens
    ;

ID  : [a-zA-Z]+ ;            // match identifiers
INT : [0-9]+ ;               // match integers
NEWLINE: '\r'? '\n' ;        // return newlines to parser (is end-statement signal)
WS  : [ \t]+ -> skip ;       // toss out whitespace
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;