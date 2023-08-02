package com.example.demo.config;

import com.example.demo.models.Account;
import com.example.demo.models.Authority;
import com.example.demo.models.Post;
import com.example.demo.models.Quiz;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.repository.QuizRepository;
import com.example.demo.services.AccountService;
import com.example.demo.services.PostService;
import com.example.demo.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private QuizService quizService;


    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.size() == 0){

            Authority user1 = new Authority();
            Authority user2 = new Authority();

            user1.setName("ROLE_ADMIN");
            user2.setName("ROLE_USER");

            authorityRepository.save(user1);
            authorityRepository.save(user2);

            Account account1 = new Account();
            Account account2 = new Account();

            account1.setEmail("bla@test.com");
            account2.setEmail("bla@test1.com");

            account1.setPassword("123");
            account2.setPassword("123");

            account1.setUsername("acc1");
            account2.setUsername("acc2");

            Set<Authority> authorities1 = new HashSet<>();
            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities1::add);
            account1.setAuthorities(authorities1);

            Set<Authority> authorities2 = new HashSet<>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities2::add);
            account2.setAuthorities(authorities2);

            accountService.save(account1);
            accountService.save(account2);

            Post post1 = new Post();
            post1.setTitle("Some test");
            post1.setBody("Some test Some test Some test Some test Some test Some test Some test Some test Some test " +
                    "\n Some test Some test Some test Some test Some test");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setTitle("Some test 2");
            post2.setBody("Some test Some test Some test Some test Some test Some test Some test Some test Some test " +
                    "\n Some test Some test Some test Some test Some test");
            post2.setAccount(account2);

            postService.save(post1);
            postService.save(post2);
        }

        if (quizService.getAllQuiz().size() == 0){
            Quiz quiz = new Quiz();
            Quiz quiz1 = new Quiz();
            Quiz quiz2 = new Quiz();
            Quiz quiz3 = new Quiz();
            Quiz quiz4 = new Quiz();
            Quiz quiz5 = new Quiz();
            Quiz quiz6 = new Quiz();
            Quiz quiz7 = new Quiz();
            Quiz quiz8 = new Quiz();
            Quiz quiz9 = new Quiz();
            Quiz quiz10 = new Quiz();
            Quiz quiz11 = new Quiz();
            Quiz quiz12 = new Quiz();
            Quiz quiz13 = new Quiz();
            Quiz quiz14 = new Quiz();
            Quiz quiz15 = new Quiz();
            Quiz quiz16 = new Quiz();
            Quiz quiz17 = new Quiz();
            Quiz quiz18 = new Quiz();
            Quiz quiz19 = new Quiz();
            Quiz quiz20 = new Quiz();
            Quiz quiz21 = new Quiz();
            Quiz quiz22 = new Quiz();
            Quiz quiz23 = new Quiz();
            Quiz quiz24 = new Quiz();
            Quiz quiz25 = new Quiz();
            Quiz quiz26 = new Quiz();
            Quiz quiz27 = new Quiz();
            Quiz quiz28 = new Quiz();
            Quiz quiz29 = new Quiz();
            Quiz quiz30 = new Quiz();
            Quiz quiz31 = new Quiz();
            Quiz quiz32 = new Quiz();
            Quiz quiz33 = new Quiz();
            Quiz quiz34 = new Quiz();
            Quiz quiz35 = new Quiz();
            Quiz quiz36 = new Quiz();
            Quiz quiz37 = new Quiz();
            Quiz quiz38 = new Quiz();
            Quiz quiz39 = new Quiz();
            Quiz quiz40 = new Quiz();
            Quiz quiz41 = new Quiz();
            Quiz quiz42 = new Quiz();
            Quiz quiz43 = new Quiz();
            Quiz quiz44 = new Quiz();
            Quiz quiz45 = new Quiz();
            Quiz quiz46 = new Quiz();
            Quiz quiz47 = new Quiz();
            Quiz quiz48 = new Quiz();
            Quiz quiz49 = new Quiz();
            Quiz quiz50 = new Quiz();
            Quiz quiz51 = new Quiz();
            Quiz quiz52 = new Quiz();
            Quiz quiz53 = new Quiz();
            Quiz quiz54 = new Quiz();
            Quiz quiz55 = new Quiz();
            Quiz quiz56 = new Quiz();
            Quiz quiz57 = new Quiz();
            Quiz quiz58 = new Quiz();
            Quiz quiz59 = new Quiz();
            Quiz quiz60 = new Quiz();
            Quiz quiz61 = new Quiz();
            Quiz quiz62 = new Quiz();
            Quiz quiz63 = new Quiz();
            Quiz quiz64 = new Quiz();
            Quiz quiz65 = new Quiz();
            Quiz quiz66 = new Quiz();
            Quiz quiz67 = new Quiz();
            Quiz quiz68 = new Quiz();
            Quiz quiz69 = new Quiz();
            Quiz quiz70 = new Quiz();
            Quiz quiz71 = new Quiz();
            Quiz quiz72 = new Quiz();
            Quiz quiz73 = new Quiz();
            Quiz quiz74 = new Quiz();
            Quiz quiz75 = new Quiz();
            Quiz quiz76 = new Quiz();
            Quiz quiz77 = new Quiz();
            Quiz quiz78 = new Quiz();
            Quiz quiz79 = new Quiz();
            Quiz quiz80 = new Quiz();
            Quiz quiz81 = new Quiz();
            Quiz quiz82 = new Quiz();
            Quiz quiz83 = new Quiz();
            Quiz quiz84 = new Quiz();
            Quiz quiz85 = new Quiz();
            Quiz quiz86 = new Quiz();
            Quiz quiz87 = new Quiz();
            Quiz quiz88 = new Quiz();
            Quiz quiz89 = new Quiz();
            Quiz quiz90 = new Quiz();;

            quiz.setTitle("Какая игра является первой частью серии \"Metal Gear Solid?\"");
            quiz.setAnswer("Metal Gear Solid");
            quiz.setOptions(List.of("Metal Gear Solid 2: Sons of Liberty", "Metal Gear Solid 3: Snake Eater", "Metal Gear Solid", "Metal Gear Solid 4: Guns of the Patriots"));

            quiz1.setTitle("Какой разработчик ответственен за серию игр \"Fallout\"?");
            quiz1.setAnswer("Bethesda Game Studios");
            quiz1.setOptions(List.of("Rockstar Games", "Ubisoft", "CD Projekt Red", "Bethesda Game Studios"));

            quiz2.setTitle("Какой из перечисленных жанров НЕ связан с игрой \"Overwatch\"?");
            quiz2.setAnswer("Открытый мир");
            quiz2.setOptions(List.of("Шутер от первого лица (FPS)", "Командный соревновательный", "Многопользовательская онлайн боевая аркада (MOBA)", "Открытый мир"));

            quiz3.setTitle("Какой персонаж из списка является главным героем игры \"Uncharted\"?");
            quiz3.setAnswer("Nathan Drake");
            quiz3.setOptions(List.of("Joel", "Nathan Drake", "Master Chief", "Geralt of Rivia"));

            quiz4.setTitle("Какой разработчик ответственен за серию игр \"Assassin's Creed\"?");
            quiz4.setAnswer("Ubisoft");
            quiz4.setOptions(List.of("Rockstar Games", "Ubisoft", "CD Projekt Red", "Bethesda Softworks"));

            quiz5.setTitle("Какой из перечисленных жанров связан с игрой \"League of Legends\"?");
            quiz5.setAnswer("Многопользовательская онлайн боевая аркада (MOBA)");
            quiz5.setOptions(List.of("Шутер от первого лица (FPS)", "Командный соревновательный", "Ролевая игра (RPG)", "Многопользовательская онлайн боевая аркада (MOBA)"));

            quiz6.setTitle("Какая игра является первой частью серии \"BioShock\"?");
            quiz6.setAnswer("BioShock");
            quiz6.setOptions(List.of("BioShock 2", "BioShock", "BioShock Infinite", "BioShock: The Collection"));

            quiz7.setTitle("Какой год стал выпуском первой части игры \"Super Mario Bros.\"?");
            quiz7.setAnswer("1985");
            quiz7.setOptions(List.of("1983", "1985", "1987", "1989"));

            quiz8.setTitle("Какой из перечисленных жанров НЕ связан с игрой \"Dark Souls\"?");
            quiz8.setAnswer("Гонки");
            quiz8.setOptions(List.of("Шутер от первого лица (FPS)", "Ролевая игра (RPG)", "Экшн", "Гонки"));

            quiz9.setTitle("Какая игра из списка была разработана студией Rockstar Games?");
            quiz9.setAnswer("Grand Theft Auto V");
            quiz9.setOptions(List.of("Grand Theft Auto V", "The Elder Scrolls V: Skyrim", "Red Dead Redemption 2", "Call of Duty: Modern Warfare"));

            quiz10.setTitle("Какой разработчик ответственен за серию игр \"Halo\"?");
            quiz10.setAnswer("343 Industries");
            quiz10.setOptions(List.of("343 Industries", "Bungie", "Guerrilla Games", "FromSoftware"));

            quiz11.setTitle("Какой из перечисленных жанров НЕ связан с игрой \"FIFA\"?");
            quiz11.setAnswer("Шутер от первого лица (FPS)");
            quiz11.setOptions(List.of("Гонки", "Футбол", "Ролевая игра (RPG)", "Шутер от первого лица (FPS)"));

            quiz12.setTitle("Какой год был началом продаж PlayStation 4?");
            quiz12.setAnswer("2013");
            quiz12.setOptions(List.of("2012", "2013", "2014", "2015"));

            quiz13.setTitle("Какой персонаж из списка является главным героем игры \"God of War (2018)\"?");
            quiz13.setAnswer("Kratos");
            quiz13.setOptions(List.of("Kratos", "Nathan Drake", "Master Chief", "Sam Fisher"));

            quiz14.setTitle("Какая игра является первой частью серии \"Resident Evil\"?");
            quiz14.setAnswer("Resident Evil");
            quiz14.setOptions(List.of("Resident Evil 2", "Resident Evil 3: Nemesis", "Resident Evil", "Resident Evil 4"));

            quiz15.setTitle("Какой разработчик ответственен за серию игр \"Final Fantasy\"?");
            quiz15.setAnswer("Square Enix");
            quiz15.setOptions(List.of("Capcom", "Square Enix", "Konami", "Activision"));

            quiz16.setTitle("Какой из перечисленных жанров связан с игрой \"The Sims\"?");
            quiz16.setAnswer("Симулятор жизни");
            quiz16.setOptions(List.of("Стратегия", "Экономическая", "Симулятор жизни", "Гонки"));

            quiz17.setTitle("Какая игра является первой частью серии \"The Legend of Zelda\"?");
            quiz17.setAnswer("The Legend of Zelda");
            quiz17.setOptions(List.of("The Legend of Zelda", "The Legend of Zelda: A Link to the Past", "The Legend of Zelda: Ocarina of Time", "The Legend of Zelda: Breath of the Wild"));

            quiz18.setTitle("Какой разработчик ответственен за серию игр \"Gears of War\"?");
            quiz18.setAnswer("The Coalition");
            quiz18.setOptions(List.of("Epic Games", "The Coalition", "Respawn Entertainment", "id Software"));

            quiz19.setTitle("Какой из перечисленных жанров НЕ связан с игрой \"Mortal Kombat\"?");
            quiz19.setAnswer("Гонки");
            quiz19.setOptions(List.of("Файтинг", "Шутер от первого лица (FPS)", "Ролевая игра (RPG)", "Гонки"));

            quiz20.setTitle("Какая игра является первой частью серии \"BioShock\"?");
            quiz20.setAnswer("BioShock");
            quiz20.setOptions(List.of("BioShock 2", "BioShock", "BioShock Infinite", "BioShock: The Collection"));

            quiz21.setTitle("Какой год стал выпуском первой части игры \"Super Mario Bros.\"?");
            quiz21.setAnswer("1985");
            quiz21.setOptions(List.of("1983", "1985", "1987", "1989"));

            quiz22.setTitle("Какой из перечисленных жанров НЕ связан с игрой \"Dark Souls\"?");
            quiz22.setAnswer("Гонки");
            quiz22.setOptions(List.of("Шутер от первого лица (FPS)", "Ролевая игра (RPG)", "Экшн", "Гонки"));

            quiz23.setTitle("Какая игра из списка была разработана студией Rockstar Games?");
            quiz23.setAnswer("Grand Theft Auto V");
            quiz23.setOptions(List.of("Grand Theft Auto V", "The Elder Scrolls V: Skyrim", "Red Dead Redemption 2", "Call of Duty: Modern Warfare"));

            quiz24.setTitle("Какой разработчик ответственен за серию игр \"Halo\"?");
            quiz24.setAnswer("343 Industries");
            quiz24.setOptions(List.of("343 Industries", "Bungie", "Guerrilla Games", "FromSoftware"));

            quiz25.setTitle("Какой из перечисленных жанров НЕ связан с игрой \"FIFA\"?");
            quiz25.setAnswer("Шутер от первого лица (FPS)");
            quiz25.setOptions(List.of("Гонки", "Футбол", "Ролевая игра (RPG)", "Шутер от первого лица (FPS)"));

            quiz26.setTitle("Какой год был началом продаж PlayStation 4?");
            quiz26.setAnswer("2013");
            quiz26.setOptions(List.of("2012", "2013", "2014", "2015"));

            quiz27.setTitle("Какой персонаж из списка является главным героем игры \"God of War\" (2018)?");
            quiz27.setAnswer("Kratos");
            quiz27.setOptions(List.of("Kratos", "Nathan Drake", "Master Chief", "Sam Fisher"));

            quiz28.setTitle("Какая игра является первой частью серии \"Resident Evil\"?");
            quiz28.setAnswer("Resident Evil");
            quiz28.setOptions(List.of("Resident Evil 2", "Resident Evil 3: Nemesis", "Resident Evil", "Resident Evil 4"));

            quiz29.setTitle("Какой разработчик ответственен за серию игр \"Final Fantasy\"?");
            quiz29.setAnswer("Square Enix");
            quiz29.setOptions(List.of("Capcom", "Square Enix", "Konami", "Activision"));

            quiz30.setTitle("Какой из перечисленных жанров связан с игрой \"The Sims\"?");
            quiz30.setAnswer("Симулятор жизни");
            quiz30.setOptions(List.of("Стратегия", "Экономическая", "Симулятор жизни", "Гонки"));

            quiz31.setTitle("Какая игра является первой частью серии \"The Legend of Zelda\"?");
            quiz31.setAnswer("The Legend of Zelda");
            quiz31.setOptions(List.of("The Legend of Zelda", "The Legend of Zelda: A Link to the Past", "The Legend of Zelda: Ocarina of Time", "The Legend of Zelda: Breath of the Wild"));

            quiz32.setTitle("Какой разработчик ответственен за серию игр \"Gears of War\"?");
            quiz32.setAnswer("The Coalition");
            quiz32.setOptions(List.of("Epic Games", "The Coalition", "Respawn Entertainment", "id Software"));

            quiz33.setTitle("Какой из перечисленных жанров НЕ связан с игрой \"Mortal Kombat\"?");
            quiz33.setAnswer("Гонки");
            quiz33.setOptions(List.of("Файтинг", "Шутер от первого лица (FPS)", "Ролевая игра (RPG)", "Гонки"));

            quiz34.setTitle("Какая игра из списка была разработана студией Naughty Dog?");
            quiz34.setAnswer("Uncharted 4: A Thief's End");
            quiz34.setOptions(List.of("Uncharted 4: A Thief's End", "The Legend of Zelda: Breath of the Wild", "Horizon Zero Dawn", "God of War (2018)"));

            quiz35.setTitle("В каком году была выпущена первая часть игры \"Half-Life\"?");
            quiz35.setAnswer("1998");
            quiz35.setOptions(List.of("1996", "1998", "2000", "2002"));

            quiz36.setTitle("Какой жанр игры \"Destiny 2\" от Bungie?");
            quiz36.setAnswer("Многопользовательская онлайн стрелялка (MMO)");
            quiz36.setOptions(List.of("Шутер от первого лица (FPS)", "Ролевая игра (RPG)", "Многопользовательская онлайн боевая аркада (MOBA)", "Многопользовательская онлайн стрелялка (MMO)"));

            quiz37.setTitle("Какой разработчик ответственен за серию игр \"Resident Evil\"?");
            quiz37.setAnswer("Capcom");
            quiz37.setOptions(List.of("Konami", "Capcom", "2K Games", "Ubisoft"));

            quiz38.setTitle("Какая игра является первой частью серии \"Grand Theft Auto\"?");
            quiz38.setAnswer("Grand Theft Auto");
            quiz38.setOptions(List.of("Grand Theft Auto: Vice City", "Grand Theft Auto III", "Grand Theft Auto", "Grand Theft Auto: San Andreas"));

            quiz39.setTitle("В каком году была выпущена первая часть игры \"Pokémon\"?");
            quiz39.setAnswer("1996");
            quiz39.setOptions(List.of("1992", "1996", "1998", "2000"));

            quiz40.setTitle("Какой из перечисленных жанров НЕ связан с игрой \"Mortal Kombat\"?");
            quiz40.setAnswer("Гонки");
            quiz40.setOptions(List.of("Гонки", "Файтинг", "Шутер от первого лица (FPS)", "Ролевая игра (RPG)"));

            quiz41.setTitle("Какой разработчик ответственен за серию игр \"Metal Gear Solid\"?");
            quiz41.setAnswer("Konami");
            quiz41.setOptions(List.of("Konami", "Capcom", "Square Enix", "Ubisoft"));

            quiz42.setTitle("Какая игра является первой частью серии \"Fallout\"?");
            quiz42.setAnswer("Fallout");
            quiz42.setOptions(List.of("Fallout 2", "Fallout 3", "Fallout", "Fallout 4"));

            quiz43.setTitle("Какой год стал выпуском первой части игры \"The Elder Scrolls\"?");
            quiz43.setAnswer("1994");
            quiz43.setOptions(List.of("1992", "1994", "1996", "1998"));

            quiz44.setTitle("Какой персонаж из списка является главным героем игры \"The Last of Us\"?");
            quiz44.setAnswer("Joel");
            quiz44.setOptions(List.of("Nathan Drake", "Kratos", "Master Chief", "Joel"));

            quiz45.setTitle("Какая игра из списка является эксклюзивом для PlayStation?");
            quiz45.setAnswer("Horizon Zero Dawn");
            quiz45.setOptions(List.of("Forza Horizon 4", "Horizon Zero Dawn", "Cuphead", "The Legend of Zelda: Breath of the Wild"));

            quiz46.setTitle("Какой разработчик ответственен за серию игр \"Uncharted\"?");
            quiz46.setAnswer("Naughty Dog");
            quiz46.setOptions(List.of("Naughty Dog", "Santa Monica Studio", "Bungie", "Ubisoft"));

            quiz47.setTitle("Какой из перечисленных жанров связан с игрой \"Red Dead Redemption 2\"?");
            quiz47.setAnswer("Экшн");
            quiz47.setOptions(List.of("Шутер от первого лица (FPS)", "Ролевая игра (RPG)", "Приключенческий", "Экшн"));

            quiz48.setTitle("Какая игра является первой частью серии \"The Legend of Zelda\"?");
            quiz48.setAnswer("The Legend of Zelda");
            quiz48.setOptions(List.of("The Legend of Zelda", "The Legend of Zelda: A Link to the Past", "The Legend of Zelda: Ocarina of Time", "The Legend of Zelda: Breath of the Wild"));

            quiz49.setTitle("Какой разработчик ответственен за серию игр \"Resident Evil\"?");
            quiz49.setAnswer("Capcom");
            quiz49.setOptions(List.of("Konami", "Capcom", "2K Games", "Ubisoft"));

            quiz50.setTitle("Какая игра является первой частью серии \"Grand Theft Auto\"?");
            quiz50.setAnswer("Grand Theft Auto");
            quiz50.setOptions(List.of("Grand Theft Auto: Vice City", "Grand Theft Auto III", "Grand Theft Auto", "Grand Theft Auto: San Andreas"));

            quiz51.setTitle("В каком году была выпущена первая часть игры \"Pokémon\"?");
            quiz51.setAnswer("1996");
            quiz51.setOptions(List.of("1992", "1996", "1998", "2000"));

            quiz52.setTitle("Какой из перечисленных жанров НЕ связан с игрой \"Mortal Kombat\"?");
            quiz52.setAnswer("Гонки");
            quiz52.setOptions(List.of("Гонки", "Файтинг", "Шутер от первого лица (FPS)", "Ролевая игра (RPG)"));

            quiz53.setTitle("Какой разработчик ответственен за серию игр \"Metal Gear Solid\"?");
            quiz53.setAnswer("Konami");
            quiz53.setOptions(List.of("Konami", "Capcom", "Square Enix", "Ubisoft"));

            quiz54.setTitle("Какая игра является первой частью серии \"Fallout\"?");
            quiz54.setAnswer("Fallout");
            quiz54.setOptions(List.of("Fallout 2", "Fallout 3", "Fallout", "Fallout 4"));

            quiz55.setTitle("Какой год стал выпуском первой части игры \"The Elder Scrolls\"?");
            quiz55.setAnswer("1994");
            quiz55.setOptions(List.of("1992", "1994", "1996", "1998"));

            quiz56.setTitle("Какой персонаж из списка является главным героем игры \"The Last of Us\"?");
            quiz56.setAnswer("Joel");
            quiz56.setOptions(List.of("Nathan Drake", "Kratos", "Master Chief", "Joel"));

            quiz57.setTitle("Какая игра из списка является эксклюзивом для PlayStation?");
            quiz57.setAnswer("Horizon Zero Dawn");
            quiz57.setOptions(List.of("Forza Horizon 4", "Horizon Zero Dawn", "Cuphead", "The Legend of Zelda: Breath of the Wild"));

            quiz58.setTitle("Какой разработчик ответственен за серию игр \"Uncharted\"?");
            quiz58.setAnswer("Naughty Dog");
            quiz58.setOptions(List.of("Naughty Dog", "Santa Monica Studio", "Bungie", "Ubisoft"));

            quiz59.setTitle("Какой из перечисленных жанров связан с игрой \"Red Dead Redemption 2\"?");
            quiz59.setAnswer("Экшн");
            quiz59.setOptions(List.of("Шутер от первого лица (FPS)", "Ролевая игра (RPG)", "Приключенческий", "Экшн"));

            quiz60.setTitle("Какой год был началом продаж первой Xbox?");
            quiz60.setAnswer("2001");
            quiz60.setOptions(List.of("2000", "2001", "2002", "2003"));

            quiz61.setTitle("Какой персонаж из списка является главным героем игры \"Red Dead Redemption 2\"?");
            quiz61.setAnswer("Arthur Morgan");
            quiz61.setOptions(List.of("Arthur Morgan", "John Marston", "Dutch van der Linde", "Micah Bell"));

            quiz62.setTitle("Какая игра является первой частью серии \"Call of Duty\"?");
            quiz62.setAnswer("Call of Duty");
            quiz62.setOptions(List.of("Call of Duty 2", "Call of Duty 3", "Call of Duty", "Call of Duty 4: Modern Warfare"));

            quiz63.setTitle("В каком году была выпущена первая часть игры \"Grand Theft Auto\"?");
            quiz63.setAnswer("1997");
            quiz63.setOptions(List.of("1995", "1997", "1999", "2001"));

            quiz64.setTitle("Какой разработчик ответственен за серию игр \"The Elder Scrolls\"?");
            quiz64.setAnswer("Bethesda Game Studios");
            quiz64.setOptions(List.of("Square Enix", "Konami", "Capcom", "Bethesda Game Studios"));

            quiz65.setTitle("Какой из перечисленных жанров связан с игрой \"Fortnite\"?");
            quiz65.setAnswer("Королевская битва");
            quiz65.setOptions(List.of("Шутер от первого лица (FPS)", "Приключенческий", "Ролевая игра (RPG)", "Королевская битва"));

            quiz66.setTitle("Какая игра является первой частью серии \"Dark Souls\"?");
            quiz66.setAnswer("Dark Souls");
            quiz66.setOptions(List.of("Dark Souls 2", "Dark Souls 3", "Dark Souls", "Demon's Souls"));

            quiz67.setTitle("Какой разработчик ответственен за серию игр \"Counter-Strike\"?");
            quiz67.setAnswer("Valve Corporation");
            quiz67.setOptions(List.of("Ubisoft", "Activision", "Valve Corporation", "Electronic Arts"));

            quiz68.setTitle("Какой из перечисленных жанров связан с игрой \"World of Warcraft\"?");
            quiz68.setAnswer("Массово многопользовательская онлайн ролевая игра (MMORPG)");
            quiz68.setOptions(List.of("Шутер от первого лица (FPS)", "Стратегия", "Массово многопользовательская онлайн ролевая игра (MMORPG)", "Файтинг"));

            quiz69.setTitle("Какая игра из списка была разработана студией FromSoftware?");
            quiz69.setAnswer("Sekiro: Shadows Die Twice");
            quiz69.setOptions(List.of("Dark Souls 3", "Bloodborne", "Sekiro: Shadows Die Twice", "Nioh"));

            quiz70.setTitle("Какой разработчик ответственен за серию игр \"The Witcher\"?");
            quiz70.setAnswer("CD Projekt Red");
            quiz70.setOptions(List.of("Rockstar Games", "Ubisoft", "CD Projekt Red", "Bethesda Softworks"));

            quiz71.setTitle("Какая игра является первой частью серии \"Grand Theft Auto\"?");
            quiz71.setAnswer("Grand Theft Auto");
            quiz71.setOptions(List.of("Grand Theft Auto: Vice City", "Grand Theft Auto III", "Grand Theft Auto", "Grand Theft Auto: San Andreas"));

            quiz72.setTitle("В каком году была выпущена первая часть игры \"Pokémon\"?");
            quiz72.setAnswer("1996");
            quiz72.setOptions(List.of("1992", "1996", "1998", "2000"));

            quiz73.setTitle("Какой из перечисленных жанров НЕ связан с игрой \"Mortal Kombat\"?");
            quiz73.setAnswer("Гонки");
            quiz73.setOptions(List.of("Гонки", "Файтинг", "Шутер от первого лица (FPS)", "Ролевая игра (RPG)"));

            quiz74.setTitle("Какой разработчик ответственен за серию игр \"Metal Gear Solid\"?");
            quiz74.setAnswer("Konami");
            quiz74.setOptions(List.of("Konami", "Capcom", "Square Enix", "Ubisoft"));

            quiz75.setTitle("Какая игра является первой частью серии \"Fallout\"?");
            quiz75.setAnswer("Fallout");
            quiz75.setOptions(List.of("Fallout 2", "Fallout 3", "Fallout", "Fallout 4"));

            quiz76.setTitle("Какой год стал выпуском первой части игры \"The Elder Scrolls\"?");
            quiz76.setAnswer("1994");
            quiz76.setOptions(List.of("1992", "1994", "1996", "1998"));

            quiz77.setTitle("Какой персонаж из списка является главным героем игры \"The Last of Us\"?");
            quiz77.setAnswer("Joel");
            quiz77.setOptions(List.of("Nathan Drake", "Kratos", "Master Chief", "Joel"));

            quiz78.setTitle("Какая игра из списка является эксклюзивом для PlayStation?");
            quiz78.setAnswer("Horizon Zero Dawn");
            quiz78.setOptions(List.of("Forza Horizon 4", "Horizon Zero Dawn", "Cuphead", "The Legend of Zelda: Breath of the Wild"));

            quiz79.setTitle("Какой разработчик ответственен за серию игр \"Uncharted\"?");
            quiz79.setAnswer("Naughty Dog");
            quiz79.setOptions(List.of("Naughty Dog", "Santa Monica Studio", "Bungie", "Ubisoft"));

            quiz81.setTitle("Какой из перечисленных жанров связан с игрой \"Red Dead Redemption 2\"?");
            quiz81.setAnswer("Экшн");
            quiz81.setOptions(List.of("Шутер от первого лица (FPS)", "Ролевая игра (RPG)", "Приключенческий", "Экшн"));

            quiz82.setTitle("Какой год был началом продаж первой Xbox?");
            quiz82.setAnswer("2001");
            quiz82.setOptions(List.of("2000", "2001", "2002", "2003"));

            quiz83.setTitle("Какой персонаж из списка является главным героем игры \"Red Dead Redemption 2\"?");
            quiz83.setAnswer("Arthur Morgan");
            quiz83.setOptions(List.of("Arthur Morgan", "John Marston", "Dutch van der Linde", "Micah Bell"));

            quiz84.setTitle("Какая игра является первой частью серии \"Call of Duty\"?");
            quiz84.setAnswer("Call of Duty");
            quiz84.setOptions(List.of("Call of Duty 2", "Call of Duty 3", "Call of Duty", "Call of Duty 4: Modern Warfare"));

            quiz85.setTitle("В каком году была выпущена первая часть игры \"Grand Theft Auto\"?");
            quiz85.setAnswer("1997");
            quiz85.setOptions(List.of("1995", "1997", "1999", "2001"));

            quiz86.setTitle("Какой разработчик ответственен за серию игр \"The Elder Scrolls\"?");
            quiz86.setAnswer("Bethesda Game Studios");
            quiz86.setOptions(List.of("Square Enix", "Konami", "Capcom", "Bethesda Game Studios"));

            quiz87.setTitle("Какой из перечисленных жанров связан с игрой \"Fortnite\"?");
            quiz87.setAnswer("Королевская битва");
            quiz87.setOptions(List.of("Шутер от первого лица (FPS)", "Приключенческий", "Ролевая игра (RPG)", "Королевская битва"));

            quiz88.setTitle("Какая игра является первой частью серии \"Dark Souls\"?");
            quiz88.setAnswer("Dark Souls");
            quiz88.setOptions(List.of("Dark Souls 2", "Dark Souls 3", "Dark Souls", "Demon's Souls"));

            quiz89.setTitle("Какой разработчик ответственен за серию игр \"Counter-Strike\"?");
            quiz89.setAnswer("Valve Corporation");
            quiz89.setOptions(List.of("Ubisoft", "Activision", "Valve Corporation", "Electronic Arts"));

            quiz90.setTitle("Какой из перечисленных жанров связан с игрой \"World of Warcraft\"?");
            quiz90.setAnswer("Массово многопользовательская онлайн ролевая игра (MMORPG)");
            quiz90.setOptions(List.of("Шутер от первого лица (FPS)", "Стратегия", "Массово многопользовательская онлайн ролевая игра (MMORPG)", "Файтинг"));


            quizService.save(quiz);
            quizService.save(quiz1);
            quizService.save(quiz2);
            quizService.save(quiz3);
            quizService.save(quiz4);
            quizService.save(quiz5);
            quizService.save(quiz6);
            quizService.save(quiz7);
            quizService.save(quiz8);
            quizService.save(quiz9);
            quizService.save(quiz10);
            quizService.save(quiz11);
            quizService.save(quiz12);
            quizService.save(quiz13);
            quizService.save(quiz14);
            quizService.save(quiz15);
            quizService.save(quiz16);
            quizService.save(quiz17);
            quizService.save(quiz18);
            quizService.save(quiz19);
            quizService.save(quiz20);
            quizService.save(quiz21);
            quizService.save(quiz22);
            quizService.save(quiz23);
            quizService.save(quiz24);
            quizService.save(quiz25);
            quizService.save(quiz26);
            quizService.save(quiz27);
            quizService.save(quiz28);
            quizService.save(quiz29);
            quizService.save(quiz30);
            quizService.save(quiz31);
            quizService.save(quiz32);
            quizService.save(quiz33);
            quizService.save(quiz34);
            quizService.save(quiz35);
            quizService.save(quiz36);
            quizService.save(quiz37);
            quizService.save(quiz38);
            quizService.save(quiz39);
            quizService.save(quiz40);
            quizService.save(quiz41);
            quizService.save(quiz42);
            quizService.save(quiz43);
            quizService.save(quiz44);
            quizService.save(quiz45);
            quizService.save(quiz46);
            quizService.save(quiz47);
            quizService.save(quiz48);
            quizService.save(quiz49);
            quizService.save(quiz50);
            quizService.save(quiz51);
            quizService.save(quiz52);
            quizService.save(quiz53);
            quizService.save(quiz54);
            quizService.save(quiz55);
            quizService.save(quiz56);
            quizService.save(quiz57);
            quizService.save(quiz58);
            quizService.save(quiz59);
            quizService.save(quiz60);
            quizService.save(quiz61);
            quizService.save(quiz62);
            quizService.save(quiz63);
            quizService.save(quiz64);
            quizService.save(quiz65);
            quizService.save(quiz66);
            quizService.save(quiz67);
            quizService.save(quiz68);
            quizService.save(quiz69);
            quizService.save(quiz70);
            quizService.save(quiz71);
            quizService.save(quiz72);
            quizService.save(quiz73);
            quizService.save(quiz74);
            quizService.save(quiz75);
            quizService.save(quiz76);
            quizService.save(quiz77);
            quizService.save(quiz78);
            quizService.save(quiz79);
            quizService.save(quiz80);
            quizService.save(quiz81);
            quizService.save(quiz82);
            quizService.save(quiz83);
            quizService.save(quiz84);
            quizService.save(quiz85);
            quizService.save(quiz86);
            quizService.save(quiz87);
            quizService.save(quiz88);
            quizService.save(quiz89);
            quizService.save(quiz90);
        }

    }


}
