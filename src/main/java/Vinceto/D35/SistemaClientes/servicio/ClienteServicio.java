package Vinceto.D35.SistemaClientes.servicio;
import Vinceto.D35.SistemaClientes.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteServicio {
    private List<Cliente> listaClientes;

    public ClienteServicio() {
        this.listaClientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public Cliente buscarCliente(String run) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getRunCliente().equalsIgnoreCase(run)) {
                return cliente;
            }
        }
        return null;
    }

    public void listarClientes() {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}
