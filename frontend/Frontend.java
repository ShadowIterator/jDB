import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;

public class Frontend {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("example/test.schema");
        ANTLRInputStream input = new ANTLRInputStream(is);
        SimpleSQLLexer lexer = new SimpleSQLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleSQLParser parser = new SimpleSQLParser(tokens);
        ParseTree tree = parser.commands();

        ArrayList<SQLExecutor> sqlExecutorList = ((SimpleSQLParser.CommandsContext)tree).sqlExecutorList;
        for(SQLExecutor sqlExecutor: sqlExecutorList) {
            sqlExecutor.printExecutor();
        }

        System.out.println("LISP:");
        System.out.println(tree.toStringTree(parser));

//        System.out.println("Visitor:");
//        SimpleSQLVisitor SQLVisitor = new SimpleSQLBaseVisitor();
//        SQLVisitor.visit(tree);
//        SQLVisitor sqlVisitor = new SQLVisitor();
//        System.out.println(sqlVisitor.visit(tree));
    }
}