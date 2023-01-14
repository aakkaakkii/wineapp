package com.wine.userservice.service;

import com.wine.userservice.domain.dto.ItemDto;
import com.wine.userservice.domain.entity.Item;
import com.wine.userservice.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemService extends AbstractService<Long, ItemDto, Item, ItemRepository> {
    @Autowired
    public ItemService(ItemRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

    @Override
    public Class<Item> getEntityClass() {
        return Item.class;
    }

    @Override
    public Class<ItemDto> getDTOClass() {
        return ItemDto.class;
    }

    public Item getItemById(Long id) {
        return repository.findItemById(id);
    }
}
