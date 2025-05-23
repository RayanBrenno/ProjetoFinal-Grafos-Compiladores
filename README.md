# 🔍 Projeto Analisador de Grafos (JFlex + CUP)

Este projeto implementa um analisador léxico e sintático capaz de processar uma linguagem de entrada específica para construção de **grafos direcionados e não direcionados**, utilizando **JFlex** para o analisador léxico e **JavaCUP** para o analisador sintático.

---

## 📌 Funcionalidades

- Reconhecimento e construção de grafos com base em comandos textuais
- Suporte a:
  - Grafos direcionados (`directed`)
  - Grafos não direcionados (`undirected`)
- Verificação de:
  - Vértices duplicados
  - Arestas duplicadas
  - Arestas com vértices inexistentes
- Geração de **matriz de adjacência** no arquivo `.txt`
- Log de erros semânticos com posição (linha e coluna)
- Feedback visual via terminal

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
