import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap; // <--- MUDANÇA 1: Importar LinkedHashMap
import java.util.Map;

public class ConfigManager {
    private static ConfigManager instance;
    private Map<String, String> properties;

    private ConfigManager() {
        // MUDANÇA 2: Usar LinkedHashMap para MANTER A ORDEM do arquivo
        properties = new LinkedHashMap<>(); 
        loadConfiguration("config.txt");
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    private void loadConfiguration(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split("=", 2);
                String key = parts[0].trim();
                String value = "";

                if (parts.length > 1) {
                    value = parts[1].trim();
                }

                properties.put(key, value);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public void printAll() {
        if (properties.isEmpty()) {
            System.out.println("Erro: Nenhuma configuração carregada.");
        } else {
            // Agora vai imprimir na ordem correta
            properties.forEach((k, v) -> System.out.println(k + "=" + v));
        }
    }
}