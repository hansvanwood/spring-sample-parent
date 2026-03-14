# Spring 框架知识点示例项目

本项目是一个多模块的 Maven 工程，旨在演示和学习 Spring Framework 的核心概念和知识点。项目采用渐进式的方式，从原始代码开始，逐步引入 Spring 的各种特性。

## 📚 项目信息

- **Java 版本**: 21
- **Spring Framework**: 7.0.5
- **构建工具**: Maven
- **依赖管理**: Jakarta Annotations 3.0.0, Lombok 1.18.42

## 🏗️ 项目结构

```
spring-sample-parent/
├── spring-01-origin/          # 原始实现（不使用 Spring）
├── spring-02-quickstart/      # Spring 快速入门
├── spring-03-bean-definition/ # Bean 定义与注册
├── spring-04-di/              # 依赖注入（Dependency Injection）
├── spring-05-bean-lifecycle/  # Bean 的生命周期
├── spring-06-aop/             # 面向切面编程（AOP）
├── spring-07-experiment-t1/   # 实验任务 1 - IoC 综合练习
├── spring-08-experiment-t2/   # 实验任务 2 - AOP 综合练习
└── spring-10-practise/        # 综合实践（个人练习使用）
```

## 📦 模块说明

### 1. spring-01-origin - 原始实现

**目标**: 展示不使用 Spring 容器的传统面向对象编程方式

**内容**:
- 手动创建和管理对象实例
- 理解没有 IoC 容器时的代码组织方式
- 对比学习 Spring 的优势

**核心类**:
- `App01`: 主启动类
- `MovieService`: 电影服务层
- `MovieDao`: 电影数据访问层
- `Movie`: 电影实体类

### 2. spring-02-quickstart - Spring 快速入门

**目标**: 快速了解 Spring 容器的基本使用

**内容**:
- 使用 `AnnotationConfigApplicationContext` 创建 Spring 容器
- 通过配置类管理 Bean
- 从容器中获取 Bean 实例
- 理解 IoC（控制反转）概念

**核心类**:
- `App02`: 主启动类
- `AppConfig`: Spring 配置类（使用 `@Configuration` 和 `@Bean`）
- `ReflectionExample`: 反射示例

### 3. spring-03-bean-definition - Bean 定义与注册

**目标**: 深入学习 Spring Bean 的定义方式和注册机制

**内容**:
- 使用 `@Component`、`@Service`、`@Controller` 等注解定义 Bean
- 使用 `@Bean` 在配置类中定义 Bean
- Bean 的扫描与自动注册
- 查看容器中的 Bean 定义
- Bean 的生命周期回调（`@PostConstruct`、`@PreDestroy`）

**核心类**:
- `App03`: 主启动类
- `AppConfig`: 主配置类（组件扫描配置）
- `CustomConfig`: 自定义配置类
- `MovieController`: 控制器层（使用 `@Controller`）
- `MovieService`: 服务层（使用 `@Service`）
- `MovieDao`: 数据访问层（使用 `@Repository`）
- `MovieUtils`: 工具类（使用 `@Component`）

### 4. spring-04-di - 依赖注入

**目标**: 掌握 Spring 依赖注入的各种方式

**内容**:
- 构造器注入（推荐）
- Setter 注入
- 字段注入
- `@Autowired` 和 `@Qualifier` 的使用
- `@RequiredArgsConstructor`（Lombok）配合依赖注入

**核心类**:
- `App04`: 主启动类
- `MovieController`: 控制器（构造器注入）
- `MovieController2`: 控制器（多种注入方式）
- `MovieService`: 服务层

### 5. spring-05-bean-lifecycle - Bean 的生命周期

**目标**: 理解 Spring Bean 的完整生命周期

**内容**:
- Bean 的实例化
- 属性赋值
- 初始化回调（`@PostConstruct`、`InitializingBean`、init-method）
- 销毁回调（`@PreDestroy`、`DisposableBean`、destroy-method）
- Bean 的作用域（Singleton、Prototype 等）

**核心类**:
- `App05`: 主启动类
- `LifecycleBean`: 生命周期演示 Bean
- `MovieController`: 控制器示例

### 6. spring-06-aop - 面向切面编程

**目标**: 掌握 Spring AOP 的核心概念和使用方法

**内容**:
- AOP 基本概念（切面、切入点、通知、连接点）
- 使用 AspectJ 注解开发
- `@Aspect`、`@Before`、`@After`、`@Around` 等注解
- 切入点表达式语法
- AOP 在实际开发中的应用场景（日志记录、事务管理、权限控制等）

**核心类**:
- `App06`: 主启动类
- `MovieLogAspect`: 切面类（日志记录示例）
- `MovieController`: 控制器（被代理对象）
- `AppConfig`: 配置类（启用 AOP）

### 7. spring-07-experiment-t1 - 实验任务 1: IoC 综合练习

**目标**: 综合运用 Spring IoC 相关知识完成实践任务

**内容**:
- 完整的分层架构设计（Controller-Service-Dao）
- Bean 的定义与管理
- 依赖注入实战
- 单元测试编写

**核心类**:
- `App07`: 主启动类
- `MovieController`: 控制器层
- `MovieService`: 服务层
- `MovieDao`: 数据访问层
- `Movie`: 实体类
- `AppConfig`: 配置类

**测试**:
- `IoCTest`: IoC 容器集成测试

### 8. spring-08-experiment-t2 - 实验任务 2: AOP 综合练习

**目标**: 运用 Spring AOP 技术解决实际问题

**内容**:
- AOP 切面的设计与实现
- 自定义注解与 AOP 结合
- 环绕通知的实际应用
- AOP 在性能监控、日志增强等场景的应用

**核心类**:
- `MovieController`: 控制器层
- `MovieService`: 服务层
- `MovieDao`: 数据访问层
- `Movie`: 实体类
- 切面类（性能监控、日志记录等）

**测试**:
- `AopTest`: AOP 功能集成测试

### 9. spring-10-practise - 综合实践

**目标**: 综合运用所学的 Spring 知识点

**内容**:
- 完整的 Spring 应用示例
- 多层架构设计
- 最佳实践演示
- 自由发挥和创新实践

**核心类**:
- `App`: 主启动类

## 🚀 快速开始

### 环境要求

- JDK 21+
- Maven 3.6+
- IDE（推荐 IntelliJ IDEA）

### 构建项目

```bash
cd spring-sample-parent
mvn clean install
```

### 运行示例

每个模块都有独立的主类，可以单独运行：

```bash
# 运行原始实现示例
mvn -pl spring-01-origin exec:java -Dexec.mainClass="com.example.App01"

# 运行 Spring 快速入门示例
mvn -pl spring-02-quickstart exec:java -Dexec.mainClass="com.example.App02"

# 运行 Bean 定义示例
mvn -pl spring-03-bean-definition exec:java -Dexec.mainClass="com.example.App03"

# 运行依赖注入示例
mvn -pl spring-04-di exec:java -Dexec.mainClass="com.example.App04"

# 运行 Bean 生命周期示例
mvn -pl spring-05-bean-lifecycle exec:java -Dexec.mainClass="com.example.App05"

# 运行 AOP 示例
mvn -pl spring-06-aop exec:java -Dexec.mainClass="com.example.App06"

# 运行实验任务 1
mvn -pl spring-07-experiment-t1 exec:java -Dexec.mainClass="com.example.App07"

# 运行实验任务 1 的测试
mvn -pl spring-07-experiment-t1 test

# 运行实验任务 2 的测试
mvn -pl spring-08-experiment-t2 test
```

或者在 IDE 中直接运行各个模块的 `AppXX` 主类。

## 🎯 学习路径

建议按照以下顺序学习：

1. **spring-01-origin**: 了解没有 Spring 时的代码组织方式
2. **spring-02-quickstart**: 初步认识 Spring 容器
3. **spring-03-bean-definition**: 学习如何定义和注册 Bean
4. **spring-04-di**: 掌握依赖注入的各种方式
5. **spring-05-bean-lifecycle**: 深入理解 Bean 的生命周期
6. **spring-06-aop**: 学习面向切面编程思想
7. **spring-07-experiment-t1**: 完成 IoC 综合练习
8. **spring-08-experiment-t2**: 完成 AOP 综合练习
9. **spring-10-practise**: 综合运用所有知识点进行自由实践

## 📝 核心概念

### IoC（控制反转）

将对象的创建和管理权交给 Spring 容器，而不是手动创建。

### DI（依赖注入）

Spring 容器自动为 Bean 注入所需的依赖对象。

### Bean

由 Spring 容器管理的对象称为 Bean。

### 注解说明

- `@Configuration`: 标识配置类
- `@Bean`: 在配置类中定义 Bean
- `@ComponentScan`: 指定组件扫描路径
- `@Component`: 通用组件注解
- `@Service`: 服务层注解
- `@Repository`: 数据访问层注解
- `@Controller`: 控制器层注解
- `@Autowired`: 自动注入依赖
- `@Qualifier`: 指定具体注入的 Bean 名称
- `@PostConstruct`: 初始化回调
- `@PreDestroy`: 销毁回调
- `@Aspect`: 声明切面
- `@Before`: 前置通知
- `@After`: 后置通知
- `@Around`: 环绕通知
- `@Pointcut`: 切入点定义

## 🛠️ 技术栈

- **Spring Framework 7.0.5**: 核心框架（包含 Core、Context、Beans、AOP、Aspects 等模块）
- **Jakarta Annotations 3.0.0**: 注解支持（Spring 6+ 使用 Jakarta 命名空间）
- **Lombok 1.18.42**: 简化代码（`@RequiredArgsConstructor`、`@Slf4j` 等）
- **SLF4J 2.0.12 + Logback 1.5.0**: 日志框架
- **JUnit 6.0.3**: 单元测试框架
- **AspectJ Weaver**: AOP 织入工具

## 📋 模块依赖关系

所有子模块都继承自 `spring-sample-parent` 父 POM，共享以下配置：

- Java 21 编译配置
- Spring Framework 依赖管理
- 统一的编码设置（UTF-8）

## 🔍 常见问题

### Q: 为什么使用 Jakarta Annotations 而不是 javax.annotations？

A: Spring Framework 6+ 已经迁移到 Jakarta EE 命名空间，因此需要使用 `jakarta.annotation.*` 而不是 `javax.annotation.*`。

### Q: 如何查看容器中定义了哪些 Bean？

A: 使用 `ApplicationContext.getBeanDefinitionNames()` 方法可以获取所有 Bean 的名称列表。

### Q: 构造器注入、Setter 注入和字段注入哪个更好？

A: Spring 官方推荐使用**构造器注入**，因为：
- 依赖不可变
- 便于测试
- 避免循环依赖
- 强制依赖显式声明

### Q: Spring AOP 和 AspectJ 有什么区别？

A: 
- **Spring AOP**: 基于动态代理，运行时织入，适用于 Spring Bean 的方法调用
- **AspectJ**: 功能更强大，编译时或加载时织入，可以拦截任意对象的方法调用、字段访问等
- 项目中通常结合使用，Spring AOP 处理简单的业务场景，复杂场景使用 AspectJ

### Q: 如何调试 AOP 相关的问题？

A:
- 启用 Spring AOP 的调试日志：在 `application.properties` 中设置 `logging.level.org.springframework.aop=DEBUG`
- 检查切入点表达式是否正确匹配到目标方法
- 确认目标类是否被 Spring 容器管理
- 注意 AOP 只对 Spring Bean 有效，对内部方法调用无效

## 📖 参考资源

- [Spring Framework 官方文档](https://docs.spring.io/spring-framework/docs/current/reference/html/)
- [Spring Core Technologies](https://spring.io/projects/spring-framework)
- [Jakarta Annotations Specification](https://jakarta.ee/specifications/annotations/)

## 📄 许可证

本项目仅用于学习和交流目的。

## 🤝 贡献

欢迎提出问题和改进建议！

---

**祝你学习愉快！** 🎉
