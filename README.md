# List of practiced topics

### Spring Boot Dependencies
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Spring Boot DevTools
- Validation
- Spring HATEOAS

### Rest Controller
[[UserRestController]()]
- @RequestBody: bind the request body to request method parameter 
- Recommend: return a created status (201) for POST method 
- Recommend: return customized error for single entity methods (GET, DELETE) in case not found
- Recommend: apply Validation API for POST, PUT method 
[[User]()]
- HATEOAS

### Internationalization
1. Configure LocaleResolver and default Locale 
[[SpringRestBootApplication]()]
2. Create resource for messages (important: use ```_```) 
[[message.properties]()] [[message_french.properties]()] [[message_vietnam.properties]()]
3. Configure ResourceBundleMessageSource with the created sources 
   - In the application 
[[SpringRestBootApplication]()]
   - In 
[application.properties]()
4. Inject the MessageSource into Rest Controller 
[[DemoRestController]()]
5. Update the internationalized API


### Notes
- @PathVariable and @RequestParam: bind path variable to request method parameter 
[[DemoRestController]()]

