package object foo {
  implicit class IntExt(val i: Int) {
    def someExtensionMethod(): Int = i
  }
}
