# micro-service-customer-service


![globale](/images/1.jpg)

### MapStruct Plugin Processor Config

```

<plugin>
 <groupId>org.apache.maven.plugins</groupId>
 <artifactId>maven-compiler-plugin</artifactId>
 <version>4.0.0</version>
 <configuration>
    <source>17</source> <!--depending on your project-->
    <target>17</target> <!--depending on your project-->
    <annotationProcessorPaths>
     <path>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>1.18.24</version>
     </path>
     <path>
       <groupId>org.mapstruct</groupId>
       <artifactId>mapstruct-processor</artifactId>
       <version>1.5.2.Final</version>
     </path>
     <!--Other annotation processors-->
    </annotationProcessorPaths>
 </configuration>
</plugin>

```
