grammar Cymbol;

// Example:
// int g = 9;
// int fact(int x) {
//     if (x == 0)
//     then return 1;
//     return x * fact(x + (-1));
// }

file: (functionDecl | varDecl)+;
varDecl: type ID ('=' expr)? ';';
functionDecl: type ID '(' formalParameters? ')' block;
formalParameters: formalParameter (',' formalParameter)*;
formalParameter: type ID;
block: '{' stat* '}';
stat: block
    | varDecl
    | 'if' expr 'then' stat ('else' stat)?
    | 'return' expr ';'
    | expr '=' expr ';'
    | expr ';'
    | ';'
    ;
expr: ID '(' exprList? ')'  // func call like f(), f(x), f(1,2)
    | expr '[' expr ']'     // array index like a[i], a[i][j]
    | '-' expr              // unary minus
    | '!' expr              // boolean not
    | expr ('*'|'/') expr
    | expr ('+'|'-') expr
    | expr '==' expr
    | ID
    | NUMBER
    | STRING
    | '(' expr ')'
    ;
exprList: expr (',' expr)*; // arg list

type: 'float' | 'int' | 'boolean' | 'void';

ID: LETTER ( LETTER | DIGIT )*;
STRING: '"' ( '\\"' | . )*? '"';
NUMBER: '-'? ( '.' DIGIT+ | DIGIT+ ( '.' DIGIT* )? );

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

WS: [ \t\n\r]+ -> skip;