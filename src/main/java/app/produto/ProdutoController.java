package app.produto;

import app.login.*;
import app.util.*;
import spark.*;
import java.util.*;
import static app.Application.produtoDao;
import static app.util.JsonUtil.*;
import static app.util.RequestUtil.*;

public class ProdutoController {

    public static Route fetchAll = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            model.put("produtos", produtoDao.getAllBooks());
            return ViewUtil.render(request, model, Path.Template.BOOKS_ALL);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(produtoDao.getAllBooks());
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route carrinho = (Request req, Response res) -> {
//        LoginController.ensureUserIsLoggedIn(req, res);
//        if (clientAcceptsHtml(req)){
//            HashMap<String, Object> model = new HashMap<>();
//            model.put("items", produtoDao.getAllBooks());
//        }
        return ViewUtil.render(req, new HashMap<>(), Path.Template.CARRINHO);
    };

    public static Route fetchOneBook = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            Produto produto = produtoDao.getBookByIsbn(getParamIsbn(request));
            model.put("produto", produto);
            return ViewUtil.render(request, model, Path.Template.BOOKS_ONE);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(produtoDao.getBookByIsbn(getParamIsbn(request)));
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };
    public static Route CadastroProd = (Request request, Response response) -> {
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();

            Produto produto = produtoDao.getBookByIsbn(getParamIsbn(request));

            model.put("cadproduto", produto);
            return ViewUtil.render(request, model, Path.Template.CADASTROPROD);
        }
        if (clientAcceptsJson(request)) {

        }
        return ViewUtil.notAcceptable.handle(request, response);
    };
    public static Route ProdBas = (Request request, Response response) -> {
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();

            Produto produto = produtoDao.getBookByIsbn(getParamIsbn(request));

            model.put("produtobas", produto);
            return ViewUtil.render(request, model, Path.Template.LISTAPRODBAS);
        }
        if (clientAcceptsJson(request)) {

        }
        return ViewUtil.notAcceptable.handle(request, response);
    };
}
