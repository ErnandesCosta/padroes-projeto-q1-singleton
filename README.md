# Questão 1 – Padrão Singleton para Leitura de Configuração

---

## 📌Enunciado

# 📝 Enunciado – Questão de Configuração com Padrão Singleton

## 🔧 Configuração

Vários tipos de software mantêm arquivos de configuração/propriedades centralizados por conta dos benefícios de **consistência** e **desempenho**. Isso evita que vários usuários acessem e leiam repetidamente o arquivo.

O software cria **uma única instância** do arquivo de configuração, que pode ser acessada simultaneamente por diversas partes do sistema. Essa instância fornece dados estáticos carregados em memória. Assim:

- O arquivo de configuração é lido **apenas uma vez**.
- Nas chamadas seguintes, os componentes do software acessam diretamente os dados já carregados na memória.

---

## 🎯 Tarefa

Usando o **Padrão Singleton**, escreva um programa que:

1. **Lê o arquivo de configuração** de um jogo.
2. **Armazena seu conteúdo em memória**.
3. **Imprime todos os dados** do arquivo.
4. Representa o conteúdo em **uma classe modelo** que representa o arquivo de configuração.
5. Permite que outros componentes acessem individualmente cada campo da configuração.

---

## 📄 Exemplo de arquivo de configuração (`config.txt`)

```txt
AppId=1649240
UserName=elamigos
Language=brazilian
Offline=0
AutoDLC=0
BuildId=10547147
DLCName=Returnal Pre-Purchase Entitlement
UpdateDB=1
Signature=FitGirl
WindowInfo=LAAAAAAAAAAIP50AAACIAAAATQMAAJACAAA=
LVWindowInfo=AwAAADEBAAByAAAApQAAAA==
ApplicationPath=../../../Returnal.exe
WorkingDirectory=
WaitForExit=1
NoOperation=0

---

## 🧩 Estrutura da solução

- `ConfigManager.java`  
  Classe Singleton responsável por:
  - Ler o arquivo `config.txt` uma única vez.
  - Armazenar as configurações em um `LinkedHashMap<String, String>` (preserva a ordem do arquivo).

- `Main.java`  
  Classe principal que:
  - Obtém a instância única via `ConfigManager.getInstance()`.
  - Chama `printAll()` para exibir todas as configurações.

- `config.txt`  
  Arquivo de configuração com pares `chave=valor`, incluindo a linha `WorkingDirectory=` (sem valor), usada para testar o tratamento de campos vazios.

---

## 🧠 Uso de IA e correções manuais

1. **Versão inicial gerada por IA**  
   - A IA criou `ConfigManager` usando `split("=")` de forma ingênua.  
   - Essa solução assumia que todas as linhas teriam sempre `chave=valor`.  
   - Ao ler `WorkingDirectory=`, ocorria `ArrayIndexOutOfBoundsException`.

2. **Cenário de erro com dados reais**  
   - Foi adicionada uma `Main` e um `config.txt` real.  
   - Executando o programa, o erro apareceu, evidenciando a limitação da solução da IA.

3. **Ajustes humanos (refatoração)**  
   - O método `loadConfiguration` foi refatorado para usar `split("=", 2)`, preservando valores vazios.  
   - Foi adicionada verificação de tamanho do array para não acessar índices inválidos.  
   - O `LinkedHashMap` passou a ser usado para manter a ordem original das entradas.  

---

## 📚 Prompts utilizados 

- "De acordo com esse enunciado, faça passo a passo e com explicações."
- "Quero que conserte o texto e deixe na ordem da questão."