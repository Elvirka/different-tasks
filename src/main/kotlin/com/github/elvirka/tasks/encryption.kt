package com.github.elvirka.tasks

import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import org.apache.commons.lang3.RandomStringUtils

fun main() {
    val length = 32
    val useLetters = true
    val useNumbers = false
    val key = RandomStringUtils.random(length, useLetters, useNumbers)
    println(key)
    val enc = encrypt("VAKE", key)
    println(enc)
    println(decrypt(enc, key))

}
// 78V2 VAKE

fun encrypt(input: String, key: String): String {
    val cipher = Cipher.getInstance("AES")
    val keySpec = SecretKeySpec(key.toByteArray(), "AES")
    cipher.init(Cipher.ENCRYPT_MODE, keySpec)
    val encrypt = cipher.doFinal(input.toByteArray())
    return Base64.getEncoder().encodeToString(encrypt)
}

fun decrypt(input: String, key: String): String {
    val cipher = Cipher.getInstance("AES")
    val keySpec = SecretKeySpec(key.toByteArray(), "AES")
    cipher.init(Cipher.DECRYPT_MODE, keySpec)
    val decrypt = cipher.doFinal(Base64.getDecoder().decode(input))
    return String(decrypt)
}