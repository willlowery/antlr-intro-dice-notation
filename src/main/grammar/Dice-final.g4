grammar Dice;
@header {
package generated.dice;
}

parse: (diceNotation ';')* EOF;

diceNotation:  dieOrNumber (operator dieOrNumber)*;

dieRoll: INTEGER D INTEGER;

operator: PLUS | MINUS;
dieOrNumber: (dieRoll | INTEGER);


PLUS: '+';
MINUS: '-';
D: [dD];
INTEGER: [0-9]+;

WS: [ \n\t\r]+ -> channel(HIDDEN);
