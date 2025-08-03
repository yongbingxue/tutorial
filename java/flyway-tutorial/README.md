
- create the project

```shell
 mvn archetype:generate -B \
    -DarchetypeGroupId=org.apache.maven.archetypes \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DarchetypeVersion=1.1 \
    -DgroupId=com.yongbing \
    -DartifactId=flyway-tutorial \
    -Dversion=1.0-SNAPSHOT \
    -Dpackage=flywaytutorial
```


- run the migrate
```shell
mvn flyway:migrate

```