grammar gyhlng;

// ========== REGRAS DO PARSER (ANALISADOR SINTÁTICO) ==========
// Regra principal do programa
programa: PROGRAMA ID PONTO_VIRGULA declaracoes? bloco PONTO EOF;

// Declarações de variáveis
declaracoes: declaracao+;
declaracao: DECLARAR listaVars DOIS_PONTOS tipo PONTO_VIRGULA;
listaVars: VAR (VIRGULA VAR)*;
tipo: INTEGER | REAL | BOOLEAN;

// Bloco de comandos
bloco: INICIO comandos? FIM;
comandos: comando+;

// Versão com colchetes [DECLARAR] ... [PROGRAMA] ...
programaBr: DELIM_ABRE DECLARAR DELIM_FECHA declaracoesBr DELIM_ABRE PROGRAMA DELIM_FECHA comandosBr EOF;
declaracoesBr: declaracaoBr+;
declaracaoBr: VAR DOIS_PONTOS tipo;
comandosBr: comandoBr+;
comandoBr: atribuicaoBr
       | comandoLeituraBr
       | comandoEscritaBr
       | comandoCondicionalBr
       | comandoRepeticaoBr
       | subAlgBr
       ;
atribuicaoBr: VAR ATRIB expressao;
comandoLeituraBr: LER VAR;
comandoEscritaBr: IMPRIMIR (VAR | CADEIA);
comandoCondicionalBr: SE expressao ENTAO comandoBr (SENAO comandoBr)?;
comandoRepeticaoBr: ENQTO expressao comandoBr;
subAlgBr: INICIO comandosBr FIM;

// Comandos da linguagem
comando: atribuicao ';'
       | comandoLeitura ';'
       | comandoEscrita ';'
       | comandoCondicional ';'
       | comandoRepeticao ';'
       | bloco
       ;

// Atribuição
atribuicao: VAR ATRIB expressao;

// Comando de leitura
comandoLeitura: LER ABRE_PAR VAR FECHA_PAR;

// Comando de escrita
comandoEscrita: IMPRIMIR ABRE_PAR expressao FECHA_PAR;

// Comando condicional
comandoCondicional: SE expressao ENTAO comando (SENAO comando)?;

// Comando de repetição
comandoRepeticao: ENQTO expressao FACA comando;

// Expressões
expressao: expressaoSimples (opRelacional expressaoSimples)?;
expressaoSimples: termo ((MAIS | MENOS | OU) termo)*;
termo: fator ((MULT | DIV | E) fator)*;
fator: VAR
     | numero
     | CADEIA
     | VERDADEIRO
     | FALSO
     | ABRE_PAR expressao FECHA_PAR
     | NAO fator
     ;

numero: NumInt | NumReal;
opRelacional: MENOR | MENOR_IGUAL | MAIOR | MAIOR_IGUAL | IGUAL | DIFERENTE;

// ========== REGRAS DO LEXER (ANALISADOR LÉXICO) ==========

// Palavras-chave
PROGRAMA: 'PROGRAMA';
DECLARAR: 'DECLARAR';
INTEGER: 'INTEGER';
REAL: 'REAL';
BOOLEAN: 'BOOLEAN';
INICIO: 'INICIO';
FIM: 'FIM' | 'FINAL';
SE: 'SE';
ENTAO: 'ENTAO';
SENAO: 'SENAO';
ENQTO: 'ENQTO';
FACA: 'FACA';
LER: 'LER';
IMPRIMIR: 'IMPRIMIR';
VERDADEIRO: 'VERDADEIRO';
FALSO: 'FALSO';
E: 'E';
OU: 'OU';
NAO: 'NAO';

// Operadores
ATRIB: ':=';
IGUAL: '==' | '=';
DIFERENTE: '!=' | '<>';
MENOR: '<';
MENOR_IGUAL: '<=';
MAIOR: '>';
MAIOR_IGUAL: '>=';
MAIS: '+';
MENOS: '-';
MULT: '*';
DIV: '/';

// Delimitadores
PONTO_VIRGULA: ';';
VIRGULA: ',';
DOIS_PONTOS: ':';
PONTO: '.';
ABRE_PAR: '(';
FECHA_PAR: ')';
DELIM_ABRE: '[';
DELIM_FECHA: ']';

// Identificadores e números
VAR: [a-z] [a-z0-9]*;
ID: [A-Za-z] [A-Za-z0-9_]*;
NumInt: [0-9]+;
NumReal: [0-9]+ '.' [0-9]+;
CADEIA: '"' (~['"'\r\n])* '"';

// Comentários
COMENTARIO: '{' .*? '}' -> skip;
COMENTARIO_LINHA: '//' ~[\r\n]* -> skip;

// Espaços em branco
WS: [ \t\r\n]+ -> skip;