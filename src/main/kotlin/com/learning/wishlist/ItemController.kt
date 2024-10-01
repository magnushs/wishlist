package com.learning.wishlist

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/items")
class ItemController(private val itemService: ItemService) {

    @GetMapping
    fun getAllItems(): List<Item> = itemService.findAll()

    @GetMapping("/thisonethatdoesntwork")
    fun get404(): List<Item> = itemService.findAll()

    @PostMapping
    fun addItem(@RequestBody item: Item): Item = itemService.addItem(item)

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: Long): ResponseEntity<Item> =
        itemService.findItemById(id)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: Long, @RequestBody newItem: Item): ResponseEntity<Item> =
        itemService.updateItem(newItem)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: Long): ResponseEntity<Void> {
        itemService.deleteItem(id)
        return ResponseEntity.noContent().build()
    }

}