package com.learning.wishlist

import org.springframework.stereotype.Service

@Service
class ItemService(val itemRepository: ItemRepository) {
    fun findAll(): List<Item> = itemRepository.findAll()
    fun addItem(item: Item): Item = itemRepository.save(item)
    fun findItemById(id: Long): Item? = itemRepository.findById(id).orElse(null)
    fun updateItem(newItem: Item): Item? {
        return itemRepository.findById(newItem.id).map {
                it.copy(name = newItem.name, priority = newItem.priority)
            }.orElse(null)?.let { itemRepository.save(it) }
    }
    fun deleteItem(id: Long) = itemRepository.deleteById(id)
}