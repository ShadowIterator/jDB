import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;

public class Frontend {
    public static void main(String[] args) throws IOException, Exception {
        MetadataManager mgr = new MetadataManager();
        mgr.init("data_meta.jDB");
        mgr.createDatabase("default");
        mgr.checkoutDatabase("default");
        ParseTree tree;
        try {
            InputStream is = new FileInputStream("example/test.schema");
            ANTLRInputStream input = new ANTLRInputStream(is);
            SimpleSQLLexer lexer = new SimpleSQLLexer(input);
            lexer.removeErrorListeners();
            lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            SimpleSQLParser parser = new SimpleSQLParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);

            tree = parser.commands();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return;
        }

        ArrayList<SQLExecutor> sqlExecutorList = ((SimpleSQLParser.CommandsContext)tree).sqlExecutorList;
//        for(SQLExecutor sqlExecutor: sqlExecutorList) {
//            sqlExecutor.printExecutor();
//        }
        System.out.println("------------------- Execute Result -------------------");
        for(SQLExecutor sqlExecutor: sqlExecutorList) {
            SQLResult sqlResult = sqlExecutor.execute(mgr);
            sqlResult.print();
        }

//        System.out.println("LISP:");
//        System.out.println(tree.toStringTree(parser));

//        System.out.println("Visitor:");
//        SimpleSQLVisitor SQLVisitor = new SimpleSQLBaseVisitor();
//        SQLVisitor.visit(tree);
//        SQLVisitor sqlVisitor = new SQLVisitor();
//        System.out.println(sqlVisitor.visit(tree));
    }
}