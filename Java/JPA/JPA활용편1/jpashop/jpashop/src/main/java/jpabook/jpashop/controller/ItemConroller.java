package jpabook.jpashop.controller;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemConroller {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new Book());
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String create(BookForm form) {
        Book book = new Book();     //다음부터는 생성자로 값을 받도록 하자! setter는 사용 지양하기
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book);

        return "redirect:/";
    }

    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findItem();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @GetMapping("/items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
        Book item = (Book) itemService.findOne(itemId);

        BookForm form = new BookForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        form.setAuthor(item.getAuthor());
        form.setIsbn(item.getIsbn());

        model.addAttribute("form", form);
        return "items/updateItemForm";
    }


    @PostMapping("items/{itemId}/edit")
    public String updateItem(@ModelAttribute("form") BookForm form,@PathVariable("itemId")Long itemId) {

//        Book book = new Book();
//        //누군가가 id값을 악의적으로 수정해서 입력할 수 있기 떄문에 이러한 취약점을 주의해야 한다.
//        book.setId(form.getId());
//        book.setName(form.getName());
//        book.setPrice(form.getPrice());
//        book.setStockQuantity(form.getStockQuantity());
//        book.setAuthor(form.getAuthor());
//        book.setIsbn(form.getIsbn());
//
//        itemService.saveItem(book);

        //어설프게 엔티티를 만들기 보다는 확실히 로직을 만들자.
        // 트랜잭션이 있는 서비스계층에서 식별자와 변경할 데이터를 확실히 제공하자.
        // 서비스 곛으에서 엔티티의 데이터를 직접 변경하자.
        // 트랜잭션 커밋 시점에 변경 감지가 실행되어 알아서 업데이트 구문이 날아간다.
        Item item = itemService.updateItem(itemId, form.getPrice(), form.getName(), form.getStockQuantity());

        return "redirect:/items";
    }
}
