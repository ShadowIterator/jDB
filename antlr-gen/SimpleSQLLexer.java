// Generated from /Users/hongfangzhou/Learn/_2019Spring/db/jDB/frontend/SimpleSQL.g4 by ANTLR 4.7.2

import java.util.ArrayList;
import javafx.util.Pair;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleSQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, CREATE=6, TABLE=7, INT=8, LONG=9, 
		FLOAT=10, DOUBLE=11, STRING=12, NOT=13, NULL=14, PRIMARY=15, KEY=16, DROP=17, 
		SHOW=18, INSERT=19, INTO=20, VALUES=21, DELETE=22, FROM=23, WHERE=24, 
		UPDATE=25, SET=26, SELECT=27, JOIN=28, ON=29, AND=30, OR=31, TEXT=32, 
		NUMFLOAT=33, NUMFLOATNEG=34, NUMINT=35, NUMINTNEG=36, OP=37, OPE=38, ID=39, 
		WS=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "A", "B", "C", "D", "E", "F", 
			"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
			"U", "V", "W", "X", "Y", "Z", "DIGIT", "SINQ", "DOUQ", "CREATE", "TABLE", 
			"INT", "LONG", "FLOAT", "DOUBLE", "STRING", "NOT", "NULL", "PRIMARY", 
			"KEY", "DROP", "SHOW", "INSERT", "INTO", "VALUES", "DELETE", "FROM", 
			"WHERE", "UPDATE", "SET", "SELECT", "JOIN", "ON", "AND", "OR", "TEXT", 
			"NUMFLOAT", "NUMFLOATNEG", "NUMINT", "NUMINTNEG", "OP", "OPE", "ID", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", "','", "'.'", null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "CREATE", "TABLE", "INT", "LONG", 
			"FLOAT", "DOUBLE", "STRING", "NOT", "NULL", "PRIMARY", "KEY", "DROP", 
			"SHOW", "INSERT", "INTO", "VALUES", "DELETE", "FROM", "WHERE", "UPDATE", 
			"SET", "SELECT", "JOIN", "ON", "AND", "OR", "TEXT", "NUMFLOAT", "NUMFLOATNEG", 
			"NUMINT", "NUMINTNEG", "OP", "OPE", "ID", "WS"
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


	public SimpleSQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleSQL.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u01b8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3\"\3\"\7\"\u00d2\n\"\f\"\16\"\u00d5\13\"\3\"\3\"\3#\3#\3#\3#\7#"+
		"\u00dd\n#\f#\16#\u00e0\13#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3"+
		"%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)"+
		"\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-"+
		"\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3"+
		"\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3"+
		"8\38\38\38\39\39\39\39\39\39\39\3:\3:\3:\3:\3:\3;\3;\3;\3<\3<\3<\3<\3"+
		"=\3=\3=\3>\3>\5>\u0175\n>\3?\6?\u0178\n?\r?\16?\u0179\3?\3?\6?\u017e\n"+
		"?\r?\16?\u017f\5?\u0182\n?\3@\3@\6@\u0186\n@\r@\16@\u0187\3@\3@\6@\u018c"+
		"\n@\r@\16@\u018d\5@\u0190\n@\3A\6A\u0193\nA\rA\16A\u0194\3B\3B\6B\u0199"+
		"\nB\rB\16B\u019a\3C\3C\3C\3C\3C\3C\3C\3C\5C\u01a5\nC\3D\3D\3E\5E\u01aa"+
		"\nE\3E\7E\u01ad\nE\fE\16E\u01b0\13E\3F\6F\u01b3\nF\rF\16F\u01b4\3F\3F"+
		"\4\u00d3\u00de\2G\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21\2\23\2\25\2\27\2\31"+
		"\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2="+
		"\2?\2A\2C\2E\2G\bI\tK\nM\13O\fQ\rS\16U\17W\20Y\21[\22]\23_\24a\25c\26"+
		"e\27g\30i\31k\32m\33o\34q\35s\36u\37w y!{\"}#\177$\u0081%\u0083&\u0085"+
		"\'\u0087(\u0089)\u008b*\3\2!\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4"+
		"\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPp"+
		"p\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2"+
		"YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\3\2\62;\3\2\60\60\5\2C\\aac|\6\2\62;C\\"+
		"aac|\5\2\13\f\17\17\"\"\2\u01ad\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3"+
		"\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2"+
		"\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2"+
		"u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2"+
		"\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089"+
		"\3\2\2\2\2\u008b\3\2\2\2\3\u008d\3\2\2\2\5\u008f\3\2\2\2\7\u0091\3\2\2"+
		"\2\t\u0093\3\2\2\2\13\u0095\3\2\2\2\r\u0097\3\2\2\2\17\u0099\3\2\2\2\21"+
		"\u009b\3\2\2\2\23\u009d\3\2\2\2\25\u009f\3\2\2\2\27\u00a1\3\2\2\2\31\u00a3"+
		"\3\2\2\2\33\u00a5\3\2\2\2\35\u00a7\3\2\2\2\37\u00a9\3\2\2\2!\u00ab\3\2"+
		"\2\2#\u00ad\3\2\2\2%\u00af\3\2\2\2\'\u00b1\3\2\2\2)\u00b3\3\2\2\2+\u00b5"+
		"\3\2\2\2-\u00b7\3\2\2\2/\u00b9\3\2\2\2\61\u00bb\3\2\2\2\63\u00bd\3\2\2"+
		"\2\65\u00bf\3\2\2\2\67\u00c1\3\2\2\29\u00c3\3\2\2\2;\u00c5\3\2\2\2=\u00c7"+
		"\3\2\2\2?\u00c9\3\2\2\2A\u00cb\3\2\2\2C\u00cd\3\2\2\2E\u00d8\3\2\2\2G"+
		"\u00e3\3\2\2\2I\u00ea\3\2\2\2K\u00f0\3\2\2\2M\u00f4\3\2\2\2O\u00f9\3\2"+
		"\2\2Q\u00ff\3\2\2\2S\u0106\3\2\2\2U\u010d\3\2\2\2W\u0111\3\2\2\2Y\u0116"+
		"\3\2\2\2[\u011e\3\2\2\2]\u0122\3\2\2\2_\u0127\3\2\2\2a\u012c\3\2\2\2c"+
		"\u0133\3\2\2\2e\u0138\3\2\2\2g\u013f\3\2\2\2i\u0146\3\2\2\2k\u014b\3\2"+
		"\2\2m\u0151\3\2\2\2o\u0158\3\2\2\2q\u015c\3\2\2\2s\u0163\3\2\2\2u\u0168"+
		"\3\2\2\2w\u016b\3\2\2\2y\u016f\3\2\2\2{\u0174\3\2\2\2}\u0177\3\2\2\2\177"+
		"\u0183\3\2\2\2\u0081\u0192\3\2\2\2\u0083\u0196\3\2\2\2\u0085\u01a4\3\2"+
		"\2\2\u0087\u01a6\3\2\2\2\u0089\u01a9\3\2\2\2\u008b\u01b2\3\2\2\2\u008d"+
		"\u008e\7=\2\2\u008e\4\3\2\2\2\u008f\u0090\7*\2\2\u0090\6\3\2\2\2\u0091"+
		"\u0092\7+\2\2\u0092\b\3\2\2\2\u0093\u0094\7.\2\2\u0094\n\3\2\2\2\u0095"+
		"\u0096\7\60\2\2\u0096\f\3\2\2\2\u0097\u0098\t\2\2\2\u0098\16\3\2\2\2\u0099"+
		"\u009a\t\3\2\2\u009a\20\3\2\2\2\u009b\u009c\t\4\2\2\u009c\22\3\2\2\2\u009d"+
		"\u009e\t\5\2\2\u009e\24\3\2\2\2\u009f\u00a0\t\6\2\2\u00a0\26\3\2\2\2\u00a1"+
		"\u00a2\t\7\2\2\u00a2\30\3\2\2\2\u00a3\u00a4\t\b\2\2\u00a4\32\3\2\2\2\u00a5"+
		"\u00a6\t\t\2\2\u00a6\34\3\2\2\2\u00a7\u00a8\t\n\2\2\u00a8\36\3\2\2\2\u00a9"+
		"\u00aa\t\13\2\2\u00aa \3\2\2\2\u00ab\u00ac\t\f\2\2\u00ac\"\3\2\2\2\u00ad"+
		"\u00ae\t\r\2\2\u00ae$\3\2\2\2\u00af\u00b0\t\16\2\2\u00b0&\3\2\2\2\u00b1"+
		"\u00b2\t\17\2\2\u00b2(\3\2\2\2\u00b3\u00b4\t\20\2\2\u00b4*\3\2\2\2\u00b5"+
		"\u00b6\t\21\2\2\u00b6,\3\2\2\2\u00b7\u00b8\t\22\2\2\u00b8.\3\2\2\2\u00b9"+
		"\u00ba\t\23\2\2\u00ba\60\3\2\2\2\u00bb\u00bc\t\24\2\2\u00bc\62\3\2\2\2"+
		"\u00bd\u00be\t\25\2\2\u00be\64\3\2\2\2\u00bf\u00c0\t\26\2\2\u00c0\66\3"+
		"\2\2\2\u00c1\u00c2\t\27\2\2\u00c28\3\2\2\2\u00c3\u00c4\t\30\2\2\u00c4"+
		":\3\2\2\2\u00c5\u00c6\t\31\2\2\u00c6<\3\2\2\2\u00c7\u00c8\t\32\2\2\u00c8"+
		">\3\2\2\2\u00c9\u00ca\t\33\2\2\u00ca@\3\2\2\2\u00cb\u00cc\t\34\2\2\u00cc"+
		"B\3\2\2\2\u00cd\u00d3\7)\2\2\u00ce\u00cf\7^\2\2\u00cf\u00d2\7)\2\2\u00d0"+
		"\u00d2\13\2\2\2\u00d1\u00ce\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3"+
		"\2\2\2\u00d3\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d6\u00d7\7)\2\2\u00d7D\3\2\2\2\u00d8\u00de\7$\2\2\u00d9"+
		"\u00da\7^\2\2\u00da\u00dd\7$\2\2\u00db\u00dd\13\2\2\2\u00dc\u00d9\3\2"+
		"\2\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00df\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7$"+
		"\2\2\u00e2F\3\2\2\2\u00e3\u00e4\5\21\t\2\u00e4\u00e5\5/\30\2\u00e5\u00e6"+
		"\5\25\13\2\u00e6\u00e7\5\r\7\2\u00e7\u00e8\5\63\32\2\u00e8\u00e9\5\25"+
		"\13\2\u00e9H\3\2\2\2\u00ea\u00eb\5\63\32\2\u00eb\u00ec\5\r\7\2\u00ec\u00ed"+
		"\5\17\b\2\u00ed\u00ee\5#\22\2\u00ee\u00ef\5\25\13\2\u00efJ\3\2\2\2\u00f0"+
		"\u00f1\5\35\17\2\u00f1\u00f2\5\'\24\2\u00f2\u00f3\5\63\32\2\u00f3L\3\2"+
		"\2\2\u00f4\u00f5\5#\22\2\u00f5\u00f6\5)\25\2\u00f6\u00f7\5\'\24\2\u00f7"+
		"\u00f8\5\31\r\2\u00f8N\3\2\2\2\u00f9\u00fa\5\27\f\2\u00fa\u00fb\5#\22"+
		"\2\u00fb\u00fc\5)\25\2\u00fc\u00fd\5\r\7\2\u00fd\u00fe\5\63\32\2\u00fe"+
		"P\3\2\2\2\u00ff\u0100\5\23\n\2\u0100\u0101\5)\25\2\u0101\u0102\5\65\33"+
		"\2\u0102\u0103\5\17\b\2\u0103\u0104\5#\22\2\u0104\u0105\5\25\13\2\u0105"+
		"R\3\2\2\2\u0106\u0107\5\61\31\2\u0107\u0108\5\63\32\2\u0108\u0109\5/\30"+
		"\2\u0109\u010a\5\35\17\2\u010a\u010b\5\'\24\2\u010b\u010c\5\31\r\2\u010c"+
		"T\3\2\2\2\u010d\u010e\5\'\24\2\u010e\u010f\5)\25\2\u010f\u0110\5\63\32"+
		"\2\u0110V\3\2\2\2\u0111\u0112\5\'\24\2\u0112\u0113\5\65\33\2\u0113\u0114"+
		"\5#\22\2\u0114\u0115\5#\22\2\u0115X\3\2\2\2\u0116\u0117\5+\26\2\u0117"+
		"\u0118\5/\30\2\u0118\u0119\5\35\17\2\u0119\u011a\5%\23\2\u011a\u011b\5"+
		"\r\7\2\u011b\u011c\5/\30\2\u011c\u011d\5=\37\2\u011dZ\3\2\2\2\u011e\u011f"+
		"\5!\21\2\u011f\u0120\5\25\13\2\u0120\u0121\5=\37\2\u0121\\\3\2\2\2\u0122"+
		"\u0123\5\23\n\2\u0123\u0124\5/\30\2\u0124\u0125\5)\25\2\u0125\u0126\5"+
		"+\26\2\u0126^\3\2\2\2\u0127\u0128\5\61\31\2\u0128\u0129\5\33\16\2\u0129"+
		"\u012a\5)\25\2\u012a\u012b\59\35\2\u012b`\3\2\2\2\u012c\u012d\5\35\17"+
		"\2\u012d\u012e\5\'\24\2\u012e\u012f\5\61\31\2\u012f\u0130\5\25\13\2\u0130"+
		"\u0131\5/\30\2\u0131\u0132\5\63\32\2\u0132b\3\2\2\2\u0133\u0134\5\35\17"+
		"\2\u0134\u0135\5\'\24\2\u0135\u0136\5\63\32\2\u0136\u0137\5)\25\2\u0137"+
		"d\3\2\2\2\u0138\u0139\5\67\34\2\u0139\u013a\5\r\7\2\u013a\u013b\5#\22"+
		"\2\u013b\u013c\5\65\33\2\u013c\u013d\5\25\13\2\u013d\u013e\5\61\31\2\u013e"+
		"f\3\2\2\2\u013f\u0140\5\23\n\2\u0140\u0141\5\25\13\2\u0141\u0142\5#\22"+
		"\2\u0142\u0143\5\25\13\2\u0143\u0144\5\63\32\2\u0144\u0145\5\25\13\2\u0145"+
		"h\3\2\2\2\u0146\u0147\5\27\f\2\u0147\u0148\5/\30\2\u0148\u0149\5)\25\2"+
		"\u0149\u014a\5%\23\2\u014aj\3\2\2\2\u014b\u014c\59\35\2\u014c\u014d\5"+
		"\33\16\2\u014d\u014e\5\25\13\2\u014e\u014f\5/\30\2\u014f\u0150\5\25\13"+
		"\2\u0150l\3\2\2\2\u0151\u0152\5\65\33\2\u0152\u0153\5+\26\2\u0153\u0154"+
		"\5\23\n\2\u0154\u0155\5\r\7\2\u0155\u0156\5\63\32\2\u0156\u0157\5\25\13"+
		"\2\u0157n\3\2\2\2\u0158\u0159\5\61\31\2\u0159\u015a\5\25\13\2\u015a\u015b"+
		"\5\63\32\2\u015bp\3\2\2\2\u015c\u015d\5\61\31\2\u015d\u015e\5\25\13\2"+
		"\u015e\u015f\5#\22\2\u015f\u0160\5\25\13\2\u0160\u0161\5\21\t\2\u0161"+
		"\u0162\5\63\32\2\u0162r\3\2\2\2\u0163\u0164\5\37\20\2\u0164\u0165\5)\25"+
		"\2\u0165\u0166\5\35\17\2\u0166\u0167\5\'\24\2\u0167t\3\2\2\2\u0168\u0169"+
		"\5)\25\2\u0169\u016a\5\'\24\2\u016av\3\2\2\2\u016b\u016c\5\r\7\2\u016c"+
		"\u016d\5\'\24\2\u016d\u016e\5\23\n\2\u016ex\3\2\2\2\u016f\u0170\5)\25"+
		"\2\u0170\u0171\5/\30\2\u0171z\3\2\2\2\u0172\u0175\5C\"\2\u0173\u0175\5"+
		"E#\2\u0174\u0172\3\2\2\2\u0174\u0173\3\2\2\2\u0175|\3\2\2\2\u0176\u0178"+
		"\5A!\2\u0177\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u0177\3\2\2\2\u0179"+
		"\u017a\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u0181\t\35\2\2\u017c\u017e\5"+
		"A!\2\u017d\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u017d\3\2\2\2\u017f"+
		"\u0180\3\2\2\2\u0180\u0182\3\2\2\2\u0181\u017d\3\2\2\2\u0181\u0182\3\2"+
		"\2\2\u0182~\3\2\2\2\u0183\u0185\7/\2\2\u0184\u0186\5A!\2\u0185\u0184\3"+
		"\2\2\2\u0186\u0187\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188"+
		"\u0189\3\2\2\2\u0189\u018f\t\35\2\2\u018a\u018c\5A!\2\u018b\u018a\3\2"+
		"\2\2\u018c\u018d\3\2\2\2\u018d\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e"+
		"\u0190\3\2\2\2\u018f\u018b\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0080\3\2"+
		"\2\2\u0191\u0193\5A!\2\u0192\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0192"+
		"\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0082\3\2\2\2\u0196\u0198\7/\2\2\u0197"+
		"\u0199\5A!\2\u0198\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u0198\3\2\2"+
		"\2\u019a\u019b\3\2\2\2\u019b\u0084\3\2\2\2\u019c\u01a5\7@\2\2\u019d\u019e"+
		"\7@\2\2\u019e\u01a5\7?\2\2\u019f\u01a5\7>\2\2\u01a0\u01a1\7>\2\2\u01a1"+
		"\u01a5\7?\2\2\u01a2\u01a3\7>\2\2\u01a3\u01a5\7@\2\2\u01a4\u019c\3\2\2"+
		"\2\u01a4\u019d\3\2\2\2\u01a4\u019f\3\2\2\2\u01a4\u01a0\3\2\2\2\u01a4\u01a2"+
		"\3\2\2\2\u01a5\u0086\3\2\2\2\u01a6\u01a7\7?\2\2\u01a7\u0088\3\2\2\2\u01a8"+
		"\u01aa\t\36\2\2\u01a9\u01a8\3\2\2\2\u01aa\u01ae\3\2\2\2\u01ab\u01ad\t"+
		"\37\2\2\u01ac\u01ab\3\2\2\2\u01ad\u01b0\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae"+
		"\u01af\3\2\2\2\u01af\u008a\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b1\u01b3\t "+
		"\2\2\u01b2\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4"+
		"\u01b5\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\bF\2\2\u01b7\u008c\3\2"+
		"\2\2\25\2\u00d1\u00d3\u00dc\u00de\u0174\u0179\u017f\u0181\u0187\u018d"+
		"\u018f\u0194\u019a\u01a4\u01a9\u01ac\u01ae\u01b4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}