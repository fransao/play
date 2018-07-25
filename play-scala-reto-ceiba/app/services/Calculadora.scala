package services

import javax.inject._

/**
 * This trait demonstrates how to create a component that is injected
 * into a controller. The trait represents a counter that returns a
 * incremented number each time it is called.
 */
trait Calculadora {
  def sum(a:Int, b:Int): Int
  def rest(a:Int, b:Int): Int
  def mul(a:Int, b:Int): Int
  def div(a:Int, b:Int): Int
}

/**
 * This class is a concrete implementation of the [[Calculadora]] trait.
 * It is configured for Guice dependency injection in the [[Module]]
 * class.
 *
 * This class has a `Singleton` annotation because we need to make
 * sure we only use one counter per application. Without this
 * annotation we would get a new instance every time a [[Calculadora]] is
 * injected.
 */
@Singleton
class OpeCalculadora extends Calculadora {
  //private val opeCalculadora = new OpeCalculadora()
  override def sum(a:Int, b:Int):  Int = a + b
  override def rest(a:Int, b:Int): Int = a - b
  override def mul(a:Int, b:Int):  Int = a * b
  override def div(a:Int, b:Int):  Int = a / b
}
