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
		DATABASE=33, USE=34, DATABASES=35, OUTER=36, LEFT=37, RIGHT=38, AS=39, 
		EXIST=40, SHUTDOWN=41, TEXT=42, NUMFLOAT=43, NUMFLOATNEG=44, NUMINT=45, 
		NUMINTNEG=46, OP=47, OPE=48, ID=49, WS=50;
	public static final int
		RULE_commands = 0, RULE_sql = 1, RULE_create_db = 2, RULE_drop_db = 3, 
		RULE_use_db = 4, RULE_show_databases = 5, RULE_show_database = 6, RULE_create_table = 7, 
		RULE_attribute_list = 8, RULE_primary_key = 9, RULE_type = 10, RULE_drop_table = 11, 
		RULE_show_table = 12, RULE_insert_into = 13, RULE_attribute_list_insert = 14, 
		RULE_value_single = 15, RULE_value_list = 16, RULE_delete_from = 17, RULE_sql_value = 18, 
		RULE_one_condition = 19, RULE_where_list = 20, RULE_update_table = 21, 
		RULE_select_table = 22, RULE_attribute_list_select = 23, RULE_table_list_select = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"commands", "sql", "create_db", "drop_db", "use_db", "show_databases", 
			"show_database", "create_table", "attribute_list", "primary_key", "type", 
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
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "CREATE", "TABLE", "INT", "LONG", 
			"FLOAT", "DOUBLE", "STRING", "NOT", "NULL", "PRIMARY", "KEY", "DROP", 
			"SHOW", "INSERT", "INTO", "VALUES", "DELETE", "FROM", "WHERE", "UPDATE", 
			"SET", "SELECT", "JOIN", "ON", "AND", "OR", "DATABASE", "USE", "DATABASES", 
			"OUTER", "LEFT", "RIGHT", "AS", "EXIST", "SHUTDOWN", "TEXT", "NUMFLOAT", 
			"NUMFLOATNEG", "NUMINT", "NUMINTNEG", "OP", "OPE", "ID", "WS"
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
			setState(51);
			((CommandsContext)_localctx).s = sql();
			_localctx.sqlExecutorList.add(((CommandsContext)_localctx).s.sqlExecutor);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CREATE) | (1L << DROP) | (1L << SHOW) | (1L << INSERT) | (1L << DELETE) | (1L << UPDATE) | (1L << SELECT) | (1L << USE) | (1L << SHUTDOWN))) != 0)) {
				{
				{
				setState(53);
				((CommandsContext)_localctx).ns = sql();
				_localctx.sqlExecutorList.add(((CommandsContext)_localctx).ns.sqlExecutor);
				}
				}
				setState(60);
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
		public Create_dbContext create_db;
		public Drop_dbContext drop_db;
		public Use_dbContext use_db;
		public Show_databasesContext show_databases;
		public Show_databaseContext show_database;
		public Create_tableContext create_table() {
			return getRuleContext(Create_tableContext.class,0);
		}
		public TerminalNode SHUTDOWN() { return getToken(SimpleSQLParser.SHUTDOWN, 0); }
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
		public Create_dbContext create_db() {
			return getRuleContext(Create_dbContext.class,0);
		}
		public Drop_dbContext drop_db() {
			return getRuleContext(Drop_dbContext.class,0);
		}
		public Use_dbContext use_db() {
			return getRuleContext(Use_dbContext.class,0);
		}
		public Show_databasesContext show_databases() {
			return getRuleContext(Show_databasesContext.class,0);
		}
		public Show_databaseContext show_database() {
			return getRuleContext(Show_databaseContext.class,0);
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
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				((SqlContext)_localctx).create_table = create_table();
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(62);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).create_table.createSqlExec;
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(SHUTDOWN);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(68);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  new ShutdownExecutor();
				                
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				((SqlContext)_localctx).drop_table = drop_table();
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(73);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).drop_table.dropSqlExec;
				                
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				((SqlContext)_localctx).show_table = show_table();
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(79);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).show_table.showSqlExec;
				                
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				((SqlContext)_localctx).insert_into = insert_into();
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(85);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).insert_into.insertSqlExec;
				                
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(90);
				((SqlContext)_localctx).delete_from = delete_from();
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(91);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).delete_from.deleteSqlExec;
				                
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(96);
				((SqlContext)_localctx).update_table = update_table();
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(97);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).update_table.updateSqlExec;
				                
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(102);
				((SqlContext)_localctx).select_table = select_table();
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(103);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).select_table.selectSqlExec;
				                
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(108);
				((SqlContext)_localctx).create_db = create_db();
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(109);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).create_db.createDBExec;
				                
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(114);
				((SqlContext)_localctx).drop_db = drop_db();
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(115);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).drop_db.dropDBExec;
				                
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(120);
				((SqlContext)_localctx).use_db = use_db();
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(121);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).use_db.useDBExec;
				                
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(126);
				((SqlContext)_localctx).show_databases = show_databases();
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(127);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).show_databases.showAllExec;
				                
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(132);
				((SqlContext)_localctx).show_database = show_database();
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(133);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).show_database.showDBExec;
				                
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

	public static class Create_dbContext extends ParserRuleContext {
		public CreateDBExecutor createDBExec;
		public Token ID;
		public TerminalNode CREATE() { return getToken(SimpleSQLParser.CREATE, 0); }
		public TerminalNode DATABASE() { return getToken(SimpleSQLParser.DATABASE, 0); }
		public TerminalNode ID() { return getToken(SimpleSQLParser.ID, 0); }
		public Create_dbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_db; }
	}

	public final Create_dbContext create_db() throws RecognitionException {
		Create_dbContext _localctx = new Create_dbContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_create_db);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(CREATE);
			setState(141);
			match(DATABASE);
			setState(142);
			((Create_dbContext)_localctx).ID = match(ID);

			                    ((Create_dbContext)_localctx).createDBExec =  new CreateDBExecutor((((Create_dbContext)_localctx).ID!=null?((Create_dbContext)_localctx).ID.getText():null));
			                
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

	public static class Drop_dbContext extends ParserRuleContext {
		public DropDBExecutor dropDBExec;
		public Token ID;
		public TerminalNode DROP() { return getToken(SimpleSQLParser.DROP, 0); }
		public TerminalNode DATABASE() { return getToken(SimpleSQLParser.DATABASE, 0); }
		public TerminalNode ID() { return getToken(SimpleSQLParser.ID, 0); }
		public Drop_dbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_db; }
	}

	public final Drop_dbContext drop_db() throws RecognitionException {
		Drop_dbContext _localctx = new Drop_dbContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_drop_db);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(DROP);
			setState(146);
			match(DATABASE);
			setState(147);
			((Drop_dbContext)_localctx).ID = match(ID);

			                    ((Drop_dbContext)_localctx).dropDBExec =  new DropDBExecutor((((Drop_dbContext)_localctx).ID!=null?((Drop_dbContext)_localctx).ID.getText():null));
			                
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

	public static class Use_dbContext extends ParserRuleContext {
		public UseDBExecutor useDBExec;
		public Token ID;
		public TerminalNode USE() { return getToken(SimpleSQLParser.USE, 0); }
		public TerminalNode DATABASE() { return getToken(SimpleSQLParser.DATABASE, 0); }
		public TerminalNode ID() { return getToken(SimpleSQLParser.ID, 0); }
		public Use_dbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_use_db; }
	}

	public final Use_dbContext use_db() throws RecognitionException {
		Use_dbContext _localctx = new Use_dbContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_use_db);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(USE);
			setState(151);
			match(DATABASE);
			setState(152);
			((Use_dbContext)_localctx).ID = match(ID);

			                    ((Use_dbContext)_localctx).useDBExec =  new UseDBExecutor((((Use_dbContext)_localctx).ID!=null?((Use_dbContext)_localctx).ID.getText():null));
			                
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

	public static class Show_databasesContext extends ParserRuleContext {
		public ShowAllDBExecutor showAllExec;
		public TerminalNode SHOW() { return getToken(SimpleSQLParser.SHOW, 0); }
		public TerminalNode DATABASES() { return getToken(SimpleSQLParser.DATABASES, 0); }
		public Show_databasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_databases; }
	}

	public final Show_databasesContext show_databases() throws RecognitionException {
		Show_databasesContext _localctx = new Show_databasesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_show_databases);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(SHOW);
			setState(156);
			match(DATABASES);

			                    ((Show_databasesContext)_localctx).showAllExec =  new ShowAllDBExecutor();
			                
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

	public static class Show_databaseContext extends ParserRuleContext {
		public ShowDBExecutor showDBExec;
		public Token ID;
		public TerminalNode SHOW() { return getToken(SimpleSQLParser.SHOW, 0); }
		public TerminalNode DATABASE() { return getToken(SimpleSQLParser.DATABASE, 0); }
		public TerminalNode ID() { return getToken(SimpleSQLParser.ID, 0); }
		public Show_databaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_database; }
	}

	public final Show_databaseContext show_database() throws RecognitionException {
		Show_databaseContext _localctx = new Show_databaseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_show_database);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(SHOW);
			setState(160);
			match(DATABASE);
			setState(161);
			((Show_databaseContext)_localctx).ID = match(ID);

			                    ((Show_databaseContext)_localctx).showDBExec =  new ShowDBExecutor((((Show_databaseContext)_localctx).ID!=null?((Show_databaseContext)_localctx).ID.getText():null));
			                
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
		enterRule(_localctx, 14, RULE_create_table);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(CREATE);
				setState(165);
				match(TABLE);
				setState(166);
				((Create_tableContext)_localctx).ID = match(ID);
				setState(167);
				match(T__1);
				setState(168);
				((Create_tableContext)_localctx).attribute_list = attribute_list();
				setState(169);
				match(T__2);

				                    ((Create_tableContext)_localctx).createSqlExec =  new CreateSQLExecutor((((Create_tableContext)_localctx).ID!=null?((Create_tableContext)_localctx).ID.getText():null), ((Create_tableContext)_localctx).attribute_list.attributeList, null);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(CREATE);
				setState(173);
				match(TABLE);
				setState(174);
				((Create_tableContext)_localctx).ID = match(ID);
				setState(175);
				match(T__1);
				setState(176);
				((Create_tableContext)_localctx).attribute_list = attribute_list();
				setState(177);
				((Create_tableContext)_localctx).primary_key = primary_key();
				setState(178);
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
		enterRule(_localctx, 16, RULE_attribute_list);
		try {
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(184);
				((Attribute_listContext)_localctx).type = type();
				setState(185);
				match(T__3);
				setState(186);
				((Attribute_listContext)_localctx).attribute_list = attribute_list();

				                     ((Attribute_listContext)_localctx).attributeList =  ((Attribute_listContext)_localctx).attribute_list.attributeList;
				                     _localctx.attributeList.add(0, new AttributeMeta((((Attribute_listContext)_localctx).ID!=null?((Attribute_listContext)_localctx).ID.getText():null), ((Attribute_listContext)_localctx).type.dataType, false));
				                 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(190);
				((Attribute_listContext)_localctx).type = type();
				setState(191);
				match(NOT);
				setState(192);
				match(NULL);
				setState(193);
				match(T__3);
				setState(194);
				((Attribute_listContext)_localctx).attribute_list = attribute_list();

				                     ((Attribute_listContext)_localctx).attributeList =  ((Attribute_listContext)_localctx).attribute_list.attributeList;
				                     _localctx.attributeList.add(0, new AttributeMeta((((Attribute_listContext)_localctx).ID!=null?((Attribute_listContext)_localctx).ID.getText():null), ((Attribute_listContext)_localctx).type.dataType, true));
				                 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(198);
				((Attribute_listContext)_localctx).type = type();

				                     ((Attribute_listContext)_localctx).attributeList =  new ArrayList<AttributeMeta>();
				                     _localctx.attributeList.add(0, new AttributeMeta((((Attribute_listContext)_localctx).ID!=null?((Attribute_listContext)_localctx).ID.getText():null), ((Attribute_listContext)_localctx).type.dataType, false));
				                 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(201);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(202);
				((Attribute_listContext)_localctx).type = type();
				setState(203);
				match(NOT);
				setState(204);
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
		enterRule(_localctx, 18, RULE_primary_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(T__3);
			setState(210);
			match(PRIMARY);
			setState(211);
			match(KEY);
			setState(212);
			match(T__1);
			setState(213);
			((Primary_keyContext)_localctx).ID = match(ID);
			setState(214);
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
		enterRule(_localctx, 20, RULE_type);
		try {
			setState(230);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				match(INT);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.INT);
				}
				break;
			case LONG:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				match(LONG);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.LONG);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(221);
				match(FLOAT);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.FLOAT);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(223);
				match(DOUBLE);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.DOUBLE);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(225);
				match(STRING);
				setState(226);
				match(T__1);
				setState(227);
				((TypeContext)_localctx).NUMINT = match(NUMINT);
				setState(228);
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
		enterRule(_localctx, 22, RULE_drop_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(DROP);
			setState(233);
			match(TABLE);
			setState(234);
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
		enterRule(_localctx, 24, RULE_show_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(SHOW);
			setState(238);
			match(TABLE);
			setState(239);
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
		enterRule(_localctx, 26, RULE_insert_into);
		try {
			setState(263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				match(INSERT);
				setState(243);
				match(INTO);
				setState(244);
				((Insert_intoContext)_localctx).ID = match(ID);
				setState(245);
				match(VALUES);
				setState(246);
				match(T__1);
				setState(247);
				((Insert_intoContext)_localctx).value_list = value_list();
				setState(248);
				match(T__2);

				                    ((Insert_intoContext)_localctx).insertSqlExec =  new InsertSQLExecutor((((Insert_intoContext)_localctx).ID!=null?((Insert_intoContext)_localctx).ID.getText():null), null, ((Insert_intoContext)_localctx).value_list.valueList);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				match(INSERT);
				setState(252);
				match(INTO);
				setState(253);
				((Insert_intoContext)_localctx).ID = match(ID);
				setState(254);
				match(T__1);
				setState(255);
				((Insert_intoContext)_localctx).attribute_list_insert = attribute_list_insert();
				setState(256);
				match(T__2);
				setState(257);
				match(VALUES);
				setState(258);
				match(T__1);
				setState(259);
				((Insert_intoContext)_localctx).value_list = value_list();
				setState(260);
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
		enterRule(_localctx, 28, RULE_attribute_list_insert);
		try {
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				((Attribute_list_insertContext)_localctx).ID = match(ID);
				setState(266);
				match(T__3);
				setState(267);
				((Attribute_list_insertContext)_localctx).attribute_list_insert = attribute_list_insert();

				                    ((Attribute_list_insertContext)_localctx).attributeList =  ((Attribute_list_insertContext)_localctx).attribute_list_insert.attributeList;
				                    _localctx.attributeList.add(0, (((Attribute_list_insertContext)_localctx).ID!=null?((Attribute_list_insertContext)_localctx).ID.getText():null));
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
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
		enterRule(_localctx, 30, RULE_value_single);
		int _la;
		try {
			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMFLOAT:
			case NUMFLOATNEG:
			case NUMINT:
			case NUMINTNEG:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
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
				setState(276);
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
		enterRule(_localctx, 32, RULE_value_list);
		try {
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				((Value_listContext)_localctx).value_single = value_single();
				setState(281);
				match(T__3);
				setState(282);
				((Value_listContext)_localctx).value_list = value_list();

				                    ((Value_listContext)_localctx).valueList =  ((Value_listContext)_localctx).value_list.valueList;
				                    _localctx.valueList.add(0, ((Value_listContext)_localctx).value_single.value);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
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
		enterRule(_localctx, 34, RULE_delete_from);
		try {
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(290);
				match(DELETE);
				setState(291);
				match(FROM);
				setState(292);
				((Delete_fromContext)_localctx).ID = match(ID);
				setState(293);
				match(WHERE);
				setState(294);
				((Delete_fromContext)_localctx).where_list = where_list();

				                    ((Delete_fromContext)_localctx).deleteSqlExec =  new DeleteSQLExecutor((((Delete_fromContext)_localctx).ID!=null?((Delete_fromContext)_localctx).ID.getText():null), ((Delete_fromContext)_localctx).where_list.whereCondition);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				match(DELETE);
				setState(298);
				match(FROM);
				setState(299);
				((Delete_fromContext)_localctx).ID = match(ID);

				                    ((Delete_fromContext)_localctx).deleteSqlExec =  new DeleteSQLExecutor((((Delete_fromContext)_localctx).ID!=null?((Delete_fromContext)_localctx).ID.getText():null), null);
				                
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
		enterRule(_localctx, 36, RULE_sql_value);
		try {
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				((Sql_valueContext)_localctx).ID = match(ID);

				                    ((Sql_valueContext)_localctx).sqlValue =  new SQLValue(null, (((Sql_valueContext)_localctx).ID!=null?((Sql_valueContext)_localctx).ID.getText():null));
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
				((Sql_valueContext)_localctx).t = match(ID);
				setState(306);
				match(T__4);
				setState(307);
				((Sql_valueContext)_localctx).a = match(ID);

				                    ((Sql_valueContext)_localctx).sqlValue =  new SQLValue((((Sql_valueContext)_localctx).t!=null?((Sql_valueContext)_localctx).t.getText():null), (((Sql_valueContext)_localctx).a!=null?((Sql_valueContext)_localctx).a.getText():null));
				                
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(309);
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
		public Select_tableContext select_table;
		public List<Sql_valueContext> sql_value() {
			return getRuleContexts(Sql_valueContext.class);
		}
		public Sql_valueContext sql_value(int i) {
			return getRuleContext(Sql_valueContext.class,i);
		}
		public TerminalNode OP() { return getToken(SimpleSQLParser.OP, 0); }
		public TerminalNode OPE() { return getToken(SimpleSQLParser.OPE, 0); }
		public TerminalNode NOT() { return getToken(SimpleSQLParser.NOT, 0); }
		public TerminalNode EXIST() { return getToken(SimpleSQLParser.EXIST, 0); }
		public Select_tableContext select_table() {
			return getRuleContext(Select_tableContext.class,0);
		}
		public One_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_condition; }
	}

	public final One_conditionContext one_condition() throws RecognitionException {
		One_conditionContext _localctx = new One_conditionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_one_condition);
		int _la;
		try {
			setState(332);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
			case NUMFLOAT:
			case NUMFLOATNEG:
			case NUMINT:
			case NUMINTNEG:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				((One_conditionContext)_localctx).l = sql_value();
				setState(315);
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
				setState(316);
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
				                        case "<>":
				                            _op = WhereCondition.Operator.NQ;
				                    }
				                    ((One_conditionContext)_localctx).oneCondition =  new OneCondition(((One_conditionContext)_localctx).l.sqlValue, ((One_conditionContext)_localctx).r.sqlValue, _op);
				                
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				match(NOT);
				setState(320);
				match(EXIST);
				setState(321);
				match(T__1);
				setState(322);
				((One_conditionContext)_localctx).select_table = select_table();
				setState(323);
				match(T__2);

				                    ((One_conditionContext)_localctx).oneCondition =  new NotExistCondition(((One_conditionContext)_localctx).select_table.selectSqlExec, false);
				                
				}
				break;
			case EXIST:
				enterOuterAlt(_localctx, 3);
				{
				setState(326);
				match(EXIST);
				setState(327);
				match(T__1);
				setState(328);
				((One_conditionContext)_localctx).select_table = select_table();
				setState(329);
				match(T__2);

				                    ((One_conditionContext)_localctx).oneCondition =  new NotExistCondition(((One_conditionContext)_localctx).select_table.selectSqlExec, true);
				                
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
		enterRule(_localctx, 40, RULE_where_list);
		try {
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				((Where_listContext)_localctx).one_condition = one_condition();
				setState(335);
				match(AND);
				setState(336);
				((Where_listContext)_localctx).where_list = where_list();

				                    ((Where_listContext)_localctx).whereCondition =  ((Where_listContext)_localctx).where_list.whereCondition;
				                    WhereCondition.LogicConnection _logic = WhereCondition.LogicConnection.AND;
				                    _localctx.whereCondition.AddCondition(((Where_listContext)_localctx).one_condition.oneCondition, _logic);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				((Where_listContext)_localctx).one_condition = one_condition();
				setState(340);
				match(OR);
				setState(341);
				((Where_listContext)_localctx).where_list = where_list();

				                    ((Where_listContext)_localctx).whereCondition =  ((Where_listContext)_localctx).where_list.whereCondition;
				                    WhereCondition.LogicConnection _logic = WhereCondition.LogicConnection.OR;
				                    _localctx.whereCondition.AddCondition(((Where_listContext)_localctx).one_condition.oneCondition, _logic);
				                
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(344);
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
		enterRule(_localctx, 42, RULE_update_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(UPDATE);
			setState(350);
			((Update_tableContext)_localctx).t = match(ID);
			setState(351);
			match(SET);
			setState(352);
			((Update_tableContext)_localctx).a = match(ID);
			setState(353);
			match(OPE);
			setState(354);
			((Update_tableContext)_localctx).value_single = value_single();
			setState(355);
			match(WHERE);
			setState(356);
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
		enterRule(_localctx, 44, RULE_select_table);
		try {
			setState(387);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(359);
				match(SELECT);
				setState(360);
				((Select_tableContext)_localctx).attribute_list_select = attribute_list_select();
				setState(361);
				match(FROM);
				setState(362);
				((Select_tableContext)_localctx).table_list_select = table_list_select();

				                    ((Select_tableContext)_localctx).selectSqlExec =  new SelectSQLExecutor();
				                    _localctx.selectSqlExec.setAttributeList(((Select_tableContext)_localctx).attribute_list_select.attributeList);
				                    _localctx.selectSqlExec.setTableJoin(((Select_tableContext)_localctx).table_list_select.tableJoin);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				match(SELECT);
				setState(366);
				((Select_tableContext)_localctx).attribute_list_select = attribute_list_select();
				setState(367);
				match(FROM);
				setState(368);
				((Select_tableContext)_localctx).table_list_select = table_list_select();
				setState(369);
				match(WHERE);
				setState(370);
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
				setState(373);
				match(SELECT);
				setState(374);
				match(T__5);
				setState(375);
				match(FROM);
				setState(376);
				((Select_tableContext)_localctx).table_list_select = table_list_select();

				                    ((Select_tableContext)_localctx).selectSqlExec =  new SelectSQLExecutor();
				                    _localctx.selectSqlExec.setSelectAll(true);
				                    _localctx.selectSqlExec.setTableJoin(((Select_tableContext)_localctx).table_list_select.tableJoin);
				                
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(379);
				match(SELECT);
				setState(380);
				match(T__5);
				setState(381);
				match(FROM);
				setState(382);
				((Select_tableContext)_localctx).table_list_select = table_list_select();
				setState(383);
				match(WHERE);
				setState(384);
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
		enterRule(_localctx, 46, RULE_attribute_list_select);
		try {
			setState(407);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(389);
				((Attribute_list_selectContext)_localctx).ID = match(ID);
				setState(390);
				match(T__3);
				setState(391);
				((Attribute_list_selectContext)_localctx).attribute_list_select = attribute_list_select();

				                            Pair<String, String> newAttr = new Pair<>(null, (((Attribute_list_selectContext)_localctx).ID!=null?((Attribute_list_selectContext)_localctx).ID.getText():null));
				                            ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList.add(0, newAttr);
				                            ((Attribute_list_selectContext)_localctx).attributeList =  ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList;
				                        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(394);
				((Attribute_list_selectContext)_localctx).t = match(ID);
				setState(395);
				match(T__4);
				setState(396);
				((Attribute_list_selectContext)_localctx).a = match(ID);
				setState(397);
				match(T__3);
				setState(398);
				((Attribute_list_selectContext)_localctx).attribute_list_select = attribute_list_select();

				                            Pair<String, String> newAttr = new Pair<>((((Attribute_list_selectContext)_localctx).t!=null?((Attribute_list_selectContext)_localctx).t.getText():null), (((Attribute_list_selectContext)_localctx).a!=null?((Attribute_list_selectContext)_localctx).a.getText():null));
				                            ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList.add(0, newAttr);
				                            ((Attribute_list_selectContext)_localctx).attributeList =  ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList;
				                        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(401);
				((Attribute_list_selectContext)_localctx).ID = match(ID);

				                            Pair<String, String> newAttr = new Pair<>(null, (((Attribute_list_selectContext)_localctx).ID!=null?((Attribute_list_selectContext)_localctx).ID.getText():null));
				                            ((Attribute_list_selectContext)_localctx).attributeList =  new ArrayList<Pair<String, String> >();
				                            _localctx.attributeList.add(newAttr);
				                        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(403);
				((Attribute_list_selectContext)_localctx).t = match(ID);
				setState(404);
				match(T__4);
				setState(405);
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
		public Where_listContext where_list;
		public Token ID;
		public Select_tableContext select_table;
		public Token t;
		public TerminalNode JOIN() { return getToken(SimpleSQLParser.JOIN, 0); }
		public TerminalNode ON() { return getToken(SimpleSQLParser.ON, 0); }
		public Where_listContext where_list() {
			return getRuleContext(Where_listContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(SimpleSQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleSQLParser.ID, i);
		}
		public TerminalNode LEFT() { return getToken(SimpleSQLParser.LEFT, 0); }
		public TerminalNode OUTER() { return getToken(SimpleSQLParser.OUTER, 0); }
		public TerminalNode RIGHT() { return getToken(SimpleSQLParser.RIGHT, 0); }
		public Select_tableContext select_table() {
			return getRuleContext(Select_tableContext.class,0);
		}
		public TerminalNode AS() { return getToken(SimpleSQLParser.AS, 0); }
		public Table_list_selectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_list_select; }
	}

	public final Table_list_selectContext table_list_select() throws RecognitionException {
		Table_list_selectContext _localctx = new Table_list_selectContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_table_list_select);
		try {
			setState(459);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(409);
				((Table_list_selectContext)_localctx).f = match(ID);
				setState(410);
				match(JOIN);
				setState(411);
				((Table_list_selectContext)_localctx).s = match(ID);
				setState(412);
				match(ON);
				setState(413);
				((Table_list_selectContext)_localctx).where_list = where_list();

				                            ((Table_list_selectContext)_localctx).tableJoin =  new TableJoin();
				                            _localctx.tableJoin.isJoin = true;
				                            _localctx.tableJoin.firstTableName = (((Table_list_selectContext)_localctx).f!=null?((Table_list_selectContext)_localctx).f.getText():null);
				                            _localctx.tableJoin.secondTableName = (((Table_list_selectContext)_localctx).s!=null?((Table_list_selectContext)_localctx).s.getText():null);
				                            _localctx.tableJoin.onCondition = ((Table_list_selectContext)_localctx).where_list.whereCondition;
				                        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(416);
				((Table_list_selectContext)_localctx).f = match(ID);
				setState(417);
				match(LEFT);
				setState(418);
				match(OUTER);
				setState(419);
				match(JOIN);
				setState(420);
				((Table_list_selectContext)_localctx).s = match(ID);
				setState(421);
				match(ON);
				setState(422);
				((Table_list_selectContext)_localctx).where_list = where_list();

				                            ((Table_list_selectContext)_localctx).tableJoin =  new TableJoin();
				                            _localctx.tableJoin.isJoin = true;
				                            _localctx.tableJoin.firstTableName = (((Table_list_selectContext)_localctx).f!=null?((Table_list_selectContext)_localctx).f.getText():null);
				                            _localctx.tableJoin.secondTableName = (((Table_list_selectContext)_localctx).s!=null?((Table_list_selectContext)_localctx).s.getText():null);
				                            _localctx.tableJoin.setJoinType(0);
				                            _localctx.tableJoin.onCondition = ((Table_list_selectContext)_localctx).where_list.whereCondition;
				                          
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(425);
				((Table_list_selectContext)_localctx).f = match(ID);
				setState(426);
				match(RIGHT);
				setState(427);
				match(OUTER);
				setState(428);
				match(JOIN);
				setState(429);
				((Table_list_selectContext)_localctx).s = match(ID);
				setState(430);
				match(ON);
				setState(431);
				((Table_list_selectContext)_localctx).where_list = where_list();

				                            ((Table_list_selectContext)_localctx).tableJoin =  new TableJoin();
				                            _localctx.tableJoin.isJoin = true;
				                            _localctx.tableJoin.firstTableName = (((Table_list_selectContext)_localctx).f!=null?((Table_list_selectContext)_localctx).f.getText():null);
				                            _localctx.tableJoin.secondTableName = (((Table_list_selectContext)_localctx).s!=null?((Table_list_selectContext)_localctx).s.getText():null);
				                            _localctx.tableJoin.setJoinType(1);
				                            _localctx.tableJoin.onCondition = ((Table_list_selectContext)_localctx).where_list.whereCondition;
				                        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(434);
				((Table_list_selectContext)_localctx).ID = match(ID);

				                            ((Table_list_selectContext)_localctx).tableJoin =  new TableJoin();
				                            _localctx.tableJoin.isJoin = false;
				                            _localctx.tableJoin.firstTableName = (((Table_list_selectContext)_localctx).ID!=null?((Table_list_selectContext)_localctx).ID.getText():null);
				                        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(436);
				match(T__1);
				setState(437);
				((Table_list_selectContext)_localctx).select_table = select_table();
				setState(438);
				match(T__2);
				setState(439);
				match(AS);
				setState(440);
				((Table_list_selectContext)_localctx).ID = match(ID);

				                            ((Table_list_selectContext)_localctx).tableJoin =  new SubSelectTable(((Table_list_selectContext)_localctx).select_table.selectSqlExec, (((Table_list_selectContext)_localctx).ID!=null?((Table_list_selectContext)_localctx).ID.getText():null));
				                        
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(443);
				match(T__1);
				setState(444);
				((Table_list_selectContext)_localctx).select_table = select_table();
				setState(445);
				match(T__2);

				                            ((Table_list_selectContext)_localctx).tableJoin =  new SubSelectTable(((Table_list_selectContext)_localctx).select_table.selectSqlExec, null);
				                        
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(448);
				match(T__1);
				setState(449);
				((Table_list_selectContext)_localctx).select_table = select_table();
				setState(450);
				match(T__2);
				setState(451);
				match(AS);
				setState(452);
				((Table_list_selectContext)_localctx).t = match(ID);
				setState(453);
				match(JOIN);
				setState(454);
				((Table_list_selectContext)_localctx).s = match(ID);
				setState(455);
				match(ON);
				setState(456);
				((Table_list_selectContext)_localctx).where_list = where_list();

				                            ((Table_list_selectContext)_localctx).tableJoin =  new SubSelectTable(((Table_list_selectContext)_localctx).select_table.selectSqlExec, (((Table_list_selectContext)_localctx).t!=null?((Table_list_selectContext)_localctx).t.getText():null), (((Table_list_selectContext)_localctx).s!=null?((Table_list_selectContext)_localctx).s.getText():null), ((Table_list_selectContext)_localctx).where_list.whereCondition);
				                        
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u01d0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\3\3\3\5\3"+
		"B\n\3\3\3\3\3\3\3\3\3\5\3H\n\3\3\3\3\3\3\3\5\3M\n\3\3\3\3\3\3\3\3\3\5"+
		"\3S\n\3\3\3\3\3\3\3\3\3\5\3Y\n\3\3\3\3\3\3\3\3\3\5\3_\n\3\3\3\3\3\3\3"+
		"\3\3\5\3e\n\3\3\3\3\3\3\3\3\3\5\3k\n\3\3\3\3\3\3\3\3\3\5\3q\n\3\3\3\3"+
		"\3\3\3\3\3\5\3w\n\3\3\3\3\3\3\3\3\3\5\3}\n\3\3\3\3\3\3\3\3\3\5\3\u0083"+
		"\n\3\3\3\3\3\3\3\3\3\5\3\u0089\n\3\3\3\3\3\5\3\u008d\n\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\5\t\u00b8\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00d2\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\f\u00e9\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u010a\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u0113\n\20\3\21\3\21\3\21\3\21\5\21\u0119"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0123\n\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0130\n\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u013b\n\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u014f\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u015e\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u0186\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u019a\n\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u01ce\n\32\3\32\2\2\33\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\4\3\2-\60\3\2\61\62\2\u01ef\2\64"+
		"\3\2\2\2\4\u008c\3\2\2\2\6\u008e\3\2\2\2\b\u0093\3\2\2\2\n\u0098\3\2\2"+
		"\2\f\u009d\3\2\2\2\16\u00a1\3\2\2\2\20\u00b7\3\2\2\2\22\u00d1\3\2\2\2"+
		"\24\u00d3\3\2\2\2\26\u00e8\3\2\2\2\30\u00ea\3\2\2\2\32\u00ef\3\2\2\2\34"+
		"\u0109\3\2\2\2\36\u0112\3\2\2\2 \u0118\3\2\2\2\"\u0122\3\2\2\2$\u012f"+
		"\3\2\2\2&\u013a\3\2\2\2(\u014e\3\2\2\2*\u015d\3\2\2\2,\u015f\3\2\2\2."+
		"\u0185\3\2\2\2\60\u0199\3\2\2\2\62\u01cd\3\2\2\2\64\65\b\2\1\2\65\66\5"+
		"\4\3\2\66<\b\2\1\2\678\5\4\3\289\b\2\1\29;\3\2\2\2:\67\3\2\2\2;>\3\2\2"+
		"\2<:\3\2\2\2<=\3\2\2\2=\3\3\2\2\2><\3\2\2\2?A\5\20\t\2@B\7\3\2\2A@\3\2"+
		"\2\2AB\3\2\2\2BC\3\2\2\2CD\b\3\1\2D\u008d\3\2\2\2EG\7+\2\2FH\7\3\2\2G"+
		"F\3\2\2\2GH\3\2\2\2HI\3\2\2\2I\u008d\b\3\1\2JL\5\30\r\2KM\7\3\2\2LK\3"+
		"\2\2\2LM\3\2\2\2MN\3\2\2\2NO\b\3\1\2O\u008d\3\2\2\2PR\5\32\16\2QS\7\3"+
		"\2\2RQ\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\b\3\1\2U\u008d\3\2\2\2VX\5\34\17"+
		"\2WY\7\3\2\2XW\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\b\3\1\2[\u008d\3\2\2\2\\"+
		"^\5$\23\2]_\7\3\2\2^]\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\b\3\1\2a\u008d\3\2"+
		"\2\2bd\5,\27\2ce\7\3\2\2dc\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\b\3\1\2g\u008d"+
		"\3\2\2\2hj\5.\30\2ik\7\3\2\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\b\3\1\2m"+
		"\u008d\3\2\2\2np\5\6\4\2oq\7\3\2\2po\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\b\3"+
		"\1\2s\u008d\3\2\2\2tv\5\b\5\2uw\7\3\2\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2"+
		"xy\b\3\1\2y\u008d\3\2\2\2z|\5\n\6\2{}\7\3\2\2|{\3\2\2\2|}\3\2\2\2}~\3"+
		"\2\2\2~\177\b\3\1\2\177\u008d\3\2\2\2\u0080\u0082\5\f\7\2\u0081\u0083"+
		"\7\3\2\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0085\b\3\1\2\u0085\u008d\3\2\2\2\u0086\u0088\5\16\b\2\u0087\u0089\7"+
		"\3\2\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\b\3\1\2\u008b\u008d\3\2\2\2\u008c?\3\2\2\2\u008cE\3\2\2\2\u008c"+
		"J\3\2\2\2\u008cP\3\2\2\2\u008cV\3\2\2\2\u008c\\\3\2\2\2\u008cb\3\2\2\2"+
		"\u008ch\3\2\2\2\u008cn\3\2\2\2\u008ct\3\2\2\2\u008cz\3\2\2\2\u008c\u0080"+
		"\3\2\2\2\u008c\u0086\3\2\2\2\u008d\5\3\2\2\2\u008e\u008f\7\t\2\2\u008f"+
		"\u0090\7#\2\2\u0090\u0091\7\63\2\2\u0091\u0092\b\4\1\2\u0092\7\3\2\2\2"+
		"\u0093\u0094\7\24\2\2\u0094\u0095\7#\2\2\u0095\u0096\7\63\2\2\u0096\u0097"+
		"\b\5\1\2\u0097\t\3\2\2\2\u0098\u0099\7$\2\2\u0099\u009a\7#\2\2\u009a\u009b"+
		"\7\63\2\2\u009b\u009c\b\6\1\2\u009c\13\3\2\2\2\u009d\u009e\7\25\2\2\u009e"+
		"\u009f\7%\2\2\u009f\u00a0\b\7\1\2\u00a0\r\3\2\2\2\u00a1\u00a2\7\25\2\2"+
		"\u00a2\u00a3\7#\2\2\u00a3\u00a4\7\63\2\2\u00a4\u00a5\b\b\1\2\u00a5\17"+
		"\3\2\2\2\u00a6\u00a7\7\t\2\2\u00a7\u00a8\7\n\2\2\u00a8\u00a9\7\63\2\2"+
		"\u00a9\u00aa\7\4\2\2\u00aa\u00ab\5\22\n\2\u00ab\u00ac\7\5\2\2\u00ac\u00ad"+
		"\b\t\1\2\u00ad\u00b8\3\2\2\2\u00ae\u00af\7\t\2\2\u00af\u00b0\7\n\2\2\u00b0"+
		"\u00b1\7\63\2\2\u00b1\u00b2\7\4\2\2\u00b2\u00b3\5\22\n\2\u00b3\u00b4\5"+
		"\24\13\2\u00b4\u00b5\7\5\2\2\u00b5\u00b6\b\t\1\2\u00b6\u00b8\3\2\2\2\u00b7"+
		"\u00a6\3\2\2\2\u00b7\u00ae\3\2\2\2\u00b8\21\3\2\2\2\u00b9\u00ba\7\63\2"+
		"\2\u00ba\u00bb\5\26\f\2\u00bb\u00bc\7\6\2\2\u00bc\u00bd\5\22\n\2\u00bd"+
		"\u00be\b\n\1\2\u00be\u00d2\3\2\2\2\u00bf\u00c0\7\63\2\2\u00c0\u00c1\5"+
		"\26\f\2\u00c1\u00c2\7\20\2\2\u00c2\u00c3\7\21\2\2\u00c3\u00c4\7\6\2\2"+
		"\u00c4\u00c5\5\22\n\2\u00c5\u00c6\b\n\1\2\u00c6\u00d2\3\2\2\2\u00c7\u00c8"+
		"\7\63\2\2\u00c8\u00c9\5\26\f\2\u00c9\u00ca\b\n\1\2\u00ca\u00d2\3\2\2\2"+
		"\u00cb\u00cc\7\63\2\2\u00cc\u00cd\5\26\f\2\u00cd\u00ce\7\20\2\2\u00ce"+
		"\u00cf\7\21\2\2\u00cf\u00d0\b\n\1\2\u00d0\u00d2\3\2\2\2\u00d1\u00b9\3"+
		"\2\2\2\u00d1\u00bf\3\2\2\2\u00d1\u00c7\3\2\2\2\u00d1\u00cb\3\2\2\2\u00d2"+
		"\23\3\2\2\2\u00d3\u00d4\7\6\2\2\u00d4\u00d5\7\22\2\2\u00d5\u00d6\7\23"+
		"\2\2\u00d6\u00d7\7\4\2\2\u00d7\u00d8\7\63\2\2\u00d8\u00d9\7\5\2\2\u00d9"+
		"\u00da\b\13\1\2\u00da\25\3\2\2\2\u00db\u00dc\7\13\2\2\u00dc\u00e9\b\f"+
		"\1\2\u00dd\u00de\7\f\2\2\u00de\u00e9\b\f\1\2\u00df\u00e0\7\r\2\2\u00e0"+
		"\u00e9\b\f\1\2\u00e1\u00e2\7\16\2\2\u00e2\u00e9\b\f\1\2\u00e3\u00e4\7"+
		"\17\2\2\u00e4\u00e5\7\4\2\2\u00e5\u00e6\7/\2\2\u00e6\u00e7\7\5\2\2\u00e7"+
		"\u00e9\b\f\1\2\u00e8\u00db\3\2\2\2\u00e8\u00dd\3\2\2\2\u00e8\u00df\3\2"+
		"\2\2\u00e8\u00e1\3\2\2\2\u00e8\u00e3\3\2\2\2\u00e9\27\3\2\2\2\u00ea\u00eb"+
		"\7\24\2\2\u00eb\u00ec\7\n\2\2\u00ec\u00ed\7\63\2\2\u00ed\u00ee\b\r\1\2"+
		"\u00ee\31\3\2\2\2\u00ef\u00f0\7\25\2\2\u00f0\u00f1\7\n\2\2\u00f1\u00f2"+
		"\7\63\2\2\u00f2\u00f3\b\16\1\2\u00f3\33\3\2\2\2\u00f4\u00f5\7\26\2\2\u00f5"+
		"\u00f6\7\27\2\2\u00f6\u00f7\7\63\2\2\u00f7\u00f8\7\30\2\2\u00f8\u00f9"+
		"\7\4\2\2\u00f9\u00fa\5\"\22\2\u00fa\u00fb\7\5\2\2\u00fb\u00fc\b\17\1\2"+
		"\u00fc\u010a\3\2\2\2\u00fd\u00fe\7\26\2\2\u00fe\u00ff\7\27\2\2\u00ff\u0100"+
		"\7\63\2\2\u0100\u0101\7\4\2\2\u0101\u0102\5\36\20\2\u0102\u0103\7\5\2"+
		"\2\u0103\u0104\7\30\2\2\u0104\u0105\7\4\2\2\u0105\u0106\5\"\22\2\u0106"+
		"\u0107\7\5\2\2\u0107\u0108\b\17\1\2\u0108\u010a\3\2\2\2\u0109\u00f4\3"+
		"\2\2\2\u0109\u00fd\3\2\2\2\u010a\35\3\2\2\2\u010b\u010c\7\63\2\2\u010c"+
		"\u010d\7\6\2\2\u010d\u010e\5\36\20\2\u010e\u010f\b\20\1\2\u010f\u0113"+
		"\3\2\2\2\u0110\u0111\7\63\2\2\u0111\u0113\b\20\1\2\u0112\u010b\3\2\2\2"+
		"\u0112\u0110\3\2\2\2\u0113\37\3\2\2\2\u0114\u0115\t\2\2\2\u0115\u0119"+
		"\b\21\1\2\u0116\u0117\7,\2\2\u0117\u0119\b\21\1\2\u0118\u0114\3\2\2\2"+
		"\u0118\u0116\3\2\2\2\u0119!\3\2\2\2\u011a\u011b\5 \21\2\u011b\u011c\7"+
		"\6\2\2\u011c\u011d\5\"\22\2\u011d\u011e\b\22\1\2\u011e\u0123\3\2\2\2\u011f"+
		"\u0120\5 \21\2\u0120\u0121\b\22\1\2\u0121\u0123\3\2\2\2\u0122\u011a\3"+
		"\2\2\2\u0122\u011f\3\2\2\2\u0123#\3\2\2\2\u0124\u0125\7\31\2\2\u0125\u0126"+
		"\7\32\2\2\u0126\u0127\7\63\2\2\u0127\u0128\7\33\2\2\u0128\u0129\5*\26"+
		"\2\u0129\u012a\b\23\1\2\u012a\u0130\3\2\2\2\u012b\u012c\7\31\2\2\u012c"+
		"\u012d\7\32\2\2\u012d\u012e\7\63\2\2\u012e\u0130\b\23\1\2\u012f\u0124"+
		"\3\2\2\2\u012f\u012b\3\2\2\2\u0130%\3\2\2\2\u0131\u0132\7\63\2\2\u0132"+
		"\u013b\b\24\1\2\u0133\u0134\7\63\2\2\u0134\u0135\7\7\2\2\u0135\u0136\7"+
		"\63\2\2\u0136\u013b\b\24\1\2\u0137\u0138\5 \21\2\u0138\u0139\b\24\1\2"+
		"\u0139\u013b\3\2\2\2\u013a\u0131\3\2\2\2\u013a\u0133\3\2\2\2\u013a\u0137"+
		"\3\2\2\2\u013b\'\3\2\2\2\u013c\u013d\5&\24\2\u013d\u013e\t\3\2\2\u013e"+
		"\u013f\5&\24\2\u013f\u0140\b\25\1\2\u0140\u014f\3\2\2\2\u0141\u0142\7"+
		"\20\2\2\u0142\u0143\7*\2\2\u0143\u0144\7\4\2\2\u0144\u0145\5.\30\2\u0145"+
		"\u0146\7\5\2\2\u0146\u0147\b\25\1\2\u0147\u014f\3\2\2\2\u0148\u0149\7"+
		"*\2\2\u0149\u014a\7\4\2\2\u014a\u014b\5.\30\2\u014b\u014c\7\5\2\2\u014c"+
		"\u014d\b\25\1\2\u014d\u014f\3\2\2\2\u014e\u013c\3\2\2\2\u014e\u0141\3"+
		"\2\2\2\u014e\u0148\3\2\2\2\u014f)\3\2\2\2\u0150\u0151\5(\25\2\u0151\u0152"+
		"\7!\2\2\u0152\u0153\5*\26\2\u0153\u0154\b\26\1\2\u0154\u015e\3\2\2\2\u0155"+
		"\u0156\5(\25\2\u0156\u0157\7\"\2\2\u0157\u0158\5*\26\2\u0158\u0159\b\26"+
		"\1\2\u0159\u015e\3\2\2\2\u015a\u015b\5(\25\2\u015b\u015c\b\26\1\2\u015c"+
		"\u015e\3\2\2\2\u015d\u0150\3\2\2\2\u015d\u0155\3\2\2\2\u015d\u015a\3\2"+
		"\2\2\u015e+\3\2\2\2\u015f\u0160\7\34\2\2\u0160\u0161\7\63\2\2\u0161\u0162"+
		"\7\35\2\2\u0162\u0163\7\63\2\2\u0163\u0164\7\62\2\2\u0164\u0165\5 \21"+
		"\2\u0165\u0166\7\33\2\2\u0166\u0167\5*\26\2\u0167\u0168\b\27\1\2\u0168"+
		"-\3\2\2\2\u0169\u016a\7\36\2\2\u016a\u016b\5\60\31\2\u016b\u016c\7\32"+
		"\2\2\u016c\u016d\5\62\32\2\u016d\u016e\b\30\1\2\u016e\u0186\3\2\2\2\u016f"+
		"\u0170\7\36\2\2\u0170\u0171\5\60\31\2\u0171\u0172\7\32\2\2\u0172\u0173"+
		"\5\62\32\2\u0173\u0174\7\33\2\2\u0174\u0175\5*\26\2\u0175\u0176\b\30\1"+
		"\2\u0176\u0186\3\2\2\2\u0177\u0178\7\36\2\2\u0178\u0179\7\b\2\2\u0179"+
		"\u017a\7\32\2\2\u017a\u017b\5\62\32\2\u017b\u017c\b\30\1\2\u017c\u0186"+
		"\3\2\2\2\u017d\u017e\7\36\2\2\u017e\u017f\7\b\2\2\u017f\u0180\7\32\2\2"+
		"\u0180\u0181\5\62\32\2\u0181\u0182\7\33\2\2\u0182\u0183\5*\26\2\u0183"+
		"\u0184\b\30\1\2\u0184\u0186\3\2\2\2\u0185\u0169\3\2\2\2\u0185\u016f\3"+
		"\2\2\2\u0185\u0177\3\2\2\2\u0185\u017d\3\2\2\2\u0186/\3\2\2\2\u0187\u0188"+
		"\7\63\2\2\u0188\u0189\7\6\2\2\u0189\u018a\5\60\31\2\u018a\u018b\b\31\1"+
		"\2\u018b\u019a\3\2\2\2\u018c\u018d\7\63\2\2\u018d\u018e\7\7\2\2\u018e"+
		"\u018f\7\63\2\2\u018f\u0190\7\6\2\2\u0190\u0191\5\60\31\2\u0191\u0192"+
		"\b\31\1\2\u0192\u019a\3\2\2\2\u0193\u0194\7\63\2\2\u0194\u019a\b\31\1"+
		"\2\u0195\u0196\7\63\2\2\u0196\u0197\7\7\2\2\u0197\u0198\7\63\2\2\u0198"+
		"\u019a\b\31\1\2\u0199\u0187\3\2\2\2\u0199\u018c\3\2\2\2\u0199\u0193\3"+
		"\2\2\2\u0199\u0195\3\2\2\2\u019a\61\3\2\2\2\u019b\u019c\7\63\2\2\u019c"+
		"\u019d\7\37\2\2\u019d\u019e\7\63\2\2\u019e\u019f\7 \2\2\u019f\u01a0\5"+
		"*\26\2\u01a0\u01a1\b\32\1\2\u01a1\u01ce\3\2\2\2\u01a2\u01a3\7\63\2\2\u01a3"+
		"\u01a4\7\'\2\2\u01a4\u01a5\7&\2\2\u01a5\u01a6\7\37\2\2\u01a6\u01a7\7\63"+
		"\2\2\u01a7\u01a8\7 \2\2\u01a8\u01a9\5*\26\2\u01a9\u01aa\b\32\1\2\u01aa"+
		"\u01ce\3\2\2\2\u01ab\u01ac\7\63\2\2\u01ac\u01ad\7(\2\2\u01ad\u01ae\7&"+
		"\2\2\u01ae\u01af\7\37\2\2\u01af\u01b0\7\63\2\2\u01b0\u01b1\7 \2\2\u01b1"+
		"\u01b2\5*\26\2\u01b2\u01b3\b\32\1\2\u01b3\u01ce\3\2\2\2\u01b4\u01b5\7"+
		"\63\2\2\u01b5\u01ce\b\32\1\2\u01b6\u01b7\7\4\2\2\u01b7\u01b8\5.\30\2\u01b8"+
		"\u01b9\7\5\2\2\u01b9\u01ba\7)\2\2\u01ba\u01bb\7\63\2\2\u01bb\u01bc\b\32"+
		"\1\2\u01bc\u01ce\3\2\2\2\u01bd\u01be\7\4\2\2\u01be\u01bf\5.\30\2\u01bf"+
		"\u01c0\7\5\2\2\u01c0\u01c1\b\32\1\2\u01c1\u01ce\3\2\2\2\u01c2\u01c3\7"+
		"\4\2\2\u01c3\u01c4\5.\30\2\u01c4\u01c5\7\5\2\2\u01c5\u01c6\7)\2\2\u01c6"+
		"\u01c7\7\63\2\2\u01c7\u01c8\7\37\2\2\u01c8\u01c9\7\63\2\2\u01c9\u01ca"+
		"\7 \2\2\u01ca\u01cb\5*\26\2\u01cb\u01cc\b\32\1\2\u01cc\u01ce\3\2\2\2\u01cd"+
		"\u019b\3\2\2\2\u01cd\u01a2\3\2\2\2\u01cd\u01ab\3\2\2\2\u01cd\u01b4\3\2"+
		"\2\2\u01cd\u01b6\3\2\2\2\u01cd\u01bd\3\2\2\2\u01cd\u01c2\3\2\2\2\u01ce"+
		"\63\3\2\2\2\37<AGLRX^djpv|\u0082\u0088\u008c\u00b7\u00d1\u00e8\u0109\u0112"+
		"\u0118\u0122\u012f\u013a\u014e\u015d\u0185\u0199\u01cd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}