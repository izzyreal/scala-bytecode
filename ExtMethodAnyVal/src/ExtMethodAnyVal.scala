package foo
object Foo {
  implicit class IntExt(i: Int) extends AnyVal {
    def someExtensionMethod(): Int = i
  }
}
