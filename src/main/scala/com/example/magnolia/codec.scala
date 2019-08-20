package org.example.magnolia.A.codec {
  import com.example.magnolia.Subtypes
  import org.example.magnolia.A.{A, A1, A2}

  object implicits {
    import org.example.magnolia.A.codec.implicits.A2_imp

    implicit lazy val A_imp: Subtypes[A] = Subtypes.gen
    implicit lazy val A1_imp: Subtypes[A1] = Subtypes.gen
    implicit lazy val A2_imp: Subtypes[A2] = Subtypes.gen
  }
}

package org.example.magnolia.B.codec {

  import com.example.magnolia.Subtypes
  import org.example.magnolia.B.{CCC, CCC1, CCC2, Root, Root1}

  object implicits {

    import org.example.magnolia.C.codec.implicits.C_imp

    implicit lazy val Root_imp: Subtypes[Root] = Subtypes.gen
    implicit lazy val Root1_imp: Subtypes[Root1] = Subtypes.gen
    implicit lazy val CCC_imp: Subtypes[CCC] = Subtypes.gen
    implicit lazy val CCC1_imp: Subtypes[CCC1] = Subtypes.gen
    implicit lazy val CCC2_imp: Subtypes[CCC2] = Subtypes.gen
  }
}

package org.example.magnolia.C.codec {

  import com.example.magnolia.Subtypes
  import org.example.magnolia.C.{C, C1, C2, C3, CC, CC1, CC2, CC3}

  object implicits {
    // comment out the following 4 imports
    import org.example.magnolia.C.codec.implicits.C2_imp
    import org.example.magnolia.B.codec.implicits.CCC_imp
    import org.example.magnolia.B.codec.implicits.CCC1_imp
    import org.example.magnolia.B.codec.implicits.CCC2_imp

    implicit lazy val C_imp: Subtypes[C] = Subtypes.gen
    implicit lazy val C1_imp: Subtypes[C1] = Subtypes.gen
    implicit lazy val C2_imp: Subtypes[C2] = Subtypes.gen
    implicit lazy val C3_imp: Subtypes[C3] = Subtypes.gen
    implicit lazy val CC_imp: Subtypes[CC] = Subtypes.gen
    implicit lazy val CC1_imp: Subtypes[CC1] = Subtypes.gen
    implicit lazy val CC2_imp: Subtypes[CC2] = Subtypes.gen
    implicit lazy val CC3_imp: Subtypes[CC3] = Subtypes.gen
  }
}

