String.metaClass.methodDefinedClass = { ->
  println "methodDefinedClass"
}
"hoge".methodDefinedClass()
// -> methodDefinedClass
"fuga".methodDefinedClass()
// -> methodDefinedClass

"moge".metaClass.methodDefinedSingletonClass = { ->
  println "methodDefinedSingletonClass"
}
"moge".methodDefinedSingletonClass()
// -> methodDefinedSingletonClass


boolean existMethod(obj, methodName) {
  obj.metaClass.methods.find { method ->
    method.name == methodName
  }
}

ret = existMethod("hoge", "methodDefinedClass")
assert(ret == true)

ret = existMethod("hoge", "methodDefinedSingletonClass")
assert(ret == false)

ret = existMethod("moge", "methodDefinedClass")
assert(ret == true)

ret = existMethod("moge", "methodDefinedSingletonClass")
assert(ret == true)

