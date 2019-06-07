grammar SimpleSQL;
@header {
import java.util.ArrayList;
import javafx.util.Pair;
}
options {
    language=Java;    // Set target language
}
// Parser Rules
commands returns [ArrayList<SQLExecutor> sqlExecutorList]
              : {$sqlExecutorList = new ArrayList<SQLExecutor>();}
                s=sql {$sqlExecutorList.add($s.sqlExecutor);}
                (ns=sql {$sqlExecutorList.add($ns.sqlExecutor);})*
              ;
sql returns [SQLExecutor sqlExecutor]
              : create_table (';')?
                {
                    $sqlExecutor = $create_table.createSqlExec;
                }
              | drop_table (';')?
                {
                    $sqlExecutor = $drop_table.dropSqlExec;
                }
              | show_table (';')?
                {
                    $sqlExecutor = $show_table.showSqlExec;
                }
              | insert_into (';')?
                {
                    $sqlExecutor = $insert_into.insertSqlExec;
                }
              | delete_from (';')?
                {
                    $sqlExecutor = $delete_from.deleteSqlExec;
                }
              | update_table (';')?
                {
                    $sqlExecutor = $update_table.updateSqlExec;
                }
              | select_table (';')?
                {
                    $sqlExecutor = $select_table.selectSqlExec;
                }
              | create_db (';')?
                {
                    $sqlExecutor = $create_db.createDBExec;
                }
              | drop_db (';')?
                {
                    $sqlExecutor = $drop_db.dropDBExec;
                }
              | use_db (';')?
                {
                    $sqlExecutor = $use_db.useDBExec;
                }
              | show_databases (';')?
                {
                    $sqlExecutor = $show_databases.showAllExec;
                }
              | show_database (';')?
                {
                    $sqlExecutor = $show_database.showDBExec;
                }
              ;

// // CREATE DATABASE
create_db returns [CreateDBExecutor createDBExec]
              : CREATE DATABASE ID
                {
                    $createDBExec = new CreateDBExecutor($ID.text);
                }
              ;

// // DROP DATABASE
drop_db returns [DropDBExecutor dropDBExec]
              : DROP DATABASE ID
                {
                    $dropDBExec = new DropDBExecutor($ID.text);
                }
              ;

// // USE DATABASE
use_db returns [UseDBExecutor useDBExec]
              : USE DATABASE ID
                {
                    $useDBExec = new UseDBExecutor($ID.text);
                }
              ;

// // SHOW DATABASES
show_databases returns [ShowAllDBExecutor showAllExec]
              : SHOW DATABASES
                {
                    $showAllExec = new ShowAllDBExecutor();
                }
              ;

// // SHOW DATABASE
show_database returns [ShowDBExecutor showDBExec]
              : SHOW DATABASE ID
                {
                    $showDBExec = new ShowDBExecutor($ID.text);
                }
              ;

// // CREATE TABLE
create_table returns [CreateSQLExecutor createSqlExec]
              : CREATE TABLE ID '(' attribute_list ')'
                {
                    $createSqlExec = new CreateSQLExecutor($ID.text, $attribute_list.attributeList, null);
                }
              | CREATE TABLE ID '(' attribute_list primary_key ')'
                {
                    $createSqlExec = new CreateSQLExecutor($ID.text, $attribute_list.attributeList, $primary_key.pkName);
                }
              ;
attribute_list returns [ArrayList<AttributeMeta> attributeList]
               : ID type ',' attribute_list
                 {
                     $attributeList = $attribute_list.attributeList;
                     $attributeList.add(0, new AttributeMeta($ID.text, $type.dataType, false));
                 }
               | ID type NOT NULL ',' attribute_list
                 {
                     $attributeList = $attribute_list.attributeList;
                     $attributeList.add(0, new AttributeMeta($ID.text, $type.dataType, true));
                 }
               | ID type
                 {
                     $attributeList = new ArrayList<AttributeMeta>();
                     $attributeList.add(0, new AttributeMeta($ID.text, $type.dataType, false));
                 }
               | ID type NOT NULL
                 {
                     $attributeList = new ArrayList<AttributeMeta>();
                     $attributeList.add(0, new AttributeMeta($ID.text, $type.dataType, true));
                 }
               ;
primary_key returns [String pkName]
              : ',' PRIMARY KEY '(' ID ')'
                {
                    $pkName = $ID.text;
                }
              ;
type returns [SQLDataType dataType]
              : INT
                {$dataType = new SQLDataType(-1, SQLDataType.Type.INT);}
              | LONG
                {$dataType = new SQLDataType(-1, SQLDataType.Type.LONG);}
              | FLOAT
                {$dataType = new SQLDataType(-1, SQLDataType.Type.FLOAT);}
              | DOUBLE
                {$dataType = new SQLDataType(-1, SQLDataType.Type.DOUBLE);}
              | STRING '(' NUMINT ')'
                {$dataType = new SQLDataType(Integer.parseInt($NUMINT.text), SQLDataType.Type.STRING);}
              ;

// // DROP TABLE
drop_table returns [DropSQLExecutor dropSqlExec]
              : DROP TABLE ID
                {
                    $dropSqlExec = new DropSQLExecutor($ID.text);
                }
              ;

// // SHOW TABLE
show_table returns [ShowSQLExecutor showSqlExec]
              : SHOW TABLE ID
                {
                    $showSqlExec = new ShowSQLExecutor($ID.text);
                }
              ;

// // INSERT INTO
insert_into returns [InsertSQLExecutor insertSqlExec]
              : INSERT INTO ID VALUES '(' value_list ')'
                {
                    $insertSqlExec = new InsertSQLExecutor($ID.text, null, $value_list.valueList);
                }
              | INSERT INTO ID '(' attribute_list_insert ')' VALUES '(' value_list ')'
                {
                    $insertSqlExec = new InsertSQLExecutor($ID.text, $attribute_list_insert.attributeList, $value_list.valueList);
                }
              ;
attribute_list_insert returns [ArrayList<String> attributeList]
              : ID ',' attribute_list_insert
                {
                    $attributeList = $attribute_list_insert.attributeList;
                    $attributeList.add(0, $ID.text);
                }
              | ID
                {
                    $attributeList = new ArrayList<String>();
                    $attributeList.add($ID.text);
                }
              ;
value_single returns [String value]
              : v=(NUMFLOAT|NUMINT|NUMFLOATNEG|NUMINTNEG)
                {
                    $value = $v.text;
                }
              | v=TEXT
                {
                    int length = $v.text.length();
                    $value = $v.text.substring(1, length-1);
                }
              ;
value_list returns [ArrayList<String> valueList]
              : value_single ',' value_list
                {
                    $valueList = $value_list.valueList;
                    $valueList.add(0, $value_single.value);
                }
              | value_single
                {
                    $valueList = new ArrayList<String>();
                    $valueList.add($value_single.value);
                }
              ;

// // DELETE FROM
delete_from returns [DeleteSQLExecutor deleteSqlExec]
              : DELETE FROM ID WHERE where_list
                {
                    $deleteSqlExec = new DeleteSQLExecutor($ID.text, $where_list.whereCondition);
                }
              ;

sql_value returns [SQLValue sqlValue]
              : ID
                {
                    $sqlValue = new SQLValue(null, $ID.text);
                }
              | t=ID '.' a=ID
                {
                    $sqlValue = new SQLValue($t.text, $a.text);
                }
              | value_single
                {
                    $sqlValue = new SQLValue($value_single.value);
                }
              ;

one_condition returns [OneCondition oneCondition]
              : l=sql_value op=(OP|OPE) r=sql_value
                {
                    WhereCondition.Operator _op = WhereCondition.Operator.EQ;
                    switch($op.text) {
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
                    $oneCondition = new OneCondition($l.sqlValue, $r.sqlValue, _op);
                }
              | NOT EXIST '(' select_table ')'
                {
                    $oneCondition = new NotExistCondition($select_table.selectSqlExec, false);
                }
              | EXIST '(' select_table ')'
                {
                    $oneCondition = new NotExistCondition($select_table.selectSqlExec, true);
                }
              ;

where_list returns [WhereCondition whereCondition]
              : one_condition AND where_list // deprecated!!
                {
                    $whereCondition = $where_list.whereCondition;
                    WhereCondition.LogicConnection _logic = WhereCondition.LogicConnection.AND;
                    $whereCondition.AddCondition($one_condition.oneCondition, _logic);
                }
              | one_condition OR where_list // deprecated!!
                {
                    $whereCondition = $where_list.whereCondition;
                    WhereCondition.LogicConnection _logic = WhereCondition.LogicConnection.OR;
                    $whereCondition.AddCondition($one_condition.oneCondition, _logic);
                }
              | one_condition
                {
                    $whereCondition = new WhereCondition();
                    $whereCondition.conditions.add($one_condition.oneCondition);
                }
              ;

// // UPDATE
update_table returns [UpdateSQLExecutor updateSqlExec]
              : UPDATE t=ID SET a=ID '=' value_single WHERE where_list
                {
                    $updateSqlExec = new UpdateSQLExecutor($t.text, $a.text, $value_single.value, $where_list.whereCondition);
                }
              ;

// // SELECT
select_table returns [SelectSQLExecutor selectSqlExec]
              : SELECT attribute_list_select FROM table_list_select
                {
                    $selectSqlExec = new SelectSQLExecutor();
                    $selectSqlExec.setAttributeList($attribute_list_select.attributeList);
                    $selectSqlExec.setTableJoin($table_list_select.tableJoin);
                }
              | SELECT attribute_list_select FROM table_list_select WHERE where_list
                {
                    $selectSqlExec = new SelectSQLExecutor();
                    $selectSqlExec.setAttributeList($attribute_list_select.attributeList);
                    $selectSqlExec.setTableJoin($table_list_select.tableJoin);
                    $selectSqlExec.setWhereCondition($where_list.whereCondition);
                }
              | SELECT '*' FROM table_list_select
                {
                    $selectSqlExec = new SelectSQLExecutor();
                    $selectSqlExec.setSelectAll(true);
                    $selectSqlExec.setTableJoin($table_list_select.tableJoin);
                }
              | SELECT '*' FROM table_list_select WHERE where_list
                {
                    $selectSqlExec = new SelectSQLExecutor();
                    $selectSqlExec.setSelectAll(true);
                    $selectSqlExec.setTableJoin($table_list_select.tableJoin);
                    $selectSqlExec.setWhereCondition($where_list.whereCondition);
                }
              ;
attribute_list_select returns [ArrayList<Pair<String, String> > attributeList]
                      : ID ',' attribute_list_select
                        {
                            Pair<String, String> newAttr = new Pair<>(null, $ID.text);
                            $attribute_list_select.attributeList.add(0, newAttr);
                            $attributeList = $attribute_list_select.attributeList;
                        }
                      | t=ID '.' a=ID ',' attribute_list_select
                        {
                            Pair<String, String> newAttr = new Pair<>($t.text, $a.text);
                            $attribute_list_select.attributeList.add(0, newAttr);
                            $attributeList = $attribute_list_select.attributeList;
                        }
                      | ID
                        {
                            Pair<String, String> newAttr = new Pair<>(null, $ID.text);
                            $attributeList = new ArrayList<Pair<String, String> >();
                            $attributeList.add(newAttr);
                        }
                      | t=ID '.' a=ID
                        {
                            Pair<String, String> newAttr = new Pair<>($t.text, $a.text);
                            $attributeList = new ArrayList<Pair<String, String> >();
                            $attributeList.add(newAttr);
                        }
                      ;
table_list_select returns [TableJoin tableJoin]
                      : f=ID JOIN s=ID ON ft=ID '.' fa=ID '=' st=ID '.' sa=ID
                        {
                            $tableJoin = new TableJoin();
                            $tableJoin.isJoin = true;
                            $tableJoin.firstTableName = $f.text;
                            $tableJoin.secondTableName = $s.text;
                            $tableJoin.onCondition = new WhereCondition();
                            SQLValue _leftValue = new SQLValue($ft.text, $fa.text);
                            SQLValue _rightValue = new SQLValue($st.text, $sa.text);
                            WhereCondition.Operator _op = WhereCondition.Operator.EQ;
                            OneCondition _oneCondition = new OneCondition(_leftValue, _rightValue, _op);
                            $tableJoin.onCondition.conditions.add(_oneCondition);
                        }
                      | f=ID LEFT OUTER JOIN s=ID ON ft=ID '.' fa=ID '=' st=ID '.' sa=ID
                        {
                            $tableJoin = new TableJoin();
                            $tableJoin.isJoin = true;
                            $tableJoin.firstTableName = $f.text;
                            $tableJoin.secondTableName = $s.text;
                            $tableJoin.onCondition = new WhereCondition();
                            $tableJoin.setJoinType(0);
                            SQLValue _leftValue = new SQLValue($ft.text, $fa.text);
                            SQLValue _rightValue = new SQLValue($st.text, $sa.text);
                            WhereCondition.Operator _op = WhereCondition.Operator.EQ;
                            OneCondition _oneCondition = new OneCondition(_leftValue, _rightValue, _op);
                            $tableJoin.onCondition.conditions.add(_oneCondition);
                          }
                      | f=ID RIGHT OUTER JOIN s=ID ON ft=ID '.' fa=ID '=' st=ID '.' sa=ID
                        {
                            $tableJoin = new TableJoin();
                            $tableJoin.isJoin = true;
                            $tableJoin.firstTableName = $f.text;
                            $tableJoin.secondTableName = $s.text;
                            $tableJoin.onCondition = new WhereCondition();
                            $tableJoin.setJoinType(1);
                            SQLValue _leftValue = new SQLValue($ft.text, $fa.text);
                            SQLValue _rightValue = new SQLValue($st.text, $sa.text);
                            WhereCondition.Operator _op = WhereCondition.Operator.EQ;
                            OneCondition _oneCondition = new OneCondition(_leftValue, _rightValue, _op);
                            $tableJoin.onCondition.conditions.add(_oneCondition);
                        }
                      | ID
                        {
                            $tableJoin = new TableJoin();
                            $tableJoin.isJoin = false;
                            $tableJoin.firstTableName = $ID.text;
                        }
                      | '(' select_table ')' AS ID
                        {
                            $tableJoin = new SubSelectTable($select_table.selectSqlExec, $ID.text);
                        }
                      ;

// Lexer Rules
fragment A : ('A'|'a');
fragment B : ('B'|'b');
fragment C : ('C'|'c');
fragment D : ('D'|'d');
fragment E : ('E'|'e');
fragment F : ('F'|'f');
fragment G : ('G'|'g');
fragment H : ('H'|'h');
fragment I : ('I'|'i');
fragment J : ('J'|'j');
fragment K : ('K'|'k');
fragment L : ('L'|'l');
fragment M : ('M'|'m');
fragment N : ('N'|'n');
fragment O : ('O'|'o');
fragment P : ('P'|'p');
fragment Q : ('Q'|'q');
fragment R : ('R'|'r');
fragment S : ('S'|'s');
fragment T : ('T'|'t');
fragment U : ('U'|'u');
fragment V : ('V'|'v');
fragment W : ('W'|'w');
fragment X : ('X'|'x');
fragment Y : ('Y'|'y');
fragment Z : ('Z'|'z');

fragment DIGIT : [0-9];
fragment SINQ  : ('\'') ('\\\''|.)*? ('\'');
fragment DOUQ  : ('"') ('\\"'|.)*? ('"');

CREATE     : C R E A T E;
TABLE      : T A B L E;
INT        : I N T;
LONG       : L O N G;
FLOAT      : F L O A T;
DOUBLE     : D O U B L E;
STRING     : S T R I N G;
NOT        : N O T;
NULL       : N U L L;
PRIMARY    : P R I M A R Y;
KEY        : K E Y;
DROP       : D R O P;
SHOW       : S H O W;
INSERT     : I N S E R T;
INTO       : I N T O;
VALUES     : V A L U E S;
DELETE     : D E L E T E;
FROM       : F R O M;
WHERE      : W H E R E;
UPDATE     : U P D A T E;
SET        : S E T;
SELECT     : S E L E C T;
JOIN       : J O I N;
ON         : O N;
AND        : A N D;
OR         : O R;
DATABASE   : D A T A B A S E;
USE        : U S E;
DATABASES  : D A T A B A S E S;
OUTER      : O U T E R;
LEFT       : L E F T;
RIGHT      : R I G H T;
AS         : A S;
EXIST      : E X I S T S;

TEXT       : (SINQ | DOUQ);
NUMFLOAT   : DIGIT+ [.] (DIGIT+)?;
NUMFLOATNEG: '-' (DIGIT+) [.] (DIGIT+)?;
NUMINT     : DIGIT+;
NUMINTNEG  : '-' (DIGIT+);
OP         : ('>'|'>='|'<'|'<='|'<>');
OPE        : '=';
ID         : ([a-z]|[A-Z]|'_')([a-z]|[A-Z]|'_'|[0-9])*;
WS         : [ \n\t\r]+ -> skip;