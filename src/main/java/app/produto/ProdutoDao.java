package app.produto;

import com.google.common.collect.*;

import java.lang.reflect.Array;
import java.util.*;

public class ProdutoDao {

    private final List<Produto> produtos = ImmutableList.of(
            new Produto("Moby Dick", "Herman Melville", "9789583001215"),
            new Produto("A Christmas Carol", "Charles Dickens", "9780141324524"),
            new Produto("Pride and Prejudice", "Jane Austen", "9781936594290"),
            new Produto("The Fellowship of The Ring", "J. R. R. Tolkien", "0007171978"),
            new Produto("Harry Potter", "J. K. Rowling", "0747532699"),
            new Produto("War and Peace", "Leo Tolstoy", "9780060798871"),
            new Produto("Don Quixote", "Miguel Cervantes", "9789626345221"),
            new Produto("Ulysses", "James Joyce", "9780394703800"),
            new Produto("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"),
            new Produto("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "9780060531041"),
            new Produto("The adventures of Huckleberry Finn", "Mark Twain", "9781591940296"),
            new Produto("Alice In Wonderland", "Lewis Carrol", "9780439291491")
    );

    public List<Produto> carrinho = new ArrayList<>();

    public Iterable<Produto> getAllBooks() {
        return produtos;
    }

    public Produto getBookByIsbn(String isbn) {
        return produtos.stream().filter(b -> b.getTitle().equals(isbn)).findFirst().orElse(null);
    }

    public Produto getRandomBook() {
        return produtos.get(new Random().nextInt(produtos.size()));
    }
}


