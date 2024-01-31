package com.wixpress.workshop.examples.ordinal

object OrderingExample extends App {
  class Person(val name: String, val age: Int) extends Ordinal[Person] {
    override def lt(other: Person): Boolean = {
      this.age < other.age
    }
  }

  val grut = new Person("Grut", 100)
  val spiderman = new Person("Peter Parker", 16)

  println(s"spiderman < grut: ${spiderman < grut}")
}
