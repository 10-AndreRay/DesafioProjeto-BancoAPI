## DesafioProjeto-BancoAPI

<p>
  <img src="https://img.shields.io/static/v1?label=Java&message=Language&color=blue&style=for-the-badge&logo=SPRING%22"/>
  <img src="http://img.shields.io/static/v1?label=License&message=MIT&color=red&style=for-the-badge"/>
  <img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge"/>
<p>
  
## Descrição do projeto 

<p align="justify">
  Implementação do padrão Rest com Spring
  <br>
</p>

## Linguagens, dependencias e libs utilizadas :books:

- [Java](https://java.com/)
- [Spring](https://spring.io/)
- [SpringDoc](https://springdoc.org/)

## Requisitos para rodar o projeto:
- JDK 17+ instalado na sua máquina

## Rotas:
Interface de teste: http://localhost:8080/swagger-ui/index.html
### Conta Controller:
HTTP  | Rotas | RequestBody Models | Resultado
--------- | ------ | ------ | ------
GET | localhost:8000/contas | none | Retorna um json com uma lista contendo todas as contas
GET | localhost:8000/contas/{id} | none | Retorna uma conta específica;
POST | localhost:8000/criar | Conta | Retorna uma String com o resultado da solicitação
PUT | localhost:8000/atualizar/{senha} | Conta | Retorna uma String com o resultado da solicitação
DELETE | localhost:8000/deletar/{id}/{senha} | none | Retorna uma String com o resultado da solicitação

### Transações Controller:
HTTP  | Rotas | RequestBody Models| Resultado
--------- | ------ | ------ | ------
POST | localhost:8000/transferir/{senha} | Transferencia | Retorna uma String com o resultado da solicitação
POST | localhost:8000/sacar/{senha} | SacarDepositar |Retorna uma String com o resultado da solicitação
POST | localhost:8000/depositar/{senha}| SacarDepositar | Retorna uma String com o resultado da solicitação

### Responses Examples

http://localhost:8000/contas/
    
      Response headers
      connection: keep-alive 
      content-type: application/json 
      date: Fri,20 Jan 2023 06:44:35 GMT 
      keep-alive: timeout=60 
      transfer-encoding: chunked 

      Response body
      [
        {
          "numConta": 0,
          "cpf": "string",
          "nomeTitular": "string",
          "saldo": 0,
          "senha": "string"
        }
      ]
      
      
http://localhost:8000/transferir/{senha}
    
      Response headers
      connection: keep-alive 
      content-length: 88 
      content-type: text/plain;charset=UTF-8 
      date: Fri,20 Jan 2023 06:41:41 GMT 
      keep-alive: timeout=60 
      
      Response body
      Transação Completa! Foram transferidos {valor} para a conta com titular de nome {nome} or
      Senha incorreta! or
      Saldo insuficiente! or
      Conta inexistente
