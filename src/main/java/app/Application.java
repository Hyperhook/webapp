package app;

import app.produto.*;
import app.index.*;
import app.login.*;
import app.user.*;
import app.util.*;
import static spark.Spark.*;
import static spark.debug.DebugScreen.*;

public class Application {

    // Declare dependencies
    public static ProdutoDao produtoDao;
    public static UserDao userDao;

    public static void main(String[] args) {

        produtoDao = new ProdutoDao();
        userDao = new UserDao();

        // Configure Spark
        port(8080);
        staticFiles.location("public");
        staticFiles.expireTime(600L);
        enableDebugScreen();

        // Set up before-filters (called before each get/post)
        before("*",                  Filters.addTrailingSlashes);
        before("*",                  Filters.handleLocaleChange);

        // Set up routes
        get(Path.Web.INDEX,          IndexController.serveIndexPage);
        get(Path.Web.BOOKS,          ProdutoController.fetchAll);
        get(Path.Web.CARRINHO,       ProdutoController.carrinho);
        get(Path.Web.ONE_BOOK,       ProdutoController.fetchOneBook);
        get(Path.Web.CADASTROPROD,   ProdutoController.CadastroProd);
        get(Path.Web.LOGIN,          LoginController.serveLoginPage);
        post(Path.Web.LOGIN,         LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,        LoginController.handleLogoutPost);
        get(Path.Web.LISTAPRODBAS,   ProdutoController.ProdBas);


        get("*",                     ViewUtil.notFound);

        //Set up after-filters (called after each get/post)
        after("*",                   Filters.addGzipHeader);

    }

}
