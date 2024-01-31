package com.wixpress.workshop.examples.ordinal

object OrderingImplicitExample extends App {
  class Person(val name: String, val age: Int)

  implicit class PersonOps(person: Person) extends Ordinal[Person] {
    override def lt(other: Person): Boolean = {
      person.age < other.age
    }
  }

  val grut = new Person("Grut", 100)
  val spiderman = new Person("Peter Parker", 16)

  println(s"spiderman < grut: ${spiderman < grut}")
}
