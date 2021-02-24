package com.github.elvirka.tasks.functionalBook

fun main() {
    printSpeak(Canine())
    printSpeak(Dog())

    printSpeak(Feline())
    printSpeak(Cat())

    printSpeak(Primate("Koko"))
    printSpeak(GiantApe("Kong"))

    println("------------------------")
    val adam = Caregiver("Adam")
    val fulgencio = Cat()
    val koko = Primate("Koko")
    val brenda = Vet("Brenda")
    listOf(adam, brenda).forEach { caregiver ->
        println("${caregiver.javaClass.simpleName} ${caregiver.name}")
        caregiver.takeCare(fulgencio)
        caregiver.takeCare(koko)
    }
}

open class Canine { open fun speak() = "<generic canine noise>" }
class Dog : Canine() { override fun speak() = "woof!!" }
fun Dog.speak() = "meow!!"
fun printSpeak(canine: Canine) { println(canine.speak()) }

open class Feline
fun Feline.speak() = "<generic feline noise>"
class Cat : Feline()
fun Cat.speak() = "meow!!"
fun printSpeak(feline: Feline) { println(feline.speak()) }

open class Primate(val name: String)
fun Primate.speak() = "${this.javaClass.canonicalName}: <generic primate noise>"
open class GiantApe(name: String) : Primate(name)
fun GiantApe.speak() = "${this.name} :<scary 100db roar>"
fun printSpeak(primate: Primate) { println(primate.speak()) }

open class Caregiver(val name: String) {
    open fun Feline.react() = "PURRR!!!"
    fun Primate.react() = "*$name plays with ${this@Caregiver.name}*"
    fun takeCare(feline: Feline) {
        println("Feline reacts: ${feline.react()}")
    }
    fun takeCare(primate: Primate){
        println("Primate reacts: ${primate.react()}")
    } }

open class Vet(name: String): Caregiver(name) {
    override fun Feline.react() = "*runs away from $name*"
}
