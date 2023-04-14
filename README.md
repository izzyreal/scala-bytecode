# Scala compiler bytecode analysis

Scala compiler version 3.2.2

javap disassembler version 17.0.6

----------------------------

## Empty class

```scala
package foo
class Foo
```

```java
Compiled from "EmptyClass.scala"
Disassembled from "Foo.class"
public class foo.Foo {
  public foo.Foo();
    Code:
       0: aload_0
       1: invokespecial #9                  // Method java/lang/Object."<init>":()V
       4: return
}
```

----------

## Empty object

```scala
package foo
object Foo
```

```java
Compiled from "EmptyObject.scala"
Disassembled from "Foo$.class"
public final class foo.Foo$ implements java.io.Serializable {
  public static final foo.Foo$ MODULE$;

  private foo.Foo$();
    Code:
       0: aload_0
       1: invokespecial #13                 // Method java/lang/Object."<init>":()V
       4: return

  public static {};
    Code:
       0: new           #2                  // class foo/Foo$
       3: dup
       4: invokespecial #16                 // Method "<init>":()V
       7: putstatic     #18                 // Field MODULE$:Lfoo/Foo$;
      10: return

  private java.lang.Object writeReplace();
    Code:
       0: new           #22                 // class scala/runtime/ModuleSerializationProxy
       3: dup
       4: ldc           #2                  // class foo/Foo$
       6: invokespecial #25                 // Method scala/runtime/ModuleSerializationProxy."<init>":(Ljava/lang/Class;)V
       9: areturn
}

Compiled from "EmptyObject.scala"
Disassembled from "Foo.class"
public final class foo.Foo {
}
```

---------------

## Empty package object

```scala
package object foo
```

```java
Compiled from "EmptyPackageObject.scala"
Disassembled from "package$.class"
public final class foo.package$ implements java.io.Serializable {
  public static final foo.package$ MODULE$;

  private foo.package$();
    Code:
       0: aload_0
       1: invokespecial #13                 // Method java/lang/Object."<init>":()V
       4: return

  public static {};
    Code:
       0: new           #2                  // class foo/package$
       3: dup
       4: invokespecial #16                 // Method "<init>":()V
       7: putstatic     #18                 // Field MODULE$:Lfoo/package$;
      10: return

  private java.lang.Object writeReplace();
    Code:
       0: new           #22                 // class scala/runtime/ModuleSerializationProxy
       3: dup
       4: ldc           #2                  // class foo/package$
       6: invokespecial #25                 // Method scala/runtime/ModuleSerializationProxy."<init>":(Ljava/lang/Class;)V
       9: areturn
}

Compiled from "EmptyPackageObject.scala"
Disassembled from "package.class"
public final class foo.package {
}
```

-----------------

## Class with method

```scala
package foo
class Foo { def bar(): Int = 42 }
```

```java
Compiled from "MethodClass.scala"
Disassembled from "Foo.class"
public class foo.Foo {
  public foo.Foo();
    Code:
       0: aload_0
       1: invokespecial #9                  // Method java/lang/Object."<init>":()V
       4: return

  public int bar();
    Code:
       0: bipush        42
       2: ireturn
}
```

------------

## Object with method

```scala
package foo
object Foo { def bar(): Int = 42 }
```

```java
Compiled from "MethodObject.scala"
Disassembled from "Foo$.class"
public final class foo.Foo$ implements java.io.Serializable {
  public static final foo.Foo$ MODULE$;

  private foo.Foo$();
    Code:
       0: aload_0
       1: invokespecial #13                 // Method java/lang/Object."<init>":()V
       4: return

  public static {};
    Code:
       0: new           #2                  // class foo/Foo$
       3: dup
       4: invokespecial #16                 // Method "<init>":()V
       7: putstatic     #18                 // Field MODULE$:Lfoo/Foo$;
      10: return

  private java.lang.Object writeReplace();
    Code:
       0: new           #22                 // class scala/runtime/ModuleSerializationProxy
       3: dup
       4: ldc           #2                  // class foo/Foo$
       6: invokespecial #25                 // Method scala/runtime/ModuleSerializationProxy."<init>":(Ljava/lang/Class;)V
       9: areturn

  public int bar();
    Code:
       0: bipush        42
       2: ireturn
}

Compiled from "MethodObject.scala"
Disassembled from "Foo.class"
public final class foo.Foo {
  public static int bar();
    Code:
       0: getstatic     #13                 // Field foo/Foo$.MODULE$:Lfoo/Foo$;
       3: invokevirtual #15                 // Method foo/Foo$.bar:()I
       6: ireturn
}
```

-------------

## Package object with method

```scala
package object foo {
	def bar(): Int = 42
}
```

```java
Compiled from "MethodPackageObject.scala"
Disassembled from "package$.class"
public final class foo.package$ implements java.io.Serializable {
  public static final foo.package$ MODULE$;

  private foo.package$();
    Code:
       0: aload_0
       1: invokespecial #13                 // Method java/lang/Object."<init>":()V
       4: return

  public static {};
    Code:
       0: new           #2                  // class foo/package$
       3: dup
       4: invokespecial #16                 // Method "<init>":()V
       7: putstatic     #18                 // Field MODULE$:Lfoo/package$;
      10: return

  private java.lang.Object writeReplace();
    Code:
       0: new           #22                 // class scala/runtime/ModuleSerializationProxy
       3: dup
       4: ldc           #2                  // class foo/package$
       6: invokespecial #25                 // Method scala/runtime/ModuleSerializationProxy."<init>":(Ljava/lang/Class;)V
       9: areturn

  public int bar();
    Code:
       0: bipush        42
       2: ireturn
}

Compiled from "MethodPackageObject.scala"
Disassembled from "package.class"
public final class foo.package {
  public static int bar();
    Code:
       0: getstatic     #13                 // Field foo/package$.MODULE$:Lfoo/package$;
       3: invokevirtual #15                 // Method foo/package$.bar:()I
       6: ireturn
}
```

------------

## Extension method

```scala
package foo
object Foo {
  implicit class IntExt(val i: Int) {
    def someExtensionMethod(): Int = i
  }
}
```

```java
Compiled from "ExtMethod.scala"
Disassembled from "Foo$.class"
public final class foo.Foo$ implements java.io.Serializable {
  public static final foo.Foo$ MODULE$;

  private foo.Foo$();
    Code:
       0: aload_0
       1: invokespecial #18                 // Method java/lang/Object."<init>":()V
       4: return

  public static {};
    Code:
       0: new           #2                  // class foo/Foo$
       3: dup
       4: invokespecial #21                 // Method "<init>":()V
       7: putstatic     #23                 // Field MODULE$:Lfoo/Foo$;
      10: return

  private java.lang.Object writeReplace();
    Code:
       0: new           #27                 // class scala/runtime/ModuleSerializationProxy
       3: dup
       4: ldc           #2                  // class foo/Foo$
       6: invokespecial #30                 // Method scala/runtime/ModuleSerializationProxy."<init>":(Ljava/lang/Class;)V
       9: areturn

  public final foo.Foo$IntExt IntExt(int);
    Code:
       0: new           #9                  // class foo/Foo$IntExt
       3: dup
       4: iload_1
       5: invokespecial #35                 // Method foo/Foo$IntExt."<init>":(I)V
       8: areturn
}

Compiled from "ExtMethod.scala"
Disassembled from "Foo$IntExt.class"
public class foo.Foo$IntExt {
  private final int i;

  public foo.Foo$IntExt(int);
    Code:
       0: aload_0
       1: iload_1
       2: putfield      #14                 // Field i:I
       5: aload_0
       6: invokespecial #17                 // Method java/lang/Object."<init>":()V
       9: return

  public int i();
    Code:
       0: aload_0
       1: getfield      #14                 // Field i:I
       4: ireturn

  public int someExtensionMethod();
    Code:
       0: aload_0
       1: invokevirtual #23                 // Method i:()I
       4: ireturn
}

Compiled from "ExtMethod.scala"
Disassembled from "Foo.class"
public final class foo.Foo {
  public static foo.Foo$IntExt IntExt(int);
    Code:
       0: getstatic     #15                 // Field foo/Foo$.MODULE$:Lfoo/Foo$;
       3: iload_0
       4: invokevirtual #17                 // Method foo/Foo$.IntExt:(I)Lfoo/Foo$IntExt;
       7: areturn
}
```

-------------

## Extension method AnyVal

```scala
package foo
object Foo {
  implicit class IntExt(i: Int) extends AnyVal {
    def someExtensionMethod(): Int = i
  }
}
```

```java
Compiled from "ExtMethodAnyVal.scala"
Disassembled from "Foo$.class"
public final class foo.Foo$ implements java.io.Serializable {
  public static final foo.Foo$IntExt$ IntExt;

  public static final foo.Foo$ MODULE$;

  private foo.Foo$();
    Code:
       0: aload_0
       1: invokespecial #22                 // Method java/lang/Object."<init>":()V
       4: return

  public static {};
    Code:
       0: new           #2                  // class foo/Foo$
       3: dup
       4: invokespecial #25                 // Method "<init>":()V
       7: putstatic     #27                 // Field MODULE$:Lfoo/Foo$;
      10: return

  private java.lang.Object writeReplace();
    Code:
       0: new           #31                 // class scala/runtime/ModuleSerializationProxy
       3: dup
       4: ldc           #2                  // class foo/Foo$
       6: invokespecial #34                 // Method scala/runtime/ModuleSerializationProxy."<init>":(Ljava/lang/Class;)V
       9: areturn

  public final int IntExt(int);
    Code:
       0: iload_1
       1: ireturn
}

Compiled from "ExtMethodAnyVal.scala"
Disassembled from "Foo$IntExt$.class"
public final class foo.Foo$IntExt$ implements java.io.Serializable {
  public static final foo.Foo$IntExt$ MODULE$;

  public foo.Foo$IntExt$();
    Code:
       0: aload_0
       1: invokespecial #19                 // Method java/lang/Object."<init>":()V
       4: return

  public static {};
    Code:
       0: new           #2                  // class foo/Foo$IntExt$
       3: dup
       4: invokespecial #22                 // Method "<init>":()V
       7: putstatic     #24                 // Field MODULE$:Lfoo/Foo$IntExt$;
      10: return

  private java.lang.Object writeReplace();
    Code:
       0: new           #28                 // class scala/runtime/ModuleSerializationProxy
       3: dup
       4: ldc           #2                  // class foo/Foo$IntExt$
       6: invokespecial #31                 // Method scala/runtime/ModuleSerializationProxy."<init>":(Ljava/lang/Class;)V
       9: areturn

  public final int hashCode$extension(int);
    Code:
       0: iload_1
       1: invokestatic  #40                 // Method scala/runtime/BoxesRunTime.boxToInteger:(I)Ljava/lang/Integer;
       4: invokevirtual #46                 // Method java/lang/Integer.hashCode:()I
       7: ireturn

  public final boolean equals$extension(int, java.lang.Object);
    Code:
       0: aload_2
       1: astore_3
       2: aload_3
       3: instanceof    #9                  // class foo/Foo$IntExt
       6: ifeq          41
       9: aload_3
      10: ifnonnull     20
      13: aconst_null
      14: invokestatic  #54                 // Method scala/runtime/BoxesRunTime.unboxToInt:(Ljava/lang/Object;)I
      17: goto          27
      20: aload_3
      21: checkcast     #9                  // class foo/Foo$IntExt
      24: invokevirtual #57                 // Method foo/Foo$IntExt.foo$Foo$IntExt$$i:()I
      27: istore        4
      29: iload_1
      30: iload         4
      32: if_icmpne     39
      35: iconst_1
      36: goto          40
      39: iconst_0
      40: ireturn
      41: iconst_0
      42: ireturn

  public final int someExtensionMethod$extension(int);
    Code:
       0: iload_1
       1: ireturn
}

Compiled from "ExtMethodAnyVal.scala"
Disassembled from "Foo$IntExt.class"
public final class foo.Foo$IntExt {
  private final int i;

  public static boolean equals$extension(int, java.lang.Object);
    Code:
       0: getstatic     #19                 // Field foo/Foo$IntExt$.MODULE$:Lfoo/Foo$IntExt$;
       3: iload_0
       4: aload_1
       5: invokevirtual #21                 // Method foo/Foo$IntExt$.equals$extension:(ILjava/lang/Object;)Z
       8: ireturn

  public static int hashCode$extension(int);
    Code:
       0: getstatic     #19                 // Field foo/Foo$IntExt$.MODULE$:Lfoo/Foo$IntExt$;
       3: iload_0
       4: invokevirtual #25                 // Method foo/Foo$IntExt$.hashCode$extension:(I)I
       7: ireturn

  public static int someExtensionMethod$extension(int);
    Code:
       0: getstatic     #19                 // Field foo/Foo$IntExt$.MODULE$:Lfoo/Foo$IntExt$;
       3: iload_0
       4: invokevirtual #28                 // Method foo/Foo$IntExt$.someExtensionMethod$extension:(I)I
       7: ireturn

  public foo.Foo$IntExt(int);
    Code:
       0: aload_0
       1: iload_1
       2: putfield      #32                 // Field i:I
       5: aload_0
       6: invokespecial #35                 // Method java/lang/Object."<init>":()V
       9: return

  public int hashCode();
    Code:
       0: getstatic     #19                 // Field foo/Foo$IntExt$.MODULE$:Lfoo/Foo$IntExt$;
       3: aload_0
       4: invokevirtual #42                 // Method foo$Foo$IntExt$$i:()I
       7: invokevirtual #25                 // Method foo/Foo$IntExt$.hashCode$extension:(I)I
      10: ireturn

  public boolean equals(java.lang.Object);
    Code:
       0: getstatic     #19                 // Field foo/Foo$IntExt$.MODULE$:Lfoo/Foo$IntExt$;
       3: aload_0
       4: invokevirtual #42                 // Method foo$Foo$IntExt$$i:()I
       7: aload_1
       8: invokevirtual #21                 // Method foo/Foo$IntExt$.equals$extension:(ILjava/lang/Object;)Z
      11: ireturn

  public int foo$Foo$IntExt$$i();
    Code:
       0: aload_0
       1: getfield      #32                 // Field i:I
       4: ireturn

  public int someExtensionMethod();
    Code:
       0: getstatic     #19                 // Field foo/Foo$IntExt$.MODULE$:Lfoo/Foo$IntExt$;
       3: aload_0
       4: invokevirtual #42                 // Method foo$Foo$IntExt$$i:()I
       7: invokevirtual #28                 // Method foo/Foo$IntExt$.someExtensionMethod$extension:(I)I
      10: ireturn
}

Compiled from "ExtMethodAnyVal.scala"
Disassembled from "Foo.class"
public final class foo.Foo {
  public static int IntExt(int);
    Code:
       0: getstatic     #18                 // Field foo/Foo$.MODULE$:Lfoo/Foo$;
       3: iload_0
       4: invokevirtual #20                 // Method foo/Foo$.IntExt:(I)I
       7: ireturn
}
```

--------

## Extension method in package object

```scala
package object foo {
  implicit class IntExt(val i: Int) {
    def someExtensionMethod(): Int = i
  }
}
```

```java
Compiled from "ExtMethodPackageObject.scala"
Disassembled from "package$.class"
public final class foo.package$ implements java.io.Serializable {
  public static final foo.package$ MODULE$;

  private foo.package$();
    Code:
       0: aload_0
       1: invokespecial #18                 // Method java/lang/Object."<init>":()V
       4: return

  public static {};
    Code:
       0: new           #2                  // class foo/package$
       3: dup
       4: invokespecial #21                 // Method "<init>":()V
       7: putstatic     #23                 // Field MODULE$:Lfoo/package$;
      10: return

  private java.lang.Object writeReplace();
    Code:
       0: new           #27                 // class scala/runtime/ModuleSerializationProxy
       3: dup
       4: ldc           #2                  // class foo/package$
       6: invokespecial #30                 // Method scala/runtime/ModuleSerializationProxy."<init>":(Ljava/lang/Class;)V
       9: areturn

  public final foo.package$IntExt IntExt(int);
    Code:
       0: new           #9                  // class foo/package$IntExt
       3: dup
       4: iload_1
       5: invokespecial #35                 // Method foo/package$IntExt."<init>":(I)V
       8: areturn
}

Compiled from "ExtMethodPackageObject.scala"
Disassembled from "package$IntExt.class"
public class foo.package$IntExt {
  private final int i;

  public foo.package$IntExt(int);
    Code:
       0: aload_0
       1: iload_1
       2: putfield      #14                 // Field i:I
       5: aload_0
       6: invokespecial #17                 // Method java/lang/Object."<init>":()V
       9: return

  public int i();
    Code:
       0: aload_0
       1: getfield      #14                 // Field i:I
       4: ireturn

  public int someExtensionMethod();
    Code:
       0: aload_0
       1: invokevirtual #23                 // Method i:()I
       4: ireturn
}

Compiled from "ExtMethodPackageObject.scala"
Disassembled from "package.class"
public final class foo.package {
  public static foo.package$IntExt IntExt(int);
    Code:
       0: getstatic     #15                 // Field foo/package$.MODULE$:Lfoo/package$;
       3: iload_0
       4: invokevirtual #17                 // Method foo/package$.IntExt:(I)Lfoo/package$IntExt;
       7: areturn
}
```

------

## Extension method AnyVal in package object

```scala
package object foo {
  implicit class IntExt(i: Int) extends AnyVal {
    def someExtensionMethod(): Int = i
  }
}
```

```java
Compiled from "ExtMethodAnyValPackageObject.scala"
Disassembled from "package$.class"
public final class foo.package$ implements java.io.Serializable {
  public static final foo.package$IntExt$ IntExt;

  public static final foo.package$ MODULE$;

  private foo.package$();
    Code:
       0: aload_0
       1: invokespecial #22                 // Method java/lang/Object."<init>":()V
       4: return

  public static {};
    Code:
       0: new           #2                  // class foo/package$
       3: dup
       4: invokespecial #25                 // Method "<init>":()V
       7: putstatic     #27                 // Field MODULE$:Lfoo/package$;
      10: return

  private java.lang.Object writeReplace();
    Code:
       0: new           #31                 // class scala/runtime/ModuleSerializationProxy
       3: dup
       4: ldc           #2                  // class foo/package$
       6: invokespecial #34                 // Method scala/runtime/ModuleSerializationProxy."<init>":(Ljava/lang/Class;)V
       9: areturn

  public final int IntExt(int);
    Code:
       0: iload_1
       1: ireturn
}

Compiled from "ExtMethodAnyValPackageObject.scala"
Disassembled from "package$IntExt$.class"
public final class foo.package$IntExt$ implements java.io.Serializable {
  public static final foo.package$IntExt$ MODULE$;

  public foo.package$IntExt$();
    Code:
       0: aload_0
       1: invokespecial #19                 // Method java/lang/Object."<init>":()V
       4: return

  public static {};
    Code:
       0: new           #2                  // class foo/package$IntExt$
       3: dup
       4: invokespecial #22                 // Method "<init>":()V
       7: putstatic     #24                 // Field MODULE$:Lfoo/package$IntExt$;
      10: return

  private java.lang.Object writeReplace();
    Code:
       0: new           #28                 // class scala/runtime/ModuleSerializationProxy
       3: dup
       4: ldc           #2                  // class foo/package$IntExt$
       6: invokespecial #31                 // Method scala/runtime/ModuleSerializationProxy."<init>":(Ljava/lang/Class;)V
       9: areturn

  public final int hashCode$extension(int);
    Code:
       0: iload_1
       1: invokestatic  #40                 // Method scala/runtime/BoxesRunTime.boxToInteger:(I)Ljava/lang/Integer;
       4: invokevirtual #46                 // Method java/lang/Integer.hashCode:()I
       7: ireturn

  public final boolean equals$extension(int, java.lang.Object);
    Code:
       0: aload_2
       1: astore_3
       2: aload_3
       3: instanceof    #9                  // class foo/package$IntExt
       6: ifeq          41
       9: aload_3
      10: ifnonnull     20
      13: aconst_null
      14: invokestatic  #54                 // Method scala/runtime/BoxesRunTime.unboxToInt:(Ljava/lang/Object;)I
      17: goto          27
      20: aload_3
      21: checkcast     #9                  // class foo/package$IntExt
      24: invokevirtual #57                 // Method foo/package$IntExt.foo$package$IntExt$$i:()I
      27: istore        4
      29: iload_1
      30: iload         4
      32: if_icmpne     39
      35: iconst_1
      36: goto          40
      39: iconst_0
      40: ireturn
      41: iconst_0
      42: ireturn

  public final int someExtensionMethod$extension(int);
    Code:
       0: iload_1
       1: ireturn
}

Compiled from "ExtMethodAnyValPackageObject.scala"
Disassembled from "package$IntExt.class"
public final class foo.package$IntExt {
  private final int i;

  public static boolean equals$extension(int, java.lang.Object);
    Code:
       0: getstatic     #19                 // Field foo/package$IntExt$.MODULE$:Lfoo/package$IntExt$;
       3: iload_0
       4: aload_1
       5: invokevirtual #21                 // Method foo/package$IntExt$.equals$extension:(ILjava/lang/Object;)Z
       8: ireturn

  public static int hashCode$extension(int);
    Code:
       0: getstatic     #19                 // Field foo/package$IntExt$.MODULE$:Lfoo/package$IntExt$;
       3: iload_0
       4: invokevirtual #25                 // Method foo/package$IntExt$.hashCode$extension:(I)I
       7: ireturn

  public static int someExtensionMethod$extension(int);
    Code:
       0: getstatic     #19                 // Field foo/package$IntExt$.MODULE$:Lfoo/package$IntExt$;
       3: iload_0
       4: invokevirtual #28                 // Method foo/package$IntExt$.someExtensionMethod$extension:(I)I
       7: ireturn

  public foo.package$IntExt(int);
    Code:
       0: aload_0
       1: iload_1
       2: putfield      #32                 // Field i:I
       5: aload_0
       6: invokespecial #35                 // Method java/lang/Object."<init>":()V
       9: return

  public int hashCode();
    Code:
       0: getstatic     #19                 // Field foo/package$IntExt$.MODULE$:Lfoo/package$IntExt$;
       3: aload_0
       4: invokevirtual #42                 // Method foo$package$IntExt$$i:()I
       7: invokevirtual #25                 // Method foo/package$IntExt$.hashCode$extension:(I)I
      10: ireturn

  public boolean equals(java.lang.Object);
    Code:
       0: getstatic     #19                 // Field foo/package$IntExt$.MODULE$:Lfoo/package$IntExt$;
       3: aload_0
       4: invokevirtual #42                 // Method foo$package$IntExt$$i:()I
       7: aload_1
       8: invokevirtual #21                 // Method foo/package$IntExt$.equals$extension:(ILjava/lang/Object;)Z
      11: ireturn

  public int foo$package$IntExt$$i();
    Code:
       0: aload_0
       1: getfield      #32                 // Field i:I
       4: ireturn

  public int someExtensionMethod();
    Code:
       0: getstatic     #19                 // Field foo/package$IntExt$.MODULE$:Lfoo/package$IntExt$;
       3: aload_0
       4: invokevirtual #42                 // Method foo$package$IntExt$$i:()I
       7: invokevirtual #28                 // Method foo/package$IntExt$.someExtensionMethod$extension:(I)I
      10: ireturn
}

Compiled from "ExtMethodAnyValPackageObject.scala"
Disassembled from "package.class"
public final class foo.package {
  public static int IntExt(int);
    Code:
       0: getstatic     #18                 // Field foo/package$.MODULE$:Lfoo/package$;
       3: iload_0
       4: invokevirtual #20                 // Method foo/package$.IntExt:(I)I
       7: ireturn
}
```
