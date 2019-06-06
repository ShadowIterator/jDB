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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, CREATE=7, TABLE=8, INT=9, 
		LONG=10, FLOAT=11, DOUBLE=12, STRING=13, NOT=14, NULL=15, PRIMARY=16, 
		KEY=17, DROP=18, SHOW=19, INSERT=20, INTO=21, VALUES=22, DELETE=23, FROM=24, 
		WHERE=25, UPDATE=26, SET=27, SELECT=28, JOIN=29, ON=30, AND=31, OR=32, 
		DATABASE=33, USE=34, DATABASES=35, OUTER=36, LEFT=37, RIGHT=38, AS=39, 
		TEXT=40, NUMFLOAT=41, NUMFLOATNEG=42, NUMINT=43, NUMINTNEG=44, OP=45, 
		OPE=46, ID=47, WS=48;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "A", "B", "C", "D", "E", 
			"F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", 
			"T", "U", "V", "W", "X", "Y", "Z", "DIGIT", "SINQ", "DOUQ", "CREATE", 
			"TABLE", "INT", "LONG", "FLOAT", "DOUBLE", "STRING", "NOT", "NULL", "PRIMARY", 
			"KEY", "DROP", "SHOW", "INSERT", "INTO", "VALUES", "DELETE", "FROM", 
			"WHERE", "UPDATE", "SET", "SELECT", "JOIN", "ON", "AND", "OR", "DATABASE", 
			"USE", "DATABASES", "OUTER", "LEFT", "RIGHT", "AS", "TEXT", "NUMFLOAT", 
			"NUMFLOATNEG", "NUMINT", "NUMINTNEG", "OP", "OPE", "ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", "','", "'.'", "'*'", null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "CREATE", "TABLE", "INT", "LONG", 
			"FLOAT", "DOUBLE", "STRING", "NOT", "NULL", "PRIMARY", "KEY", "DROP", 
			"SHOW", "INSERT", "INTO", "VALUES", "DELETE", "FROM", "WHERE", "UPDATE", 
			"SET", "SELECT", "JOIN", "ON", "AND", "OR", "DATABASE", "USE", "DATABASES", 
			"OUTER", "LEFT", "RIGHT", "AS", "TEXT", "NUMFLOAT", "NUMFLOATNEG", "NUMINT", 
			"NUMINTNEG", "OP", "OPE", "ID", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u01f5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\7#\u00e4"+
		"\n#\f#\16#\u00e7\13#\3#\3#\3$\3$\3$\3$\7$\u00ef\n$\f$\16$\u00f2\13$\3"+
		"$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3"+
		"(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3"+
		",\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3"+
		"\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3"+
		"\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3"+
		"\67\3\67\3\67\38\38\38\38\38\38\38\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3"+
		";\3;\3;\3;\3;\3<\3<\3<\3=\3=\3=\3=\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?\3"+
		"?\3@\3@\3@\3@\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3C\3C\3"+
		"C\3C\3C\3D\3D\3D\3D\3D\3D\3E\3E\3E\3F\3F\5F\u01b2\nF\3G\6G\u01b5\nG\r"+
		"G\16G\u01b6\3G\3G\6G\u01bb\nG\rG\16G\u01bc\5G\u01bf\nG\3H\3H\6H\u01c3"+
		"\nH\rH\16H\u01c4\3H\3H\6H\u01c9\nH\rH\16H\u01ca\5H\u01cd\nH\3I\6I\u01d0"+
		"\nI\rI\16I\u01d1\3J\3J\6J\u01d6\nJ\rJ\16J\u01d7\3K\3K\3K\3K\3K\3K\3K\3"+
		"K\5K\u01e2\nK\3L\3L\3M\5M\u01e7\nM\3M\7M\u01ea\nM\fM\16M\u01ed\13M\3N"+
		"\6N\u01f0\nN\rN\16N\u01f1\3N\3N\4\u00e5\u00f0\2O\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-"+
		"\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2I\tK\nM\13O\fQ\rS\16"+
		"U\17W\20Y\21[\22]\23_\24a\25c\26e\27g\30i\31k\32m\33o\34q\35s\36u\37w"+
		" y!{\"}#\177$\u0081%\u0083&\u0085\'\u0087(\u0089)\u008b*\u008d+\u008f"+
		",\u0091-\u0093.\u0095/\u0097\60\u0099\61\u009b\62\3\2!\4\2CCcc\4\2DDd"+
		"d\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2"+
		"MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4"+
		"\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\3\2\62;\3\2\60"+
		"\60\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u01ea\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2"+
		"\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2"+
		"\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}"+
		"\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2"+
		"\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f"+
		"\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2"+
		"\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\3\u009d\3\2\2\2\5\u009f\3\2\2\2\7\u00a1"+
		"\3\2\2\2\t\u00a3\3\2\2\2\13\u00a5\3\2\2\2\r\u00a7\3\2\2\2\17\u00a9\3\2"+
		"\2\2\21\u00ab\3\2\2\2\23\u00ad\3\2\2\2\25\u00af\3\2\2\2\27\u00b1\3\2\2"+
		"\2\31\u00b3\3\2\2\2\33\u00b5\3\2\2\2\35\u00b7\3\2\2\2\37\u00b9\3\2\2\2"+
		"!\u00bb\3\2\2\2#\u00bd\3\2\2\2%\u00bf\3\2\2\2\'\u00c1\3\2\2\2)\u00c3\3"+
		"\2\2\2+\u00c5\3\2\2\2-\u00c7\3\2\2\2/\u00c9\3\2\2\2\61\u00cb\3\2\2\2\63"+
		"\u00cd\3\2\2\2\65\u00cf\3\2\2\2\67\u00d1\3\2\2\29\u00d3\3\2\2\2;\u00d5"+
		"\3\2\2\2=\u00d7\3\2\2\2?\u00d9\3\2\2\2A\u00db\3\2\2\2C\u00dd\3\2\2\2E"+
		"\u00df\3\2\2\2G\u00ea\3\2\2\2I\u00f5\3\2\2\2K\u00fc\3\2\2\2M\u0102\3\2"+
		"\2\2O\u0106\3\2\2\2Q\u010b\3\2\2\2S\u0111\3\2\2\2U\u0118\3\2\2\2W\u011f"+
		"\3\2\2\2Y\u0123\3\2\2\2[\u0128\3\2\2\2]\u0130\3\2\2\2_\u0134\3\2\2\2a"+
		"\u0139\3\2\2\2c\u013e\3\2\2\2e\u0145\3\2\2\2g\u014a\3\2\2\2i\u0151\3\2"+
		"\2\2k\u0158\3\2\2\2m\u015d\3\2\2\2o\u0163\3\2\2\2q\u016a\3\2\2\2s\u016e"+
		"\3\2\2\2u\u0175\3\2\2\2w\u017a\3\2\2\2y\u017d\3\2\2\2{\u0181\3\2\2\2}"+
		"\u0184\3\2\2\2\177\u018d\3\2\2\2\u0081\u0191\3\2\2\2\u0083\u019b\3\2\2"+
		"\2\u0085\u01a1\3\2\2\2\u0087\u01a6\3\2\2\2\u0089\u01ac\3\2\2\2\u008b\u01b1"+
		"\3\2\2\2\u008d\u01b4\3\2\2\2\u008f\u01c0\3\2\2\2\u0091\u01cf\3\2\2\2\u0093"+
		"\u01d3\3\2\2\2\u0095\u01e1\3\2\2\2\u0097\u01e3\3\2\2\2\u0099\u01e6\3\2"+
		"\2\2\u009b\u01ef\3\2\2\2\u009d\u009e\7=\2\2\u009e\4\3\2\2\2\u009f\u00a0"+
		"\7*\2\2\u00a0\6\3\2\2\2\u00a1\u00a2\7+\2\2\u00a2\b\3\2\2\2\u00a3\u00a4"+
		"\7.\2\2\u00a4\n\3\2\2\2\u00a5\u00a6\7\60\2\2\u00a6\f\3\2\2\2\u00a7\u00a8"+
		"\7,\2\2\u00a8\16\3\2\2\2\u00a9\u00aa\t\2\2\2\u00aa\20\3\2\2\2\u00ab\u00ac"+
		"\t\3\2\2\u00ac\22\3\2\2\2\u00ad\u00ae\t\4\2\2\u00ae\24\3\2\2\2\u00af\u00b0"+
		"\t\5\2\2\u00b0\26\3\2\2\2\u00b1\u00b2\t\6\2\2\u00b2\30\3\2\2\2\u00b3\u00b4"+
		"\t\7\2\2\u00b4\32\3\2\2\2\u00b5\u00b6\t\b\2\2\u00b6\34\3\2\2\2\u00b7\u00b8"+
		"\t\t\2\2\u00b8\36\3\2\2\2\u00b9\u00ba\t\n\2\2\u00ba \3\2\2\2\u00bb\u00bc"+
		"\t\13\2\2\u00bc\"\3\2\2\2\u00bd\u00be\t\f\2\2\u00be$\3\2\2\2\u00bf\u00c0"+
		"\t\r\2\2\u00c0&\3\2\2\2\u00c1\u00c2\t\16\2\2\u00c2(\3\2\2\2\u00c3\u00c4"+
		"\t\17\2\2\u00c4*\3\2\2\2\u00c5\u00c6\t\20\2\2\u00c6,\3\2\2\2\u00c7\u00c8"+
		"\t\21\2\2\u00c8.\3\2\2\2\u00c9\u00ca\t\22\2\2\u00ca\60\3\2\2\2\u00cb\u00cc"+
		"\t\23\2\2\u00cc\62\3\2\2\2\u00cd\u00ce\t\24\2\2\u00ce\64\3\2\2\2\u00cf"+
		"\u00d0\t\25\2\2\u00d0\66\3\2\2\2\u00d1\u00d2\t\26\2\2\u00d28\3\2\2\2\u00d3"+
		"\u00d4\t\27\2\2\u00d4:\3\2\2\2\u00d5\u00d6\t\30\2\2\u00d6<\3\2\2\2\u00d7"+
		"\u00d8\t\31\2\2\u00d8>\3\2\2\2\u00d9\u00da\t\32\2\2\u00da@\3\2\2\2\u00db"+
		"\u00dc\t\33\2\2\u00dcB\3\2\2\2\u00dd\u00de\t\34\2\2\u00deD\3\2\2\2\u00df"+
		"\u00e5\7)\2\2\u00e0\u00e1\7^\2\2\u00e1\u00e4\7)\2\2\u00e2\u00e4\13\2\2"+
		"\2\u00e3\u00e0\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e6"+
		"\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8"+
		"\u00e9\7)\2\2\u00e9F\3\2\2\2\u00ea\u00f0\7$\2\2\u00eb\u00ec\7^\2\2\u00ec"+
		"\u00ef\7$\2\2\u00ed\u00ef\13\2\2\2\u00ee\u00eb\3\2\2\2\u00ee\u00ed\3\2"+
		"\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1"+
		"\u00f3\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f4\7$\2\2\u00f4H\3\2\2\2\u00f5"+
		"\u00f6\5\23\n\2\u00f6\u00f7\5\61\31\2\u00f7\u00f8\5\27\f\2\u00f8\u00f9"+
		"\5\17\b\2\u00f9\u00fa\5\65\33\2\u00fa\u00fb\5\27\f\2\u00fbJ\3\2\2\2\u00fc"+
		"\u00fd\5\65\33\2\u00fd\u00fe\5\17\b\2\u00fe\u00ff\5\21\t\2\u00ff\u0100"+
		"\5%\23\2\u0100\u0101\5\27\f\2\u0101L\3\2\2\2\u0102\u0103\5\37\20\2\u0103"+
		"\u0104\5)\25\2\u0104\u0105\5\65\33\2\u0105N\3\2\2\2\u0106\u0107\5%\23"+
		"\2\u0107\u0108\5+\26\2\u0108\u0109\5)\25\2\u0109\u010a\5\33\16\2\u010a"+
		"P\3\2\2\2\u010b\u010c\5\31\r\2\u010c\u010d\5%\23\2\u010d\u010e\5+\26\2"+
		"\u010e\u010f\5\17\b\2\u010f\u0110\5\65\33\2\u0110R\3\2\2\2\u0111\u0112"+
		"\5\25\13\2\u0112\u0113\5+\26\2\u0113\u0114\5\67\34\2\u0114\u0115\5\21"+
		"\t\2\u0115\u0116\5%\23\2\u0116\u0117\5\27\f\2\u0117T\3\2\2\2\u0118\u0119"+
		"\5\63\32\2\u0119\u011a\5\65\33\2\u011a\u011b\5\61\31\2\u011b\u011c\5\37"+
		"\20\2\u011c\u011d\5)\25\2\u011d\u011e\5\33\16\2\u011eV\3\2\2\2\u011f\u0120"+
		"\5)\25\2\u0120\u0121\5+\26\2\u0121\u0122\5\65\33\2\u0122X\3\2\2\2\u0123"+
		"\u0124\5)\25\2\u0124\u0125\5\67\34\2\u0125\u0126\5%\23\2\u0126\u0127\5"+
		"%\23\2\u0127Z\3\2\2\2\u0128\u0129\5-\27\2\u0129\u012a\5\61\31\2\u012a"+
		"\u012b\5\37\20\2\u012b\u012c\5\'\24\2\u012c\u012d\5\17\b\2\u012d\u012e"+
		"\5\61\31\2\u012e\u012f\5? \2\u012f\\\3\2\2\2\u0130\u0131\5#\22\2\u0131"+
		"\u0132\5\27\f\2\u0132\u0133\5? \2\u0133^\3\2\2\2\u0134\u0135\5\25\13\2"+
		"\u0135\u0136\5\61\31\2\u0136\u0137\5+\26\2\u0137\u0138\5-\27\2\u0138`"+
		"\3\2\2\2\u0139\u013a\5\63\32\2\u013a\u013b\5\35\17\2\u013b\u013c\5+\26"+
		"\2\u013c\u013d\5;\36\2\u013db\3\2\2\2\u013e\u013f\5\37\20\2\u013f\u0140"+
		"\5)\25\2\u0140\u0141\5\63\32\2\u0141\u0142\5\27\f\2\u0142\u0143\5\61\31"+
		"\2\u0143\u0144\5\65\33\2\u0144d\3\2\2\2\u0145\u0146\5\37\20\2\u0146\u0147"+
		"\5)\25\2\u0147\u0148\5\65\33\2\u0148\u0149\5+\26\2\u0149f\3\2\2\2\u014a"+
		"\u014b\59\35\2\u014b\u014c\5\17\b\2\u014c\u014d\5%\23\2\u014d\u014e\5"+
		"\67\34\2\u014e\u014f\5\27\f\2\u014f\u0150\5\63\32\2\u0150h\3\2\2\2\u0151"+
		"\u0152\5\25\13\2\u0152\u0153\5\27\f\2\u0153\u0154\5%\23\2\u0154\u0155"+
		"\5\27\f\2\u0155\u0156\5\65\33\2\u0156\u0157\5\27\f\2\u0157j\3\2\2\2\u0158"+
		"\u0159\5\31\r\2\u0159\u015a\5\61\31\2\u015a\u015b\5+\26\2\u015b\u015c"+
		"\5\'\24\2\u015cl\3\2\2\2\u015d\u015e\5;\36\2\u015e\u015f\5\35\17\2\u015f"+
		"\u0160\5\27\f\2\u0160\u0161\5\61\31\2\u0161\u0162\5\27\f\2\u0162n\3\2"+
		"\2\2\u0163\u0164\5\67\34\2\u0164\u0165\5-\27\2\u0165\u0166\5\25\13\2\u0166"+
		"\u0167\5\17\b\2\u0167\u0168\5\65\33\2\u0168\u0169\5\27\f\2\u0169p\3\2"+
		"\2\2\u016a\u016b\5\63\32\2\u016b\u016c\5\27\f\2\u016c\u016d\5\65\33\2"+
		"\u016dr\3\2\2\2\u016e\u016f\5\63\32\2\u016f\u0170\5\27\f\2\u0170\u0171"+
		"\5%\23\2\u0171\u0172\5\27\f\2\u0172\u0173\5\23\n\2\u0173\u0174\5\65\33"+
		"\2\u0174t\3\2\2\2\u0175\u0176\5!\21\2\u0176\u0177\5+\26\2\u0177\u0178"+
		"\5\37\20\2\u0178\u0179\5)\25\2\u0179v\3\2\2\2\u017a\u017b\5+\26\2\u017b"+
		"\u017c\5)\25\2\u017cx\3\2\2\2\u017d\u017e\5\17\b\2\u017e\u017f\5)\25\2"+
		"\u017f\u0180\5\25\13\2\u0180z\3\2\2\2\u0181\u0182\5+\26\2\u0182\u0183"+
		"\5\61\31\2\u0183|\3\2\2\2\u0184\u0185\5\25\13\2\u0185\u0186\5\17\b\2\u0186"+
		"\u0187\5\65\33\2\u0187\u0188\5\17\b\2\u0188\u0189\5\21\t\2\u0189\u018a"+
		"\5\17\b\2\u018a\u018b\5\63\32\2\u018b\u018c\5\27\f\2\u018c~\3\2\2\2\u018d"+
		"\u018e\5\67\34\2\u018e\u018f\5\63\32\2\u018f\u0190\5\27\f\2\u0190\u0080"+
		"\3\2\2\2\u0191\u0192\5\25\13\2\u0192\u0193\5\17\b\2\u0193\u0194\5\65\33"+
		"\2\u0194\u0195\5\17\b\2\u0195\u0196\5\21\t\2\u0196\u0197\5\17\b\2\u0197"+
		"\u0198\5\63\32\2\u0198\u0199\5\27\f\2\u0199\u019a\5\63\32\2\u019a\u0082"+
		"\3\2\2\2\u019b\u019c\5+\26\2\u019c\u019d\5\67\34\2\u019d\u019e\5\65\33"+
		"\2\u019e\u019f\5\27\f\2\u019f\u01a0\5\61\31\2\u01a0\u0084\3\2\2\2\u01a1"+
		"\u01a2\5%\23\2\u01a2\u01a3\5\27\f\2\u01a3\u01a4\5\31\r\2\u01a4\u01a5\5"+
		"\65\33\2\u01a5\u0086\3\2\2\2\u01a6\u01a7\5\61\31\2\u01a7\u01a8\5\37\20"+
		"\2\u01a8\u01a9\5\33\16\2\u01a9\u01aa\5\35\17\2\u01aa\u01ab\5\65\33\2\u01ab"+
		"\u0088\3\2\2\2\u01ac\u01ad\5\17\b\2\u01ad\u01ae\5\63\32\2\u01ae\u008a"+
		"\3\2\2\2\u01af\u01b2\5E#\2\u01b0\u01b2\5G$\2\u01b1\u01af\3\2\2\2\u01b1"+
		"\u01b0\3\2\2\2\u01b2\u008c\3\2\2\2\u01b3\u01b5\5C\"\2\u01b4\u01b3\3\2"+
		"\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7"+
		"\u01b8\3\2\2\2\u01b8\u01be\t\35\2\2\u01b9\u01bb\5C\"\2\u01ba\u01b9\3\2"+
		"\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd"+
		"\u01bf\3\2\2\2\u01be\u01ba\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u008e\3\2"+
		"\2\2\u01c0\u01c2\7/\2\2\u01c1\u01c3\5C\"\2\u01c2\u01c1\3\2\2\2\u01c3\u01c4"+
		"\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6"+
		"\u01cc\t\35\2\2\u01c7\u01c9\5C\"\2\u01c8\u01c7\3\2\2\2\u01c9\u01ca\3\2"+
		"\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cd\3\2\2\2\u01cc"+
		"\u01c8\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u0090\3\2\2\2\u01ce\u01d0\5C"+
		"\"\2\u01cf\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1"+
		"\u01d2\3\2\2\2\u01d2\u0092\3\2\2\2\u01d3\u01d5\7/\2\2\u01d4\u01d6\5C\""+
		"\2\u01d5\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8"+
		"\3\2\2\2\u01d8\u0094\3\2\2\2\u01d9\u01e2\7@\2\2\u01da\u01db\7@\2\2\u01db"+
		"\u01e2\7?\2\2\u01dc\u01e2\7>\2\2\u01dd\u01de\7>\2\2\u01de\u01e2\7?\2\2"+
		"\u01df\u01e0\7>\2\2\u01e0\u01e2\7@\2\2\u01e1\u01d9\3\2\2\2\u01e1\u01da"+
		"\3\2\2\2\u01e1\u01dc\3\2\2\2\u01e1\u01dd\3\2\2\2\u01e1\u01df\3\2\2\2\u01e2"+
		"\u0096\3\2\2\2\u01e3\u01e4\7?\2\2\u01e4\u0098\3\2\2\2\u01e5\u01e7\t\36"+
		"\2\2\u01e6\u01e5\3\2\2\2\u01e7\u01eb\3\2\2\2\u01e8\u01ea\t\37\2\2\u01e9"+
		"\u01e8\3\2\2\2\u01ea\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2"+
		"\2\2\u01ec\u009a\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01f0\t \2\2\u01ef"+
		"\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2\3\2"+
		"\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\bN\2\2\u01f4\u009c\3\2\2\2\25\2\u00e3"+
		"\u00e5\u00ee\u00f0\u01b1\u01b6\u01bc\u01be\u01c4\u01ca\u01cc\u01d1\u01d7"+
		"\u01e1\u01e6\u01e9\u01eb\u01f1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}