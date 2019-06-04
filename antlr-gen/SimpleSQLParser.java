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
		DATABASE=33, USE=34, DATABASES=35, TEXT=36, NUMFLOAT=37, NUMFLOATNEG=38, 
		NUMINT=39, NUMINTNEG=40, OP=41, OPE=42, ID=43, WS=44;
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
			null, null, null, null, null, null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "CREATE", "TABLE", "INT", "LONG", 
			"FLOAT", "DOUBLE", "STRING", "NOT", "NULL", "PRIMARY", "KEY", "DROP", 
			"SHOW", "INSERT", "INTO", "VALUES", "DELETE", "FROM", "WHERE", "UPDATE", 
			"SET", "SELECT", "JOIN", "ON", "AND", "OR", "DATABASE", "USE", "DATABASES", 
			"TEXT", "NUMFLOAT", "NUMFLOATNEG", "NUMINT", "NUMINTNEG", "OP", "OPE", 
			"ID", "WS"
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CREATE) | (1L << DROP) | (1L << SHOW) | (1L << INSERT) | (1L << DELETE) | (1L << UPDATE) | (1L << SELECT) | (1L << USE))) != 0)) {
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
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
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
				((SqlContext)_localctx).drop_table = drop_table();
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(68);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).drop_table.dropSqlExec;
				                
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				((SqlContext)_localctx).show_table = show_table();
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(74);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).show_table.showSqlExec;
				                
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				((SqlContext)_localctx).insert_into = insert_into();
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(80);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).insert_into.insertSqlExec;
				                
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(85);
				((SqlContext)_localctx).delete_from = delete_from();
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(86);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).delete_from.deleteSqlExec;
				                
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(91);
				((SqlContext)_localctx).update_table = update_table();
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(92);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).update_table.updateSqlExec;
				                
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(97);
				((SqlContext)_localctx).select_table = select_table();
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(98);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).select_table.selectSqlExec;
				                
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(103);
				((SqlContext)_localctx).create_db = create_db();
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(104);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).create_db.createDBExec;
				                
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(109);
				((SqlContext)_localctx).drop_db = drop_db();
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(110);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).drop_db.dropDBExec;
				                
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(115);
				((SqlContext)_localctx).use_db = use_db();
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(116);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).use_db.useDBExec;
				                
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(121);
				((SqlContext)_localctx).show_databases = show_databases();
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(122);
					match(T__0);
					}
				}


				                    ((SqlContext)_localctx).sqlExecutor =  ((SqlContext)_localctx).show_databases.showAllExec;
				                
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(127);
				((SqlContext)_localctx).show_database = show_database();
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(128);
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
			setState(135);
			match(CREATE);
			setState(136);
			match(DATABASE);
			setState(137);
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
			setState(140);
			match(DROP);
			setState(141);
			match(DATABASE);
			setState(142);
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
			setState(145);
			match(USE);
			setState(146);
			match(DATABASE);
			setState(147);
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
			setState(150);
			match(SHOW);
			setState(151);
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
			setState(154);
			match(SHOW);
			setState(155);
			match(DATABASE);
			setState(156);
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
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(CREATE);
				setState(160);
				match(TABLE);
				setState(161);
				((Create_tableContext)_localctx).ID = match(ID);
				setState(162);
				match(T__1);
				setState(163);
				((Create_tableContext)_localctx).attribute_list = attribute_list();
				setState(164);
				match(T__2);

				                    ((Create_tableContext)_localctx).createSqlExec =  new CreateSQLExecutor((((Create_tableContext)_localctx).ID!=null?((Create_tableContext)_localctx).ID.getText():null), ((Create_tableContext)_localctx).attribute_list.attributeList, null);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				match(CREATE);
				setState(168);
				match(TABLE);
				setState(169);
				((Create_tableContext)_localctx).ID = match(ID);
				setState(170);
				match(T__1);
				setState(171);
				((Create_tableContext)_localctx).attribute_list = attribute_list();
				setState(172);
				((Create_tableContext)_localctx).primary_key = primary_key();
				setState(173);
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
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(179);
				((Attribute_listContext)_localctx).type = type();
				setState(180);
				match(T__3);
				setState(181);
				((Attribute_listContext)_localctx).attribute_list = attribute_list();

				                     ((Attribute_listContext)_localctx).attributeList =  ((Attribute_listContext)_localctx).attribute_list.attributeList;
				                     _localctx.attributeList.add(0, new AttributeMeta((((Attribute_listContext)_localctx).ID!=null?((Attribute_listContext)_localctx).ID.getText():null), ((Attribute_listContext)_localctx).type.dataType, false));
				                 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(185);
				((Attribute_listContext)_localctx).type = type();
				setState(186);
				match(NOT);
				setState(187);
				match(NULL);
				setState(188);
				match(T__3);
				setState(189);
				((Attribute_listContext)_localctx).attribute_list = attribute_list();

				                     ((Attribute_listContext)_localctx).attributeList =  ((Attribute_listContext)_localctx).attribute_list.attributeList;
				                     _localctx.attributeList.add(0, new AttributeMeta((((Attribute_listContext)_localctx).ID!=null?((Attribute_listContext)_localctx).ID.getText():null), ((Attribute_listContext)_localctx).type.dataType, true));
				                 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(193);
				((Attribute_listContext)_localctx).type = type();

				                     ((Attribute_listContext)_localctx).attributeList =  new ArrayList<AttributeMeta>();
				                     _localctx.attributeList.add(0, new AttributeMeta((((Attribute_listContext)_localctx).ID!=null?((Attribute_listContext)_localctx).ID.getText():null), ((Attribute_listContext)_localctx).type.dataType, false));
				                 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(196);
				((Attribute_listContext)_localctx).ID = match(ID);
				setState(197);
				((Attribute_listContext)_localctx).type = type();
				setState(198);
				match(NOT);
				setState(199);
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
			setState(204);
			match(T__3);
			setState(205);
			match(PRIMARY);
			setState(206);
			match(KEY);
			setState(207);
			match(T__1);
			setState(208);
			((Primary_keyContext)_localctx).ID = match(ID);
			setState(209);
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
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				match(INT);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.INT);
				}
				break;
			case LONG:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				match(LONG);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.LONG);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				match(FLOAT);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.FLOAT);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(218);
				match(DOUBLE);
				((TypeContext)_localctx).dataType =  new SQLDataType(-1, SQLDataType.Type.DOUBLE);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(220);
				match(STRING);
				setState(221);
				match(T__1);
				setState(222);
				((TypeContext)_localctx).NUMINT = match(NUMINT);
				setState(223);
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
			setState(227);
			match(DROP);
			setState(228);
			match(TABLE);
			setState(229);
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
			setState(232);
			match(SHOW);
			setState(233);
			match(TABLE);
			setState(234);
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
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				match(INSERT);
				setState(238);
				match(INTO);
				setState(239);
				((Insert_intoContext)_localctx).ID = match(ID);
				setState(240);
				match(VALUES);
				setState(241);
				match(T__1);
				setState(242);
				((Insert_intoContext)_localctx).value_list = value_list();
				setState(243);
				match(T__2);

				                    ((Insert_intoContext)_localctx).insertSqlExec =  new InsertSQLExecutor((((Insert_intoContext)_localctx).ID!=null?((Insert_intoContext)_localctx).ID.getText():null), null, ((Insert_intoContext)_localctx).value_list.valueList);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				match(INSERT);
				setState(247);
				match(INTO);
				setState(248);
				((Insert_intoContext)_localctx).ID = match(ID);
				setState(249);
				match(T__1);
				setState(250);
				((Insert_intoContext)_localctx).attribute_list_insert = attribute_list_insert();
				setState(251);
				match(T__2);
				setState(252);
				match(VALUES);
				setState(253);
				match(T__1);
				setState(254);
				((Insert_intoContext)_localctx).value_list = value_list();
				setState(255);
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
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				((Attribute_list_insertContext)_localctx).ID = match(ID);
				setState(261);
				match(T__3);
				setState(262);
				((Attribute_list_insertContext)_localctx).attribute_list_insert = attribute_list_insert();

				                    ((Attribute_list_insertContext)_localctx).attributeList =  ((Attribute_list_insertContext)_localctx).attribute_list_insert.attributeList;
				                    _localctx.attributeList.add(0, (((Attribute_list_insertContext)_localctx).ID!=null?((Attribute_list_insertContext)_localctx).ID.getText():null));
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
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
			setState(273);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMFLOAT:
			case NUMFLOATNEG:
			case NUMINT:
			case NUMINTNEG:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
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
				setState(271);
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
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				((Value_listContext)_localctx).value_single = value_single();
				setState(276);
				match(T__3);
				setState(277);
				((Value_listContext)_localctx).value_list = value_list();

				                    ((Value_listContext)_localctx).valueList =  ((Value_listContext)_localctx).value_list.valueList;
				                    _localctx.valueList.add(0, ((Value_listContext)_localctx).value_single.value);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(DELETE);
			setState(286);
			match(FROM);
			setState(287);
			((Delete_fromContext)_localctx).ID = match(ID);
			setState(288);
			match(WHERE);
			setState(289);
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
		enterRule(_localctx, 36, RULE_sql_value);
		try {
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				((Sql_valueContext)_localctx).ID = match(ID);

				                    ((Sql_valueContext)_localctx).sqlValue =  new SQLValue(null, (((Sql_valueContext)_localctx).ID!=null?((Sql_valueContext)_localctx).ID.getText():null));
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				((Sql_valueContext)_localctx).t = match(ID);
				setState(295);
				match(T__4);
				setState(296);
				((Sql_valueContext)_localctx).a = match(ID);

				                    ((Sql_valueContext)_localctx).sqlValue =  new SQLValue((((Sql_valueContext)_localctx).t!=null?((Sql_valueContext)_localctx).t.getText():null), (((Sql_valueContext)_localctx).a!=null?((Sql_valueContext)_localctx).a.getText():null));
				                
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
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
		enterRule(_localctx, 38, RULE_one_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			((One_conditionContext)_localctx).l = sql_value();
			setState(304);
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
			setState(305);
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
		enterRule(_localctx, 40, RULE_where_list);
		try {
			setState(321);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				((Where_listContext)_localctx).one_condition = one_condition();
				setState(309);
				match(AND);
				setState(310);
				((Where_listContext)_localctx).where_list = where_list();

				                    ((Where_listContext)_localctx).whereCondition =  ((Where_listContext)_localctx).where_list.whereCondition;
				                    WhereCondition.LogicConnection _logic = WhereCondition.LogicConnection.AND;
				                    _localctx.whereCondition.AddCondition(((Where_listContext)_localctx).one_condition.oneCondition, _logic);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
				((Where_listContext)_localctx).one_condition = one_condition();
				setState(314);
				match(OR);
				setState(315);
				((Where_listContext)_localctx).where_list = where_list();

				                    ((Where_listContext)_localctx).whereCondition =  ((Where_listContext)_localctx).where_list.whereCondition;
				                    WhereCondition.LogicConnection _logic = WhereCondition.LogicConnection.OR;
				                    _localctx.whereCondition.AddCondition(((Where_listContext)_localctx).one_condition.oneCondition, _logic);
				                
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(318);
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
			setState(323);
			match(UPDATE);
			setState(324);
			((Update_tableContext)_localctx).t = match(ID);
			setState(325);
			match(SET);
			setState(326);
			((Update_tableContext)_localctx).a = match(ID);
			setState(327);
			match(OPE);
			setState(328);
			((Update_tableContext)_localctx).value_single = value_single();
			setState(329);
			match(WHERE);
			setState(330);
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
			setState(361);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				match(SELECT);
				setState(334);
				((Select_tableContext)_localctx).attribute_list_select = attribute_list_select();
				setState(335);
				match(FROM);
				setState(336);
				((Select_tableContext)_localctx).table_list_select = table_list_select();

				                    ((Select_tableContext)_localctx).selectSqlExec =  new SelectSQLExecutor();
				                    _localctx.selectSqlExec.setAttributeList(((Select_tableContext)_localctx).attribute_list_select.attributeList);
				                    _localctx.selectSqlExec.setTableJoin(((Select_tableContext)_localctx).table_list_select.tableJoin);
				                
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				match(SELECT);
				setState(340);
				((Select_tableContext)_localctx).attribute_list_select = attribute_list_select();
				setState(341);
				match(FROM);
				setState(342);
				((Select_tableContext)_localctx).table_list_select = table_list_select();
				setState(343);
				match(WHERE);
				setState(344);
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
				setState(347);
				match(SELECT);
				setState(348);
				match(T__5);
				setState(349);
				match(FROM);
				setState(350);
				((Select_tableContext)_localctx).table_list_select = table_list_select();

				                    ((Select_tableContext)_localctx).selectSqlExec =  new SelectSQLExecutor();
				                    _localctx.selectSqlExec.setSelectAll(true);
				                    _localctx.selectSqlExec.setTableJoin(((Select_tableContext)_localctx).table_list_select.tableJoin);
				                
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(353);
				match(SELECT);
				setState(354);
				match(T__5);
				setState(355);
				match(FROM);
				setState(356);
				((Select_tableContext)_localctx).table_list_select = table_list_select();
				setState(357);
				match(WHERE);
				setState(358);
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
			setState(381);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				((Attribute_list_selectContext)_localctx).ID = match(ID);
				setState(364);
				match(T__3);
				setState(365);
				((Attribute_list_selectContext)_localctx).attribute_list_select = attribute_list_select();

				                            Pair<String, String> newAttr = new Pair<>(null, (((Attribute_list_selectContext)_localctx).ID!=null?((Attribute_list_selectContext)_localctx).ID.getText():null));
				                            ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList.add(0, newAttr);
				                            ((Attribute_list_selectContext)_localctx).attributeList =  ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList;
				                        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(368);
				((Attribute_list_selectContext)_localctx).t = match(ID);
				setState(369);
				match(T__4);
				setState(370);
				((Attribute_list_selectContext)_localctx).a = match(ID);
				setState(371);
				match(T__3);
				setState(372);
				((Attribute_list_selectContext)_localctx).attribute_list_select = attribute_list_select();

				                            Pair<String, String> newAttr = new Pair<>((((Attribute_list_selectContext)_localctx).t!=null?((Attribute_list_selectContext)_localctx).t.getText():null), (((Attribute_list_selectContext)_localctx).a!=null?((Attribute_list_selectContext)_localctx).a.getText():null));
				                            ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList.add(0, newAttr);
				                            ((Attribute_list_selectContext)_localctx).attributeList =  ((Attribute_list_selectContext)_localctx).attribute_list_select.attributeList;
				                        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(375);
				((Attribute_list_selectContext)_localctx).ID = match(ID);

				                            Pair<String, String> newAttr = new Pair<>(null, (((Attribute_list_selectContext)_localctx).ID!=null?((Attribute_list_selectContext)_localctx).ID.getText():null));
				                            ((Attribute_list_selectContext)_localctx).attributeList =  new ArrayList<Pair<String, String> >();
				                            _localctx.attributeList.add(newAttr);
				                        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(377);
				((Attribute_list_selectContext)_localctx).t = match(ID);
				setState(378);
				match(T__4);
				setState(379);
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
		enterRule(_localctx, 48, RULE_table_list_select);
		try {
			setState(397);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(383);
				((Table_list_selectContext)_localctx).f = match(ID);
				setState(384);
				match(JOIN);
				setState(385);
				((Table_list_selectContext)_localctx).s = match(ID);
				setState(386);
				match(ON);
				setState(387);
				((Table_list_selectContext)_localctx).ft = match(ID);
				setState(388);
				match(T__4);
				setState(389);
				((Table_list_selectContext)_localctx).fa = match(ID);
				setState(390);
				match(OPE);
				setState(391);
				((Table_list_selectContext)_localctx).st = match(ID);
				setState(392);
				match(T__4);
				setState(393);
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
				setState(395);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0192\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\3\3\3\5\3"+
		"B\n\3\3\3\3\3\3\3\3\3\5\3H\n\3\3\3\3\3\3\3\3\3\5\3N\n\3\3\3\3\3\3\3\3"+
		"\3\5\3T\n\3\3\3\3\3\3\3\3\3\5\3Z\n\3\3\3\3\3\3\3\3\3\5\3`\n\3\3\3\3\3"+
		"\3\3\3\3\5\3f\n\3\3\3\3\3\3\3\3\3\5\3l\n\3\3\3\3\3\3\3\3\3\5\3r\n\3\3"+
		"\3\3\3\3\3\3\3\5\3x\n\3\3\3\3\3\3\3\3\3\5\3~\n\3\3\3\3\3\3\3\3\3\5\3\u0084"+
		"\n\3\3\3\3\3\5\3\u0088\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00b3\n\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\u00cd\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00e4\n"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\5\17\u0105\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u010e\n\20\3\21\3\21\3\21\3\21\5\21\u0114\n\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\5\22\u011e\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0130\n\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u0144\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u016c\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0180\n\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0190\n\32"+
		"\3\32\2\2\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\4"+
		"\3\2\'*\3\2+,\2\u01a7\2\64\3\2\2\2\4\u0087\3\2\2\2\6\u0089\3\2\2\2\b\u008e"+
		"\3\2\2\2\n\u0093\3\2\2\2\f\u0098\3\2\2\2\16\u009c\3\2\2\2\20\u00b2\3\2"+
		"\2\2\22\u00cc\3\2\2\2\24\u00ce\3\2\2\2\26\u00e3\3\2\2\2\30\u00e5\3\2\2"+
		"\2\32\u00ea\3\2\2\2\34\u0104\3\2\2\2\36\u010d\3\2\2\2 \u0113\3\2\2\2\""+
		"\u011d\3\2\2\2$\u011f\3\2\2\2&\u012f\3\2\2\2(\u0131\3\2\2\2*\u0143\3\2"+
		"\2\2,\u0145\3\2\2\2.\u016b\3\2\2\2\60\u017f\3\2\2\2\62\u018f\3\2\2\2\64"+
		"\65\b\2\1\2\65\66\5\4\3\2\66<\b\2\1\2\678\5\4\3\289\b\2\1\29;\3\2\2\2"+
		":\67\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\3\3\2\2\2><\3\2\2\2?A\5\20"+
		"\t\2@B\7\3\2\2A@\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\b\3\1\2D\u0088\3\2\2\2"+
		"EG\5\30\r\2FH\7\3\2\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\b\3\1\2J\u0088\3"+
		"\2\2\2KM\5\32\16\2LN\7\3\2\2ML\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\b\3\1\2P"+
		"\u0088\3\2\2\2QS\5\34\17\2RT\7\3\2\2SR\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\b"+
		"\3\1\2V\u0088\3\2\2\2WY\5$\23\2XZ\7\3\2\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2"+
		"\2[\\\b\3\1\2\\\u0088\3\2\2\2]_\5,\27\2^`\7\3\2\2_^\3\2\2\2_`\3\2\2\2"+
		"`a\3\2\2\2ab\b\3\1\2b\u0088\3\2\2\2ce\5.\30\2df\7\3\2\2ed\3\2\2\2ef\3"+
		"\2\2\2fg\3\2\2\2gh\b\3\1\2h\u0088\3\2\2\2ik\5\6\4\2jl\7\3\2\2kj\3\2\2"+
		"\2kl\3\2\2\2lm\3\2\2\2mn\b\3\1\2n\u0088\3\2\2\2oq\5\b\5\2pr\7\3\2\2qp"+
		"\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\b\3\1\2t\u0088\3\2\2\2uw\5\n\6\2vx\7\3"+
		"\2\2wv\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\b\3\1\2z\u0088\3\2\2\2{}\5\f\7\2"+
		"|~\7\3\2\2}|\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\b\3\1\2\u0080\u0088"+
		"\3\2\2\2\u0081\u0083\5\16\b\2\u0082\u0084\7\3\2\2\u0083\u0082\3\2\2\2"+
		"\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\b\3\1\2\u0086\u0088"+
		"\3\2\2\2\u0087?\3\2\2\2\u0087E\3\2\2\2\u0087K\3\2\2\2\u0087Q\3\2\2\2\u0087"+
		"W\3\2\2\2\u0087]\3\2\2\2\u0087c\3\2\2\2\u0087i\3\2\2\2\u0087o\3\2\2\2"+
		"\u0087u\3\2\2\2\u0087{\3\2\2\2\u0087\u0081\3\2\2\2\u0088\5\3\2\2\2\u0089"+
		"\u008a\7\t\2\2\u008a\u008b\7#\2\2\u008b\u008c\7-\2\2\u008c\u008d\b\4\1"+
		"\2\u008d\7\3\2\2\2\u008e\u008f\7\24\2\2\u008f\u0090\7#\2\2\u0090\u0091"+
		"\7-\2\2\u0091\u0092\b\5\1\2\u0092\t\3\2\2\2\u0093\u0094\7$\2\2\u0094\u0095"+
		"\7#\2\2\u0095\u0096\7-\2\2\u0096\u0097\b\6\1\2\u0097\13\3\2\2\2\u0098"+
		"\u0099\7\25\2\2\u0099\u009a\7%\2\2\u009a\u009b\b\7\1\2\u009b\r\3\2\2\2"+
		"\u009c\u009d\7\25\2\2\u009d\u009e\7#\2\2\u009e\u009f\7-\2\2\u009f\u00a0"+
		"\b\b\1\2\u00a0\17\3\2\2\2\u00a1\u00a2\7\t\2\2\u00a2\u00a3\7\n\2\2\u00a3"+
		"\u00a4\7-\2\2\u00a4\u00a5\7\4\2\2\u00a5\u00a6\5\22\n\2\u00a6\u00a7\7\5"+
		"\2\2\u00a7\u00a8\b\t\1\2\u00a8\u00b3\3\2\2\2\u00a9\u00aa\7\t\2\2\u00aa"+
		"\u00ab\7\n\2\2\u00ab\u00ac\7-\2\2\u00ac\u00ad\7\4\2\2\u00ad\u00ae\5\22"+
		"\n\2\u00ae\u00af\5\24\13\2\u00af\u00b0\7\5\2\2\u00b0\u00b1\b\t\1\2\u00b1"+
		"\u00b3\3\2\2\2\u00b2\u00a1\3\2\2\2\u00b2\u00a9\3\2\2\2\u00b3\21\3\2\2"+
		"\2\u00b4\u00b5\7-\2\2\u00b5\u00b6\5\26\f\2\u00b6\u00b7\7\6\2\2\u00b7\u00b8"+
		"\5\22\n\2\u00b8\u00b9\b\n\1\2\u00b9\u00cd\3\2\2\2\u00ba\u00bb\7-\2\2\u00bb"+
		"\u00bc\5\26\f\2\u00bc\u00bd\7\20\2\2\u00bd\u00be\7\21\2\2\u00be\u00bf"+
		"\7\6\2\2\u00bf\u00c0\5\22\n\2\u00c0\u00c1\b\n\1\2\u00c1\u00cd\3\2\2\2"+
		"\u00c2\u00c3\7-\2\2\u00c3\u00c4\5\26\f\2\u00c4\u00c5\b\n\1\2\u00c5\u00cd"+
		"\3\2\2\2\u00c6\u00c7\7-\2\2\u00c7\u00c8\5\26\f\2\u00c8\u00c9\7\20\2\2"+
		"\u00c9\u00ca\7\21\2\2\u00ca\u00cb\b\n\1\2\u00cb\u00cd\3\2\2\2\u00cc\u00b4"+
		"\3\2\2\2\u00cc\u00ba\3\2\2\2\u00cc\u00c2\3\2\2\2\u00cc\u00c6\3\2\2\2\u00cd"+
		"\23\3\2\2\2\u00ce\u00cf\7\6\2\2\u00cf\u00d0\7\22\2\2\u00d0\u00d1\7\23"+
		"\2\2\u00d1\u00d2\7\4\2\2\u00d2\u00d3\7-\2\2\u00d3\u00d4\7\5\2\2\u00d4"+
		"\u00d5\b\13\1\2\u00d5\25\3\2\2\2\u00d6\u00d7\7\13\2\2\u00d7\u00e4\b\f"+
		"\1\2\u00d8\u00d9\7\f\2\2\u00d9\u00e4\b\f\1\2\u00da\u00db\7\r\2\2\u00db"+
		"\u00e4\b\f\1\2\u00dc\u00dd\7\16\2\2\u00dd\u00e4\b\f\1\2\u00de\u00df\7"+
		"\17\2\2\u00df\u00e0\7\4\2\2\u00e0\u00e1\7)\2\2\u00e1\u00e2\7\5\2\2\u00e2"+
		"\u00e4\b\f\1\2\u00e3\u00d6\3\2\2\2\u00e3\u00d8\3\2\2\2\u00e3\u00da\3\2"+
		"\2\2\u00e3\u00dc\3\2\2\2\u00e3\u00de\3\2\2\2\u00e4\27\3\2\2\2\u00e5\u00e6"+
		"\7\24\2\2\u00e6\u00e7\7\n\2\2\u00e7\u00e8\7-\2\2\u00e8\u00e9\b\r\1\2\u00e9"+
		"\31\3\2\2\2\u00ea\u00eb\7\25\2\2\u00eb\u00ec\7\n\2\2\u00ec\u00ed\7-\2"+
		"\2\u00ed\u00ee\b\16\1\2\u00ee\33\3\2\2\2\u00ef\u00f0\7\26\2\2\u00f0\u00f1"+
		"\7\27\2\2\u00f1\u00f2\7-\2\2\u00f2\u00f3\7\30\2\2\u00f3\u00f4\7\4\2\2"+
		"\u00f4\u00f5\5\"\22\2\u00f5\u00f6\7\5\2\2\u00f6\u00f7\b\17\1\2\u00f7\u0105"+
		"\3\2\2\2\u00f8\u00f9\7\26\2\2\u00f9\u00fa\7\27\2\2\u00fa\u00fb\7-\2\2"+
		"\u00fb\u00fc\7\4\2\2\u00fc\u00fd\5\36\20\2\u00fd\u00fe\7\5\2\2\u00fe\u00ff"+
		"\7\30\2\2\u00ff\u0100\7\4\2\2\u0100\u0101\5\"\22\2\u0101\u0102\7\5\2\2"+
		"\u0102\u0103\b\17\1\2\u0103\u0105\3\2\2\2\u0104\u00ef\3\2\2\2\u0104\u00f8"+
		"\3\2\2\2\u0105\35\3\2\2\2\u0106\u0107\7-\2\2\u0107\u0108\7\6\2\2\u0108"+
		"\u0109\5\36\20\2\u0109\u010a\b\20\1\2\u010a\u010e\3\2\2\2\u010b\u010c"+
		"\7-\2\2\u010c\u010e\b\20\1\2\u010d\u0106\3\2\2\2\u010d\u010b\3\2\2\2\u010e"+
		"\37\3\2\2\2\u010f\u0110\t\2\2\2\u0110\u0114\b\21\1\2\u0111\u0112\7&\2"+
		"\2\u0112\u0114\b\21\1\2\u0113\u010f\3\2\2\2\u0113\u0111\3\2\2\2\u0114"+
		"!\3\2\2\2\u0115\u0116\5 \21\2\u0116\u0117\7\6\2\2\u0117\u0118\5\"\22\2"+
		"\u0118\u0119\b\22\1\2\u0119\u011e\3\2\2\2\u011a\u011b\5 \21\2\u011b\u011c"+
		"\b\22\1\2\u011c\u011e\3\2\2\2\u011d\u0115\3\2\2\2\u011d\u011a\3\2\2\2"+
		"\u011e#\3\2\2\2\u011f\u0120\7\31\2\2\u0120\u0121\7\32\2\2\u0121\u0122"+
		"\7-\2\2\u0122\u0123\7\33\2\2\u0123\u0124\5*\26\2\u0124\u0125\b\23\1\2"+
		"\u0125%\3\2\2\2\u0126\u0127\7-\2\2\u0127\u0130\b\24\1\2\u0128\u0129\7"+
		"-\2\2\u0129\u012a\7\7\2\2\u012a\u012b\7-\2\2\u012b\u0130\b\24\1\2\u012c"+
		"\u012d\5 \21\2\u012d\u012e\b\24\1\2\u012e\u0130\3\2\2\2\u012f\u0126\3"+
		"\2\2\2\u012f\u0128\3\2\2\2\u012f\u012c\3\2\2\2\u0130\'\3\2\2\2\u0131\u0132"+
		"\5&\24\2\u0132\u0133\t\3\2\2\u0133\u0134\5&\24\2\u0134\u0135\b\25\1\2"+
		"\u0135)\3\2\2\2\u0136\u0137\5(\25\2\u0137\u0138\7!\2\2\u0138\u0139\5*"+
		"\26\2\u0139\u013a\b\26\1\2\u013a\u0144\3\2\2\2\u013b\u013c\5(\25\2\u013c"+
		"\u013d\7\"\2\2\u013d\u013e\5*\26\2\u013e\u013f\b\26\1\2\u013f\u0144\3"+
		"\2\2\2\u0140\u0141\5(\25\2\u0141\u0142\b\26\1\2\u0142\u0144\3\2\2\2\u0143"+
		"\u0136\3\2\2\2\u0143\u013b\3\2\2\2\u0143\u0140\3\2\2\2\u0144+\3\2\2\2"+
		"\u0145\u0146\7\34\2\2\u0146\u0147\7-\2\2\u0147\u0148\7\35\2\2\u0148\u0149"+
		"\7-\2\2\u0149\u014a\7,\2\2\u014a\u014b\5 \21\2\u014b\u014c\7\33\2\2\u014c"+
		"\u014d\5*\26\2\u014d\u014e\b\27\1\2\u014e-\3\2\2\2\u014f\u0150\7\36\2"+
		"\2\u0150\u0151\5\60\31\2\u0151\u0152\7\32\2\2\u0152\u0153\5\62\32\2\u0153"+
		"\u0154\b\30\1\2\u0154\u016c\3\2\2\2\u0155\u0156\7\36\2\2\u0156\u0157\5"+
		"\60\31\2\u0157\u0158\7\32\2\2\u0158\u0159\5\62\32\2\u0159\u015a\7\33\2"+
		"\2\u015a\u015b\5*\26\2\u015b\u015c\b\30\1\2\u015c\u016c\3\2\2\2\u015d"+
		"\u015e\7\36\2\2\u015e\u015f\7\b\2\2\u015f\u0160\7\32\2\2\u0160\u0161\5"+
		"\62\32\2\u0161\u0162\b\30\1\2\u0162\u016c\3\2\2\2\u0163\u0164\7\36\2\2"+
		"\u0164\u0165\7\b\2\2\u0165\u0166\7\32\2\2\u0166\u0167\5\62\32\2\u0167"+
		"\u0168\7\33\2\2\u0168\u0169\5*\26\2\u0169\u016a\b\30\1\2\u016a\u016c\3"+
		"\2\2\2\u016b\u014f\3\2\2\2\u016b\u0155\3\2\2\2\u016b\u015d\3\2\2\2\u016b"+
		"\u0163\3\2\2\2\u016c/\3\2\2\2\u016d\u016e\7-\2\2\u016e\u016f\7\6\2\2\u016f"+
		"\u0170\5\60\31\2\u0170\u0171\b\31\1\2\u0171\u0180\3\2\2\2\u0172\u0173"+
		"\7-\2\2\u0173\u0174\7\7\2\2\u0174\u0175\7-\2\2\u0175\u0176\7\6\2\2\u0176"+
		"\u0177\5\60\31\2\u0177\u0178\b\31\1\2\u0178\u0180\3\2\2\2\u0179\u017a"+
		"\7-\2\2\u017a\u0180\b\31\1\2\u017b\u017c\7-\2\2\u017c\u017d\7\7\2\2\u017d"+
		"\u017e\7-\2\2\u017e\u0180\b\31\1\2\u017f\u016d\3\2\2\2\u017f\u0172\3\2"+
		"\2\2\u017f\u0179\3\2\2\2\u017f\u017b\3\2\2\2\u0180\61\3\2\2\2\u0181\u0182"+
		"\7-\2\2\u0182\u0183\7\37\2\2\u0183\u0184\7-\2\2\u0184\u0185\7 \2\2\u0185"+
		"\u0186\7-\2\2\u0186\u0187\7\7\2\2\u0187\u0188\7-\2\2\u0188\u0189\7,\2"+
		"\2\u0189\u018a\7-\2\2\u018a\u018b\7\7\2\2\u018b\u018c\7-\2\2\u018c\u0190"+
		"\b\32\1\2\u018d\u018e\7-\2\2\u018e\u0190\b\32\1\2\u018f\u0181\3\2\2\2"+
		"\u018f\u018d\3\2\2\2\u0190\63\3\2\2\2\34<AGMSY_ekqw}\u0083\u0087\u00b2"+
		"\u00cc\u00e3\u0104\u010d\u0113\u011d\u012f\u0143\u016b\u017f\u018f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}