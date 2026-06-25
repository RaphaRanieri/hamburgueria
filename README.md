# Hamburgueria - Sistema de Pedidos

Sistema de gerenciamento de pedidos para uma hamburgueria, desenvolvido em Java com aplicação de múltiplos padrões de projeto (Design Patterns).

Raphaella Ranieri de abreu senra

## Padrões de Projeto Utilizados

| Padrão | Pacote | Descrição |
|---|---|---|
| **Builder** | `cardapio` | Montagem de lanches e combos do cardápio |
| **Decorator** | `adicional` | Personalização de lanches com bacon, queijo e versão sem glúten |
| **Strategy** | `precificacao` | Regras de desconto (estudante, fidelidade, sem desconto) |
| **Command** | `pedido` | Operações de adicionar/remover itens com histórico e desfazer |
| **Chain of Responsibility** | `fluxo` | Fluxo de processamento: verificação de itens → estoque → pagamento → cozinha |
| **Mediator** | `comunicacao` | Comunicação entre os setores: caixa, cozinha, entrega e cliente |
| **Singleton** | `config` | Configuração única do restaurante compartilhada por toda a aplicação |

## Estrutura do Projeto

```
src/main/java/com/hamburgueria/
├── adicional/       # Decorator - personalizações de lanche
├── calculo/         # Totalizadores de preço e imposto
├── cardapio/        # Builder - montagem de lanches e combos
├── comunicacao/     # Mediator - central de mensagens entre setores
├── config/          # Singleton - configuração do restaurante
├── cozinha/         # Serviço de cozinha com controle de acesso
├── entrega/         # Integração com plataforma logística
├── fila/            # Fila de pedidos
├── fluxo/           # Chain of Responsibility - processamento de pedidos
├── model/           # Modelos de domínio
├── pagamento/       # Formas de pagamento (cartão, Pix, parcelado)
├── pedido/          # Command - operações sobre o pedido
├── precificacao/    # Strategy - regras de desconto
└── sistema/         # Classe principal da hamburgueria
```

## Tecnologias

- Java 17
- Maven
- JUnit 5

## Como Executar

**Pré-requisitos:** Java 17+ e Maven instalados.

```bash
# Compilar
mvn compile

# Executar os testes
mvn test

# Compilar e gerar o JAR
mvn package

# Executar
java -cp target/hamburgueria-1.0-SNAPSHOT.jar com.hamburgueria.Main
```

## Fluxo de um Pedido

1. Cliente escolhe o lanche via **Builder** (Clássico, Premium ou Veggie)
2. Personalizações são adicionadas via **Decorator** (bacon, queijo, sem glúten)
3. Desconto é aplicado via **Strategy** (estudante, fidelidade ou sem desconto)
4. Itens são adicionados ao pedido via **Command** (com suporte a desfazer)
5. Pedido entra na **fila** de processamento
6. **Chain of Responsibility** processa: verifica itens → estoque → aprovação de pagamento → envio para cozinha
7. **Mediator** coordena a comunicação entre caixa, cozinha, entrega e cliente
