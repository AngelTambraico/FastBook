package fb.daos;
import fb.daos.PedidoDaoMemory;
import fb.model.Pedido;
import fb.service.EntidadService;
import fb.util.Constantes;

public class PedidoDaoFactory {
    private static PedidoDaoFactory fabrica;

    private PedidoDaoFactory() {}

    public static PedidoDaoFactory getFabrica() {
        if (fabrica == null) {
            fabrica = new PedidoDaoFactory();
        }
        return fabrica;
    }

    public EntidadService<Pedido> getAutorDao(int tipo) {
        EntidadService<Pedido> e = null;
        switch (tipo) {
            case Constantes.MEMO:
                e = PedidoDaoMemory.getInstancia();
                break;
        }
        return e;
    }
}