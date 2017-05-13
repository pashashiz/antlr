grammar SQLExpression;

expr: '(' expr ')' ' ' ('AND'|'OR') ' ' '(' expr ')'
    | FIELD ' ' ('='|'!='|'>'|'>='|'<'|'<=') ' ' STRING
    ;

FIELD  : [a-zA-Z]+ ;
STRING: '\'' ( ~'\'' | '\'\'' )* '\'' ;

WS : [\r\n]+ -> skip ;