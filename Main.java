public class Main {
    public static void main(String[] args) {
        System.out.println("--- Iniciando leitura de configuração ---");
        ConfigManager config = ConfigManager.getInstance();

        System.out.println("--- Configurações carregadas ---");
        config.printAll();
    }
}
