package com.github.elvirka.tasks.educative.dsl

fun main() {
    val langsAndAuthors =
        mapOf("JavaScript" to "Eich", "Java" to "Gosling", "Ruby" to "Matz")

    val xmlString = xml {
        root("languages") {
            langsAndAuthors.forEach { (name, author) ->
                element("language", "name" to name) {
                    element("author") { text(author) }
                }
            }
        }
    }
    println(xmlString)
}

fun xml(block: XMLBuilder.() -> Node): Node = XMLBuilder().run(block)

@DslMarker
annotation class XMLMarker

@XMLMarker
class XMLBuilder {
    fun root(rootElementName: String, block: Node.() -> Unit): Node =
    Node(rootElementName).apply(block)
}

@XMLMarker
class Node(val name: String) {
    var attributes: Map<String, String> = mutableMapOf()
    var children: List<Node> = listOf()
    var textValue: String = ""

    fun text(value: String) { textValue = value }

    fun element(childName: String,
                vararg attributeValues: Pair<String, String>,
                block: Node.() -> Unit): Node {

        val child = Node(childName)
        attributeValues.forEach { child.attributes += it }
        children = children + child
        return child.apply(block)
    }

    private fun toString(indentation: Int): String {
        val attributesValues = if (attributes.isEmpty()) "" else
            attributes.map { "${it.key}='${it.value}'" }.joinToString(" ", " ")

        val depth = 2
        val indent = " ".repeat(indentation)

        return if (textValue.isNotEmpty())
            "$indent<$name$attributesValues>$textValue</$name>"
        else
            """$indent<$name$attributesValues>
          |${children.joinToString("\n") { it.toString(indentation + depth) }}
          |$indent</$name>""".trimMargin()
    }

    override fun toString() = toString(0)
}