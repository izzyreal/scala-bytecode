package object foo {
  implicit class IntExt(i: Int) extends AnyVal {
    def someExtensionMethod(): Int = i
  }
}
