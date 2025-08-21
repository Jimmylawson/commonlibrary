# Common Library

A shared Java library containing common utilities, base entities, and exception handling for Spring Boot applications.

## Features

### Base Entity
- [BaseEntity](cci:2://file:///Users/jimmylawson/Downloads/commonlibrary/src/main/java/com/commonlibrary/commonlibrary/entity/BaseEntity.java:12:0-25:1) class with common fields:
    - `id` - Auto-generated primary key
    - `createdAt` - Timestamp of creation (auto-set on creation)
    - `updatedAt` - Timestamp of last update (auto-updated)

### Exception Handling
- [BusinessException](cci:2://file:///Users/jimmylawson/Downloads/commonlibrary/src/main/java/com/commonlibrary/commonlibrary/exceptions/BusinessException.java:2:0-10:1) - Base exception for business logic errors
- [ResourceNotFoundException](cci:2://file:///Users/jimmylawson/Downloads/commonlibrary/src/main/java/com/commonlibrary/commonlibrary/exceptions/ResourceNotFoundException.java:2:0-6:1) - Thrown when a requested resource is not found
- [DuplicateResourceException](cci:2://file:///Users/jimmylawson/Downloads/commonlibrary/src/main/java/com/commonlibrary/commonlibrary/exceptions/DuplicateResourceException.java:2:0-6:1) - Thrown when trying to create a duplicate resource
- [UserNotFoundException](cci:2://file:///Users/jimmylawson/Downloads/commonlibrary/src/main/java/com/commonlibrary/commonlibrary/exceptions/UserNotFoundException.java:2:0-6:1) - Specific exception for user-related not found cases

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6.3 or higher
- Spring Boot 3.x

### Installation

Add the following dependency to your [pom.xml](cci:7://file:///Users/jimmylawson/Downloads/commonlibrary/pom.xml:0:0-0:0):

```xml
<dependency>
    <groupId>com.commonlibrary</groupId>
    <artifactId>common-library</artifactId>
    <version>1.0.0</version>
</dependency>