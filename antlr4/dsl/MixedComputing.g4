grammar MixedComputing;
prog:	expr EOF ;
expr:	expr ('*'|'/') expr  #MultiOrDiv
    |	expr ('+'|'-') expr  #AddOrSub
    |	INT     #Lieteral
    |	'(' expr ')'   #Single
    ;
NEWLINE : [\r\n]+ -> skip;
INT     : [0-9]+ ;