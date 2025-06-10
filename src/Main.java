//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import service.MainService;
import view.MainView;
import view.View;

/*

Dependency Inversion Principle
Injeção Correta:
public interface IProdutoDAO {
    void save(Produto produto);
    Collection<Produto> findAll();
    void delete(int id);
}


public class ProdutoDAO implements IProdutoDAO {
    // Implementações dos métodos
}

public class ProdutoService {
    private IProdutoDAO produtoDAO;

    public ProdutoService(IProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    // Demais métodos...
}

public class Main {
    public static void main(String[] args) {
        IProdutoDAO produtoDAO = new ProdutoDAO(); // Dependência concreta instanciada no "nível alto"
        ProdutoService produtoService = new ProdutoService(produtoDAO);
        produtoService.salvar();
    }
}


Single Responsibility Principle


*/
public class Main {
    public static void main(String[] args) {
        MainView view = new MainView();
        MainService service = new MainService(view);

        service.capturar();
    }
}