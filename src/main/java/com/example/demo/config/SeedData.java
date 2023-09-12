package com.example.demo.config;

import com.example.demo.models.*;
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

        if (posts.size() == 0) {

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

        if (quizService.getAllQuiz().size() == 0) {


            Quiz quiz1 = new Quiz();
            quiz1.setTitle("Какой разработчик ответственен за серию игр \"Fallout\"?");
            quiz1.setAnswer("Bethesda Game Studios");
            quiz1.setOptions(List.of("Rockstar Games", "Ubisoft", "CD Projekt Red", "Bethesda Game Studios"));
            quiz1.setImageUrl("https://pbs.twimg.com/media/DK7VeG6WkAA-zqx.jpg:large");

            Quiz quiz2 = new Quiz();
            quiz2.setTitle("Какой из перечисленных жанров НЕ связан с игрой \"Overwatch\"?");
            quiz2.setAnswer("Открытый мир");
            quiz2.setOptions(List.of("Шутер от первого лица (FPS)", "Командный соревновательный", "Многопользовательская онлайн боевая аркада (MOBA)", "Открытый мир"));
            quiz2.setImageUrl("https://cdn.exputer.com/wp-content/uploads/2020/09/thumb-1920-564997.jpg");

            Quiz quiz3 = new Quiz();
            quiz3.setTitle("Какой персонаж из списка является главным героем игры \"Uncharted\"?");
            quiz3.setAnswer("Nathan Drake");
            quiz3.setOptions(List.of("Joel", "Nathan Drake", "Master Chief", "Geralt of Rivia"));
            quiz3.setImageUrl("https://cdn.cloudflare.steamstatic.com/steam/apps/1659420/ss_a1816dd536122dd740043c2b9440136503904215.1920x1080.jpg");

            Quiz quiz4 = new Quiz();
            quiz4.setTitle("Какой разработчик ответственен за серию игр \"Assassin's Creed\"?");
            quiz4.setAnswer("Ubisoft");
            quiz4.setOptions(List.of("Rockstar Games", "Ubisoft", "CD Projekt Red", "Bethesda Softworks"));
            quiz4.setImageUrl("https://dotesports.com/wp-content/uploads/2022/03/03060714/AC-x-FF-Key-Art-Leap-of-Faith-scaled.jpg");

            Quiz quiz5 = new Quiz();
            quiz5.setTitle("Какой из перечисленных жанров связан с игрой \"League of Legends\"?");
            quiz5.setAnswer("Многопользовательская онлайн боевая аркада (MOBA)");
            quiz5.setOptions(List.of("Шутер от первого лица (FPS)", "Командный соревновательный", "Ролевая игра (RPG)", "Многопользовательская онлайн боевая аркада (MOBA)"));
            quiz5.setImageUrl("https://guidefall.com/wp-content/uploads/2021/01/league-of-legends-1280x713.jpg");

            Quiz quiz7 = new Quiz();
            quiz7.setTitle("Какой год стал выпуском первой части игры \"Super Mario Bros.\"?");
            quiz7.setAnswer("1985");
            quiz7.setOptions(List.of("1983", "1985", "1987", "1989"));
            quiz7.setImageUrl("https://play.nintendo.com/images/PLAY-4675-SwitchKids2020-download01_2x1_v01.0290fa98.54247e6d.jpg");

            Quiz quiz9 = new Quiz();
            quiz9.setTitle("Какая игра из списка была разработана студией Rockstar Games?");
            quiz9.setAnswer("Grand Theft Auto V");
            quiz9.setOptions(List.of("Grand Theft Auto V", "The Elder Scrolls V: Skyrim", "Mass Effect 2", "Call of Duty: Modern Warfare"));
            quiz9.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQv3QXN1XLpN5KqbYUa0eykJI51EeoLev4psA&usqp=CAU");

            Quiz quiz10 = new Quiz();
            quiz10.setTitle("Какой разработчик ответственен за серию игр \"Halo\"?");
            quiz10.setAnswer("343 Industries");
            quiz10.setOptions(List.of("343 Industries", "Bungie", "Guerrilla Games", "FromSoftware"));
            quiz10.setImageUrl("https://imageio.forbes.com/specials-images/imageserve/5f19b8a2d0f4b6feb38edcc2/0x0.jpg?format=jpg&width=1200");

            Quiz quiz12 = new Quiz();
            quiz12.setTitle("Какой год был началом продаж PlayStation 4?");
            quiz12.setAnswer("2013");
            quiz12.setOptions(List.of("2012", "2013", "2014", "2015"));
            quiz12.setImageUrl("https://media.istockphoto.com/id/687958304/photo/sony-play-station-4-and-dualshock-video-game-console.jpg?s=612x612&w=0&k=20&c=TjYQMjUchhSuoWd9P3z4XE-E_QddhruFMKVq644RmIE=");

            Quiz quiz13 = new Quiz();
            quiz13.setTitle("Какой персонаж из списка является главным героем игры \"God of War (2018)\"?");
            quiz13.setAnswer("Kratos");
            quiz13.setOptions(List.of("Kratos", "Nathan Drake", "Master Chief", "Sam Fisher"));
            quiz13.setImageUrl("https://cdn.wallpapersafari.com/75/10/ZqDQwd.jpg");

            Quiz quiz15 = new Quiz();
            quiz15.setTitle("Какой разработчик ответственен за серию игр \"Final Fantasy\"?");
            quiz15.setAnswer("Square Enix");
            quiz15.setOptions(List.of("Capcom", "Square Enix", "Konami", "Activision"));
            quiz15.setImageUrl("https://cdn.wallpapersafari.com/73/19/WzgjbF.jpg");

            Quiz quiz16 = new Quiz();
            quiz16.setTitle("Какой из перечисленных жанров связан с игрой \"The Sims\"?");
            quiz16.setAnswer("Симулятор жизни");
            quiz16.setOptions(List.of("Стратегия", "Экономическая", "Симулятор жизни", "Гонки"));
            quiz16.setImageUrl("https://nox.uno/wp-content/uploads/2020/05/the-sims-freeplay.jpg");

            Quiz quiz18 = new Quiz();
            quiz18.setTitle("Какой разработчик ответственен за серию игр \"Gears of War\"?");
            quiz18.setAnswer("The Coalition");
            quiz18.setOptions(List.of("Epic Games", "The Coalition", "Respawn Entertainment", "id Software"));
            quiz18.setImageUrl("https://www.gearsofwar.com/static/297e9697d87614d03a085215269429d1/gearsOfWar.jpg");

            Quiz quiz34 = new Quiz();
            quiz34.setTitle("Какая игра из списка была разработана студией Naughty Dog?");
            quiz34.setAnswer("Uncharted 4: A Thief's End");
            quiz34.setOptions(List.of("Uncharted 4: A Thief's End", "The Legend of Zelda: Breath of the Wild", "Horizon Zero Dawn", "God of War (2018)"));
            quiz34.setImageUrl("https://www.gematsu.com/wp-content/uploads/2023/05/Naughty-Dog-Update_05-26-23.jpg");

            Quiz quiz35 = new Quiz();
            quiz35.setTitle("В каком году была выпущена первая часть игры \"Half-Life\"?");
            quiz35.setAnswer("1998");
            quiz35.setOptions(List.of("1996", "1998", "2000", "2002"));
            quiz35.setImageUrl("https://img.wallpapic.com/i1279-139-713/medium/half-life-hiking-wallpaper.jpg");

            Quiz quiz36 = new Quiz();
            quiz36.setTitle("Какой жанр игры \"Destiny 2\" от Bungie?");
            quiz36.setAnswer("Многопользовательская онлайн стрелялка (MMO)");
            quiz36.setOptions(List.of("Шутер от первого лица (FPS)", "Ролевая игра (RPG)", "Многопользовательская онлайн боевая аркада (MOBA)", "Многопользовательская онлайн стрелялка (MMO)"));
            quiz36.setImageUrl("https://image.api.playstation.com/vulcan/ap/rnd/202201/2819/q3BbPZlmvNwPcGokrhds1Qzg.jpg");

            Quiz quiz37 = new Quiz();
            quiz37.setTitle("Какой разработчик ответственен за серию игр \"Resident Evil\"?");
            quiz37.setAnswer("Capcom");
            quiz37.setOptions(List.of("Konami", "Capcom", "2K Games", "Ubisoft"));
            quiz37.setImageUrl("https://www.magneticmag.com/.image/t_share/MTkyMDExMjk4OTAzNTY1NzY3/942590.jpg");

            Quiz quiz41 = new Quiz();
            quiz41.setTitle("Какой разработчик ответственен за серию игр \"Metal Gear Solid\"?");
            quiz41.setAnswer("Konami");
            quiz41.setOptions(List.of("Konami", "Capcom", "Square Enix", "Ubisoft"));
            quiz41.setImageUrl("https://cdn.wallpapersafari.com/53/99/8r6ezc.jpg");

            Quiz quiz43 = new Quiz();
            quiz43.setTitle("Какой год стал выпуском первой части игры \"The Elder Scrolls\"?");
            quiz43.setAnswer("1994");
            quiz43.setOptions(List.of("1992", "1994", "1996", "1998"));
            quiz43.setImageUrl("https://cdn.akamai.steamstatic.com/steam/apps/1812290/capsule_616x353.jpg?t=1650992611");

            Quiz quiz60 = new Quiz();
            quiz60.setTitle("Какой год был началом продаж первой Xbox?");
            quiz60.setAnswer("2001");
            quiz60.setOptions(List.of("2000", "2001", "2002", "2003"));
            quiz60.setImageUrl("https://www.stuff.tv/wp-content/uploads/sites/2/2023/02/Best-Xbox-consoles-ever-lead.jpg");

            Quiz quiz63 = new Quiz();
            quiz63.setTitle("В каком году была выпущена первая часть игры \"Grand Theft Auto\"?");
            quiz63.setAnswer("1997");
            quiz63.setOptions(List.of("1995", "1997", "1999", "2001"));
            quiz63.setImageUrl("https://upload.wikimedia.org/wikipedia/ru/6/6b/GTA_Cover.jpg");

            Quiz quiz67 = new Quiz();
            quiz67.setTitle("Какой разработчик ответственен за серию игр \"Counter-Strike\"?");
            quiz67.setAnswer("Valve Corporation");
            quiz67.setOptions(List.of("Ubisoft", "Activision", "Valve Corporation", "Electronic Arts"));
            quiz67.setImageUrl("https://wallpaperaccess.com/full/1495843.jpg");

            Quiz quiz70 = new Quiz();
            quiz70.setTitle("Какой разработчик ответственен за серию игр \"The Witcher\"?");
            quiz70.setAnswer("CD Projekt Red");
            quiz70.setOptions(List.of("Rockstar Games", "Ubisoft", "CD Projekt Red", "Bethesda Softworks"));
            quiz70.setImageUrl("https://www.thesun.co.uk/wp-content/uploads/2022/11/the-witcher-3.jpg?strip=all&quality=100&w=1920&h=1440&crop=1");

            Quiz quiz83 = new Quiz();
            quiz83.setTitle("Какой персонаж из списка является главным героем игры \"Red Dead Redemption 2\"?");
            quiz83.setAnswer("Arthur Morgan");
            quiz83.setOptions(List.of("Arthur Morgan", "John Marston", "Dutch van der Linde", "Micah Bell"));
            quiz83.setImageUrl("https://static0.gamerantimages.com/wordpress/wp-content/uploads/red-dead-redemption-2-free-ps4-theme.jpg");


            quizService.save(quiz1);
            quizService.save(quiz2);
            quizService.save(quiz3);
            quizService.save(quiz4);
            quizService.save(quiz5);
            quizService.save(quiz7);
            quizService.save(quiz9);
            quizService.save(quiz10);
            quizService.save(quiz12);
            quizService.save(quiz13);
            quizService.save(quiz15);
            quizService.save(quiz16);
            quizService.save(quiz18);
            quizService.save(quiz34);
            quizService.save(quiz35);
            quizService.save(quiz36);
            quizService.save(quiz37);
            quizService.save(quiz41);
            quizService.save(quiz43);
            quizService.save(quiz60);
            quizService.save(quiz63);
            quizService.save(quiz67);
            quizService.save(quiz70);
            quizService.save(quiz83);
        }

    }


}
