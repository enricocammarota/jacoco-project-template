# Jacoco Project Template

The project has the purpose of giving some guidelines over the inclusion of Jacoco within your application. A basic API
has been developed in order to offer a rough idea on how's supposed to work.

### Jacoco plugin

Jacoco is a test coverage tool who has the purpose of analysing if the source code has been efficiently covered by
appropriate unit tests. During the execution of the build, the plugin checks for the bytecode and verifies that
lines and branches have been properly covered by the various test scenarios.

The coverage checks can be more or less stringent, depending on the configuration specified in the pom.xml file:

```
 <configuration>
    <rules>
        <rule>
            <element>CLASS</element>
            <limits>
                <limit>
                    <counter>LINE</counter>
                    <value>COVEREDRATIO</value>
                    <minimum>70%</minimum>
                </limit>
                <limit>
                    <counter>BRANCH</counter>
                    <value>COVEREDRATIO</value>
                    <minimum>70%</minimum>
                </limit>
            </limits>
        </rule>
    </rules>
</configuration>
```

Please note the above configurations for the *minimum line covered ratio* and the *minimum branch covered ratio*.

The code coverage analysis will generate a report at the end of the maven build. The report can be found in:

```
target/site/jacoco/index.html
```

And in it there will be a full detail of what has been covered and what needs to be enhanced.

### Hot to run

Build using Maven.

```bash
mvn clean install
```

If you want to additionally build the docker image, you can run with a profile as follows:
```bash
mvn clean install -P docker
```

And you're now ready to query the API:

```bash
curl --location --request GET 'http://localhost:8801/student-api/{studentName}'
```


### Running the application locally

There is a compose file you can use:

- docker-compose.yml

The file is configured to run the application on port 8801 and therefore will be possible for you
to query the API through that port. Please run:

```bash
docker-compose up
```

In order to be able to use the API.