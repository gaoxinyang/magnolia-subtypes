package org.example.magnolia.A {

  import org.example.magnolia.B.Root

  sealed trait A extends Root {
    def a1: String
  }

  case class A1(b2: String, a1: String, a2: A2) extends A

  case class A2(b2: String, a1: String) extends A
}

package org.example.magnolia.B {

  import org.example.magnolia.C.{C, CC}

  sealed trait Root {
    def b2: String
  }

  case class Root1(b2: String) extends Root

  sealed trait CCC extends CC

  case class CCC1(b1: C, b2: String, c1: Boolean) extends CCC
  case class CCC2(b1: C, b2: String, c1: Boolean) extends CCC
}

package org.example.magnolia.C {

  import org.example.magnolia.B.{CCC, CCC1, Root}

  sealed trait C extends Root{
    def c1: Boolean
  }

  case class C1(b1: C, b2: String, c1: Boolean, c2: C2) extends C
  case class C2(b1: C, b2: String, c1: Boolean, c2: String) extends C
  case class C3(b1: C, b2: String, c1: Boolean) extends C

  sealed trait CC extends C

  case class CC1(b1: C, b2: String, c1: Boolean) extends CC
  case class CC2(b1: C, b2: String, c1: Boolean, c2: CCC1) extends CC
  case class CC3(b1: C, b2: String, c1: Boolean, c2: CCC) extends CC

}

