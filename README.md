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