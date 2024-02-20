 ## Spring JPA Annotations
 * @MappedSuperclass : BaseModel class - inherited by all other classes.
 * @Entity : Designate to classes whose tables need to be created/ updated in DB.
 * @Table(name = "CITIES") : If want some other table name than default ex - "city" for City class.
 * @OneToMany : Define relationship between attribute & it's class with cardinality
 * @Id : Primary Key for a table
 * @GeneratedValue(strategy = GenerationType.IDENTITY) : How Id is automatically generated (AUTO/ SEQUENCE/ ..)
 * @CreatedDate : createdAt field is auto-populated
 * @LastModifiedDate : updatedAt field is auto-populated
 * @Enumerated : Correlate a field with an enum class
 * @ElementCollection : List of datatype, create a mapping table