// Generated from gyhlng.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gyhlngLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PROGRAMA", "DECLARAR", "INTEGER", "REAL", "BOOLEAN", "INICIO", "FIM", 
			"SE", "ENTAO", "SENAO", "ENQTO", "FACA", "LER", "IMPRIMIR", "VERDADEIRO", 
			"FALSO", "E", "OU", "NAO", "ATRIB", "IGUAL", "DIFERENTE", "MENOR", "MENOR_IGUAL", 
			"MAIOR", "MAIOR_IGUAL", "MAIS", "MENOS", "MULT", "DIV", "PONTO_VIRGULA", 
			"VIRGULA", "DOIS_PONTOS", "PONTO", "ABRE_PAR", "FECHA_PAR", "DELIM_ABRE", 
			"DELIM_FECHA", "VAR", "ID", "NumInt", "NumReal", "CADEIA", "COMENTARIO", 
			"COMENTARIO_LINHA", "WS"
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


	public gyhlngLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "gyhlng.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\60\u014c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0096\n\b\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\5\26\u00df\n\26\3\27\3\27\3\27\3\27\5\27"+
		"\u00e5\n\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3"+
		"&\3&\3\'\3\'\3(\3(\7(\u010b\n(\f(\16(\u010e\13(\3)\3)\7)\u0112\n)\f)\16"+
		")\u0115\13)\3*\6*\u0118\n*\r*\16*\u0119\3+\6+\u011d\n+\r+\16+\u011e\3"+
		"+\3+\6+\u0123\n+\r+\16+\u0124\3,\3,\7,\u0129\n,\f,\16,\u012c\13,\3,\3"+
		",\3-\3-\7-\u0132\n-\f-\16-\u0135\13-\3-\3-\3-\3-\3.\3.\3.\3.\7.\u013f"+
		"\n.\f.\16.\u0142\13.\3.\3.\3/\6/\u0147\n/\r/\16/\u0148\3/\3/\3\u0133\2"+
		"\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60\3\2\n\3\2c|\4\2\62;c|\4\2C"+
		"\\c|\6\2\62;C\\aac|\3\2\62;\6\2\f\f\17\17$$))\4\2\f\f\17\17\5\2\13\f\17"+
		"\17\"\"\2\u0157\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3"+
		"_\3\2\2\2\5h\3\2\2\2\7q\3\2\2\2\ty\3\2\2\2\13~\3\2\2\2\r\u0086\3\2\2\2"+
		"\17\u0095\3\2\2\2\21\u0097\3\2\2\2\23\u009a\3\2\2\2\25\u00a0\3\2\2\2\27"+
		"\u00a6\3\2\2\2\31\u00ac\3\2\2\2\33\u00b1\3\2\2\2\35\u00b5\3\2\2\2\37\u00be"+
		"\3\2\2\2!\u00c9\3\2\2\2#\u00cf\3\2\2\2%\u00d1\3\2\2\2\'\u00d4\3\2\2\2"+
		")\u00d8\3\2\2\2+\u00de\3\2\2\2-\u00e4\3\2\2\2/\u00e6\3\2\2\2\61\u00e8"+
		"\3\2\2\2\63\u00eb\3\2\2\2\65\u00ed\3\2\2\2\67\u00f0\3\2\2\29\u00f2\3\2"+
		"\2\2;\u00f4\3\2\2\2=\u00f6\3\2\2\2?\u00f8\3\2\2\2A\u00fa\3\2\2\2C\u00fc"+
		"\3\2\2\2E\u00fe\3\2\2\2G\u0100\3\2\2\2I\u0102\3\2\2\2K\u0104\3\2\2\2M"+
		"\u0106\3\2\2\2O\u0108\3\2\2\2Q\u010f\3\2\2\2S\u0117\3\2\2\2U\u011c\3\2"+
		"\2\2W\u0126\3\2\2\2Y\u012f\3\2\2\2[\u013a\3\2\2\2]\u0146\3\2\2\2_`\7R"+
		"\2\2`a\7T\2\2ab\7Q\2\2bc\7I\2\2cd\7T\2\2de\7C\2\2ef\7O\2\2fg\7C\2\2g\4"+
		"\3\2\2\2hi\7F\2\2ij\7G\2\2jk\7E\2\2kl\7N\2\2lm\7C\2\2mn\7T\2\2no\7C\2"+
		"\2op\7T\2\2p\6\3\2\2\2qr\7K\2\2rs\7P\2\2st\7V\2\2tu\7G\2\2uv\7I\2\2vw"+
		"\7G\2\2wx\7T\2\2x\b\3\2\2\2yz\7T\2\2z{\7G\2\2{|\7C\2\2|}\7N\2\2}\n\3\2"+
		"\2\2~\177\7D\2\2\177\u0080\7Q\2\2\u0080\u0081\7Q\2\2\u0081\u0082\7N\2"+
		"\2\u0082\u0083\7G\2\2\u0083\u0084\7C\2\2\u0084\u0085\7P\2\2\u0085\f\3"+
		"\2\2\2\u0086\u0087\7K\2\2\u0087\u0088\7P\2\2\u0088\u0089\7K\2\2\u0089"+
		"\u008a\7E\2\2\u008a\u008b\7K\2\2\u008b\u008c\7Q\2\2\u008c\16\3\2\2\2\u008d"+
		"\u008e\7H\2\2\u008e\u008f\7K\2\2\u008f\u0096\7O\2\2\u0090\u0091\7H\2\2"+
		"\u0091\u0092\7K\2\2\u0092\u0093\7P\2\2\u0093\u0094\7C\2\2\u0094\u0096"+
		"\7N\2\2\u0095\u008d\3\2\2\2\u0095\u0090\3\2\2\2\u0096\20\3\2\2\2\u0097"+
		"\u0098\7U\2\2\u0098\u0099\7G\2\2\u0099\22\3\2\2\2\u009a\u009b\7G\2\2\u009b"+
		"\u009c\7P\2\2\u009c\u009d\7V\2\2\u009d\u009e\7C\2\2\u009e\u009f\7Q\2\2"+
		"\u009f\24\3\2\2\2\u00a0\u00a1\7U\2\2\u00a1\u00a2\7G\2\2\u00a2\u00a3\7"+
		"P\2\2\u00a3\u00a4\7C\2\2\u00a4\u00a5\7Q\2\2\u00a5\26\3\2\2\2\u00a6\u00a7"+
		"\7G\2\2\u00a7\u00a8\7P\2\2\u00a8\u00a9\7S\2\2\u00a9\u00aa\7V\2\2\u00aa"+
		"\u00ab\7Q\2\2\u00ab\30\3\2\2\2\u00ac\u00ad\7H\2\2\u00ad\u00ae\7C\2\2\u00ae"+
		"\u00af\7E\2\2\u00af\u00b0\7C\2\2\u00b0\32\3\2\2\2\u00b1\u00b2\7N\2\2\u00b2"+
		"\u00b3\7G\2\2\u00b3\u00b4\7T\2\2\u00b4\34\3\2\2\2\u00b5\u00b6\7K\2\2\u00b6"+
		"\u00b7\7O\2\2\u00b7\u00b8\7R\2\2\u00b8\u00b9\7T\2\2\u00b9\u00ba\7K\2\2"+
		"\u00ba\u00bb\7O\2\2\u00bb\u00bc\7K\2\2\u00bc\u00bd\7T\2\2\u00bd\36\3\2"+
		"\2\2\u00be\u00bf\7X\2\2\u00bf\u00c0\7G\2\2\u00c0\u00c1\7T\2\2\u00c1\u00c2"+
		"\7F\2\2\u00c2\u00c3\7C\2\2\u00c3\u00c4\7F\2\2\u00c4\u00c5\7G\2\2\u00c5"+
		"\u00c6\7K\2\2\u00c6\u00c7\7T\2\2\u00c7\u00c8\7Q\2\2\u00c8 \3\2\2\2\u00c9"+
		"\u00ca\7H\2\2\u00ca\u00cb\7C\2\2\u00cb\u00cc\7N\2\2\u00cc\u00cd\7U\2\2"+
		"\u00cd\u00ce\7Q\2\2\u00ce\"\3\2\2\2\u00cf\u00d0\7G\2\2\u00d0$\3\2\2\2"+
		"\u00d1\u00d2\7Q\2\2\u00d2\u00d3\7W\2\2\u00d3&\3\2\2\2\u00d4\u00d5\7P\2"+
		"\2\u00d5\u00d6\7C\2\2\u00d6\u00d7\7Q\2\2\u00d7(\3\2\2\2\u00d8\u00d9\7"+
		"<\2\2\u00d9\u00da\7?\2\2\u00da*\3\2\2\2\u00db\u00dc\7?\2\2\u00dc\u00df"+
		"\7?\2\2\u00dd\u00df\7?\2\2\u00de\u00db\3\2\2\2\u00de\u00dd\3\2\2\2\u00df"+
		",\3\2\2\2\u00e0\u00e1\7#\2\2\u00e1\u00e5\7?\2\2\u00e2\u00e3\7>\2\2\u00e3"+
		"\u00e5\7@\2\2\u00e4\u00e0\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5.\3\2\2\2\u00e6"+
		"\u00e7\7>\2\2\u00e7\60\3\2\2\2\u00e8\u00e9\7>\2\2\u00e9\u00ea\7?\2\2\u00ea"+
		"\62\3\2\2\2\u00eb\u00ec\7@\2\2\u00ec\64\3\2\2\2\u00ed\u00ee\7@\2\2\u00ee"+
		"\u00ef\7?\2\2\u00ef\66\3\2\2\2\u00f0\u00f1\7-\2\2\u00f18\3\2\2\2\u00f2"+
		"\u00f3\7/\2\2\u00f3:\3\2\2\2\u00f4\u00f5\7,\2\2\u00f5<\3\2\2\2\u00f6\u00f7"+
		"\7\61\2\2\u00f7>\3\2\2\2\u00f8\u00f9\7=\2\2\u00f9@\3\2\2\2\u00fa\u00fb"+
		"\7.\2\2\u00fbB\3\2\2\2\u00fc\u00fd\7<\2\2\u00fdD\3\2\2\2\u00fe\u00ff\7"+
		"\60\2\2\u00ffF\3\2\2\2\u0100\u0101\7*\2\2\u0101H\3\2\2\2\u0102\u0103\7"+
		"+\2\2\u0103J\3\2\2\2\u0104\u0105\7]\2\2\u0105L\3\2\2\2\u0106\u0107\7_"+
		"\2\2\u0107N\3\2\2\2\u0108\u010c\t\2\2\2\u0109\u010b\t\3\2\2\u010a\u0109"+
		"\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"P\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0113\t\4\2\2\u0110\u0112\t\5\2\2"+
		"\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114"+
		"\3\2\2\2\u0114R\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0118\t\6\2\2\u0117"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011aT\3\2\2\2\u011b\u011d\t\6\2\2\u011c\u011b\3\2\2\2\u011d\u011e"+
		"\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120"+
		"\u0122\7\60\2\2\u0121\u0123\t\6\2\2\u0122\u0121\3\2\2\2\u0123\u0124\3"+
		"\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125V\3\2\2\2\u0126\u012a"+
		"\7$\2\2\u0127\u0129\n\7\2\2\u0128\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a"+
		"\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d\3\2\2\2\u012c\u012a\3\2"+
		"\2\2\u012d\u012e\7$\2\2\u012eX\3\2\2\2\u012f\u0133\7}\2\2\u0130\u0132"+
		"\13\2\2\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0134\3\2\2\2"+
		"\u0133\u0131\3\2\2\2\u0134\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0137"+
		"\7\177\2\2\u0137\u0138\3\2\2\2\u0138\u0139\b-\2\2\u0139Z\3\2\2\2\u013a"+
		"\u013b\7\61\2\2\u013b\u013c\7\61\2\2\u013c\u0140\3\2\2\2\u013d\u013f\n"+
		"\b\2\2\u013e\u013d\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140"+
		"\u0141\3\2\2\2\u0141\u0143\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0144\b."+
		"\2\2\u0144\\\3\2\2\2\u0145\u0147\t\t\2\2\u0146\u0145\3\2\2\2\u0147\u0148"+
		"\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u014a"+
		"\u014b\b/\2\2\u014b^\3\2\2\2\17\2\u0095\u00de\u00e4\u010c\u0113\u0119"+
		"\u011e\u0124\u012a\u0133\u0140\u0148\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}