pedi para IA modificar o desafio backend Itaú e deu isso:

🧩 Desafio Backend Simplificado – “Controle de Pedidos”
1. Introdução

Sua missão é criar uma API REST para gerenciar pedidos de compra simples. A API deve permitir:

Criar pedidos

Listar pedidos

Calcular o valor total dos pedidos

Use Java ou Kotlin com Spring Boot.

2. Regras Gerais

Seu projeto:

Deve usar Spring Boot

Não precisa de banco de dados (armazenar em memória)

Deve usar JSON

Deve seguir exatamente os endpoints definidos

Pode usar List, ArrayList, etc.

3. Estrutura do Pedido

Um pedido tem o seguinte formato:

{
  "descricao": "Notebook",
  "valor": 2500.00
}
Campos:
Campo	Tipo	Obrigatório
descricao	String	Sim
valor	Double	Sim
4. Endpoints
4.1 Criar Pedido

POST /pedido

Recebe um pedido e armazena em memória.

Regras:

descricao não pode ser vazia

valor deve ser maior que 0

Respostas:

✅ 201 Created → pedido válido

❌ 422 Unprocessable Entity → dados inválidos

❌ 400 Bad Request → JSON inválido

4.2 Listar Pedidos

GET /pedido

Retorna todos os pedidos cadastrados.

Exemplo de resposta:
[
  {
    "descricao": "Notebook",
    "valor": 2500.00
  },
  {
    "descricao": "Mouse",
    "valor": 100.00
  }
]
Resposta:

✅ 200 OK

4.3 Limpar Pedidos

DELETE /pedido

Apaga todos os pedidos da memória.

Resposta:

✅ 200 OK

4.4 Estatísticas

GET /pedido/estatistica

Retorna:

{
  "count": 2,
  "sum": 2600.00,
  "avg": 1300.00,
  "min": 100.00,
  "max": 2500.00
}
Regras:

Se não houver pedidos → tudo deve ser 0

Resposta:

✅ 200 OK

5. Dicas de Implementação

Use List<Pedido> para armazenar os dados

Use DoubleSummaryStatistics para facilitar os cálos

Crie camadas:

Controller

Service

Model

6. Extras (Opcional)

✅ Tratamento global de erros (@ControllerAdvice)

✅ Logs com SLF4J

💡 Diferença para o desafio do Itaú
Itaú	Este desafio
Trabalha com tempo (60s)	Sem tempo (fiz com o tempo)
Mais regras de validação	Regras simples
Mais complexo	Mais direto
Fiz uma busca pela descricao que nao estava no desafio que a IA propos.
