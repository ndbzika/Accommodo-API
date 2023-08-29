# **Documentação do projeto accommodo**

## Visão Geral
Nesta documentação, você encontrará informações sobre o projeto "accommodo", 
um sistema de gerenciamento do hotel do usuário, executando no servidor do cliente. 
O projeto "accommodo" é um sistema de gerenciamento de hotéis que permite realizar diversas 
tarefas relacionadas à administração e operação de um hotel, como reserva de quartos, gerenciamento 
de hóspedes, controle de ocupação e registro de serviços. Descreveremos as principais funcionalidades, 
estrutura de pastas, API e outros aspectos relevantes.
Você pode ver o front-end dessa aplicação aqui: https://github.com/ndbzika/accommodo-frontend

### Tecnologias Utilizadas

O projeto é desenvolvido utilizando a linguagem de programação Java, conhecida por sua ampla adoção no desenvolvimento de aplicativos empresariais e sua forte orientação a objetos. O paradigma de programação utilizado é a Orientação a Objetos (OO), que permite modelar entidades do mundo real como classes e objetos, encapsulando dados e comportamentos relacionados.

### Arquitetura e Design

A arquitetura do projeto "accommodo" segue os princípios da arquitetura em camadas, com uma separação clara entre a camada de apresentação, lógica de negócio e persistência de dados. As classes são estruturadas de forma modular, com responsabilidades bem definidas e relações de herança e composição quando apropriado.

### Frameworks e Bibliotecas

Durante o desenvolvimento, são utilizados frameworks e bibliotecas populares do ecossistema Java, como Spring Framework para a criação da camada de negócio e persistência, e outras bibliotecas auxiliares para lidar com tarefas específicas.

### Benefícios da Abordagem Orientada a Objetos

A utilização da abordagem de Orientação a Objetos traz benefícios significativos ao projeto "accommodo". Alguns desses benefícios incluem:

- Reutilização de código: Através da criação de classes reutilizáveis e hierarquias de herança, é possível reutilizar código em diferentes partes do sistema.
- Encapsulamento: O encapsulamento permite ocultar detalhes internos de implementação e fornecer uma interface bem definida para o uso das classes.
- Manutenibilidade: A estrutura modular e organizada da Orientação a Objetos facilita a manutenção e evolução do sistema ao longo do tempo.
- Flexibilidade: Através de conceitos como polimorfismo e interfaces, é possível criar código flexível e extensível, adaptando-se às mudanças nos requisitos do sistema.

### Diagrama de classes

![Diagrama de classes Accommodo](/accommodo-diagram.png "Diagrama de classes")


## Rotas da API
A seguir, estão listadas as rotas disponíveis na API do projeto "accommodo":

### /hospedes
- **GET**: Obtém a lista de todos os hospedes cadastrados.
- **POST**: Obtém a lista de todos os hospedes cadastrados.

### /hospedes/{id}
- **GET**: Obtém os detalhes de um hospede específico.
- **PUT**: Atualiza as informações de um hospede.
- **DELETE**: Realiza a exclusão física de um hospede.


### /funcionarios
- **GET**: Obtém a lista de todos os funcionarios cadastrados.
- **POST**: Obtém a lista de todos os funcionarios cadastrados.

### /funcionarios/{id}
- **GET**: Obtém os detalhes de um funcionario específico.
- **PUT**: Atualiza as informações de um funcionario.
- **DELETE**: Realiza a exclusão física de um funcionario.


### /quartos
- **GET**: Obtém a lista de todos os quartos cadastrados.
- **POST**: Obtém a lista de todos os quartos cadastrados.

### /quartos/{id}
- **GET**: Obtém os detalhes de um quarto específico.
- **PUT**: Atualiza as informações de um quarto.
- **DELETE**: Realiza a exclusão física de um quarto.


### /reservas
- **GET**: Obtém a lista de todos os reservas cadastrados.
- **POST**: Obtém a lista de todos os reservas cadastrados.

### /reservas/{id}
- **GET**: Obtém os detalhes de um reserva específico.
- **PUT**: Atualiza as informações de um reserva.
- **DELETE**: Realiza a exclusão física de um reserva.

## Exemplos de Solicitações e Respostas
Aqui estão alguns exemplos de solicitações e respostas para ilustrar o uso da API do projeto "accommodo":

### Exemplo de solicitação GET /hospedes/1
GET /hospedes/1

#### Exemplo de resposta GET /hospedes/1
Status: 200 OK
```JSON
{
"id": 1,
"nome": "Flavio Henrique",
"email": "flavio@email.com",
"telefone": "(12) 3456-7890"
}
```

### Exemplo de solicitação GET /funcionarios/1
GET /funcionarios/1

#### Exemplo de resposta GET /funcionarios/1
Status: 200 OK
```JSON
{
"nome": "Joao Humberto",
"email": "joao@email.com",
"telefone": "(09) 8765-4321",
"id": 1,
"cargo": "Gerente",
"salario": 3000.0
}
```

### Exemplo de solicitação GET /quartos/1
GET /quartos/1

#### Exemplo de resposta GET /quartos/1
Status: 200 OK
```JSON
{
"id": 1,
"numero": 1,
"tipo": "Deluxe",
"preco": 3000.0,
"status": "Manutenção"
}
```
### Exemplo de solicitação GET /reservas/1
GET /reservas/1

#### Exemplo de resposta GET /reservas/1
Status: 200 OK
```JSON
{
"id": 1,
"hospede": {
    "nome": "Flavio Henrique",
    "email": "flavio@email.com",
    "telefone": "(12) 3456-7890",
    "id": 1
},
"quarto": {
    "id": 1,
    "numero": 1,
    "tipo": "Deluxe",
    "preco": 3000.0,
    "status": "Manutenção"
},
"funcionario": {
    "nome": "Joao Humberto",
    "email": "joao@email.com",
    "telefone": "(09) 8765-4321",
    "id": 1,
    "cargo": "Gerente",
    "salario": 3000.0
},
"dataInicio": "2023-06-22T03:00:00.000+00:00",
"dataFim": "2023-06-25T03:00:00.000+00:00",
"status": "ativo"
}
```

## Notas Adicionais
- Esta documentação foi atualizada pela última vez em 15 de junho de 2023.
- As informações aqui presentes são confidenciais e destinam-se apenas aos desenvolvedores do projeto "accommodo".
