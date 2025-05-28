
# ArchUnit Test

https://www.archunit.org/userguide/html/000_Index.html#_architectures

### 8.1.2. Onion Architecture

In an "**Onion Architecture**" (also known as "**Hexagonal Architecture**" or "**Ports and Adapters**"), we can define 
domain packages and adapter packages as follows.

The semantic follows the descriptions in https://jeffreypalermo.com/2008/07/the-onion-architecture-part-1/. 
More precisely, the following holds:

The `domain` package is the core of the application. It consists of two parts:
- The `domainModels` packages contain the domain entities.
- The packages in `domainServices` contains services that use the entities in the `domainModel` packages.

The `applicationServices` packages contain services and configuration to run the application and use cases.
It can use the items of the domain package but there must not be any dependency from the domain to the `application` 
packages.

The `adapter` package contains logic to connect to external systems and/or infrastructure. No adapter may depend on
another adapter. Adapters can use both the items of the domain as well as the application packages. Vice versa, 
neither the domain nor the application packages must contain dependencies on any adapter package.