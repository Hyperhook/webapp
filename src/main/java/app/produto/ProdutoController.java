package app.produto;

import app.login.*;
import app.util.*;
import spark.*;
import java.util.*;
import static app.Application.produtoDao;
import static app.util.JsonUtil.*;
import static app.util.RequestUtil.*;

public class ProdutoController {

    public static Route fetchAllBooks = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            model.put("books", produtoDao.getAllBooks());
            return ViewUtil.render(request, model, Path.Template.BOOKS_ALL);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(produtoDao.getAllBooks());
        }
        return ViewUtil.notAcceptable.handle(request, response);
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
}
