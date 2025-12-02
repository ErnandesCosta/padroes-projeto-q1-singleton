import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    // Instância única da classe (Singleton)
    private static ConfigManager instance;
    // Armazena as configurações em memória
    private Map<String, String> properties;

    // Construtor privado: impede criação direta de instâncias
    private ConfigManager() {
        properties = new HashMap<>();
        loadConfiguration("config.txt");
    }

    // Ponto de acesso global à instância única
    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    // VERSÃO INICIAL GERADA PELA IA
    private void loadConfiguration(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assume que sempre existe "chave=valor"
                String[] parts = line.split("=");
                properties.put(parts[0].trim(), parts[1].trim());
            }
        } catch (Exception e) {
            // Apenas imprime o erro (vamos usar isso para ver o bug depois)
            e.printStackTrace();
        }
    }

    public void printAll() {
        if (properties.isEmpty()) {
            System.out.println("Nenhuma configuração carregada (pode ter ocorrido erro na leitura).");
        } else {
            properties.forEach((k, v) -> System.out.println(k + " -> " + v));
        }
    }
}
