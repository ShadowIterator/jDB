// Generated from /Users/hongfangzhou/Learn/_2019Spring/db/jDB/frontend/SimpleSQL.g4 by ANTLR 4.7.2

import java.util.ArrayList;
import javafx.util.Pair;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleSQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, CREATE=7, TABLE=8, INT=9, 
		LONG=10, FLOAT=11, DOUBLE=12, STRING=13, NOT=14, NULL=15, PRIMARY=16, 
		KEY=17, DROP=18, SHOW=19, INSERT=20, INTO=21, VALUES=22, DELETE=23, FROM=24, 
		WHERE=25, UPDATE=26, SET=27, SELECT=28, JOIN=29, ON=30, AND=31, OR=32, 
		TEXT=33, NUMFLOAT=34, NUMFLOATNEG=35, NUMINT=36, NUMINTNEG=37, OP=38, 
		OPE=39, ID=40, WS=41;
	public static final int
		RULE_commands = 0, RULE_sql = 1, RULE_create_table = 2, RULE_attribute_list = 3, 
		RULE_primary_key = 4, RULE_type = 5, RULE_drop_table = 6, RULE_show_table = 7, 
		RULE_insert_into = 8, RULE_attribute_list_insert = 9, RULE_value_single = 10, 
		RULE_value_list = 11, RULE_delete_from = 12, RULE_sql_value = 13, RULE_one_condition = 14, 
		RULE_where_list = 15, RULE_update_table = 16, RULE_select_table = 17, 
		RULE_attribute_list_select = 18, RULE_table_list_select = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"commands", "sql", "create_table", "attribute_list", "primary_key", "type", 
			"drop_table", "show_table", "insert_into", "attribute_list_insert", "value_single", 
			"value_list", "delete_from", "sql_value", "one_condition", "where_list", 
			"update_table", "select_table", "attribute_list_select", "table_list_select"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", "','", "'.'", "'*'", null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "CREATE", "TABLE", "INT", "LONG", 
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

	@Override
	public String getGrammarFileName() { return "SimpleSQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleSQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CommandsContext extends ParserRuleContext {
		public ArrayList<SQLExecutor> sqlExecutorList;
		public SqlContext s;
		public SqlContext ns;
		public List<SqlContext> sql() {
			return getRuleContexts(SqlContext.class);
		}
		public SqlContext sql(int i) {
			return getRuleContext(SqlContext.class,i);
		}
		public CommandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commands; }
	}

	public final CommandsContext commands() throws RecognitionException {
		CommandsContext _localctx = new CommandsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_commands);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((CommandsContext)_localctx).sqlExecutorList =  new ArrayList<SQLExecutor>();
			setState(41);
			((CommandsContext)_localctx).s = sql();
			_localctx.sqlExecutorList.add(((CommandsContext)_localctx).s.sqlExecutor);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CREATE) | (1L << DROP) | (1L << SHOW) | (1L << INSERT) | (1L << DELETE) | (1L << UPDATE) | (1L << SELECT))) != 0)) {
				{
				{
				setState(43);
				((CommandsContext)_localctx).ns = sql();
				_localctx.sqlExecutorList.add(((CommandsContext)_localctx).ns.sqlExecutor);
				}
				}
				setState(50);
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

	public static class SqlContext extends ParserRuleContext {
		public SQLExecutor sqlExecutor;
		public Create_tableContext create_table;
		public Drop_tableContext drop_table;
		public Show_tableContext show_table;
		public Insert_intoContext insert_into;
		public Delete_fromContext delete_from;
		public Update_tableContext update_table;
		public Select_tableContext select_table;
		public Create_tableContext create_table() {
			return getRuleContext(Create_tableContext.class,0);
		}
		public Drop_tableContext drop_table() {
			return getRuleContext(Drop_tableContext.class,0);
		}
		public Show_tableContext show_table() {
			return getRuleContext(Show_tableContext.class,0);
		}
		public Insert_intoContext insert_into() {
			return getRuleContext(Insert_intoContext.class,0);
		}
		public Delete_fromContext delete_from() {
			return getRuleContext(Delete_fromContext.class,0);
		}
		public Update_tableContext update_table() {
			return getRuleContext(Update_tableContext.class,0);
		}
		public Select_tableContext select_table() {
			return getRuleContext(Select_tableContext.class,0);
		}
		public SqlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql; }
	}

	public final SqlContext sql() throws RecognitionException {
		SqlContext _localctx = new SqlContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sql);
		int _la;
		try {
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				((SqlContext)_localctx).create_table = create_table();
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(52);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).create_table.createSqlExec;
				                
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				((SqlContext)_localctx).drop_table = drop_table();
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(58);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).drop_table.dropSqlExec;
				                
				}
				break;
			case SHOW:
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				((SqlContext)_localctx).show_table = show_table();
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(64);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).show_table.showSqlExec;
				                
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				((SqlContext)_localctx).insert_into = insert_into();
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(70);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).insert_into.insertSqlExec;
				                
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				((SqlContext)_localctx).delete_from = delete_from();
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(76);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).delete_from.deleteSqlExec;
				                
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				((SqlContext)_localctx).update_table = update_table();
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(82);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).update_table.updateSqlExec;
				                
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 7);
				{
				setState(87);
				((SqlContext)_localctx).select_table = select_table();
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(88);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).select_table.selectSqlExec;
				                
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

	public static class Create_tableContext extends ParserRuleContext {
		public CreateSQLExecutor createSqlExec;
		public Token ID;
		public Attribute_listContext attribute_list;
		public Primary_keyContext primary_key;
		public TerminalNode CREATE() { return getToken(SimpleSQLParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SimpleSQLParser.TABLE, 0); }
		public TerminalNode ID() { return getToken(SimpleSQLParser.ID, 0); }
		public Attribute_listContext attribute_list() {
			return getRuleContext(Attribute_listContext.class,0);
		}
		public Primary_keyContext primary_key() {
			return getRuleContext(Primary_keyContext.class,0);
		}
		public Create_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_table; }
	}

	public final Create_tableContext create_table() throws RecognitionException {
		Create_tableContext _localctx = new Create_tableContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_create_table);
		try {
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				match(CREATE);
				setState(96);
				match(TABLE);
				setState(97);
				((Create_tableContext)_localctx).ID = match(ID);
				setState(98);
				match(T__1);
				setState(99);
				((Create_tableContext)_localctx).attribute_list = attribute_list();
				setState(100);
				match(T__2);

				                    ((Create_tableContext)_localctx).createSqlExec =  new CreateSQLExecutor((((Create_tableContext)_localctx).ID!=null?((Create_tableContext)_localctx).ID.getText():null), ((Create_tableContext)_localctx).attribute_list.attributeList, null);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(CREATE);
				setState(104);
				match(TABLE);
				setState(105);
				((Create_tableContext)_localctx).ID = match(ID);
				setState(106);
				match(T__1);
				setState(107);
				((Create_tableContext)_localctx).attribute_list = attribute_list();
				setState(108);
				((Create_tableContext)_localctx).primary_key = primary_key();
				setState(109);
				match(T__2);

				                    ((Create_tableContext)_localctx).createSqlExec =  new CreateSQLExecutor((((Create_tableContext)_localctx).ID!=null?((Create_tableContext)_localctx).ID.getText():null), ((Create_tableContext)_localctx).attribute_list.attributeList, ((Create_tableContext)_localctx).primary_key.pkName);
				                
				}
				break;
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

	public static class Attribute_listContext extends ParserRuleContext {
		public ArrayList<AttributeMeta> attributeList;
		public Token ID;
		public TypeContext type;
		public Attribute_listContext attribute_list;
		public TerminalNode ID() { return getToken(SimpleSQLParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Attribute_listContext attribute_list() {
			return getRuleContext(Attribute_listContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SimpleSQLParser.NOT, 0); }
		public TerminalNode NULL() { return getToken(SimpleSQLParser.NULL, 0); }
		public Attribute_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_list; }
	}

	public final Attribute_listContext attribute_list() throws RecognitionException {
		Attribute_listContext _localctx = new Attribute_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attribute_list);
		try {
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(115);
				((Attribute_listContext)_localctx).type = type();
				setState(116);
				match(T__3);
				setState(117);
				((Attribute_listContext)_localctx).attribute_list = attribute_list();

				                     ((Attribute_listContext)_localctx).attributeList =  ((Attribute_listContext)_localctx).attribute_list.attributeList;
				                     _localctx.attributeList.add(0, new AttributeMeta((((Attribute_listContext)_localctx).ID!=null?((Attribute_listContext)_localctx).ID.getText():null), ((Attribute_listContext)_localctx).type.dataType, false));
				                 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(121);
				((Attribute_listContext)_localctx).type = type();
				setState(122);
				match(NOT);
				setState(123);
				match(NULL);
				setState(124);
				match(T__3);
				setState(125);
				((Attribute_listContext)_localctx).attribute_list = attribute_list();

				                     ((Attribute_listContext)_localctx).attributeList =  ((Attribute_listContext)_localctx).attribute_list.attributeList;
				                     _localctx.attributeList.add(0, new AttributeMeta((((Attribute_listContext)_localctx).ID!=null?((Attribute_listContext)_localctx).ID.getText():null), ((Attribute_listContext)_localctx).type.dataType, true));
				                 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(129);
				((Attribute_listContext)_localctx).type = type();

				                     ((Attribute_listContext)_localctx).attributeList =  new ArrayList<AttributeMeta>();
				                     _localctx.attributeList.add(0, new AttributeMeta((((Attribute_listContext)_localctx).ID!=null?((Attribute_listContext)_localctx).ID.getText():null), ((Attribute_listContext)_localctx).type.dataType, false));
				                 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(133);
				((Attribute_listContext)_localctx).type = type();
				setState(134);
				match(NOT);
				setState(135);
				match(NULL);

				                     ((Attribute_listContext)_localctx).attributeList =  new ArrayList<AttributeMeta>();
				                     _localctx.attributeList.add(0, new AttributeMeta((((Attribute_listContext)_localctx).ID!=null?((Attribute_listContext)_localctx).ID.getText():null), ((Attribute_listContext)_localctx).type.dataType, true));
				                 
				}
				break;
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

	public static class Primary_keyContext extends ParserRuleContext {
		public String pkName;
		public Token ID;
		public TerminalNode PRIMARY() { return getToken(SimpleSQLParser.PRIMARY, 0); }
		public TerminalNode KEY() { return getToken(SimpleSQLParser.KEY, 0); }
		public TerminalNode ID() { return getToken(SimpleSQLParser.ID, 0); }
		public Primary_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_key; }
	}

	public final Primary_keyContext primary_key() throws RecognitionException {
		Primary_keyContext _localctx = new Primary_keyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_primary_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__3);
			setState(141);
			match(PRIMARY);
			setState(142);
			match(KEY);
			setState(143);
			match(T__1);
			setState(144);
			((Primary_keyContext)_localctx).ID = match(ID);
			setState(145);
			match(T__2);

			                    ((Primary_keyContext)_localctx).pkName =  (((Primary_keyContext)_localctx).ID!=null?((Primary_keyContext)_localctx).ID.getText():null);
			                
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

	public static class TypeContext extends ParserRuleContext {
		public SQLDataType dataType;
		public Token NUMINT;
		public TerminalNode INT() { return getToken(SimpleSQLParser.INT, 0); }
		public TerminalNode LONG() { return getToken(SimpleSQLParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(SimpleSQLParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(SimpleSQLParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(SimpleSQLParser.STRING, 0); }
		public TerminalNode NUMINT() { return getToken(SimpleSQLParser.NUMINT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(INT);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.INT);
				}
				break;
			case LONG:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(LONG);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.LONG);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				match(FLOAT);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.FLOAT);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				match(DOUBLE);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.DOUBLE);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(156);
				match(STRING);
				setState(157);
				match(T__1);
				setState(158);
				((TypeContext)_localctx).NUMINT = match(NUMINT);
				setState(159);
				match(T__2);
				((TypeContext)_localctx).dataType =  new SQLDataType(Integer.parseInt((((TypeContext)_localctx).NUMINT!=null?((TypeContext)_localctx).NUMINT.getText():null)), SQLDataType.Type.STRING);
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

	public static class Drop_tableContext extends ParserRuleContext {
		public DropSQLExecutor dropSqlExec;
		public Token ID;
		public TerminalNode DROP() { return getToken(SimpleSQLParser.DROP, 0); }
		public TerminalNode TABLE() { return getToken(SimpleSQLParser.TABLE, 0); }
		public TerminalNode ID() { return getToken(SimpleSQLParser.ID, 0); }
		public Drop_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_table; }
	}

	public final Drop_tableContext drop_table() throws RecognitionException {
		Drop_tableContext _localctx = new Drop_tableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_drop_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(DROP);
			setState(164);
			match(TABLE);
			setState(165);
			((Drop_tableContext)_localctx).ID = match(ID);

			                    ((Drop_tableContext)_localctx).dropSqlExec =  new DropSQLExecutor((((Drop_tableContext)_localctx).ID!=null?((Drop_tableContext)_localctx).ID.getText():null));
			                
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

	public static class Show_tableContext extends ParserRuleContext {
		public ShowSQLExecutor showSqlExec;
		public Token ID;
		public TerminalNode SHOW() { return getToken(SimpleSQLParser.SHOW, 0); }
		public TerminalNode TABLE() { return getToken(SimpleSQLParser.TABLE, 0); }
		public TerminalNode ID() { return getToken(SimpleSQLParser.ID, 0); }
		public Show_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_table; }
	}

	public final Show_tableContext show_table() throws RecognitionException {
		Show_tableContext _localctx = new Show_tableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_show_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(SHOW);
			setState(169);
			match(TABLE);
			setState(170);
			((Show_tableContext)_localctx).ID = match(ID);

			                    ((Show_tableContext)_localctx).showSqlExec =  new ShowSQLExecutor((((Show_tableContext)_localctx).ID!=null?((Show_tableContext)_localctx).ID.getText():null));
			                
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

	public static class Insert_intoContext extends ParserRuleContext {
		public InsertSQLExecutor insertSqlExec;
		public Token ID;
		public Value_listContext value_list;
		public Attribute_list_insertContext attribute_list_insert;
		public TerminalNode INSERT() { return getToken(SimpleSQLParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(SimpleSQLParser.INTO, 0); }
		public TerminalNode ID() { return getToken(SimpleSQLParser.ID, 0); }
		public TerminalNode VALUES() { return getToken(SimpleSQLParser.VALUES, 0); }
		public Value_listContext value_list() {
			return getRuleContext(Value_listContext.class,0);
		}
		public Attribute_list_insertContext attribute_list_insert() {
			return getRuleContext(Attribute_list_insertContext.class,0);
		}
		public Insert_intoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_into; }
	}

	public final Insert_intoContext insert_into() throws RecognitionException {
		Insert_intoContext _localctx = new Insert_intoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_insert_into);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				match(INSERT);
				setState(174);
				match(INTO);
				setState(175);
				((Insert_intoContext)_localctx).ID = match(ID);
				setState(176);
				match(VALUES);
				setState(177);
				match(T__1);
				setState(178);
				((Insert_intoContext)_localctx).value_list = value_list();
				setState(179);
				match(T__2);

				                    ((Insert_intoContext)_localctx).insertSqlExec =  new InsertSQLExecutor((((Insert_intoContext)_localctx).ID!=null?((Insert_intoContext)_localctx).ID.getText():null), null, ((Insert_intoContext)_localctx).value_list.valueList);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				match(INSERT);
				setState(183);
				match(INTO);
				setState(184);
				((Insert_intoContext)_localctx).ID = match(ID);
				setState(185);
				match(T__1);
				setState(186);
				((Insert_intoContext)_localctx).attribute_list_insert = attribute_list_insert();
				setState(187);
				match(T__2);
				setState(188);
				match(VALUES);
				setState(189);
				match(T__1);
				setState(190);
				((Insert_intoContext)_localctx).value_list = value_list();
				setState(191);
				match(T__2);

				                    ((Insert_intoContext)_localctx).insertSqlExec =  new InsertSQLExecutor((((Insert_intoContext)_localctx).ID!=null?((Insert_intoContext)_localctx).ID.getText():null), ((Insert_intoContext)_localctx).attribute_list_insert.attributeList, ((Insert_intoContext)_localctx).value_list.valueList);
				                
				}
				break;
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

	public static class Attribute_list_insertContext extends ParserRuleContext {
		public ArrayList<String> attributeList;
		public Token ID;
		public Attribute_list_insertContext attribute_list_insert;
		public TerminalNode ID() { return getToken(SimpleSQLParser.ID, 0); }
		public Attribute_list_insertContext attribute_list_insert() {
			return getRuleContext(Attribute_list_insertContext.class,0);
		}
		public Attribute_list_insertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_list_insert; }
	}

	public final Attribute_list_insertContext attribute_list_insert() throws RecognitionException {
		Attribute_list_insertContext _localctx = new Attribute_list_insertContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_attribute_list_insert);
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				((Attribute_list_insertContext)_localctx).ID = match(ID);
				setState(197);
				match(T__3);
				setState(198);
				((Attribute_list_insertContext)_localctx).attribute_list_insert = attribute_list_insert();

				                    ((Attribute_list_insertContext)_localctx).attributeList =  ((Attribute_list_insertContext)_localctx).attribute_list_insert.attributeList;
				                    _localctx.attributeList.add(0, (((Attribute_list_insertContext)_localctx).ID!=null?((Attribute_list_insertContext)_localctx).ID.getText():null));
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				((Attribute_list_insertContext)_localctx).ID = match(ID);

				                    ((Attribute_list_insertContext)_localctx).attributeList =  new ArrayList<String>();
				                    _localctx.attributeList.add((((Attribute_list_insertContext)_localctx).ID!=null?((Attribute_list_insertContext)_localctx).ID.getText():null));
				                
				}
				break;
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

	public static class Value_singleContext extends ParserRuleContext {
		public String value;
		public Token v;
		public TerminalNode NUMFLOAT() { return getToken(SimpleSQLParser.NUMFLOAT, 0); }
		public TerminalNode NUMINT() { return getToken(SimpleSQLParser.NUMINT, 0); }
		public TerminalNode NUMFLOATNEG() { return getToken(SimpleSQLParser.NUMFLOATNEG, 0); }
		public TerminalNode NUMINTNEG() { return getToken(SimpleSQLParser.NUMINTNEG, 0); }
		public TerminalNode TEXT() { return getToken(SimpleSQLParser.TEXT, 0); }
		public Value_singleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_single; }
	}

	public final Value_singleContext value_single() throws RecognitionException {
		Value_singleContext _localctx = new Value_singleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_value_single);
		int _la;
		try {
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMFLOAT:
			case NUMFLOATNEG:
			case NUMINT:
			case NUMINTNEG:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				((Value_singleContext)_localctx).v = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMFLOAT) | (1L << NUMFLOATNEG) | (1L << NUMINT) | (1L << NUMINTNEG))) != 0)) ) {
					((Value_singleContext)_localctx).v = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}

				                    ((Value_singleContext)_localctx).value =  (((Value_singleContext)_localctx).v!=null?((Value_singleContext)_localctx).v.getText():null);
				                
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				((Value_singleContext)_localctx).v = match(TEXT);

				                    int length = (((Value_singleContext)_localctx).v!=null?((Value_singleContext)_localctx).v.getText():null).length();
				                    ((Value_singleContext)_localctx).value =  (((Value_singleContext)_localctx).v!=null?((Value_singleContext)_localctx).v.getText():null).substring(1, length-1);
				                
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

	public static class Value_listContext extends ParserRuleContext {
		public ArrayList<String> valueList;
		public Value_singleContext value_single;
		public Value_listContext value_list;
		public Value_singleContext value_single() {
			return getRuleContext(Value_singleContext.class,0);
		}
		public Value_listContext value_list() {
			return getRuleContext(Value_listContext.class,0);
		}
		public Value_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_list; }
	}

	public final Value_listContext value_list() throws RecognitionException {
		Value_listContext _localctx = new Value_listContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_value_list);
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				((Value_listContext)_localctx).value_single = value_single();
				setState(212);
				match(T__3);
				setState(213);
				((Value_listContext)_localctx).value_list = value_list();

				                    ((Value_listContext)_localctx).valueList =  ((Value_listContext)_localctx).value_list.valueList;
				                    _localctx.valueList.add(0, ((Value_listContext)_localctx).value_single.value);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				((Value_listContext)_localctx).value_single = value_single();

				                    ((Value_listContext)_localctx).valueList =  new ArrayList<String>();
				                    _localctx.valueList.add(((Value_listContext)_localctx).value_single.value);
				                
				}
				break;
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

	public static class Delete_fromContext extends ParserRuleContext {
		public DeleteSQLExecutor deleteSqlExec;
		public Token ID;
		public Where_listContext where_list;
		public TerminalNode DELETE() { return getToken(SimpleSQLParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(SimpleSQLParser.FROM, 0); }
		public TerminalNode ID() { return getToken(SimpleSQLParser.ID, 0); }
		public TerminalNode WHERE() { return getToken(SimpleSQLParser.WHERE, 0); }
		public Where_listContext where_list() {
			return getRuleContext(Where_listContext.class,0);
		}
		public Delete_fromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_from; }
	}

	public final Delete_fromContext delete_from() throws RecognitionException {
		Delete_fromContext _localctx = new Delete_fromContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_delete_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(DELETE);
			setState(222);
			match(FROM);
			setState(223);
			((Delete_fromContext)_localctx).ID = match(ID);
			setState(224);
			match(WHERE);
			setState(225);
			((Delete_fromContext)_localctx).where_list = where_list();

			                    ((Delete_fromContext)_localctx).deleteSqlExec =  new DeleteSQLExecutor((((Delete_fromContext)_localctx).ID!=null?((Delete_fromContext)_localctx).ID.getText():null), ((Delete_fromContext)_localctx).where_list.whereCondition);
			                
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

	public static class Sql_valueContext extends ParserRuleContext {
		public SQLValue sqlValue;
		public Token ID;
		public Token t;
		public Token a;
		public Value_singleContext value_single;
		public List<TerminalNode> ID() { return getTokens(SimpleSQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleSQLParser.ID, i);
		}
		public Value_singleContext value_single() {
			return getRuleContext(Value_singleContext.class,0);
		}
		public Sql_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_value; }
	}

	public final Sql_valueContext sql_value() throws RecognitionException {
		Sql_valueContext _localctx = new Sql_valueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sql_value);
		try {
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				((Sql_valueContext)_localctx).ID = match(ID);

				                    ((Sql_valueContext)_localctx).sqlValue =  new SQLValue(null, (((Sql_valueContext)_localctx).ID!=null?((Sql_valueContext)_localctx).ID.getText():null));
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				((Sql_valueContext)_localctx).t = match(ID);
				setState(231);
				match(T__4);
				setState(232);
				((Sql_valueContext)_localctx).a = match(ID);

				                    ((Sql_valueContext)_localctx).sqlValue =  new SQLValue((((Sql_valueContext)_localctx).t!=null?((Sql_valueContext)_localctx).t.getText():null), (((Sql_valueContext)_localctx).a!=null?((Sql_valueContext)_localctx).a.getText():null));
				                
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
				((Sql_valueContext)_localctx).value_single = value_single();

				                    ((Sql_valueContext)_localctx).sqlValue =  new SQLValue(((Sql_valueContext)_localctx).value_single.value);
				                
				}
				break;
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

	public static class One_conditionContext extends ParserRuleContext {
		public OneCondition oneCondition;
		public Sql_valueContext l;
		public Token op;
		public Sql_valueContext r;
		public List<Sql_valueContext> sql_value() {
			return getRuleContexts(Sql_valueContext.class);
		}
		public Sql_valueContext sql_value(int i) {
			return getRuleContext(Sql_valueContext.class,i);
		}
		public TerminalNode OP() { return getToken(SimpleSQLParser.OP, 0); }
		public TerminalNode OPE() { return getToken(SimpleSQLParser.OPE, 0); }
		public One_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_condition; }
	}

	public final One_conditionContext one_condition() throws RecognitionException {
		One_conditionContext _localctx = new One_conditionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_one_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			((One_conditionContext)_localctx).l = sql_value();
			setState(240);
			((One_conditionContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==OP || _la==OPE) ) {
				((One_conditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(241);
			((One_conditionContext)_localctx).r = sql_value();

			                    WhereCondition.Operator _op = WhereCondition.Operator.EQ;
			                    switch((((One_conditionContext)_localctx).op!=null?((One_conditionContext)_localctx).op.getText():null)) {
			                        case "=":
			                            _op = WhereCondition.Operator.EQ;
			                            break;
			                        case ">":
			                            _op = WhereCondition.Operator.GT;
			                            break;
			                        case ">=":
			                            _op = WhereCondition.Operator.GEQ;
			                            break;
			                        case "<":
			                            _op = WhereCondition.Operator.LT;
			                            break;
			                        case "<=":
			                            _op = WhereCondition.Operator.LEQ;
			                            break;
			                    }
			                    ((One_conditionContext)_localctx).oneCondition =  new OneCondition(((One_conditionContext)_localctx).l.sqlValue, ((One_conditionContext)_localctx).r.sqlValue, _op);
			                
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

	public static class Where_listContext extends ParserRuleContext {
		public WhereCondition whereCondition;
		public One_conditionContext one_condition;
		public Where_listContext where_list;
		public One_conditionContext one_condition() {
			return getRuleContext(One_conditionContext.class,0);
		}
		public TerminalNode AND() { return getToken(SimpleSQLParser.AND, 0); }
		public Where_listContext where_list() {
			return getRuleContext(Where_listContext.class,0);
		}
		public TerminalNode OR() { return getToken(SimpleSQLParser.OR, 0); }
		public Where_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_list; }
	}

	public final Where_listContext where_list() throws RecognitionException {
		Where_listContext _localctx = new Where_listContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_where_list);
		try {
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				((Where_listContext)_localctx).one_condition = one_condition();
				setState(245);
				match(AND);
				setState(246);
				((Where_listContext)_localctx).where_list = where_list();

				                    ((Where_listContext)_localctx).whereCondition =  ((Where_listContext)_localctx).where_list.whereCondition;
				                    WhereCondition.LogicConnection _logic = WhereCondition.LogicConnection.AND;
				                    _localctx.whereCondition.AddCondition(((Where_listContext)_localctx).one_condition.oneCondition, _logic);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				((Where_listContext)_localctx).one_condition = one_condition();
				setState(250);
				match(OR);
				setState(251);
				((Where_listContext)_localctx).where_list = where_list();

				                    ((Where_listContext)_localctx).whereCondition =  ((Where_listContext)_localctx).where_list.whereCondition;
				                    WhereCondition.LogicConnection _logic = WhereCondition.LogicConnection.OR;
				                    _localctx.whereCondition.AddCondition(((Where_listContext)_localctx).one_condition.oneCondition, _logic);
				                
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(254);
				((Where_listContext)_localctx).one_condition = one_condition();

				                    ((Where_listContext)_localctx).whereCondition =  new WhereCondition();
				                    _localctx.whereCondition.conditions.add(((Where_listContext)_localctx).one_condition.oneCondition);
				                
				}
				break;
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

	public static class Update_tableContext extends ParserRuleContext {
		public UpdateSQLExecutor updateSqlExec;
		public Token t;
		public Token a;
		public Value_singleContext value_single;
		public Where_listContext where_list;
		public TerminalNode UPDATE() { return getToken(SimpleSQLParser.UPDATE, 0); }
		public TerminalNode SET() { return getToken(SimpleSQLParser.SET, 0); }
		public TerminalNode OPE() { return getToken(SimpleSQLParser.OPE, 0); }
		public Value_singleContext value_single() {
			return getRuleContext(Value_singleContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(SimpleSQLParser.WHERE, 0); }
		public Where_listContext where_list() {
			return getRuleContext(Where_listContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(SimpleSQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleSQLParser.ID, i);
		}
		public Update_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_table; }
	}

	public final Update_tableContext update_table() throws RecognitionException {
		Update_tableContext _localctx = new Update_tableContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_update_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(UPDATE);
			setState(260);
			((Update_tableContext)_localctx).t = match(ID);
			setState(261);
			match(SET);
			setState(262);
			((Update_tableContext)_localctx).a = match(ID);
			setState(263);
			match(OPE);
			setState(264);
			((Update_tableContext)_localctx).value_single = value_single();
			setState(265);
			match(WHERE);
			setState(266);
			((Update_tableContext)_localctx).where_list = where_list();

			                    ((Update_tableContext)_localctx).updateSqlExec =  new UpdateSQLExecutor((((Update_tableContext)_localctx).t!=null?((Update_tableContext)_localctx).t.getText():null), (((Update_tableContext)_localctx).a!=null?((Update_tableContext)_localctx).a.getText():null), ((Update_tableContext)_localctx).value_single.value, ((Update_tableContext)_localctx).where_list.whereCondition);
			                
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

	public static class Select_tableContext extends ParserRuleContext {
		public SelectSQLExecutor selectSqlExec;
		public Attribute_list_selectContext attribute_list_select;
		public Table_list_selectContext table_list_select;
		public Where_listContext where_list;
		public TerminalNode SELECT() { return getToken(SimpleSQLParser.SELECT, 0); }
		public Attribute_list_selectContext attribute_list_select() {
			return getRuleContext(Attribute_list_selectContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SimpleSQLParser.FROM, 0); }
		public Table_list_selectContext table_list_select() {
			return getRuleContext(Table_list_selectContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(SimpleSQLParser.WHERE, 0); }
		public Where_listContext where_list() {
			return getRuleContext(Where_listContext.class,0);
		}
		public Select_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_table; }
	}

	public final Select_tableContext select_table() throws RecognitionException {
		Select_tableContext _localctx = new Select_tableContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_select_table);
		try {
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				match(SELECT);
				setState(270);
				((Select_tableContext)_localctx).attribute_list_select = attribute_list_select();
				setState(271);
				match(FROM);
				setState(272);
				((Select_tableContext)_localctx).table_list_select = table_list_select();

				                    ((Select_tableContext)_localctx).selectSqlExec =  new SelectSQLExecutor();
				                    _localctx.selectSqlExec.setAttributeList(((Select_tableContext)_localctx).attribute_list_select.attributeList);
				                    _localctx.selectSqlExec.setTableJoin(((Select_tableContext)_localctx).table_list_select.tableJoin);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				match(SELECT);
				setState(276);
				((Select_tableContext)_localctx).attribute_list_select = attribute_list_select();
				setState(277);
				match(FROM);
				setState(278);
				((Select_tableContext)_localctx).table_list_select = table_list_select();
				setState(279);
				match(WHERE);
				setState(280);
				((Select_tableContext)_localctx).where_list = where_list();

				                    ((Select_tableContext)_localctx).selectSqlExec =  new SelectSQLExecutor();
				                    _localctx.selectSqlExec.setAttributeList(((Select_tableContext)_localctx).attribute_list_select.attributeList);
				                    _localctx.selectSqlExec.setTableJoin(((Select_tableContext)_localctx).table_list_select.tableJoin);
				                    _localctx.selectSqlExec.setWhereCondition(((Select_tableContext)_localctx).where_list.whereCondition);
				                
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(283);
				match(SELECT);
				setState(284);
				match(T__5);
				setState(285);
				match(FROM);
				setState(286);
				((Select_tableContext)_localctx).table_list_select = table_list_select();

				                    ((Select_tableContext)_localctx).selectSqlExec =  new SelectSQLExecutor();
				                    _localctx.selectSqlExec.setSelectAll(true);
				                    _localctx.selectSqlExec.setTableJoin(((Select_tableContext)_localctx).table_list_select.tableJoin);
				                
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(289);
				match(SELECT);
				setState(290);
				match(T__5);
				setState(291);
				match(FROM);
				setState(292);
				((Select_tableContext)_localctx).table_list_select = table_list_select();
				setState(293);
				match(WHERE);
				setState(294);
				((Select_tableContext)_localctx).where_list = where_list();

				                    ((Select_tableContext)_localctx).selectSqlExec =  new SelectSQLExecutor();
				                    _localctx.selectSqlExec.setSelectAll(true);
				                    _localctx.selectSqlExec.setTableJoin(((Select_tableContext)_localctx).table_list_select.tableJoin);
				                    _localctx.selectSqlExec.setWhereCondition(((Select_tableContext)_localctx).where_list.whereCondition);
				                
				}
				break;
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

	public static class Attribute_list_selectContext extends ParserRuleContext {
		public ArrayList<Pair<String, String> > attributeList;
		public Token ID;
		public Attribute_list_selectContext attribute_list_select;
		public Token t;
		public Token a;
		public List<TerminalNode> ID() { return getTokens(SimpleSQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleSQLParser.ID, i);
		}
		public Attribute_list_selectContext attribute_list_select() {
			return getRuleContext(Attribute_list_selectContext.class,0);
		}
		public Attribute_list_selectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_list_select; }
	}

	public final Attribute_list_selectContext attribute_list_select() throws RecognitionException {
		Attribute_list_selectContext _localctx = new Attribute_list_selectContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_attribute_list_select);
		try {
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				((Attribute_list_selectContext)_localctx).ID = match(ID);
				setState(300);
				match(T__3);
				setState(301);
				((Attribute_list_selectContext)_localctx).attribute_list_select = attribute_list_select();

				                            Pair<String, String> newAttr = new Pair<>(null, (((Attribute_list_selectContext)_localctx).ID!=null?((Attribute_list_selectContext)_localctx).ID.getText():null));
				                            ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList.add(0, newAttr);
				                            ((Attribute_list_selectContext)_localctx).attributeList =  ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList;
				                        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				((Attribute_list_selectContext)_localctx).t = match(ID);
				setState(305);
				match(T__4);
				setState(306);
				((Attribute_list_selectContext)_localctx).a = match(ID);
				setState(307);
				match(T__3);
				setState(308);
				((Attribute_list_selectContext)_localctx).attribute_list_select = attribute_list_select();

				                            Pair<String, String> newAttr = new Pair<>((((Attribute_list_selectContext)_localctx).t!=null?((Attribute_list_selectContext)_localctx).t.getText():null), (((Attribute_list_selectContext)_localctx).a!=null?((Attribute_list_selectContext)_localctx).a.getText():null));
				                            ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList.add(0, newAttr);
				                            ((Attribute_list_selectContext)_localctx).attributeList =  ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList;
				                        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(311);
				((Attribute_list_selectContext)_localctx).ID = match(ID);

				                            Pair<String, String> newAttr = new Pair<>(null, (((Attribute_list_selectContext)_localctx).ID!=null?((Attribute_list_selectContext)_localctx).ID.getText():null));
				                            ((Attribute_list_selectContext)_localctx).attributeList =  new ArrayList<Pair<String, String> >();
				                            _localctx.attributeList.add(newAttr);
				                        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(313);
				((Attribute_list_selectContext)_localctx).t = match(ID);
				setState(314);
				match(T__4);
				setState(315);
				((Attribute_list_selectContext)_localctx).a = match(ID);

				                            Pair<String, String> newAttr = new Pair<>((((Attribute_list_selectContext)_localctx).t!=null?((Attribute_list_selectContext)_localctx).t.getText():null), (((Attribute_list_selectContext)_localctx).a!=null?((Attribute_list_selectContext)_localctx).a.getText():null));
				                            ((Attribute_list_selectContext)_localctx).attributeList =  new ArrayList<Pair<String, String> >();
				                            _localctx.attributeList.add(newAttr);
				                        
				}
				break;
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

	public static class Table_list_selectContext extends ParserRuleContext {
		public TableJoin tableJoin;
		public Token f;
		public Token s;
		public Token ft;
		public Token fa;
		public Token st;
		public Token sa;
		public Token ID;
		public TerminalNode JOIN() { return getToken(SimpleSQLParser.JOIN, 0); }
		public TerminalNode ON() { return getToken(SimpleSQLParser.ON, 0); }
		public TerminalNode OPE() { return getToken(SimpleSQLParser.OPE, 0); }
		public List<TerminalNode> ID() { return getTokens(SimpleSQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleSQLParser.ID, i);
		}
		public Table_list_selectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_list_select; }
	}

	public final Table_list_selectContext table_list_select() throws RecognitionException {
		Table_list_selectContext _localctx = new Table_list_selectContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_table_list_select);
		try {
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				((Table_list_selectContext)_localctx).f = match(ID);
				setState(320);
				match(JOIN);
				setState(321);
				((Table_list_selectContext)_localctx).s = match(ID);
				setState(322);
				match(ON);
				setState(323);
				((Table_list_selectContext)_localctx).ft = match(ID);
				setState(324);
				match(T__4);
				setState(325);
				((Table_list_selectContext)_localctx).fa = match(ID);
				setState(326);
				match(OPE);
				setState(327);
				((Table_list_selectContext)_localctx).st = match(ID);
				setState(328);
				match(T__4);
				setState(329);
				((Table_list_selectContext)_localctx).sa = match(ID);

				                            ((Table_list_selectContext)_localctx).tableJoin =  new TableJoin();
				                            _localctx.tableJoin.isJoin = true;
				                            _localctx.tableJoin.firstTableName = (((Table_list_selectContext)_localctx).f!=null?((Table_list_selectContext)_localctx).f.getText():null);
				                            _localctx.tableJoin.secondTableName = (((Table_list_selectContext)_localctx).s!=null?((Table_list_selectContext)_localctx).s.getText():null);
				                            _localctx.tableJoin.onCondition = new WhereCondition();
				                            SQLValue _leftValue = new SQLValue((((Table_list_selectContext)_localctx).ft!=null?((Table_list_selectContext)_localctx).ft.getText():null), (((Table_list_selectContext)_localctx).fa!=null?((Table_list_selectContext)_localctx).fa.getText():null));
				                            SQLValue _rightValue = new SQLValue((((Table_list_selectContext)_localctx).st!=null?((Table_list_selectContext)_localctx).st.getText():null), (((Table_list_selectContext)_localctx).sa!=null?((Table_list_selectContext)_localctx).sa.getText():null));
				                            WhereCondition.Operator _op = WhereCondition.Operator.EQ;
				                            OneCondition _oneCondition = new OneCondition(_leftValue, _rightValue, _op);
				                            _localctx.tableJoin.onCondition.conditions.add(_oneCondition);
				                        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(331);
				((Table_list_selectContext)_localctx).ID = match(ID);

				                            ((Table_list_selectContext)_localctx).tableJoin =  new TableJoin();
				                            _localctx.tableJoin.isJoin = false;
				                            _localctx.tableJoin.firstTableName = (((Table_list_selectContext)_localctx).ID!=null?((Table_list_selectContext)_localctx).ID.getText():null);
				                        
				}
				break;
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u0152\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\7\2\61\n\2\f\2"+
		"\16\2\64\13\2\3\3\3\3\5\38\n\3\3\3\3\3\3\3\3\3\5\3>\n\3\3\3\3\3\3\3\3"+
		"\3\5\3D\n\3\3\3\3\3\3\3\3\3\5\3J\n\3\3\3\3\3\3\3\3\3\5\3P\n\3\3\3\3\3"+
		"\3\3\3\3\5\3V\n\3\3\3\3\3\3\3\3\3\5\3\\\n\3\3\3\3\3\5\3`\n\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4s\n\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u008d\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a4\n\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c5\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ce\n\13\3\f\3\f\3\f\3\f\5\f\u00d4"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00de\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00f0"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u0104\n\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u012c\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0140\n\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u0150\n\25\3\25\2\2\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(\2\4\3\2$\'\3\2()\2\u0162\2*\3\2\2\2\4_\3\2\2\2\6r\3\2\2\2\b\u008c"+
		"\3\2\2\2\n\u008e\3\2\2\2\f\u00a3\3\2\2\2\16\u00a5\3\2\2\2\20\u00aa\3\2"+
		"\2\2\22\u00c4\3\2\2\2\24\u00cd\3\2\2\2\26\u00d3\3\2\2\2\30\u00dd\3\2\2"+
		"\2\32\u00df\3\2\2\2\34\u00ef\3\2\2\2\36\u00f1\3\2\2\2 \u0103\3\2\2\2\""+
		"\u0105\3\2\2\2$\u012b\3\2\2\2&\u013f\3\2\2\2(\u014f\3\2\2\2*+\b\2\1\2"+
		"+,\5\4\3\2,\62\b\2\1\2-.\5\4\3\2./\b\2\1\2/\61\3\2\2\2\60-\3\2\2\2\61"+
		"\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\3\3\2\2\2\64\62\3\2\2\2\65"+
		"\67\5\6\4\2\668\7\3\2\2\67\66\3\2\2\2\678\3\2\2\289\3\2\2\29:\b\3\1\2"+
		":`\3\2\2\2;=\5\16\b\2<>\7\3\2\2=<\3\2\2\2=>\3\2\2\2>?\3\2\2\2?@\b\3\1"+
		"\2@`\3\2\2\2AC\5\20\t\2BD\7\3\2\2CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\b\3"+
		"\1\2F`\3\2\2\2GI\5\22\n\2HJ\7\3\2\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\b"+
		"\3\1\2L`\3\2\2\2MO\5\32\16\2NP\7\3\2\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2Q"+
		"R\b\3\1\2R`\3\2\2\2SU\5\"\22\2TV\7\3\2\2UT\3\2\2\2UV\3\2\2\2VW\3\2\2\2"+
		"WX\b\3\1\2X`\3\2\2\2Y[\5$\23\2Z\\\7\3\2\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2"+
		"\2\2]^\b\3\1\2^`\3\2\2\2_\65\3\2\2\2_;\3\2\2\2_A\3\2\2\2_G\3\2\2\2_M\3"+
		"\2\2\2_S\3\2\2\2_Y\3\2\2\2`\5\3\2\2\2ab\7\t\2\2bc\7\n\2\2cd\7*\2\2de\7"+
		"\4\2\2ef\5\b\5\2fg\7\5\2\2gh\b\4\1\2hs\3\2\2\2ij\7\t\2\2jk\7\n\2\2kl\7"+
		"*\2\2lm\7\4\2\2mn\5\b\5\2no\5\n\6\2op\7\5\2\2pq\b\4\1\2qs\3\2\2\2ra\3"+
		"\2\2\2ri\3\2\2\2s\7\3\2\2\2tu\7*\2\2uv\5\f\7\2vw\7\6\2\2wx\5\b\5\2xy\b"+
		"\5\1\2y\u008d\3\2\2\2z{\7*\2\2{|\5\f\7\2|}\7\20\2\2}~\7\21\2\2~\177\7"+
		"\6\2\2\177\u0080\5\b\5\2\u0080\u0081\b\5\1\2\u0081\u008d\3\2\2\2\u0082"+
		"\u0083\7*\2\2\u0083\u0084\5\f\7\2\u0084\u0085\b\5\1\2\u0085\u008d\3\2"+
		"\2\2\u0086\u0087\7*\2\2\u0087\u0088\5\f\7\2\u0088\u0089\7\20\2\2\u0089"+
		"\u008a\7\21\2\2\u008a\u008b\b\5\1\2\u008b\u008d\3\2\2\2\u008ct\3\2\2\2"+
		"\u008cz\3\2\2\2\u008c\u0082\3\2\2\2\u008c\u0086\3\2\2\2\u008d\t\3\2\2"+
		"\2\u008e\u008f\7\6\2\2\u008f\u0090\7\22\2\2\u0090\u0091\7\23\2\2\u0091"+
		"\u0092\7\4\2\2\u0092\u0093\7*\2\2\u0093\u0094\7\5\2\2\u0094\u0095\b\6"+
		"\1\2\u0095\13\3\2\2\2\u0096\u0097\7\13\2\2\u0097\u00a4\b\7\1\2\u0098\u0099"+
		"\7\f\2\2\u0099\u00a4\b\7\1\2\u009a\u009b\7\r\2\2\u009b\u00a4\b\7\1\2\u009c"+
		"\u009d\7\16\2\2\u009d\u00a4\b\7\1\2\u009e\u009f\7\17\2\2\u009f\u00a0\7"+
		"\4\2\2\u00a0\u00a1\7&\2\2\u00a1\u00a2\7\5\2\2\u00a2\u00a4\b\7\1\2\u00a3"+
		"\u0096\3\2\2\2\u00a3\u0098\3\2\2\2\u00a3\u009a\3\2\2\2\u00a3\u009c\3\2"+
		"\2\2\u00a3\u009e\3\2\2\2\u00a4\r\3\2\2\2\u00a5\u00a6\7\24\2\2\u00a6\u00a7"+
		"\7\n\2\2\u00a7\u00a8\7*\2\2\u00a8\u00a9\b\b\1\2\u00a9\17\3\2\2\2\u00aa"+
		"\u00ab\7\25\2\2\u00ab\u00ac\7\n\2\2\u00ac\u00ad\7*\2\2\u00ad\u00ae\b\t"+
		"\1\2\u00ae\21\3\2\2\2\u00af\u00b0\7\26\2\2\u00b0\u00b1\7\27\2\2\u00b1"+
		"\u00b2\7*\2\2\u00b2\u00b3\7\30\2\2\u00b3\u00b4\7\4\2\2\u00b4\u00b5\5\30"+
		"\r\2\u00b5\u00b6\7\5\2\2\u00b6\u00b7\b\n\1\2\u00b7\u00c5\3\2\2\2\u00b8"+
		"\u00b9\7\26\2\2\u00b9\u00ba\7\27\2\2\u00ba\u00bb\7*\2\2\u00bb\u00bc\7"+
		"\4\2\2\u00bc\u00bd\5\24\13\2\u00bd\u00be\7\5\2\2\u00be\u00bf\7\30\2\2"+
		"\u00bf\u00c0\7\4\2\2\u00c0\u00c1\5\30\r\2\u00c1\u00c2\7\5\2\2\u00c2\u00c3"+
		"\b\n\1\2\u00c3\u00c5\3\2\2\2\u00c4\u00af\3\2\2\2\u00c4\u00b8\3\2\2\2\u00c5"+
		"\23\3\2\2\2\u00c6\u00c7\7*\2\2\u00c7\u00c8\7\6\2\2\u00c8\u00c9\5\24\13"+
		"\2\u00c9\u00ca\b\13\1\2\u00ca\u00ce\3\2\2\2\u00cb\u00cc\7*\2\2\u00cc\u00ce"+
		"\b\13\1\2\u00cd\u00c6\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\25\3\2\2\2\u00cf"+
		"\u00d0\t\2\2\2\u00d0\u00d4\b\f\1\2\u00d1\u00d2\7#\2\2\u00d2\u00d4\b\f"+
		"\1\2\u00d3\u00cf\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\27\3\2\2\2\u00d5\u00d6"+
		"\5\26\f\2\u00d6\u00d7\7\6\2\2\u00d7\u00d8\5\30\r\2\u00d8\u00d9\b\r\1\2"+
		"\u00d9\u00de\3\2\2\2\u00da\u00db\5\26\f\2\u00db\u00dc\b\r\1\2\u00dc\u00de"+
		"\3\2\2\2\u00dd\u00d5\3\2\2\2\u00dd\u00da\3\2\2\2\u00de\31\3\2\2\2\u00df"+
		"\u00e0\7\31\2\2\u00e0\u00e1\7\32\2\2\u00e1\u00e2\7*\2\2\u00e2\u00e3\7"+
		"\33\2\2\u00e3\u00e4\5 \21\2\u00e4\u00e5\b\16\1\2\u00e5\33\3\2\2\2\u00e6"+
		"\u00e7\7*\2\2\u00e7\u00f0\b\17\1\2\u00e8\u00e9\7*\2\2\u00e9\u00ea\7\7"+
		"\2\2\u00ea\u00eb\7*\2\2\u00eb\u00f0\b\17\1\2\u00ec\u00ed\5\26\f\2\u00ed"+
		"\u00ee\b\17\1\2\u00ee\u00f0\3\2\2\2\u00ef\u00e6\3\2\2\2\u00ef\u00e8\3"+
		"\2\2\2\u00ef\u00ec\3\2\2\2\u00f0\35\3\2\2\2\u00f1\u00f2\5\34\17\2\u00f2"+
		"\u00f3\t\3\2\2\u00f3\u00f4\5\34\17\2\u00f4\u00f5\b\20\1\2\u00f5\37\3\2"+
		"\2\2\u00f6\u00f7\5\36\20\2\u00f7\u00f8\7!\2\2\u00f8\u00f9\5 \21\2\u00f9"+
		"\u00fa\b\21\1\2\u00fa\u0104\3\2\2\2\u00fb\u00fc\5\36\20\2\u00fc\u00fd"+
		"\7\"\2\2\u00fd\u00fe\5 \21\2\u00fe\u00ff\b\21\1\2\u00ff\u0104\3\2\2\2"+
		"\u0100\u0101\5\36\20\2\u0101\u0102\b\21\1\2\u0102\u0104\3\2\2\2\u0103"+
		"\u00f6\3\2\2\2\u0103\u00fb\3\2\2\2\u0103\u0100\3\2\2\2\u0104!\3\2\2\2"+
		"\u0105\u0106\7\34\2\2\u0106\u0107\7*\2\2\u0107\u0108\7\35\2\2\u0108\u0109"+
		"\7*\2\2\u0109\u010a\7)\2\2\u010a\u010b\5\26\f\2\u010b\u010c\7\33\2\2\u010c"+
		"\u010d\5 \21\2\u010d\u010e\b\22\1\2\u010e#\3\2\2\2\u010f\u0110\7\36\2"+
		"\2\u0110\u0111\5&\24\2\u0111\u0112\7\32\2\2\u0112\u0113\5(\25\2\u0113"+
		"\u0114\b\23\1\2\u0114\u012c\3\2\2\2\u0115\u0116\7\36\2\2\u0116\u0117\5"+
		"&\24\2\u0117\u0118\7\32\2\2\u0118\u0119\5(\25\2\u0119\u011a\7\33\2\2\u011a"+
		"\u011b\5 \21\2\u011b\u011c\b\23\1\2\u011c\u012c\3\2\2\2\u011d\u011e\7"+
		"\36\2\2\u011e\u011f\7\b\2\2\u011f\u0120\7\32\2\2\u0120\u0121\5(\25\2\u0121"+
		"\u0122\b\23\1\2\u0122\u012c\3\2\2\2\u0123\u0124\7\36\2\2\u0124\u0125\7"+
		"\b\2\2\u0125\u0126\7\32\2\2\u0126\u0127\5(\25\2\u0127\u0128\7\33\2\2\u0128"+
		"\u0129\5 \21\2\u0129\u012a\b\23\1\2\u012a\u012c\3\2\2\2\u012b\u010f\3"+
		"\2\2\2\u012b\u0115\3\2\2\2\u012b\u011d\3\2\2\2\u012b\u0123\3\2\2\2\u012c"+
		"%\3\2\2\2\u012d\u012e\7*\2\2\u012e\u012f\7\6\2\2\u012f\u0130\5&\24\2\u0130"+
		"\u0131\b\24\1\2\u0131\u0140\3\2\2\2\u0132\u0133\7*\2\2\u0133\u0134\7\7"+
		"\2\2\u0134\u0135\7*\2\2\u0135\u0136\7\6\2\2\u0136\u0137\5&\24\2\u0137"+
		"\u0138\b\24\1\2\u0138\u0140\3\2\2\2\u0139\u013a\7*\2\2\u013a\u0140\b\24"+
		"\1\2\u013b\u013c\7*\2\2\u013c\u013d\7\7\2\2\u013d\u013e\7*\2\2\u013e\u0140"+
		"\b\24\1\2\u013f\u012d\3\2\2\2\u013f\u0132\3\2\2\2\u013f\u0139\3\2\2\2"+
		"\u013f\u013b\3\2\2\2\u0140\'\3\2\2\2\u0141\u0142\7*\2\2\u0142\u0143\7"+
		"\37\2\2\u0143\u0144\7*\2\2\u0144\u0145\7 \2\2\u0145\u0146\7*\2\2\u0146"+
		"\u0147\7\7\2\2\u0147\u0148\7*\2\2\u0148\u0149\7)\2\2\u0149\u014a\7*\2"+
		"\2\u014a\u014b\7\7\2\2\u014b\u014c\7*\2\2\u014c\u0150\b\25\1\2\u014d\u014e"+
		"\7*\2\2\u014e\u0150\b\25\1\2\u014f\u0141\3\2\2\2\u014f\u014d\3\2\2\2\u0150"+
		")\3\2\2\2\27\62\67=CIOU[_r\u008c\u00a3\u00c4\u00cd\u00d3\u00dd\u00ef\u0103"+
		"\u012b\u013f\u014f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}