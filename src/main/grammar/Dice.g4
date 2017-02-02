grammar Dice;
@header {
package generated.dice;
}
parse: EOF;

WS: [ \n\t\r]+ -> channel(HIDDEN);
