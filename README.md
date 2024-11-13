# Spring Boot

- [Commands](#commands);
- [Java Log Levels and their usage](#java-log-levels-and-their-usage)

## Commands

You can check the maven commands on the Intellij

- Run: ./mvnw spring-boot:run

# Java Log Levels and Their Usage

In Java, logging frameworks like Log4j, SLF4J, and Java’s built-in `java.util.logging` provide various log levels to help manage and filter log messages based on their severity. Here’s a breakdown of the common log levels, from highest to lowest priority, along with guidance on when to use each.

## 1. `FATAL`
- **Purpose**: Indicates a severe error that will cause the application to terminate.
- **When to Use**: Use `FATAL` for critical situations that prevent the program from continuing, such as an unrecoverable database failure or the loss of a critical resource.
- **Example**: Database connection is lost and cannot be reestablished.

## 2. `ERROR`
- **Purpose**: Signals an error that might allow the application to continue running, but with limited functionality.
- **When to Use**: Use `ERROR` for issues that indicate serious problems but do not crash the program, like a failed transaction or an invalid state.
- **Example**: A user attempts to upload a file that is too large.

## 3. `WARN`
- **Purpose**: Indicates a potentially harmful situation that does not immediately affect the program.
- **When to Use**: Use `WARN` for issues that might become problematic, such as deprecated methods, high memory usage, or configuration issues.
- **Example**: Application is running with a configuration that may lead to performance issues.

## 4. `INFO`
- **Purpose**: Provides general information about the application’s flow.
- **When to Use**: Use `INFO` for standard operations, like service starts, configuration settings, or the successful completion of significant tasks.
- **Example**: A server starts successfully, or a user logs in.

## 5. `DEBUG`
- **Purpose**: Contains detailed information useful for debugging.
- **When to Use**: Use `DEBUG` to gain insights into the internal workings of the application, including variable values and detailed flow control. Commonly used in development, rather than in production.
- **Example**: Logging the response from a database query or API request.

## 6. `TRACE`
- **Purpose**: Provides highly detailed information, down to the step-by-step flow of the code.
- **When to Use**: Use `TRACE` for very fine-grained details, like entry and exit of methods, which can be beneficial when diagnosing issues that require a comprehensive understanding of the code flow.
- **Example**: Entering and exiting each method in a service class.

---

## How and When to Use Log Levels Effectively
- **Production Environments**: Typically only `ERROR` and `FATAL` messages are logged by default, as these provide crucial information without overwhelming the logs.
- **Development and Debugging**: Enable `DEBUG` or `TRACE` levels to troubleshoot and diagnose issues, but avoid leaving them on in production to prevent performance degradation.
- **Configuring Log Levels**: Most logging frameworks allow configuring the log level threshold dynamically. For instance, setting the log level to `WARN` will capture `WARN`, `ERROR`, and `FATAL` messages, filtering out lower-priority logs.

Using log levels effectively helps you maintain a clear, concise logging system that provides meaningful insights without clutter.