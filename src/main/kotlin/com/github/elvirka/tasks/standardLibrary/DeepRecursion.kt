package com.github.elvirka.tasks.standardLibrary

import java.lang.Integer.max

@ExperimentalStdlibApi
fun main() {
    val deepTree = generateSequence(Tree()) { Tree(it) }.take(100_000).last()
    //println(depth(deepTree))

    val deepDepth = DeepRecursiveFunction<Tree?, Int> { t ->
        if (t == null) 0 else max(callRecursive(t.left), callRecursive(t.right)) + 1
    }
    println(deepDepth(deepTree))

    val mutualRecursion = object {
        val even: DeepRecursiveFunction<Tree?, Int> = DeepRecursiveFunction { t ->
            if (t == null) 0 else odd.callRecursive(t.left) + odd.callRecursive(t.right) + 1
        }
        val odd: DeepRecursiveFunction<Tree?, Int> = DeepRecursiveFunction { t ->
            if (t == null) 0 else even.callRecursive(t.left) + even.callRecursive(t.right)
        }
    }
    println(mutualRecursion.even(deepTree))
    println(mutualRecursion.odd(deepTree))
}

fun depth(t: Tree?): Int =
    if (t == null) 0 else max(depth(t.left), depth(t.right)) + 1

class Tree(val left: Tree? = null, val right: Tree? = null)
