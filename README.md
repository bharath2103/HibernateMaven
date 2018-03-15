# HibernateMaven

we can embed value objects to the primary key as well by using @Embedded in the entity class

- We cannot use @GenerateValue(Strategy = GenerationType.AUTO)
- we cannot use @Id
- Rather we should use @EmbeddedID (Composite primary key)

in this case the Embedded Object (Value_Object) becomes the primary key.
Now hibernate treats all the member variable of the Value_Object as primary key. 
Any duplicates in any of the member variable will not be accepted by hibernate.
