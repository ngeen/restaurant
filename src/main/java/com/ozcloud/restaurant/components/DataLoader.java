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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            subCategory = new Item();
            subCategory.setName("Omletler");
            subCategory.setItemType(ItemType.CATEGORY);
            subCategory.setDescription("Omletler");
            subCategory.setImage("fas fa-coffee");
            subCategory.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            category = new Item();
            category.setName("Pizzalar");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Pizzalar");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            category = itemRepository.save(category);

            product = new Product();
            product.setName("Süper Pizza");
            product.setDescription("Salam, sosis, sucuk, mantar, biber, siyah zeytin, domates sosu, mozarella peyniri.");
            product.setImage("http://www.pizzapizza.com.tr/static/635845027115827500.png");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));

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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
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
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            category = new Item();
            category.setName("Wraplar");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Wraplar");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            category = itemRepository.save(category);

            product = new Product();
            product.setName("Et Wrap");
            product.setDescription("Bonfile parçaları, mantar, biber, soğan, sarımsak, domates, yeşillik ve patates ile servis edilir");
            product.setImage("http://www.patista.net/Site2018/wp-content/uploads/urunler/patista_et_wrap.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Kajun Chicken Wrap");
            product.setDescription("Kajun baharatlı tavuk parçaları, mantar, biber, soğan, sarımsak, domates, yeşillik ve patates ile servis edilir");
            product.setImage("https://food.fnr.sndimg.com/content/dam/images/food/fullset/2010/8/30/0/FNM_100110-Tailgating-008_s4x3.jpg.rend.hgtvcom.616.462.suffix/1371593124011.jpeg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            category = new Item();
            category.setName("Kırmızı ve Beyaz Etler");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Kırmızı ve Beyaz Etler");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            category = itemRepository.save(category);

            product = new Product();
            product.setName("Mantar Soslu Bonfile (200 gr.)");
            product.setDescription("Mevsim yeşillikleri, pilav ve elma dilim patates ile servis edilir");
            product.setImage("http://www.ardaninmutfagi.com/wp-content/uploads/2013/06/mantar-soslu-bonfile-632x361.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Beğendi Soslu Bonfile (200 gr.)");
            product.setDescription("Mevsim yeşillikleri, pilav ve elma dilim patates ile servis edilir");
            product.setImage("https://iasbh.tmgrup.com.tr/ce13b4/752/395/0/108/800/528?u=https://isbh.tmgrup.com.tr/sbh/2018/05/01/hunkar-begendi-tarifi-hunkar-begendi-nasil-yapilir-1525162375252.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Et Fajita");
            product.setDescription("Salsa sos, guacamole ve kremalı ekşili sos ile servis edilir");
            product.setImage("https://img.yemektarifleri.com/photos/27253/1502283627_400.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Çömlekte Et Sote");
            product.setDescription("Çömlekte Et Sote");
            product.setImage("https://i.nefisyemektarifleri.com/2013/04/guvecte-kasar-peynirli-et-sote-500x333.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Cızbız Ev Köftesi");
            product.setDescription("Mevsi yeşillikleri ve kızarmış patates ile servis edilir");
            product.setImage("http://lezzetler.com/images/yuklenen/cizbiz-kofte-1847.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Ispanaklı Dolgulu Tavuk");
            product.setDescription("Panelenmiş tavuk içine mozarella, beyaz peynir, tulum peynir ile yapılır. Mevsim yeşillikleri, pilav ve elma dilim patates ile servis edilir");
            product.setImage("https://superbiyemek.com/fileman/Uploads/garn%C4%B1tur%20dolgulu%20tavuk.png");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Tavuk Şinitzel");
            product.setDescription("Mevsim yeşillikleri ve kızarmış patates ile servis edilir");
            product.setImage("https://cdn.ye-mek.net/App_UI/Img/out/650/2012/07/tavuk-c59finitzel-resimli-yemek-tarifi-11.jpg?h=487&w=650");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Kremalı Tavuk Izgara");
            product.setDescription("Mevsim yeşillikleri, pilav ve elma dilim patates ile servis edilir");
            product.setImage("http://www.yesiltopuklar.com/wp-content/uploads/2016/06/Kremal%C4%B1-Mantar-Soslu-Tavuk-Izgara-2-785x600.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Kremalı Tavuk Izgara");
            product.setDescription("Mevsim yeşillikleri, pilav ve elma dilim patates ile servis edilir");
            product.setImage("http://www.yesiltopuklar.com/wp-content/uploads/2016/06/Kremal%C4%B1-Mantar-Soslu-Tavuk-Izgara-2-785x600.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Tavuk Fajita");
            product.setDescription("Salsa sos, guacamole ve kremalı ekşili sos ile servis edilir");
            product.setImage("https://i.nefisyemektarifleri.com/2016/05/14/tavuk-fajita-6.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            category = new Item();
            category.setName("Balıklar");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Balıklar");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            category = itemRepository.save(category);

            product = new Product();
            product.setName("Levrek Izgara");
            product.setDescription("Levrek Izgara");
            product.setImage("http://www.nefisyemekler.net/wp-content/uploads/2013/07/Levrek-%C4%B1zgara-610x300.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Çupra Izgara");
            product.setDescription("Çupra Izgara");
            product.setImage("http://www.nefisyemekler.net/wp-content/uploads/2013/02/%C3%87ipura-%C4%B1zgara-600x300.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Somon Izgara");
            product.setDescription("Somon Izgara");
            product.setImage("https://i.superhaber.tv/2/649/382/storage/old/assets/uploads/images/content/2017/03/27/cropped_content_somon-izgara-nasil-yapilir-somon-baliginin-faydalari-nelerdir_A1Phzea141AtoXL.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Çıtır Sardalya Tava");
            product.setDescription("Çıtır Sardalya Tava");
            product.setImage("http://www.yemektarifci.com/uploads/media/recipe/0001/02/thumb_1022_recipe_default.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Mezgit Tava");
            product.setDescription("Mezgit Tava");
            product.setImage("http://www.yemektarifi.com/wp-content/uploads/2017/08/mezgit-tava-1.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Kalamar Tava");
            product.setDescription("Kalamar Tava");
            product.setImage("https://cdn.yemek.com/mncrop/600/315/uploads/2014/10/balik-osman-kalamar-tava-tarifi.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Tereyağlı Karides");
            product.setDescription("Tereyağlı Karides");
            product.setImage("https://baliktarifi.com/wp-content/uploads/2015/07/tereyagli-sarimsakli-karides-tava-tarifi-2.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Karides Güveç");
            product.setDescription("Karides Güveç");
            product.setImage("https://baliktarifi.com/wp-content/uploads/2017/10/mantarli-karides-guvec-tarifi.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Okyanus Lokumu");
            product.setDescription("Okyanus Lokumu");
            product.setImage("http://www.kumsalsuurunleri.com.tr/wp-content/uploads/2016/12/1-10.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Midye Dolma");
            product.setDescription("Midye Dolma");
            product.setImage("http://www.yemektarifci.com/uploads/media/recipe/0001/02/thumb_1096_recipe_default.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            category = new Item();
            category.setName("Tatlılar");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Tatlılar");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            category = itemRepository.save(category);

            product = new Product();
            product.setName("Çikolatalı Sufle");
            product.setDescription("Çikolatalı Sufle");
            product.setImage("https://lezzet.blob.core.windows.net/images-xxlarge-recipe/cikolatali_sufle-cc5cd6ba-ef80-4817-a454-7be5d9c802a6.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Brownie");
            product.setDescription("Brownie");
            product.setImage("https://images.media-allrecipes.com/userphotos/560x315/3850414.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Bal Badem");
            product.setDescription("Bal Badem");
            product.setImage("https://lezzet.blob.core.windows.net/images-xxlarge-recipe/bal-badem-4d290956-44dc-4a4e-8ffc-ab55f5a15d9e.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Tiramisu");
            product.setDescription("Tiramisu");
            product.setImage("https://www.fifteenspatulas.com/wp-content/uploads/2012/11/Tiramisu-Fifteen-Spatulas-1-640x424.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Top Dondurma");
            product.setDescription("Top Dondurma");
            product.setImage("https://diyetkolik.com/site_media/media/nutrition_images/meyveli-dondurma.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            category = new Item();
            category.setName("Kahveler");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Kahveler");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            category = itemRepository.save(category);

            product = new Product();
            product.setName("Americano");
            product.setDescription("Americano");
            product.setImage("https://globalassets.starbucks.com/assets/2a4807223b53455b89f792b5e25ce89e.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Cappuccino");
            product.setDescription("Cappuccino");
            product.setImage("https://www.merriam-webster.com/assets/mw/images/article/art-wap-landing-mp-lg/cappuccino-2029-e80b7c6d318c7862df2c4c8623a11f99@1x.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Cafe Latte");
            product.setDescription("Cafe Latte");
            product.setImage("https://www.nespresso.com/ncp/res/uploads/recipes/95386cc6cc803643f38d5e2982a56698c89d9b7d.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Chocolate Mocha");
            product.setDescription("Chocolate Mocha");
            product.setImage("https://www.torani.com/sites/default/files/taxonomy/drinktypes/illustration/Mochas_0.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("White Chocolate Mocha");
            product.setDescription("White Chocolate Mocha");
            product.setImage("https://globalassets.starbucks.com/assets/bba1d79372384d39aa1662f481584610.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("İrlanda Kahvesi");
            product.setDescription("İrlanda Kahvesi");
            product.setImage("http://4.bp.blogspot.com/-1nA_Dy50CJo/UECqvxOl3LI/AAAAAAAABpE/IU_OHFLIauY/s400/coffee.JPG");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Nescafe");
            product.setDescription("Nescafe");
            product.setImage("http://rtpsupplies.ie/wp-content/uploads/2017/09/NESCAFE.M.750-001.png");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Sütten Nescafe");
            product.setDescription("Sütten Nescafe");
            product.setImage("http://www.agaclar.net/forum/attachments/icecekler/229022d1309253501-img_0913.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Sıcak Çikolata");
            product.setDescription("Sıcak Çikolata");
            product.setImage("http://i.milliyet.com.tr/YeniAnaResim/2017/12/29/fft99_mf10526350.Jpeg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Türk Kahvesi");
            product.setDescription("Türk Kahvesi");
            product.setImage("http://i.hurimg.com/i/hurriyet/75/750x422/58bff72567b0a92cf42593bc.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Espresso");
            product.setDescription("Espresso");
            product.setImage("http://www.delonghi.com/Global/recipes/Coffee/espresso.png");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Sahlep");
            product.setDescription("Sahlep");
            product.setImage("https://i.ebayimg.com/images/g/qjoAAOSwYZ9ZnWXY/s-l300.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            category = new Item();
            category.setName("Çaylar");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Çaylar");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            category = itemRepository.save(category);

            product = new Product();
            product.setName("Bardak Çay");
            product.setDescription("Bardak Çay");
            product.setImage("https://cdn.yeniakit.com.tr/images/news/625/bardak-bardak-cay-icen-mutlaka-okusun-h1436852831.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Fincan Çay");
            product.setDescription("Fincan Çay");
            product.setImage("http://www.gidagundemi.com/images/fotogaleri/gunde-20-fincan-cay-icerseniz-bakin-ne-oluyor-734-sira2.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Yeşil Çay");
            product.setDescription("Yeşil Çay");
            product.setImage("https://isbh.tmgrup.com.tr/sbh/2015/04/17/650x344/1429257637350.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Ada Çayı");
            product.setDescription("Ada Çayı");
            product.setImage("http://www.turkiyegazetesi.com.tr/images/haberler/2017_12/buyuk/adacayi-neye-iyi-gelir-adacayi-faydalari-neler-nasil-demlenir--1512904481.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Ihlamur");
            product.setDescription("Ihlamur");
            product.setImage("https://isbh.tmgrup.com.tr/sbh/2015/12/23/650x344/1450882619560.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Kuşburnu");
            product.setDescription("Kuşburnu");
            product.setImage("https://im.hthayat.com/2017/02/03/ver1537858646/1045896_620x360.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Kış Çayı");
            product.setDescription("Kış Çayı");
            product.setImage("https://www.nnedir.com/wp-content/uploads/2014/11/kis_cayi_tarifleri.jpeg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            category = new Item();
            category.setName("Soğuk Kahveler");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Soğuk Kahveler");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            category = itemRepository.save(category);

            product = new Product();
            product.setName("Ice Americano");
            product.setDescription("Ice Americano");
            product.setImage("https://www.mrcoffee.com/on/demandware.static/-/Sites-mr-coffee-Library/default/dwf77ed1f2/images/blog/How-To-Make-The-Perfect-Iced-Americano_1770_40122425_0_14128126_500.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Ice Latte");
            product.setDescription("Ice Latte");
            product.setImage("https://www.nespresso.com/ncp/res/uploads/recipes/8fe7c911680055d1c8461f8b491e153b1c98839e.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Ice Chocolate Mocha");
            product.setDescription("Ice Chocolate Mocha");
            product.setImage("https://www.torani.com/sites/default/files/recipes/illustration/Iced%20mint%20mocha.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Ice White Chocolate Mocha");
            product.setDescription("Ice White Chocolate Mocha");
            product.setImage("https://globalassets.starbucks.com/assets/637cc460f9934ca3ac1f9b8d5aa2caf0.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            category = new Item();
            category.setName("Smoothie");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Smoothie");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            category = itemRepository.save(category);

            product = new Product();
            product.setName("Milk Shake (Muz/Çilek/Çikolata)");
            product.setDescription("Milk Shake (Muz/Çilek/Çikolata)");
            product.setImage("https://i.sozcu.com.tr/wp-content/uploads/2018/01/cileklimilkshake.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Pina Colada Smoothie");
            product.setDescription("Pina Colada Smoothie");
            product.setImage("http://thebearfootbaker.com/wp-content/uploads/2013/04/Pina-Colada-Smoothie-by-www.thebearfootbaker.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Çilek Muz Smoothie");
            product.setDescription("Çilek Muz Smoothie");
            product.setImage("https://core-cdn.russellhobbs.com/images/a513t_strawberry_banana_smoothie_main.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            category = new Item();
            category.setName("Soğuk İçecekler");
            category.setItemType(ItemType.CATEGORY);
            category.setDescription("Soğuk İçecekler");
            category.setImage("fas fa-coffee");
            category.setParentItem(menu);
            category = itemRepository.save(category);

            product = new Product();
            product.setName("Coca Cola/Fanta/Sprite");
            product.setDescription("Coca Cola/Fanta/Sprite");
            product.setImage("https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX20864672.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Ice Tea (Şeftali/Limon)");
            product.setDescription("Ice Tea (Şeftali/Limon)");
            product.setImage("https://cdn.akakce.com/lipton/lipton-ice-tea-330-ml-seftali-z.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Ev Yapımı Limonata");
            product.setDescription("Ev Yapımı Limonata");
            product.setImage("http://i.milliyet.com.tr/YeniAnaResim/2017/07/07/fft99_mf9448606.Jpeg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Taze Sıkılmış Portakal Suyu");
            product.setDescription("Taze Sıkılmış Portakal Suyu");
            product.setImage("https://im.hthayat.com/2013/04/02/ver1445611837/1012906_620x413.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Soda");
            product.setDescription("Soda");
            product.setImage("https://cdn.o-fix.com/Images/SiteImages/ProductDetailImage/Beypazari-Maden-Suyu-Cam-Sise-200-Ml-24-Adet_RI60662FT2MF220322.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Meyveli Soda (Elma/Limon)");
            product.setDescription("Meyveli Soda (Elma/Limon)");
            product.setImage("http://www.uludagicecek.com.tr/_assets/img/sub/urunler/meyveli-maden-sulari/uludag-frutti-page-v2.png");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Meyve Suyu (Vişne/Şeftali/Karışık)");
            product.setDescription("Meyve Suyu (Vişne/Şeftali/Karışık)");
            product.setImage("https://n11scdn.akamaized.net/a1/450/ev-yasam/meyve-suyu/dimes-meyve-suyu-54-adet-200-ml-2-koli-27li__0668797139766906.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Ayran");
            product.setDescription("Ayran");
            product.setImage("https://online.yunusmarket.com.tr/720-large_default/cim-bardak-ayran-195-ml.jpg");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);

            product = new Product();
            product.setName("Redbull");
            product.setDescription("Redbull");
            product.setImage("https://officedepot.scene7.com/is/image/officedepot/729770_p?$OD%2DLarge$&wid=450&hei=450");
            product.setCalories(10);
            product.setPrepareTime(5);
            product.setProductStatus(ProductStatus.NEW);
            product.setItemType(ItemType.PRODUCT);
            product.setParentItem(category);
            product.setPrice(new BigDecimal(BigInteger.valueOf(new Random().nextInt(301)), 2));
            product = productRepository.save(product);



        }
    }
}