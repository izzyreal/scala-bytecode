package foo
object Foo {
  implicit class IntExt(val i: Int) {
    def someExtensionMethod(): Int = i
  }
}
