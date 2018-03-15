# HibernateMaven

If we want to change the name of the Collection of ValueObject table then we have to use @JoinTable
Ex:
@JoinTable(name = "USER_ADDRESS")

If we want to change the name of the foreign key in the Collection of the value object then we have to use @JoinColumn
Ex:
@JoinTable(name = "USER_ADDRESS", @JoinColumns(@JoinColumn(name = "USER_ID")))

If we want to create a primary key for the table which has the collection of Value Object, then we have to use
Ex:
@GenericGenerator(name = "sequence-gen", strategy = "sequence")
@CollectionId(columns = {@Column(name = "ADDRESS_ID")}, type = @Type(type = "long"), generator = "sequence-gen")

Note:
@GenericGenerator & @CollectionID belongs to hibernate package, and all other annotations belongs to java.persistence package.
