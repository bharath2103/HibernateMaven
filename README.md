# HibernateMaven

When using the @OneToMany annotation in the primary entity, we tell the hibernate to create a new Table with the PrimaryKey of Primary entity and secondary entity as columns.

Example
USER_DETAILS_VEHICLE_DETAILS

The Primary entity is in One-Many Mapping
The Secondary entity is in Many-one Mapping

So rather than creating a new Table, we can persist the value to the Secondary Entity table itself, as a single vehicle can have only one user.

This saves space in the database.
