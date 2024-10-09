package com.learning.wishlist

import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/items")
class ItemController(private val itemService: ItemService) {

    @GetMapping
    fun getAllItems(
        @RequestParam(defaultValue = "id") sortBy: String,
        @RequestParam(defaultValue = "asd") order: String
    ): List<Item> {
        val sort = if (order == "asc") Sort.by(sortBy).ascending() else Sort.by(sortBy).descending()

        return itemService.findAll(sort)
    }

    @PostMapping
    fun addItem(@RequestBody item: Item): Item = itemService.addItem(item)

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: Long): ResponseEntity<Item> =
        itemService.findItemById(id)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

//    @PutMapping("/{id}")
//    fun updateItem(@PathVariable id: Long, @RequestBody newItem: Item): ResponseEntity<Item> =
//        itemService.updateItem(newItem)?.let { ResponseEntity.ok(it) }
//            ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: Long): ResponseEntity<Void> {
        itemService.deleteItem(id)
        return ResponseEntity.noContent().build()
    }

}