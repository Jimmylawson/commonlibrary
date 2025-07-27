# Common Library

A shared library containing common utilities, JWT authentication, and components for Spring Boot microservices.

## Features

- **JWT Authentication**
  - Token generation and validation
  - Refresh token support
  - Custom claims support
  - Configurable token expiration
- **Exception Handling**
  - Global exception handler for REST APIs
  - Standardized error responses
- **Base Components**
  - Base properties for configuration
  - Common DTOs and utilities

## Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- Spring Boot 3.5.4 or higher

## Installation

### Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.jimmyproject</groupId>
    <artifactId>commonlibrary</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### Gradle

```gradle
implementation 'com.jimmyproject:commonlibrary:0.0.1-SNAPSHOT'
```

## Building the Library

To build the library and install it to your local Maven repository:

```bash
mvn clean install
```

## Usage

### JWT Configuration

Add the following properties to your `application.yml` or `application.properties`:

```yaml
jwt:
  secret: your-jwt-secret-key
  expiration: 86400000  # 24 hours in milliseconds
  refresh-expiration: 604800000  # 7 days in milliseconds
```

### Enabling Components

Add `@ComponentScan("com.jimmyproject.utils")` to your main application class to enable all components.

## Testing

Run the tests with:

```bash
mvn test
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Quick Start

### 1. Configure JWT Properties

Add these properties to your `application.yml` or `application.properties`:

```yaml
jwt:
  secret-key: your-256-bit-secret-key-must-be-at-least-32-characters-long
  issuer: your-application-name
  expiration: 86400000  # 24 hours in milliseconds
```

### 2. Using JWT Authentication

```java
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;
    
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        // Authenticate user
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );
        
        // Generate tokens
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtTokenService.generateJwtToken(userDetails);
        String refreshToken = jwtTokenService.generateRefreshToken(userDetails);
        
        return ResponseEntity.ok(Map.of(
            "token", token,
            "refreshToken", refreshToken,
            "expiresIn", jwtTokenService.getExpirationTime().toString()
        ));
    }
}
```

## Building the Library

To build and install the library locally:

```bash
mvn clean install
```

## Publishing to Maven Central

1. Set up your OSSRH credentials in `~/.m2/settings.xml`:

```xml
<settings>
  <servers>
    <server>
      <id>ossrh</id>
      <username>your-jira-username</username>
      <password>your-jira-password</password>
    </server>
  </servers>
</settings>
```

2. Configure GPG for artifact signing (required for Maven Central):

```bash
# Install GPG if not installed
brew install gpg

# Generate a key if you don't have one
gpg --gen-key

# List your keys
gpg --list-keys

# Send your public key to a key server
gpg --keyserver keyserver.ubuntu.com --send-keys YOUR_KEY_ID
```

3. Add your GPG key details to `~/.m2/settings.xml`:

```xml
<settings>
  <profiles>
    <profile>
      <id>gpg</id>
      <properties>
        <gpg.executable>gpg</gpg.executable>
        <gpg.passphrase>your-gpg-passphrase</gpg.passphrase>
      </properties>
    </profile>
  </profiles>
</settings>
```

4. Deploy to Maven Central:

```bash
mvn clean deploy -P release
```

## Versioning

We use [SemVer](https://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/yourusername/common-library/tags).

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## Changelog

### 1.0.0
- Initial release with JWT authentication and common utilities
