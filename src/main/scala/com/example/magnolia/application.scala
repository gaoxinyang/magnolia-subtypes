package com.example.magnolia

import org.example.magnolia.B.Root
import org.example.magnolia.A.codec.implicits._
import org.example.magnolia.C.codec.implicits._
import org.example.magnolia.B.codec.implicits._
object application extends App {
  val allSubtypes = Syntax.getSubtypes[Root]

  println(allSubtypes)

}
