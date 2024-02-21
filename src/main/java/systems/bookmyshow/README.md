 ## Spring JPA Annotations
 * @MappedSuperclass : BaseModel class - inherited by all other classes.
 * @Entity : Designate to classes whose tables need to be created/ updated in DB.
 * @Table(name = "CITIES") : If want some other table name than default ex - "city" for City class.
 * @OneToMany : Define relationship between attribute & it's class with cardinality
 * @Id : Primary Key for a table
 * @GeneratedValue(strategy = GenerationType.IDENTITY) : How Id is automatically generated (AUTO/ SEQUENCE/ ..)
 * @CreatedDate : createdAt field is auto-populated
 * @LastModifiedDate : updatedAt field is auto-populated
 * @EntityListeners(AuditingEntityListener.class) : _BaseModel.java_, above createdAt & updatedAt fields are auto-populated
 * @EnableJpaAuditing : _BookmyshowApplication.java_, createdAt & updatedAt fields are auto-populated
 * @Enumerated : Correlate a field with an enum class
 * @ElementCollection : List of datatype, create a mapping table
 * @Transactional : Annotating a method or class as transactional means that any database operations performed within the marked method or class will be executed within a transaction. If the transaction is successful, the changes will be committed to the database. If the transaction fails, the changes will be rolled back.
