# micro-service-customer-service


![globale](/images/1.jpg)


![modele_asynchrone](/images/modele_asynchrone.jpg)




### Links

[mapstruct](https://mapstruct.org/)

[swagger-ui](http://localhost:8082/swagger-ui/index.html)

[api-docs](http://localhost:8082/v3/api-docs)




### MapStruct Plugin Processor Config

```

<plugin>
 <groupId>org.apache.maven.plugins</groupId>
 <artifactId>maven-compiler-plugin</artifactId>
 <version>3.10.1</version>
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

### without mapStruct

```
/* Mapping OBJECT OBJECT */

public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer = new Customer();
        customer.setId(customerRequestDTO.getId());
        customer.setName(customerRequestDTO.getName());
        customer.setEmail(customerRequestDTO.getEmail());

        customer.setId(UUID.randomUUID().toString());
        Customer savedCustomer = customerRepository.save(customer);

        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setId(savedCustomer.getId());
        customerResponseDTO.setName(savedCustomer.getName());
        customerResponseDTO.setEmail(savedCustomer.getEmail());

        return customerResponseDTO;
    }
```


### with mapStruct

##### 1- create an interface 

```
@Mapper(componentModel = "spring")
public interface CustomerMapper {
CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
Customer customerRequestDtoToCustomer(CustomerRequestDTO customerRequestDTO);
}
```

#####

```
public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {

        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDTO);
        Customer savedCustomer = customerRepository.save(customer);

        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(savedCustomer);
        return customerResponseDTO;
    }
```
