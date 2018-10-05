package com.ozcloud.restaurant.components;

import com.ozcloud.restaurant.enums.ItemType;
import com.ozcloud.restaurant.enums.ProductStatus;
import com.ozcloud.restaurant.model.Item;
import com.ozcloud.restaurant.model.Product;
import com.ozcloud.restaurant.model.User;
import com.ozcloud.restaurant.repository.ItemRepository;
import com.ozcloud.restaurant.repository.ProductRepository;
import com.ozcloud.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;
    private ItemRepository itemRepository;
    private ProductRepository productRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, ItemRepository itemRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.productRepository = productRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void run(ApplicationArguments args) {
        User user = userRepository.findByUserName("admin");
        if (user == null) {

            UUID uuid = UUID.randomUUID();
            user = new User("admin", passwordEncoder.encode("admin"),new String[]{"ADMIN"}, uuid.toString());
            userRepository.save(user);
        }

        Item item = itemRepository.findById(1L).orElse(null);
        if(item == null){
            Product product = new Product();
            product.setName("Doğuş Yeşil Çay");
            product.setDescription("Yeşil çayın faydaları saymakla bitmez. Yüzyıllardır vücudun kendini yenilemesi, enerji depolaması ve direncini arttırması için tüketilen bu ürün şimdi Doğuş Yeşil Çay 20'li Paket ile Avansas.com'da. ");
            product.setImage("https://cdn2.avansas.com/urun/56385/dogus-yesil-cay-20-li-paket-zoom-1.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product = productRepository.save(product);
            Product product1 = new Product();
            product1.setName("Çaykur Rize Turist Çayı");
            product1.setDescription("Yurdun dört bir yanında girmediği ev, katılmadığı dost sohbeti yoktur! Ona boşuna \"Gerçek Sarı\" denmez. Herkes ona hayrandır. Köklü geçmişi, nesilden nesile aktarılan nefis aroması ile Rize Turist ailemizin çayıdır.");
            product1.setImage("https://cdn3.volusion.com/p3y5v.vg2ps/v/vspfiles/photos/TCW-TTCR-2.jpg?1512045279");
            product1.setCalories(10);
            product1.setPrepareTime(5);
            product1.setProductStatus(ProductStatus.NEW);
            product1.setItemType(ItemType.PRODUCT);
            product1 = productRepository.save(product1);
            Product product2 = new Product();
            product2.setName("Coca Cola");
            product2.setDescription("Yurdun dört bir yanında girmediği ev, katılmadığı dost sohbeti yoktur! Ona boşuna \"Gerçek Sarı\" denmez. Herkes ona hayrandır. Köklü geçmişi, nesilden nesile aktarılan nefis aroması ile Rize Turist ailemizin çayıdır.");
            product2.setImage("https://pbs.twimg.com/profile_images/777321007099088897/5tkZ2z5W_400x400.jpg");
            product2.setCalories(10);
            product2.setPrepareTime(5);
            product2.setProductStatus(ProductStatus.NEW);
            product2.setItemType(ItemType.PRODUCT);
            product2 = productRepository.save(product2);
            Product product3 = new Product();
            product3.setName("Pepsi");
            product3.setDescription("Yeşil çayın faydaları saymakla bitmez. Yüzyıllardır vücudun kendini yenilemesi, enerji depolaması ve direncini arttırması için tüketilen bu ürün şimdi Doğuş Yeşil Çay 20'li Paket ile Avansas.com'da. ");
            product3.setImage("https://icon2.kisspng.com/20180323/yow/kisspng-coca-cola-pepsi-logo-bottle-cap-pepsi-5ab4e43ee02349.6048279715218043509181.jpg");
            product3.setCalories(10);
            product3.setPrepareTime(5);
            product3.setProductStatus(ProductStatus.NEW);
            product3.setItemType(ItemType.PRODUCT);
            product3 = productRepository.save(product3);
            Item category = new Item();
            category.setName("Sıcak İçecekler");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Kahve, çay gibi sıcak içecekler");
            category.setImage("fas fa-coffee");
            category.getChildren().add(product);
            category.getChildren().add(product1);
            category = itemRepository.save(category);
            Item category2 = new Item();
            category2.setName("Soğuk İçecekler");
            category2.setItemType(ItemType.CATEGORY);
            category2.setDescription("kola gazoz bira");
            category2.setImage("fas fa-beer");
            category2.getChildren().add(product3);
            category2.getChildren().add(product2);
            category2 = itemRepository.save(category2);
            Item drinkCategory = new Item();
            drinkCategory.setName("İçecekler");
            drinkCategory.setItemType(ItemType.CATEGORY);
            drinkCategory.setDescription("Sıcak soğuk içecekler");
            drinkCategory.setImage("fas fa-cocktail");
            drinkCategory.getChildren().add(category2);
            drinkCategory.getChildren().add(category);
            drinkCategory = itemRepository.save(drinkCategory);
            item = new Item();
            item.setName("Yaz Menüsü");
            item.setDescription("Yazın en iddalı menüsü");
            item.setImage("https://im.haberturk.com/2010/07/07/ver1278492400/530133_detay.jpg");
            item.setItemType(ItemType.MENU);
            item.getChildren().add(drinkCategory);
            item = itemRepository.save(item);
        }
    }
}