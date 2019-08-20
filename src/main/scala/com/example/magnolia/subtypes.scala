package com.example.magnolia

import language.experimental.macros
import magnolia._
import org.example.magnolia.B.Root

case class Error(value: String)

trait Subtypes[T] { def get: List[String]}

object Subtypes {
  type Typeclass[T] = Subtypes[T]
  def combine[T](ctx: CaseClass[Subtypes, T]): Subtypes[T] =
    new Subtypes[T] {
      override def get: List[String] = List(ctx.typeName.full)
    }

  def dispatch[T](ctx: SealedTrait[Subtypes, T]): Subtypes[T] =
    new Subtypes[T] {
      override def get: List[String] = ctx.subtypes.toList.map(_.typeName.full)
    }

  implicit def gen[T]: Subtypes[T] = macro Magnolia.gen[T]

  implicit val string: Subtypes[String] = new Subtypes[String] {
    override def get: List[String] = List.empty
  }
  implicit val boolean: Subtypes[Boolean] = new Subtypes[Boolean] {
    override def get: List[String] = List.empty
  }
}

object Syntax {
  def getSubtypes[T](implicit s: Subtypes[T]): List[String] = s.get
}