package codeforces.com.tasks.entityLockerTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Ad> ads = List.of(
            Ad.valueOf(UUID.randomUUID().toString(), Set.of("поршень недорого")),
            Ad.valueOf(UUID.randomUUID().toString(), Set.of("ремонт смартфонов")),
            Ad.valueOf(UUID.randomUUID().toString(), Set.of("гигантские улитки")),
            Ad.valueOf(UUID.randomUUID().toString(), Set.of("зонтик в горошек")),
            Ad.valueOf(UUID.randomUUID().toString(), Set.of("трактор на воздушной подушке")),
            Ad.valueOf(UUID.randomUUID().toString(), Set.of("агрессивные растения")),
            Ad.valueOf(UUID.randomUUID().toString(), Set.of("ручной енот")),
            Ad.valueOf(UUID.randomUUID().toString(), Set.of("пустой холодильник"))
        );

        final EntityLocker<String> locker = new EntityLocker<>();
        final ExecutorService executor = Executors.newFixedThreadPool(5);
        final AdsRepository adRepository = AdsRepository.getInstance(locker);

        ads.forEach(adRepository::create);

        List<Runnable> tasks = new ArrayList<>();

        ads.stream().forEach( item -> {
                tasks.add(() -> adRepository.addKeyword(item.getId(), "черная пятница"));
                tasks.add(() -> adRepository.addKeyword(item.getId(), "толстые котики"));
            }
        );

        tasks.forEach(executor::submit);
        executor.awaitTermination(5, TimeUnit.SECONDS);

        adRepository.print();
    }
}
