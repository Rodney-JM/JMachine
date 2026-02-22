# 🧠 JMachine Engine

> Sistema inteligente de estudos com validação automática por IA

<div align="center">

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![AI](https://img.shields.io/badge/Groq_AI-LLaMA_3.1-00D9FF?style=for-the-badge&logo=ai&logoColor=white)
![Status](https://img.shields.io/badge/Status-MVP-FFD700?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

</div>

---

## 🎯 Sobre o Projeto

**JMachine Engine** é um sistema de gerenciamento de estudos desenvolvido do zero em **Java puro** (sem frameworks), aplicando rigorosamente **Clean Architecture**, **princípios SOLID** e **Design Patterns**. 

O grande diferencial? **Integração real com IA** (Groq - LLaMA 3.1) que valida automaticamente as respostas corretas em questões de múltipla escolha.

> ⚠️ **Projeto em desenvolvimento ativo** - Funcionalidades 1-5 implementadas (CRUD completo de estudantes + cadastro de exercícios com IA)

---

## ✨ Diferenciais Técnicos

🤖 **IA Real Integrada** - Validação automática de questões usando Groq AI (LLaMA 3.1 70B)  
🏗️ **Clean Architecture** - Separação total entre negócio, aplicação e infraestrutura  
💎 **SOLID na Prática** - Todos os 5 princípios aplicados rigorosamente  
🎨 **Design Patterns** - Repository, Factory, Value Objects, DTO, Dependency Injection  
🔧 **Zero Frameworks** - Java puro para demonstrar domínio dos fundamentos  

---

## 🏗️ Arquitetura

### Clean Architecture (Hexagonal)
```
┌─────────────────────────────────────────┐
│         PRESENTATION (Console)          │
│         Handlers & User Interface       │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│       APPLICATION (Use Cases)           │
│     Orquestração de Regras de Negócio  │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│      DOMAIN (Business Logic)            │
│   Entidades, Value Objects, Interfaces │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│    INFRASTRUCTURE (External)            │
│  Persistence, AI Services, Config       │
└─────────────────────────────────────────┘
```

**Princípio:** Dependências apontam sempre para dentro. O domínio não conhece frameworks, banco de dados ou IA.

---

## 💎 SOLID Principles Aplicados

| Princípio | Implementação |
|-----------|---------------|
| **Single Responsibility** | `CreateStudentUseCase` faz apenas uma coisa: criar estudantes |
| **Open/Closed** | Novos repositórios podem ser adicionados sem modificar use cases |
| **Liskov Substitution** | Qualquer `StudentRepository` é substituível (InMemory → File → Database) |
| **Interface Segregation** | Interfaces específicas (`StudentRepository`, `ExerciseRepository`) |
| **Dependency Inversion** | Use cases dependem de abstrações, não de implementações concretas |

---

## 🎨 Design Patterns

### 🗄️ Repository Pattern
```java
public interface StudentRepository {
    void save(Student student);
    Optional findById(String id);
    List findAll();
    void delete(String id);
}
```

### 🏭 Factory Method
```java
Student.create(name, email, level);  // Gera UUID automaticamente
Question.createOpenEnded(text, answer);
Question.createMultipleChoice(text, answer, alternatives);
```

### 💎 Value Objects
```java
public class Email {
    private final String value;
    
    public Email(String value) {
        if (!isValid(value)) throw new IllegalArgumentException();
        this.value = value;
    }
}
```
**Garantia:** Objetos nunca existem em estado inválido.

### 📦 DTO Pattern
```java
public class CreateStudentDTO {
    private final String name;
    private final String email;
    private final StudentLevel level;
}
```

### 💉 Dependency Injection (Manual)
```java
public class StudentConfig {
    private static final StudentRepository repository = 
        new InMemoryStudentRepository();
    
    public static CreateStudentUseCase createUseCase() {
        return new CreateStudentUseCase(repository);
    }
}
```

---

## 🤖 Integração com IA (Groq)

### Como Funciona?
```
┌──────────────┐
│ Usuário cria │
│   questão    │
└──────┬───────┘
       │
       ▼
┌─────────────────────┐
│ Sistema envia para  │
│  Groq AI (LLaMA)    │
└──────┬──────────────┘
       │
       ▼
┌─────────────────────┐
│ IA identifica qual  │
│ alternativa correta │
└──────┬──────────────┘
       │
       ▼
┌─────────────────────┐
│ Usuário confirma    │
│   ou corrige        │
└─────────────────────┘
```

### Exemplo Real
```bash
========== QUESTÃO 1 ==========
Enunciado: Qual palavra-chave é usada para herança em Java?

Quantas alternativas? 4
Alternativa A: extends
Alternativa B: implements  
Alternativa C: super
Alternativa D: this

🤖 Consultando IA (Groq)...
✅ IA identificou: "extends"

A IA está correta? (S/N): s
✅ Questão adicionada!
```

### Por que Groq?

✅ **100% Gratuito** - 14.400 requests/dia  
✅ **Ultra Rápido** - Resposta em ~1 segundo  
✅ **Alta Precisão** - LLaMA 3.1 70B  
✅ **Simples** - API compatível OpenAI  

---

## ✅ Funcionalidades Implementadas

### 👨‍🎓 Gestão de Estudantes
- [x] Cadastrar estudante com validação de email
- [x] Listar todos os estudantes
- [x] Atualizar dados (nome, email, nível)
- [x] Deletar estudante
- [x] Sistema de níveis (Iniciante → Intermediário → Avançado)
- [x] Value Objects para garantir consistência

### 📝 Gestão de Exercícios
- [x] Cadastrar exercício com múltiplas questões
- [x] Questões dissertativas (resposta aberta)
- [x] Questões múltipla escolha (4+ alternativas)
- [x] **Validação automática por IA** 🤖
- [x] Níveis de dificuldade (Fácil, Médio, Difícil)
- [x] Categorização por tópicos (Java, POO, Algoritmos...)

---

## 🚀 Roadmap Futuro

### 🎯 Próximas Features

#### Sistema de Respostas
- [ ] Alunos responderem exercícios
- [ ] Correção automática
- [ ] Histórico de tentativas
- [ ] Feedback da IA em respostas erradas

#### 📊 Analytics & Performance
- [ ] Taxa de acerto por tópico
- [ ] Identificação de pontos fracos
- [ ] Gráficos de evolução temporal
- [ ] Comparação com média geral

#### 🎓 Planos de Estudo
- [ ] Geração baseada no nível do aluno
- [ ] Recomendações adaptativas por IA
- [ ] Sistema de revisão espaçada
- [ ] Metas personalizadas

#### 🏆 Gamificação
- [ ] Conquistas (badges)
- [ ] Ranking de alunos
- [ ] Sequências de estudo (streaks)
- [ ] Sistema de pontos e níveis

#### 🤖 Expansão IA
- [ ] Geração automática de exercícios
- [ ] Explicações didáticas personalizadas
- [ ] Chatbot para tirar dúvidas
- [ ] Sugestões de melhoria nas questões

---

## 🔄 Evolução do Projeto

### Fase 1: Backend Spring Boot

**Migração planejada:**
```
Java Puro → Spring Boot 3+
InMemory  → PostgreSQL + JPA
Console   → REST API + Swagger
Manual DI → @Autowired
```

**Stack:**
- Spring Boot Web
- Spring Data JPA  
- Spring Security (JWT)
- PostgreSQL
- Docker
- AWS Deploy

---

### Fase 2: Frontend Next.js

**Interface moderna:**
```
Next.js 14 + TypeScript
├── Dashboard interativo
├── Gráficos de performance (Chart.js)
├── Resolução de exercícios em tempo real
├── Sistema de notificações
└── Design responsivo (Tailwind + shadcn/ui)
```

**Stack:**
- Next.js 14 (React Server Components)
- TypeScript
- Tailwind CSS
- shadcn/ui (componentes)
- React Query (cache)
- Zustand (state management)

---

## 🛠️ Como Executar

### Pré-requisitos
```bash
☕ Java 17 ou superior
📦 Maven ou Gradle
🤖 Conta Groq (opcional - para IA)
```

### Instalação
```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/jmachine-engine.git
cd jmachine-engine

# 2. Configure Groq API (opcional)
export GROQ_API_KEY="gsk_sua_key_aqui"
# Crie conta grátis em: https://console.groq.com

# 3. Compile
mvn clean compile

# 4. Execute
mvn exec:java -Dexec.mainClass="org.JMachine.Main"
```

> 💡 **Sem API key:** Sistema funciona normalmente, mas sem validação automática por IA.

---

## 📁 Estrutura do Projeto
```
src/main/java/org/JMachine/
│
├── 🎯 domain/                    # Coração do sistema
│   ├── model/
│   │   ├── student/
│   │   │   ├── Student.java            # Entidade agregadora
│   │   │   ├── Name.java               # Value Object
│   │   │   ├── Email.java              # Value Object
│   │   │   └── StudentLevel.java       # Enum
│   │   └── exercise/
│   │       ├── Exercise.java           # Entidade agregadora
│   │       ├── Question.java           # Entidade
│   │       ├── ExerciseDifficulty.java # Enum
│   │       └── QuestionType.java       # Enum
│   └── repository/                     # Contratos (Portas)
│       ├── StudentRepository.java
│       └── ExerciseRepository.java
│
├── 💼 application/               # Casos de uso
│   ├── usecase/
│   │   ├── student/
│   │   │   ├── CreateStudentUseCase.java
│   │   │   ├── ListAllStudentsUseCase.java
│   │   │   ├── UpdateStudentUseCase.java
│   │   │   └── DeleteStudentUseCase.java
│   │   └── exercise/
│   │       └── CreateExerciseUseCase.java
│   └── dto/
│       ├── student/
│       └── exercise/
│
├── 🔧 infrastructure/            # Adaptadores
│   ├── persistence/memory/
│   │   ├── InMemoryStudentRepository.java
│   │   └── InMemoryExerciseRepository.java
│   ├── ai/
│   │   └── GroqService.java           # Integração IA
│   └── config/
│       ├── StudentConfig.java         # DI Manual
│       └── ExerciseConfig.java
│
├── 🎨 presentation/              # Interface
│   ├── Console.java                   # Menu principal
│   ├── student/
│   │   ├── CreateStudentConsoleHandler.java
│   │   ├── ListStudentConsoleHandler.java
│   │   ├── UpdateStudentConsoleHandler.java
│   │   └── DeleteStudentConsoleHandler.java
│   └── exercise/
│       ├── BaseExerciseConsoleHandler.java
│       └── CreateExerciseConsoleHandler.java
│
└── 🚀 Main.java                  # Entry point
```

---

## 💻 Stack Técnica

### Atual (MVP)
| Tecnologia | Uso |
|------------|-----|
| Java 17 | Linguagem base |
| Groq AI (LLaMA 3.1) | Validação por IA |
| Gson | Serialização JSON |
| Clean Architecture | Padrão arquitetural |

### Futuro (Fullstack)
| Layer | Stack |
|-------|-------|
| **Frontend** | Next.js 14, TypeScript, Tailwind, shadcn/ui |
| **Backend** | Spring Boot 3, Spring Security, JPA |
| **Database** | PostgreSQL |
| **Deploy** | Docker, AWS/Vercel |
| **Docs** | Swagger/OpenAPI |

---

## 📊 Demonstração

### Cadastro de Estudante
```bash
========== CADASTRAR ESTUDANTE ==========
Nome: João Silva
Email: joao@email.com

Escolha o nível:
1 - Iniciante
2 - Intermediário  
3 - Avançado
Opção: 1

✅ Estudante criado com sucesso!
   Nome: João Silva
   Email: joao@email.com
   Nível: BEGINNER
```

### Cadastro de Exercício com IA
```bash
========== CADASTRAR EXERCÍCIO ==========
Título: Fundamentos de POO
Descrição: Conceitos básicos de orientação a objetos
Tópico: Java

Dificuldade:
1 - Fácil
2 - Médio
3 - Difícil
Opção: 2

Quantas questões? 1

========== QUESTÃO 1 ==========
Enunciado: Qual palavra-chave para herança em Java?

Tipo de questão:
1 - Múltipla escolha (IA identifica resposta automaticamente)
2 - Dissertativa
Escolha: 1

Quantas alternativas (mínimo 2)? 4
Alternativa A: extends
Alternativa B: implements
Alternativa C: super
Alternativa D: this

📋 Alternativas cadastradas:
  A) extends
  B) implements
  C) super
  D) this

🤖 Consultando IA (Groq) para identificar resposta correta...
✅ IA identificou: "extends"

A IA está correta? (S/N): s
✅ Questão 1 adicionada!

✅ Exercício criado com sucesso!
   Título: Fundamentos de POO
   Questões: 1
   Dificuldade: Médio
```

---

## 💡 Decisões Técnicas

### Por que Java Puro (sem frameworks)?

**Objetivo:** Demonstrar domínio profundo dos fundamentos

- ✅ Controle total sobre arquitetura
- ✅ Implementação manual de DI, validação, persistência
- ✅ Entendimento completo do fluxo de dados
- ✅ Base sólida para migração futura

### Por que Clean Architecture?

**Benefícios comprovados:**

- 🧪 **Testabilidade** - Camadas isoladas facilitam testes
- 🔧 **Manutenibilidade** - Mudanças localizadas
- 📈 **Escalabilidade** - Fácil adicionar novos casos de uso
- 🔌 **Independência** - Domain não conhece frameworks/DB

### Por que Value Objects?

**Encapsulamento de regras:**
```java
// ❌ Sem Value Object
if (email == null || !email.contains("@")) {
    throw new IllegalArgumentException();
}

// ✅ Com Value Object  
new Email(email); // Valida automaticamente
```

**Garantia:** Objetos nunca existem em estado inválido.

---

## 📈 Métricas do Projeto
```
📦 Linhas de código: ~2.500
🏗️ Camadas arquiteturais: 4
📚 Entidades de domínio: 2 (Student, Exercise)
🎯 Use Cases implementados: 5
🤖 Integrações IA: 1 (Groq)
💎 Value Objects: 2 (Email, Name)
🎨 Design Patterns: 5+
```

---

## 🎓 Aprendizados Demonstrados

### Arquitetura & Design
✅ Clean Architecture  
✅ Hexagonal Architecture  
✅ Separation of Concerns  
✅ Dependency Inversion  

### Princípios
✅ SOLID (todos os 5)  
✅ DRY (Don't Repeat Yourself)  
✅ KISS (Keep It Simple)  
✅ YAGNI (You Aren't Gonna Need It)  

### Padrões
✅ Repository Pattern  
✅ Factory Method  
✅ Value Object  
✅ DTO (Data Transfer Object)  
✅ Dependency Injection  

### Práticas
✅ Clean Code  
✅ Fail-Fast Validation  
✅ Immutability (Value Objects)  
✅ Separation of Business Logic  

---

## 🤝 Contribuições

Este é um projeto educacional para demonstração de habilidades técnicas. Sugestões e feedbacks são bem-vindos!

---

## 📄 Licença

MIT License - Livre para uso educacional e demonstração.

---

## 👨‍💻 Autor

Desenvolvido para demonstrar expertise em:
- ✨ Arquitetura de Software
- ✨ Princípios SOLID
- ✨ Design Patterns
- ✨ Integração com IA
- ✨ Java Fundamentals
- ✨ Clean Code

---

<div align="center">

### ⭐ Status: MVP Funcional

**Próximo passo:** Migração para fullstack (Spring Boot + Next.js)

[🚀 Ver Roadmap](#-roadmap-futuro) | [📖 Documentação](#-arquitetura) | [💻 Como Executar](#-como-executar)

</div>
