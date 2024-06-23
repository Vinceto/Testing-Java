package Vinceto.D35.SistemaClientes.servicio;

import Vinceto.D35.SistemaClientes.modelo.Cliente;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ExportadorTxt {
    private static final String BASE_PATH = "src/main/java/Vinceto/D35/SistemaClientes/";

    public void exportar(String fileName, List<Cliente> listaClientes) {
        String filePath = BASE_PATH + fileName;

        Path path = Paths.get(filePath).getParent(); // Obtener la ruta del directorio

        try {
            // Verificar si el directorio existe, si no, crearlo
            if (path != null && !Files.exists(path)) {
                Files.createDirectories(path);
            }

            try (FileWriter writer = new FileWriter(filePath)) {
                for (Cliente cliente : listaClientes) {
                    writer.write(cliente.toString() + "\n");
                }
                System.out.println("Datos exportados correctamente a: " + filePath);
            }
        } catch (IOException e) {
            System.err.println("Error al exportar a TXT: " + e.getMessage());
        }
    }
}