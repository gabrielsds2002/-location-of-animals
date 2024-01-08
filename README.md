<h1 align="center">
  location of animals
</h1>


## 1. Sobre

Aplicação para a consulta de locais de pets desaparecidos.

| |  |
|----------|----------|
| Nome da Api | location-of-animals |
| Descrição resumida |Consulta de pets|
| versão | v1 |
| Tecnologia | Java 17 |

## 2. Hierarquia das pastas
| **Diretório** | **Descrição** |
|---------------|---------------|
| /commons/** | Mapeamento de response |
| /config/** | Configuração do projeto |
| /dataprovider/** | Contem a integração com a api externa |
| /entrypoint/** | Contem a controller da aplicação e mapeamento dos parametros |
| /exceptions/** | Tratativas de erros |
| /usecase/** | Casos de uso da API |
| /tests/** | are you? |

## 3. O que é preciso para rodar local

## 4. Rotas
| Ambiente | Endpoint |
|----------|----------|
| Local | http://localhost:8081/localizapets/v1/localizacoes |
| Cloud | https://location-of-animals-production.up.railway.app/localizapets/v1/localizacoes |
## 5. Endpoints

### [GET] .../localizacoes
| Parâmetro | Tipo Parâmetro |Tipo Dado| Obrigatório | Descrição |
|-----------|----------------|---------|-------------|-----------|
|latitude|query|String|Sim|Latitude|
|longitude|query|String|Sim|Longitude|
|idColeira|query|String|Sim|Id da coleira do pet|
|correlation-id|header|String|Sim|Id de correlação entre as chamadas|

## 6. Duvidas
