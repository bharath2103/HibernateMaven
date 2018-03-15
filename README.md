# HibernateMaven
we can embed collections also to the Entity class, but we will store the collections (Value Object) in a separate table and use the primary key of the entity Class as the foreign key for the Value Object

In the previous example we know that we have to use the ValueObject (UserAddress) twice

- userOfficeAddress
- userHomeAddress

But imagine a scenario where you have to store a collection of ValueObject (UserAddress) then we have to use a different approach

we have to implement @ElementCollection in the Entity class, to inform hibernate to persist the value Object in a seperate table

- The Name of the Separate table will be (<name of the entity class>_<name of the value object class>)
- The Foreign key of the Collection (Value Object) Table will be

          (<name of the entity class>_<name of the member variable of the primary key of entity class>)
