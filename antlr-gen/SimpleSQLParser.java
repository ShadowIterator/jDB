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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, CREATE=6, TABLE=7, INT=8, LONG=9, 
		FLOAT=10, DOUBLE=11, STRING=12, NOT=13, NULL=14, PRIMARY=15, KEY=16, DROP=17, 
		SHOW=18, INSERT=19, INTO=20, VALUES=21, DELETE=22, FROM=23, WHERE=24, 
		UPDATE=25, SET=26, SELECT=27, JOIN=28, ON=29, AND=30, OR=31, TEXT=32, 
		NUMFLOAT=33, NUMFLOATNEG=34, NUMINT=35, NUMINTNEG=36, OP=37, OPE=38, ID=39, 
		WS=40;
	public static final int
		RULE_commands = 0, RULE_sql = 1, RULE_create_table = 2, RULE_attribute_list = 3, 
		RULE_primary_key = 4, RULE_type = 5, RULE_drop_table = 6, RULE_show_table = 7, 
		RULE_insert_into = 8, RULE_attribute_list_insert = 9, RULE_value_single = 10, 
		RULE_value_list = 11, RULE_delete_from = 12, RULE_where_list = 13, RULE_update_table = 14, 
		RULE_select_table = 15, RULE_attribute_list_select = 16, RULE_table_list_select = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"commands", "sql", "create_table", "attribute_list", "primary_key", "type", 
			"drop_table", "show_table", "insert_into", "attribute_list_insert", "value_single", 
			"value_list", "delete_from", "where_list", "update_table", "select_table", 
			"attribute_list_select", "table_list_select"
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
			setState(37);
			((CommandsContext)_localctx).s = sql();
			_localctx.sqlExecutorList.add(((CommandsContext)_localctx).s.sqlExecutor);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CREATE) | (1L << DROP) | (1L << SHOW) | (1L << INSERT) | (1L << DELETE) | (1L << UPDATE) | (1L << SELECT))) != 0)) {
				{
				{
				setState(39);
				((CommandsContext)_localctx).ns = sql();
				_localctx.sqlExecutorList.add(((CommandsContext)_localctx).ns.sqlExecutor);
				}
				}
				setState(46);
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
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				((SqlContext)_localctx).create_table = create_table();
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(48);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).create_table.createSqlExec;
				                
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				((SqlContext)_localctx).drop_table = drop_table();
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(54);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).drop_table.dropSqlExec;
				                
				}
				break;
			case SHOW:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				((SqlContext)_localctx).show_table = show_table();
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(60);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).show_table.showSqlExec;
				                
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				((SqlContext)_localctx).insert_into = insert_into();
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(66);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).insert_into.insertSqlExec;
				                
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				((SqlContext)_localctx).delete_from = delete_from();
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(72);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).delete_from.deleteSqlExec;
				                
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 6);
				{
				setState(77);
				((SqlContext)_localctx).update_table = update_table();
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(78);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).update_table.updateSqlExec;
				                
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 7);
				{
				setState(83);
				((SqlContext)_localctx).select_table = select_table();
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(84);
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
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(CREATE);
				setState(92);
				match(TABLE);
				setState(93);
				((Create_tableContext)_localctx).ID = match(ID);
				setState(94);
				match(T__1);
				setState(95);
				((Create_tableContext)_localctx).attribute_list = attribute_list();
				setState(96);
				match(T__2);

				                    ((Create_tableContext)_localctx).createSqlExec =  new CreateSQLExecutor((((Create_tableContext)_localctx).ID!=null?((Create_tableContext)_localctx).ID.getText():null), ((Create_tableContext)_localctx).attribute_list.attributeList, null);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(CREATE);
				setState(100);
				match(TABLE);
				setState(101);
				((Create_tableContext)_localctx).ID = match(ID);
				setState(102);
				match(T__1);
				setState(103);
				((Create_tableContext)_localctx).attribute_list = attribute_list();
				setState(104);
				((Create_tableContext)_localctx).primary_key = primary_key();
				setState(105);
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
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(111);
				((Attribute_listContext)_localctx).type = type();
				setState(112);
				match(T__3);
				setState(113);
				((Attribute_listContext)_localctx).attribute_list = attribute_list();

				                     ((Attribute_listContext)_localctx).attributeList =  ((Attribute_listContext)_localctx).attribute_list.attributeList;
				                     _localctx.attributeList.add(0, new AttributeMeta((((Attribute_listContext)_localctx).ID!=null?((Attribute_listContext)_localctx).ID.getText():null), ((Attribute_listContext)_localctx).type.dataType, false));
				                 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(117);
				((Attribute_listContext)_localctx).type = type();
				setState(118);
				match(NOT);
				setState(119);
				match(NULL);
				setState(120);
				match(T__3);
				setState(121);
				((Attribute_listContext)_localctx).attribute_list = attribute_list();

				                     ((Attribute_listContext)_localctx).attributeList =  ((Attribute_listContext)_localctx).attribute_list.attributeList;
				                     _localctx.attributeList.add(0, new AttributeMeta((((Attribute_listContext)_localctx).ID!=null?((Attribute_listContext)_localctx).ID.getText():null), ((Attribute_listContext)_localctx).type.dataType, true));
				                 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(125);
				((Attribute_listContext)_localctx).type = type();

				                     ((Attribute_listContext)_localctx).attributeList =  new ArrayList<AttributeMeta>();
				                     _localctx.attributeList.add(0, new AttributeMeta((((Attribute_listContext)_localctx).ID!=null?((Attribute_listContext)_localctx).ID.getText():null), ((Attribute_listContext)_localctx).type.dataType, false));
				                 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(128);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(129);
				((Attribute_listContext)_localctx).type = type();
				setState(130);
				match(NOT);
				setState(131);
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
			setState(136);
			match(T__3);
			setState(137);
			match(PRIMARY);
			setState(138);
			match(KEY);
			setState(139);
			match(T__1);
			setState(140);
			((Primary_keyContext)_localctx).ID = match(ID);
			setState(141);
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
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(INT);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.INT);
				}
				break;
			case LONG:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(LONG);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.LONG);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				match(FLOAT);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.FLOAT);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(150);
				match(DOUBLE);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.DOUBLE);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
				match(STRING);
				setState(153);
				match(T__1);
				setState(154);
				((TypeContext)_localctx).NUMINT = match(NUMINT);
				setState(155);
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
			setState(159);
			match(DROP);
			setState(160);
			match(TABLE);
			setState(161);
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
			setState(164);
			match(SHOW);
			setState(165);
			match(TABLE);
			setState(166);
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
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				match(INSERT);
				setState(170);
				match(INTO);
				setState(171);
				((Insert_intoContext)_localctx).ID = match(ID);
				setState(172);
				match(VALUES);
				setState(173);
				match(T__1);
				setState(174);
				((Insert_intoContext)_localctx).value_list = value_list();
				setState(175);
				match(T__2);

				                    ((Insert_intoContext)_localctx).insertSqlExec =  new InsertSQLExecutor((((Insert_intoContext)_localctx).ID!=null?((Insert_intoContext)_localctx).ID.getText():null), null, ((Insert_intoContext)_localctx).value_list.valueList);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(INSERT);
				setState(179);
				match(INTO);
				setState(180);
				((Insert_intoContext)_localctx).ID = match(ID);
				setState(181);
				match(T__1);
				setState(182);
				((Insert_intoContext)_localctx).attribute_list_insert = attribute_list_insert();
				setState(183);
				match(T__2);
				setState(184);
				match(VALUES);
				setState(185);
				match(T__1);
				setState(186);
				((Insert_intoContext)_localctx).value_list = value_list();
				setState(187);
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
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				((Attribute_list_insertContext)_localctx).ID = match(ID);
				setState(193);
				match(T__3);
				setState(194);
				((Attribute_list_insertContext)_localctx).attribute_list_insert = attribute_list_insert();

				                    ((Attribute_list_insertContext)_localctx).attributeList =  ((Attribute_list_insertContext)_localctx).attribute_list_insert.attributeList;
				                    _localctx.attributeList.add(0, (((Attribute_list_insertContext)_localctx).ID!=null?((Attribute_list_insertContext)_localctx).ID.getText():null));
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
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
		public TerminalNode TEXT() { return getToken(SimpleSQLParser.TEXT, 0); }
		public TerminalNode NUMFLOAT() { return getToken(SimpleSQLParser.NUMFLOAT, 0); }
		public TerminalNode NUMINT() { return getToken(SimpleSQLParser.NUMINT, 0); }
		public TerminalNode NUMFLOATNEG() { return getToken(SimpleSQLParser.NUMFLOATNEG, 0); }
		public TerminalNode NUMINTNEG() { return getToken(SimpleSQLParser.NUMINTNEG, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			((Value_singleContext)_localctx).v = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << NUMFLOAT) | (1L << NUMFLOATNEG) | (1L << NUMINT) | (1L << NUMINTNEG))) != 0)) ) {
				((Value_singleContext)_localctx).v = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}

			                    ((Value_singleContext)_localctx).value =  (((Value_singleContext)_localctx).v!=null?((Value_singleContext)_localctx).v.getText():null);
			                
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
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				((Value_listContext)_localctx).value_single = value_single();
				setState(205);
				match(T__3);
				setState(206);
				((Value_listContext)_localctx).value_list = value_list();

				                    ((Value_listContext)_localctx).valueList =  ((Value_listContext)_localctx).value_list.valueList;
				                    _localctx.valueList.add(0, ((Value_listContext)_localctx).value_single.value);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
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
			setState(214);
			match(DELETE);
			setState(215);
			match(FROM);
			setState(216);
			((Delete_fromContext)_localctx).ID = match(ID);
			setState(217);
			match(WHERE);
			setState(218);
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

	public static class Where_listContext extends ParserRuleContext {
		public WhereCondition whereCondition;
		public Token ID;
		public Token op;
		public Value_singleContext value_single;
		public Where_listContext where_list;
		public TerminalNode ID() { return getToken(SimpleSQLParser.ID, 0); }
		public Value_singleContext value_single() {
			return getRuleContext(Value_singleContext.class,0);
		}
		public TerminalNode AND() { return getToken(SimpleSQLParser.AND, 0); }
		public Where_listContext where_list() {
			return getRuleContext(Where_listContext.class,0);
		}
		public TerminalNode OP() { return getToken(SimpleSQLParser.OP, 0); }
		public TerminalNode OPE() { return getToken(SimpleSQLParser.OPE, 0); }
		public TerminalNode OR() { return getToken(SimpleSQLParser.OR, 0); }
		public Where_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_list; }
	}

	public final Where_listContext where_list() throws RecognitionException {
		Where_listContext _localctx = new Where_listContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_where_list);
		int _la;
		try {
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				((Where_listContext)_localctx).ID = match(ID);
				setState(222);
				((Where_listContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==OP || _la==OPE) ) {
					((Where_listContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(223);
				((Where_listContext)_localctx).value_single = value_single();
				setState(224);
				match(AND);
				setState(225);
				((Where_listContext)_localctx).where_list = where_list();

				                    ((Where_listContext)_localctx).whereCondition =  ((Where_listContext)_localctx).where_list.whereCondition;
				                    WhereCondition.SQLValue _leftValue = _localctx.whereCondition.new SQLValue(null, (((Where_listContext)_localctx).ID!=null?((Where_listContext)_localctx).ID.getText():null));
				                    WhereCondition.SQLValue _rightValue = _localctx.whereCondition.new SQLValue(((Where_listContext)_localctx).value_single.value);
				                    WhereCondition.Operator _op = WhereCondition.Operator.EQ;
				                    switch((((Where_listContext)_localctx).op!=null?((Where_listContext)_localctx).op.getText():null)) {
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
				                    WhereCondition.OneCondition _oneCondition = _localctx.whereCondition.new OneCondition(_leftValue, _rightValue, _op);
				                    WhereCondition.LogicConnection _logic = WhereCondition.LogicConnection.AND;
				                    _localctx.whereCondition.AddCondition(_oneCondition, _logic);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				((Where_listContext)_localctx).ID = match(ID);
				setState(229);
				((Where_listContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==OP || _la==OPE) ) {
					((Where_listContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(230);
				((Where_listContext)_localctx).value_single = value_single();
				setState(231);
				match(OR);
				setState(232);
				((Where_listContext)_localctx).where_list = where_list();

				                    ((Where_listContext)_localctx).whereCondition =  ((Where_listContext)_localctx).where_list.whereCondition;
				                    WhereCondition.SQLValue _leftValue = _localctx.whereCondition.new SQLValue(null, (((Where_listContext)_localctx).ID!=null?((Where_listContext)_localctx).ID.getText():null));
				                    WhereCondition.SQLValue _rightValue = _localctx.whereCondition.new SQLValue(((Where_listContext)_localctx).value_single.value);
				                    WhereCondition.Operator _op = WhereCondition.Operator.EQ;
				                    switch((((Where_listContext)_localctx).op!=null?((Where_listContext)_localctx).op.getText():null)) {
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
				                    WhereCondition.OneCondition _oneCondition = _localctx.whereCondition.new OneCondition(_leftValue, _rightValue, _op);
				                    WhereCondition.LogicConnection _logic = WhereCondition.LogicConnection.OR;
				                    _localctx.whereCondition.AddCondition(_oneCondition, _logic);
				                
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(235);
				((Where_listContext)_localctx).ID = match(ID);
				setState(236);
				((Where_listContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==OP || _la==OPE) ) {
					((Where_listContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(237);
				((Where_listContext)_localctx).value_single = value_single();

				                    ((Where_listContext)_localctx).whereCondition =  new WhereCondition();
				                    WhereCondition.SQLValue _leftValue = _localctx.whereCondition.new SQLValue(null, (((Where_listContext)_localctx).ID!=null?((Where_listContext)_localctx).ID.getText():null));
				                    WhereCondition.SQLValue _rightValue = _localctx.whereCondition.new SQLValue(((Where_listContext)_localctx).value_single.value);
				                    WhereCondition.Operator _op = WhereCondition.Operator.EQ;
				                    switch((((Where_listContext)_localctx).op!=null?((Where_listContext)_localctx).op.getText():null)) {
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
				                    WhereCondition.OneCondition _oneCondition = _localctx.whereCondition.new OneCondition(_leftValue, _rightValue, _op);
				                    _localctx.whereCondition.conditions.add(_oneCondition);
				                
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
		enterRule(_localctx, 28, RULE_update_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(UPDATE);
			setState(243);
			((Update_tableContext)_localctx).t = match(ID);
			setState(244);
			match(SET);
			setState(245);
			((Update_tableContext)_localctx).a = match(ID);
			setState(246);
			match(OPE);
			setState(247);
			((Update_tableContext)_localctx).value_single = value_single();
			setState(248);
			match(WHERE);
			setState(249);
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
		enterRule(_localctx, 30, RULE_select_table);
		try {
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				match(SELECT);
				setState(253);
				((Select_tableContext)_localctx).attribute_list_select = attribute_list_select();
				setState(254);
				match(FROM);
				setState(255);
				((Select_tableContext)_localctx).table_list_select = table_list_select();

				                    ((Select_tableContext)_localctx).selectSqlExec =  new SelectSQLExecutor();
				                    _localctx.selectSqlExec.setAttributeList(((Select_tableContext)_localctx).attribute_list_select.attributeList);
				                    _localctx.selectSqlExec.setTableJoin(((Select_tableContext)_localctx).table_list_select.tableJoin);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				match(SELECT);
				setState(259);
				((Select_tableContext)_localctx).attribute_list_select = attribute_list_select();
				setState(260);
				match(FROM);
				setState(261);
				((Select_tableContext)_localctx).table_list_select = table_list_select();
				setState(262);
				match(WHERE);
				setState(263);
				((Select_tableContext)_localctx).where_list = where_list();

				                    ((Select_tableContext)_localctx).selectSqlExec =  new SelectSQLExecutor();
				                    _localctx.selectSqlExec.setAttributeList(((Select_tableContext)_localctx).attribute_list_select.attributeList);
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
		enterRule(_localctx, 32, RULE_attribute_list_select);
		try {
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				((Attribute_list_selectContext)_localctx).ID = match(ID);
				setState(269);
				match(T__3);
				setState(270);
				((Attribute_list_selectContext)_localctx).attribute_list_select = attribute_list_select();

				                            Pair<String, String> newAttr = new Pair<>(null, (((Attribute_list_selectContext)_localctx).ID!=null?((Attribute_list_selectContext)_localctx).ID.getText():null));
				                            ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList.add(0, newAttr);
				                            ((Attribute_list_selectContext)_localctx).attributeList =  ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList;
				                        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				((Attribute_list_selectContext)_localctx).t = match(ID);
				setState(274);
				match(T__4);
				setState(275);
				((Attribute_list_selectContext)_localctx).a = match(ID);
				setState(276);
				match(T__3);
				setState(277);
				((Attribute_list_selectContext)_localctx).attribute_list_select = attribute_list_select();

				                            Pair<String, String> newAttr = new Pair<>((((Attribute_list_selectContext)_localctx).t!=null?((Attribute_list_selectContext)_localctx).t.getText():null), (((Attribute_list_selectContext)_localctx).a!=null?((Attribute_list_selectContext)_localctx).a.getText():null));
				                            ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList.add(0, newAttr);
				                            ((Attribute_list_selectContext)_localctx).attributeList =  ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList;
				                        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(280);
				((Attribute_list_selectContext)_localctx).ID = match(ID);

				                            Pair<String, String> newAttr = new Pair<>(null, (((Attribute_list_selectContext)_localctx).ID!=null?((Attribute_list_selectContext)_localctx).ID.getText():null));
				                            ((Attribute_list_selectContext)_localctx).attributeList =  new ArrayList<Pair<String, String> >();
				                            _localctx.attributeList.add(newAttr);
				                        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(282);
				((Attribute_list_selectContext)_localctx).t = match(ID);
				setState(283);
				match(T__4);
				setState(284);
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
		enterRule(_localctx, 34, RULE_table_list_select);
		try {
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				((Table_list_selectContext)_localctx).f = match(ID);
				setState(289);
				match(JOIN);
				setState(290);
				((Table_list_selectContext)_localctx).s = match(ID);
				setState(291);
				match(ON);
				setState(292);
				((Table_list_selectContext)_localctx).ft = match(ID);
				setState(293);
				match(T__4);
				setState(294);
				((Table_list_selectContext)_localctx).fa = match(ID);
				setState(295);
				match(OPE);
				setState(296);
				((Table_list_selectContext)_localctx).st = match(ID);
				setState(297);
				match(T__4);
				setState(298);
				((Table_list_selectContext)_localctx).sa = match(ID);

				                            ((Table_list_selectContext)_localctx).tableJoin =  new TableJoin();
				                            _localctx.tableJoin.isJoin = true;
				                            _localctx.tableJoin.firstTableName = (((Table_list_selectContext)_localctx).f!=null?((Table_list_selectContext)_localctx).f.getText():null);
				                            _localctx.tableJoin.secondTableName = (((Table_list_selectContext)_localctx).s!=null?((Table_list_selectContext)_localctx).s.getText():null);
				                            _localctx.tableJoin.onCondition = new WhereCondition();
				                            WhereCondition.SQLValue _leftValue = _localctx.tableJoin.onCondition.new SQLValue((((Table_list_selectContext)_localctx).ft!=null?((Table_list_selectContext)_localctx).ft.getText():null), (((Table_list_selectContext)_localctx).fa!=null?((Table_list_selectContext)_localctx).fa.getText():null));
				                            WhereCondition.SQLValue _rightValue = _localctx.tableJoin.onCondition.new SQLValue((((Table_list_selectContext)_localctx).st!=null?((Table_list_selectContext)_localctx).st.getText():null), (((Table_list_selectContext)_localctx).sa!=null?((Table_list_selectContext)_localctx).sa.getText():null));
				                            WhereCondition.Operator _op = WhereCondition.Operator.EQ;
				                            WhereCondition.OneCondition _oneCondition = _localctx.tableJoin.onCondition.new OneCondition(_leftValue, _rightValue, _op);
				                            _localctx.tableJoin.onCondition.conditions.add(_oneCondition);
				                        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u0133\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\7\2-\n\2\f\2\16\2\60\13\2\3\3\3\3\5"+
		"\3\64\n\3\3\3\3\3\3\3\3\3\5\3:\n\3\3\3\3\3\3\3\3\3\5\3@\n\3\3\3\3\3\3"+
		"\3\3\3\5\3F\n\3\3\3\3\3\3\3\3\3\5\3L\n\3\3\3\3\3\3\3\3\3\5\3R\n\3\3\3"+
		"\3\3\3\3\3\3\5\3X\n\3\3\3\3\3\5\3\\\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4o\n\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\5\5\u0089\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a0\n\7\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c1\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u00ca\n\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u00d7\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00f3\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u010d\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0121\n\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0131\n\23\3\23"+
		"\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\4\3\2\"&\3\2\'(\2"+
		"\u0140\2&\3\2\2\2\4[\3\2\2\2\6n\3\2\2\2\b\u0088\3\2\2\2\n\u008a\3\2\2"+
		"\2\f\u009f\3\2\2\2\16\u00a1\3\2\2\2\20\u00a6\3\2\2\2\22\u00c0\3\2\2\2"+
		"\24\u00c9\3\2\2\2\26\u00cb\3\2\2\2\30\u00d6\3\2\2\2\32\u00d8\3\2\2\2\34"+
		"\u00f2\3\2\2\2\36\u00f4\3\2\2\2 \u010c\3\2\2\2\"\u0120\3\2\2\2$\u0130"+
		"\3\2\2\2&\'\b\2\1\2\'(\5\4\3\2(.\b\2\1\2)*\5\4\3\2*+\b\2\1\2+-\3\2\2\2"+
		",)\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\3\3\2\2\2\60.\3\2\2\2\61\63"+
		"\5\6\4\2\62\64\7\3\2\2\63\62\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66"+
		"\b\3\1\2\66\\\3\2\2\2\679\5\16\b\28:\7\3\2\298\3\2\2\29:\3\2\2\2:;\3\2"+
		"\2\2;<\b\3\1\2<\\\3\2\2\2=?\5\20\t\2>@\7\3\2\2?>\3\2\2\2?@\3\2\2\2@A\3"+
		"\2\2\2AB\b\3\1\2B\\\3\2\2\2CE\5\22\n\2DF\7\3\2\2ED\3\2\2\2EF\3\2\2\2F"+
		"G\3\2\2\2GH\b\3\1\2H\\\3\2\2\2IK\5\32\16\2JL\7\3\2\2KJ\3\2\2\2KL\3\2\2"+
		"\2LM\3\2\2\2MN\b\3\1\2N\\\3\2\2\2OQ\5\36\20\2PR\7\3\2\2QP\3\2\2\2QR\3"+
		"\2\2\2RS\3\2\2\2ST\b\3\1\2T\\\3\2\2\2UW\5 \21\2VX\7\3\2\2WV\3\2\2\2WX"+
		"\3\2\2\2XY\3\2\2\2YZ\b\3\1\2Z\\\3\2\2\2[\61\3\2\2\2[\67\3\2\2\2[=\3\2"+
		"\2\2[C\3\2\2\2[I\3\2\2\2[O\3\2\2\2[U\3\2\2\2\\\5\3\2\2\2]^\7\b\2\2^_\7"+
		"\t\2\2_`\7)\2\2`a\7\4\2\2ab\5\b\5\2bc\7\5\2\2cd\b\4\1\2do\3\2\2\2ef\7"+
		"\b\2\2fg\7\t\2\2gh\7)\2\2hi\7\4\2\2ij\5\b\5\2jk\5\n\6\2kl\7\5\2\2lm\b"+
		"\4\1\2mo\3\2\2\2n]\3\2\2\2ne\3\2\2\2o\7\3\2\2\2pq\7)\2\2qr\5\f\7\2rs\7"+
		"\6\2\2st\5\b\5\2tu\b\5\1\2u\u0089\3\2\2\2vw\7)\2\2wx\5\f\7\2xy\7\17\2"+
		"\2yz\7\20\2\2z{\7\6\2\2{|\5\b\5\2|}\b\5\1\2}\u0089\3\2\2\2~\177\7)\2\2"+
		"\177\u0080\5\f\7\2\u0080\u0081\b\5\1\2\u0081\u0089\3\2\2\2\u0082\u0083"+
		"\7)\2\2\u0083\u0084\5\f\7\2\u0084\u0085\7\17\2\2\u0085\u0086\7\20\2\2"+
		"\u0086\u0087\b\5\1\2\u0087\u0089\3\2\2\2\u0088p\3\2\2\2\u0088v\3\2\2\2"+
		"\u0088~\3\2\2\2\u0088\u0082\3\2\2\2\u0089\t\3\2\2\2\u008a\u008b\7\6\2"+
		"\2\u008b\u008c\7\21\2\2\u008c\u008d\7\22\2\2\u008d\u008e\7\4\2\2\u008e"+
		"\u008f\7)\2\2\u008f\u0090\7\5\2\2\u0090\u0091\b\6\1\2\u0091\13\3\2\2\2"+
		"\u0092\u0093\7\n\2\2\u0093\u00a0\b\7\1\2\u0094\u0095\7\13\2\2\u0095\u00a0"+
		"\b\7\1\2\u0096\u0097\7\f\2\2\u0097\u00a0\b\7\1\2\u0098\u0099\7\r\2\2\u0099"+
		"\u00a0\b\7\1\2\u009a\u009b\7\16\2\2\u009b\u009c\7\4\2\2\u009c\u009d\7"+
		"%\2\2\u009d\u009e\7\5\2\2\u009e\u00a0\b\7\1\2\u009f\u0092\3\2\2\2\u009f"+
		"\u0094\3\2\2\2\u009f\u0096\3\2\2\2\u009f\u0098\3\2\2\2\u009f\u009a\3\2"+
		"\2\2\u00a0\r\3\2\2\2\u00a1\u00a2\7\23\2\2\u00a2\u00a3\7\t\2\2\u00a3\u00a4"+
		"\7)\2\2\u00a4\u00a5\b\b\1\2\u00a5\17\3\2\2\2\u00a6\u00a7\7\24\2\2\u00a7"+
		"\u00a8\7\t\2\2\u00a8\u00a9\7)\2\2\u00a9\u00aa\b\t\1\2\u00aa\21\3\2\2\2"+
		"\u00ab\u00ac\7\25\2\2\u00ac\u00ad\7\26\2\2\u00ad\u00ae\7)\2\2\u00ae\u00af"+
		"\7\27\2\2\u00af\u00b0\7\4\2\2\u00b0\u00b1\5\30\r\2\u00b1\u00b2\7\5\2\2"+
		"\u00b2\u00b3\b\n\1\2\u00b3\u00c1\3\2\2\2\u00b4\u00b5\7\25\2\2\u00b5\u00b6"+
		"\7\26\2\2\u00b6\u00b7\7)\2\2\u00b7\u00b8\7\4\2\2\u00b8\u00b9\5\24\13\2"+
		"\u00b9\u00ba\7\5\2\2\u00ba\u00bb\7\27\2\2\u00bb\u00bc\7\4\2\2\u00bc\u00bd"+
		"\5\30\r\2\u00bd\u00be\7\5\2\2\u00be\u00bf\b\n\1\2\u00bf\u00c1\3\2\2\2"+
		"\u00c0\u00ab\3\2\2\2\u00c0\u00b4\3\2\2\2\u00c1\23\3\2\2\2\u00c2\u00c3"+
		"\7)\2\2\u00c3\u00c4\7\6\2\2\u00c4\u00c5\5\24\13\2\u00c5\u00c6\b\13\1\2"+
		"\u00c6\u00ca\3\2\2\2\u00c7\u00c8\7)\2\2\u00c8\u00ca\b\13\1\2\u00c9\u00c2"+
		"\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\25\3\2\2\2\u00cb\u00cc\t\2\2\2\u00cc"+
		"\u00cd\b\f\1\2\u00cd\27\3\2\2\2\u00ce\u00cf\5\26\f\2\u00cf\u00d0\7\6\2"+
		"\2\u00d0\u00d1\5\30\r\2\u00d1\u00d2\b\r\1\2\u00d2\u00d7\3\2\2\2\u00d3"+
		"\u00d4\5\26\f\2\u00d4\u00d5\b\r\1\2\u00d5\u00d7\3\2\2\2\u00d6\u00ce\3"+
		"\2\2\2\u00d6\u00d3\3\2\2\2\u00d7\31\3\2\2\2\u00d8\u00d9\7\30\2\2\u00d9"+
		"\u00da\7\31\2\2\u00da\u00db\7)\2\2\u00db\u00dc\7\32\2\2\u00dc\u00dd\5"+
		"\34\17\2\u00dd\u00de\b\16\1\2\u00de\33\3\2\2\2\u00df\u00e0\7)\2\2\u00e0"+
		"\u00e1\t\3\2\2\u00e1\u00e2\5\26\f\2\u00e2\u00e3\7 \2\2\u00e3\u00e4\5\34"+
		"\17\2\u00e4\u00e5\b\17\1\2\u00e5\u00f3\3\2\2\2\u00e6\u00e7\7)\2\2\u00e7"+
		"\u00e8\t\3\2\2\u00e8\u00e9\5\26\f\2\u00e9\u00ea\7!\2\2\u00ea\u00eb\5\34"+
		"\17\2\u00eb\u00ec\b\17\1\2\u00ec\u00f3\3\2\2\2\u00ed\u00ee\7)\2\2\u00ee"+
		"\u00ef\t\3\2\2\u00ef\u00f0\5\26\f\2\u00f0\u00f1\b\17\1\2\u00f1\u00f3\3"+
		"\2\2\2\u00f2\u00df\3\2\2\2\u00f2\u00e6\3\2\2\2\u00f2\u00ed\3\2\2\2\u00f3"+
		"\35\3\2\2\2\u00f4\u00f5\7\33\2\2\u00f5\u00f6\7)\2\2\u00f6\u00f7\7\34\2"+
		"\2\u00f7\u00f8\7)\2\2\u00f8\u00f9\7(\2\2\u00f9\u00fa\5\26\f\2\u00fa\u00fb"+
		"\7\32\2\2\u00fb\u00fc\5\34\17\2\u00fc\u00fd\b\20\1\2\u00fd\37\3\2\2\2"+
		"\u00fe\u00ff\7\35\2\2\u00ff\u0100\5\"\22\2\u0100\u0101\7\31\2\2\u0101"+
		"\u0102\5$\23\2\u0102\u0103\b\21\1\2\u0103\u010d\3\2\2\2\u0104\u0105\7"+
		"\35\2\2\u0105\u0106\5\"\22\2\u0106\u0107\7\31\2\2\u0107\u0108\5$\23\2"+
		"\u0108\u0109\7\32\2\2\u0109\u010a\5\34\17\2\u010a\u010b\b\21\1\2\u010b"+
		"\u010d\3\2\2\2\u010c\u00fe\3\2\2\2\u010c\u0104\3\2\2\2\u010d!\3\2\2\2"+
		"\u010e\u010f\7)\2\2\u010f\u0110\7\6\2\2\u0110\u0111\5\"\22\2\u0111\u0112"+
		"\b\22\1\2\u0112\u0121\3\2\2\2\u0113\u0114\7)\2\2\u0114\u0115\7\7\2\2\u0115"+
		"\u0116\7)\2\2\u0116\u0117\7\6\2\2\u0117\u0118\5\"\22\2\u0118\u0119\b\22"+
		"\1\2\u0119\u0121\3\2\2\2\u011a\u011b\7)\2\2\u011b\u0121\b\22\1\2\u011c"+
		"\u011d\7)\2\2\u011d\u011e\7\7\2\2\u011e\u011f\7)\2\2\u011f\u0121\b\22"+
		"\1\2\u0120\u010e\3\2\2\2\u0120\u0113\3\2\2\2\u0120\u011a\3\2\2\2\u0120"+
		"\u011c\3\2\2\2\u0121#\3\2\2\2\u0122\u0123\7)\2\2\u0123\u0124\7\36\2\2"+
		"\u0124\u0125\7)\2\2\u0125\u0126\7\37\2\2\u0126\u0127\7)\2\2\u0127\u0128"+
		"\7\7\2\2\u0128\u0129\7)\2\2\u0129\u012a\7(\2\2\u012a\u012b\7)\2\2\u012b"+
		"\u012c\7\7\2\2\u012c\u012d\7)\2\2\u012d\u0131\b\23\1\2\u012e\u012f\7)"+
		"\2\2\u012f\u0131\b\23\1\2\u0130\u0122\3\2\2\2\u0130\u012e\3\2\2\2\u0131"+
		"%\3\2\2\2\25.\639?EKQW[n\u0088\u009f\u00c0\u00c9\u00d6\u00f2\u010c\u0120"+
		"\u0130";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}