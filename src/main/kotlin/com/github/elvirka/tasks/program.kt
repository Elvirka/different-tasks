package com.github.elvirka.tasks
import org.springframework.web.util.UriComponentsBuilder
import java.net.URL

fun main() {
    val baseUrl = "http://backservice.exp/dir1/{string}/dir3/dir4"
    val params = mapOf("string" to "../?dummy=")
    val queryParam1 = "val1&foo=bar"
    val queryParam2 = "val2"
    val url1 = UriComponentsBuilder.fromUriString(baseUrl).buildAndExpand(params).toUriString()
    printUrlInfo(url1)
    val url2 = UriComponentsBuilder.fromUriString(baseUrl)
        .queryParam("par1", queryParam1)
        .queryParam("par2", queryParam2)
        .buildAndExpand(mapOf("string" to "dir2"))
        .toUriString()
    printUrlInfo(url2)
    val url3 = UriComponentsBuilder.fromUriString(baseUrl)
        .queryParam("par1", queryParam1)
        .queryParam("par2", queryParam2)
        .buildAndExpand(params)
        .encode()
        .toUriString()
    val normalizedUrl3 = UriComponentsBuilder.fromUriString(url3).build().normalize().toUriString()
    printUrlInfo(url3)
    printUrlInfo(normalizedUrl3)
    println(url3.equals(normalizedUrl3))
}

fun printUrlInfo (url: String) {
    println(url)
    val parsedURL = URL(url)
    println(java.lang.String.format("\thost: %s, path: %s", parsedURL.host, parsedURL.path))
    val queryParams = parsedURL.query.split("&")
    queryParams.forEach {
        val keyValue = it.split("=")
        println(java.lang.String.format("\t\t%s: %s", keyValue[0], keyValue[1]))
    }
}


