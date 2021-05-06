package com.github.elvirka.tasks

import java.util.Stack

import java.util.LinkedHashSet
import java.util.LinkedList

import java.util.Queue

fun main() {
    val pairs = arrayOf("Bob" to "Alice", "Bob" to "Rob", "Alice" to "Mark", "Rob" to "Mark", "Alice" to "Maria", "Rob" to "Maria")
    val graph = createAdjacencyList(pairs)
    println(graph)

    println(depthFirstTraversal(graph, "Bob"))
    println(breadthFirstTraversal(graph, "Bob"))
}

fun createAdjacencyList(pairs: Array<Pair<String, String>>): HashMap<String, MutableList<String>> {
    val graph: HashMap<String, MutableList<String>> = hashMapOf()
    pairs.forEach { pair ->
        if (pair.first in graph) {
            graph[pair.first]?.add(pair.second)
        } else {
            graph[pair.first] = mutableListOf(pair.second)
        }
    }
    return graph
}

fun depthFirstTraversal(graph: HashMap<String, MutableList<String>>, root: String): Set<String> {
    val visited = LinkedHashSet<String>()
    val stack = Stack<String>()
    stack.push(root)
    while (!stack.isEmpty()) {
        val vertex = stack.pop()
        if (vertex !in visited) {
            visited.add(vertex)
            for (v in graph.getOrDefault(vertex, listOf())) {
                stack.push(v)
            }
        }
    }
    return visited
}
fun breadthFirstTraversal(graph: HashMap<String, MutableList<String>>, root: String): Set<String> {
    val visited = LinkedHashSet<String>()
    val queue: Queue<String> = LinkedList()
    queue.add(root)
    while (!queue.isEmpty()) {
        val vertex = queue.poll()
        if (vertex !in visited) {
            visited.add(vertex)
            for (v in graph.getOrDefault(vertex, listOf())) {
                queue.add(v)
            }
        }
    }
    return visited
}

