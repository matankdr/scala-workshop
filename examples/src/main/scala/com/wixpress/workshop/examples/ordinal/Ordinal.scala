package com.wixpress.workshop.examples.ordinal

trait Ordinal[T] {
  def lt(other: T): Boolean
  def le(other: T): Boolean = lt(other) || this == other
  def gte(other: T): Boolean = !lt(other)
  def gt(other: T): Boolean = !le(other)

  def <(other: T): Boolean = lt(other)
  def <=(other: T): Boolean = le(other)
  def >=(other: T): Boolean = gte(other)
  def >(other: T): Boolean = gt(other)
}
