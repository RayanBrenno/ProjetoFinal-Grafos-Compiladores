# 🔍 Projeto — Analisador de Grafos (JFlex + CUP)

Este projeto implementa um analisador léxico e sintático utilizando **JFlex** e **JavaCUP**, com o objetivo de processar uma linguagem de entrada customizada para a construção e validação de **grafos direcionados e não direcionados**.

---

## ⚙️ Tecnologias Utilizadas

- **JFlex** — geração do analisador léxico
- **JavaCUP** — geração do analisador sintático
- **Java** — linguagem base da implementação

---

## 📌 Funcionalidades

- Reconhecimento e construção automática de grafos a partir de comandos textuais
- Suporte a:
  - 🔁 **Grafos direcionados** (`directed`)
  - 🔁 **Grafos não direcionados** (`undirected`)
- Validação semântica:
  - ❌ Deteção de vértices duplicados
  - ❌ Deteção de arestas duplicadas
  - ❌ Verificação de arestas com vértices inexistentes
- Geração de **matriz de adjacência** em arquivo `.txt`
- Registro de **erros semânticos e sintáticos** com indicação precisa de **linha e coluna**
- Exibição de mensagens de análise via terminal (modo interativo/log de ações)

---

## 📥 Estrutura de Entrada (Exemplo de `input.txt`)

```txt
GRAPH:
directed
vertex A
vertex B
vertex C
edge A -> B
edge B -> C
edge C -> A
print adjacency

---

## 📤 Saídas

matriz_adjacencia.txt → matriz de adjacência do grafo processado

erros.log → log contendo todos os erros detectados com linha e coluna

Terminal → mensagens de feedback sobre a construção do grafo e validações
