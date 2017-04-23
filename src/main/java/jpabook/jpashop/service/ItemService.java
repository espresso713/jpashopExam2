package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.item.QItem;
import jpabook.jpashop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hyun on 2017-01-15.
 */
@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void save(Item item) {
        itemRepository.save(item);
    }

    public Item findOne(Long ItemId) {
        return itemRepository.findOne(ItemId);
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public List<Item> findAll() {
        QItem item = QItem.item;
        itemRepository.findAll(item.name.contains("장난감").and(item.price.between(10,20))); //  QueryDsl사용 - QueryDslPredicateExecutor<Item>
        return null;
    }
}
