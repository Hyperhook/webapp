package app.util;

import lombok.*;

public class Path {

    // The @Getter methods are needed in order to access
    // the variables from Velocity Templates
    public static class Web {
        @Getter public static final String INDEX = "/";
        @Getter public static final String LOGIN = "/login/";
        @Getter public static final String LOGOUT = "/logout/";
        @Getter public static final String BOOKS = "/books/";
        @Getter public static final String ONE_BOOK = "/books/:isbn/";
        @Getter public static final String CADASTROPROD = "/cadproduto/";
        @Getter public static final String LISTAPRODBAS = "/produtobas/";
        @Getter public static final String LISTAPRODFUT = "/produtofut/";
        @Getter public static final String LISTAPRODTEN = "/produtoten/";
        @Getter public static final String LISTAPRODVOL = "/produtovol/";
        @Getter public static final String CARRINHO = "/carrinho/";
        @Getter public static final String CADASTROCLIENTE = "/cadcliente/";
    }

    public static class Template {
        public final static String INDEX = "/velocity/index/index.html";
        public final static String LOGIN = "/velocity/login/login.vm";
        public final static String BOOKS_ALL = "/velocity/produto/all.vm";
        public static final String BOOKS_ONE = "/velocity/produto/one.vm";
        public static final String NOT_FOUND = "/velocity/notFound.vm";
        public static final String CADASTROPROD = "/velocity/produto/CadastroProduto";
        public static final String LISTAPRODBAS = "/velocity/produto/ListaProdBas.html";
        public static final String LISTAPRODFUT = "/velocity/produto/ListaProdFut/";
        public static final String LISTAPRODTEN = "/velocity/produto/ListaProdTen/";
        public static final String LISTAPRODVOL = "/velocity/produto/ListaProdVol/";
        public static final String CARRINHO = "/velocity/Carrinho.html";
        public static final String CADASTROCLIENTE = "/velocity/cadcliente/";

    }

}
