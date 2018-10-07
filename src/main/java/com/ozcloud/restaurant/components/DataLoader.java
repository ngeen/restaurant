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

            Item menu = new Item();
            menu.setName("Yaz Menüsü");
            menu.setDescription("Yazın en iddalı menüsü");
            menu.setImage("https://im.haberturk.com/2010/07/07/ver1278492400/530133_detay.jpg");
            menu.setItemType(ItemType.MENU);
            menu = itemRepository.save(menu);

            Item category = new Item();
            category.setName("Kahvaltılar");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Kahve, çay gibi sıcak içecekler");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            category = itemRepository.save(category);

            Product product = new Product();
            product.setName("Serpme Kahvaltı (En az iki kişilik)");
            product.setDescription("Tulum Peyniri, Beyaz Peynir, Çeçil Peyniri, Siyah Zeytin, Yeşil Zeytin, Çemen, Bal, Kaymak, Reçel Çeşitleri, Domates, Salatalık, Tereyağ, Kakaolu Fındık Ezmesi, Kızartma, Sürpriz Kahvaltılık, Mevsim Meyvesi, Köy Ekmeği, Termos Çay.");
            product.setImage("https://media-cdn.tripadvisor.com/media/photo-s/0e/62/5b/8f/serpme-kahvalti.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Kahvaltı Tabağı");
            product.setDescription("Tulum Peyniri, Beyaz Peynir, Çeçil Peyniri, Siyah Zeytin, Yeşil Zeytin, Çemen, Bal, Kaymak, Reçel Çeşitleri, Domates, Salatalık, Tereyağ, Köy Ekmeği, Çay.");
            product.setImage("https://media-cdn.tripadvisor.com/media/photo-s/0a/b5/3a/12/kahvalti-tabagi.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Pancake");
            product.setDescription("Pancake");
            product.setImage("https://images-gmi-pmc.edge-generalmills.com/edfaaf9f-9bde-426a-8d67-3284e9e496ae.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            Item subCategory = new Item();
            subCategory.setName("Yumurtalar");
            subCategory.setItemType(ItemType.CATEGORY);
            subCategory.setDescription("Yumurtalar");
            subCategory.setImage("fas fa-coffee");
            subCategory.setParentItem(category);
            subCategory = itemRepository.save(subCategory);

            product = new Product();
            product.setName("Tire Sucuklu Yumurta");
            product.setDescription("Tire Sucuklu Yumurta");
            product.setImage("https://i.sozcu.com.tr/wp-content/uploads//2018/02/iecrop/sucuklu-yumurta-tarifi_16_9_1519714666.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Kavurmalı Yumurta");
            product.setDescription("Kavurmalı Yumurta");
            product.setImage("https://im.haberturk.com/2017/09/01/ver1504266366/1617321_620x410.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Pastırmalı Yumurta");
            product.setDescription("Pastırmalı Yumurta");
            product.setImage("http://i.hurimg.com/i/hurriyet/75/1500x844/5b59b0a65379fe1030079198.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Pastırmalı Yumurta");
            product.setDescription("Pastırmalı Yumurta");
            product.setImage("http://i.hurimg.com/i/hurriyet/75/1500x844/5b59b0a65379fe1030079198.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Kaşarlı Yumurta");
            product.setDescription("Kaşarlı Yumurta");
            product.setImage("https://i.ytimg.com/vi/cDaL2GN3EOw/maxresdefault.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Tulum Peynirli Yumurta");
            product.setDescription("Tulum Peynirli Yumurta");
            product.setImage("https://cdn.ye-mek.net/App_UI/Img/out/650/2014/08/sahanda-peynirli-yumurta-resimli-yemek-tarifi(6).jpg?h=487&w=650");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Beyaz Peynirli Yumurta");
            product.setDescription("Beyaz Peynirli Yumurta");
            product.setImage("https://cdn.ye-mek.net/App_UI/Img/out/650/2014/08/sahanda-peynirli-yumurta-resimli-yemek-tarifi(6).jpg?h=487&w=650");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Sahanda Yumurta");
            product.setDescription("Sahanda Yumurta");
            product.setImage("https://iasbh.tmgrup.com.tr/1a9816/650/344/0/29/545/317?u=http://i.sabah.com.tr/sbh/2016/12/28/sahanda-yumurta-tarifi-sahanda-yumurta-nasil-yapilir-1482912189180.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            subCategory = new Item();
            subCategory.setName("Omletler");
            subCategory.setItemType(ItemType.CATEGORY);
            subCategory.setDescription("Omletler");
            subCategory.setImage("fas fa-coffee");
            subCategory.setParentItem(category);
            subCategory = itemRepository.save(subCategory);

            product = new Product();
            product.setName("Sade Omlet");
            product.setDescription("Sade Omlet");
            product.setImage("https://cdn.ye-mek.net/App_UI/Img/out/650/2018/09/sade-omlet-resimli-yemek-tarifi(12).jpg?h=487&w=650");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Kaşarlı Omlet");
            product.setDescription("Kaşarlı Omlet");
            product.setImage("https://www.omlet.gen.tr/images/sade-omlet-tarifi.gif");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Sucuklu Omlet");
            product.setDescription("Sucuklu Omlet");
            product.setImage("https://www.omlet.gen.tr/images/sucuklu-omlet.gif");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Karışık Omlet(Sosis, Kaşar, Sucuk)");
            product.setDescription("Karışık Omlet(Sosis, Kaşar, Sucuk)");
            product.setImage("http://www.yemektarifleri-sitesi.com/wp-content/uploads/2014/04/karisik-omlet-tarifi.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            subCategory = new Item();
            subCategory.setName("Diğer");
            subCategory.setItemType(ItemType.CATEGORY);
            subCategory.setDescription("Diğer");
            subCategory.setImage("fas fa-coffee");
            subCategory.setParentItem(category);
            subCategory = itemRepository.save(subCategory);

            product = new Product();
            product.setName("Menemen");
            product.setDescription("Menemen");
            product.setImage("https://cdn.yemek.com/mncrop/940/625/uploads/2015/02/soganli-menemen.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Sucuklu Menemen");
            product.setDescription("Sucuklu Menemen");
            product.setImage("http://i.milliyet.com.tr/YeniAnaResim/2016/11/25/fft99_mf8057051.Jpeg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Kaşarlı Menemen");
            product.setDescription("Kaşarlı Menemen");
            product.setImage("http://i.milliyet.com.tr/YeniAnaResim/2016/10/20/fft99_mf7835426.Jpeg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Sucuk Tava");
            product.setDescription("Sucuk Tava");
            product.setImage("http://photos1.blogger.com/x/blogger/3134/3555/1600/314338/sucuk%20tava%20%282%29.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Sosis Tava");
            product.setDescription("Sosis Tava");
            product.setImage("http://www.namet.com.tr/Files/img/sosisb-635611649358434922.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Anne Kızartması(İsteğe göre yoğurtlu)");
            product.setDescription("Anne Kızartması(İsteğe göre yoğurtlu)");
            product.setImage("https://i.nefisyemektarifleri.com/2017/06/04/karisik-yogurtlu-kizartma-aci-icerir-500x333.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Anne Pişisi(5 Adet)");
            product.setDescription("Anne Pişisi(5 Adet)");
            product.setImage("https://i.nefisyemektarifleri.com/2016/04/26/anne-pisisi-500x333.jpeg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Portakal Suyu");
            product.setDescription("Portakal Suyu");
            product.setImage("https://cdn.yemek.com/mncrop/940/625/uploads/2017/11/3-portakaldan-5-litre-portakal-suyu-tarifi.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(subCategory);
            product = productRepository.save(product);

            category = new Item();
            category.setName("Salatalar");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Salatalar");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            category = itemRepository.save(category);

            product = new Product();
            product.setName("Akdeniz Salata");
            product.setDescription("Akdeniz Yeşillikleri, domates, mısır, salatalık, havuç, zeytin, kekik, beyaz peynir");
            product.setImage("https://www.mutfakyolu.com/wp-content/uploads/nefis-akdeniz-salatasi-tarifi.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Izgara Tavuk Salata");
            product.setDescription("Izgara tavuk, roka, marul, maydonoz, domates, salatalık,mısır");
            product.setImage("http://i.milliyet.com.tr/YeniAnaResim/2015/01/22/fft99_mf5222582.Jpeg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Sıcak Et Salata");
            product.setDescription("Sotelenmiş bonfile parçaları, roka, marul, maydonoz, domates, salatalık, mısır");
            product.setImage("http://2.bp.blogspot.com/-loPLn9G9aug/UJPPeD-Ub0I/AAAAAAAAD7U/Nc7gIaKLBGY/s1600/s%C4%B1cak+et+salatas%C4%B1+copy.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Çoban Salata");
            product.setDescription("Roka, domates, salatalık, yeşil biber, kuru soğan");
            product.setImage("https://cdn.ye-mek.net/App_UI/Img/out/650/2013/06/coban-salatasi-resimli-yemek-tarifi(7).jpg?h=487&w=650");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Çoban Salata");
            product.setDescription("Roka, domates, salatalık, yeşil biber, kuru soğan");
            product.setImage("https://cdn.ye-mek.net/App_UI/Img/out/650/2013/06/coban-salatasi-resimli-yemek-tarifi(7).jpg?h=487&w=650");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Roka Salatası");
            product.setDescription("Roka, rendelenmiş domates, rendelenmiş peynir, ceviz");
            product.setImage("https://cdn.yemek.com/mncrop/940/625/uploads/2016/02/roka-salatasi-tarifi.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Ton Balıklı Salata");
            product.setDescription("Ton balığı, akdeniz yeşillikleri, mısır, domates");
            product.setImage("https://isbh.tmgrup.com.tr/sbh/2016/03/30/650x344/1459325517043.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            category = new Item();
            category.setName("Atıştırmalıklar");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Atıştırmalıklar");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            category = itemRepository.save(category);

            product = new Product();
            product.setName("Çıtır Sepet");
            product.setDescription("Çıtır tavuk, paçanga böreği, sigara böreği, sosis, kaşar kroket, soğan halkası, parmak patates");
            product.setImage("https://media-cdn.tripadvisor.com/media/photo-s/11/51/a0/64/citir-sepeti.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Çıtır Balık Tabağı");
            product.setDescription("Çıtır sardalye, mezgit, okyanus lokumu, karides cips, midye tava");
            product.setImage("http://ismailkaratas.com.tr/Images/Thumbs/News/780-citir-deniz-mahsulleri-tabagi-ve-tartar-sos-450x0.jpeg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Peynir Tabağı");
            product.setDescription("Gravyer, gouda, envanter peyniri, isli peynir, rokfor, yuvarlak peynir");
            product.setImage("http://c.igte.ch/?u=http://www.trendus.com/Content/Images/PhotoGallery/size1/sik-bir-peynir-tabagi-sunumu-nasil-hazirlanir-59179-19072017115335.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Paçanga böreği");
            product.setDescription("Paçanga böreği");
            product.setImage("https://lezzet.blob.core.windows.net/images-xxlarge-recipe/pacanga_boregi-69450364-faae-4863-be1d-34dc5cd7c1ed.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Sigara böreği");
            product.setDescription("Sigara böreği");
            product.setImage("https://img.yemektarifleri.com/photos/21940/1509632434_400.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Parmak Patates");
            product.setDescription("Parmak Patates");
            product.setImage("http://cdn.shopify.com/s/files/1/1189/7554/products/feast_parmak_patates_10x10_a023af81-d181-463b-9cb1-3cda1475ca01_grande.jpg?v=1522937279");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Elma Dilim Patates");
            product.setDescription("Elma Dilim Patates");
            product.setImage("https://im.haberturk.com/2016/05/12/ver1463037443/1238363_620x410.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Soslu Soğan Halkası");
            product.setDescription("Soslu Soğan Halkası");
            product.setImage("https://www.hurrem.com/wp-content/uploads/2014/05/So%C4%9Fan-Halkas%C4%B1-Tarifi-300x184.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Sosis Tava");
            product.setDescription("Sosis Tava");
            product.setImage("http://www.namet.com.tr/Files/img/sosisb-635611649358434922.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Meze Çeşitleri");
            product.setDescription("Meze Çeşitleri");
            product.setImage("https://media-cdn.tripadvisor.com/media/photo-s/11/97/4e/94/meze-cesitleri.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            category = new Item();
            category.setName("Burgerler");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Burgerler");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            category = itemRepository.save(category);

            product = new Product();
            product.setName("Allesta Burger");
            product.setDescription("Özel hamburger ekmeği arasında ev yapımı 180 gr'lık hamburger köftesi, dil peyniri, füme et, karamelize soğan, saman patates, domates, marul, turşu, parmak patates(baharatlı), soğan halkası, coleslaw ve sweet chili ile servis edilir");
            product.setImage("http://caribbeanpot.com/wp-content/uploads/2015/07/homemade-burgers-1.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Hamburger");
            product.setDescription("Özel hamburger ekmeği arasında ev yapımı 150 gr'lık hamburger köftesi, marul, domates, karamelize soğan, parmak patates(baharatlı), coleslaw ve sweet chili ile servis edilir");
            product.setImage("http://www.munchkintime.com/wp-content/uploads/2017/06/Best-Hamburger-Recipe-to-make-for-Fathers-Day-from-Munchkintime.com-46.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Cheese Burger");
            product.setDescription("Özel hamburger ekmeği arasında ev yapımı 150 gr'lık hamburger köftesi, double cheddar peyniri, marul, domates, karamelize soğan, parmak patates(baharatlı), coleslaw ve sweet chili ile servis edilir.");
            product.setImage("https://cdn-jpg3.thedailymeal.com/sites/default/files/2014/09/25/cheeseburger_1.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Double Burger");
            product.setDescription("Özel hamburger ekmeği arasında ev yapımı 300 gr'lık hamburger köftesi, marul, domates, karamelize soğan, parmak patates(baharatlı), coleslaw ve sweet chili ile servis edilir.");
            product.setImage("https://cdn-jpg3.thedailymeal.com/sites/default/files/2014/09/25/cheeseburger_1.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Süper Pizza");
            product.setDescription("Salam, sosis, sucuk, mantar, biber, siyah zeytin, domates sosu, mozarella peyniri.");
            product.setImage("http://www.pizzapizza.com.tr/static/635845027115827500.png");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Sucuklu Pizza");
            product.setDescription("Sucuk, domates sos, mozarella peyniri");
            product.setImage("http://www.yemektarifi.com/wp-content/uploads/2017/03/sucuklu-pizza.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Ton Balıklı Pizza");
            product.setDescription("Ton balığı, siyah zeytin, mısır, kırmızı soğan, kapari, domates sos, mozarella peyniri");
            product.setImage("https://img.yemektarifleri.com/photos/16886/1507558319_400.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Vejeteryan Pizza");
            product.setDescription("Kırmızı ve yeşil biber, mısır, mantar, zeytin, domates sos, mozarella peyniri");
            product.setImage("https://img.yemektarifleri.com/photos/22928/1307106896_400.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            category = new Item();
            category.setName("Makarnalar");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Makarnalar");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            category = itemRepository.save(category);

            product = new Product();
            product.setName("Tavuklu Mantarlı Penne");
            product.setDescription("Tavuk parçaları, mantar, krema ve parmesan peyniri");
            product.setImage("https://i.nefisyemektarifleri.com/2018/06/08/mantarli-tavuklu-penne-3-500x333.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Tortellini");
            product.setDescription("3 Peynirli(Lor, mozarella, dil peyniri), parmesan ile servis edilir");
            product.setImage("https://cdn-image.myrecipes.com/sites/default/files/styles/medium_2x/public/image/recipes/ay/08/tortellini-ham-ay-1875548-x.jpg?itok=QCUe6UwC");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

            product = new Product();
            product.setName("Ev Mantısı");
            product.setDescription("%100 dana kıyma ve el açma hamur kullanılır. Yoğurt ve tereyağı ile servis edilir");
            product.setImage("https://lezzet.blob.core.windows.net/images-xxlarge-recipe/ispanakli_manti-0f249945-3ef8-470f-b33a-a6b075c1a7d9.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product = productRepository.save(product);

        }
    }
}