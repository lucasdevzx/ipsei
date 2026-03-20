# IPSEI - MVP de Gestão de Desempenho Estudantil

Este repositório contém uma API backend em Spring Boot para um MVP de gerenciamento de desempenho de estudantes.

## O que foi implementado

1. Modelo de dados de desempenho: `StudentPerformance` com campos:
   - `studentName`
   - `course`
   - `term`
   - `score`
   - `reward`
   - `rank` (transiente, calculado no retorno)

2. Repositório JPA:
   - `StudentPerformanceRepository` estende `JpaRepository` para CRUD.

3. Serviço de domínio:
   - `StudentPerformanceService` centraliza lógica de persistência e cálculo de ranking por score.

4. API REST:
   - `StudentPerformanceController` expõe endpoints sob `/api/performance`:
     - `POST /api/performance/students` para criar registro de performance
     - `GET /api/performance/students` para listar todos com ranking calculado
     - `GET /api/performance/students/{id}` para consultar um registro

## Detalhes técnicos

- O ranking é calculado no serviço ordenando por nota (`score`) em ordem decrescente e atribuindo `rank` como posição.
- A aplicação usa H2 em memória (a configuração padrão do Spring Boot se aplica).
- A estrutura criada é pequena e focada para MVP.

## Como rodar localmente

1. Certifique-se de ter JDK 21 instalado e configurado (`JAVA_HOME` apontando para JDK).
2. Execute:

```bash
./mvnw clean package
./mvnw spring-boot:run
```

3. Teste endpoints com `curl` ou Postman:

```bash
curl -X POST http://localhost:8080/api/performance/students -H "Content-Type: application/json" -d '{"studentName":"Ana","course":"Engenharia","term":"2026-1","score":9.2,"reward":"Bolsista"}'
curl http://localhost:8080/api/performance/students
```

## Observação do código atual

A base original do projeto tinha apenas entidades de campus/curso/instituição e não havia APIs nem repositórios de domínio.
Adicionamos um módulo funcional mínimo para gestão de desempenho acadêmico.

Para avançar daqui, você pode incluir:
- Endpoints de dashboards e filtros por curso/term
- Regras de recompensa customizáveis
- Integração com interfaces front-end (React, Angular, etc.)
