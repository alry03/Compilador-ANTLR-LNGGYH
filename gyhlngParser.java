// Generated from gyhlng.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gyhlngParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAMA=1, DECLARAR=2, INTEGER=3, REAL=4, BOOLEAN=5, INICIO=6, FIM=7, 
		SE=8, ENTAO=9, SENAO=10, ENQTO=11, FACA=12, LER=13, IMPRIMIR=14, VERDADEIRO=15, 
		FALSO=16, E=17, OU=18, NAO=19, ATRIB=20, IGUAL=21, DIFERENTE=22, MENOR=23, 
		MENOR_IGUAL=24, MAIOR=25, MAIOR_IGUAL=26, MAIS=27, MENOS=28, MULT=29, 
		DIV=30, PONTO_VIRGULA=31, VIRGULA=32, DOIS_PONTOS=33, PONTO=34, ABRE_PAR=35, 
		FECHA_PAR=36, DELIM_ABRE=37, DELIM_FECHA=38, VAR=39, ID=40, NumInt=41, 
		NumReal=42, CADEIA=43, COMENTARIO=44, COMENTARIO_LINHA=45, WS=46;
	public static final int
		RULE_programa = 0, RULE_declaracoes = 1, RULE_declaracao = 2, RULE_listaVars = 3, 
		RULE_tipo = 4, RULE_bloco = 5, RULE_comandos = 6, RULE_programaBr = 7, 
		RULE_declaracoesBr = 8, RULE_declaracaoBr = 9, RULE_comandosBr = 10, RULE_comandoBr = 11, 
		RULE_atribuicaoBr = 12, RULE_comandoLeituraBr = 13, RULE_comandoEscritaBr = 14, 
		RULE_comandoCondicionalBr = 15, RULE_comandoRepeticaoBr = 16, RULE_subAlgBr = 17, 
		RULE_comando = 18, RULE_atribuicao = 19, RULE_comandoLeitura = 20, RULE_comandoEscrita = 21, 
		RULE_comandoCondicional = 22, RULE_comandoRepeticao = 23, RULE_expressao = 24, 
		RULE_expressaoSimples = 25, RULE_termo = 26, RULE_fator = 27, RULE_numero = 28, 
		RULE_opRelacional = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaracoes", "declaracao", "listaVars", "tipo", "bloco", 
			"comandos", "programaBr", "declaracoesBr", "declaracaoBr", "comandosBr", 
			"comandoBr", "atribuicaoBr", "comandoLeituraBr", "comandoEscritaBr", 
			"comandoCondicionalBr", "comandoRepeticaoBr", "subAlgBr", "comando", 
			"atribuicao", "comandoLeitura", "comandoEscrita", "comandoCondicional", 
			"comandoRepeticao", "expressao", "expressaoSimples", "termo", "fator", 
			"numero", "opRelacional"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'PROGRAMA'", "'DECLARAR'", "'INTEGER'", "'REAL'", "'BOOLEAN'", 
			"'INICIO'", null, "'SE'", "'ENTAO'", "'SENAO'", "'ENQTO'", "'FACA'", 
			"'LER'", "'IMPRIMIR'", "'VERDADEIRO'", "'FALSO'", "'E'", "'OU'", "'NAO'", 
			"':='", null, null, "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", 
			"'/'", "';'", "','", "':'", "'.'", "'('", "')'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAMA", "DECLARAR", "INTEGER", "REAL", "BOOLEAN", "INICIO", 
			"FIM", "SE", "ENTAO", "SENAO", "ENQTO", "FACA", "LER", "IMPRIMIR", "VERDADEIRO", 
			"FALSO", "E", "OU", "NAO", "ATRIB", "IGUAL", "DIFERENTE", "MENOR", "MENOR_IGUAL", 
			"MAIOR", "MAIOR_IGUAL", "MAIS", "MENOS", "MULT", "DIV", "PONTO_VIRGULA", 
			"VIRGULA", "DOIS_PONTOS", "PONTO", "ABRE_PAR", "FECHA_PAR", "DELIM_ABRE", 
			"DELIM_FECHA", "VAR", "ID", "NumInt", "NumReal", "CADEIA", "COMENTARIO", 
			"COMENTARIO_LINHA", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "gyhlng.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gyhlngParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode PROGRAMA() { return getToken(gyhlngParser.PROGRAMA, 0); }
		public TerminalNode ID() { return getToken(gyhlngParser.ID, 0); }
		public TerminalNode PONTO_VIRGULA() { return getToken(gyhlngParser.PONTO_VIRGULA, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode PONTO() { return getToken(gyhlngParser.PONTO, 0); }
		public TerminalNode EOF() { return getToken(gyhlngParser.EOF, 0); }
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(PROGRAMA);
			setState(61);
			match(ID);
			setState(62);
			match(PONTO_VIRGULA);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DECLARAR) {
				{
				setState(63);
				declaracoes();
				}
			}

			setState(66);
			bloco();
			setState(67);
			match(PONTO);
			setState(68);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracoesContext extends ParserRuleContext {
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitDeclaracoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitDeclaracoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				declaracao();
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DECLARAR );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracaoContext extends ParserRuleContext {
		public TerminalNode DECLARAR() { return getToken(gyhlngParser.DECLARAR, 0); }
		public ListaVarsContext listaVars() {
			return getRuleContext(ListaVarsContext.class,0);
		}
		public TerminalNode DOIS_PONTOS() { return getToken(gyhlngParser.DOIS_PONTOS, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode PONTO_VIRGULA() { return getToken(gyhlngParser.PONTO_VIRGULA, 0); }
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitDeclaracao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitDeclaracao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(DECLARAR);
			setState(76);
			listaVars();
			setState(77);
			match(DOIS_PONTOS);
			setState(78);
			tipo();
			setState(79);
			match(PONTO_VIRGULA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaVarsContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(gyhlngParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(gyhlngParser.VAR, i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(gyhlngParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(gyhlngParser.VIRGULA, i);
		}
		public ListaVarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaVars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterListaVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitListaVars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitListaVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaVarsContext listaVars() throws RecognitionException {
		ListaVarsContext _localctx = new ListaVarsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_listaVars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(VAR);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(82);
				match(VIRGULA);
				setState(83);
				match(VAR);
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(gyhlngParser.INTEGER, 0); }
		public TerminalNode REAL() { return getToken(gyhlngParser.REAL, 0); }
		public TerminalNode BOOLEAN() { return getToken(gyhlngParser.BOOLEAN, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << REAL) | (1L << BOOLEAN))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public TerminalNode INICIO() { return getToken(gyhlngParser.INICIO, 0); }
		public TerminalNode FIM() { return getToken(gyhlngParser.FIM, 0); }
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitBloco(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitBloco(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(INICIO);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INICIO) | (1L << SE) | (1L << ENQTO) | (1L << LER) | (1L << IMPRIMIR) | (1L << VAR))) != 0)) {
				{
				setState(92);
				comandos();
				}
			}

			setState(95);
			match(FIM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandosContext extends ParserRuleContext {
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitComandos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitComandos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandosContext comandos() throws RecognitionException {
		ComandosContext _localctx = new ComandosContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_comandos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(97);
				comando();
				}
				}
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INICIO) | (1L << SE) | (1L << ENQTO) | (1L << LER) | (1L << IMPRIMIR) | (1L << VAR))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramaBrContext extends ParserRuleContext {
		public List<TerminalNode> DELIM_ABRE() { return getTokens(gyhlngParser.DELIM_ABRE); }
		public TerminalNode DELIM_ABRE(int i) {
			return getToken(gyhlngParser.DELIM_ABRE, i);
		}
		public TerminalNode DECLARAR() { return getToken(gyhlngParser.DECLARAR, 0); }
		public List<TerminalNode> DELIM_FECHA() { return getTokens(gyhlngParser.DELIM_FECHA); }
		public TerminalNode DELIM_FECHA(int i) {
			return getToken(gyhlngParser.DELIM_FECHA, i);
		}
		public DeclaracoesBrContext declaracoesBr() {
			return getRuleContext(DeclaracoesBrContext.class,0);
		}
		public TerminalNode PROGRAMA() { return getToken(gyhlngParser.PROGRAMA, 0); }
		public ComandosBrContext comandosBr() {
			return getRuleContext(ComandosBrContext.class,0);
		}
		public TerminalNode EOF() { return getToken(gyhlngParser.EOF, 0); }
		public ProgramaBrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programaBr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterProgramaBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitProgramaBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitProgramaBr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaBrContext programaBr() throws RecognitionException {
		ProgramaBrContext _localctx = new ProgramaBrContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_programaBr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(DELIM_ABRE);
			setState(103);
			match(DECLARAR);
			setState(104);
			match(DELIM_FECHA);
			setState(105);
			declaracoesBr();
			setState(106);
			match(DELIM_ABRE);
			setState(107);
			match(PROGRAMA);
			setState(108);
			match(DELIM_FECHA);
			setState(109);
			comandosBr();
			setState(110);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracoesBrContext extends ParserRuleContext {
		public List<DeclaracaoBrContext> declaracaoBr() {
			return getRuleContexts(DeclaracaoBrContext.class);
		}
		public DeclaracaoBrContext declaracaoBr(int i) {
			return getRuleContext(DeclaracaoBrContext.class,i);
		}
		public DeclaracoesBrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoesBr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterDeclaracoesBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitDeclaracoesBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitDeclaracoesBr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracoesBrContext declaracoesBr() throws RecognitionException {
		DeclaracoesBrContext _localctx = new DeclaracoesBrContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaracoesBr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(112);
				declaracaoBr();
				}
				}
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VAR );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracaoBrContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(gyhlngParser.VAR, 0); }
		public TerminalNode DOIS_PONTOS() { return getToken(gyhlngParser.DOIS_PONTOS, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DeclaracaoBrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoBr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterDeclaracaoBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitDeclaracaoBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitDeclaracaoBr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracaoBrContext declaracaoBr() throws RecognitionException {
		DeclaracaoBrContext _localctx = new DeclaracaoBrContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declaracaoBr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(VAR);
			setState(118);
			match(DOIS_PONTOS);
			setState(119);
			tipo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandosBrContext extends ParserRuleContext {
		public List<ComandoBrContext> comandoBr() {
			return getRuleContexts(ComandoBrContext.class);
		}
		public ComandoBrContext comandoBr(int i) {
			return getRuleContext(ComandoBrContext.class,i);
		}
		public ComandosBrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandosBr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterComandosBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitComandosBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitComandosBr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandosBrContext comandosBr() throws RecognitionException {
		ComandosBrContext _localctx = new ComandosBrContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_comandosBr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(121);
				comandoBr();
				}
				}
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INICIO) | (1L << SE) | (1L << ENQTO) | (1L << LER) | (1L << IMPRIMIR) | (1L << VAR))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoBrContext extends ParserRuleContext {
		public AtribuicaoBrContext atribuicaoBr() {
			return getRuleContext(AtribuicaoBrContext.class,0);
		}
		public ComandoLeituraBrContext comandoLeituraBr() {
			return getRuleContext(ComandoLeituraBrContext.class,0);
		}
		public ComandoEscritaBrContext comandoEscritaBr() {
			return getRuleContext(ComandoEscritaBrContext.class,0);
		}
		public ComandoCondicionalBrContext comandoCondicionalBr() {
			return getRuleContext(ComandoCondicionalBrContext.class,0);
		}
		public ComandoRepeticaoBrContext comandoRepeticaoBr() {
			return getRuleContext(ComandoRepeticaoBrContext.class,0);
		}
		public SubAlgBrContext subAlgBr() {
			return getRuleContext(SubAlgBrContext.class,0);
		}
		public ComandoBrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoBr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterComandoBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitComandoBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitComandoBr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoBrContext comandoBr() throws RecognitionException {
		ComandoBrContext _localctx = new ComandoBrContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comandoBr);
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				atribuicaoBr();
				}
				break;
			case LER:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				comandoLeituraBr();
				}
				break;
			case IMPRIMIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				comandoEscritaBr();
				}
				break;
			case SE:
				enterOuterAlt(_localctx, 4);
				{
				setState(129);
				comandoCondicionalBr();
				}
				break;
			case ENQTO:
				enterOuterAlt(_localctx, 5);
				{
				setState(130);
				comandoRepeticaoBr();
				}
				break;
			case INICIO:
				enterOuterAlt(_localctx, 6);
				{
				setState(131);
				subAlgBr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtribuicaoBrContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(gyhlngParser.VAR, 0); }
		public TerminalNode ATRIB() { return getToken(gyhlngParser.ATRIB, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public AtribuicaoBrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicaoBr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterAtribuicaoBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitAtribuicaoBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitAtribuicaoBr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuicaoBrContext atribuicaoBr() throws RecognitionException {
		AtribuicaoBrContext _localctx = new AtribuicaoBrContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_atribuicaoBr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(VAR);
			setState(135);
			match(ATRIB);
			setState(136);
			expressao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoLeituraBrContext extends ParserRuleContext {
		public TerminalNode LER() { return getToken(gyhlngParser.LER, 0); }
		public TerminalNode VAR() { return getToken(gyhlngParser.VAR, 0); }
		public ComandoLeituraBrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoLeituraBr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterComandoLeituraBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitComandoLeituraBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitComandoLeituraBr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoLeituraBrContext comandoLeituraBr() throws RecognitionException {
		ComandoLeituraBrContext _localctx = new ComandoLeituraBrContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comandoLeituraBr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(LER);
			setState(139);
			match(VAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoEscritaBrContext extends ParserRuleContext {
		public TerminalNode IMPRIMIR() { return getToken(gyhlngParser.IMPRIMIR, 0); }
		public TerminalNode VAR() { return getToken(gyhlngParser.VAR, 0); }
		public TerminalNode CADEIA() { return getToken(gyhlngParser.CADEIA, 0); }
		public ComandoEscritaBrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoEscritaBr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterComandoEscritaBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitComandoEscritaBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitComandoEscritaBr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoEscritaBrContext comandoEscritaBr() throws RecognitionException {
		ComandoEscritaBrContext _localctx = new ComandoEscritaBrContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_comandoEscritaBr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(IMPRIMIR);
			setState(142);
			_la = _input.LA(1);
			if ( !(_la==VAR || _la==CADEIA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoCondicionalBrContext extends ParserRuleContext {
		public TerminalNode SE() { return getToken(gyhlngParser.SE, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode ENTAO() { return getToken(gyhlngParser.ENTAO, 0); }
		public List<ComandoBrContext> comandoBr() {
			return getRuleContexts(ComandoBrContext.class);
		}
		public ComandoBrContext comandoBr(int i) {
			return getRuleContext(ComandoBrContext.class,i);
		}
		public TerminalNode SENAO() { return getToken(gyhlngParser.SENAO, 0); }
		public ComandoCondicionalBrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoCondicionalBr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterComandoCondicionalBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitComandoCondicionalBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitComandoCondicionalBr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoCondicionalBrContext comandoCondicionalBr() throws RecognitionException {
		ComandoCondicionalBrContext _localctx = new ComandoCondicionalBrContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comandoCondicionalBr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(SE);
			setState(145);
			expressao();
			setState(146);
			match(ENTAO);
			setState(147);
			comandoBr();
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(148);
				match(SENAO);
				setState(149);
				comandoBr();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoRepeticaoBrContext extends ParserRuleContext {
		public TerminalNode ENQTO() { return getToken(gyhlngParser.ENQTO, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ComandoBrContext comandoBr() {
			return getRuleContext(ComandoBrContext.class,0);
		}
		public ComandoRepeticaoBrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoRepeticaoBr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterComandoRepeticaoBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitComandoRepeticaoBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitComandoRepeticaoBr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoRepeticaoBrContext comandoRepeticaoBr() throws RecognitionException {
		ComandoRepeticaoBrContext _localctx = new ComandoRepeticaoBrContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comandoRepeticaoBr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(ENQTO);
			setState(153);
			expressao();
			setState(154);
			comandoBr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubAlgBrContext extends ParserRuleContext {
		public TerminalNode INICIO() { return getToken(gyhlngParser.INICIO, 0); }
		public ComandosBrContext comandosBr() {
			return getRuleContext(ComandosBrContext.class,0);
		}
		public TerminalNode FIM() { return getToken(gyhlngParser.FIM, 0); }
		public SubAlgBrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subAlgBr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterSubAlgBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitSubAlgBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitSubAlgBr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubAlgBrContext subAlgBr() throws RecognitionException {
		SubAlgBrContext _localctx = new SubAlgBrContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_subAlgBr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(INICIO);
			setState(157);
			comandosBr();
			setState(158);
			match(FIM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoContext extends ParserRuleContext {
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public TerminalNode PONTO_VIRGULA() { return getToken(gyhlngParser.PONTO_VIRGULA, 0); }
		public ComandoLeituraContext comandoLeitura() {
			return getRuleContext(ComandoLeituraContext.class,0);
		}
		public ComandoEscritaContext comandoEscrita() {
			return getRuleContext(ComandoEscritaContext.class,0);
		}
		public ComandoCondicionalContext comandoCondicional() {
			return getRuleContext(ComandoCondicionalContext.class,0);
		}
		public ComandoRepeticaoContext comandoRepeticao() {
			return getRuleContext(ComandoRepeticaoContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitComando(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitComando(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_comando);
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				atribuicao();
				setState(161);
				match(PONTO_VIRGULA);
				}
				break;
			case LER:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				comandoLeitura();
				setState(164);
				match(PONTO_VIRGULA);
				}
				break;
			case IMPRIMIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				comandoEscrita();
				setState(167);
				match(PONTO_VIRGULA);
				}
				break;
			case SE:
				enterOuterAlt(_localctx, 4);
				{
				setState(169);
				comandoCondicional();
				setState(170);
				match(PONTO_VIRGULA);
				}
				break;
			case ENQTO:
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				comandoRepeticao();
				setState(173);
				match(PONTO_VIRGULA);
				}
				break;
			case INICIO:
				enterOuterAlt(_localctx, 6);
				{
				setState(175);
				bloco();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtribuicaoContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(gyhlngParser.VAR, 0); }
		public TerminalNode ATRIB() { return getToken(gyhlngParser.ATRIB, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitAtribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_atribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(VAR);
			setState(179);
			match(ATRIB);
			setState(180);
			expressao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoLeituraContext extends ParserRuleContext {
		public TerminalNode LER() { return getToken(gyhlngParser.LER, 0); }
		public TerminalNode ABRE_PAR() { return getToken(gyhlngParser.ABRE_PAR, 0); }
		public TerminalNode VAR() { return getToken(gyhlngParser.VAR, 0); }
		public TerminalNode FECHA_PAR() { return getToken(gyhlngParser.FECHA_PAR, 0); }
		public ComandoLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterComandoLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitComandoLeitura(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitComandoLeitura(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoLeituraContext comandoLeitura() throws RecognitionException {
		ComandoLeituraContext _localctx = new ComandoLeituraContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_comandoLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(LER);
			setState(183);
			match(ABRE_PAR);
			setState(184);
			match(VAR);
			setState(185);
			match(FECHA_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoEscritaContext extends ParserRuleContext {
		public TerminalNode IMPRIMIR() { return getToken(gyhlngParser.IMPRIMIR, 0); }
		public TerminalNode ABRE_PAR() { return getToken(gyhlngParser.ABRE_PAR, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FECHA_PAR() { return getToken(gyhlngParser.FECHA_PAR, 0); }
		public ComandoEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterComandoEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitComandoEscrita(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitComandoEscrita(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoEscritaContext comandoEscrita() throws RecognitionException {
		ComandoEscritaContext _localctx = new ComandoEscritaContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_comandoEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(IMPRIMIR);
			setState(188);
			match(ABRE_PAR);
			setState(189);
			expressao();
			setState(190);
			match(FECHA_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoCondicionalContext extends ParserRuleContext {
		public TerminalNode SE() { return getToken(gyhlngParser.SE, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode ENTAO() { return getToken(gyhlngParser.ENTAO, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public TerminalNode SENAO() { return getToken(gyhlngParser.SENAO, 0); }
		public ComandoCondicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoCondicional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterComandoCondicional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitComandoCondicional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitComandoCondicional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoCondicionalContext comandoCondicional() throws RecognitionException {
		ComandoCondicionalContext _localctx = new ComandoCondicionalContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_comandoCondicional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(SE);
			setState(193);
			expressao();
			setState(194);
			match(ENTAO);
			setState(195);
			comando();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(196);
				match(SENAO);
				setState(197);
				comando();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoRepeticaoContext extends ParserRuleContext {
		public TerminalNode ENQTO() { return getToken(gyhlngParser.ENQTO, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FACA() { return getToken(gyhlngParser.FACA, 0); }
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public ComandoRepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoRepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterComandoRepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitComandoRepeticao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitComandoRepeticao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoRepeticaoContext comandoRepeticao() throws RecognitionException {
		ComandoRepeticaoContext _localctx = new ComandoRepeticaoContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_comandoRepeticao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(ENQTO);
			setState(201);
			expressao();
			setState(202);
			match(FACA);
			setState(203);
			comando();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoContext extends ParserRuleContext {
		public List<ExpressaoSimplesContext> expressaoSimples() {
			return getRuleContexts(ExpressaoSimplesContext.class);
		}
		public ExpressaoSimplesContext expressaoSimples(int i) {
			return getRuleContext(ExpressaoSimplesContext.class,i);
		}
		public OpRelacionalContext opRelacional() {
			return getRuleContext(OpRelacionalContext.class,0);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitExpressao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitExpressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expressao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			expressaoSimples();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IGUAL) | (1L << DIFERENTE) | (1L << MENOR) | (1L << MENOR_IGUAL) | (1L << MAIOR) | (1L << MAIOR_IGUAL))) != 0)) {
				{
				setState(206);
				opRelacional();
				setState(207);
				expressaoSimples();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoSimplesContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> MAIS() { return getTokens(gyhlngParser.MAIS); }
		public TerminalNode MAIS(int i) {
			return getToken(gyhlngParser.MAIS, i);
		}
		public List<TerminalNode> MENOS() { return getTokens(gyhlngParser.MENOS); }
		public TerminalNode MENOS(int i) {
			return getToken(gyhlngParser.MENOS, i);
		}
		public List<TerminalNode> OU() { return getTokens(gyhlngParser.OU); }
		public TerminalNode OU(int i) {
			return getToken(gyhlngParser.OU, i);
		}
		public ExpressaoSimplesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoSimples; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterExpressaoSimples(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitExpressaoSimples(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitExpressaoSimples(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoSimplesContext expressaoSimples() throws RecognitionException {
		ExpressaoSimplesContext _localctx = new ExpressaoSimplesContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expressaoSimples);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			termo();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OU) | (1L << MAIS) | (1L << MENOS))) != 0)) {
				{
				{
				setState(212);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OU) | (1L << MAIS) | (1L << MENOS))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(213);
				termo();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(gyhlngParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(gyhlngParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(gyhlngParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(gyhlngParser.DIV, i);
		}
		public List<TerminalNode> E() { return getTokens(gyhlngParser.E); }
		public TerminalNode E(int i) {
			return getToken(gyhlngParser.E, i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitTermo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitTermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			fator();
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << E) | (1L << MULT) | (1L << DIV))) != 0)) {
				{
				{
				setState(220);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << E) | (1L << MULT) | (1L << DIV))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(221);
				fator();
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FatorContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(gyhlngParser.VAR, 0); }
		public NumeroContext numero() {
			return getRuleContext(NumeroContext.class,0);
		}
		public TerminalNode CADEIA() { return getToken(gyhlngParser.CADEIA, 0); }
		public TerminalNode VERDADEIRO() { return getToken(gyhlngParser.VERDADEIRO, 0); }
		public TerminalNode FALSO() { return getToken(gyhlngParser.FALSO, 0); }
		public TerminalNode ABRE_PAR() { return getToken(gyhlngParser.ABRE_PAR, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FECHA_PAR() { return getToken(gyhlngParser.FECHA_PAR, 0); }
		public TerminalNode NAO() { return getToken(gyhlngParser.NAO, 0); }
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitFator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitFator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_fator);
		try {
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				match(VAR);
				}
				break;
			case NumInt:
			case NumReal:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				numero();
				}
				break;
			case CADEIA:
				enterOuterAlt(_localctx, 3);
				{
				setState(229);
				match(CADEIA);
				}
				break;
			case VERDADEIRO:
				enterOuterAlt(_localctx, 4);
				{
				setState(230);
				match(VERDADEIRO);
				}
				break;
			case FALSO:
				enterOuterAlt(_localctx, 5);
				{
				setState(231);
				match(FALSO);
				}
				break;
			case ABRE_PAR:
				enterOuterAlt(_localctx, 6);
				{
				setState(232);
				match(ABRE_PAR);
				setState(233);
				expressao();
				setState(234);
				match(FECHA_PAR);
				}
				break;
			case NAO:
				enterOuterAlt(_localctx, 7);
				{
				setState(236);
				match(NAO);
				setState(237);
				fator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumeroContext extends ParserRuleContext {
		public TerminalNode NumInt() { return getToken(gyhlngParser.NumInt, 0); }
		public TerminalNode NumReal() { return getToken(gyhlngParser.NumReal, 0); }
		public NumeroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numero; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterNumero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitNumero(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitNumero(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumeroContext numero() throws RecognitionException {
		NumeroContext _localctx = new NumeroContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_numero);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_la = _input.LA(1);
			if ( !(_la==NumInt || _la==NumReal) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpRelacionalContext extends ParserRuleContext {
		public TerminalNode MENOR() { return getToken(gyhlngParser.MENOR, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(gyhlngParser.MENOR_IGUAL, 0); }
		public TerminalNode MAIOR() { return getToken(gyhlngParser.MAIOR, 0); }
		public TerminalNode MAIOR_IGUAL() { return getToken(gyhlngParser.MAIOR_IGUAL, 0); }
		public TerminalNode IGUAL() { return getToken(gyhlngParser.IGUAL, 0); }
		public TerminalNode DIFERENTE() { return getToken(gyhlngParser.DIFERENTE, 0); }
		public OpRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opRelacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).enterOpRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gyhlngListener ) ((gyhlngListener)listener).exitOpRelacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gyhlngVisitor ) return ((gyhlngVisitor<? extends T>)visitor).visitOpRelacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpRelacionalContext opRelacional() throws RecognitionException {
		OpRelacionalContext _localctx = new OpRelacionalContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_opRelacional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IGUAL) | (1L << DIFERENTE) | (1L << MENOR) | (1L << MENOR_IGUAL) | (1L << MAIOR) | (1L << MAIOR_IGUAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u00f7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\5\2C\n\2\3\2\3\2\3\2\3\2\3\3\6\3J\n\3\r\3\16\3K\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\7\5W\n\5\f\5\16\5Z\13\5\3\6\3\6\3\7\3\7\5\7`\n\7"+
		"\3\7\3\7\3\b\6\be\n\b\r\b\16\bf\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\6\nt\n\n\r\n\16\nu\3\13\3\13\3\13\3\13\3\f\6\f}\n\f\r\f\16\f~\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\r\u0087\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0099\n\21\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00b3\n\24\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u00c9\n\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\5\32\u00d4\n\32\3\33\3\33\3\33\7\33\u00d9\n\33\f\33\16\33\u00dc"+
		"\13\33\3\34\3\34\3\34\7\34\u00e1\n\34\f\34\16\34\u00e4\13\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00f1\n\35\3\36\3\36"+
		"\3\37\3\37\3\37\2\2 \2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<\2\b\3\2\5\7\4\2))--\4\2\24\24\35\36\4\2\23\23\37 \3\2+,\3"+
		"\2\27\34\2\u00f4\2>\3\2\2\2\4I\3\2\2\2\6M\3\2\2\2\bS\3\2\2\2\n[\3\2\2"+
		"\2\f]\3\2\2\2\16d\3\2\2\2\20h\3\2\2\2\22s\3\2\2\2\24w\3\2\2\2\26|\3\2"+
		"\2\2\30\u0086\3\2\2\2\32\u0088\3\2\2\2\34\u008c\3\2\2\2\36\u008f\3\2\2"+
		"\2 \u0092\3\2\2\2\"\u009a\3\2\2\2$\u009e\3\2\2\2&\u00b2\3\2\2\2(\u00b4"+
		"\3\2\2\2*\u00b8\3\2\2\2,\u00bd\3\2\2\2.\u00c2\3\2\2\2\60\u00ca\3\2\2\2"+
		"\62\u00cf\3\2\2\2\64\u00d5\3\2\2\2\66\u00dd\3\2\2\28\u00f0\3\2\2\2:\u00f2"+
		"\3\2\2\2<\u00f4\3\2\2\2>?\7\3\2\2?@\7*\2\2@B\7!\2\2AC\5\4\3\2BA\3\2\2"+
		"\2BC\3\2\2\2CD\3\2\2\2DE\5\f\7\2EF\7$\2\2FG\7\2\2\3G\3\3\2\2\2HJ\5\6\4"+
		"\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\5\3\2\2\2MN\7\4\2\2NO\5\b"+
		"\5\2OP\7#\2\2PQ\5\n\6\2QR\7!\2\2R\7\3\2\2\2SX\7)\2\2TU\7\"\2\2UW\7)\2"+
		"\2VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\t\3\2\2\2ZX\3\2\2\2[\\\t\2"+
		"\2\2\\\13\3\2\2\2]_\7\b\2\2^`\5\16\b\2_^\3\2\2\2_`\3\2\2\2`a\3\2\2\2a"+
		"b\7\t\2\2b\r\3\2\2\2ce\5&\24\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2"+
		"g\17\3\2\2\2hi\7\'\2\2ij\7\4\2\2jk\7(\2\2kl\5\22\n\2lm\7\'\2\2mn\7\3\2"+
		"\2no\7(\2\2op\5\26\f\2pq\7\2\2\3q\21\3\2\2\2rt\5\24\13\2sr\3\2\2\2tu\3"+
		"\2\2\2us\3\2\2\2uv\3\2\2\2v\23\3\2\2\2wx\7)\2\2xy\7#\2\2yz\5\n\6\2z\25"+
		"\3\2\2\2{}\5\30\r\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\27"+
		"\3\2\2\2\u0080\u0087\5\32\16\2\u0081\u0087\5\34\17\2\u0082\u0087\5\36"+
		"\20\2\u0083\u0087\5 \21\2\u0084\u0087\5\"\22\2\u0085\u0087\5$\23\2\u0086"+
		"\u0080\3\2\2\2\u0086\u0081\3\2\2\2\u0086\u0082\3\2\2\2\u0086\u0083\3\2"+
		"\2\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2\2\2\u0087\31\3\2\2\2\u0088\u0089"+
		"\7)\2\2\u0089\u008a\7\26\2\2\u008a\u008b\5\62\32\2\u008b\33\3\2\2\2\u008c"+
		"\u008d\7\17\2\2\u008d\u008e\7)\2\2\u008e\35\3\2\2\2\u008f\u0090\7\20\2"+
		"\2\u0090\u0091\t\3\2\2\u0091\37\3\2\2\2\u0092\u0093\7\n\2\2\u0093\u0094"+
		"\5\62\32\2\u0094\u0095\7\13\2\2\u0095\u0098\5\30\r\2\u0096\u0097\7\f\2"+
		"\2\u0097\u0099\5\30\r\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"!\3\2\2\2\u009a\u009b\7\r\2\2\u009b\u009c\5\62\32\2\u009c\u009d\5\30\r"+
		"\2\u009d#\3\2\2\2\u009e\u009f\7\b\2\2\u009f\u00a0\5\26\f\2\u00a0\u00a1"+
		"\7\t\2\2\u00a1%\3\2\2\2\u00a2\u00a3\5(\25\2\u00a3\u00a4\7!\2\2\u00a4\u00b3"+
		"\3\2\2\2\u00a5\u00a6\5*\26\2\u00a6\u00a7\7!\2\2\u00a7\u00b3\3\2\2\2\u00a8"+
		"\u00a9\5,\27\2\u00a9\u00aa\7!\2\2\u00aa\u00b3\3\2\2\2\u00ab\u00ac\5.\30"+
		"\2\u00ac\u00ad\7!\2\2\u00ad\u00b3\3\2\2\2\u00ae\u00af\5\60\31\2\u00af"+
		"\u00b0\7!\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00b3\5\f\7\2\u00b2\u00a2\3\2"+
		"\2\2\u00b2\u00a5\3\2\2\2\u00b2\u00a8\3\2\2\2\u00b2\u00ab\3\2\2\2\u00b2"+
		"\u00ae\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\'\3\2\2\2\u00b4\u00b5\7)\2\2"+
		"\u00b5\u00b6\7\26\2\2\u00b6\u00b7\5\62\32\2\u00b7)\3\2\2\2\u00b8\u00b9"+
		"\7\17\2\2\u00b9\u00ba\7%\2\2\u00ba\u00bb\7)\2\2\u00bb\u00bc\7&\2\2\u00bc"+
		"+\3\2\2\2\u00bd\u00be\7\20\2\2\u00be\u00bf\7%\2\2\u00bf\u00c0\5\62\32"+
		"\2\u00c0\u00c1\7&\2\2\u00c1-\3\2\2\2\u00c2\u00c3\7\n\2\2\u00c3\u00c4\5"+
		"\62\32\2\u00c4\u00c5\7\13\2\2\u00c5\u00c8\5&\24\2\u00c6\u00c7\7\f\2\2"+
		"\u00c7\u00c9\5&\24\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9/\3"+
		"\2\2\2\u00ca\u00cb\7\r\2\2\u00cb\u00cc\5\62\32\2\u00cc\u00cd\7\16\2\2"+
		"\u00cd\u00ce\5&\24\2\u00ce\61\3\2\2\2\u00cf\u00d3\5\64\33\2\u00d0\u00d1"+
		"\5<\37\2\u00d1\u00d2\5\64\33\2\u00d2\u00d4\3\2\2\2\u00d3\u00d0\3\2\2\2"+
		"\u00d3\u00d4\3\2\2\2\u00d4\63\3\2\2\2\u00d5\u00da\5\66\34\2\u00d6\u00d7"+
		"\t\4\2\2\u00d7\u00d9\5\66\34\2\u00d8\u00d6\3\2\2\2\u00d9\u00dc\3\2\2\2"+
		"\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\65\3\2\2\2\u00dc\u00da"+
		"\3\2\2\2\u00dd\u00e2\58\35\2\u00de\u00df\t\5\2\2\u00df\u00e1\58\35\2\u00e0"+
		"\u00de\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2"+
		"\2\2\u00e3\67\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00f1\7)\2\2\u00e6\u00f1"+
		"\5:\36\2\u00e7\u00f1\7-\2\2\u00e8\u00f1\7\21\2\2\u00e9\u00f1\7\22\2\2"+
		"\u00ea\u00eb\7%\2\2\u00eb\u00ec\5\62\32\2\u00ec\u00ed\7&\2\2\u00ed\u00f1"+
		"\3\2\2\2\u00ee\u00ef\7\25\2\2\u00ef\u00f1\58\35\2\u00f0\u00e5\3\2\2\2"+
		"\u00f0\u00e6\3\2\2\2\u00f0\u00e7\3\2\2\2\u00f0\u00e8\3\2\2\2\u00f0\u00e9"+
		"\3\2\2\2\u00f0\u00ea\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f19\3\2\2\2\u00f2"+
		"\u00f3\t\6\2\2\u00f3;\3\2\2\2\u00f4\u00f5\t\7\2\2\u00f5=\3\2\2\2\21BK"+
		"X_fu~\u0086\u0098\u00b2\u00c8\u00d3\u00da\u00e2\u00f0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}