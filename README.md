# Sistema de Cadastros de usuários

Este projeto vai ser constantemente atualizado sempre implementando mais funcionalidades, estou utilizando o pojeto para treinar conceitos em java. 
Ele consiste em um sistema de cadastros de usuário com autenticação via console (por enquanto) desenvolvido em Java, focado na segurança do usuário e na integridade do acesso. A aplicação simula um banco de dados em memória para gerenciar cadastros e validar logins com políticas de segurança contra ataques de força bruta.

## 📌 Contextualização

No cenário atual de desenvolvimento de software, a segurança da informação é uma prioridade crítica. Este projeto foi concebido para demonstrar a aplicação prática de conceitos de **Lógica de Programação**, **Estruturas de Dados (HashMap)** e **Regras de Negócio de Segurança**, como o bloqueio temporário de contas após múltiplas tentativas de acesso inválidas.

## 🚀 Funcionalidades Principais

* **Cadastro de Usuários:** Permite o registro de novos usuários garantindo a unicidade do ID de acesso.
* **Autenticação Segura:** Sistema de login que valida as credenciais em tempo real.
* **Trava de Segurança Exponencial:** * Após **3 tentativas falhas**, o usuário é bloqueado por **5 minutos**.
    * Tentativas subsequentes incorretas aplicam um multiplicador de tempo, aumentando o período de espera.
* **Gerenciamento de Estado:** Monitoramento dinâmico de tentativas e horários de desbloqueio utilizando a API `java.time`.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (Versão 8 ou superior)
* **Estrutura:** `java.util.HashMap` para armazenamento otimizado de dados.
* **Tempo/Data:** `java.time.LocalDateTime` para controle de períodos de bloqueio.
