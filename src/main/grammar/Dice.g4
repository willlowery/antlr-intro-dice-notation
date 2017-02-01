grammar Dice;
@header {
package generated.dice;
}

parse: EOF;



PLUS: '+';
D: [dD];
INTEGER: [0-9]+;

WS: [ \n\t\r]+ -> channel(HIDDEN);
