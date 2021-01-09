## Clean Architecture in Android — a beginner approach
A clean architecture starting point for android projects

Check my article on Medium: https://nicola-gallazzi-dev.medium.com/clean-architecture-in-android-a-beginner-approach-be0ce00d806b

## Layers
1. Presentation: the layer that interacts with the UI.

2. Use cases: The actions that the user can trigger (clicking on a button, navigating to a destination)

3. Domain: contains all the business models (data classe    s)

4. Data: contains an abstract definition of different data sources. It's modeled using repositories and data sources

5. Framework: implements the dependencies (proper of android framework) we provided in the rest of the layers. Should contain classes specific of the android framework

## App modules
- App: includes everything about android framework, so Framework and Presentation layer
- Domain: contains the definitions of business logic of the app, the server data model, the abstract definition of repositories and the definition of the use cases. It’s a simple, pure kotlin module (android independent)
- Data: contains the implementation of the abstract definitions of the domain layer. Can be reused by any application without modifications. It contains repositories and data sources implementations, the database definition and its DAOs, the network APIs definitions, some mappers to convert network api models to database models and vice versa.
